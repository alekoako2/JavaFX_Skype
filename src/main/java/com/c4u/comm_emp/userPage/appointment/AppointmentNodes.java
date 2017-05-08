/*
 * AppointmentNodes.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.userPage.appointment;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

/**
 * TODO : Description.
 */
public class AppointmentNodes
{
  @FXML
  protected Pane datePickerSkinPane;

  @FXML
  protected Pane datePickerBackgroundPanePane;

  @FXML
  protected Pane datePickerInnerPane;

  @FXML
  protected ToggleGroup appointmentMenu;

  @FXML
  protected ToggleButton plannerToggle;

  @FXML
  protected Pane plannerPane;

  @FXML
  protected Pane massagePane;

  @FXML
  protected Pane menuPane;

  @FXML
  protected Label appointmentDateLabel;

  @FXML
  protected Button appointmentFinishButton;

  @FXML
  protected Pane plannerInnerPane;

  @FXML
  protected Pane massageInnerPane;

  @FXML
  protected Pane menuInnerPane;

  private LocalDate datePickerdates;

  private LocalDate selectedDate;

  private HashMap<String, List<String>> myMap = new HashMap<>();

  private Boolean clicked = false;

  private ImageView tempAddButton = new ImageView();

  private Image image = new Image("/com/c4u/comm_emp/image/add_green_button.png");

  private HashMap<LocalDate, List<Node>> appointmentDrafts = new HashMap<>();

  private TextField plannerTitleField;

  private TextArea plannerNoteField, massageNoteField;

  private Pane plannerTimePane;

  @SuppressWarnings("rawtypes")
  private ComboBox plannerDurationDropBox, massageProviderDropBox, massageTimeDropBox, massageDurationDropBox;

  private ScrollPane menuScrollPane;

  private FlowPane menuFlowPane;

  private Label menuTotalPriceLabel;

  private List<Node> appointmentListNodes;

  /**
   * @return Button
   */
  public Button getAppointmentFinishButton()
  {
    return appointmentFinishButton;
  }

  /**
   * @return Boolean
   */
  public Boolean getClicked()
  {
    return clicked;
  }

  /**
   * @return HashMap
   */
  public HashMap<String, List<String>> getMyMap()
  {
    return myMap;
  }

  /**
   * @return Image
   */
  public Image getImage()
  {
    return image;
  }

  /**
   * @return ComboBox
   */
  @SuppressWarnings("rawtypes")
  public ComboBox getPlannerDurationDropBox()
  {
    return plannerDurationDropBox;
  }

  /**
   * @return HashMap
   */
  public HashMap<LocalDate, List<Node>> getAppointmentDrafts()
  {
    return appointmentDrafts;
  }

  /**
   * @return ImageView
   */
  public ImageView getTempAddButton()
  {
    return tempAddButton;
  }

  /**
   * @return label
   */
  public Label getAppointmentDateLabel()
  {
    return appointmentDateLabel;
  }

  /**
   * @return LocalDate
   */
  public LocalDate getDatePickerdates()
  {
    return datePickerdates;
  }

  /**
   * @return ComboBox
   */
  @SuppressWarnings("rawtypes")
  public ComboBox getMassageProviderDropBox()
  {
    return massageProviderDropBox;
  }

  /**
   * @return LocalDate
   */
  public LocalDate getSelectedDate()
  {
    return selectedDate;
  }

  /**
   * @return Pane
   */
  public Pane getDatePickerBackgroundPanePane()
  {
    return datePickerBackgroundPanePane;
  }

  /**
   * @return ComboBox
   */
  @SuppressWarnings("rawtypes")
  public ComboBox getMassageTimeDropBox()
  {
    return massageTimeDropBox;
  }

  /**
   * @return Pane
   */
  public Pane getDatePickerInnerPane()
  {
    return datePickerInnerPane;
  }

  /**
   * @return ComboBox
   */
  @SuppressWarnings("rawtypes")
  public ComboBox getMassageDurationDropBox()
  {
    return massageDurationDropBox;
  }

  /**
   * @return Pane
   */
  public Pane getDatePickerSkinPane()
  {
    return datePickerSkinPane;
  }

  /**
   * @return FlowPane
   */
  public FlowPane getMenuFlowPane()
  {
    return menuFlowPane;
  }

  /**
   * @return Label
   */
  public Label getMenuTotalPriceLabel()
  {
    return menuTotalPriceLabel;
  }

  /**
   * @return List
   */
  public List<Node> getAppointmentListNodes()
  {
    return appointmentListNodes;
  }

  /**
   * @return Pane
   */
  public Pane getMassageInnerPane()
  {
    return massageInnerPane;
  }

  /**
   * @return Pane
   */
  public Pane getMassagePane()
  {
    return massagePane;
  }

  /**
   * @return Pane
   */
  public Pane getMenuInnerPane()
  {
    return menuInnerPane;
  }

  /**
   * @return Pane
   */
  public Pane getMenuPane()
  {
    return menuPane;
  }

  /**
   * @return Pane
   */
  public Pane getPlannerInnerPane()
  {
    return plannerInnerPane;
  }

  /**
   * @return Pane
   */
  public Pane getPlannerPane()
  {
    return plannerPane;
  }

  /**
   * @return Pane
   */
  public Pane getPlannerTimePane()
  {
    return plannerTimePane;
  }

  /**
   * @return ScrollPane
   */
  public ScrollPane getMenuScrollPane()
  {
    return menuScrollPane;
  }

  /**
   * @return TextArea
   */
  public TextArea getMassageNoteField()
  {
    return massageNoteField;
  }

  /**
   * @return TextArea
   */
  public TextArea getPlannerNoteField()
  {
    return plannerNoteField;
  }

  /**
   * @return TextField
   */
  public TextField getPlannerTitleField()
  {
    return plannerTitleField;
  }

  /**
   * @return ToggleButton
   */
  public ToggleButton getPlannerToggle()
  {
    return plannerToggle;
  }

  /**
   * @return ToggleGroup
   */
  public ToggleGroup getAppointmentMenu()
  {
    return appointmentMenu;
  }

  /**
   * @param theMassageTimeDropBox ComboBox
   */
  public void setMassageTimeDropBox(@SuppressWarnings("rawtypes")
  final ComboBox theMassageTimeDropBox)
  {
    this.massageTimeDropBox = theMassageTimeDropBox;
  }

  /**
   * @param theAppointmentDateLabel Label
   */
  public void setAppointmentDateLabel(final Label theAppointmentDateLabel)
  {
    this.appointmentDateLabel = theAppointmentDateLabel;
  }

  /**
   * @param theAppointmentDrafts HashMap
   */
  public void setAppointmentDrafts(final HashMap<LocalDate, List<Node>> theAppointmentDrafts)
  {
    this.appointmentDrafts = theAppointmentDrafts;
  }

  /**
   * @param theAppointmentFinishButton Button
   */
  public void setAppointmentFinishButton(final Button theAppointmentFinishButton)
  {
    this.appointmentFinishButton = theAppointmentFinishButton;
  }

  /**
   * @param theAppointmentMenu ToggleGroup
   */
  public void setAppointmentMenu(final ToggleGroup theAppointmentMenu)
  {
    this.appointmentMenu = theAppointmentMenu;
  }

  /**
   * @param theClicked Boolean
   */
  public void setClicked(final Boolean theClicked)
  {
    this.clicked = theClicked;
  }

  /**
   * @param theDatePickerBackgroundPanePane Pane
   */
  public void setDatePickerBackgroundPanePane(final Pane theDatePickerBackgroundPanePane)
  {
    this.datePickerBackgroundPanePane = theDatePickerBackgroundPanePane;
  }

  /**
   * @param theDatePickerdates LocalDate
   */
  public void setDatePickerdates(final LocalDate theDatePickerdates)
  {
    this.datePickerdates = theDatePickerdates;
  }

  /**
   * @param theDatePickerInnerPane Pane
   */
  public void setDatePickerInnerPane(final Pane theDatePickerInnerPane)
  {
    this.datePickerInnerPane = theDatePickerInnerPane;
  }

  /**
   * @param theDatePickerSkinPane theDatePickerSkinPane
   */
  public void setDatePickerSkinPane(final Pane theDatePickerSkinPane)
  {
    this.datePickerSkinPane = theDatePickerSkinPane;
  }

  /**
   * @param theImage Image
   */
  public void setImage(final Image theImage)
  {
    this.image = theImage;
  }

  /**
   * @param theMassageInnerPane Pane
   */
  public void setMassageInnerPane(final Pane theMassageInnerPane)
  {
    this.massageInnerPane = theMassageInnerPane;
  }

  /**
   * @param theAppointmentListNodes List
   */
  public void setAppointmentListNodes(final List<Node> theAppointmentListNodes)
  {
    this.appointmentListNodes = theAppointmentListNodes;
  }

  /**
   * @param theMassageNoteField TextArea
   */
  public void setMassageNoteField(final TextArea theMassageNoteField)
  {
    this.massageNoteField = theMassageNoteField;
  }

  /**
   * @param theMassagePane Pane
   */
  public void setMassagePane(final Pane theMassagePane)
  {
    this.massagePane = theMassagePane;
  }

  /**
   * @param theMenuInnerPane Pane
   */
  public void setMenuInnerPane(final Pane theMenuInnerPane)
  {
    this.menuInnerPane = theMenuInnerPane;
  }

  /**
   * @param theMassageProviderDropBox ComboBox
   */
  public void setMassageProviderDropBox(@SuppressWarnings("rawtypes")
  final ComboBox theMassageProviderDropBox)
  {
    this.massageProviderDropBox = theMassageProviderDropBox;
  }

  /**
   * @param theMassageDurationDropBox theMassageDurationDropBox
   */
  public void setMassageDurationDropBox(@SuppressWarnings("rawtypes")
  final ComboBox theMassageDurationDropBox)
  {
    this.massageDurationDropBox = theMassageDurationDropBox;
  }

  /**
   * @param theMenuPane theMenuPane
   */
  public void setMenuPane(final Pane theMenuPane)
  {
    this.menuPane = theMenuPane;
  }

  /**
   * @param theMenuFlowPane FlowPane
   */
  public void setMenuFlowPane(final FlowPane theMenuFlowPane)
  {
    this.menuFlowPane = theMenuFlowPane;
  }

  /**
   * @param theMenuScrollPane ScrollPane
   */
  public void setMenuScrollPane(final ScrollPane theMenuScrollPane)
  {
    this.menuScrollPane = theMenuScrollPane;
  }

  /**
   * @param theMenuTotalPriceLabel Label
   */
  public void setMenuTotalPriceLabel(final Label theMenuTotalPriceLabel)
  {
    this.menuTotalPriceLabel = theMenuTotalPriceLabel;
  }

  /**
   * @param theMyMap HashMap
   */
  public void setMyMap(final HashMap<String, List<String>> theMyMap)
  {
    this.myMap = theMyMap;
  }

  /**
   * @param thePlannerDurationDropBox ComboBox
   */
  public void setPlannerDurationDropBox(@SuppressWarnings("rawtypes")
  final ComboBox thePlannerDurationDropBox)
  {
    this.plannerDurationDropBox = thePlannerDurationDropBox;
  }

  /**
   * @param thePlannerInnerPane Pane
   */
  public void setPlannerInnerPane(final Pane thePlannerInnerPane)
  {
    this.plannerInnerPane = thePlannerInnerPane;
  }

  /**
   * @param thePlannerNoteField TextArea
   */
  public void setPlannerNoteField(final TextArea thePlannerNoteField)
  {
    this.plannerNoteField = thePlannerNoteField;
  }

  /**
   * @param thePlannerPane Pane
   */
  public void setPlannerPane(final Pane thePlannerPane)
  {
    this.plannerPane = thePlannerPane;
  }

  /**
   * @param thePlannerTimePane Pane
   */
  public void setPlannerTimePane(final Pane thePlannerTimePane)
  {
    this.plannerTimePane = thePlannerTimePane;
  }

  /**
   * @param thePlannerTitleField TextField
   */
  public void setPlannerTitleField(final TextField thePlannerTitleField)
  {
    this.plannerTitleField = thePlannerTitleField;
  }

  /**
   * @param thePlannerToggle thePlannerToggle
   */
  public void setPlannerToggle(final ToggleButton thePlannerToggle)
  {
    this.plannerToggle = thePlannerToggle;
  }

  /**
   * @param theSelectedDate LocalDate
   */
  public void setSelectedDate(final LocalDate theSelectedDate)
  {
    this.selectedDate = theSelectedDate;
  }

  /**
   * @param theTempAddButton ImageView
   */
  public void setTempAddButton(final ImageView theTempAddButton)
  {
    this.tempAddButton = theTempAddButton;
  }

}
