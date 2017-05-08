/*
 * ClientPageViewImpl.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.userPage;

import java.io.IOException;

import com.c4u.comm_emp.Main;
import com.c4u.comm_emp.MakeDraggable;
import com.c4u.comm_emp.service.InitializePicture;
import com.c4u.comm_emp.service.WindowDecoration;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;

/**
 * TODO : Description.
 */
public class UserPageViewImpl extends UserPageNodes implements UserPageView
{

  WindowDecoration windowDecoration;

  final ToggleGroup employeesGroup = new ToggleGroup();

  /**
   * @throws IOException
   */
  @FXML
  private void initialize()
      throws IOException
  {
    initializeGUI();
  }

  /**
   * @throws IOException
   */
  private void initializeGUI()
      throws IOException
  {
    System.out.println("me var");
    // TODO Auto-generated method stub
    // getUserSearchTextField().requestFocus();
    windowDecoration = new WindowDecoration(getHeaderPane());
    windowDecoration.getBack().getBackLabel().setVisible(false);
    MakeDraggable.performDragg(Main.getPrimaryStage(), getHeaderPane());
    setPictures();
    setButtons();
  }

  /**
   * @throws IOException
   */
  void setPictures()
      throws IOException
  {
  }

  /**
   * 
   */
  void setButtons()
  {

  }

  @Override
  public void setUserData(final String theName, final String theActivityMessage, final String theAvailability,
      final String theImageUrl)
      throws IOException
  {
    // TODO Auto-generated method stub
    getUserNameLabel().setText(theName);
    getActivityMessageTextField().setText(theActivityMessage);
    System.out.println(theAvailability);
    getUserImageCircle().setFill(new ImagePattern(new InitializePicture(theImageUrl).getImage()));

  }

  @Override
  public void setEmployee(final int theEmployeeId, final String theName, final String theActivityMessage,
      final Boolean theOnlineStatus, final String theAvailability, final String theImageUrl)
      throws IOException
  {
    // TODO Auto-generated method stub
    final Pane _employeePane = new FlowPane();
    final Pane _pane = new Pane();
    _pane.setTranslateX(20);
    final Pane _nameActivityPane = new Pane();
    _nameActivityPane.setLayoutX(55);
    final Label _nameLabel = new Label(theName);
    _nameLabel.setLayoutX(3);
    _nameLabel.setLayoutY(11);
    _nameLabel.setStyle("-fx-font-size:16px;-fx-text-fill:black");
    final Label _activityLabel = new Label(theActivityMessage);
    _activityLabel.setLayoutX(4);
    _activityLabel.setLayoutY(32);
    _activityLabel.setStyle("-fx-text-fill:gray");
    _nameActivityPane.getChildren().addAll(_nameLabel, _activityLabel);
    final Pane _picturePane = new Pane();
    _picturePane.setPrefWidth(50);
    _picturePane.setPrefHeight(50);
    _picturePane.setLayoutY(6);
    _picturePane.setStyle("-fx-background-radius:50;-fx-background-color:white");
    final Circle _circle = new Circle(25);
    _circle.setFill(javafx.scene.paint.Color.WHITE);
    _circle.setLayoutX(25);
    _circle.setLayoutY(25);
    _circle.setStrokeWidth(0);
    if (theImageUrl != null)
    {
      _circle.setFill(new ImagePattern(new InitializePicture(theImageUrl).getImage()));
    }
    else
    {
      _circle.setFill(new ImagePattern(new InitializePicture("userPicture").getImage()));
    }
    final Pane _availabilityPane = new Pane();
    _availabilityPane.setPrefWidth(20);
    _availabilityPane.setPrefHeight(21);
    _availabilityPane.setLayoutX(30);
    _availabilityPane.setLayoutY(30);
    final Circle _availabilityCircle = new Circle(10);
    _availabilityCircle.setLayoutX(10);
    _availabilityCircle.setLayoutY(10);
    _availabilityCircle.setFill(javafx.scene.paint.Color.WHITE);

    final Label _availabilityLabel = new Label("✔");
    _availabilityLabel.setTextAlignment(TextAlignment.CENTER);
    _availabilityLabel.setAlignment(Pos.CENTER);
    _availabilityLabel.setPrefWidth(14);
    _availabilityLabel.setPrefHeight(14);
    _availabilityLabel.setLayoutX(3);
    _availabilityLabel.setLayoutY(3);
    _availabilityLabel.setStyle(
        "-fx-background-color:green;-fx-background-radius:100;-fx-font-size:11px;-fx-font-weight:bold;-fx-text-fill:white;");

    _availabilityPane.getChildren().addAll(_availabilityCircle, _availabilityLabel);

    _picturePane.getChildren().addAll(_circle, _availabilityPane);

    final ToggleButton _favoriteToggleBtn = new ToggleButton("★");
    _favoriteToggleBtn.getStyleClass().addAll("favoriteStar");
    _favoriteToggleBtn.setTextAlignment(TextAlignment.CENTER);
    _favoriteToggleBtn.setLayoutX(300);
    _favoriteToggleBtn.setLayoutY(10);

    _pane.getChildren().addAll(_picturePane, _nameActivityPane, _favoriteToggleBtn);

    _employeePane.getChildren().addAll(_pane);

    final ToggleButton _toggleButton = new ToggleButton();
    _toggleButton.setCache(true);
    _toggleButton.getStyleClass().addAll("employeesBtn");
    _toggleButton.setToggleGroup(employeesGroup);
    _toggleButton.setPrefWidth(400);
    _toggleButton.setPrefHeight(70);
    _toggleButton.setGraphic(_employeePane);
//    _toggleButton.setId(theEmployeeId+);
    getEmployeesFlowPane().getChildren().addAll(_toggleButton);

    System.out.println(theEmployeeId);
    System.out.println(theName);
    System.out.println(theActivityMessage);
    System.out.println(theOnlineStatus);
    System.out.println(theAvailability);
    System.out.println(theImageUrl);
  }
}