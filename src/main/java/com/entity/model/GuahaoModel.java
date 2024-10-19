package com.entity.model;

import com.entity.GuahaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 挂号
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GuahaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 患者
     */
    private Integer huanzheId;


    /**
     * 挂号人员
     */
    private Integer guahaorenyuanId;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 号
     */
    private String guahaoUuidNumber;


    /**
     * 挂号时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：患者
	 */
    public Integer getHuanzheId() {
        return huanzheId;
    }


    /**
	 * 设置：患者
	 */
    public void setHuanzheId(Integer huanzheId) {
        this.huanzheId = huanzheId;
    }
    /**
	 * 获取：挂号人员
	 */
    public Integer getGuahaorenyuanId() {
        return guahaorenyuanId;
    }


    /**
	 * 设置：挂号人员
	 */
    public void setGuahaorenyuanId(Integer guahaorenyuanId) {
        this.guahaorenyuanId = guahaorenyuanId;
    }
    /**
	 * 获取：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 设置：医生
	 */
    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 获取：号
	 */
    public String getGuahaoUuidNumber() {
        return guahaoUuidNumber;
    }


    /**
	 * 设置：号
	 */
    public void setGuahaoUuidNumber(String guahaoUuidNumber) {
        this.guahaoUuidNumber = guahaoUuidNumber;
    }
    /**
	 * 获取：挂号时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：挂号时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
