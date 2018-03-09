package io.renren.modules.sys.entity;


import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 系统配置信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月4日 下午6:43:36
 */
@ApiModel(value="系统配置信息")
public class SysConfigEntity {
	
	@ApiModelProperty(value="id",required=false,example="")
	private Long id;
	
	@NotBlank(message="参数名不能为空")
	@ApiModelProperty(value="key",required=true,example="")
	private String key;
	
	@NotBlank(message="参数值不能为空")
	@ApiModelProperty(value="value",required=true,example="")
	private String value; 
	
	@ApiModelProperty(value="remark",required=false,example="")
	private String remark;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
