/*
 * RegistrationNodes.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.authorization.registration;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * TODO : Description.
 */
public class RegistrationNodes
{
  @FXML
  private ComboBox<String> regCountry;

  @FXML
  private ComboBox<String> regCity;

  @FXML
  private TextField regFName;

  @FXML
  private TextField regLName;

  @FXML
  private TextField regEMail;

  @FXML
  private TextField regREMail;

  @FXML
  private PasswordField regPass;

  @FXML
  private PasswordField regCPass;

  @FXML
  private TextField regAddress;

  @FXML
  private DatePicker regDate;

  @FXML
  private RadioButton regRBtnMr;

  @FXML
  private RadioButton regRBtnMrs;

  @FXML
  private Pane regOrgPane;

  @FXML
  private CheckBox regFleet;

  @FXML
  private CheckBox regLease;

  @FXML
  private CheckBox regMobile;

  @FXML
  private CheckBox regCars;

  @FXML
  private CheckBox regObject;

  @FXML
  private CheckBox regGps;

  @FXML
  private CheckBox regFair;

  @FXML
  private CheckBox regTicket;

  @FXML
  private Button regReg;

  @FXML
  private Label mistakeReEmail;

  @FXML
  private Label mistakeMainEmail;

  @FXML
  private Label mistakeDate;

  @FXML
  private Label mistakeMainPass;

  @FXML
  private Label mistakeRePass;

  @FXML
  private Label mistakecountrySelect;

  @FXML
  private Label mistakeCitySelect;

  @FXML
  private ImageView regGif;

  @FXML
  private Label errorfirstName;

  @FXML
  private Label errorlastName;

  @FXML
  private Label warnlabel;

  @FXML
  private Label mistakeAddress;

  /**
   * @return Label
   */
  public Label getErrorfirstName()
  {
    return errorfirstName;
  }

  /**
   * @return Label
   */
  public Label getErrorlastName()
  {
    return errorlastName;
  }

  /**
   * @return Label
   */
  public Label getMistakeAddress()
  {
    return mistakeAddress;
  }

  /**
   * @return Label
   */
  public Label getMistakeCitySelect()
  {
    return mistakeCitySelect;
  }

  /**
   * @return Label
   */
  public Label getMistakecountrySelect()
  {
    return mistakecountrySelect;
  }

  /**
   * @return Label
   */
  public Label getMistakeDate()
  {
    return mistakeDate;
  }

  /**
   * @return Label
   */
  public Label getMistakeMainEmail()
  {
    return mistakeMainEmail;
  }

  /**
   * @return Label
   */
  public Label getMistakeMainPass()
  {
    return mistakeMainPass;
  }

  /**
   * @return Label
   */
  public Label getMistakeReEmail()
  {
    return mistakeReEmail;
  }

  /**
   * @return Label
   */
  public Label getMistakeRePass()
  {
    return mistakeRePass;
  }

  /**
   * @return TextField
   */
  public TextField getRegAddress()
  {
    return regAddress;
  }

  /**
   * @return TextField
   */
  public CheckBox getRegCars()
  {
    return regCars;
  }

  /**
   * @return ComboBox
   */
  public ComboBox<String> getRegCity()
  {
    return regCity;
  }

  /**
   * @return ComboBox
   */
  public ComboBox<String> getRegCountry()
  {
    return regCountry;
  }

  /**
   * @return PasswordField
   */
  public PasswordField getRegCPass()
  {
    return regCPass;
  }

  /**
   * @return DatePicker
   */
  public DatePicker getRegDate()
  {
    return regDate;
  }

  /**
   * @return TextField
   */
  public TextField getRegEMail()
  {
    return regEMail;
  }

  /**
   * @return CheckBox
   */
  public CheckBox getRegFair()
  {
    return regFair;
  }

  /**
   * @return CheckBox
   */
  public CheckBox getRegFleet()
  {
    return regFleet;
  }

  /**
   * @return TextField
   */
  public TextField getRegFName()
  {
    return regFName;
  }

  /**
   * @return ImageView
   */
  public ImageView getRegGif()
  {
    return regGif;
  }

  /**
   * @return CheckBox
   */
  public CheckBox getRegGps()
  {
    return regGps;
  }

  /**
   * @return CheckBox
   */
  public CheckBox getRegLease()
  {
    return regLease;
  }

  /**
   * @return TextField
   */
  public TextField getRegLName()
  {
    return regLName;
  }

  /**
   * @return CheckBox
   */
  public CheckBox getRegMobile()
  {
    return regMobile;
  }

  /**
   * @return CheckBox
   */
  public CheckBox getRegObject()
  {
    return regObject;
  }

  /**
   * @return Pane
   */
  public Pane getRegOrgPane()
  {
    return regOrgPane;
  }

  /**
   * @return PasswordField
   */
  public PasswordField getRegPass()
  {
    return regPass;
  }

  /**
   * @return RadioButton
   */
  public RadioButton getRegRBtnMr()
  {
    return regRBtnMr;
  }

  /**
   * @return RadioButton
   */
  public RadioButton getRegRBtnMrs()
  {
    return regRBtnMrs;
  }

  /**
   * @return Button
   */
  public Button getRegReg()
  {
    return regReg;
  }

  /**
   * @return TextField
   */
  public TextField getRegREMail()
  {
    return regREMail;
  }

  /**
   * @return CheckBox
   */
  public CheckBox getRegTicket()
  {
    return regTicket;
  }

  /**
   * @return Label
   */
  public Label getWarnlabel()
  {
    return warnlabel;
  }

  /**
   * @param theErrorfirstName Label
   */
  public void setErrorfirstName(final Label theErrorfirstName)
  {
    errorfirstName = theErrorfirstName;
  }

  /**
   * @param theErrorlastName Label
   */
  public void setErrorlastName(final Label theErrorlastName)
  {
    errorlastName = theErrorlastName;
  }

  /**
   * @param theMistakeAddress Label
   */
  public void setMistakeAddress(final Label theMistakeAddress)
  {
    mistakeAddress = theMistakeAddress;
  }

  /**
   * @param theMistakeCitySelect Label
   */
  public void setMistakeCitySelect(final Label theMistakeCitySelect)
  {
    mistakeCitySelect = theMistakeCitySelect;
  }

  /**
   * @param theMistakecountrySelect Label
   */
  public void setMistakecountrySelect(final Label theMistakecountrySelect)
  {
    mistakecountrySelect = theMistakecountrySelect;
  }

  /**
   * @param theMistakeDate Label
   */
  public void setMistakeDate(final Label theMistakeDate)
  {
    mistakeDate = theMistakeDate;
  }

  /**
   * @param theMistakeMainEmail Label
   */
  public void setMistakeMainEmail(final Label theMistakeMainEmail)
  {
    mistakeMainEmail = theMistakeMainEmail;
  }

  /**
   * @param theMistakeMainPass Label
   */
  public void setMistakeMainPass(final Label theMistakeMainPass)
  {
    mistakeMainPass = theMistakeMainPass;
  }

  /**
   * @param theMistakeReEmail Label
   */
  public void setMistakeReEmail(final Label theMistakeReEmail)
  {
    mistakeReEmail = theMistakeReEmail;
  }

  /**
   * @param theMistakeRePass Label
   */
  public void setMistakeRePass(final Label theMistakeRePass)
  {
    mistakeRePass = theMistakeRePass;
  }

  /**
   * @param theRegAddress TextField
   */
  public void setRegAddress(final TextField theRegAddress)
  {
    regAddress = theRegAddress;
  }

  /**
   * @param theRegCars CheckBox
   */
  public void setRegCars(final CheckBox theRegCars)
  {
    regCars = theRegCars;
  }

  /**
   * @param theRegCity ComboBox
   */
  public void setRegCity(final ComboBox<String> theRegCity)
  {
    regCity = theRegCity;
  }

  /**
   * @param theRegCountry ComboBox
   */
  public void setRegCountry(final ComboBox<String> theRegCountry)
  {
    regCountry = theRegCountry;
  }

  /**
   * @param theRegCPass PasswordField
   */
  public void setRegCPass(final PasswordField theRegCPass)
  {
    regCPass = theRegCPass;
  }

  /**
   * @param theRegDate DatePicker
   */
  public void setRegDate(final DatePicker theRegDate)
  {
    regDate = theRegDate;
  }

  /**
   * @param theRegEMail TextField
   */
  public void setRegEMail(final TextField theRegEMail)
  {
    regEMail = theRegEMail;
  }

  /**
   * @param theRegFair CheckBox
   */
  public void setRegFair(final CheckBox theRegFair)
  {
    regFair = theRegFair;
  }

  /**
   * @param theRegFleet CheckBox
   */
  public void setRegFleet(final CheckBox theRegFleet)
  {
    regFleet = theRegFleet;
  }

  /**
   * @param theRegFName TextField
   */
  public void setRegFName(final TextField theRegFName)
  {
    regFName = theRegFName;
  }

  /**
   * @param theRegGif ImageView
   */
  public void setRegGif(final ImageView theRegGif)
  {
    regGif = theRegGif;
  }

  /**
   * @param theRegGps CheckBox
   */
  public void setRegGps(final CheckBox theRegGps)
  {
    regGps = theRegGps;
  }

  /**
   * @param theRegLease CheckBox
   */
  public void setRegLease(final CheckBox theRegLease)
  {
    regLease = theRegLease;
  }

  /**
   * @param theRegLName TextField
   */
  public void setRegLName(final TextField theRegLName)
  {
    regLName = theRegLName;
  }

  /**
   * @param theRegMobile CheckBox
   */
  public void setRegMobile(final CheckBox theRegMobile)
  {
    regMobile = theRegMobile;
  }

  /**
   * @param theRegObject CheckBox
   */
  public void setRegObject(final CheckBox theRegObject)
  {
    regObject = theRegObject;
  }

  /**
   * @param theRegOrgPane Pane
   */
  public void setRegOrgPane(final Pane theRegOrgPane)
  {
    regOrgPane = theRegOrgPane;
  }

  /**
   * @param theRegPass PasswordField
   */
  public void setRegPass(final PasswordField theRegPass)
  {
    regPass = theRegPass;
  }

  /**
   * @param theRegRBtnMr RadioButton
   */
  public void setRegRBtnMr(final RadioButton theRegRBtnMr)
  {
    regRBtnMr = theRegRBtnMr;
  }

  /**
   * @param theRegRBtnMrs RadioButton
   */
  public void setRegRBtnMrs(final RadioButton theRegRBtnMrs)
  {
    regRBtnMrs = theRegRBtnMrs;
  }

  /**
   * @param theRegReg Button
   */
  public void setRegReg(final Button theRegReg)
  {
    regReg = theRegReg;
  }

  /**
   * @param theRegREMail TextField
   */
  public void setRegREMail(final TextField theRegREMail)
  {
    regREMail = theRegREMail;
  }

  /**
   * @param theRegTicket CheckBox
   */
  public void setRegTicket(final CheckBox theRegTicket)
  {
    regTicket = theRegTicket;
  }

  /**
   * @param theWarnlabel Label
   */
  public void setWarnlabel(final Label theWarnlabel)
  {
    warnlabel = theWarnlabel;
  }

}