/*
 * AppointmentController.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.userPage.appointment;

import java.math.BigDecimal;

/**
 * Created by mprangishvili on 24.11.16.
 */
/**
 * TODO : Description.
 */
public class InfoContainer
{

  private BigDecimal price;

  private Integer quantity;

  /**
   * 
   */
  public InfoContainer()
  {
  }

  /**
   * @param thePrice BigDecimal
   * @param theQuantity Integer
   */
  public InfoContainer(final BigDecimal thePrice, final Integer theQuantity)
  {
    this.price = thePrice;
    this.quantity = theQuantity;
  }

  /**
   * @param thePrice BigDecimal
   */
  public void set_price(final BigDecimal thePrice)
  {
    this.price = thePrice;
  }

  /**
   * @param theQuantity Integer
   */
  public void set_quantity(final Integer theQuantity)
  {
    this.quantity = theQuantity;
  }

  /**
   * @return BigDecimal
   */
  public BigDecimal get_price()
  {
    return price;
  }

  /**
   * @return Integer
   */
  public Integer get_quantity()
  {
    return quantity;
  }
}
