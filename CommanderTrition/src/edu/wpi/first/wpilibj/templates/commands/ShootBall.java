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
    private double shootSpeed = 1.0;
    public ShootBall(double speed) {
        requires(theBox);
        setTimeout(5);
        shootSpeed = speed;
    }

    protected void initialize() { }
        //requires(acquisition);

    protected void execute() {
        //theBox.lookUp();
        theBox.startFlyWheelsSpeed(shootSpeed);
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
