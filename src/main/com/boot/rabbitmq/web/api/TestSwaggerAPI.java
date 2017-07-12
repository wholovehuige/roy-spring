package com.boot.rabbitmq.web.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boot.rabbitmq.config.Redis;
import com.boot.rabbitmq.domain.External;
import com.boot.rabbitmq.domain.Login;
//import com.boot.rabbitmq.message.MessageSend;
//import com.boot.rabbitmq.properties.Properties;
import com.boot.rabbitmq.service.LoginService;
import com.boot.rabbitmq.service.MailService;
import com.boot.rabbitmq.service.impl.LoginServiceImpl;
import com.boot.rabbitmq.web.request.LonginRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by roy on 17-5-24.
 */
@Controller
@RequestMapping("/message")
public class TestSwaggerAPI {
//    @Autowired
//    private MessageSend messageSend;
    @Autowired
    private MailService mailService;
    @Autowired
    private LoginService loginService;
//    @Autowired
//    private Properties properties;
    @Autowired
    private Redis redis;

    @ApiOperation(value = "队列加入数据",notes = "用于队列的数据添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "msg",value = "入队信息",required = true)
    })
    @ResponseBody
    @RequestMapping(value = "/send",method = RequestMethod.POST )
    public String messageSend(@RequestBody String msg) {
//        messageSend.send(External.test,msg);

        return "ok";
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    @ResponseBody
    public String getMessage(LonginRequest request) {
//        redis.add(request.getPhone(),request.getPassword());
        Long id  = loginService.register(request.getUserName(),request.getPhone(),request.getPassword());
        return id==null?"该用户已经被注册了":id.toString();
    }


    @RequestMapping(value = "get" ,method = RequestMethod.POST)
    @ResponseBody
    public String getTest(String uname,String passwd) {
        System.out.println("uname: "+uname + "passwd: " +passwd);
        return "yes";
    }

    @RequestMapping(value = "property",method = RequestMethod.GET )
    @ResponseBody
    public String getProperties() {
        mailService.sendSimpleMail("soabstract@136.com","test simple mail"," hello this is simple mail");
//        String name = properties.getName();
//        String phone = properties.getPhone();
//        String result = redis.search(name);
        return "";
    }


}
