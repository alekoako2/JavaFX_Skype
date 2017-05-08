/*
 * StageLoader.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.service;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * TODO : Description.
 */

public class StageLoader
{

  private FXMLLoader fxmlLoader;

  /**
   * @param theFxmlFileName String
   * @param thePrimaryStage Stage
   * @param theWidth int
   * @param theHeight int
   * @throws IOException
   */
  public StageLoader(final String theFxmlFileName, final Stage thePrimaryStage, final int theWidth, final int theHeight)
      throws IOException
  {
    final FXMLLoader _fxmlLoader = new FXMLLoader(getClass().getResource(theFxmlFileName));
    final StackPane _borderPane = (StackPane) _fxmlLoader.load();
    _borderPane.setStyle("-fx-background-color:null");
    final Scene _scene = new Scene(_borderPane, theWidth, theHeight, Color.TRANSPARENT);
    _scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
    thePrimaryStage.setScene(_scene);
    // thePrimaryStage.initModality(Modality.WINDOW_MODAL);
    thePrimaryStage.show();
    setFxmlLoader(_fxmlLoader);
  }

  /**
   * @return FXMLLoader
   */
  public FXMLLoader getFxmlLoader()
  {
    return fxmlLoader;
  }

  /**
   * @param theFxmlLoader FXMLLoader
   */
  public void setFxmlLoader(final FXMLLoader theFxmlLoader)
  {
    fxmlLoader = theFxmlLoader;
  }

}
