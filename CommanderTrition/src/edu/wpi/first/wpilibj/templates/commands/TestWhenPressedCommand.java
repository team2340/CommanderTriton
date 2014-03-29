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
public class TestWhenPressedCommand extends CommandBase {
    public TestWhenPressedCommand() {
    }

    protected void initialize() {
    }

    protected void execute() {
        System.out.println( " When Pressed " );
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        System.out.println( " When Released " );
        
    }

    protected void interrupted() {
        end();
    }
    
}
