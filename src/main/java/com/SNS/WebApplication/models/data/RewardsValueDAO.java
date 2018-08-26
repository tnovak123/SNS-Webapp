package com.SNS.WebApplication.models.data;

import com.SNS.WebApplication.models.RewardsValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RewardsValueDAO extends CrudRepository<RewardsValue, Integer> {
}
