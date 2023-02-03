package com.softitlan.tortuganinja.services;

import com.softitlan.tortuganinja.model.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserServices {

    List<UserDTO> verifyUser(String username);

    boolean registerNewUser(Map<String, Object> datos);
}
