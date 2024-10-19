package com.entity.view;

import com.entity.BingliEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 病例
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bingli")
public class BingliView extends BingliEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 状态的值
		*/
		private String bingliValue;



		//级联表 guahao
			/**
			* 挂号 的 挂号人员
			*/
			private Integer guahaoGuahaorenyuanId;
			/**
			* 挂号 的 医生
			*/
			private Integer guahaoYishengId;
			/**
			* 号
			*/
			private String guahaoUuidNumber;

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

	public BingliView() {

	}

	public BingliView(BingliEntity bingliEntity) {
		try {
			BeanUtils.copyProperties(this, bingliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 状态的值
			*/
			public String getBingliValue() {
				return bingliValue;
			}
			/**
			* 设置： 状态的值
			*/
			public void setBingliValue(String bingliValue) {
				this.bingliValue = bingliValue;
			}










				//级联表的get和set guahao

					/**
					* 获取：挂号 的 挂号人员
					*/
					public Integer getGuahaoGuahaorenyuanId() {
						return guahaoGuahaorenyuanId;
					}
					/**
					* 设置：挂号 的 挂号人员
					*/
					public void setGuahaoGuahaorenyuanId(Integer guahaoGuahaorenyuanId) {
						this.guahaoGuahaorenyuanId = guahaoGuahaorenyuanId;
					}

					/**
					* 获取：挂号 的 医生
					*/
					public Integer getGuahaoYishengId() {
						return guahaoYishengId;
					}
					/**
					* 设置：挂号 的 医生
					*/
					public void setGuahaoYishengId(Integer guahaoYishengId) {
						this.guahaoYishengId = guahaoYishengId;
					}

					/**
					* 获取： 号
					*/
					public String getGuahaoUuidNumber() {
						return guahaoUuidNumber;
					}
					/**
					* 设置： 号
					*/
					public void setGuahaoUuidNumber(String guahaoUuidNumber) {
						this.guahaoUuidNumber = guahaoUuidNumber;
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
