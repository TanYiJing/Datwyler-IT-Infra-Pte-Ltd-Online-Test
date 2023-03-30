package com.example.onlineAssessment.infra.DAL;

import com.example.onlineAssessment.infra.DAO.UserDAO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAL {
    UserDAO queryUserInfoByUsername(String username);

    boolean insertUserInfo(String username, String clientNo, String name, String password, String salt);
}
