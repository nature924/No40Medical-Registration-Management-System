package com.entity.model;

import com.entity.GuahaorenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 挂号人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GuahaorenyuanModel implements Serializable {
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
     * 挂号人员姓名
     */
    private String guahaorenyuanName;


    /**
     * 挂号人员手机号
     */
    private String guahaorenyuanPhone;


    /**
     * 挂号人员身份证号
     */
    private String guahaorenyuanIdNumber;


    /**
     * 挂号人员头像
     */
    private String guahaorenyuanPhoto;


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
	 * 获取：挂号人员姓名
	 */
    public String getGuahaorenyuanName() {
        return guahaorenyuanName;
    }


    /**
	 * 设置：挂号人员姓名
	 */
    public void setGuahaorenyuanName(String guahaorenyuanName) {
        this.guahaorenyuanName = guahaorenyuanName;
    }
    /**
	 * 获取：挂号人员手机号
	 */
    public String getGuahaorenyuanPhone() {
        return guahaorenyuanPhone;
    }


    /**
	 * 设置：挂号人员手机号
	 */
    public void setGuahaorenyuanPhone(String guahaorenyuanPhone) {
        this.guahaorenyuanPhone = guahaorenyuanPhone;
    }
    /**
	 * 获取：挂号人员身份证号
	 */
    public String getGuahaorenyuanIdNumber() {
        return guahaorenyuanIdNumber;
    }


    /**
	 * 设置：挂号人员身份证号
	 */
    public void setGuahaorenyuanIdNumber(String guahaorenyuanIdNumber) {
        this.guahaorenyuanIdNumber = guahaorenyuanIdNumber;
    }
    /**
	 * 获取：挂号人员头像
	 */
    public String getGuahaorenyuanPhoto() {
        return guahaorenyuanPhoto;
    }


    /**
	 * 设置：挂号人员头像
	 */
    public void setGuahaorenyuanPhoto(String guahaorenyuanPhoto) {
        this.guahaorenyuanPhoto = guahaorenyuanPhoto;
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
