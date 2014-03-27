/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commandgroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.AcquireBallCommand;
import edu.wpi.first.wpilibj.templates.commands.RaiseArm;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;
import edu.wpi.first.wpilibj.templates.commands.TimedDrive;
import team2340.TritonDefinitions;

/**
 *
 * @author Team2340
 */
public class BasicAuto extends CommandGroup{
    public BasicAuto() {
        addSequential(new TimedDrive(TritonDefinitions.TIMEDDRIVE_FORWARD, 2.0));
        addParallel(new ShootBall());
        addParallel(new RaiseArm());
        addParallel(new AcquireBallCommand());
        
    }
    
}
