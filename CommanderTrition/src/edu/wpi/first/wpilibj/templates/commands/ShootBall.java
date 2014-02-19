/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Team2340
 */
public class ShootBall extends CommandBase{
    
    public ShootBall() {
        requires(theBox);
        //requires(acquisition);
        setTimeout(10);
    }

    protected void initialize() { }

    protected void execute() {
        theBox.lookUp();
        theBox.startFlyWheels();
        //acquisition.startSpinner();
        //acquisition.armIn();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        theBox.stopFlyWheel();
        //acquisition.stopSpinner();
        //acquisition.armStop();
    }

    protected void interrupted() {
    }
    
}
