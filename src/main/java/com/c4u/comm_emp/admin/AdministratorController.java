/*
 * AdministratorController.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * TODO : Description.
 */
public class AdministratorController implements Initializable
{
  @FXML
  private Label label;

  @FXML
  private TableView<Person> table;// = new TableView<Person>();

  @FXML
  private TextField usernameEdit;

  @FXML
  private TextField lastnameEdit;

  @FXML
  private TextField emailEdit;

  @FXML
  private TextField passwordEdit;

  @FXML
  private ComboBox<String> countryEdit;

  @FXML
  private ComboBox<String> cityEdit;

  @FXML
  private TextField addressEdit;

  @FXML
  private DatePicker dateEdit;

  @FXML
  private TextField titleEdit;

  @FXML
  private TextField workingfieldEdit;

  @FXML
  private Button deleteBtn;

  @FXML
  private TableColumn<Person, String> firstNameCol;

  @FXML
  private TableColumn<Person, String> lastNameCol;

  @FXML
  private TableColumn<Person, String> emailCol;

  @FXML
  private TableColumn<Person, String> passwordColumn;

  @FXML
  private TableColumn<Person, String> countryColumn;

  @FXML
  private TableColumn<Person, String> cityColumn;

  @FXML
  private TableColumn<Person, String> addressColumn;

  @FXML
  private TableColumn<Person, String> dateColumn;

  @FXML
  private TableColumn<Person, String> titleColumn;

  @FXML
  private TableColumn<Person, String> workingFieldColumn;

  @FXML
  private TableColumn<Person, String> identifier;

  @FXML
  private TextField getFirstName;

  @FXML
  private Button updateBtn;

  @FXML
  private RadioButton maleTitle;

  @FXML
  private RadioButton femaleTitle;

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
  private ImageView nameImageError;

  @FXML
  private ImageView lastnameImageError;

  @FXML
  private ImageView emailImageError;

  @FXML
  private ImageView passwordImageError;

  @FXML
  private ImageView countryImageError;

  @FXML
  private ImageView cityImageError;

  @FXML
  private ImageView addressImageError;

  @FXML
  private ImageView dateImageError;

  @FXML
  private ImageView titleImageError;

  @FXML
  private ImageView workingfieldImageError;

  @FXML
  private Group userGroup;

  boolean namecheck, lastnamecheck, emailcheck, passwordcheck, countrycheck, citycheck, addresscheck, datecheck, titlecheck,
      workingfieldcheck = false;

  @SuppressWarnings("resource")
  @Override
  public void initialize(final URL theUrl, final ResourceBundle theArb)
  {
    PreparedStatement _theStmt = null;
    userGroup.setVisible(false);
    ResultSet _theResultset = null;
    table.setVisible(false);
    updateBtn.setDisable(true);
    table.setPlaceholder(new Label("PLEASE LOAD THE TABLE TO SEE COMM-EMP DATA"));

    try
    {
      Connection _theConnection = null;
      _theConnection = DriverManager.getConnection("jdbc:postgresql://10.3.12.28:5432/postgres", "postgres", "18052010M+m");
      _theStmt = _theConnection.prepareStatement("select * from addcountries()");
      _theResultset = _theStmt.executeQuery();
      while (_theResultset.next())
      {
        countryList.add(_theResultset.getString("country_name"));
        countryEdit.setItems(countryList);
      }
      // if(countryEdit.getValue()==null)
      // {
      // System.out.println("null");
      // }
      // else

    }
    catch (final Exception _e)
    {
      System.out.println("Error");

    }

    firstNameCol.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
    lastNameCol.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
    emailCol.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
    passwordColumn.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
    countryColumn.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
    cityColumn.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
    addressColumn.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
    dateColumn.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
    titleColumn.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
    workingFieldColumn.setCellFactory(TextFieldTableCell.<Person> forTableColumn());
    identifier.setCellFactory(TextFieldTableCell.<Person> forTableColumn());

  }

  private ObservableList<Person> data = FXCollections.observableArrayList();

  int count = 0;

  /**
   * @throws buttonAction.
   */
  @SuppressWarnings("resource")
  @FXML
  private void handleButtonAction()
  {
    table.setVisible(true);
    userGroup.setVisible(true);
    ++count;

    // final ObservableList<String> row = FXCollections.observableArrayList();
    // final ObservableList<ObservableList> userDataList = FXCollections.observableArrayList();
    try
    {

      PreparedStatement _theStmt = null;
      Connection _theConnection = null;
      ResultSet _theRs = null;
      _theConnection = DriverManager.getConnection("jdbc:postgresql://10.3.12.28:5432/postgres", "postgres", "18052010M+m");
      _theStmt = _theConnection.prepareStatement("select * from users order by user_id");
      _theRs = _theStmt.executeQuery();

      while (_theRs.next())
      {
        String _atitlefromboolean = null;
        final boolean _aTitlec = _theRs.getBoolean("title");
        if (_aTitlec == true)
        {
          _atitlefromboolean = "male";
        }
        else
        {
          _atitlefromboolean = "female";
        }

        data.add(new Person(_theRs.getString("user_id"), _theRs.getString("first_name"), _theRs.getString("last_name"),
            _theRs.getString("email"), _theRs.getString("pass_phrase"), _theRs.getString("country"), _theRs.getString("city"),
            _theRs.getString("address"), _theRs.getString("date_time"), _atitlefromboolean, _theRs.getString("organization")));
        ++count;

        table.getItems().setAll(this.data);

        table.refresh();
        ++count;

      }

    }
    catch (final Exception _e)
    {
      System.out.println("Table Load Error");
    }
  }

  /**
   * 
   */
  @FXML
  private void finalcheckallfileds()
  {
    // addresschecker();
    validateFirstName();
    validateLastName();
    validateEmiail();
    passwordcheck();

    if (namecheck && lastnamecheck && emailcheck && citycheck && passwordcheck
        && (maleTitle.isSelected() || femaleTitle.isSelected()))
    {
      updateBtn.setDisable(false);
    }
    else
      updateBtn.setDisable(true);

  }

  /**
   * 
   */

  @SuppressWarnings(
  { "resource" })
  @FXML
  private void deleteUser()
      throws Exception
  {
    PreparedStatement _theStmt = null;

    connection = DriverManager.getConnection("jdbc:postgresql://10.3.12.28:5432/postgres", "postgres", "18052010M+m");
    _theStmt = connection
        .prepareStatement("delete from users where user_id=" + table.getSelectionModel().getSelectedItem().getId());

    _theStmt.executeUpdate();

    final Alert _theAlert = new Alert(Alert.AlertType.WARNING);
    _theAlert.setTitle("ATTENTION");
    _theAlert.setHeaderText(null);
    _theAlert.setContentText("USER " + table.getSelectionModel().getSelectedItem().getFirstName() + " "
        + table.getSelectionModel().getSelectedItem().getLastName() + " WITH identifier: "
        + table.getSelectionModel().getSelectedItem().getId() + " WILL BE REMOVED FROM THE SYSTEM");
    _theAlert.showAndWait();
    connection.close();

    data.clear();

    table.refresh();
    handleButtonAction();

    deleteBtn.setDisable(true);
    // --count;

    for (final Node _aNode : userGroup.getChildren())
    {

      if (_aNode instanceof TextField)
      {

        ((TextField) _aNode).setText("");
      }
      if (_aNode instanceof ComboBox)
      {
        ((ComboBox<?>) _aNode).setValue(null);

      }

      if (_aNode instanceof RadioButton)
      {
        ((RadioButton) _aNode).setSelected(false);

      }

      if (_aNode instanceof DatePicker)
      {
        ((DatePicker) _aNode).setValue(null);

      }
      if (_aNode instanceof ImageView)
      {
        ((ImageView) _aNode).setImage(null);

      }
    }

  }

  /**
   * 
   */
  private void validateFirstName()
  {
    final String _theUsernamechecking = usernameEdit.getText();
    final Pattern _thePattern = Pattern.compile("^[a-z]{3,15}$");
    final Matcher _theMatcher = _thePattern.matcher(_theUsernamechecking);
    if (_theMatcher.find() && _theMatcher.group().equals(_theUsernamechecking))
    {
      nameImageError.setVisible(false);
      namecheck = true;

    }
    else
    {
      nameImageError.setVisible(true);
      nameImageError.setImage(userInvalidFields);
      namecheck = false;
      table.refresh();

    }

  }

  /**
   * 
   */
  private void validateLastName()
  {
    final String _aLastnameget = lastnameEdit.getText();
    final Pattern _thePattern = Pattern.compile("^[a-z]{3,15}$");
    final Matcher _theMatcher = _thePattern.matcher(_aLastnameget);
    if (_theMatcher.find() && _theMatcher.group().equals(_aLastnameget))
    {
      lastnameImageError.setVisible(false);
      lastnamecheck = true;

    }
    else
    {
      lastnameImageError.setVisible(true);
      lastnameImageError.setImage(userInvalidFields);
      lastnamecheck = false;

    }
  }

  /**
   * 
   */

  private void validateEmiail()
  {
    final String _anEmail = emailEdit.getText();
    final Pattern _thePattern = Pattern
        .compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    final Matcher _theMatcher = _thePattern.matcher(_anEmail);
    if (_theMatcher.find() && _theMatcher.group().equals(_anEmail))
    {
      emailImageError.setVisible(false);

      emailcheck = true;

    }
    else
    {

      emailImageError.setVisible(true);
      emailImageError.setImage(userInvalidFields);

      emailcheck = false;
    }
  }

  /**
   * 
   */
  private void passwordcheck()
  {
    final String _aPassword = passwordEdit.getText();
    final Pattern _thePattern = Pattern
        .compile("^(?=.*?[A-Z])(?=(.*[a-z]){1,})" + "(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$");
    final Matcher _theMatcher = _thePattern.matcher(_aPassword);

    if (_theMatcher.find() && _theMatcher.group().equals(_aPassword))
    {
      passwordImageError.setVisible(false);

      passwordcheck = true;
    }
    else
    {
      passwordcheck = false;
      passwordImageError.setVisible(true);
      passwordImageError.setImage(userInvalidFields);

    }

  }

  ObservableList<String> countryList = FXCollections.observableArrayList();

  ObservableList<String> cityList = FXCollections.observableArrayList();

  /**
   * 
   */
  @FXML
  private void countrycheck()
  {

    cityEdit.getItems().clear();

  }

  /**
   * 
   */
  @SuppressWarnings("resource")
  @FXML
  private void citycheck()
  {
    try
    {
      Connection _theConnection = null;
      _theConnection = DriverManager.getConnection("jdbc:postgresql://10.3.12.28:5432/postgres", "postgres", "18052010M+m");
      PreparedStatement _aStmtC = null;
      PreparedStatement _aStmtCa = null;
      ResultSet _theRsc = null;
      ResultSet _theRsca = null;
      _aStmtC = _theConnection
          .prepareStatement("select country_id from countries where country_name= '" + countryEdit.getValue().toString() + "'");
      _theRsc = _aStmtC.executeQuery();
      while (_theRsc.next())
      {
        _aStmtCa = _theConnection.prepareStatement("select * from addcities(" + _theRsc.getInt("country_id") + ")");
        _theRsca = _aStmtCa.executeQuery();
        while (_theRsca.next())
        {
          cityList.addAll(_theRsca.getString("city_name"));

        }
      }
      if (cityEdit.getValue() == null)
      {
        cityImageError.setVisible(true);
        cityImageError.setImage(userInvalidFields);
        citycheck = false;
        finalcheckallfileds();

      }
      else
      {
        cityImageError.setVisible(false);
        citycheck = true;
        finalcheckallfileds();

      }

      cityEdit.setItems(cityList);

    }
    catch (final Exception _e)
    {
      System.out.println("Country list was changed");
    }
  }

  // @FXML
  // private void addresschecker(){
  //
  // String address=addressEdit.getText();
  // Pattern p = Pattern.compile("[a-zA-Z0-9\\-#\\.\\(\\)\\/%&\\s]{15,40}");
  // Matcher m = p.matcher(address);
  //
  // if (m.find() && m.group().equals(address)) {
  // addressImageError.setVisible(false);
  //
  // addresscheck=true;
  //
  //
  // }
  // else {
  //
  // addressImageError.setVisible(true);
  // addressImageError.setImage(userInvalidFields);
  // addresscheck = false;
  //
  // }
  //
  //
  // }

  /**
   * 
   */
  @FXML
  private void tableSearch()
  {

    data.remove(data);

    System.out.println(table.getSelectionModel().getFocusedIndex());

    final int _aKsize = firstNameCol.getTableView().getItems().size();
    System.out.println(_aKsize);

    final FilteredList<Person> _filteredData = new FilteredList<>(data, e -> true);
    getFirstName.setOnKeyReleased(e ->
    {
      getFirstName.textProperty().addListener((anObservablevalue, anOldvalue, aNewvalue) ->
      {
        _filteredData.setPredicate((Predicate<? super Person>) user ->
        {
          if (aNewvalue == null || aNewvalue.isEmpty())
          {
            return true;
          }
          final String _lowerCaseilter = aNewvalue.toLowerCase();
          if (user.getFirstName().contains(aNewvalue))
          {
            return true;
          }
          else if (user.getFirstName().toLowerCase().contains(_lowerCaseilter))
          {
            return true;
          }
          else if (user.getLastName().toLowerCase().contains(_lowerCaseilter))
          {
            return true;
          }
          else if (user.getEmail().toLowerCase().contains(_lowerCaseilter))
          {
            return true;
          }
          else if (user.getCountry().toLowerCase().contains(_lowerCaseilter))
          {
            return true;
          }
          else if (user.getCity().toLowerCase().contains(_lowerCaseilter))
          {
            return true;
          }
          else if (user.getAddress().toLowerCase().contains(_lowerCaseilter))
          {
            return true;
          }
          else if (user.getDate().toLowerCase().contains(_lowerCaseilter))
          {
            return true;
          }
          else if (user.getWorking().toLowerCase().contains(_lowerCaseilter))
          {
            return true;
          }
          return false;
        });
      });
      final SortedList<Person> _sortedData = new SortedList<>(_filteredData);
      _sortedData.comparatorProperty().bind(table.comparatorProperty());
      table.setItems(_sortedData);

    });

    table.refresh();
  }

  Image userInvalidFields = new Image(getClass().getResourceAsStream("/com/c4u/comm_emp/image/q.png"));

  PreparedStatement pst = null;

  Connection connection = null;

  /**
   * @throws Exception e
   */
  @FXML
  private void getUserData()
      throws Exception
  {
    deleteBtn.setDisable(false);
    // addresschecker();
    final String _startDate = table.getSelectionModel().getSelectedItem().getDate().toString();
    final DateTimeFormatter _formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    final LocalDate _localDate = LocalDate.parse(_startDate, _formatter);

    table.getSelectionModel().getSelectedItem().getFirstName();
    usernameEdit.setText(table.getSelectionModel().getSelectedItem().getFirstName());
    lastnameEdit.setText(table.getSelectionModel().getSelectedItem().getLastName());
    emailEdit.setText(table.getSelectionModel().getSelectedItem().getEmail());
    passwordEdit.setText(table.getSelectionModel().getSelectedItem().getPassword());

    countryEdit.setValue(table.getSelectionModel().getSelectedItem().getCountry());
    cityEdit.setValue(table.getSelectionModel().getSelectedItem().getCity());
    addressEdit.setText(table.getSelectionModel().getSelectedItem().getAddress());

    String _l = null;
    _l = table.getSelectionModel().getSelectedItem().getWorking().toLowerCase();

    if (_l.contains("regfair") || _l.contains("fleet") || _l.contains("lease") || _l.contains("ticket") || _l.contains("gps")
        || _l.contains("object") || _l.contains("cars") || _l.contains("mobile"))
    {
      System.out.println("contains Working Field");
      // regFair.setSelected(true);
    }

    dateEdit.setValue(_localDate);

    String _titleCheck = null;
    _titleCheck = table.getSelectionModel().getSelectedItem().getTitle();
    if (_titleCheck.equals("male"))
    {
      maleTitle.setSelected(true);
      femaleTitle.setSelected(false);
    }
    else if (_titleCheck.equals("female"))
    {
      maleTitle.setSelected(false);
      femaleTitle.setSelected(true);

    }
    else
    {
      maleTitle.setSelected(false);
      femaleTitle.setSelected(false);

    }

  }

  /**
   * @throws Exception
   */

  @SuppressWarnings("resource")
  @FXML
  private void updateData()
      throws Exception
  {

    @SuppressWarnings("unused")
    ResultSet _rs = null;
    connection = DriverManager.getConnection("jdbc:postgresql://10.3.12.28:5432/postgres", "postgres", "18052010M+m");
    pst = connection.prepareStatement("select * from users");
    _rs = pst.executeQuery();

    try
    {
      // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

      final String _query = "update users set  first_name=?, last_name=?,email=? ,pass_phrase=? ,country=?,"
          + "city=? ,address=?, date_time=?,title=?," + "organization=?  where user_id='"
          + table.getSelectionModel().getSelectedItem().getId() + "' ";
      pst = connection.prepareStatement(_query);

      final int _k = table.getSelectionModel().getSelectedIndex();
      final String _startDate = dateEdit.getValue().toString();
      System.out.println(_startDate);
      final SimpleDateFormat _dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
      final java.util.Date _date = _dateFormatter.parse(_startDate);
      final Date _sqlStartDate = new Date(_date.getTime());

      System.out.println(usernameEdit.getText());

      pst.setString(1, usernameEdit.getText());
      pst.setString(2, lastnameEdit.getText());

      pst.setString(3, emailEdit.getText());
      pst.setString(4, passwordEdit.getText());

      pst.setString(5, countryEdit.getValue());
      pst.setString(6, cityEdit.getValue());

      pst.setString(7, addressEdit.getText());

      pst.setDate(8, _sqlStartDate);

      if (femaleTitle.isSelected())
        pst.setBoolean(9, false);
      else
      {
        pst.setBoolean(9, true);
      }

      pst.setString(10, workingfieldEdit.getText());

      System.out.println("done");
      final Alert _alert = new Alert(Alert.AlertType.INFORMATION);
      _alert.setTitle("Information Dialog");
      _alert.setHeaderText(null);
      _alert.setContentText("User details has been updated.");
      _alert.showAndWait();

      pst.execute();

      pst.close();
      data.clear();
      handleButtonAction();
      table.getSelectionModel().select((_k));
      --count;

    }
    catch (final SQLException _e1)
    {
      label.setText("SQL Error");
      System.err.println(_e1);
    }
    catch (final ParseException _e1)
    {
      System.out.println("data was not parsed!");

    }
    System.out.println("Sql Error");
    table.refresh();
  }

  /**
   */
  public static class Person
  {

    // public SimpleStringProperty lastNameProperty() {
    // return lastName;
    // }
    //
    // public SimpleStringProperty dateProperty() {
    // return date;
    // }

    private SimpleStringProperty id;

    private SimpleStringProperty firstName;

    private SimpleStringProperty lastName;

    private SimpleStringProperty email;

    private SimpleStringProperty password;

    private SimpleStringProperty country;

    private SimpleStringProperty city;

    private SimpleStringProperty address;

    private SimpleStringProperty date;

    private SimpleStringProperty title;

    private SimpleStringProperty working;

    /**
     * @param theIdentifier ID
     * @param theFname Name
     * @param theLname LastName
     * @param theUemail Email
     * @param theUpassword Password
     * @param theUcountry Country
     * @param theUcity City
     * @param theUaddress Address
     * @param theUdate Date
     * @param theUtitle Title
     * @param theUworking Working Field
     */
    private Person(final String theIdentifier, final String theFname, final String theLname, final String theUemail,
        final String theUpassword, final String theUcountry, final String theUcity, final String theUaddress,
        final String theUdate, final String theUtitle, final String theUworking)
    {
      this.id = new SimpleStringProperty(theIdentifier);
      this.firstName = new SimpleStringProperty(theFname);
      this.lastName = new SimpleStringProperty(theLname);
      this.email = new SimpleStringProperty(theUemail);
      this.password = new SimpleStringProperty(theUpassword);
      this.country = new SimpleStringProperty(theUcountry);
      this.city = new SimpleStringProperty(theUcity);
      this.address = new SimpleStringProperty(theUaddress);
      this.date = new SimpleStringProperty(theUdate);
      this.title = new SimpleStringProperty(theUtitle);
      this.working = new SimpleStringProperty(theUworking);

    }

    /**
     * @return ID
     */
    public String getId()
    {
      return id.get();
    }

    /**
     * @param anIdentifier id
     */
    public void setId(final String anIdentifier)
    {
      firstName.set(anIdentifier);
    }

    /**
     * @return firstName
     */
    public String getFirstName()
    {
      return firstName.get();
    }

    /**
     * @param theFname firstName
     */
    public void setFirstName(final String theFname)
    {
      firstName.set(theFname);
    }

    /**
     * @return lastName
     */
    public String getLastName()
    {
      return lastName.get();
    }

    /**
     * @param theName String
     */
    public void setLastName(final String theName)
    {
      lastName.set(theName);
    }

    /**
     * @return email
     */
    public String getEmail()
    {
      return email.get();
    }

    /**
     * @param theUemail String
     */
    public void setEmail(final String theUemail)
    {
      email.set(theUemail);
    }

    /**
     * @return password
     */
    public String getPassword()
    {
      return password.get();
    }

    /**
     * @param theUpassword String
     */
    public void setPassword(final String theUpassword)
    {
      password.set(theUpassword);
    }

    /**
     * @return countryName
     */
    public String getCountry()
    {
      return country.get();
    }

    /**
     * @param theUcountry Country
     */
    public void setCountry(final String theUcountry)
    {
      country.set(theUcountry);
    }

    /**
     * @return CityName
     */
    public String getCity()
    {
      return city.get();
    }

    /**
     * @param theUcity city
     */
    public void setCity(final String theUcity)
    {
      city.set(theUcity);
    }

    /**
     * @return Address
     */
    public String getAddress()
    {
      return address.get();
    }

    /**
     * @param theUaddress Address
     */
    public void setAddress(final String theUaddress)
    {
      address.set(theUaddress);
    }

    /**
     * @return Date
     */
    public String getDate()
    {
      return date.getValue();
    }

    /**
     * @param theUdate Date
     */
    public void setDate(final String theUdate)
    {
      date.set(theUdate);
    }

    /**
     * @return Title
     */
    public String getTitle()
    {
      return title.get();
    }

    /**
     * @param theUtitle title
     */

    public void setTitle(final String theUtitle)
    {
      title.set(theUtitle);
    }

    /**
     * @return working
     */

    public String getWorking()
    {
      return working.get();
    }

    /**
     * @param theWorking workingOn
     */

    public void setWorking(final String theWorking)
    {
      this.working.set(theWorking);
    }
  }
}