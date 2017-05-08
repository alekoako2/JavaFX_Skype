/*
 * RegistrationView.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.authorization.registration;

import static com.c4u.comm_emp.User._firstName;
import static com.c4u.comm_emp.User._lastName;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import com.c4u.comm_emp.User;
import com.c4u.comm_emp.service.ConnectionClass;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * TODO : Description.
 */
public class RegistrationView extends RegistrationNodes
{
  private RegistrationPresenter registrationPresenter;

  /**
   * @param theRegistrationPresenter RegistrationPresenter
   */
  public void setRegistrationPresenter(final RegistrationPresenter theRegistrationPresenter)
  {
    this.registrationPresenter = theRegistrationPresenter;
    // createLoginGUI();
    System.out.println(getErrorfirstName());
  }

  ObservableList<String> countryList = FXCollections.observableArrayList();

  /**
   * @param theEvent ActionEvent
   * @throws IOException
   */
  public void back(final ActionEvent theEvent)
      throws IOException
  {
//    new StageLoaderdd("Login.fxml", theEvent);
  }

  boolean registerButton = false;

  boolean usernamefield;

  boolean lastnamefield;

  boolean emailfield;

  boolean reemailfield;

  boolean passwordf;

  boolean repasswordf;

  boolean countryselectfield;

  boolean cityselectfield;

  boolean addressfield;

  boolean datefield;

  private ArrayList<TextInputControl> textInputControlList = new ArrayList<TextInputControl>();

  private ArrayList<CheckBox> checkBoxList = new ArrayList<CheckBox>();

  Connection connect = null;

  Image image = new Image(getClass().getResourceAsStream("/com/c4u/comm_emp/image/emailError.png"));

  Image imageDateValid = new Image(getClass().getResourceAsStream("/com/c4u/comm_emp/image/q.png"));

  Image regGIF = new Image(getClass().getResourceAsStream("/com/c4u/comm_emp/image/regreg1.gif"));

  /**
   * @throws SQLException
   */
  @FXML
  private void initialize()
      throws SQLException
  {

    @SuppressWarnings("resource")
    final ResultSet _rs = new ConnectionClass("select * from addcountries()").getResultSet();

    while (_rs.next())
    {
      countryList.add(_rs.getString("country_name"));
      getRegCountry().setItems(countryList);
    }

    getErrorfirstName().setGraphic(new ImageView(image));
    getErrorlastName().setGraphic(new ImageView(image));
    getMistakeMainEmail().setGraphic(new ImageView(image));
    getMistakeReEmail().setGraphic(new ImageView(image));
    getMistakeMainPass().setGraphic(new ImageView(image));
    getMistakecountrySelect().setGraphic(new ImageView(image));
    getMistakeCitySelect().setGraphic(new ImageView(image));
    getMistakeAddress().setGraphic(new ImageView(image));
    getMistakeDate().setGraphic(new ImageView(imageDateValid));
    getErrorfirstName().setGraphic(new ImageView(image));
    getErrorfirstName().setGraphic(new ImageView(image));
    getMistakeRePass().setGraphic(new ImageView(image));
    getRegCountry().setValue("Choose country*");
    getRegCountry().setItems(countryList);
    getRegCity().setValue("Choose city*");
    textInputControlList.addAll(Arrays.asList(getRegFName(), getRegLName(), getRegEMail(), getRegREMail(), getRegPass(),
        getRegCPass(), getRegAddress()));
    checkBoxList.addAll(Arrays.asList(getRegFleet(), getRegLease(), getRegMobile(), getRegCars(), getRegObject(), getRegGps(),
        getRegFair(), getRegTicket()));
  }

  /**
   * 
   */
  @FXML
  private void usernameCheck()
  {

    User._firstName = getRegFName().getText().toLowerCase().toString();

    final String _usercheck = "^[a-z]{3,15}$";
    final java.util.regex.Pattern _k = java.util.regex.Pattern.compile(_usercheck);
    final java.util.regex.Matcher _n = _k.matcher(User._firstName);
    if (_n.matches())
    {
      getErrorfirstName().setVisible(false);
      usernamefield = true;
      lastcheck();
      getWarnlabel().setText("");
    }
    else
    {
      getWarnlabel().setText("Name should contain only Letters A-Z");
      getErrorfirstName().setVisible(true);
      getErrorfirstName().setGraphic(new ImageView(image));
      usernamefield = false;
      lastcheck();
    }
  }

  /**
   * 
   */
  @FXML
  private void lastnameCheck()
  {
    _lastName = getRegLName().getText().toLowerCase().toString();
    getWarnlabel().setText("");

    final String _usercheck = "^[a-z]{3,15}$";
    final java.util.regex.Pattern _k = java.util.regex.Pattern.compile(_usercheck);
    final java.util.regex.Matcher _n = _k.matcher(_lastName);
    if (_n.matches())
    {
      getErrorlastName().setVisible(false);
      lastnamefield = true;
      lastcheck();
    }
    else
    {
      getWarnlabel().setText("Last Name should contain only Letters A-Z");
      getErrorlastName().setVisible(true);
      getErrorlastName().setGraphic(new ImageView(image));
      lastnamefield = false;
      lastcheck();
    }
  }

  /**
   * @param theEmail String
   * @return boolean
   */
  @FXML
  private boolean isValidEmailAddress(final String theEmail)
  {
    final String _ePattern = "^[a-zA-Z0-9.#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\."
        + "[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    final java.util.regex.Pattern _p = java.util.regex.Pattern.compile(_ePattern);
    final java.util.regex.Matcher _m = _p.matcher(theEmail);
    return _m.matches();
  }

  /**
   * 
   */
  @FXML
  private void fieldChecker()
  {
    final boolean _k;
    reEmailCheck();
    _k = isValidEmailAddress(getRegEMail().getText().toString());
    // System.out.println(k);
    if (_k)
    {
      getWarnlabel().setText("");
      getMistakeMainEmail().setVisible(false);
      emailfield = true;
      lastcheck();

    }
    else
    {
      getWarnlabel().setText("Please Enter your Email Correctly ");
      getMistakeMainEmail().setVisible(true);
      getMistakeMainEmail().setGraphic(new ImageView(image));
      emailfield = false;
      lastcheck();
    }
  }

  /**
   * 
   */
  @FXML
  private void reEmailCheck()
  {
    if (getRegEMail().getText().equals(getRegREMail().getText()))
    {
      getWarnlabel().setText("");
      getMistakeReEmail().setVisible(false);
      reemailfield = true;
      lastcheck();
    }
    else
    {
      getMistakeReEmail().setVisible(true);
      getMistakeReEmail().setGraphic(new ImageView(image));
      getWarnlabel().setText("Email Fields do not match!");
      reemailfield = false;
      lastcheck();
    }
  }

  /**
   * 
   */
  @FXML
  private void passCheck()
  {
    passReCheck();
    final boolean _p = passValidator(getRegPass().getText().toString());
    // System.out.println(p);
    if (!_p)
    {
      getWarnlabel().setText("Password should be at least 8 Symbols including [,#$%] 1-9 A-z  ");
      getMistakeMainPass().setVisible(true);
      getMistakeMainPass().setGraphic(new ImageView(image));
      passwordf = false;
      lastcheck();
    }
    else
    {
      passwordf = true;
      getMistakeMainPass().setVisible(false);
      lastcheck();
    }
  }

  /**
   * @param thePassword String
   * @return boolean
   */
  @FXML
  private boolean passValidator(final String thePassword)
  {
    final String _rule = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
    final java.util.regex.Pattern _p = java.util.regex.Pattern.compile(_rule);
    final java.util.regex.Matcher _m = _p.matcher(thePassword);
    return _m.matches();
  }

  /**
   * 
   */
  @FXML
  private void passReCheck()
  {
    if (getRegPass().getText().toString().equals(getRegCPass().getText().toString()))
    {
      getWarnlabel().setText("");
      getMistakeRePass().setVisible(false);
      repasswordf = true;
      lastcheck();
    }
    else
    {

      getWarnlabel().setText("Passwords do not match!");
      getMistakeRePass().setVisible(true);
      getMistakeRePass().setGraphic(new ImageView(image));
      repasswordf = false;
      lastcheck();
    }
  }

  /**
   * 
   */
  @FXML
  private void countryCheck()
  {
    getRegCity().getItems().clear();
    getRegCountry().setEditable(false);
    if (getRegCountry().getValue() == "Choose country*" || getRegCountry().getValue() == "")
    {
      getWarnlabel().setText("Please select country!");
      getMistakecountrySelect().setVisible(true);
      getMistakecountrySelect().setGraphic(new ImageView(image));
      countryselectfield = false;
      lastcheck();
    }
    else
    {
      getWarnlabel().setText("");
      getMistakecountrySelect().setVisible(false);
      countryselectfield = true;
      lastcheck();
    }
  }

  ObservableList<String> cityList = FXCollections.observableArrayList();

  /**
   * @throws SQLException
   */
  @SuppressWarnings("resource")
  @FXML
  private void chooseCity()
      throws SQLException
  {

    PreparedStatement _stmtC = null;
    PreparedStatement _stmtCa = null;
    ResultSet _rsC = null;
    ResultSet _rsCa = null;
    _stmtC = connect.prepareStatement(
        "select country_id from countries where country_name= '" + getRegCountry().getValue().toString() + "'");
    _rsC = _stmtC.executeQuery();
    while (_rsC.next())
    {
      _stmtCa = connect.prepareStatement("select * from addcities(" + _rsC.getInt("country_id") + ")");
      _rsCa = _stmtCa.executeQuery();
      while (_rsCa.next())
      {
        cityList.addAll(_rsCa.getString("city_name"));
      }
    }

    getRegCity().setItems(cityList);

    // System.out.println(getRegCity().getValue());
    if (getRegCity().getValue() == null)
    {
      getWarnlabel().setText("Please select city!");
      getMistakeCitySelect().setVisible(true);
      getMistakeCitySelect().setGraphic(new ImageView(image));
      cityselectfield = false;
      lastcheck();
    }
    else
    {
      getWarnlabel().setText("");
      getMistakeCitySelect().setVisible(false);
      cityselectfield = true;
      lastcheck();
    }
  }

  /**
   * 
   */
  @FXML
  private void addressCheck()
  {
    if (getRegAddress().getText().matches("[a-zA-Z0-9\\-#\\.\\(\\)\\/%&\\s]{15,40}"))
    {
      getWarnlabel().setText("");
      getMistakeAddress().setVisible(false);
      addressfield = true;
      lastcheck();

    }
    else
    {

      getWarnlabel().setText("please enter your address correctly!");
      getMistakeAddress().setVisible(true);
      getMistakeAddress().setGraphic(new ImageView(image));
      addressfield = false;
      lastcheck();
    }
  }

  /**
   * 
   */
  @FXML
  private void date()
  {

    if (getRegDate().getValue() == null)

    {
      getWarnlabel().setText("please select your birth Date!");
      getMistakeDate().setVisible(true);
      getMistakeDate().setGraphic(new ImageView(imageDateValid));
      datefield = false;
      lastcheck();
    }
    else
    {
      getWarnlabel().setText("");
      getMistakeDate().setVisible(false);
      datefield = true;
      lastcheck();
    }
  }

  /**
   * 
   */
  @FXML
  private void lastcheck()
  {

    if ((usernamefield && lastnamefield && emailfield && reemailfield && passwordf && repasswordf && countryselectfield
        && addressfield && datefield && cityselectfield)
        && (getRegFleet().isSelected() || getRegLease().isSelected() || getRegMobile().isSelected() || getRegCars().isSelected()
            || getRegObject().isSelected() || getRegTicket().isSelected() || getRegFair().isSelected()
            || getRegGps().isSelected())
        && (getRegRBtnMr().isSelected() || getRegRBtnMrs().isSelected()))
    {

      getRegReg().setDisable(false);
      registerButton = true;
    }
    else
      getRegReg().setDisable(true);
  }

  int secondsPassed = 0;

  /**
   * @param theEvent ActionEvent
   */
  @SuppressWarnings("resource")
  @FXML
  private void register(final ActionEvent theEvent)
  {

    String _workAppend = "";
    String _gender = "";
    // System.out.println(regFName.getText());
    // System.out.println(regLName.getText());
    // System.out.println(getRegEMail().getText());
    // System.out.println(getRegREMail().getText());
    // System.out.println(getRegPass().getText());
    // System.out.println(regCPass.getText());
    // System.out.println(getRegCountry().getValue().toString());
    // System.out.println(getRegCity().getValue().toString());

    if (getRegFair().isSelected())
      _workAppend += " regFair";
    if (getRegFleet().isSelected())
      _workAppend += " Fleet";
    if (getRegLease().isSelected())
      _workAppend += " Lease";
    if (getRegTicket().isSelected())
      _workAppend += " Ticket";
    if (getRegGps().isSelected())
      _workAppend += " Gps";
    if (getRegObject().isSelected())
      _workAppend += " Object";
    if (getRegCars().isSelected())
      _workAppend += " Cars";
    if (getRegMobile().isSelected())
      _workAppend += " mobile";
    if (getRegRBtnMr().isSelected())
      _gender += "male";
    else if (getRegRBtnMrs().isSelected())
      _gender += "female";
    // System.out.println(gender);
    // System.out.println(workAppend);

    User._email = getRegEMail().getText();
    User._rEmail = getRegREMail().getText();
    User._password = getRegPass().getText();
    User._country = getRegCountry().getValue().toString();
    User._city = getRegCity().getValue().toString();
    User._date = getRegDate().getValue().toString();

    User._address = getRegAddress().getText();

    try
    {
      Connection _connection = null;
      PreparedStatement _stmt = null;

      _connection = DriverManager.getConnection("jdbc:postgresql://10.3.12.28:5432/postgres", "postgres", "18052010M+m");

      _stmt = _connection.prepareStatement("insert into  users (first_name, last_name,email,pass_phrase,country,city,"
          + "address,date_time,title,organization) values('" + _firstName + "','" + _lastName + "','" + User._email + "','"
          + User._password + "','" + User._country + "','" + User._city + "','" + User._address + "','" + User._date + "','"
          + _gender + "','" + _workAppend + "')");
      _stmt.executeUpdate();
      System.out.println("data added to the table");

      final Timer _timer = new Timer();

      final TimerTask _task = new TimerTask()
      {
        @Override
        public void run()
        {
          Platform.runLater(new Runnable()
          {
            @Override
            public void run()
            {
              secondsPassed++;
              getRegGif().setDisable(false);
              getRegGif().setVisible(true);
              getRegGif().setImage(regGIF);

              getWarnlabel().setText("Your Account Has been Created, Please Log in");
              getWarnlabel().setVisible(true);
              getWarnlabel().setStyle("-fx-text-fill: limegreen !important; -fx-font-size:16px;   -fx-font-weight: bold;");

              System.out.println("Seconds passed: " + secondsPassed);
              if (secondsPassed == 4)
              {
//                try
//                {
                  getRegGif().setVisible(false);
                  getRegGif().setDisable(true);
                  getRegReg().setDisable(true);
                  _timer.cancel();

//                  new StageLoaderdd("Login.fxml", theEvent);

//                }
//                catch (final IOException _e)
//                {
//                  System.out.println(_e);
//                }
              }
            }
          });
        }
      };
      _timer.scheduleAtFixedRate(_task, 1000, 1000);

    }
    /**
     * 
     */
    catch (final Exception _e)
    {
      System.out.println(_e);

    }
  }

}
