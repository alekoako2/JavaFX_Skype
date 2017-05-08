/*
 * ClientPageModelImpl.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.userPage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.c4u.comm_emp.service.ConnectionClass;

/**
 * TODO : Description.
 */
public class UserPageModelImpl implements UserPageModel
{

  @SuppressWarnings("resource")
  @Override
  public ArrayList<Object> loadUserData(final int theUserId)
      throws SQLException, IOException
  {
    // TODO Auto-generated method stub
    final ResultSet _resultSet = new ConnectionClass("select * from get_user_data('" + theUserId + "');").getResultSet();

    final ArrayList<Object> _arrayList = new ArrayList<>();
    while (_resultSet.next())
    {
      _arrayList.add(0, _resultSet.getString(1));
      _arrayList.add(1, _resultSet.getString(2));
      _arrayList.add(2, _resultSet.getString(3));
      _arrayList.add(3, _resultSet.getString(4));
      _arrayList.add(4, _resultSet.getString(5));
    }

    return _arrayList;
  }

  @SuppressWarnings("resource")
  @Override
  public HashMap<String, ArrayList<Object>> loadEmployeesData(final int theUserId)
      throws SQLException
  {
    // TODO Auto-generated method stub
    final ResultSet _resultSet = new ConnectionClass("select * from get_employees_data('" + theUserId + "');").getResultSet();

    final HashMap<String, ArrayList<Object>> _hashMap = new HashMap<>();
    while (_resultSet.next())
    {
      final ArrayList<Object> _arrayList = new ArrayList<>();
      _arrayList.add(0, _resultSet.getInt(1));
      _arrayList.add(1, _resultSet.getString(2));
      _arrayList.add(2, _resultSet.getString(3));
      _arrayList.add(3, _resultSet.getString(4));
      _arrayList.add(4, _resultSet.getBoolean(5));
      _arrayList.add(5, _resultSet.getString(6));
      _arrayList.add(6, _resultSet.getString(7));
      _hashMap.put(_resultSet.getString(1), _arrayList);
    }

    return _hashMap;
  }

}
