/*
 * Back.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.service;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * TODO : Description.
 */
public class Back
{
  Label backLabel;

  /**
   * @return Label
   */
  public Label getBackLabel()
  {
    return backLabel;
  }

  /**
   * @param thePane Pane
   */
  public Back(final Pane thePane)
  {
    // TODO Auto-generated constructor stub
    final Label _backLabel = new Label("↰");
    _backLabel.getStyleClass().addAll("stageDecorationButtons");
    _backLabel.setStyle("-fx-rotate:0 !important;");
    _backLabel.setAlignment(Pos.CENTER);
    _backLabel.setPrefWidth(25);
    _backLabel.setPrefHeight(25);
    _backLabel.setLayoutX(10);
    _backLabel.setLayoutY(7);
    thePane.getChildren().addAll(_backLabel);
    this.backLabel = _backLabel;
  }
}
