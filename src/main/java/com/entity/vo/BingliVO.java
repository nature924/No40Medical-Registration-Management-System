package com.entity.vo;

import com.entity.BingliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 病例
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bingli")
public class BingliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 挂号
     */

    @TableField(value = "guahao_id")
    private Integer guahaoId;


    /**
     * 医生
     */

    @TableField(value = "yisheng_id")
    private Integer yishengId;


    /**
     * 病例编号
     */

    @TableField(value = "bingli_uuid_number")
    private String bingliUuidNumber;


    /**
     * 患者主诉
     */

    @TableField(value = "zhusu_content")
    private String zhusuContent;


    /**
     * 诊断结果
     */

    @TableField(value = "zhenduan_content")
    private String zhenduanContent;


    /**
     * 开药详情
     */

    @TableField(value = "kaiyao_content")
    private String kaiyaoContent;


    /**
     * 状态
     */

    @TableField(value = "bingli_types")
    private Integer bingliTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：挂号
	 */
    public Integer getGuahaoId() {
        return guahaoId;
    }


    /**
	 * 获取：挂号
	 */

    public void setGuahaoId(Integer guahaoId) {
        this.guahaoId = guahaoId;
    }
    /**
	 * 设置：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 获取：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 设置：病例编号
	 */
    public String getBingliUuidNumber() {
        return bingliUuidNumber;
    }


    /**
	 * 获取：病例编号
	 */

    public void setBingliUuidNumber(String bingliUuidNumber) {
        this.bingliUuidNumber = bingliUuidNumber;
    }
    /**
	 * 设置：患者主诉
	 */
    public String getZhusuContent() {
        return zhusuContent;
    }


    /**
	 * 获取：患者主诉
	 */

    public void setZhusuContent(String zhusuContent) {
        this.zhusuContent = zhusuContent;
    }
    /**
	 * 设置：诊断结果
	 */
    public String getZhenduanContent() {
        return zhenduanContent;
    }


    /**
	 * 获取：诊断结果
	 */

    public void setZhenduanContent(String zhenduanContent) {
        this.zhenduanContent = zhenduanContent;
    }
    /**
	 * 设置：开药详情
	 */
    public String getKaiyaoContent() {
        return kaiyaoContent;
    }


    /**
	 * 获取：开药详情
	 */

    public void setKaiyaoContent(String kaiyaoContent) {
        this.kaiyaoContent = kaiyaoContent;
    }
    /**
	 * 设置：状态
	 */
    public Integer getBingliTypes() {
        return bingliTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setBingliTypes(Integer bingliTypes) {
        this.bingliTypes = bingliTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
