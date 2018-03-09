package io.renren.modules.app.controller;


import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.modules.app.service.UserService;
import io.renren.modules.app.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * APP登录授权
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/app")
@Api(value="APP接口",description="App")
public class ApiLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @ResponseBody
    @PostMapping("login")
    @ApiOperation(httpMethod = "POST", value = "登录", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,responseContainer="Map")
    @ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = true),
		@ApiImplicitParam(paramType = "query", dataType = "String", name = "mobile", value = "手机号", required = true), 
		@ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = true)
	})
    public R login(String mobile, String password){
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");

        //用户登录
        long userId = userService.login(mobile, password);

        //生成token
        String token = jwtUtils.generateToken(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return R.ok(map);
    }

}
