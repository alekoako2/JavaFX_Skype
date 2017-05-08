/*
 * package-info.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.authorization.forgotPassword;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.c4u.comm_emp.service.Exit;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/** ForgotPassword class. **/
public class ForgotPasswordController
{
  /** userEmail String. **/
  public static String userEmail = null;

  @FXML
  private TextField resetEmail;

  @FXML
  private Label warningLabel;

  @FXML
  private Label resetPasswordInstruction;

  @FXML
  private ImageView userIcon;

  @FXML
  private Button resetPasswordBtn;

  @FXML
  private Button submitCodeBtn;

  /**
   * 
   */
  public static String tempocode;

  @FXML
  private Pane forgotPasswordPane;

  @FXML
  private Pane mainPane;

  @FXML
  private ImageView loadImage;

  @FXML
  private Pane newPasswordPane;

  @FXML
  private TextField newpass1;

  @FXML
  private TextField newpass2;

  @FXML
  private Button resetEmailBtn;

  @FXML
  private Label labelWarning;

  @FXML
  private Hyperlink goBackBtn;

  @FXML
  private Hyperlink goBackBtn2;

  @FXML
  private Pane anotherPane;

  @FXML
  private ImageView succsessGif;

  @FXML
  private Label succsessLabel;

  @FXML
  private Pane succsessPane;

  /** Method that loads LOGIN pane. **/
  /**
   * @param aEvent ActionEvent
   * @throws InterruptedException
   ***/
  @FXML
  private void loadLogin(final ActionEvent aEvent)
      throws IOException, InterruptedException
  {
    // new StageLoaderdd("Login.fxml", aEvent);
  }

  /** Method that loads FORGOT PASSWORD panel **/
  /**
   * @param aEvent ActionEvent
   * @throws InterruptedException
   ***/
  @FXML
  private void loadForgotPassword(final ActionEvent aEvent)
      throws IOException, InterruptedException
  {
    // new StageLoaderdd("ForgotPassword.fxml", aEvent);
  }

  /** Calling Exit class, that Exits the applications. **/
  @FXML
  private void initialize()
  {
    // forgotPasswordPane.setVisible(true);
    @SuppressWarnings("unused")
    final Exit _exitBtn = new Exit(forgotPasswordPane);
  }

  static int count;

  private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  /** Generating verification code. **/
  /** Method that loads FORGOT PASSWORD panel **/
  /**
   * @param aCount int
   * @return integer
   ***/

  public String randomAlphaNumeric(final int aCount)
  {
    count = aCount;
    final StringBuilder _aBuilder = new StringBuilder();
    while (count-- != 0)
    {
      final int _aCharacter = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
      _aBuilder.append(ALPHA_NUMERIC_STRING.charAt(_aCharacter));
    }
    System.out.println("maria");
    System.out.println(_aBuilder.toString());
    tempocode = _aBuilder.toString();
    return tempocode;
  }

  // Loading image gif
  Image image = new Image(getClass().getResourceAsStream("/com/c4u/comm_emp/image/load.gif"));

  /** Method called when button "reset" is pressed. **/
  @FXML
  private void sendOnSubmit()
      throws SQLException
  {

    codeValidation();
    if (!resetEmail.getText().equals(""))
    {
      final String _recipientMail = "verifyourpwd@gmail.com";
      final String _recipientPassword = "18052010M+m";
      final String _recipient = resetEmail.getText();
      final String _subject = "Password recovery";
      final String _resetCode = randomAlphaNumeric(5);
      final String _body = "Your password is ... " + _resetCode;
      System.out.println(_body + " " + _resetCode);
      sendPassword(_recipientMail, _recipientPassword, _recipient, _subject, _body);

    }
    else
    {
      warningLabel.setVisible(true);
      warningLabel.setText("This email doesn't exist in our system!");
    }
    userEmail = resetEmail.getText();
  }

  private Thread threadTwo;

  private Thread threadOne;

  /** helper method for SENDONSUBMIT. Makes a connection and sends email with the verification code to user. **/
  /**
   * @param aSender String
   * @param aPass String
   * @param aReciever String
   * @param aSubject String
   * @param aBody String
   * @throws SQLException
   ***/
  @SuppressWarnings("resource")
  public void sendPassword(final String aSender, final String aPass, final String aReciever, final String aSubject,
      final String aBody)
      throws SQLException
  {
    count = 0;

    try
    {
      Connection _aConnect = null;
      PreparedStatement _aStmt = null;
      ResultSet _aResultSet = null;
      _aConnect = DriverManager.getConnection("jdbc:postgresql://10.3.12.28:5432/postgres", "postgres", "18052010M+m");
      _aStmt = _aConnect.prepareStatement("select * from users where email = ?");
      _aStmt.setString(1, resetEmail.getText());
      _aResultSet = _aStmt.executeQuery();
      if (_aResultSet.next())
      {
        if (_aResultSet.getString("email").equals(resetEmail.getText()))
        {
          threadTwo = new Thread()
          {
            @Override
            public void run()
            {
              mainPane.setVisible(false);
              loadImage.setVisible(true);
            }
          };
          threadOne = new Thread()
          {
            @Override
            public void run()
            {
              warningLabel.setVisible(false);
              final Properties _aProps = System.getProperties();
              final String _aHost = "smtp.gmail.com";
              _aProps.put("mail.smtp.starttls.enable", "true");
              _aProps.put("mail.smtp.host", _aHost);
              _aProps.put("mail.smtp.user", aReciever);
              _aProps.put("mail.smtp.password", aPass);
              _aProps.put("mail.smtp.port", "587");
              _aProps.put("mail.smtp.auth", "true");
              final Session _aSession = Session.getDefaultInstance(_aProps);
              final MimeMessage _aMessage = new MimeMessage(_aSession);
              try
              {
                _aMessage.setFrom(new InternetAddress(aSender));
                _aMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(aReciever));
                _aMessage.setSubject(aSubject);
                _aMessage.setText(aBody);
                final Transport _aTransport = _aSession.getTransport("smtp");
                _aTransport.connect(_aHost, aSender, aPass);
                _aTransport.sendMessage(_aMessage, _aMessage.getAllRecipients());
                _aTransport.close();
                resetCodeFunc();
              }
              catch (final AddressException _aDressEx)
              {
                System.out.println(_aDressEx);
              }
              catch (final MessagingException _aMessageEx)
              {
                System.out.println(_aMessageEx);
              }
            }
          };
          threadOne.start();
          threadTwo.start();
        }
      }
      else
      {
        warningLabel.setVisible(true);
        warningLabel.setText("This email doesn't exist in our system!");
      }
      _aConnect.close();
      // System.out.println("First connection CLOSED");
    }
    catch (final Exception _e)
    {
      System.out.println(_e);
    }
  }

  // SETTING TIMER

  Timer timer = new Timer();

  int secondsPassed = 0;

  /** Validation the code entered by user. **/
  @FXML
  public void codeValidation()
  {

    final TimerTask _aTask = new TimerTask()
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
            System.out.println("Seconds passed: " + secondsPassed);
            if (secondsPassed == 100)
            {
              warningLabel.setVisible(true);
              timer.cancel();
              final String _newTempoCode = randomAlphaNumeric(5);
              tempocode = _newTempoCode;
              warningLabel.setText("Your code is no longer valid. Please go back");
              System.out.println(tempocode);

            }
          }
        });
      }

    };
    timer.scheduleAtFixedRate(_aTask, 1000, 1000);
  }

  /** Method that prompts user to enter the code, sent to the email. **/
  public void resetCodeFunc()
  {
    mainPane.setVisible(true);
    loadImage.setVisible(false);
    Platform.runLater(new Runnable()
    {
      @Override
      public void run()
      {
        goBackBtn.setVisible(false);
        goBackBtn2.setVisible(true);
        resetPasswordInstruction.textProperty()
            .setValue("The code was sent to your email. \n Please enter it in the field below");
        resetEmail.setText("");
        resetPasswordBtn.setVisible(false);
        userIcon.visibleProperty().setValue(false);
        submitCodeBtn.setVisible(true);
      }
    });
  }

  /** method that calls new password panel, where user should enter new password and confirm it. **/
  /**
   * @param aEvent ActionEvent
   * @throws IOException
   * @throws InterruptedException
   * @throws SQLException
   */
  @FXML
  private void newPasswordPrompt(final ActionEvent aEvent)
      throws IOException, InterruptedException, SQLException
  {

    warningLabel.setText("");

    if (resetEmail.getText().equals(tempocode))
    {
      resetPasswordBtn.setVisible(true);
      warningLabel.setVisible(false);
      // new StageLoaderdd("NewPasswordPane.fxml", aEvent);
    }
    else
    {
      ++count;
      warningLabel.setVisible(true);
      warningLabel.setText("The code is not correct!");
      // if (count == 3) {
      // System.out.println("Locked");
      // Thread.sleep(5000);
      // }
    }
    System.out.println("5 " + resetEmail.getText());
  }

  /** method called on resetPasswordBtn, checks if the previous password was the same and sets a new one if not. **/
  @SuppressWarnings("resource")
  @FXML
  private void resetEmail()
  {
    succsessPane.setVisible(false);

    try
    {
      Connection _aConnect = null;
      @SuppressWarnings("unused")
      final Connection _aConnect2 = null;
      PreparedStatement _aState = null;
      PreparedStatement _aState2 = null;
      ResultSet _aRsSet = null;
      @SuppressWarnings("unused")
      ResultSet _aRsSet2 = null;
      _aConnect = DriverManager.getConnection("jdbc:postgresql://10.3.12.28:5432/postgres", "postgres", "18052010M+m");
      System.out.println("connection OK");
      _aState = _aConnect.prepareStatement("select * from validation('" + userEmail + "','" + newpass1.getText() + "')");

      if (newpass1.getText().equals(newpass2.getText()))
      {
        _aRsSet = _aState.executeQuery();
        while (_aRsSet.next())
        {
          System.out.println(_aRsSet.getBoolean("validation_result"));
          if (_aRsSet.getBoolean("validation_result"))
          {
            System.out.println("password is in db");
            labelWarning.setText("Do not use the previous password!");
          }
          else
          {
            final boolean _valid = passValidator(newpass1.getText());
            if (_valid)
            {
              labelWarning.setVisible(false);
              _aState2 = _aConnect.prepareStatement("select changepassword('" + userEmail + "','" + newpass1.getText() + "')");
              System.out.println("for aleko " + userEmail + " password " + newpass1.getText());
              _aRsSet2 = _aState2.executeQuery();
              anotherPane.setVisible(false);
              succsessPane.setVisible(true);
              succsessGif.setVisible(true);

              succsessLabel.setText("Your password was succesfully changed!");
            }
            else
            {
              labelWarning.setVisible(true);
              labelWarning.setText("The password should have at least one capital letter, one number and one symbol!");
            }
          }
        }
      }
      else
      {
        System.out.println("do not match");
        labelWarning.setText("The passwords do not match!");

      }
    }
    catch (final Exception _e)
    {
      System.out.println(_e);
    }
  }

  /** Password validator function. **/
  /**
   * @param aPassword String
   * @return boolean
   */

  private boolean passValidator(final String aPassword)
  {
    final String _aRule = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
    final java.util.regex.Pattern _p = java.util.regex.Pattern.compile(_aRule);
    final java.util.regex.Matcher _m = _p.matcher(aPassword);
    return _m.matches();
  }

}
