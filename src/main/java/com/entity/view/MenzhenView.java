package com.entity.view;

import com.entity.MenzhenEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 门诊
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("menzhen")
public class MenzhenView extends MenzhenEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 yisheng
			/**
			* 医生姓名
			*/
			private String yishengName;
			/**
			* 医生联系方式
			*/
			private String yishengPhone;
			/**
			* 医生头像
			*/
			private String yishengPhoto;
			/**
			* 科室
			*/
			private Integer keshiTypes;
				/**
				* 科室的值
				*/
				private String keshiValue;
			/**
			* 职位
			*/
			private Integer zhiweiTypes;
				/**
				* 职位的值
				*/
				private String zhiweiValue;
			/**
			* 挂号费
			*/
			private Double guahaofei;

	public MenzhenView() {

	}

	public MenzhenView(MenzhenEntity menzhenEntity) {
		try {
			BeanUtils.copyProperties(this, menzhenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

























				//级联表的get和set yisheng
					/**
					* 获取： 医生姓名
					*/
					public String getYishengName() {
						return yishengName;
					}
					/**
					* 设置： 医生姓名
					*/
					public void setYishengName(String yishengName) {
						this.yishengName = yishengName;
					}
					/**
					* 获取： 医生联系方式
					*/
					public String getYishengPhone() {
						return yishengPhone;
					}
					/**
					* 设置： 医生联系方式
					*/
					public void setYishengPhone(String yishengPhone) {
						this.yishengPhone = yishengPhone;
					}
					/**
					* 获取： 医生头像
					*/
					public String getYishengPhoto() {
						return yishengPhoto;
					}
					/**
					* 设置： 医生头像
					*/
					public void setYishengPhoto(String yishengPhoto) {
						this.yishengPhoto = yishengPhoto;
					}
					/**
					* 获取： 科室
					*/
					public Integer getKeshiTypes() {
						return keshiTypes;
					}
					/**
					* 设置： 科室
					*/
					public void setKeshiTypes(Integer keshiTypes) {
						this.keshiTypes = keshiTypes;
					}


						/**
						* 获取： 科室的值
						*/
						public String getKeshiValue() {
							return keshiValue;
						}
						/**
						* 设置： 科室的值
						*/
						public void setKeshiValue(String keshiValue) {
							this.keshiValue = keshiValue;
						}
					/**
					* 获取： 职位
					*/
					public Integer getZhiweiTypes() {
						return zhiweiTypes;
					}
					/**
					* 设置： 职位
					*/
					public void setZhiweiTypes(Integer zhiweiTypes) {
						this.zhiweiTypes = zhiweiTypes;
					}


						/**
						* 获取： 职位的值
						*/
						public String getZhiweiValue() {
							return zhiweiValue;
						}
						/**
						* 设置： 职位的值
						*/
						public void setZhiweiValue(String zhiweiValue) {
							this.zhiweiValue = zhiweiValue;
						}
					/**
					* 获取： 挂号费
					*/
					public Double getGuahaofei() {
						return guahaofei;
					}
					/**
					* 设置： 挂号费
					*/
					public void setGuahaofei(Double guahaofei) {
						this.guahaofei = guahaofei;
					}


}
