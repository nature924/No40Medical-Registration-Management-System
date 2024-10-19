package com.entity.model;

import com.entity.TijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 体检
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TijianModel implements Serializable {
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
     * 患者
     */
    private Integer huanzheId;


    /**
     * 体检编号
     */
    private String tijianUuidNumber;


    /**
     * 体重
     */
    private String tizhong;


    /**
     * 身高
     */
    private String shengao;


    /**
     * 左眼度数
     */
    private String zuoyandushu;


    /**
     * 右眼度数
     */
    private String youyandushu;


    /**
     * 心率
     */
    private String xinlv;


    /**
     * 心音
     */
    private String xinyin;


    /**
     * 肺部听诊
     */
    private String feibutingzhen;


    /**
     * 肝脏听诊
     */
    private String ganzangtingzhen;


    /**
     * 血常规详情
     */
    private String xuechangguiText;


    /**
     * 尿常规详情
     */
    private String niaochangguiText;


    /**
     * 其他详情
     */
    private String qitaText;


    /**
     * 检查时间
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
	 * 获取：体检编号
	 */
    public String getTijianUuidNumber() {
        return tijianUuidNumber;
    }


    /**
	 * 设置：体检编号
	 */
    public void setTijianUuidNumber(String tijianUuidNumber) {
        this.tijianUuidNumber = tijianUuidNumber;
    }
    /**
	 * 获取：体重
	 */
    public String getTizhong() {
        return tizhong;
    }


    /**
	 * 设置：体重
	 */
    public void setTizhong(String tizhong) {
        this.tizhong = tizhong;
    }
    /**
	 * 获取：身高
	 */
    public String getShengao() {
        return shengao;
    }


    /**
	 * 设置：身高
	 */
    public void setShengao(String shengao) {
        this.shengao = shengao;
    }
    /**
	 * 获取：左眼度数
	 */
    public String getZuoyandushu() {
        return zuoyandushu;
    }


    /**
	 * 设置：左眼度数
	 */
    public void setZuoyandushu(String zuoyandushu) {
        this.zuoyandushu = zuoyandushu;
    }
    /**
	 * 获取：右眼度数
	 */
    public String getYouyandushu() {
        return youyandushu;
    }


    /**
	 * 设置：右眼度数
	 */
    public void setYouyandushu(String youyandushu) {
        this.youyandushu = youyandushu;
    }
    /**
	 * 获取：心率
	 */
    public String getXinlv() {
        return xinlv;
    }


    /**
	 * 设置：心率
	 */
    public void setXinlv(String xinlv) {
        this.xinlv = xinlv;
    }
    /**
	 * 获取：心音
	 */
    public String getXinyin() {
        return xinyin;
    }


    /**
	 * 设置：心音
	 */
    public void setXinyin(String xinyin) {
        this.xinyin = xinyin;
    }
    /**
	 * 获取：肺部听诊
	 */
    public String getFeibutingzhen() {
        return feibutingzhen;
    }


    /**
	 * 设置：肺部听诊
	 */
    public void setFeibutingzhen(String feibutingzhen) {
        this.feibutingzhen = feibutingzhen;
    }
    /**
	 * 获取：肝脏听诊
	 */
    public String getGanzangtingzhen() {
        return ganzangtingzhen;
    }


    /**
	 * 设置：肝脏听诊
	 */
    public void setGanzangtingzhen(String ganzangtingzhen) {
        this.ganzangtingzhen = ganzangtingzhen;
    }
    /**
	 * 获取：血常规详情
	 */
    public String getXuechangguiText() {
        return xuechangguiText;
    }


    /**
	 * 设置：血常规详情
	 */
    public void setXuechangguiText(String xuechangguiText) {
        this.xuechangguiText = xuechangguiText;
    }
    /**
	 * 获取：尿常规详情
	 */
    public String getNiaochangguiText() {
        return niaochangguiText;
    }


    /**
	 * 设置：尿常规详情
	 */
    public void setNiaochangguiText(String niaochangguiText) {
        this.niaochangguiText = niaochangguiText;
    }
    /**
	 * 获取：其他详情
	 */
    public String getQitaText() {
        return qitaText;
    }


    /**
	 * 设置：其他详情
	 */
    public void setQitaText(String qitaText) {
        this.qitaText = qitaText;
    }
    /**
	 * 获取：检查时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：检查时间
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
