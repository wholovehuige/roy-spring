package com.boot.rabbitmq.web.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boot.rabbitmq.config.Redis;
import com.boot.rabbitmq.domain.External;
import com.boot.rabbitmq.domain.Login;
import com.boot.rabbitmq.message.MessageSend;
//import com.boot.rabbitmq.properties.Properties;
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
    @Autowired
    private MessageSend messageSend;
    @Autowired
    private MailService mailService;
    @Autowired
    private LoginServiceImpl loginService;
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
        messageSend.send(External.test,msg);

        return "ok";
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    @ResponseBody
    public String getMessage(LonginRequest request) {
//        redis.add(request.getPhone(),request.getPassword());
        loginService.test(request.getUserName(),request.getPhone(),request.getPassword());
        return "1";
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

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject newaPAGE() {
        String[] titile = new String[7];
        JSONObject jsonObject = new JSONObject();
        JSONArray foodtitle = new JSONArray();
        JSONArray foodData = new JSONArray();
        JSONObject object1 = new JSONObject();
        object1.put("value",15);
        object1.put("name","动物油");
        foodData.add(object1);
        JSONObject object2 = new JSONObject();
        object2.put("value",33);
        object2.put("name","肉制品");
        foodData.add(object2);
        JSONObject object3 = new JSONObject();
        object3.put("value",10);
        object3.put("name","乳制品");
        foodData.add(object3);
        JSONObject object4 = new JSONObject();
        object4.put("value",20);
        object4.put("name","水产品");
        foodData.add(object4);
        JSONObject object5 = new JSONObject();
        object5.put("value",8);
        object5.put("name","酒类");
        foodData.add(object5);
        JSONObject object6 = new JSONObject();
        object6.put("value",14);
        object6.put("name","植物油");
        foodData.add(object6);
        for(int i = 0 ; i<foodData.size();i++) {
            JSONObject jsonObject11 = foodData.getJSONObject(i);
            String name = jsonObject11.getString("name");
            titile[i] = name;
            foodtitle.add(name);
        }
        jsonObject.put("foodtitle",titile);
        jsonObject.put("foodData",foodData);
        return jsonObject;
    }
}
