package com.SNS.WebApplication.models.data;

import com.SNS.WebApplication.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PersonDAO extends CrudRepository<Person, Integer> {

    List<Person> findDistinctPersonByType(PersonType type);
}
