/*
 * package-info.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by mprangishvili on 09.11.16.
 */
public class ValidationClass
{
  /**
   * @param theTime ComboBox
   * @param theTitle TextField
   * @return boolean
   */
  public static boolean checkAppointment(@SuppressWarnings("rawtypes")
  final ComboBox theTime, final TextField theTitle)
  {
    if (theTime.getValue() == null && theTitle.getText().equals(""))
    {
      return false;
    }
    return true;
  }

  /**
   * @param theProvider ComboBox
   * @param theTime ComboBox
   * @param theDuration ComboBox
   * @return boolean
   */
  public static boolean checkAppointment(@SuppressWarnings("rawtypes")
  final ComboBox theProvider, @SuppressWarnings("rawtypes")
  final ComboBox theTime, @SuppressWarnings("rawtypes")
  final ComboBox theDuration)
  {
    if (theProvider.getValue() == null && theTime.getValue() == null && theDuration.getValue() == null)
    {
      return false;
    }
    return true;
  }

  /**
   * @param thePlannerTitleField TextField
   * @param thePlannerTimeDropBox ComboBox
   * @return Boolean
   */
  public static Boolean plannerFieldsIsEmpty(final TextField thePlannerTitleField, @SuppressWarnings("rawtypes")
  final ComboBox thePlannerTimeDropBox)
  {
    if (thePlannerTitleField.getText().equals("") && thePlannerTimeDropBox.getValue() == null)
    {
      return true;
    }
    return false;
  }

}
