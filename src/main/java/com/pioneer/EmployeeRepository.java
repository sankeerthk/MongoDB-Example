package com.pioneer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sankeerth on 7/12/2017.
 */
@Transactional
public interface EmployeeRepository extends MongoRepository<Employee,String>{
    Employee findByFirstName(String firstName);

}
