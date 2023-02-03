package com.softitlan.tortuganinja.repository;

import com.softitlan.tortuganinja.model.AccountVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository<AccountVO, Integer> {

    List<AccountVO> getListAccount(@Param("id_user") Integer id_user);

}
