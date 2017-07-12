package com.boot.rabbitmq.es.repository;

import com.boot.rabbitmq.es.domain.LoginEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by roy on 17-7-12.
 */
public interface LoginEsRepository extends ElasticsearchRepository<LoginEs,Long> {
}
