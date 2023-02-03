package com.softitlan.tortuganinja.services.impl;

import com.softitlan.tortuganinja.model.AccountDTO;
import com.softitlan.tortuganinja.model.AccountVO;
import com.softitlan.tortuganinja.repository.AccountRepository;
import com.softitlan.tortuganinja.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountServices {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountDTO> getListAccount(Integer id_user){
        List<AccountVO> accountVOS = accountRepository.getListAccount(id_user);
        List<AccountDTO> accountDTOList = new ArrayList<>();

        accountVOS.forEach(e->accountDTOList.add(
                new AccountDTO(
                        e.getId(),
                        e.getId_user(),
                        e.getTitle(),
                        e.getLabel1(),
                        e.getLabel2(),
                        e.getLabel3(),
                        e.getLabel4(),
                        e.getLabel5(),
                        e.getValue1(),
                        e.getValue2(),
                        e.getValue3(),
                        e.getValue4(),
                        e.getValue5()
                )));

        return accountDTOList;
    }

    @Override
    public boolean insertAccount(Map<String, Object> datos){
        boolean flag = false;
        try {
            AccountVO accountVO = new AccountVO();
            accountVO.setId(null);
            accountVO.setId_user(Integer.parseInt(datos.get("id_user").toString()));
            accountVO.setTitle(datos.get("title").toString());
            accountVO.setLabel1(datos.get("label1").toString());
            accountVO.setLabel2(datos.get("label2").toString());
            accountVO.setLabel3(datos.get("label3").toString());
            accountVO.setLabel4(datos.get("label4").toString());
            accountVO.setLabel5(datos.get("label5").toString());
            accountVO.setValue1(datos.get("value1").toString());
            accountVO.setValue2(datos.get("value2").toString());
            accountVO.setValue3(datos.get("value3").toString());
            accountVO.setValue4(datos.get("value4").toString());
            accountVO.setValue5(datos.get("value5").toString());

            flag = true;

            accountRepository.save(accountVO);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return flag;
        /*
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
         */
    }

}
