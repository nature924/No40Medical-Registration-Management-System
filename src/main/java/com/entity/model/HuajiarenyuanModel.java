package com.entity.model;

import com.entity.HuajiarenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 划价人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuajiarenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 划价人员姓名
     */
    private String huajiarenyuanName;


    /**
     * 划价人员手机号
     */
    private String huajiarenyuanPhone;


    /**
     * 划价人员身份证号
     */
    private String huajiarenyuanIdNumber;


    /**
     * 划价人员头像
     */
    private String huajiarenyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：划价人员姓名
	 */
    public String getHuajiarenyuanName() {
        return huajiarenyuanName;
    }


    /**
	 * 设置：划价人员姓名
	 */
    public void setHuajiarenyuanName(String huajiarenyuanName) {
        this.huajiarenyuanName = huajiarenyuanName;
    }
    /**
	 * 获取：划价人员手机号
	 */
    public String getHuajiarenyuanPhone() {
        return huajiarenyuanPhone;
    }


    /**
	 * 设置：划价人员手机号
	 */
    public void setHuajiarenyuanPhone(String huajiarenyuanPhone) {
        this.huajiarenyuanPhone = huajiarenyuanPhone;
    }
    /**
	 * 获取：划价人员身份证号
	 */
    public String getHuajiarenyuanIdNumber() {
        return huajiarenyuanIdNumber;
    }


    /**
	 * 设置：划价人员身份证号
	 */
    public void setHuajiarenyuanIdNumber(String huajiarenyuanIdNumber) {
        this.huajiarenyuanIdNumber = huajiarenyuanIdNumber;
    }
    /**
	 * 获取：划价人员头像
	 */
    public String getHuajiarenyuanPhoto() {
        return huajiarenyuanPhoto;
    }


    /**
	 * 设置：划价人员头像
	 */
    public void setHuajiarenyuanPhoto(String huajiarenyuanPhoto) {
        this.huajiarenyuanPhoto = huajiarenyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
