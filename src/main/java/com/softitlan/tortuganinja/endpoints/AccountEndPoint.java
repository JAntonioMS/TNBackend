package com.softitlan.tortuganinja.endpoints;

import com.softitlan.tortuganinja.repository.AccountRepository;
import com.softitlan.tortuganinja.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("account")
@RestController()
public class AccountEndPoint {

    //@Autowired
    //private AccountRepository accountRepository;

    @Autowired
    private AccountServices accountServices;

    //
    @GetMapping("/getAccounts")
    public boolean getAccounts(@RequestParam() Integer id_user){
        accountServices.getListAccount(id_user).forEach(e->System.out.println("Esta es la cuenta de " + e.getTitle()+" con las tipo" + e.getLabel1()+" Con la contrasena"+e.getValue1()+" con la segunda label2 las tipo" + e.getLabel2()+" Con la contrasena"+e.getValue2()));
        return true;
    }

    //@GetMapping("/saveAccount")
    @PostMapping("/saveAccount")
    public boolean saveAccount(@RequestParam() Map<String, Object> datos){
        return accountServices.insertAccount(datos);
        /*
        if (validateUser(data.get("username").toString())){
            System.out.println(data.toString());
            return userServices.registerNewUser(data);
        }else{
            System.out.println("Usuario existente");
            return false;
        }
         */
    }

    /*
    @Override
    public boolean updateCliente(String id, Map<String, Object> datostoUpdate) {
        boolean flag = false;

        try {
            Optional<ClienteVO> clienteVO = clienteRepository.findById(Integer.parseInt(id));

            if ( clienteVO.isPresent() ){
                clienteVO.get().setCorreo( datostoUpdate.get("correo").toString() );
                clienteRepository.save(clienteVO.get());
                flag = true;
            }else throw new Exception();

        }catch (Exception e){
            System.out.println(e.getCause() + e.getMessage());
        }

        return flag;
    }

     */
}
