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
public class LowerArm extends CommandBase{

    public LowerArm() {
        requires(acquisition);
    }
    protected void initialize() {
    }

    protected void execute() {
        acquisition.armIn();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
