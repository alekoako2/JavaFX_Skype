/*
 * package-info.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp;

import java.io.IOException;
import java.sql.SQLException;

import com.c4u.comm_emp.authorization.login.LoginModel;
import com.c4u.comm_emp.authorization.login.LoginModelImpl;
import com.c4u.comm_emp.authorization.login.LoginPresenter;
import com.c4u.comm_emp.authorization.login.LoginView;
import com.c4u.comm_emp.authorization.login.LoginViewImpl;
import com.c4u.comm_emp.service.StageLoader;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * TODO : Description.
 */
public class Main extends Application
{
  private static Stage primaryStage;

  /**
   * @return Stage
   */
  public static Stage getPrimaryStage()
  {
    return primaryStage;
  }

  /**
   * @param thePrimaryStage Stage
   */
  public void setPrimaryStage(final Stage thePrimaryStage)
  {
    primaryStage = thePrimaryStage;
  }

  /**
   * {@inheritDoc}
   *
   * @param thePrimaryStage Stage
   * @throws IOException
   */
  @Override
  public void start(final Stage thePrimaryStage)
      throws IOException, NoSuchMethodException, SQLException
  {
    setPrimaryStage(thePrimaryStage);
    thePrimaryStage.initStyle(StageStyle.TRANSPARENT);
    final LoginViewImpl _loginViewImpl = new StageLoader("/Login.fxml", getPrimaryStage(), 550, 450).getFxmlLoader()
        .getController();
    thePrimaryStage.setResizable(false);
    final LoginModel _loginModel = new LoginModelImpl();
    final LoginView _loginView = _loginViewImpl;
    System.out.println(thePrimaryStage.alwaysOnTopProperty());
    new LoginPresenter(_loginView, _loginModel, thePrimaryStage);
//    final UserPageViewImpl _userPageViewImpl = new StageLoader("/Login2.fxml", getPrimaryStage(), 550, 800).getFxmlLoader()
//        .getController();
//    final UserPageModel _userPageModel= new UserPageModelImpl();
//    final UserPageView _userPageView = _userPageViewImpl;
//    System.out.println(primaryStage.alwaysOnTopProperty());
//    new UserPagePresenter(_userPageView, _userPageModel, primaryStage);
  }

  /**
   * @param aString String
   * @throws IOException
   */
  public static void main(final String[] aString)
      throws IOException
  {
    // TODO Auto-generated method stub
    launch(aString);

  }

}
