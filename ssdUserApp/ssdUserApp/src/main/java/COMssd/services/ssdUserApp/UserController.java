package COMssd.services.ssdUserApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public List<User> getUser(){

        return userRepository.findAll();

    }
    @RequestMapping("/{id}")
    public List<User> getUserForaCourse(@PathVariable("id") BigInteger id){

        return userRepository.findBycourseid(id);

    }
}
