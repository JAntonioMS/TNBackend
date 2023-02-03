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


    @PostMapping ("/registerNewUser") // 💪
    @CrossOrigin
    public boolean registerNewUser(@RequestParam() Map<String, Object> data){
        if (validateUser(data.get("username").toString())){
            System.out.println("Usuario existente");
            return false;
        }else{
            System.out.println(data.toString());
            return userServices.registerNewUser(data);
        }
    }

    @PostMapping("/validateUser") // 💪
    @CrossOrigin
    public boolean validateUser(@RequestParam() String username){
        if (userServices.verifyUser(username).isEmpty()){
            return false;
        }else{
            return true;
        }
    }

}
