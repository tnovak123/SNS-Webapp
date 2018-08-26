package com.SNS.WebApplication.models.data;

import com.SNS.WebApplication.models.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ServiceDAO extends CrudRepository<Service, Integer> {
}
