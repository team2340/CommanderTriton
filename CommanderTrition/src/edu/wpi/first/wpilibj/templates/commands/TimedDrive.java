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
public class TimedDrive extends CommandBase {

    private String direction; // LEFT, RIGHT, FROWARD, BACKWARD
    public TimedDrive( String direction, double time) {
        requires(drive);
        setTimeout(time);
        this.direction = direction;
    }
    protected void initialize() {
    }

    protected void execute() {
        try{
        if (direction.equalsIgnoreCase(TritonDefinitions.TIMEDDRIVE_FORWARD)) {
            drive.forward(.65);
        }
        else if (direction.equalsIgnoreCase(TritonDefinitions.TIMEDDRIVE_BACKWARD)) {
            drive.reverse(.65);
        }
        else if (direction.equalsIgnoreCase(TritonDefinitions.TIMEDDRIVE_LEFT)) {
            
        }
        else if (direction.equalsIgnoreCase(TritonDefinitions.TIMEDRIVE_RIGHT)) {
            
        }
        }
        catch (Exception ex) {
            System.out.println( "TIMED DRIVE EXCEPTION");
        }
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        drive.driveBreak();
    }

    protected void interrupted() {
        drive.driveBreak();
    }
    
}
