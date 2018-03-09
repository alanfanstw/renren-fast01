package io.renren.modules.app.controller;


import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.modules.app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/app")
@Api(value="APP接口",description="App")
public class ApiRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ApiOperation(httpMethod = "POST", value = "注册", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
		@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token", required = true),
		@ApiImplicitParam(paramType = "query", dataType = "String", name = "mobile", value = "手机号", required = true), 
		@ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = true)
	})
    public R register(String mobile, String password){
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");

        userService.save(mobile, password);

        return R.ok();
    }
}
