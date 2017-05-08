/*
 * UserPageNodes.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.userPage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

/**
 * TODO : Description.
 */
public class UserPageNodes
{

  @FXML
  private Pane headerPane;

  @FXML
  private Circle userImageCircle;

  @FXML
  private Circle employeeImageCircle;

  @FXML
  private Label userNameLabel;

  @FXML
  private TextField activityMessageTextField;

  @FXML
  private TextField userSearchTextField;

  @FXML
  private ToggleButton userAccountsToggleButton;

  @FXML
  private ToggleButton userSettingsToggleButton;

  @FXML
  private FlowPane employeesFlowPane;

  /**
   * @return Pane
   */
  public Pane getHeaderPane()
  {
    return headerPane;
  }

  /**
   * @return Circle
   */
  public Circle getUserImageCircle()
  {
    return userImageCircle;
  }

  /**
   * @return Circle
   */
  public Circle getEmployeeImageCircle()
  {
    return employeeImageCircle;
  }

  /**
   * @return Label
   */
  public Label getUserNameLabel()
  {
    return userNameLabel;
  }

  /**
   * @return TextField
   */
  public TextField getActivityMessageTextField()
  {
    return activityMessageTextField;
  }

  /**
   * @return TextField
   */
  public TextField getUserSearchTextField()
  {
    return userSearchTextField;
  }

  /**
   * @return ToggleButton
   */
  public ToggleButton getUserAccountsToggleButton()
  {
    return userAccountsToggleButton;
  }

  /**
   * @return ToggleButton
   */
  public ToggleButton getUserSettingsToggleButton()
  {
    return userSettingsToggleButton;
  }

  /**
   * @return FlowPane
   */
  public FlowPane getEmployeesFlowPane()
  {
    return employeesFlowPane;
  }
}
