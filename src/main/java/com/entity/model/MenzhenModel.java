package com.entity.model;

import com.entity.MenzhenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 门诊
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MenzhenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 门诊名称
     */
    private String menzhenName;


    /**
     * 门诊位置
     */
    private String menzhenAddress;


    /**
     * 星期几坐诊
     */
    private String xingqiji;


    /**
     * 门诊详情
     */
    private String qitaContent;


    /**
     * 添加详情
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
	 * 获取：门诊名称
	 */
    public String getMenzhenName() {
        return menzhenName;
    }


    /**
	 * 设置：门诊名称
	 */
    public void setMenzhenName(String menzhenName) {
        this.menzhenName = menzhenName;
    }
    /**
	 * 获取：门诊位置
	 */
    public String getMenzhenAddress() {
        return menzhenAddress;
    }


    /**
	 * 设置：门诊位置
	 */
    public void setMenzhenAddress(String menzhenAddress) {
        this.menzhenAddress = menzhenAddress;
    }
    /**
	 * 获取：星期几坐诊
	 */
    public String getXingqiji() {
        return xingqiji;
    }


    /**
	 * 设置：星期几坐诊
	 */
    public void setXingqiji(String xingqiji) {
        this.xingqiji = xingqiji;
    }
    /**
	 * 获取：门诊详情
	 */
    public String getQitaContent() {
        return qitaContent;
    }


    /**
	 * 设置：门诊详情
	 */
    public void setQitaContent(String qitaContent) {
        this.qitaContent = qitaContent;
    }
    /**
	 * 获取：添加详情
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加详情
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
