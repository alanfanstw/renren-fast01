package io.renren.modules.app.controller;


import io.renren.common.utils.R;
import io.renren.modules.app.annotation.Login;
import io.renren.modules.app.annotation.LoginUser;
import io.renren.modules.app.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * APP测试接口
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/app")
@Api(value="APP接口",description="App")
public class ApiTestController {

    @Login
    @GetMapping("userInfo")
    @ApiOperation(httpMethod = "GET", value = "获取用户信息")
    @ApiResponses({
    	@ApiResponse(code=200, message = "200",response=R.class)
    })
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
    @ApiOperation(httpMethod = "GET", value = "获取用户ID", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = true),
		@ApiImplicitParam(paramType = "query", dataType = "String", name = "userId", value = "用户ID", required = true)
	})
    public R userInfo(@RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }

    @GetMapping("notToken")
    @ApiOperation(httpMethod = "GET", value = "忽略Token验证测试", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }

}
