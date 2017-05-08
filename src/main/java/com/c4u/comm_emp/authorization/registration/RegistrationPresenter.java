/*
 * package-info.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.authorization.registration;

import javafx.stage.Stage;

/**
 * TODO : Description.
 */
public class RegistrationPresenter
{
  private RegistrationView registrationView;

  private RegistrationModel registrationModel;

  private Stage primaryStage;

  /**
   * @param theRegistrationView RegistrationView
   * @param theRegistrationModel RegistrationModel
   * @param thePrimaryStage Stage
   */
  public RegistrationPresenter(final RegistrationView theRegistrationView, final RegistrationModel theRegistrationModel,
      final Stage thePrimaryStage)
  {
    // TODO Auto-generated constructor stub
    this.registrationView = theRegistrationView;
    this.registrationModel = theRegistrationModel;
    this.primaryStage = thePrimaryStage;
  }
}