package io.java.springbootstarter.repository.Topics1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.java.springbootstarter.model1.Topics1;

@Repository
public interface Topics1Repository extends JpaRepository<Topics1, String>{	
 
}
