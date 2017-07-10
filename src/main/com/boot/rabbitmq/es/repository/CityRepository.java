package com.boot.rabbitmq.es.repository;

import com.boot.rabbitmq.es.domain.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bysocket on 17/05/2017.
 */
@Repository
public interface CityRepository extends ElasticsearchRepository<City,Long> {


}
