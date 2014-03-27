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
public class HoldArm extends CommandBase{

    public HoldArm() {
        requires(acquisition);
    }
    protected void initialize() {
    }

    protected void execute() {
        acquisition.armStop();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
