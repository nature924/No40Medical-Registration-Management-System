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
 * 体检
 *
 * @author 
 * @email
 */
@TableName("tijian")
public class TijianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TijianEntity() {

	}

	public TijianEntity(T t) {
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
     * 医生
     */
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 患者
     */
    @TableField(value = "huanzhe_id")

    private Integer huanzheId;


    /**
     * 体检编号
     */
    @TableField(value = "tijian_uuid_number")

    private String tijianUuidNumber;


    /**
     * 体重
     */
    @TableField(value = "tizhong")

    private String tizhong;


    /**
     * 身高
     */
    @TableField(value = "shengao")

    private String shengao;


    /**
     * 左眼度数
     */
    @TableField(value = "zuoyandushu")

    private String zuoyandushu;


    /**
     * 右眼度数
     */
    @TableField(value = "youyandushu")

    private String youyandushu;


    /**
     * 心率
     */
    @TableField(value = "xinlv")

    private String xinlv;


    /**
     * 心音
     */
    @TableField(value = "xinyin")

    private String xinyin;


    /**
     * 肺部听诊
     */
    @TableField(value = "feibutingzhen")

    private String feibutingzhen;


    /**
     * 肝脏听诊
     */
    @TableField(value = "ganzangtingzhen")

    private String ganzangtingzhen;


    /**
     * 血常规详情
     */
    @TableField(value = "xuechanggui_text")

    private String xuechangguiText;


    /**
     * 尿常规详情
     */
    @TableField(value = "niaochanggui_text")

    private String niaochangguiText;


    /**
     * 其他详情
     */
    @TableField(value = "qita_text")

    private String qitaText;


    /**
     * 检查时间
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
	 * 设置：患者
	 */
    public Integer getHuanzheId() {
        return huanzheId;
    }


    /**
	 * 获取：患者
	 */

    public void setHuanzheId(Integer huanzheId) {
        this.huanzheId = huanzheId;
    }
    /**
	 * 设置：体检编号
	 */
    public String getTijianUuidNumber() {
        return tijianUuidNumber;
    }


    /**
	 * 获取：体检编号
	 */

    public void setTijianUuidNumber(String tijianUuidNumber) {
        this.tijianUuidNumber = tijianUuidNumber;
    }
    /**
	 * 设置：体重
	 */
    public String getTizhong() {
        return tizhong;
    }


    /**
	 * 获取：体重
	 */

    public void setTizhong(String tizhong) {
        this.tizhong = tizhong;
    }
    /**
	 * 设置：身高
	 */
    public String getShengao() {
        return shengao;
    }


    /**
	 * 获取：身高
	 */

    public void setShengao(String shengao) {
        this.shengao = shengao;
    }
    /**
	 * 设置：左眼度数
	 */
    public String getZuoyandushu() {
        return zuoyandushu;
    }


    /**
	 * 获取：左眼度数
	 */

    public void setZuoyandushu(String zuoyandushu) {
        this.zuoyandushu = zuoyandushu;
    }
    /**
	 * 设置：右眼度数
	 */
    public String getYouyandushu() {
        return youyandushu;
    }


    /**
	 * 获取：右眼度数
	 */

    public void setYouyandushu(String youyandushu) {
        this.youyandushu = youyandushu;
    }
    /**
	 * 设置：心率
	 */
    public String getXinlv() {
        return xinlv;
    }


    /**
	 * 获取：心率
	 */

    public void setXinlv(String xinlv) {
        this.xinlv = xinlv;
    }
    /**
	 * 设置：心音
	 */
    public String getXinyin() {
        return xinyin;
    }


    /**
	 * 获取：心音
	 */

    public void setXinyin(String xinyin) {
        this.xinyin = xinyin;
    }
    /**
	 * 设置：肺部听诊
	 */
    public String getFeibutingzhen() {
        return feibutingzhen;
    }


    /**
	 * 获取：肺部听诊
	 */

    public void setFeibutingzhen(String feibutingzhen) {
        this.feibutingzhen = feibutingzhen;
    }
    /**
	 * 设置：肝脏听诊
	 */
    public String getGanzangtingzhen() {
        return ganzangtingzhen;
    }


    /**
	 * 获取：肝脏听诊
	 */

    public void setGanzangtingzhen(String ganzangtingzhen) {
        this.ganzangtingzhen = ganzangtingzhen;
    }
    /**
	 * 设置：血常规详情
	 */
    public String getXuechangguiText() {
        return xuechangguiText;
    }


    /**
	 * 获取：血常规详情
	 */

    public void setXuechangguiText(String xuechangguiText) {
        this.xuechangguiText = xuechangguiText;
    }
    /**
	 * 设置：尿常规详情
	 */
    public String getNiaochangguiText() {
        return niaochangguiText;
    }


    /**
	 * 获取：尿常规详情
	 */

    public void setNiaochangguiText(String niaochangguiText) {
        this.niaochangguiText = niaochangguiText;
    }
    /**
	 * 设置：其他详情
	 */
    public String getQitaText() {
        return qitaText;
    }


    /**
	 * 获取：其他详情
	 */

    public void setQitaText(String qitaText) {
        this.qitaText = qitaText;
    }
    /**
	 * 设置：检查时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：检查时间
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
        return "Tijian{" +
            "id=" + id +
            ", yishengId=" + yishengId +
            ", huanzheId=" + huanzheId +
            ", tijianUuidNumber=" + tijianUuidNumber +
            ", tizhong=" + tizhong +
            ", shengao=" + shengao +
            ", zuoyandushu=" + zuoyandushu +
            ", youyandushu=" + youyandushu +
            ", xinlv=" + xinlv +
            ", xinyin=" + xinyin +
            ", feibutingzhen=" + feibutingzhen +
            ", ganzangtingzhen=" + ganzangtingzhen +
            ", xuechangguiText=" + xuechangguiText +
            ", niaochangguiText=" + niaochangguiText +
            ", qitaText=" + qitaText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
