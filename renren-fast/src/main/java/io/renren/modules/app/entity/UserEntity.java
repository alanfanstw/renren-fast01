package io.renren.modules.app.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
@ApiModel(value="用户实体")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	@ApiModelProperty(value="用户ID",required=true,example="")
	private Long userId;
	//用户名
	@ApiModelProperty(value="用户名",required=true,example="")
	private String username;
	//手机号
	@ApiModelProperty(value="手机号",required=true,example="")
	private String mobile;
	//密码
	@ApiModelProperty(value="密码",required=true,example="")
	transient private String password;
	//创建时间
	@ApiModelProperty(value="创建时间",required=true,example="")
	private Date createTime;

	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
