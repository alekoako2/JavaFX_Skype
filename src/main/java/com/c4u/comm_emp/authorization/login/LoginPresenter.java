/*
 * package-info.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.authorization.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.c4u.comm_emp.User;
import com.c4u.comm_emp.service.CommEmpLogger;
import com.c4u.comm_emp.service.StageLoader;
import com.c4u.comm_emp.userPage.UserPageModel;
import com.c4u.comm_emp.userPage.UserPageModelImpl;
import com.c4u.comm_emp.userPage.UserPagePresenter;
import com.c4u.comm_emp.userPage.UserPageView;
import com.c4u.comm_emp.userPage.UserPageViewImpl;

import javafx.stage.Stage;

/**
 * Class that controls Login panel.
 **/
public class LoginPresenter
{

  private LoginView loginView;

  private LoginModel loginModel;

  private Stage primaryStage;

  /**
   * @return Stage
   */
  public Stage getPrimaryStage()
  {
    return primaryStage;
  }

  /**
   * @param theLoginView LoginView
   * @param theLoginModel LoginModel
   * @param thePrimaryStage Stage
   * @throws IOException
   */
  public LoginPresenter(final LoginView theLoginView, final LoginModel theLoginModel, final Stage thePrimaryStage)
      throws IOException
  {
    // TODO Auto-generated constructor stub

    this.loginView = theLoginView;
    this.loginModel = theLoginModel;
    this.primaryStage = thePrimaryStage;
    loginView.setEvents(this::validateEMail, this::validatePassword);
  }

  /**
   * 
   */
  void tryThis()
  {
    System.out.println("aq var");
  }

  /**
   * @throws SQLException
   */
  public void validateEMail()
      throws SQLException
  {
    System.out.println("presenterValimail");
    Boolean _approved = null;
    _approved = loginModel.validateEMail(loginView.getEMail());
    if (_approved)
    {
      loginView.emailPassed();
    }
    else
    {
      loginView.emailRejected();
    }
  }

  /**
   * @throws SQLException
   * @throws IOException
   */
  @SuppressWarnings("null")
  public void validatePassword()
      throws SQLException, IOException
  {
    System.out.println("presentervalipas");

    Boolean _approved = null;
    try
    {
      final ArrayList<Object> _arrayList = loginModel.signIn(loginView.getEMail(), loginView.getPassword());
      _approved = (Boolean) _arrayList.get(0);
      User.set_userId((int) _arrayList.get(1));
    }
    catch (final SQLException _e)
    {
      CommEmpLogger.logSQLException(_e);
    }
    if (_approved)
    {
      final UserPageViewImpl _userPageViewImpl = new StageLoader("/UserPage.fxml", getPrimaryStage(), 474, 688).getFxmlLoader()
          .getController();
      final UserPageModel _userPageModel = new UserPageModelImpl();
      final UserPageView _userPageView = _userPageViewImpl;
      System.out.println(primaryStage.alwaysOnTopProperty());
      new UserPagePresenter(_userPageView, _userPageModel, primaryStage);
    }
    else
    {
      loginView.passwordRejected();
    }

  }
}