package com.entity.model;

import com.entity.BingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 病例
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BingliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 挂号
     */
    private Integer guahaoId;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 病例编号
     */
    private String bingliUuidNumber;


    /**
     * 患者主诉
     */
    private String zhusuContent;


    /**
     * 诊断结果
     */
    private String zhenduanContent;


    /**
     * 开药详情
     */
    private String kaiyaoContent;


    /**
     * 状态
     */
    private Integer bingliTypes;


    /**
     * 添加时间
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
	 * 获取：挂号
	 */
    public Integer getGuahaoId() {
        return guahaoId;
    }


    /**
	 * 设置：挂号
	 */
    public void setGuahaoId(Integer guahaoId) {
        this.guahaoId = guahaoId;
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
	 * 获取：病例编号
	 */
    public String getBingliUuidNumber() {
        return bingliUuidNumber;
    }


    /**
	 * 设置：病例编号
	 */
    public void setBingliUuidNumber(String bingliUuidNumber) {
        this.bingliUuidNumber = bingliUuidNumber;
    }
    /**
	 * 获取：患者主诉
	 */
    public String getZhusuContent() {
        return zhusuContent;
    }


    /**
	 * 设置：患者主诉
	 */
    public void setZhusuContent(String zhusuContent) {
        this.zhusuContent = zhusuContent;
    }
    /**
	 * 获取：诊断结果
	 */
    public String getZhenduanContent() {
        return zhenduanContent;
    }


    /**
	 * 设置：诊断结果
	 */
    public void setZhenduanContent(String zhenduanContent) {
        this.zhenduanContent = zhenduanContent;
    }
    /**
	 * 获取：开药详情
	 */
    public String getKaiyaoContent() {
        return kaiyaoContent;
    }


    /**
	 * 设置：开药详情
	 */
    public void setKaiyaoContent(String kaiyaoContent) {
        this.kaiyaoContent = kaiyaoContent;
    }
    /**
	 * 获取：状态
	 */
    public Integer getBingliTypes() {
        return bingliTypes;
    }


    /**
	 * 设置：状态
	 */
    public void setBingliTypes(Integer bingliTypes) {
        this.bingliTypes = bingliTypes;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
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
