package com.softitlan.tortuganinja.endpoints;

import com.softitlan.tortuganinja.repository.UserRepository;
import com.softitlan.tortuganinja.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("user")
@RestController()
public class UserEndPoint {

    @Autowired
    private UserServices userServices;


    @PostMapping("/getUser")
    //@CrossOrigin
    public boolean getUser(){
        System.out.println("Hola mozo");

        userServices.getListUser().forEach(e -> System.out.println("Hola " + e.getUsername() + " como estas 123!!!"));

        return false;
    }

    @GetMapping("/registerNewUser") // 💪
    public boolean registerNewUser(@RequestParam() Map<String, Object> data){
        if (validateUser(data.get("username").toString())){
            System.out.println(data.toString());
            return userServices.registerNewUser(data);
        }else{
            System.out.println("Usuario existente");
            return false;
        }
    }

    @GetMapping("/validateUser") // 💪
    public boolean validateUser(@RequestParam() String username){
        if (userServices.verifyUser(username).isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}
