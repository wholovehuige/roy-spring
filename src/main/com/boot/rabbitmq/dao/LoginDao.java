package com.boot.rabbitmq.dao;

import com.boot.rabbitmq.domain.Login;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by roy on 17-6-13.
 */
@Repository
public interface LoginDao extends PagingAndSortingRepository<Login,Long> , JpaSpecificationExecutor<Login> {


}
