/*
 * LoginModel.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.authorization.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c4u.comm_emp.service.ConnectionClass;

/**
 * TODO : Description.
 *
 * @author aphatsatsia
 */
public class LoginModelImpl implements LoginModel
{
  @SuppressWarnings("resource")
  @Override
  public ArrayList<Object> signIn(final String theEMail, final String thePassword)
      throws SQLException
  {
    final ResultSet _resultSet = new ConnectionClass("select * from validation('" + theEMail + "','" + thePassword + "');")
        .getResultSet();

    final ArrayList<Object> _arrayList = new ArrayList<>();
    while (_resultSet.next())
    {
      _arrayList.add(0, _resultSet.getBoolean(1));
      _arrayList.add(1, _resultSet.getInt(2));
      _arrayList.add(2, _resultSet.getString(3));
    }

    return _arrayList;
  }

  @SuppressWarnings("resource")
  @Override
  public Boolean validateEMail(final String theEMail)
      throws SQLException
  {

    final ResultSet _resultSet = new ConnectionClass("select * from email_validator('" + theEMail + "');").getResultSet();
    boolean _approved = false;
    while (_resultSet.next())
    {
      _approved = _resultSet.getBoolean(1);
    }
    // TODO Auto-generated method stub
    System.out.println(_approved);
    return _approved;
  }
}
