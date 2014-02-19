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
public class MoveForwardXRotations extends CommandBase {
    int numRotations;
    public MoveForwardXRotations (int numberOfRotations){
        requires(drive);
        numRotations = numberOfRotations;
        
    }

    protected void initialize() {
   }

    protected void execute() {
        drive.forwardXRotations(numRotations);
        
   }

    protected boolean isFinished() {
        return false;
  }

    protected void end() {
   }

    protected void interrupted() {
  }
    
}
