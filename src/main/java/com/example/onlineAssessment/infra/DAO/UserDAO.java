package com.example.onlineAssessment.infra.DAO;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yijing.tan
 */

@Data
public class UserDAO  {


   private String clientNo;

   private String username;

   private String name;

   private String password;

   private String salt;

}
