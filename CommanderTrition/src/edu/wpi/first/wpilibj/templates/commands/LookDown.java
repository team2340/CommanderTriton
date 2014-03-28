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
public class LookDown extends CommandBase{
    public LookDown() {
        requires(theBox);
        setTimeout(0.5);
    }

    protected void initialize() { }

    protected void execute() {
        theBox.lookDown();
    }

    protected boolean isFinished() {
        return isTimedOut();
       }

    protected void end() {
        theBox.stopLooking();
    }

    protected void interrupted() {
        end(); 
    }
    
}
