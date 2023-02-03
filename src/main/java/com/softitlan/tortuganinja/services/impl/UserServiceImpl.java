package com.softitlan.tortuganinja.services.impl;

import com.softitlan.tortuganinja.model.UserDTO;
import com.softitlan.tortuganinja.model.UserVO;
import com.softitlan.tortuganinja.repository.UserRepository;
import com.softitlan.tortuganinja.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean registerNewUser(Map<String, Object> datos) {
        boolean flag = false;
        try {
            UserVO userVO = new UserVO();
            userVO.setId(null);
            userVO.setUsername(datos.get("username").toString());
            userVO.setPassword(datos.get("password").toString());

            flag = true;

            userRepository.save(userVO);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return flag;
    }

    @Override
    public List<UserDTO> verifyUser(String username) {
        List<UserVO> userVOS = userRepository.verifyUserExist(username);
        List<UserDTO> userDTOList = new ArrayList<>();

        userVOS.forEach(e -> userDTOList.add(new UserDTO(e.getId(), e.getUsername(), e.getPassword())));

        return userDTOList;
    }
}
