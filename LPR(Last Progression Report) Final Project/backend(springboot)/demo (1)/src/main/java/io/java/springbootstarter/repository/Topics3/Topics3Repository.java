package io.java.springbootstarter.repository.Topics3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.java.springbootstarter.model3.Topics3;

@Repository
public interface Topics3Repository extends JpaRepository<Topics3, String>  {

}
