/*
 * AppointmentController.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO : Description.
 */
public class ConnectionClass
{
  private ResultSet resultSet;

  /**
   * @return ResultSet
   */
  public ResultSet getResultSet()
  {
    return resultSet;
  }

  /**
   * @param theQuery String
   * @throws SQLException
   */
  public ConnectionClass(final String theQuery)
      throws SQLException
  {
    final Connection _connection = DriverManager.getConnection("jdbc:postgresql://10.3.12.28:5432/postgres", "postgres",
        "18052010M+m");
    @SuppressWarnings("resource")
    final PreparedStatement _stmt = _connection.prepareStatement(theQuery);
    this.resultSet = _stmt.executeQuery();
    _connection.close();
  }

}
