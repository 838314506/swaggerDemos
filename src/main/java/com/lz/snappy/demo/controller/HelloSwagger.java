package com.lz.snappy.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hello")
//此注解用于声明类的作用
@Api("HelloSwagger一个用来测试swagger的控制器")
public class HelloSwagger {

	@GetMapping("/getUserName")
	//用于给接口方法添加说明
	@ApiOperation(value="此api接口用于获取姓名",notes="注意只有1和2能够得到具体的姓名名称")
	//用于注解给方法入参添加方法说明
	@ApiImplicitParam(paramType="query",name="userNumber",value="用户编号",required=true,dataType="Integer")
	public String getUserName(Integer userNumber) {
		if(userNumber == 1) {
			return "张三丰";
		}else if(userNumber == 2) {
			return "梅朝风";
		}else {
			return "未知";
		}
	}
	
	@GetMapping("/updatePassword")
	@ApiOperation(value="此接口用于修改用户密码")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query",name="userId",value="用户编号",required=true,dataType="Integer"),
		@ApiImplicitParam(paramType="query",name="oldPawd",value="旧密码",required=true,dataType="String"),
		@ApiImplicitParam(paramType="query",name="newPawd",value="新密码",required=true,dataType="String")
	})
	public String updatePassword(Integer userId,String oldPawd,String newPawd) {
		if(userId <= 0 || userId > 2) {
			return "未知的用户";
		}
		if(oldPawd.isEmpty() || newPawd.isEmpty()) {
			return "新旧密码的内容不能为空";
		}
		if(oldPawd.equals(newPawd)) {
			return "新旧密码不能相同";
		}
		return "密码修改成功！";
	}
}
