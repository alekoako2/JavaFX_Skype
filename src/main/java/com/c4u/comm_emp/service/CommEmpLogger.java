/*
 * CommEmpLogger.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO : Description.
 */
public class CommEmpLogger
{
  private static Logger _Logger = Logger.getLogger(CommEmpLogger.class.getName());

  /**
   * @param theSqlException SQLException
   */
  public static void logSQLException(final SQLException theSqlException)
  {
    _Logger.log(Level.SEVERE, "SQLException", theSqlException);
  }

  /**
   * @param theIoException IOException
   */
  public static void logIOException(final IOException theIoException)
  {
    _Logger.log(Level.SEVERE, "IOexception", theIoException);
  }
}
