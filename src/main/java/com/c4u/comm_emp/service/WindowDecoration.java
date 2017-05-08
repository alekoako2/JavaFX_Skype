/*
 * WindowDecoration.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.service;

import java.io.IOException;

import com.c4u.comm_emp.Main;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * TODO : Description.
 */
public class WindowDecoration
{
  Pane decorationPane;

  Back back;

  /**
   * @return Back
   */
  public Back getBack()
  {
    return back;
  }

  /**
   * @param thePane Pane
   */
  public WindowDecoration(final Pane thePane)
  {
    // TODO Auto-generated constructor stub
    this.back = new Back(thePane);
    final FlowPane _flowPane = new FlowPane();
    _flowPane.getChildren().addAll(minimize(), exit());
    _flowPane.setHgap(5);
    _flowPane.setLayoutX(thePane.getPrefWidth() - 50);
    _flowPane.setLayoutY(5);
    thePane.getChildren().addAll(_flowPane);
  }

  /**
   * @return Label
   */
  private Label back()
  {
    final Label _backLabel = new Label("↰");
    _backLabel.getStyleClass().addAll("stageDecorationButtons");
    _backLabel.setStyle("-fx-rotate:0 !important;");
    _backLabel.setAlignment(Pos.CENTER);
    _backLabel.setPrefWidth(25);
    _backLabel.setPrefHeight(25);
    _backLabel.setLayoutX(10);
    _backLabel.setLayoutY(7);
    return _backLabel;
  }

  /**
   * @return Label
   */
  private Label exit()
  {
    final Label _exitLabel = new Label("X");
    _exitLabel.getStyleClass().addAll("stageDecorationButtons");
    _exitLabel.setAlignment(Pos.CENTER);
    _exitLabel.setPrefWidth(20);
    _exitLabel.setPrefHeight(20);
    // _exitLabel.setLayoutX(thePane.getPrefWidth() - 23);
    _exitLabel.setLayoutY(7);
    _exitLabel.setOnMouseClicked(new EventHandler<Event>()
    {

      @Override
      public void handle(final Event theEvent)
      {
        // TODO Auto-generated method stub
        Main.getPrimaryStage().setIconified(true);
      }
    });
    return _exitLabel;
  }

  /**
   * @return Label
   */
  private Label minimize()
  {
    final Label _minimizeLabel = new Label("^");
    _minimizeLabel.getStyleClass().addAll("stageDecorationButtons");
    _minimizeLabel.setAlignment(Pos.CENTER);
    _minimizeLabel.setPrefWidth(20);
    _minimizeLabel.setPrefHeight(20);
    _minimizeLabel.setLayoutX(10);
    _minimizeLabel.setLayoutY(7);
    _minimizeLabel.setOnMouseClicked(new EventHandler<Event>()
    {

      @Override
      public void handle(final Event theEvent)
      {
        // TODO Auto-generated method stub
        Main.getPrimaryStage().hide();
        try
        {
          final Stage _minimizedStage = new Stage();
          // setMinimizedStage(_minimizedStage);
          final FXMLLoader _fxmlLoader = new FXMLLoader(getClass().getResource("/Minimized.fxml"));
          final StackPane _stackPane = (StackPane) _fxmlLoader.load();
          _stackPane.setStyle("-fx-background-color:null");
          final Scene _scene = new Scene(_stackPane, 100, 100, Color.TRANSPARENT);
          // _scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
          _minimizedStage.initStyle(StageStyle.TRANSPARENT);
          _minimizedStage.setScene(_scene);
          // _minimizedStage.setX(width - 100);
          _minimizedStage.setY(0);
          _minimizedStage.show();
        }
        catch (final IOException _e)
        {
          // TODO Auto-generated catch block
          CommEmpLogger.logIOException(_e);
        }

      }
    });
    return _minimizeLabel;
  }
}
