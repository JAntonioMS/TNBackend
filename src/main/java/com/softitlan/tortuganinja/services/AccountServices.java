package com.softitlan.tortuganinja.services;

import com.softitlan.tortuganinja.model.AccountDTO;
import com.softitlan.tortuganinja.model.UserDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface AccountServices {

    List<AccountDTO> getListAccount(Integer id_user);

    boolean insertAccount(Map<String, Object> datos);

    boolean deleteAccount(String username, Integer idAccount, String password);

    boolean updateAccount(Map<String, Object> datos);
}
