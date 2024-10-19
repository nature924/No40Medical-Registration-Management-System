
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
 * 体检
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tijian")
public class TijianController {
    private static final Logger logger = LoggerFactory.getLogger(TijianController.class);

    @Autowired
    private TijianService tijianService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private HuanzheService huanzheService;
    @Autowired
    private YishengService yishengService;

    @Autowired
    private HuajiarenyuanService huajiarenyuanService;
    @Autowired
    private GuahaorenyuanService guahaorenyuanService;


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
        PageUtils page = tijianService.queryPage(params);

        //字典表数据转换
        List<TijianView> list =(List<TijianView>)page.getList();
        for(TijianView c:list){
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
        TijianEntity tijian = tijianService.selectById(id);
        if(tijian !=null){
            //entity转view
            TijianView view = new TijianView();
            BeanUtils.copyProperties( tijian , view );//把实体数据重构到view中

                //级联表
                HuanzheEntity huanzhe = huanzheService.selectById(tijian.getHuanzheId());
                if(huanzhe != null){
                    BeanUtils.copyProperties( huanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuanzheId(huanzhe.getId());
                }
                //级联表
                YishengEntity yisheng = yishengService.selectById(tijian.getYishengId());
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
    public R save(@RequestBody TijianEntity tijian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tijian:{}",this.getClass().getName(),tijian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("医生".equals(role))
            tijian.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<TijianEntity> queryWrapper = new EntityWrapper<TijianEntity>()
            .eq("yisheng_id", tijian.getYishengId())
            .eq("huanzhe_id", tijian.getHuanzheId())
            .eq("tijian_uuid_number", tijian.getTijianUuidNumber())
            .eq("tizhong", tijian.getTizhong())
            .eq("shengao", tijian.getShengao())
            .eq("zuoyandushu", tijian.getZuoyandushu())
            .eq("youyandushu", tijian.getYouyandushu())
            .eq("xinlv", tijian.getXinlv())
            .eq("xinyin", tijian.getXinyin())
            .eq("feibutingzhen", tijian.getFeibutingzhen())
            .eq("ganzangtingzhen", tijian.getGanzangtingzhen())
            .eq("xuechanggui_text", tijian.getXuechangguiText())
            .eq("niaochanggui_text", tijian.getNiaochangguiText())
            .eq("qita_text", tijian.getQitaText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianEntity tijianEntity = tijianService.selectOne(queryWrapper);
        if(tijianEntity==null){
            tijian.setInsertTime(new Date());
            tijian.setCreateTime(new Date());
            tijianService.insert(tijian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TijianEntity tijian, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tijian:{}",this.getClass().getName(),tijian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("医生".equals(role))
//            tijian.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<TijianEntity> queryWrapper = new EntityWrapper<TijianEntity>()
            .notIn("id",tijian.getId())
            .andNew()
            .eq("yisheng_id", tijian.getYishengId())
            .eq("huanzhe_id", tijian.getHuanzheId())
            .eq("tijian_uuid_number", tijian.getTijianUuidNumber())
            .eq("tizhong", tijian.getTizhong())
            .eq("shengao", tijian.getShengao())
            .eq("zuoyandushu", tijian.getZuoyandushu())
            .eq("youyandushu", tijian.getYouyandushu())
            .eq("xinlv", tijian.getXinlv())
            .eq("xinyin", tijian.getXinyin())
            .eq("feibutingzhen", tijian.getFeibutingzhen())
            .eq("ganzangtingzhen", tijian.getGanzangtingzhen())
            .eq("xuechanggui_text", tijian.getXuechangguiText())
            .eq("niaochanggui_text", tijian.getNiaochangguiText())
            .eq("qita_text", tijian.getQitaText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianEntity tijianEntity = tijianService.selectOne(queryWrapper);
        if(tijianEntity==null){
            tijianService.updateById(tijian);//根据id更新
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
        tijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<TijianEntity> tijianList = new ArrayList<>();//上传的东西
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
                            TijianEntity tijianEntity = new TijianEntity();
//                            tijianEntity.setYishengId(Integer.valueOf(data.get(0)));   //医生 要改的
//                            tijianEntity.setHuanzheId(Integer.valueOf(data.get(0)));   //患者 要改的
//                            tijianEntity.setTijianUuidNumber(data.get(0));                    //体检编号 要改的
//                            tijianEntity.setTizhong(data.get(0));                    //体重 要改的
//                            tijianEntity.setShengao(data.get(0));                    //身高 要改的
//                            tijianEntity.setZuoyandushu(data.get(0));                    //左眼度数 要改的
//                            tijianEntity.setYouyandushu(data.get(0));                    //右眼度数 要改的
//                            tijianEntity.setXinlv(data.get(0));                    //心率 要改的
//                            tijianEntity.setXinyin(data.get(0));                    //心音 要改的
//                            tijianEntity.setFeibutingzhen(data.get(0));                    //肺部听诊 要改的
//                            tijianEntity.setGanzangtingzhen(data.get(0));                    //肝脏听诊 要改的
//                            tijianEntity.setXuechangguiText(data.get(0));                    //血常规详情 要改的
//                            tijianEntity.setNiaochangguiText(data.get(0));                    //尿常规详情 要改的
//                            tijianEntity.setQitaText(data.get(0));                    //其他详情 要改的
//                            tijianEntity.setInsertTime(date);//时间
//                            tijianEntity.setCreateTime(date);//时间
                            tijianList.add(tijianEntity);


                            //把要查询是否重复的字段放入map中
                                //体检编号
                                if(seachFields.containsKey("tijianUuidNumber")){
                                    List<String> tijianUuidNumber = seachFields.get("tijianUuidNumber");
                                    tijianUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tijianUuidNumber = new ArrayList<>();
                                    tijianUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("tijianUuidNumber",tijianUuidNumber);
                                }
                        }

                        //查询是否重复
                         //体检编号
                        List<TijianEntity> tijianEntities_tijianUuidNumber = tijianService.selectList(new EntityWrapper<TijianEntity>().in("tijian_uuid_number", seachFields.get("tijianUuidNumber")));
                        if(tijianEntities_tijianUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TijianEntity s:tijianEntities_tijianUuidNumber){
                                repeatFields.add(s.getTijianUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [体检编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tijianService.insertBatch(tijianList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
