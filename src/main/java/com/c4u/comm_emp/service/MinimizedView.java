/*
 * MinimizedView.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.service;

import com.c4u.comm_emp.Main;
import com.c4u.comm_emp.MakeDraggable;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

/**
 * TODO : Description.
 */
public class MinimizedView
{
  @FXML
  private Pane minimizedCircle;

  /**
   * 
   */
  @FXML
  public void initialize()
  {
    MakeDraggable.performDragg(Minimize.getMinimizedStage(), minimizedCircle);
    minimizedCircle.setOnMouseClicked(new EventHandler<Event>()
    {
      @Override
      public void handle(final Event theEvent)
      {
        // TODO Auto-generated method stub
        Minimize.getMinimizedStage().hide();
        Main.getPrimaryStage().show();
      }
    });
  }
}
