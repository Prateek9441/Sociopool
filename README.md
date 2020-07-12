# Sociopool
Sociopool Assignment

Two rest endpoint has been created and can be checked with postman.   

1.  To save distance, following json format will be used on url "localhost:8085/save" :     
        {   
	"userName":"abcd",   
	"distance":"80",   
	"date":"25/10/2009",  
	"time":"01:30"  
   	}      
  
2. To get the distance, following json format will be used on url "localhost:8085/get" :   

  {     
	"userName":"abcd",    
	"startTime":"24/10/2009 23:30",   
	"endTime":"25/10/2009 01:15"   	
  }    
     
  Note: Time will be in 24 hours.And date will be in above given format i.e day/Month/year format.
  

