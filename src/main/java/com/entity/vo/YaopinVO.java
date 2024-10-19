package com.entity.vo;

import com.entity.YaopinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 药品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yaopin")
public class YaopinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 药品编号
     */

    @TableField(value = "yaopin_uuid_number")
    private String yaopinUuidNumber;


    /**
     * 药品名称
     */

    @TableField(value = "yaopin_name")
    private String yaopinName;


    /**
     * 药品照片
     */

    @TableField(value = "yaopin_photo")
    private String yaopinPhoto;


    /**
     * 药品类型
     */

    @TableField(value = "yaopin_types")
    private Integer yaopinTypes;


    /**
     * 药品介绍
     */

    @TableField(value = "yaopin_content")
    private String yaopinContent;


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
	 * 设置：药品编号
	 */
    public String getYaopinUuidNumber() {
        return yaopinUuidNumber;
    }


    /**
	 * 获取：药品编号
	 */

    public void setYaopinUuidNumber(String yaopinUuidNumber) {
        this.yaopinUuidNumber = yaopinUuidNumber;
    }
    /**
	 * 设置：药品名称
	 */
    public String getYaopinName() {
        return yaopinName;
    }


    /**
	 * 获取：药品名称
	 */

    public void setYaopinName(String yaopinName) {
        this.yaopinName = yaopinName;
    }
    /**
	 * 设置：药品照片
	 */
    public String getYaopinPhoto() {
        return yaopinPhoto;
    }


    /**
	 * 获取：药品照片
	 */

    public void setYaopinPhoto(String yaopinPhoto) {
        this.yaopinPhoto = yaopinPhoto;
    }
    /**
	 * 设置：药品类型
	 */
    public Integer getYaopinTypes() {
        return yaopinTypes;
    }


    /**
	 * 获取：药品类型
	 */

    public void setYaopinTypes(Integer yaopinTypes) {
        this.yaopinTypes = yaopinTypes;
    }
    /**
	 * 设置：药品介绍
	 */
    public String getYaopinContent() {
        return yaopinContent;
    }


    /**
	 * 获取：药品介绍
	 */

    public void setYaopinContent(String yaopinContent) {
        this.yaopinContent = yaopinContent;
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
