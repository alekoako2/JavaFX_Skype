/*
 * AppointmentView.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.userPage.appointment;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

/**
 * TODO : Description.
 */
public class AppointmentView
{
  private AppointmentPresenter appointmentPresenter;

  /**
   * @param theAppointmentPresenter AppointmentPresenter
   */
  public void setAppointmentPresenter(final AppointmentPresenter theAppointmentPresenter)
  {
    appointmentPresenter = theAppointmentPresenter;
  }

  private LocalDate datePickerdates;

  private LocalDate selectedDate;

  @SuppressWarnings("unused")
  private HashMap<String, List<String>> myMap = new HashMap<>();

  private Boolean clicked = false;

  private ImageView tempAddButton = new ImageView();

  // private Image image = new Image("/com/c4u/comm_emp/image/add_green_button.png");

  private HashMap<LocalDate, List<Node>> appointmentDrafts = new HashMap<>();

  private HashMap<String, InfoContainer> menuItems = new HashMap<>();

  private TextField plannerTitleField;

  private TextArea plannerNoteField, massageNoteField;

  private Pane plannerTimePane;

  @SuppressWarnings("rawtypes")
  private ComboBox plannerDurationDropBox, massageProviderDropBox, massageTimeDropBox, massageDurationDropBox;

  private ScrollPane menuScrollPane;

  private FlowPane menuFlowPane;

  private Label menuTotalPriceLabel;

  private List<Node> appointmentListNodes;

  private ResultSet resultSet;

  // @FXML
  // private FlowPane flowPane;

  private int userID = 0;

}
//
/// **
// * @throws SQLException
// */
// public void initialize()
// throws SQLException
// {
// setDatePickerSkinPane();
// userID = User.get_userId();
// System.out.println(User.get_userId());
// getHistory();
//
// MakeDraggable.performDragg(datePickerInnerPane);
// // ResultSet resultSet = new ConnectionClass("select * from loadhistory(1);").getResultSet();
// }
//
/// **
// * @throws SQLException
// */
// public void getHistory()
// throws SQLException
// {
//
// flowPane.setPrefWidth(1500);
// flowPane.setPrefHeight(310);
//
// final Accordion _accordion = new Accordion();
// _accordion.setMinSize(1600, 550);
//
// @SuppressWarnings("resource")
// final ResultSet _resultSet = new ConnectionClass("select * from loadhistory(" + User.get_userId() + ") limit 7;")
// .getResultSet();
// final SimpleDateFormat _dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
//
// while (_resultSet.next())
// {
//
// final Date _appDate = resultSet.getDate("appointment_date");
// final String _dateTime = _dateFormat.format(_appDate);
//
// @SuppressWarnings("resource")
// final ResultSet _massResultSet = new ConnectionClass(
// "select check_massage_app(" + userID + "," + "'" + resultSet.getDate("appointment_date") + "'" + ")").getResultSet();
// @SuppressWarnings("resource")
// final ResultSet _plannerResultSet = new ConnectionClass(
// "select check_planner_app(" + userID + "," + "'" + resultSet.getDate("appointment_date") + "'" + ")").getResultSet();
//
// final VBox _namesBox = new VBox();
// final VBox _pricesBox = new VBox();
// final HBox _orderItemsBox = new HBox();
// final VBox _quantityBox = new VBox();
// final Label _totalPriceBox = new Label();
// final VBox _mainBox = new VBox();
// _mainBox.setSpacing(30);
//
// _mainBox.setTranslateX(420);
// _orderItemsBox.setSpacing(30);
//
// final Label _paidLabel = new Label("");
// _paidLabel.setId("paidLabel");
// _paidLabel.setTranslateX(250);
// if (resultSet.getBoolean("massage_paid"))
// {
// _paidLabel.setText("Paid");
// }
// else
// {
// _paidLabel.setText("Not Paid");
// }
// _paidLabel.setTranslateX(500);
//
// final HBox _hbox = new HBox();
//
// // MASSAGE HISTORY RELATED ITEMS
//
// final FlowPane _massageFlowPane = new FlowPane();
// _massageFlowPane.setMaxWidth(533);
// _massageFlowPane.setMaxWidth(533);
// final Label _titleMassage = new Label("MASSAGE");
// _titleMassage.setStyle("-fx-font-weight: bold;");
// _massageFlowPane.getChildren().addAll(_titleMassage);
// _paidLabel.setVisible(false);
// final Label _massageLabel = new Label();
// _massageLabel.setText("Not items to display");
// _massageLabel.setPrefWidth(533);
// final Label _commentMassage = new Label();
//
// if (_massResultSet.next())
// {
//
// if (_massResultSet.getBoolean("check_massage_app"))
// {
// _massageLabel.setText("Your massage appointment is scheduled for: " + resultSet.getString("massage_time"));
// _commentMassage.setText("Your comment: " + resultSet.getString("massage_comment"));
// _paidLabel.setVisible(true);
// }
// // else {
// // massageLabel.setText("No items to display");
// // commentMassage.setText("lkj");
// // paidLabel.setVisible(false);
// // }
//
// // massageFlowPane.getChildren().add(new Label("Your comment: " + resultSet.getString("massage_comment")))
//
// }
// _massageFlowPane.getChildren().addAll(_massageLabel, _commentMassage);
//
// _hbox.getChildren().addAll(_paidLabel);
// _hbox.getChildren().addAll(_massageFlowPane);
//
// final Line _afterMassageLine = new Line();
// _afterMassageLine.setEndY(230);
// _afterMassageLine.setTranslateY(0);
// _hbox.getChildren().addAll((_afterMassageLine));
//
// // PLANNER HISTORY RELATED ITEMS
// final FlowPane _plannerPane = new FlowPane(Orientation.VERTICAL);
// _plannerPane.setMaxWidth(533);
// _plannerPane.setTranslateX(100);
//
// final Label _forPlanner = new Label("PLANNER");
// _forPlanner.setStyle("-fx-font-weight: bold;");
// final Label _plannerTitle = new Label();
// _plannerTitle.setText("No items to display");
//
// final Label _plannerDuration = new Label();
// _plannerDuration.setVisible(false);
//
// final Label _plannerNotes = new Label();
// _plannerNotes.setVisible(false);
//
// _plannerPane.getChildren().addAll(_forPlanner);
// _plannerPane.getChildren().addAll(_plannerTitle, _plannerDuration, _plannerNotes);
//
// if (_plannerResultSet.next())
// {
// if (_plannerResultSet.getBoolean("check_planner_app"))
// {
// _plannerTitle
// .setText("PLan title " + resultSet.getString("planner_title") + " at " + resultSet.getString("planner_time"));
// _plannerDuration.setVisible(true);
// _plannerDuration.setText("Duration " + resultSet.getString("planner_duration"));
// _plannerNotes.setVisible(true);
// _plannerDuration.setText(resultSet.getString("planner_notes"));
// }
// }
// // plannerPane.getChildren().addAll(new Label("PLan title " + resultSet.getString("planner_title") + " at " +
// // resultSet.getString("planner_time")));
// // plannerPane.getChildren().addAll(new Label("Duration " + resultSet.getString("planner_duration")));
// // plannerPane.getChildren().addAll(new Label(resultSet.getString("planner_notes")));
//
// final Line _afterPlannerLine = new Line();
// _afterPlannerLine.setEndY(230);
// _afterPlannerLine.setTranslateY(0);
// _afterPlannerLine.setTranslateX(533);
// _hbox.getChildren().addAll(_afterPlannerLine);
// _hbox.getChildren().addAll(plannerPane);
//
// // MENU HISTORY RELATED ITEMS
// @SuppressWarnings("unused")
// final FlowPane _menuPane = new FlowPane();
// final Label _foodPaneTitle = new Label("ORDERED FOOD");
// _foodPaneTitle.setStyle("-fx-font-weight: bold;");
//
// final HBox _titlesFood = new HBox();
// _titlesFood.setSpacing(20);
// _titlesFood.getChildren().addAll(new Label("Menu item"), new Label("Price"), new Label("Quantity"));
//
// menuPane.setMaxWidth(533);
// Label _foodName = new Label();
// Label _foodPrice = new Label();
// Label _foodQuantity = new Label();
// _foodName.setTranslateX(150);
// _foodPrice.setTranslateX(200);
// _foodQuantity.setTranslateX(250);
// // GETTING ARRAYS FROM DATABASE WITHOUT {} SYBMOBLS AND PUT IN LISTS
// //
// @SuppressWarnings("unchecked")
// final List<String> _myMenuNames = getSqlString(resultSet.getString("menu_names"));
// @SuppressWarnings("unchecked")
// final List<BigDecimal> _myPrices = getSqlDecimal(resultSet.getString("menu_individual_price"));
// @SuppressWarnings("unchecked")
// final List<Integer> _myQuantity = getSQlInt(resultSet.getString("menu_items_quantity"));
//
// // CASTING STRING TO DOUBLE FOR PRICES OF MENU ITEMS
//
// final ArrayList<InfoContainer> _arrayList = new ArrayList<>();
//
// for (int _i = 0; _i < _myMenuNames.size(); _i++)
// {
//
// final InfoContainer _cont = new InfoContainer(BigDecimal.valueOf(Double.parseDouble(String.valueOf(_myPrices.get(_i)))),
// _myQuantity.get(_i));
// _arrayList.add(_cont);
// final HashMap<String, InfoContainer> _hashMap = new HashMap<>();
// _hashMap.put(_myMenuNames.get(_i), _arrayList.get(_i));
// // menuItems.put(resultSet.getInt("appointment_id"), hashMap);
// menuItems.put(_myMenuNames.get(_i), _arrayList.get(_i));
// }
//
// for (final HashMap.Entry<String, InfoContainer> _entry : menuItems.entrySet())
// {
// final String _key = _entry.getKey();
// final InfoContainer _containerItems = _entry.getValue();
// System.out.println("Key = " + _key);
// System.out.println("Values = " + _containerItems.get_price() + " " + _containerItems.get_quantity());
// // menuPane.getChildren().addAll(new Label(key), new Label(containerItems.get_price().toString()), new
// // Label(containerItems.get_quantity().toString()));
// _foodName = new Label();
// _foodPrice = new Label();
// _foodQuantity = new Label();
//
// _foodName.setText(_key);
// _foodPrice.setText(_containerItems.get_price().toString());
// _foodQuantity.setText(_containerItems.get_quantity().toString());
//
// _namesBox.getChildren().addAll(_foodName);
// _pricesBox.getChildren().addAll(_foodPrice);
// _quantityBox.getChildren().addAll(_foodQuantity);
// }
//
// _totalPriceBox.setText("Your Total is: " + roundTo2Decimals(Double.valueOf(resultSet.getString("total_price"))));
// _totalPriceBox.setStyle("-fx-font-weight: bold;");
// _orderItemsBox.getChildren().addAll(_namesBox, _pricesBox, _quantityBox);
// _mainBox.getChildren().addAll(_foodPaneTitle, _titlesFood, _orderItemsBox, _totalPriceBox);
//
// menuPane.getChildren().addAll(_mainBox);
// menuItems = new HashMap<>();
// // for(int i=0; i<myMenuNames.size(); i++)
// // {
// // menuPane.getChildren().addAll(foodName);
// //// menuPane.getChildren().addAll(foodPrice);
// //// menuPane.getChildren().addAll(foodQuantity);
// //
// // }
// //
// System.out.println("******************");
//
// _hbox.getChildren().addAll(menuPane);
//
// final TitledPane _titledPane = new TitledPane(_dateTime.toUpperCase(), _hbox);
// _titledPane.setId("headerText");
// _accordion.getPanes().addAll(_titledPane);
// }
//
// // for (Map.Entry<Integer, HashMap<String, InfoContainer>> hashMapItem : menuItems.entrySet()) {
// //// HashMap<String, InfoContainer> innerHashMap=hashMapItem.getValue();
// ////
// //// for (HashMap name: menuItems) {
// ////
// //// }
// // System.out.println(menuItems.values());
// // }
// flowPane.getChildren().add(_accordion);
//
// }
//
/// **
// * @param theVal double
// * @return the double
// */
// double roundTo2Decimals(final double theVal)
// {
// final DecimalFormat _df2 = new DecimalFormat("###.##");
// return Double.valueOf(_df2.format(theVal));
// }
//
/// **
// * @param theResultSetString String
// * @return the List
// */
// @SuppressWarnings("rawtypes")
// private List getSqlString(final String theResultSetString)
// {
// final String _replacedString = theResultSetString.replaceAll("[{}]", "");
// List _tempList = null;
//
// if (_replacedString.contains(","))
// {
// _tempList = Arrays.asList(_replacedString.split(","));
// }
// // else {
// // System.out.println("else stmt");
// // tempList.add(replacedString);
// // }
// return _tempList;
// }
//
/// **
// * @param theResultSetString String
// * @return the List
// */
// @SuppressWarnings(
// { "rawtypes", "null" })
// private List getSqlDecimal(final String theResultSetString)
// {
// final String _replacedString = theResultSetString.replaceAll("[{}]", "");
// String[] _tempList = null;
// final List<BigDecimal> _decimalList = new ArrayList<>();
// if (_replacedString.contains(","))
// {
// _tempList = _replacedString.split(",");
// }
// for (final String _tempListItem : _tempList)
// {
// _decimalList.add(BigDecimal.valueOf(Double.valueOf(_tempListItem)));
// }
// return _decimalList;
// }
//
/// **
// * @param theResultSetString String
// * @return the List
// */
// @SuppressWarnings(
// { "rawtypes", "null" })
// private List getSQlInt(final String theResultSetString)
// {
// final String _replacedString = theResultSetString.replaceAll("[{}]", "");
// String[] _tempList = null;
// final List<Integer> _intList = new ArrayList<>();
// if (_replacedString.contains(","))
// {
// _tempList = _replacedString.split(",");
// }
// // else {
// // System.out.println("else stmt");
// // tempList.add(replacedString);
// // }
// for (final String _tempListItem : _tempList)
// {
// _intList.add(Integer.valueOf(_tempListItem));
// }
// return _intList;
// }
//
/// **
// * @return the ImageView
// */
// private ImageView setAddButton()
// {
// final ImageView _add_button = new ImageView();// create new image variable for + button
// _add_button.setId(String.valueOf(datePickerdates));
// _add_button.setImage(image);// give a background image
// _add_button.setStyle("-fx-cursor: hand !important;");// give a style on hover to appear hand(pointer)
// _add_button.setOnMouseClicked(new EventHandler<MouseEvent>()
// {// set the EventHandler on mouse click for appearing new pane that allows to user to add an sAppointment
// @Override
// public void handle(final MouseEvent theEvent)
// {
// selectedDate = LocalDate.parse(_add_button.getId());
//
// System.out.println(selectedDate);
// datePickerBackgroundPanePane.setVisible(true);// showing up background pane that has an event which helps to easily quit
// // from the pane where you can make an sAppointment
// datePickerInnerPane.setVisible(true);// showing up Appointments maker pane
// datePickerSkinPane.setDisable(true);// making datePickerSkinPane disable to avoid some bugs while working inside a
// // datePickerInnerPane
// appointmentDateLabel.setText(String.valueOf(selectedDate));// Initializing the value of current date that was chosen by
// // user above to the Appointments Label
// if (appointmentDrafts.get(selectedDate) == null)
// {
// try
// {
// setAppointmentInnerPane();
// }
// catch (final SQLException _e)
// {
// System.out.println(_e);
// }
// }
// else
// {
// final List<Node> _selectedDateListNodes = appointmentDrafts.get(selectedDate);
// appointmentListNodes = new ArrayList<>();
// for (final Node _selectedDateListsItem : _selectedDateListNodes)
// {
// if (_selectedDateListsItem.getId().contains("planner"))
// {
// plannerInnerPane.getChildren().addAll(_selectedDateListsItem);
// }
// else if (_selectedDateListsItem.getId().contains("massage"))
// {
// massageInnerPane.getChildren().addAll(_selectedDateListsItem);
// }
// else
// {
// menuInnerPane.getChildren().addAll(_selectedDateListsItem);
// System.out.println(_selectedDateListsItem);
// }
// appointmentListNodes.add(_selectedDateListsItem);
// }
// }
// }
// });
// _add_button.setVisible(false);// at first all add_buttons are hidden, only when you hover or press to the specific field of
// // calendar it appears in it.
// return _add_button;
// }
//
/// **
// * @throws SQLException
// */
// private void setAppointmentInnerPane()
// throws SQLException
// {
// plannerTitleField = CustomNodes.createTextField(235, 39, 93, 0, "Please enter the title",
// "plannerTitleField;" + selectedDate);
// plannerTimePane = CustomNodes.createTimePicker(235, 39, 93, 48, "plannerTimePane;" + selectedDate);
// plannerDurationDropBox = CustomNodes.createComboBox(235, 39, 93, 96, "Please select the duration",
// "plannerDurationDropBox;" + selectedDate);
// plannerNoteField = CustomNodes.createTextArea(235, 39, 93, 144, "Please type the comment...",
// "plannerNoteField;" + selectedDate);
// plannerInnerPane.getChildren().addAll(plannerTitleField, plannerTimePane, plannerDurationDropBox, plannerNoteField);
//
// massageProviderDropBox = CustomNodes.createComboBox(235, 39, 93, 0, "Please select the provider",
// "massageProviderDropBox;" + selectedDate);
// massageTimeDropBox = CustomNodes.createComboBox(235, 39, 93, 48, "Please select the time",
// "massageTimeDropBox;" + selectedDate);
// massageDurationDropBox = CustomNodes.createComboBox(235, 39, 93, 96, "Please select the duration",
// "massageDurationDropBox;" + selectedDate);
// massageNoteField = CustomNodes.createTextArea(235, 39, 93, 144, "Please type the comment...",
// "massageNoteField;" + selectedDate);
// massageInnerPane.getChildren().addAll(massageProviderDropBox, massageTimeDropBox, massageDurationDropBox, massageNoteField);
//
// menuScrollPane = CustomNodes.createMenuScrollPane(235, 180, 0, 0, "menuScrollPane;" + selectedDate);
// menuFlowPane = CustomNodes.createMenuFlowPane(215, 155, 0, 0, 5, 5, "menuFlowPane;" + selectedDate);
// menuTotalPriceLabel = CustomNodes.createTotalPriceLabel(93, 28, 110, 181, "0.00", "menuTotalPriceLabel;" + selectedDate);
// setMenuItems();
// menuScrollPane.setContent(menuFlowPane);
// menuInnerPane.getChildren().addAll(menuTotalPriceLabel, menuScrollPane);
//
// }
//
/// **
// * @throws SQLException
// */
// private void setDatePickerSkinPane()
// throws SQLException
// {
// final HashMap<String, HashMap<String, String>> _dateCellInfo = new HashMap<>();
// try
// {
// resultSet = new ConnectionClass("select * from loadhistory(" + User.get_userId() + ")").getResultSet();
// while (resultSet.next())
// {
// final HashMap<String, String> _resultSetHashMap = new HashMap<>();
// _resultSetHashMap.put("appointment_id", resultSet.getString("appointment_id"));
// _resultSetHashMap.put("appointment_date", resultSet.getString("appointment_date"));
// _resultSetHashMap.put("massage_time", resultSet.getString("massage_time"));
// _resultSetHashMap.put("massage_comment", resultSet.getString("massage_comment"));
// _resultSetHashMap.put("massage_paid", resultSet.getString("massage_paid"));
// _resultSetHashMap.put("massage_duration", resultSet.getString("massage_duration"));
// _resultSetHashMap.put("planner_title", resultSet.getString("planner_title"));
// _resultSetHashMap.put("planner_time", resultSet.getString("planner_time"));
// _resultSetHashMap.put("planner_duration", resultSet.getString("planner_duration"));
// _resultSetHashMap.put("planner_notes", resultSet.getString("planner_notes"));
// _resultSetHashMap.put("menu_ids", resultSet.getString("menu_ids"));
// _resultSetHashMap.put("menu_names", resultSet.getString("menu_names"));
// _resultSetHashMap.put("menu_individual_price", resultSet.getString("menu_individual_price"));
// _resultSetHashMap.put("menu_items_quantity", resultSet.getString("menu_items_quantity"));
// _resultSetHashMap.put("total_price", resultSet.getString("total_price"));
// _dateCellInfo.put(resultSet.getString("appointment_date"), _resultSetHashMap);
// }
// }
// catch (final SQLException _e)
// {
// System.out.println(_e);
// }
// final DatePicker _date_picker = new DatePicker();
// _date_picker.setShowWeekNumbers(false);
// _date_picker.setDayCellFactory(new Callback<DatePicker, DateCell>()
// {
// /**
// * {@inheritDoc}
// */
// @Override
// public DateCell call(final DatePicker theParam)
// {
// return new DateCell()
// {
// /**
// * {@inheritDoc}
// */
// @Override
// public void updateItem(final LocalDate theItem, final boolean theEmpty)
// {
// super.updateItem(theItem, theEmpty);
// if (theEmpty || theItem == null)
// {
// setText(null);
// setGraphic(null);
// }
// else
// {
// datePickerdates = theItem;
// final FlowPane _fPane = new FlowPane();
// final Label _lbl = new Label(getText());// current day set to label
// _lbl.setPrefWidth(190);// set label width
// _fPane.getChildren().add(_lbl);// add label to the top of flowPane
// if (LocalDate.now().getDayOfYear() <= theItem.getDayOfYear())
// {
// final ImageView _add_button = setAddButton();
// _fPane.getChildren().add(_add_button);// adding add_buttons(plus) all to the calendar fields
//
// setOnMouseClicked(new EventHandler<MouseEvent>()
// {
// /**
// * {@inheritDoc}
// */
// @Override
// public void handle(final MouseEvent theEvent)
// {
// clicked = true;
// _add_button.setVisible(true);
// tempAddButton = _add_button;
// }
// });
// setOnMouseEntered(new EventHandler<MouseEvent>()
// {
// @Override
// public void handle(final MouseEvent theEvent)
// {
// _add_button.setVisible(true);
// }
// });
// setOnMouseExited(new EventHandler<MouseEvent>()
// {
// @Override
// public void handle(final MouseEvent theEvent)
// {
// _add_button.setVisible(false);
// if (clicked)
// {
// tempAddButton.setVisible(true);
// }
// }
// });
// }
// _fPane.setMinHeight(100);
// _fPane.setPrefWidth(230);
//
// final HashMap<String, String> _resultSet1 = _dateCellInfo.get(theItem.toString());
// if (_resultSet1 != null)
// {
// final Label _plannerLabel = new Label(_resultSet1.get("planner_title") + " " + _resultSet1.get("planner_time"));
// _plannerLabel.setPrefWidth(190);
// _plannerLabel.setPrefHeight(20);
// final Label _massageLabel = new Label(
// "Massage time:" + _resultSet1.get("massage_time") + " Paid:" + _resultSet1.get("massage_paid"));
// _massageLabel.setPrefWidth(190);
// _massageLabel.setPrefHeight(20);
// final Label _menuLabel = new Label(_resultSet1.get("menu_names").replaceAll("[{}]", "") + "\n Price:"
// + String.valueOf(BigDecimal.valueOf(Double.valueOf(_resultSet1.get("total_price")))));
// _menuLabel.setPrefWidth(190);
// _menuLabel.setPrefHeight(40);
// _fPane.getChildren().addAll(_plannerLabel, _massageLabel, _menuLabel);
// }
//
// setGraphic(_fPane);
// setPrefWidth(230);
// setPrefHeight(100);
// }
// }
// };
// }
// });
// final DatePickerSkin _datePickerSkin = new DatePickerSkin(_date_picker);
// final Node _popupContent = _datePickerSkin.getPopupContent();
// datePickerSkinPane.getChildren().add(_popupContent);
// }
//
/// **
// * @param theEvent ActionEvent
// */
// public void chooseAppointment(final ActionEvent theEvent)
// {
// final ToggleButton _selectedToggle = (ToggleButton) theEvent.getSource();
// for (final Toggle _tempToggle : appointmentMenu.getToggles())
// {
// final ToggleButton _tg = (ToggleButton) _tempToggle;
// _tg.getStyleClass().removeAll("toggleBtnActive");
// }
// _selectedToggle.getStyleClass().addAll("toggleBtnActive");
// if (_selectedToggle.getId().equals("plannerToggle"))
// {
// massagePane.setVisible(false);
// menuPane.setVisible(false);
// plannerPane.setVisible(true);
// }
// else if (_selectedToggle.getId().equals("massageToggle"))
// {
// plannerPane.setVisible(false);
// menuPane.setVisible(false);
// massagePane.setVisible(true);
// }
// else
// {
// plannerPane.setVisible(false);
// massagePane.setVisible(false);
// menuPane.setVisible(true);
// }
// }
//
/// **
// * @throws SQLException
// */
// private void setMenuItems()
// throws SQLException
// {
// @SuppressWarnings(
// { "resource", })
// final ResultSet _resultSet = new ConnectionClass("SELECT * FROM menu").getResultSet();
// final HashMap<String, Double> _itemPrices = new HashMap<>();
// while (_resultSet.next())
// {
// final ToggleButton _foodToggleButton = CustomNodes.createFoodToggleButton(105, 105, 0, 0,
// _resultSet.getString("menu_name"), _resultSet.getDouble("price"), _resultSet.getString("directory"),
// _resultSet.getInt("menu_id"), selectedDate, menuTotalPriceLabel, _itemPrices);
// menuFlowPane.getChildren().add(_foodToggleButton);
// }
// }
//
/// **
// *
// */
// private void saveAppointmentDrafts()
// {
// final Object _tempa = appointmentDrafts.get(selectedDate);
// if (_tempa == null)
// {
// appointmentListNodes = new ArrayList<>();
// appointmentListNodes.add(plannerTitleField);
// appointmentListNodes.add(plannerNoteField);
// appointmentListNodes.add(plannerTimePane);
// appointmentListNodes.add(plannerDurationDropBox);
// appointmentListNodes.add(massageNoteField);
// appointmentListNodes.add(massageProviderDropBox);
// appointmentListNodes.add(massageTimeDropBox);
// appointmentListNodes.add(massageDurationDropBox);
// appointmentListNodes.add(menuScrollPane);
// appointmentListNodes.add(menuTotalPriceLabel);
// appointmentDrafts.put(selectedDate, appointmentListNodes);
// }
// else
// {
// appointmentDrafts.replace(selectedDate, appointmentListNodes);
// }
// plannerInnerPane.getChildren().clear();
// massageInnerPane.getChildren().clear();
// menuInnerPane.getChildren().clear();
// }
//
/// **
// *
// */
// public void performFinish()
// {
// menuFlowPane.getChildren().stream().filter(toggleBtn -> toggleBtn instanceof ToggleButton)
// .filter(toggleBtn -> ((ToggleButton) toggleBtn).isSelected())
// .forEach(toggleBtn -> System.out.println(toggleBtn.getId()));
// performExit();
// }
//
/// **
// *
// */
// public void performExit()
// {
// datePickerBackgroundPanePane.setVisible(false);
// datePickerInnerPane.setVisible(false);
// datePickerSkinPane.setDisable(false);
// saveAppointmentDrafts();
// }
//
/// **
// * @param theEvent theEvent
// * @throws IOException
// */
// @FXML
// public void signOut(final ActionEvent theEvent)
// throws IOException
// {
// new StageLoaderdd("Login.fxml", theEvent);
// }