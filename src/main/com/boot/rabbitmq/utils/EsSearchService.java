package com.boot.rabbitmq.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Created by roy on 17-7-12.
 */
@Service
public class EsSearchService {

    public JSONObject analyze(String result) {
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject res = JSON.parseObject(result);
        JSONObject hits = res.getJSONObject("hits");
        int total = hits.getIntValue("total");
        JSONArray _hits = hits.getJSONArray("hits");
        for(int i = 0 ; i< _hits.size();i++) {
            array.add(_hits.getJSONObject(i).getJSONObject("_source"));
        }
        object.put("total",total);
        object.put("nowNum",_hits.size());
        object.put("data",array);
        return object;
    }


    /**
     * 查询
     * @param searchValue
     * @return
     */
    public JSONObject mustSearch(int from,int size,String searchValue) {
        JSONObject object = new JSONObject();
        JSONObject bool = new JSONObject();
        bool.put("must", must(searchValue));
        bool.put("must_not", must_not());
        bool.put("should", should());
        JSONObject query = new JSONObject();
        query.put("bool",bool);
        JSONObject aggs = new JSONObject();
        JSONArray sort = new JSONArray();
        object.put("query", query);
        object.put("from", from);
        object.put("size", size);
        object.put("sort", sort);
        object.put("aggs", aggs);
        return object;
    }


    private JSONArray must(String searchValue) {
        JSONArray array = new JSONArray();
        JSONObject query_string = new JSONObject();
        JSONObject object = new JSONObject();
        object.put("default_field", "_all");
        object.put("query", searchValue);
        query_string.put("query_string",object);
        array.add(query_string);
        return array;
    }

    private JSONArray must_not() {
        JSONArray array = new JSONArray();

        return array;
    }

    private JSONArray should() {
        JSONArray array = new JSONArray();

        return array;
    }
}
