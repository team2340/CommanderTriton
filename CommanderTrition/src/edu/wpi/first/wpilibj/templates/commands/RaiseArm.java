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
public class RaiseArm extends CommandBase{

    public RaiseArm() {
        requires(acquisition);
        setTimeout(TritonDefinitions.ACQUISITION_ARM_TIMEOUT);
    }


    protected void initialize() {
    }

    protected void execute() {
        acquisition.armOut();
    }

    protected boolean isFinished() {
        //return true;
        return isTimedOut();
    }

    protected void end() {
        acquisition.armStop();
    }

    protected void interrupted() {
        end();
    }
    
}
