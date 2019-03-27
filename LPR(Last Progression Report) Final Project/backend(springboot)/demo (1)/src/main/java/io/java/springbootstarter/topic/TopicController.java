package io.java.springbootstarter.topic;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping
@CrossOrigin(origins="http://localhost:4200")
public class TopicController {
	
	
	
	
	@Autowired
	private TopicService ts;
  
	
	//defining path to get data from springboot and sending to angular using getTopic()
	  @GetMapping("api/topics/{id}") 
	  public List getTopic(@PathVariable("id") String id){ 

			return (List)ts.getByTopic(id);
		  }

}
