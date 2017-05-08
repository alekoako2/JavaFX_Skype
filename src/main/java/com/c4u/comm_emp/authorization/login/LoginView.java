/*
 * LoginView.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.authorization.login;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by aphatsatsia on 06.12.16.
 */
public interface LoginView
{
  /**
   * @return String
   */
  String getEMail();

  /**
   * @return String
   */
  String getPassword();

  /**
   *
   */
  void emailPassed();

  /**
   *
   */
  void emailRejected();

  /**
   *
   */
  void passwordPassed();

  /**
   *
   */
  void passwordRejected();

  /**
   *
   */
  void setBack();

  /**
   * TODO : Description.
   */
  interface ValidateEmail
  {
    /**
     * @throws SQLException
     */
    void validateEMail()
        throws SQLException;
  }

  /**
   * TODO : Description.
   */
  interface ValidatePassword
  {
    /**
     * @throws IOException
     * @throws SQLException
     */
    void validatePassword()
        throws IOException, SQLException;
  }

  /**
   * @param theValidateEmail ValidateEmail
   * @param theValidatePassword ValidatePassword
   */
  void setEvents(ValidateEmail theValidateEmail, ValidatePassword theValidatePassword);
}
