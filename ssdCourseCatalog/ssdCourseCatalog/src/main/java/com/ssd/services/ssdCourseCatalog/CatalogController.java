package com.ssd.services.ssdCourseCatalog;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CatalogController {

    @Autowired
    EurekaClient client;

    @RequestMapping("/")
    @HystrixCommand(fallbackMethod = "displayDefaultHome")
    public String getCatalogHome(){
        String courseMessage = "";
        //String courseAppURL = "http://localhost:8080";

        RestTemplate restTemplate = new RestTemplate();
        InstanceInfo instanceInfo =  client.getNextServerFromEureka("fx-course-service",false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseMessage = restTemplate.getForObject(courseAppURL,String.class);


        return ("Welcome to CourseApp Course catalog: " + courseMessage);
    }
    public String displayDefaultHome(){
        return ("Welcome to CourseApp Course catalog: PLEASE TRY AFTER SOME TIME");
    }
    @RequestMapping("/catalog")
    public String getCatalog(){
        String courses = "";
        //String courseAppURL = "http://localhost:8080/courses";
        InstanceInfo instanceInfo =  client.getNextServerFromEureka("fx-course-service",false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL += "/courses";
        RestTemplate restTemplate = new RestTemplate();
        courses = restTemplate.getForObject(courseAppURL,String.class);


        return ("Our Courses are: " + courses);
    }

    @RequestMapping("/firstcourse")
    public  String getSpecificCourse(){
        Course courses = new Course();
        User user = new User();
        //String courseAppURL = "http://localhost:8080/1";
        InstanceInfo instanceInfo =  client.getNextServerFromEureka("fx-course-service",false);
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL += "/1";
        RestTemplate restTemplate = new RestTemplate();
        courses = restTemplate.getForObject(courseAppURL,Course.class);

        instanceInfo =  client.getNextServerFromEureka("fx-user-service",false);
        String userAppURL = instanceInfo.getHomePageUrl();
        userAppURL += "/" + courses.getCourseid();
        String userList = restTemplate.getForObject(userAppURL,String.class);


        return ("Our First Courses is: " + courses.getCoursename() + "******** Users registered" + userList );
    }
}
