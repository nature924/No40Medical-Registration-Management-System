package com.entity.model;

import com.entity.HuanzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 患者
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuanzheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 患者姓名
     */
    private String huanzheName;


    /**
     * 患者手机号
     */
    private String huanzhePhone;


    /**
     * 患者身份证号
     */
    private String huanzheIdNumber;


    /**
     * 患者头像
     */
    private String huanzhePhoto;


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
	 * 获取：患者姓名
	 */
    public String getHuanzheName() {
        return huanzheName;
    }


    /**
	 * 设置：患者姓名
	 */
    public void setHuanzheName(String huanzheName) {
        this.huanzheName = huanzheName;
    }
    /**
	 * 获取：患者手机号
	 */
    public String getHuanzhePhone() {
        return huanzhePhone;
    }


    /**
	 * 设置：患者手机号
	 */
    public void setHuanzhePhone(String huanzhePhone) {
        this.huanzhePhone = huanzhePhone;
    }
    /**
	 * 获取：患者身份证号
	 */
    public String getHuanzheIdNumber() {
        return huanzheIdNumber;
    }


    /**
	 * 设置：患者身份证号
	 */
    public void setHuanzheIdNumber(String huanzheIdNumber) {
        this.huanzheIdNumber = huanzheIdNumber;
    }
    /**
	 * 获取：患者头像
	 */
    public String getHuanzhePhoto() {
        return huanzhePhoto;
    }


    /**
	 * 设置：患者头像
	 */
    public void setHuanzhePhoto(String huanzhePhoto) {
        this.huanzhePhoto = huanzhePhoto;
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
