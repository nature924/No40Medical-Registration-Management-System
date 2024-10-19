
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
 * 挂号人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/guahaorenyuan")
public class GuahaorenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(GuahaorenyuanController.class);

    @Autowired
    private GuahaorenyuanService guahaorenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

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
        PageUtils page = guahaorenyuanService.queryPage(params);

        //字典表数据转换
        List<GuahaorenyuanView> list =(List<GuahaorenyuanView>)page.getList();
        for(GuahaorenyuanView c:list){
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
        GuahaorenyuanEntity guahaorenyuan = guahaorenyuanService.selectById(id);
        if(guahaorenyuan !=null){
            //entity转view
            GuahaorenyuanView view = new GuahaorenyuanView();
            BeanUtils.copyProperties( guahaorenyuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody GuahaorenyuanEntity guahaorenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,guahaorenyuan:{}",this.getClass().getName(),guahaorenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GuahaorenyuanEntity> queryWrapper = new EntityWrapper<GuahaorenyuanEntity>()
            .eq("username", guahaorenyuan.getUsername())
            .or()
            .eq("guahaorenyuan_phone", guahaorenyuan.getGuahaorenyuanPhone())
            .or()
            .eq("guahaorenyuan_id_number", guahaorenyuan.getGuahaorenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuahaorenyuanEntity guahaorenyuanEntity = guahaorenyuanService.selectOne(queryWrapper);
        if(guahaorenyuanEntity==null){
            guahaorenyuan.setCreateTime(new Date());
            guahaorenyuan.setPassword("123456");
            guahaorenyuanService.insert(guahaorenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者挂号人员手机号或者挂号人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GuahaorenyuanEntity guahaorenyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,guahaorenyuan:{}",this.getClass().getName(),guahaorenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<GuahaorenyuanEntity> queryWrapper = new EntityWrapper<GuahaorenyuanEntity>()
            .notIn("id",guahaorenyuan.getId())
            .andNew()
            .eq("username", guahaorenyuan.getUsername())
            .or()
            .eq("guahaorenyuan_phone", guahaorenyuan.getGuahaorenyuanPhone())
            .or()
            .eq("guahaorenyuan_id_number", guahaorenyuan.getGuahaorenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GuahaorenyuanEntity guahaorenyuanEntity = guahaorenyuanService.selectOne(queryWrapper);
        if("".equals(guahaorenyuan.getGuahaorenyuanPhoto()) || "null".equals(guahaorenyuan.getGuahaorenyuanPhoto())){
                guahaorenyuan.setGuahaorenyuanPhoto(null);
        }
        if(guahaorenyuanEntity==null){
            guahaorenyuanService.updateById(guahaorenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者挂号人员手机号或者挂号人员身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        guahaorenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<GuahaorenyuanEntity> guahaorenyuanList = new ArrayList<>();//上传的东西
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
                            GuahaorenyuanEntity guahaorenyuanEntity = new GuahaorenyuanEntity();
//                            guahaorenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //guahaorenyuanEntity.setPassword("123456");//密码
//                            guahaorenyuanEntity.setGuahaorenyuanName(data.get(0));                    //挂号人员姓名 要改的
//                            guahaorenyuanEntity.setGuahaorenyuanPhone(data.get(0));                    //挂号人员手机号 要改的
//                            guahaorenyuanEntity.setGuahaorenyuanIdNumber(data.get(0));                    //挂号人员身份证号 要改的
//                            guahaorenyuanEntity.setGuahaorenyuanPhoto("");//照片
//                            guahaorenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            guahaorenyuanEntity.setCreateTime(date);//时间
                            guahaorenyuanList.add(guahaorenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //挂号人员手机号
                                if(seachFields.containsKey("guahaorenyuanPhone")){
                                    List<String> guahaorenyuanPhone = seachFields.get("guahaorenyuanPhone");
                                    guahaorenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> guahaorenyuanPhone = new ArrayList<>();
                                    guahaorenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("guahaorenyuanPhone",guahaorenyuanPhone);
                                }
                                //挂号人员身份证号
                                if(seachFields.containsKey("guahaorenyuanIdNumber")){
                                    List<String> guahaorenyuanIdNumber = seachFields.get("guahaorenyuanIdNumber");
                                    guahaorenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> guahaorenyuanIdNumber = new ArrayList<>();
                                    guahaorenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("guahaorenyuanIdNumber",guahaorenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<GuahaorenyuanEntity> guahaorenyuanEntities_username = guahaorenyuanService.selectList(new EntityWrapper<GuahaorenyuanEntity>().in("username", seachFields.get("username")));
                        if(guahaorenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GuahaorenyuanEntity s:guahaorenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //挂号人员手机号
                        List<GuahaorenyuanEntity> guahaorenyuanEntities_guahaorenyuanPhone = guahaorenyuanService.selectList(new EntityWrapper<GuahaorenyuanEntity>().in("guahaorenyuan_phone", seachFields.get("guahaorenyuanPhone")));
                        if(guahaorenyuanEntities_guahaorenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GuahaorenyuanEntity s:guahaorenyuanEntities_guahaorenyuanPhone){
                                repeatFields.add(s.getGuahaorenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [挂号人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //挂号人员身份证号
                        List<GuahaorenyuanEntity> guahaorenyuanEntities_guahaorenyuanIdNumber = guahaorenyuanService.selectList(new EntityWrapper<GuahaorenyuanEntity>().in("guahaorenyuan_id_number", seachFields.get("guahaorenyuanIdNumber")));
                        if(guahaorenyuanEntities_guahaorenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GuahaorenyuanEntity s:guahaorenyuanEntities_guahaorenyuanIdNumber){
                                repeatFields.add(s.getGuahaorenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [挂号人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        guahaorenyuanService.insertBatch(guahaorenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        GuahaorenyuanEntity guahaorenyuan = guahaorenyuanService.selectOne(new EntityWrapper<GuahaorenyuanEntity>().eq("username", username));
        if(guahaorenyuan==null || !guahaorenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(guahaorenyuan.getId(),username, "guahaorenyuan", "挂号人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","挂号人员");
        r.put("username",guahaorenyuan.getGuahaorenyuanName());
        r.put("tableName","guahaorenyuan");
        r.put("userId",guahaorenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody GuahaorenyuanEntity guahaorenyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<GuahaorenyuanEntity> queryWrapper = new EntityWrapper<GuahaorenyuanEntity>()
            .eq("username", guahaorenyuan.getUsername())
            .or()
            .eq("guahaorenyuan_phone", guahaorenyuan.getGuahaorenyuanPhone())
            .or()
            .eq("guahaorenyuan_id_number", guahaorenyuan.getGuahaorenyuanIdNumber())
            ;
        GuahaorenyuanEntity guahaorenyuanEntity = guahaorenyuanService.selectOne(queryWrapper);
        if(guahaorenyuanEntity != null)
            return R.error("账户或者挂号人员手机号或者挂号人员身份证号已经被使用");
        guahaorenyuan.setCreateTime(new Date());
        guahaorenyuanService.insert(guahaorenyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        GuahaorenyuanEntity guahaorenyuan = new GuahaorenyuanEntity();
        guahaorenyuan.setPassword("123456");
        guahaorenyuan.setId(id);
        guahaorenyuanService.updateById(guahaorenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        GuahaorenyuanEntity guahaorenyuan = guahaorenyuanService.selectOne(new EntityWrapper<GuahaorenyuanEntity>().eq("username", username));
        if(guahaorenyuan!=null){
            guahaorenyuan.setPassword("123456");
            boolean b = guahaorenyuanService.updateById(guahaorenyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrGuahaorenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        GuahaorenyuanEntity guahaorenyuan = guahaorenyuanService.selectById(id);
        if(guahaorenyuan !=null){
            //entity转view
            GuahaorenyuanView view = new GuahaorenyuanView();
            BeanUtils.copyProperties( guahaorenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
