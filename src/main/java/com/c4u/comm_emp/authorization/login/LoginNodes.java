/*
 * LoginNodes.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.authorization.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * TODO : Description.
 */
public abstract class LoginNodes
{
  @FXML
  private Pane signInPane;

  @FXML
  private Pane headerPane;

  @FXML
  private Pane emailPane;

  @FXML
  private Pane passwordPane;

  @FXML
  private TextField emailfield;

  @FXML
  private TextField passwordField;

  @FXML
  private Label signIn;

  @FXML
  private Label warningLabel;

  /**
   * @return Pane
   */
  public Pane getSignInPane()
  {
    return signInPane;
  }

  /**
   * @return Pane
   */
  public Pane getHeaderPane()
  {
    return headerPane;
  }

  /**
   * @return Pane
   */
  public Pane getEmailPane()
  {
    return emailPane;
  }

  /**
   * @return Pane
   */
  public Pane getPasswordPane()
  {
    return passwordPane;
  }

  /**
   * @return TextField
   */
  public TextField getEmailfield()
  {
    return emailfield;
  }

  /**
   * @return TextField
   */
  public TextField getPasswordField()
  {
    return passwordField;
  }

  /**
   * @return Label
   */
  public Label getSignIn()
  {
    return signIn;
  }

  /**
   * @return Label
   */
  public Label getWarningLabel()
  {
    return warningLabel;
  }
}
