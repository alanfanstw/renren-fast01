package io.renren.modules.oss.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 文件上传
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-25 12:13:26
 */
@ApiModel(value="文件上传")
public class SysOssEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value="id",required=true,example="")
	private Long id;
	//URL地址
	@ApiModelProperty(value="URL地址",required=true,example="")
	private String url;
	//创建时间
	@ApiModelProperty(value="创建时间",required=true,example="")
	private Date createDate;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：URL地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：URL地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
