/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import toolkit.LogitechF310;

/**
 *
 * @author Team2340
 */
public class DriveWithControllerCommand extends CommandBase{

        private LogitechF310 controller;
        
    public DriveWithControllerCommand() {
        requires(drive);
        controller = oi.getDriveController();
    }
    protected void initialize() {}

    protected void execute() { 
      drive.mainDrive(controller.getLeftStick(), controller.getRightStick(), controller.getDPad(), controller.getRB(), controller.getLB(), controller.getRT(), controller.getLT());
         
    }

    protected boolean isFinished() { return false; }

    protected void end() {  }

    protected void interrupted() {  }
    
}
