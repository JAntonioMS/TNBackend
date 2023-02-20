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
import java.util.Optional;

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

            if( datos.get("label2") != null ) {
                accountVO.setLabel2(datos.get("label2").toString());
            }

            if( datos.get("label3") != null ) {
                accountVO.setLabel3(datos.get("label3").toString());
            }

            if( datos.get("label4") != null ) {
                accountVO.setLabel4(datos.get("label4").toString());
            }

            if( datos.get("label5") != null ) {
                accountVO.setLabel5(datos.get("label5").toString());
            }

            accountVO.setValue1(datos.get("value1").toString());

            if( datos.get("value2") != null ) {
                accountVO.setValue2(datos.get("value2").toString());
            }

            if( datos.get("value3") != null ) {
                accountVO.setValue3(datos.get("value3").toString());
            }

            if( datos.get("value4") != null ) {
                accountVO.setValue4(datos.get("value4").toString());
            }

            if( datos.get("value5") != null ) {
                accountVO.setValue5(datos.get("value5").toString());
            }

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

    @Override
    public boolean deleteAccount(String username, Integer idAccount, String password){
        boolean flag = false;
        try{
            accountRepository.deleteById(idAccount);
            flag = true;
        }catch (Exception e){
            System.out.println(e.getCause() + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean updateAccount(Map<String, Object> datos) {
        boolean flag = false;
        try {
            Optional<AccountVO> accountVO = accountRepository.findById(Integer.parseInt(datos.get("idAccount").toString()));

            if ( accountVO.isPresent() ){

                if(datos.get("title") != null){
                    accountVO.get().setTitle(datos.get("title").toString());
                }

                if (datos.get("label1") != null){
                    accountVO.get().setLabel1(datos.get("label1").toString());
                }

                if (datos.get("label2") != null){
                    accountVO.get().setLabel2(datos.get("label2").toString());
                }

                if (datos.get("label3") != null){
                    accountVO.get().setLabel3(datos.get("label3").toString());
                }

                if (datos.get("label4") != null){
                    accountVO.get().setLabel4(datos.get("label4").toString());
                }

                if (datos.get("label5") != null){
                    accountVO.get().setLabel5(datos.get("label5").toString());
                }

                if (datos.get("value1") != null){
                    accountVO.get().setValue1(datos.get("value1").toString());
                }

                if (datos.get("value2") != null){
                    accountVO.get().setValue2(datos.get("value2").toString());
                }

                if (datos.get("value3") != null){
                    accountVO.get().setValue3(datos.get("value3").toString());
                }

                if (datos.get("value4") != null){
                    accountVO.get().setValue4(datos.get("value4").toString());
                }

                if (datos.get("value5") != null){
                    accountVO.get().setValue5(datos.get("value5").toString());
                }
                accountRepository.save(accountVO.get());
                flag = true;
            }else throw new Exception();
        }catch (Exception e) {
            System.out.println(e.getCause() + e.getMessage());
        }
        return flag;
    }
}

