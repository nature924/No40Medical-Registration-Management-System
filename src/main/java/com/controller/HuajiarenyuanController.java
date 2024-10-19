
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
 * 划价人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huajiarenyuan")
public class HuajiarenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(HuajiarenyuanController.class);

    @Autowired
    private HuajiarenyuanService huajiarenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YishengService yishengService;
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
        PageUtils page = huajiarenyuanService.queryPage(params);

        //字典表数据转换
        List<HuajiarenyuanView> list =(List<HuajiarenyuanView>)page.getList();
        for(HuajiarenyuanView c:list){
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
        HuajiarenyuanEntity huajiarenyuan = huajiarenyuanService.selectById(id);
        if(huajiarenyuan !=null){
            //entity转view
            HuajiarenyuanView view = new HuajiarenyuanView();
            BeanUtils.copyProperties( huajiarenyuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody HuajiarenyuanEntity huajiarenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huajiarenyuan:{}",this.getClass().getName(),huajiarenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HuajiarenyuanEntity> queryWrapper = new EntityWrapper<HuajiarenyuanEntity>()
            .eq("username", huajiarenyuan.getUsername())
            .or()
            .eq("huajiarenyuan_phone", huajiarenyuan.getHuajiarenyuanPhone())
            .or()
            .eq("huajiarenyuan_id_number", huajiarenyuan.getHuajiarenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuajiarenyuanEntity huajiarenyuanEntity = huajiarenyuanService.selectOne(queryWrapper);
        if(huajiarenyuanEntity==null){
            huajiarenyuan.setCreateTime(new Date());
            huajiarenyuan.setPassword("123456");
            huajiarenyuanService.insert(huajiarenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者划价人员手机号或者划价人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuajiarenyuanEntity huajiarenyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huajiarenyuan:{}",this.getClass().getName(),huajiarenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HuajiarenyuanEntity> queryWrapper = new EntityWrapper<HuajiarenyuanEntity>()
            .notIn("id",huajiarenyuan.getId())
            .andNew()
            .eq("username", huajiarenyuan.getUsername())
            .or()
            .eq("huajiarenyuan_phone", huajiarenyuan.getHuajiarenyuanPhone())
            .or()
            .eq("huajiarenyuan_id_number", huajiarenyuan.getHuajiarenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuajiarenyuanEntity huajiarenyuanEntity = huajiarenyuanService.selectOne(queryWrapper);
        if("".equals(huajiarenyuan.getHuajiarenyuanPhoto()) || "null".equals(huajiarenyuan.getHuajiarenyuanPhoto())){
                huajiarenyuan.setHuajiarenyuanPhoto(null);
        }
        if(huajiarenyuanEntity==null){
            huajiarenyuanService.updateById(huajiarenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者划价人员手机号或者划价人员身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        huajiarenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<HuajiarenyuanEntity> huajiarenyuanList = new ArrayList<>();//上传的东西
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
                            HuajiarenyuanEntity huajiarenyuanEntity = new HuajiarenyuanEntity();
//                            huajiarenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //huajiarenyuanEntity.setPassword("123456");//密码
//                            huajiarenyuanEntity.setHuajiarenyuanName(data.get(0));                    //划价人员姓名 要改的
//                            huajiarenyuanEntity.setHuajiarenyuanPhone(data.get(0));                    //划价人员手机号 要改的
//                            huajiarenyuanEntity.setHuajiarenyuanIdNumber(data.get(0));                    //划价人员身份证号 要改的
//                            huajiarenyuanEntity.setHuajiarenyuanPhoto("");//照片
//                            huajiarenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            huajiarenyuanEntity.setCreateTime(date);//时间
                            huajiarenyuanList.add(huajiarenyuanEntity);


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
                                //划价人员手机号
                                if(seachFields.containsKey("huajiarenyuanPhone")){
                                    List<String> huajiarenyuanPhone = seachFields.get("huajiarenyuanPhone");
                                    huajiarenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> huajiarenyuanPhone = new ArrayList<>();
                                    huajiarenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("huajiarenyuanPhone",huajiarenyuanPhone);
                                }
                                //划价人员身份证号
                                if(seachFields.containsKey("huajiarenyuanIdNumber")){
                                    List<String> huajiarenyuanIdNumber = seachFields.get("huajiarenyuanIdNumber");
                                    huajiarenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huajiarenyuanIdNumber = new ArrayList<>();
                                    huajiarenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("huajiarenyuanIdNumber",huajiarenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<HuajiarenyuanEntity> huajiarenyuanEntities_username = huajiarenyuanService.selectList(new EntityWrapper<HuajiarenyuanEntity>().in("username", seachFields.get("username")));
                        if(huajiarenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuajiarenyuanEntity s:huajiarenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //划价人员手机号
                        List<HuajiarenyuanEntity> huajiarenyuanEntities_huajiarenyuanPhone = huajiarenyuanService.selectList(new EntityWrapper<HuajiarenyuanEntity>().in("huajiarenyuan_phone", seachFields.get("huajiarenyuanPhone")));
                        if(huajiarenyuanEntities_huajiarenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuajiarenyuanEntity s:huajiarenyuanEntities_huajiarenyuanPhone){
                                repeatFields.add(s.getHuajiarenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [划价人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //划价人员身份证号
                        List<HuajiarenyuanEntity> huajiarenyuanEntities_huajiarenyuanIdNumber = huajiarenyuanService.selectList(new EntityWrapper<HuajiarenyuanEntity>().in("huajiarenyuan_id_number", seachFields.get("huajiarenyuanIdNumber")));
                        if(huajiarenyuanEntities_huajiarenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuajiarenyuanEntity s:huajiarenyuanEntities_huajiarenyuanIdNumber){
                                repeatFields.add(s.getHuajiarenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [划价人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huajiarenyuanService.insertBatch(huajiarenyuanList);
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
        HuajiarenyuanEntity huajiarenyuan = huajiarenyuanService.selectOne(new EntityWrapper<HuajiarenyuanEntity>().eq("username", username));
        if(huajiarenyuan==null || !huajiarenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(huajiarenyuan.getId(),username, "huajiarenyuan", "划价人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","划价人员");
        r.put("username",huajiarenyuan.getHuajiarenyuanName());
        r.put("tableName","huajiarenyuan");
        r.put("userId",huajiarenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody HuajiarenyuanEntity huajiarenyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<HuajiarenyuanEntity> queryWrapper = new EntityWrapper<HuajiarenyuanEntity>()
            .eq("username", huajiarenyuan.getUsername())
            .or()
            .eq("huajiarenyuan_phone", huajiarenyuan.getHuajiarenyuanPhone())
            .or()
            .eq("huajiarenyuan_id_number", huajiarenyuan.getHuajiarenyuanIdNumber())
            ;
        HuajiarenyuanEntity huajiarenyuanEntity = huajiarenyuanService.selectOne(queryWrapper);
        if(huajiarenyuanEntity != null)
            return R.error("账户或者划价人员手机号或者划价人员身份证号已经被使用");
        huajiarenyuan.setCreateTime(new Date());
        huajiarenyuanService.insert(huajiarenyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        HuajiarenyuanEntity huajiarenyuan = new HuajiarenyuanEntity();
        huajiarenyuan.setPassword("123456");
        huajiarenyuan.setId(id);
        huajiarenyuanService.updateById(huajiarenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        HuajiarenyuanEntity huajiarenyuan = huajiarenyuanService.selectOne(new EntityWrapper<HuajiarenyuanEntity>().eq("username", username));
        if(huajiarenyuan!=null){
            huajiarenyuan.setPassword("123456");
            boolean b = huajiarenyuanService.updateById(huajiarenyuan);
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
    public R getCurrHuajiarenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        HuajiarenyuanEntity huajiarenyuan = huajiarenyuanService.selectById(id);
        if(huajiarenyuan !=null){
            //entity转view
            HuajiarenyuanView view = new HuajiarenyuanView();
            BeanUtils.copyProperties( huajiarenyuan , view );//把实体数据重构到view中

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
