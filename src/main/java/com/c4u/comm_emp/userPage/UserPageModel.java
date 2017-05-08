/*
 * ClientPageModel.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.userPage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * TODO : Description.
 */
public interface UserPageModel
{
  /**
   * @param theUserId int
   * @return ArrayList
   * @throws SQLException
   * @throws IOException
   */
  ArrayList<Object> loadUserData(int theUserId)
      throws SQLException, IOException;

  /**
   * @param theUserId int
   * @return HashMap
   * @throws SQLException
   */
  HashMap<String, ArrayList<Object>> loadEmployeesData(int theUserId)
      throws SQLException;
}
