/*
 * AppointmentController.java
 * Copyright (c) 1999-2016 by Community4you GmbH
 */
package com.c4u.comm_emp.userPage.appointment;

import javafx.stage.Stage;

/**
 * Created by aphatsatsia on 03.11.16.
 */

@SuppressWarnings("restriction")
public class AppointmentPresenter
{
  private AppointmentView appointmentView;

  private AppointmentModel appointmentModel;

  private Stage primaryStage;

  /**
   * @param theAppointmentView AppointmentView
   * @param theAppointmentModel AppointmentModel
   * @param thePrimaryStage Stage
   */
  public AppointmentPresenter(final AppointmentView theAppointmentView, final AppointmentModel theAppointmentModel,
      final Stage thePrimaryStage)
  {
    // TODO Auto-generated constructor stub
    this.appointmentView = theAppointmentView;
    this.appointmentModel = theAppointmentModel;
    this.primaryStage = thePrimaryStage;
  }
}
