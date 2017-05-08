/*
 * ClientPagePresenter.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.userPage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.c4u.comm_emp.User;

import javafx.stage.Stage;

/**
 * TODO : Description.
 */
public class UserPagePresenter
{
  private UserPageView userPageView;

  private UserPageModel userPageModel;

  private Stage primaryStage;

  /**
   * @param theUserPageView UserPageView
   * @param theUserPageModel UserPageModel
   * @param thePrimaryStage Stage
   * @throws IOException
   * @throws SQLException
   */
  public UserPagePresenter(final UserPageView theUserPageView, final UserPageModel theUserPageModel,
      final Stage thePrimaryStage)
      throws IOException, SQLException
  {
    // TODO Auto-generated constructor stub
    this.userPageView = theUserPageView;
    this.userPageModel = theUserPageModel;
    this.primaryStage = thePrimaryStage;
    // userPageView.setEvents(this::validateEMail, this::validatePassword);
    setUser();
    setEmployees();
  }

  /**
   * @throws SQLException
   * @throws IOException
   */
  void setUser()
      throws SQLException, IOException
  {
    final ArrayList<Object> _arrayList = userPageModel.loadUserData(User.get_userId());
    userPageView.setUserData((String) _arrayList.get(0) + " " + (String) _arrayList.get(1), (String) _arrayList.get(2),
        (String) _arrayList.get(3), (String) _arrayList.get(4));
  }

  /**
   * @throws SQLException
   * @throws IOException
   */
  void setEmployees()
      throws SQLException, IOException
  {
    final HashMap<String, ArrayList<Object>> _hashMap = userPageModel.loadEmployeesData(User.get_userId());
    for (final Entry<String, ArrayList<Object>> _iterable_element : _hashMap.entrySet())
    {
      final ArrayList<Object> _arrayList = _iterable_element.getValue();
      userPageView.setEmployee((int) _arrayList.get(0), (String) _arrayList.get(1) + " " + (String) _arrayList.get(2),
          (String) _arrayList.get(3), (Boolean) _arrayList.get(4), (String) _arrayList.get(5), (String) _arrayList.get(6));
    }
  }

}
