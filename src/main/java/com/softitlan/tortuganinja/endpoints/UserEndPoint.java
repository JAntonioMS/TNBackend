package com.softitlan.tortuganinja.endpoints;

import mx.softitlan.utils.ResponseBody;
import mx.softitlan.utils.Utils;
import com.softitlan.tortuganinja.services.UserServices;
import mx.softitlan.utils.exception.AppException400BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static mx.softitlan.utils.Utils.response;
import static mx.softitlan.utils.Utils.validate400BadRequest;

@RequestMapping("user")
@RestController()
public class UserEndPoint {

    @Autowired
    private UserServices userServices;


    @PostMapping ("/registerNewUser") // 💪
    @CrossOrigin
    public Map<String, Object> registerNewUser(@RequestParam() Map<String, Object> data) {
        if (data.get("username") == null || data.get("password") == null || data.get("username").toString().isEmpty() || data.get("password").toString().isEmpty()) {
            Map<String, Object> response400BadRequest = new HashMap<>();
            response400BadRequest.put("responsecode", "400");
            response400BadRequest.put("message", "Bad Request");
            response400BadRequest.put("values", data );
            return response400BadRequest;
        }else {
            if (validateUser(data.get("username").toString())){
                Map<String, Object> response409UserExist = new HashMap<>();
                response409UserExist.put("responsecode", "409");
                response409UserExist.put("message", "User Exist");
                response409UserExist.put("values", data );
                return response409UserExist;
            }else{
                if (userServices.registerNewUser(data)){
                    Map<String, Object> response201UserSaved = new HashMap<>();
                    response201UserSaved.put("responsecode", "201");
                    response201UserSaved.put("message", "User Inserted");
                    response201UserSaved.put("values", data );
                    return response201UserSaved;
                }else {
                    Map<String, Object> response500ServerError = new HashMap<>();
                    response500ServerError.put("responsecode", "500");
                    response500ServerError.put("message", "Server Error");
                    response500ServerError.put("values", data );
                    return response500ServerError;
                }
            }
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
