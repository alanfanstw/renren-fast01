package io.renren.modules.sys.entity;


import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:26:39
 */
@ApiModel(value="菜单管理")
public class SysMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 菜单ID
	 */
	@ApiModelProperty(value="菜单ID",required=true,example="")
	private Long menuId;

	/**
	 * 父菜单ID，一级菜单为0
	 */
	@ApiModelProperty(value="父菜单ID，一级菜单为0",required=true,example="")
	private Long parentId;
	
	/**
	 * 父菜单名称
	 */
	@ApiModelProperty(value="父菜单名称",required=true,example="")
	private String parentName;

	/**
	 * 菜单名称
	 */
	@ApiModelProperty(value="菜单ID",required=true,example="")
	private String name;

	/**
	 * 菜单URL
	 */
	@ApiModelProperty(value="菜单URL",required=true,example="")
	private String url;

	/**
	 * 授权(多个用逗号分隔，如：user:list,user:create)
	 */
	@ApiModelProperty(value="菜单授权(多个用逗号分隔，如：user:list,user:create)",required=true,example="")
	private String perms;

	/**
	 * 类型     0：目录   1：菜单   2：按钮
	 */
	@ApiModelProperty(value="菜单类型     0：目录   1：菜单   2：按钮",required=true,example="")
	private Integer type;

	/**
	 * 菜单图标
	 */
	@ApiModelProperty(value="菜单图标",required=true,example="")
	private String icon;

	/**
	 * 排序
	 */
	@ApiModelProperty(value="排序",required=false,example="")
	private Integer orderNum;
	
	/**
	 * ztree属性
	 */
	@ApiModelProperty(value="ztree属性",required=false,example="")
	private Boolean open;
	
	@ApiModelProperty(value="list",required=false,example="")
	private List<?> list;

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getMenuId() {
		return menuId;
	}
	
	/**
	 * 设置：父菜单ID，一级菜单为0
	 * @param parentId 父菜单ID，一级菜单为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取：父菜单ID，一级菜单为0
	 * @return Long
	 */
	public Long getParentId() {
		return parentId;
	}
	
	/**
	 * 设置：菜单名称
	 * @param name 菜单名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：菜单名称
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置：菜单URL
	 * @param url 菜单URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取：菜单URL
	 * @return String
	 */
	public String getUrl() {
		return url;
	}
	
	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 设置：菜单图标
	 * @param icon 菜单图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 获取：菜单图标
	 * @return String
	 */
	public String getIcon() {
		return icon;
	}
	
	/**
	 * 设置：排序
	 * @param orderNum 排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * 获取：排序
	 * @return Integer
	 */
	public Integer getOrderNum() {
		return orderNum;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}
}
