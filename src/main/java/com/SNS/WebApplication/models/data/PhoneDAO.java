package com.SNS.WebApplication.models.data;

import com.SNS.WebApplication.models.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PhoneDAO extends CrudRepository<Phone, Integer> {
}
