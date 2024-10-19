package com.entity.vo;

import com.entity.MenzhenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 门诊
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("menzhen")
public class MenzhenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 医生
     */

    @TableField(value = "yisheng_id")
    private Integer yishengId;


    /**
     * 门诊名称
     */

    @TableField(value = "menzhen_name")
    private String menzhenName;


    /**
     * 门诊位置
     */

    @TableField(value = "menzhen_address")
    private String menzhenAddress;


    /**
     * 星期几坐诊
     */

    @TableField(value = "xingqiji")
    private String xingqiji;


    /**
     * 门诊详情
     */

    @TableField(value = "qita_content")
    private String qitaContent;


    /**
     * 添加详情
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
	 * 设置：门诊名称
	 */
    public String getMenzhenName() {
        return menzhenName;
    }


    /**
	 * 获取：门诊名称
	 */

    public void setMenzhenName(String menzhenName) {
        this.menzhenName = menzhenName;
    }
    /**
	 * 设置：门诊位置
	 */
    public String getMenzhenAddress() {
        return menzhenAddress;
    }


    /**
	 * 获取：门诊位置
	 */

    public void setMenzhenAddress(String menzhenAddress) {
        this.menzhenAddress = menzhenAddress;
    }
    /**
	 * 设置：星期几坐诊
	 */
    public String getXingqiji() {
        return xingqiji;
    }


    /**
	 * 获取：星期几坐诊
	 */

    public void setXingqiji(String xingqiji) {
        this.xingqiji = xingqiji;
    }
    /**
	 * 设置：门诊详情
	 */
    public String getQitaContent() {
        return qitaContent;
    }


    /**
	 * 获取：门诊详情
	 */

    public void setQitaContent(String qitaContent) {
        this.qitaContent = qitaContent;
    }
    /**
	 * 设置：添加详情
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加详情
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
