package com.entity.vo;

import com.entity.HuajiarenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 划价人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huajiarenyuan")
public class HuajiarenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 划价人员姓名
     */

    @TableField(value = "huajiarenyuan_name")
    private String huajiarenyuanName;


    /**
     * 划价人员手机号
     */

    @TableField(value = "huajiarenyuan_phone")
    private String huajiarenyuanPhone;


    /**
     * 划价人员身份证号
     */

    @TableField(value = "huajiarenyuan_id_number")
    private String huajiarenyuanIdNumber;


    /**
     * 划价人员头像
     */

    @TableField(value = "huajiarenyuan_photo")
    private String huajiarenyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：划价人员姓名
	 */
    public String getHuajiarenyuanName() {
        return huajiarenyuanName;
    }


    /**
	 * 获取：划价人员姓名
	 */

    public void setHuajiarenyuanName(String huajiarenyuanName) {
        this.huajiarenyuanName = huajiarenyuanName;
    }
    /**
	 * 设置：划价人员手机号
	 */
    public String getHuajiarenyuanPhone() {
        return huajiarenyuanPhone;
    }


    /**
	 * 获取：划价人员手机号
	 */

    public void setHuajiarenyuanPhone(String huajiarenyuanPhone) {
        this.huajiarenyuanPhone = huajiarenyuanPhone;
    }
    /**
	 * 设置：划价人员身份证号
	 */
    public String getHuajiarenyuanIdNumber() {
        return huajiarenyuanIdNumber;
    }


    /**
	 * 获取：划价人员身份证号
	 */

    public void setHuajiarenyuanIdNumber(String huajiarenyuanIdNumber) {
        this.huajiarenyuanIdNumber = huajiarenyuanIdNumber;
    }
    /**
	 * 设置：划价人员头像
	 */
    public String getHuajiarenyuanPhoto() {
        return huajiarenyuanPhoto;
    }


    /**
	 * 获取：划价人员头像
	 */

    public void setHuajiarenyuanPhoto(String huajiarenyuanPhoto) {
        this.huajiarenyuanPhoto = huajiarenyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
