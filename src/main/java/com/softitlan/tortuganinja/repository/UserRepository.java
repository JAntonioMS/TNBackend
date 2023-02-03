package com.softitlan.tortuganinja.repository;

import com.softitlan.tortuganinja.model.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Integer> {

    List<UserVO> getUser();

    List<UserVO> verifyUserExist(@Param("username") String username);

}
