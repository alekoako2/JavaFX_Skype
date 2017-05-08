/*
 * package-info.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * TODO : Description.
 */
public class MakeDraggable
{
  private static int xOffset;

  private static int yOffset;

  /**
   * @param theStage Stage
   * @param theDraggableElement Node
   */
  public static void performDragg(final Stage theStage, final Node theDraggableElement)
  {
    // TODO Auto-generated method stub
    theDraggableElement.setOnMousePressed(new EventHandler<MouseEvent>()
    {
      @Override
      public void handle(final MouseEvent theEvent)
      {
        xOffset = (int) (theEvent.getScreenX());
        yOffset = (int) (theEvent.getScreenY());
      }
    });

    theDraggableElement.setOnMouseDragged(new EventHandler<MouseEvent>()
    {
      @Override
      public void handle(final MouseEvent theEvent)
      {
        final int _tempOffsetX = (int) theEvent.getScreenX();
        final int _tempOffsetY = (int) theEvent.getScreenY();
        theStage.setX(theStage.getX() + (_tempOffsetX - xOffset));
        theStage.setY(theStage.getY() + (_tempOffsetY - yOffset));
        xOffset = _tempOffsetX;
        yOffset = _tempOffsetY;
      }
    });
  }

  /**
   * @param theDraggableElement Node
   */
  public static void performDragg(final Node theDraggableElement)
  {
    theDraggableElement.setOnMousePressed(new EventHandler<MouseEvent>()
    {
      @Override
      public void handle(final MouseEvent theEvent)
      {
        xOffset = (int) (theEvent.getScreenX());
        yOffset = (int) (theEvent.getScreenY());
      }
    });

    theDraggableElement.setOnMouseDragged(new EventHandler<MouseEvent>()
    {
      @Override
      public void handle(final MouseEvent theEvent)
      {
        final int _tempOffsetX = (int) theEvent.getScreenX();
        final int _tempOffsetY = (int) theEvent.getScreenY();
        theDraggableElement.setLayoutX(theDraggableElement.getLayoutX() + (_tempOffsetX - xOffset));
        theDraggableElement.setLayoutY(theDraggableElement.getLayoutY() + (_tempOffsetY - yOffset));
        xOffset = _tempOffsetX;
        yOffset = _tempOffsetY;
      }
    });
  }
}
