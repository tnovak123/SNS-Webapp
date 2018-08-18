package com.SNS.WebApplication.models.data;

import com.SNS.WebApplication.models.PersonType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonTypeDAO extends CrudRepository<PersonType, Integer> {
}
