/*
 * LoginView.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.authorization.login;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aphatsatsia on 06.12.16.
 */
public interface LoginModel
{
  /**
   * @param theEMail String
   * @param thePassword String
   * @return Boolean
   * @throws SQLException
   */
  ArrayList<Object> signIn(String theEMail, String thePassword)
      throws SQLException;

  /**
   * @param theEMail String
   * @return Boolean
   * @throws SQLException 
   */
  Boolean validateEMail(String theEMail) throws SQLException;
}