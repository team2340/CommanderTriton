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
public class SlowLookUp extends CommandBase{
    
    public SlowLookUp(){
        requires(theBox);
        setTimeout(1);
        
    }

    protected void initialize() {
    }

    protected void execute() {
        theBox.lookUp();
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
