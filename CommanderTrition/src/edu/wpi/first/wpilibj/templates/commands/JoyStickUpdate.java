/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Team2340
 */
public class JoyStickUpdate extends CommandBase{
    private String joyStick;
    
    public JoyStickUpdate(String joystick) {
        this.joyStick = joystick;
        setTimeout(.1);
    }

    protected void initialize() { }

    protected void execute() {
        SmartDashboard.putBoolean(joyStick, true);
    }

    protected boolean isFinished() {
    return isTimedOut();
            }

    protected void end() {
        SmartDashboard.putBoolean(joyStick, false);
    }

    protected void interrupted() {}
    
}
