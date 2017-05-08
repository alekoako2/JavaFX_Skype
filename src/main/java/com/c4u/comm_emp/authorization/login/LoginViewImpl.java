/*
 * LoginView.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.authorization.login;

import java.io.IOException;
import java.sql.SQLException;

import com.c4u.comm_emp.Main;
import com.c4u.comm_emp.MakeDraggable;
import com.c4u.comm_emp.service.CommEmpLogger;
import com.c4u.comm_emp.service.WindowDecoration;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * TODO : Description.
 */
public class LoginViewImpl extends LoginNodes implements LoginView
{
  ValidateEmail validateEmail;

  ValidatePassword validatePassword;

  WindowDecoration windowDecoration;

  Label backLabel;

  @Override
  public void setEvents(final ValidateEmail theValidateEmail, final ValidatePassword theValidatePassword)
  {
    // TODO Auto-generated method stub
    this.validateEmail = theValidateEmail;
    this.validatePassword = theValidatePassword;
  }

  /**
   * @throws IOException
   */
  @FXML
  private void initialize()
      throws IOException
  {
    initializeGUI();
  }

  /**
   * @throws IOException
   */
  private void initializeGUI()
      throws IOException
  {
    // TODO Auto-generated method stub
    windowDecoration = new WindowDecoration(getHeaderPane());
    backLabel = windowDecoration.getBack().getBackLabel();
    MakeDraggable.performDragg(Main.getPrimaryStage(), getHeaderPane());
    setButtons();
  }

  /**
   *
   */
  void setButtons()
      throws IOException
  {
    setPictures();
    setBack();
    getSignIn().setOnMouseClicked(new EventHandler<Event>()
    {
      @Override
      public void handle(final Event theEvent)
      {
        // TODO Auto-generated method stub
        try
        {
          if (getSignIn().getEllipsisString().equals("email"))
          {
            validateEmail.validateEMail();
          }
          else
          {
            validatePassword.validatePassword();
          }
        }
        catch (final SQLException _e)
        {
          CommEmpLogger.logSQLException(_e);
        }
        catch (final IOException _e)
        {
          // TODO Auto-generated catch block
          CommEmpLogger.logIOException(_e);
        }
      }
    });
    getEmailfield().setOnKeyReleased(new EventHandler<KeyEvent>()
    {

      @Override
      public void handle(final KeyEvent theEvent)
      {
        // TODO Auto-generated method stub
        if (theEvent.getCode() == KeyCode.ENTER)
        {
          try
          {
            validateEmail.validateEMail();
          }
          catch (final SQLException _e)
          {
            // TODO Auto-generated catch block
            CommEmpLogger.logSQLException(_e);
          }
        }
      }
    });

    getPasswordField().setOnKeyReleased(new EventHandler<KeyEvent>()
    {

      @Override
      public void handle(final KeyEvent theEvent)
      {
        // TODO Auto-generated method stub
        if (theEvent.getCode() == KeyCode.ENTER)
        {
          try
          {
            validatePassword.validatePassword();
          }
          catch (final SQLException _e)
          {
            // TODO Auto-generated catch block
            CommEmpLogger.logSQLException(_e);
          }
          catch (final IOException _e)
          {
            // TODO Auto-generated catch block
            CommEmpLogger.logIOException(_e);
          }
        }
      }
    });
  }

  /**
   * @throws IOException
   */
  public void setPictures()
      throws IOException
  {
  }

  @Override
  public void setBack()
  {
    // TODO Auto-generated method stub
    backLabel.setVisible(false);
    backLabel.setOnMouseClicked(new EventHandler<Event>()
    {
      @Override
      public void handle(final Event theEvent)
      {
        // TODO Auto-generated method stub
        System.out.println("asdasdas");
        getEmailfield().setVisible(true);
        getPasswordField().setVisible(false);
        getEmailfield().getStyleClass().removeAll("incorrectTextField");
        getPasswordField().getStyleClass().removeAll("incorrectTextField");
        getPasswordField().clear();
        getWarningLabel().setVisible(false);
        if (getEmailfield().visibleProperty() != null)
        {
          backLabel.setVisible(false);
        }
      }
    });

  }

  @Override
  public void emailPassed()
  {
    // TODO Auto-generated method stub
    getEmailfield().setVisible(false);
    getPasswordField().setVisible(true);
    getEmailfield().getStyleClass().removeAll("incorrectTextField");
    getWarningLabel().setVisible(false);
    backLabel.setVisible(true);
    getSignIn().setEllipsisString("password");
  }

  @Override
  public void emailRejected()
  {
    // TODO Auto-generated method stub
    getWarningLabel().setText("Incorrect Email");
    getEmailfield().getStyleClass().addAll("incorrectTextField");
    getWarningLabel().setVisible(true);
  }

  @Override
  public void passwordPassed()
  {
    // TODO Auto-generated method stub
    System.out.println("sworia");
    getPasswordField().getStyleClass().removeAll("incorrectTextField");
    getWarningLabel().setVisible(false);
    backLabel.setVisible(true);
    getSignIn().setEllipsisString("email");
  }

  @Override
  public void passwordRejected()
  {
    // TODO Auto-generated method stub
    getWarningLabel().setText("Incorrect password");
    getPasswordField().getStyleClass().addAll("incorrectTextField");
    getWarningLabel().setVisible(true);
  }

  @Override
  public String getEMail()
  {
    return getEmailfield().getText();
  }

  @Override
  public String getPassword()
  {
    return getPasswordField().getText();
  }
}