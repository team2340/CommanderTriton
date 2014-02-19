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
public class RepelBallCommand extends CommandBase{

    public RepelBallCommand() {
        requires(acquisition);
        setTimeout(2);
    }
    protected void initialize() {
    
    }

    protected void execute() {
        acquisition.reverseSpinner();
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