/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commandgroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.RaiseArm;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;

/**
 *
 * @author Team2340
 */
public class PrepareToShoot extends CommandGroup{
    public PrepareToShoot(){
        addParallel(new RaiseArm());
        addParallel(new ShootBall());
    }
    
}
