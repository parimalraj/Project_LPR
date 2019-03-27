package io.java.springbootstarter.topic;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.java.springbootstarter.model1.Topics1;
import io.java.springbootstarter.model2.Topics2;
import io.java.springbootstarter.model3.Topics3;
import io.java.springbootstarter.repository.Topics1.Topics1Repository;
import io.java.springbootstarter.repository.Topics2.Topics2Repository;
import io.java.springbootstarter.repository.Topics3.Topics3Repository;

@Service
public class TopicService {
	
	@Autowired
	private Topics1Repository topicRepo1;
	@Autowired
	private Topics2Repository topicRepo2;
	@Autowired
	private Topics3Repository topicRepo3;
	
	private String st1;
	private String st2;
	private String st3;
	

//defining an arrayList which would be used to store and send data to angular
	ArrayList<Topic> topics = new ArrayList<Topic>(); 	
	
	
	//method which is taking whole id string and retrieving data from 3 db and returning as a list
	 public List getByTopic(String id) {
	
	//logic for splitting the whole input string and getting order id
	  List finalList=new ArrayList<String>();
	  id=id.replaceAll("\\s","");
	  String[] arrInputOrder=id.split(",");

	 //taking particular id(in h) from the arrayList containing many id's
	  for(String orderId:arrInputOrder) {
		int flag=0;

		  st1="";
		  st2="";
		  st3="";
		  
		  //taking data from database 1 (Cordys) using findById() method
		    try{
		    	Optional<Topics1> str1 = (Optional<Topics1>)topicRepo1.findById(orderId);
		    	st1 = str1.get().getStatus1();
		    	if(st1.equals("Complete"))
		    		st1="Completed";
			
		    }
		    catch(NoSuchElementException e1){
		    	st1= "Not Reached";
				flag=1;
		    }
		    
		    catch(RuntimeException e2){
	    		st3= "Not Connected";
	    	}
	    	catch(Exception e3) {
	    		e3.printStackTrace(System.out);
	    	}
		  //taking data from database 2 (Siebel) using findById() method
		    try{
		    	Optional<Topics2> str2 = (Optional<Topics2>)topicRepo2.findById(orderId);
		    	st2 = str2.get().getStatus2();
		    	if(st2.equals("Complete"))
					st2="Completed";
		    }
		    
		    catch(NoSuchElementException e1){
		    	if(flag==0)
		    		st2= "Not Reached";
		    	else
		    	    flag=1;	
			}
		    catch(RuntimeException e2){
	    		st3= "Not Connected";
	    	}
	    	catch(Exception e3) {
	    		e3.printStackTrace(System.out);
	    	}
		  //taking data from database 3 (AIA) using findById() method
		    try{
		    	Optional<Topics3> str3 = (Optional<Topics3>)topicRepo3.findById(orderId);
		    	st3 = str3.get().getStatus3();
			
		    	if(st3.equals("SentToAIA"))
		    		st3="Wait";
			
		    	if(st3.equals("ReceivedByAIA"))
		    		st3="InProgress";
			
		    	if(st3.equals("XREFUpdated"))
		    		st3="Completed";
		    }
				 
				catch(NoSuchElementException e1){
					if(flag==0)
			    		st3= "Not Reached";
					else
						flag=1;
				}
		    	catch(RuntimeException e2){
		    		st3= "Not Connected";
		    	}
		    	catch(Exception e3) {
		    		e3.printStackTrace(System.out);
		    	}
				
			
              //adding data in form of Topic class object to arrayList (topics)
             if(flag==0) {
            	  topics.add(new Topic(orderId,"Completed",st1,st2,st3,st3));
             }
             else {
            	 topics.add(new Topic(orderId,"Invalid Order ID","Invalid Order ID","Invalid Order ID","Invalid Order ID","Invalid Order ID"));

             }
		    
	  		}
	
	  //searching data from the above populated arrayList(topics) and storing it in another List (al)
	  for(String s2:arrInputOrder) {
	    finalList.add(topics.stream().filter(t -> t.getId().equalsIgnoreCase(s2)).findFirst().get());
	    }
	  
	  //returning the list
	  return finalList; 
	  
	  }


}
