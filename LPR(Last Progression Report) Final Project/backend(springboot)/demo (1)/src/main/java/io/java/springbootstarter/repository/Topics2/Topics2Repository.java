package io.java.springbootstarter.repository.Topics2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.java.springbootstarter.model2.Topics2;

@Repository
public interface Topics2Repository extends JpaRepository<Topics2, String> {

}
