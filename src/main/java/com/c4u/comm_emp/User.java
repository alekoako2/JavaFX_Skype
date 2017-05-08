/*
 * package-info.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp;

/**
 * TODO : Description.
 */
public class User
{
  /**
   * 
   */
  public static int _userId;

  /**
   * 
   */
  public static String _firstName;

  /**
   * 
   */
  public static String _lastName;

  /**
   * 
   */
  public static String _email;

  /**
   * 
   */
  public static String _rEmail;

  /**
   * 
   */
  public static String _password;

  /**
   * 
   */
  public static String _cPassword;

  /**
   * 
   */
  public static String _country;

  /**
   * 
   */
  public static String _city;

  /**
   * 
   */
  public static String _address;

  /**
   * 
   */
  public static String _date;

  /**
   * 
   */
  public static String _title;

  /**
   * 
   */
  public static String _module;

  /**
   * @return Integer
   */
  public static int get_userId()
  {
    return _userId;
  }

  /**
   * @return String
   */
  public String get_firstName()
  {
    return _firstName;
  }

  /**
   * @return String
   */
  public String get_lastName()
  {
    return _lastName;
  }

  /**
   * @return String
   */
  public String get_email()
  {
    return _email;
  }

  /**
   * @return String
   */
  public String get_rEmail()
  {
    return _rEmail;
  }

  /**
   * @return String
   */
  public String get_password()
  {
    return _password;
  }

  /**
   * @return String
   */
  public String get_cPassword()
  {
    return _cPassword;
  }

  /**
   * @return String
   */
  public String get_country()
  {
    return _country;
  }

  /**
   * @return String
   */
  public String get_city()
  {
    return _city;
  }

  /**
   * @return String
   */
  public String get_address()
  {
    return _address;
  }

  /**
   * @return String
   */
  public String get_date()
  {
    return _date;
  }

  /**
   * @return String
   */
  public String get_title()
  {
    return _title;
  }

  /**
   * @return String
   */
  public String get_module()
  {
    return _module;
  }

  /**
   * @param theUserId int
   */
  public static void set_userId(final int theUserId)
  {
    User._userId = theUserId;
  }

  /**
   * @param theFirstName String
   */
  @SuppressWarnings("static-access")
  public final void set_firstName(final String theFirstName)
  {
    this._firstName = theFirstName;
  }

  /**
   * @param theLastName String
   */
  @SuppressWarnings("static-access")
  public final void set_lastName(final String theLastName)
  {
    this._lastName = theLastName;
  }

  /**
   * @param theEmail String
   */
  @SuppressWarnings("static-access")
  public final void set_email(final String theEmail)
  {
    this._email = theEmail;
  }

  /**
   * @param theREmail String
   */
  @SuppressWarnings("static-access")
  public final void set_rEmail(final String theREmail)
  {
    this._rEmail = theREmail;
  }

  /**
   * @param thePassword String
   */
  @SuppressWarnings("static-access")
  public final void set_password(final String thePassword)
  {
    this._password = thePassword;
  }

  /**
   * @param theCPassword String
   */
  @SuppressWarnings("static-access")
  public final void set_cPassword(final String theCPassword)
  {
    this._cPassword = theCPassword;
  }

  /**
   * @param theCountry String
   */
  @SuppressWarnings("static-access")
  public final void set_country(final String theCountry)
  {
    this._country = theCountry;
  }

  /**
   * @param theCity String
   */
  @SuppressWarnings("static-access")
  public final void set_city(final String theCity)
  {
    this._city = theCity;
  }

  /**
   * @param theAddress String
   */
  @SuppressWarnings("static-access")
  public final void set_address(final String theAddress)
  {
    this._address = theAddress;
  }

  /**
   * @param theDate String
   */
  @SuppressWarnings("static-access")
  public final void set_date(final String theDate)
  {
    this._date = theDate;
  }

  /**
   * @param theTitle String
   */
  @SuppressWarnings("static-access")
  public final void set_title(final String theTitle)
  {
    this._title = theTitle;
  }

  /**
   * @param theModule String
   */
  @SuppressWarnings("static-access")
  public final void set_module(final String theModule)
  {
    this._module = theModule;
  }
}
