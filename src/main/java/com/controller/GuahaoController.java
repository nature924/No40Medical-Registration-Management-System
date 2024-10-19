
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 挂号
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/guahao")
public class GuahaoController {
    private static final Logger logger = LoggerFactory.getLogger(GuahaoController.class);

    @Autowired
    private GuahaoService guahaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private GuahaorenyuanService guahaorenyuanService;
    @Autowired
    private HuanzheService huanzheService;
    @Autowired
    private YishengService yishengService;

    @Autowired
    private HuajiarenyuanService huajiarenyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        else if("划价人员".equals(role))
            params.put("huajiarenyuanId",request.getSession().getAttribute("userId"));
        else if("挂号人员".equals(role))
            params.put("guahaorenyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = guahaoService.queryPage(params);

        //字典表数据转换
        List<GuahaoView> list =(List<GuahaoView>)page.getList();
        for(GuahaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GuahaoEntity guahao = guahaoService.selectById(id);
        if(guahao !=null){
            //entity转view
            GuahaoView view = new GuahaoView();
            BeanUtils.copyProperties( guahao , view );//把实体数据重构到view中

                //级联表
                GuahaorenyuanEntity guahaorenyuan = guahaorenyuanService.selectById(guahao.getGuahaorenyuanId());
                if(guahaorenyuan != null){
                    BeanUtils.copyProperties( guahaorenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGuahaorenyuanId(guahaorenyuan.getId());
                }
                //级联表
                HuanzheEntity huanzhe = huanzheService.selectById(guahao.getHuanzheId());
                if(huanzhe != null){
                    BeanUtils.copyProperties( huanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuanzheId(huanzhe.getId());
                }
                //级联表
                YishengEntity yisheng = yishengService.selectById(guahao.getYishengId());
                if(yisheng != null){
                    BeanUtils.copyProperties( yisheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYishengId(yisheng.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GuahaoEntity guahao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,guahao:{}",this.getClass().getName(),guahao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("挂号人员".equals(role))
            guahao.setGuahaorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("医生".equals(role))
            guahao.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<GuahaoEntity> queryWrapper = new EntityWrapper<GuahaoEntity>()
            .eq("huanzhe_id", guahao.getHuanzheId())
            .eq("guahaorenyuan_id", guahao.getGuahaorenyuanId())
            .eq("yisheng_id", guahao.getYishengId())
            .eq("guahao_uuid_number", guahao.getGuahaoUuidNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuahaoEntity guahaoEntity = guahaoService.selectOne(queryWrapper);
        if(guahaoEntity==null){
            guahao.setInsertTime(new Date());
            guahao.setCreateTime(new Date());
            guahaoService.insert(guahao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GuahaoEntity guahao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,guahao:{}",this.getClass().getName(),guahao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("挂号人员".equals(role))
//            guahao.setGuahaorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("医生".equals(role))
//            guahao.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<GuahaoEntity> queryWrapper = new EntityWrapper<GuahaoEntity>()
            .notIn("id",guahao.getId())
            .andNew()
            .eq("huanzhe_id", guahao.getHuanzheId())
            .eq("guahaorenyuan_id", guahao.getGuahaorenyuanId())
            .eq("yisheng_id", guahao.getYishengId())
            .eq("guahao_uuid_number", guahao.getGuahaoUuidNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuahaoEntity guahaoEntity = guahaoService.selectOne(queryWrapper);
        if(guahaoEntity==null){
            guahaoService.updateById(guahao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        guahaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<GuahaoEntity> guahaoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            GuahaoEntity guahaoEntity = new GuahaoEntity();
//                            guahaoEntity.setHuanzheId(Integer.valueOf(data.get(0)));   //患者 要改的
//                            guahaoEntity.setGuahaorenyuanId(Integer.valueOf(data.get(0)));   //挂号人员 要改的
//                            guahaoEntity.setYishengId(Integer.valueOf(data.get(0)));   //医生 要改的
//                            guahaoEntity.setGuahaoUuidNumber(data.get(0));                    //号 要改的
//                            guahaoEntity.setInsertTime(date);//时间
//                            guahaoEntity.setCreateTime(date);//时间
                            guahaoList.add(guahaoEntity);


                            //把要查询是否重复的字段放入map中
                                //号
                                if(seachFields.containsKey("guahaoUuidNumber")){
                                    List<String> guahaoUuidNumber = seachFields.get("guahaoUuidNumber");
                                    guahaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> guahaoUuidNumber = new ArrayList<>();
                                    guahaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("guahaoUuidNumber",guahaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //号
                        List<GuahaoEntity> guahaoEntities_guahaoUuidNumber = guahaoService.selectList(new EntityWrapper<GuahaoEntity>().in("guahao_uuid_number", seachFields.get("guahaoUuidNumber")));
                        if(guahaoEntities_guahaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GuahaoEntity s:guahaoEntities_guahaoUuidNumber){
                                repeatFields.add(s.getGuahaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        guahaoService.insertBatch(guahaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
