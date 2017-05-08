/*
 * Minimize.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.service;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * TODO : Description.
 */
public class Minimize
{
  private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  private double width = screenSize.getWidth();

  private double height = screenSize.getHeight();

  private static Stage minimizedStage;

  /**
   * @return Stage
   */
  public static Stage getMinimizedStage()
  {
    return minimizedStage;
  }

  /**
   * @param theMinimizedStage Stage
   */
  public static void setMinimizedStage(final Stage theMinimizedStage)
  {
    minimizedStage = theMinimizedStage;
  }

  /**
   * @param thePane Pane
   */
  public Minimize(final Pane thePane)
  {
    // TODO Auto-generated constructor stub
    
  }
}
