/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import team2340.TritonDefinitions;

/**
 *
 * @author Team2340
 */
public class AcquireBallCommand extends CommandBase{
    
    public AcquireBallCommand() {
        requires(acquisition);
        setTimeout(TritonDefinitions.TRITON_SPINNER_TIMEOUT);
    }

    protected void initialize() { }

    protected void execute() {
        acquisition.startSpinner();     
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        acquisition.stopSpinner();
    }

    protected void interrupted() { 
        end();
    }
    
}
