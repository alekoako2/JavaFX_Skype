/*
 * package-info.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

/**
 * Created by aphatsatsia on 10.11.16.
 */
public class CustomNodes
{
  /**
   * @param theWidth int
   * @param theHeight int
   * @param theLayoutX int
   * @param theLayoutY int
   * @param thePromptText String
   * @param theId String
   * @return TextField
   */
  public static TextField createTextField(final int theWidth, final int theHeight, final int theLayoutX, final int theLayoutY,
      final String thePromptText, final String theId)
  {
    final TextField _plannerTitleField = new TextField();
    _plannerTitleField.getStyleClass().addAll("AppointmentInput");
    _plannerTitleField.setStyle("-fx-cursor: text");
    _plannerTitleField.setLayoutX(theLayoutX);
    _plannerTitleField.setLayoutY(theLayoutY);
    _plannerTitleField.setPrefWidth(theWidth);
    _plannerTitleField.setPrefHeight(theHeight);
    _plannerTitleField.setPromptText(thePromptText);
    _plannerTitleField.setId(theId);
    return _plannerTitleField;
  }

  /**
   * @param theWidth int
   * @param theHeight int
   * @param theLayoutX int
   * @param theLayoutY int
   * @param thePromptText String
   * @param theId String
   * @return ComboBox
   */
  @SuppressWarnings("rawtypes")
  public static ComboBox createComboBox(final int theWidth, final int theHeight, final int theLayoutX, final int theLayoutY,
      final String thePromptText, final String theId)
  {
    final ComboBox _plannerTimeDropBox = new ComboBox();
    _plannerTimeDropBox.getStyleClass().addAll("AppointmentInput");
    _plannerTimeDropBox.setLayoutX(theLayoutX);
    _plannerTimeDropBox.setLayoutY(theLayoutY);
    _plannerTimeDropBox.setPrefWidth(theWidth);
    _plannerTimeDropBox.setPrefHeight(theHeight);
    _plannerTimeDropBox.setPromptText(thePromptText);
    _plannerTimeDropBox.setId(theId);
    return _plannerTimeDropBox;
  }

  /**
   * @param theWidth int
   * @param theHeight int
   * @param theLayoutX int
   * @param theLayoutY int
   * @param theId String
   * @return Pane
   */
  public static Pane createTimePicker(final int theWidth, final int theHeight, final int theLayoutX, final int theLayoutY,
      final String theId)
  {
    final Pane _timePickerPane = new Pane();
    _timePickerPane.setPrefWidth(theWidth);
    _timePickerPane.setPrefHeight(theHeight);
    _timePickerPane.setLayoutX(theLayoutX);
    _timePickerPane.setLayoutY(theLayoutY);
    _timePickerPane.setId(theId);

    final TextField _hourTextField = new TextField(LocalTime.now().format(DateTimeFormatter.ofPattern("hh")));
    final TextField _minuteTextField = new TextField(LocalTime.now().format(DateTimeFormatter.ofPattern("mm")));
    final Label _colonLabel = new Label(":");
    final ImageView _imageViewUp = new ImageView();
    final ImageView _imageViewDown = new ImageView();
    _imageViewUp.setImage(new Image("com/c4u/comm_emp/image/up.png"));
    _imageViewDown.setImage(new Image("com/c4u/comm_emp/image/up.png"));

    _hourTextField.setPrefWidth(45);
    _hourTextField.setPrefHeight(39);
    _hourTextField.setLayoutX(45);
    _hourTextField.getStyleClass().addAll("AppointmentInput");
    _hourTextField.setStyle("-fx-padding: 0;-fx-text-fill: #0ba4e3;-fx-font-size: 32");

    _minuteTextField.setPrefWidth(45);
    _minuteTextField.setPrefHeight(39);
    _minuteTextField.setLayoutX(110);
    _minuteTextField.getStyleClass().addAll("AppointmentInput");
    _minuteTextField.setStyle("-fx-padding: 0;-fx-text-fill: #0ba4e3;-fx-font-size: 32");

    timeTextFieldsValidator(_hourTextField, _minuteTextField);

    _colonLabel.setPrefHeight(36);
    _colonLabel.setLayoutX(95);
    _colonLabel.setLayoutY(-3);
    _colonLabel.setStyle("-fx-text-fill: #0ba4e3;-fx-font-size: 31");

    _imageViewUp.setFitWidth(24);
    _imageViewUp.setFitHeight(15);
    _imageViewUp.setLayoutX(161);
    _imageViewUp.setLayoutY(5);
    _imageViewUp.setStyle("-fx-cursor: hand");

    _imageViewDown.setFitWidth(24);
    _imageViewDown.setFitHeight(15);
    _imageViewDown.setLayoutX(161);
    _imageViewDown.setLayoutY(18);
    _imageViewDown.setStyle("-fx-cursor: hand;-fx-rotate: 180");

    _timePickerPane.getChildren().addAll(_hourTextField, _colonLabel, _minuteTextField, _imageViewUp, _imageViewDown);

    return _timePickerPane;
  }

  /**
   * @param theHourTextField TextField
   * @param theMinuteTextField TextField
   */
  private static void timeTextFieldsValidator(final TextField theHourTextField, final TextField theMinuteTextField)
  {
    final int[] _count =
    { 0, 0 };
    final int[] _antiLoop =
    { 0, 0 };
    final Boolean[] _regexChecker =
    { false, false, false };
    final Boolean[] _regexCheckerMinutes =
    { false, false };

    theHourTextField.setOnMouseClicked(new EventHandler<MouseEvent>()
    {
      @Override
      public void handle(final MouseEvent theEvent)
      {
        theHourTextField.selectAll();
      }
    });
    theHourTextField.setOnKeyTyped(new EventHandler<KeyEvent>()
    {
      @Override
      public void handle(final KeyEvent theEvent)
      {
        if (theEvent.getCharacter().matches("[0-9]"))
        {

          if (_antiLoop[0] == 0)
          {
            System.out.println(theEvent.getCharacter());
            _regexChecker[0] = theEvent.getCharacter().matches("[0-2]+");
            _regexChecker[1] = theEvent.getCharacter().matches("[0-4]+");
            if (_count[0] == 0)
            {
              if (_regexChecker[0])
              {
                theHourTextField.setText("0");
                _count[0]++;
                if (theEvent.getCharacter().equals("2"))
                {
                  _regexChecker[2] = true;
                }
              }
              else
              {
                theEvent.consume();
              }
            }
            else
            {
              if (_regexChecker[2])
              {
                if (_regexChecker[1])
                {
                  theHourTextField.setText(theHourTextField.getText().substring(0, 1));
                  _count[0]++;
                  theHourTextField.positionCaret(1);
                  _regexChecker[2] = false;
                }
                else
                {
                  theEvent.consume();
                }
              }
              else
              {
                theHourTextField.setText(theHourTextField.getText().substring(0, 1));
                _count[0]++;
                theHourTextField.positionCaret(1);
              }
            }
          }
          else
          {
            theEvent.consume();
          }
          _antiLoop[0]++;
        }
        else
        {
          theEvent.consume();
        }
      }
    });
    theHourTextField.setOnKeyReleased(new EventHandler<KeyEvent>()
    {
      @Override
      public void handle(final KeyEvent theEvent)
      {
        theHourTextField.selectAll();
        if (theHourTextField.getText().equals("24"))
        {
          theHourTextField.setText("00");
        }
        if (_count[0] == 2)
        {
          theHourTextField.requestFocus();
          _count[0] = 0;
        }
        _antiLoop[0] = 0;
      }
    });

    theHourTextField.setOnMouseClicked(new EventHandler<MouseEvent>()
    {
      @Override
      public void handle(final MouseEvent theEvent)
      {
        theMinuteTextField.selectAll();
      }
    });
    theMinuteTextField.setOnKeyTyped(new EventHandler<KeyEvent>()
    {
      @Override
      public void handle(final KeyEvent theEvent)
      {
        if (theEvent.getCharacter().matches("[0-9]+"))
        {
          if (_antiLoop[1] == 0)
          {
            _regexCheckerMinutes[0] = theEvent.getCharacter().matches("[0-6]+");
            if (_count[1] == 0)
            {
              if (_regexCheckerMinutes[0])
              {
                theMinuteTextField.setText("0");
                _count[1]++;
                if (theEvent.getCharacter().equals("6"))
                {
                  _regexCheckerMinutes[1] = true;
                }
              }
              else
              {
                theEvent.consume();
              }
            }
            else
            {
              theMinuteTextField.setText(theMinuteTextField.getText().substring(0, 1));
              _count[1]++;
              theMinuteTextField.positionCaret(1);
            }
          }
          else
          {
            theEvent.consume();
          }
          _antiLoop[1]++;
        }
        else
        {
          theEvent.consume();
        }
      }
    });
    theMinuteTextField.setOnKeyReleased(new EventHandler<KeyEvent>()
    {
      @Override
      public void handle(final KeyEvent theEvent)
      {
        if (_regexCheckerMinutes[1])
        {
          theMinuteTextField.setText("00");
          _regexCheckerMinutes[1] = false;
          _count[1] = 0;
        }
        if (_count[1] == 2)
        {
          System.out.println("me var");
          _count[1] = 0;
        }
        theMinuteTextField.selectAll();
        _antiLoop[1] = 0;
      }
    });
  }

  /**
   * @param theWidth int
   * @param theHeight int
   * @param theLayoutX int
   * @param theLayoutY int
   * @param thePromptText String
   * @param theId String
   * @return TextArea
   */
  public static TextArea createTextArea(final int theWidth, final int theHeight, final int theLayoutX, final int theLayoutY,
      final String thePromptText, final String theId)
  {
    final TextArea _plannerNoteField = new TextArea();
    _plannerNoteField.getStyleClass().addAll("AppointmentInput");
    _plannerNoteField.setLayoutX(theLayoutX);
    _plannerNoteField.setLayoutY(theLayoutY);
    _plannerNoteField.setPrefWidth(theWidth);
    _plannerNoteField.setPrefHeight(theHeight);
    _plannerNoteField.setPromptText(thePromptText);
    _plannerNoteField.setId(theId);
    return _plannerNoteField;
  }

  /**
   * @param theWidth int
   * @param theHeight int
   * @param theLayoutX int
   * @param theLayoutY int
   * @param theId String
   * @return ScrollPane
   */
  public static ScrollPane createMenuScrollPane(final int theWidth, final int theHeight, final int theLayoutX,
      final int theLayoutY, final String theId)
  {
    final ScrollPane _menuScrollPane = new ScrollPane();
    _menuScrollPane.setLayoutX(theLayoutX);
    _menuScrollPane.setLayoutY(theLayoutY);
    _menuScrollPane.setPrefWidth(theWidth);
    _menuScrollPane.setPrefHeight(theHeight);
    _menuScrollPane.setId(theId);
    return _menuScrollPane;
  }

  /**
   * @param theWidth int
   * @param theHeight int
   * @param theLayoutX int
   * @param theLayoutY int
   * @param theVGap int
   * @param theHGap int
   * @param theId String
   * @return FlowPane
   */
  public static FlowPane createMenuFlowPane(final int theWidth, final int theHeight, final int theLayoutX, final int theLayoutY,
      final int theVGap, final int theHGap, final String theId)
  {
    final FlowPane _menuFlowPane = new FlowPane();
    _menuFlowPane.setLayoutX(theLayoutX);
    _menuFlowPane.setLayoutY(theLayoutY);
    _menuFlowPane.setPrefWidth(theWidth);
    _menuFlowPane.setPrefHeight(theHeight);
    _menuFlowPane.setVgap(theVGap);
    _menuFlowPane.setHgap(theHGap);
    _menuFlowPane.setId(theId);
    return _menuFlowPane;
  }

  /**
   * @param theWidth int
   * @param theHeight int
   * @param theLayoutX int
   * @param theLayoutY int
   * @param theMenuName String
   * @param thePrice Double
   * @param theImageDirectory String
   * @param theMenuId int
   * @param theSelectedDate LocalDate
   * @param theMenuTotalPriceLabel Label
   * @param theItemPrices HashMap
   * @return ToggleButton
   */
  public static ToggleButton createFoodToggleButton(final int theWidth, final int theHeight, final int theLayoutX,
      final int theLayoutY, final String theMenuName, final Double thePrice, final String theImageDirectory,
      final int theMenuId, final LocalDate theSelectedDate, final Label theMenuTotalPriceLabel,
      final HashMap<String, Double> theItemPrices)
  {
    final ToggleButton _foodToggleButton = new ToggleButton(theMenuName + " \n\n\n\n\n€" + thePrice);
    _foodToggleButton.setPrefWidth(theWidth);
    _foodToggleButton.setPrefHeight(theHeight);
    _foodToggleButton.setStyle("-fx-background-image: url('" + theImageDirectory + "');");
    _foodToggleButton.getStyleClass().addAll("menuItemsStyle");
    _foodToggleButton.setAlignment(Pos.TOP_CENTER);
    final String _key = String.valueOf(theMenuId) + theMenuName + theSelectedDate;
    _foodToggleButton.setId(_key);
    theItemPrices.put(_key, thePrice);
    _foodToggleButton.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(final ActionEvent theEvent)
      {
        final BigDecimal _tempTotalPrice = new BigDecimal(theMenuTotalPriceLabel.getText());
        final ToggleButton _clickedFoodToggleBtn = (ToggleButton) theEvent.getSource();
        final BigDecimal _itemPrice = BigDecimal.valueOf(theItemPrices.get(_clickedFoodToggleBtn.getId()));
        if (_foodToggleButton.isSelected())
        {
          theMenuTotalPriceLabel.setText(String.valueOf(_tempTotalPrice.add(_itemPrice)));
          _clickedFoodToggleBtn.getStyleClass().add("menuItemsStyleActive");
        }
        else
        {
          theMenuTotalPriceLabel.setText(String.valueOf(_tempTotalPrice.subtract(_itemPrice)));
          _clickedFoodToggleBtn.getStyleClass().removeAll("menuItemsStyleActive");
        }
      }
    });
    return _foodToggleButton;
  }

  /**
   * @param theWidth int
   * @param theHeight int
   * @param theLayoutX int
   * @param theLayoutY int
   * @param theValue String
   * @param theId String
   * @return Label
   */
  public static Label createTotalPriceLabel(final int theWidth, final int theHeight, final int theLayoutX, final int theLayoutY,
      final String theValue, final String theId)
  {
    final Label _totalPriceLabel = new Label();
    _totalPriceLabel.setStyle("-fx-text-fill:#0096c9;-fx-font-size: 18;-fx-font-weight: bold");
    _totalPriceLabel.setLayoutX(theLayoutX);
    _totalPriceLabel.setLayoutY(theLayoutY);
    _totalPriceLabel.setPrefWidth(theWidth);
    _totalPriceLabel.setPrefHeight(theHeight);
    _totalPriceLabel.setText(theValue);
    _totalPriceLabel.setId(theId);
    return _totalPriceLabel;
  }

}
