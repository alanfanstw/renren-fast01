package io.renren.modules.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.Constant;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserRoleService;
import io.renren.modules.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
@Api(value="系统用户",description="SysUser")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	@ApiOperation(httpMethod = "GET", value = "所有用户列表")
	
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = true),
//		@ApiImplicitParam(paramType = "query", dataType = "String", name = "params", value = "params", required = false),
		@ApiImplicitParam(paramType = "query", dataType = "int", name = "page", value = "页码", required = true),
		@ApiImplicitParam(paramType = "query", dataType = "int", name = "limit", value = "每页条数", required = true),
		@ApiImplicitParam(paramType = "query", dataType = "String", name = "sidx", value = "排序字段", required = false),
		@ApiImplicitParam(paramType = "query", dataType = "String", name = "order", value = "排序方式，如：asc、desc", required = false),
		@ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名", required = false)
	})
	@ApiResponses({
		@ApiResponse(code=200, message = "返回管理员列表",reference="#/definitions/SysUserEntityList")
	})
	public R list(@RequestParam Map<String, Object> params){
		//只有超级管理员，才能查看所有管理员列表
		if(getUserId() != Constant.SUPER_ADMIN){
			params.put("createUserId", getUserId());
		}
		//查询列表数据
		Query query = new Query(params);
		List<SysUserEntity> userList = sysUserService.queryList(query);
		int total = sysUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	@ApiOperation(httpMethod = "GET", value = "获取登录的用户信息" )
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = true)
	})
	public R info(){
		return R.ok().put("user", getUser());
	}
	
	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@RequestMapping("/password")
	@ApiOperation(httpMethod = "GET", value = "修改登录用户密码")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = true),
		@ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "password", required = true),
		@ApiImplicitParam(paramType = "query", dataType = "String", name = "newPassword", value = "newPassword", required = true)
	})
	public R password(String password, String newPassword){
		Assert.isBlank(newPassword, "新密码不为能空");
		
		//sha256加密
		password = new Sha256Hash(password, getUser().getSalt()).toHex();
		//sha256加密
		newPassword = new Sha256Hash(newPassword, getUser().getSalt()).toHex();
				
		//更新密码
		int count = sysUserService.updatePassword(getUserId(), password, newPassword);
		if(count == 0){
			return R.error("原密码不正确");
		}
		
		return R.ok();
	}
	
	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	@ApiOperation(httpMethod = "GET", value = "用户信息" )
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = true),
		@ApiImplicitParam(paramType = "query", dataType = "Long", name = "userId", value = "userId", required = true)
	})
	public R info(@PathVariable("userId") Long userId){
		SysUserEntity user = sysUserService.queryObject(userId);
		
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		
		return R.ok().put("user", user);
	}
	
	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@RequestMapping("/save")
	@RequiresPermissions("sys:user:save")
	@ApiOperation(httpMethod = "POST", value = "保存用户" )
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = true)
	})
	public R save(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, AddGroup.class);
		
		user.setCreateUserId(getUserId());
		sysUserService.save(user);
		
		return R.ok();
	}
	
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@RequestMapping("/update")
	@RequiresPermissions("sys:user:update")
	@ApiOperation(httpMethod = "POST", value = "修改用户" )
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = true)
	})
	public R update(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, UpdateGroup.class);
		
		user.setCreateUserId(getUserId());
		sysUserService.update(user);
		
		return R.ok();
	}
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	@ApiOperation(httpMethod = "POST", value = "删除用户" )
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = true),
		@ApiImplicitParam(paramType = "query", dataType ="Long", name = "userIds", value = "userIds", required = true ,allowMultiple = true)
	})
	public R delete(@RequestBody Long[] userIds){
		if(ArrayUtils.contains(userIds, 1L)){
			return R.error("系统管理员不能删除");
		}
		
		if(ArrayUtils.contains(userIds, getUserId())){
			return R.error("当前用户不能删除");
		}
		
		sysUserService.deleteBatch(userIds);
		
		return R.ok();
	}
}
