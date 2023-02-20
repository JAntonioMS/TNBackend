package com.softitlan.tortuganinja.endpoints;

import com.softitlan.tortuganinja.repository.AccountRepository;
import com.softitlan.tortuganinja.services.AccountServices;
import com.softitlan.tortuganinja.services.UserServices;
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

    @Autowired
    private UserServices userServices;
    //
    @GetMapping("/getAccounts")
    public boolean getAccounts(@RequestParam() Integer id_user){
        accountServices.getListAccount(id_user).forEach(e->System.out.println("Esta es la cuenta de " + e.getTitle()+" con las tipo" + e.getLabel1()+" Con la contrasena"+e.getValue1()+" con la segunda label2 las tipo" + e.getLabel2()+" Con la contrasena"+e.getValue2()));
        return true;
    }

    //@GetMapping("/saveAccount")
    @PostMapping("/saveAccount")
    @CrossOrigin
    public boolean saveAccount(@RequestParam() Map<String, Object> datos, String username, String password){
        if (userServices.verifyUser(username).isEmpty()){
            return false;
        }else{
            if (datos.get("idAccount") == null){
                return accountServices.insertAccount(datos);
            }else{
                System.out.println("PAso por aqui");
                return accountServices.updateAccount(datos);
            }
        }
    }

    @PostMapping("/deleteAccount")
    public boolean deleteAccount(@RequestParam() String username, Integer idAccount, String password){
        if( username == null || idAccount == null || password == null){
            System.out.println("Faltan parametros");
            return false;
        }else {
            if (userServices.verifyUser(username).isEmpty()){
                System.out.println("El usuario no existe");
                return false;
            }else {
                accountServices.deleteAccount(username, idAccount, password);
            }
        }
        return true;
    }
}
