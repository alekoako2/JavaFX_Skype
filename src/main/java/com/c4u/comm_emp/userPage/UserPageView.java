/*
 * ClientPageView.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.userPage;

import java.io.IOException;

/**
 * TODO : Description.
 */
public interface UserPageView
{
  /**
   * @param theName String
   * @param theActivityMessage String
   * @param theAvailability String
   * @param theImageUrl String
   * @throws IOException String
   */
  void setUserData(String theName, String theActivityMessage, String theAvailability, String theImageUrl)
      throws IOException;

  /**
   * @param theEmployeeId int
   * @param theName String
   * @param theActivityMessage String
   * @param theOnlineStatus Boolean
   * @param theAvailability String
   * @param theImageUrl String
   * @throws IOException 
   */
  void setEmployee(int theEmployeeId, String theName, String theActivityMessage, Boolean theOnlineStatus,
      String theAvailability, String theImageUrl) throws IOException;
}
