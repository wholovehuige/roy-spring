package com.boot.rabbitmq.es.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.rabbitmq.es.domain.CityEs;
import com.boot.rabbitmq.es.repository.CityRepository;
import com.boot.rabbitmq.es.service.CityService;
import com.boot.rabbitmq.utils.HttpMethod;
import com.boot.rabbitmq.utils.EsSearchService;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * 城市 ES 业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityESServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityESServiceImpl.class);

    @Autowired
    CityRepository cityRepository;

    @Autowired
    private EsSearchService searchService;

    @Inject
    private ElasticsearchTemplate template;

    @Override
    public Long saveCity(CityEs city) {

        CityEs cityResult = cityRepository.save(city);
        return cityResult.getId();
    }


    @Override
    public List<CityEs> searchCity(Integer pageNumber,
                                   Integer pageSize,
                                   String searchContent) {
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        // Function Score Query
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
//                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("cityname", searchContent)),
//                    ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("cityname", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(100));

        // 创建搜索 DSL 查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();

        LOGGER.info("\n searchCity(): searchContent [" + searchContent + "] \n DSL  = \n " + searchQuery.getQuery().toString());

        Page<CityEs> searchPageResults = cityRepository.search(searchQuery);
        return searchPageResults.getContent();
    }


    @Override
    public List<CityEs> search(int pagenow, int rowMax, String searchKey) {
        BoolQueryBuilder boolQuery = boolQuery();
        boolQuery.should(queryStringQuery(searchKey).field("cityname"));
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQuery)
                .withPageable(new PageRequest(pagenow, rowMax))
                .build();
        Page<CityEs> cities = cityRepository.search(searchQuery);

        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        return cities.getContent();
//        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(boolQuery)
//                .addAggregation(terms("name").field("txid").subAggregation(sum("sum").field("proteinSize")).order(Terms.Order.aggregation("sum", false)).size(10))
//                .build();

    }

    @Override
    public JSONObject searchBy(int pagenow, int rowMax, String searchKey) {
        JSONObject jsonObject = searchService.mustSearch(pagenow,rowMax,searchKey);
        String url = "http://192.168.122.1:9200/_search/";
        String res = HttpMethod.sendPost(url, jsonObject.toString());
        return searchService.analyze(res);
    }
}
