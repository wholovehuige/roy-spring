
package com.boot.rabbitmq.es.service;


import com.alibaba.fastjson.JSONObject;
import com.boot.rabbitmq.es.domain.CityEs;

import java.util.List;

public interface CityService {

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveCity(CityEs city);


    /**
     * 根据关键词，function score query 权重分分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @param searchContent
     * @return
     */
    List<CityEs> searchCity(Integer pageNumber, Integer pageSize, String searchContent);

    List<CityEs> search(int pagenow, int rowMax, String searchKey);

    JSONObject searchBy(int pagenow, int rowMax, String searchKey);
}