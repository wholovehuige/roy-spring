package com.boot.rabbitmq.web.api;

import com.boot.rabbitmq.es.domain.City;
import com.boot.rabbitmq.es.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 03/05/2017.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public Long createCity(City city) {
        return cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city/search", method = RequestMethod.GET,headers = "Accept=application/json")
    @ResponseBody
    public List<City> searchCity(@RequestParam(value = "pageNumber") Integer pageNumber,
                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                 @RequestParam(value = "searchContent") String searchContent) {
        return cityService.searchCity(pageNumber,pageSize,searchContent);
    }
}