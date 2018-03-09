package io.renren.modules.sys.entity;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色与菜单对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:13
 */
@ApiModel(value="角色与菜单对应关系")
public class SysRoleMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="id",required=false,example="")
	private Long id;

	/**
	 * 角色ID
	 */
	@ApiModelProperty(value="角色ID",required=true,example="")
	private Long roleId;

	/**
	 * 菜单ID
	 */
	@ApiModelProperty(value="菜单ID",required=true,example="")
	private Long menuId;

	/**
	 * 设置：
	 * @param id 
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取：
	 * @return Long
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置：角色ID
	 * @param roleId 角色ID
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取：角色ID
	 * @return Long
	 */
	public Long getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置：菜单ID
	 * @param menuId 菜单ID
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * 获取：菜单ID
	 * @return Long
	 */
	public Long getMenuId() {
		return menuId;
	}
	
}
