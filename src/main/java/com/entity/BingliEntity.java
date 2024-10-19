package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 病例
 *
 * @author 
 * @email
 */
@TableName("bingli")
public class BingliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BingliEntity() {

	}

	public BingliEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Bingli{" +
            "id=" + id +
            ", guahaoId=" + guahaoId +
            ", yishengId=" + yishengId +
            ", bingliUuidNumber=" + bingliUuidNumber +
            ", zhusuContent=" + zhusuContent +
            ", zhenduanContent=" + zhenduanContent +
            ", kaiyaoContent=" + kaiyaoContent +
            ", bingliTypes=" + bingliTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
