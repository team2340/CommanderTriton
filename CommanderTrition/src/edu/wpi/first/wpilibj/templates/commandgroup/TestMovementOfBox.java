/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commandgroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 *
 * @author Team2340
 */
public class TestMovementOfBox extends CommandGroup {
    public TestMovementOfBox () {
            addSequential (new MoveForwardXRotations(4));
            addSequential (new MoveLeftXRotations(4));
            addSequential (new ReverseXRotations(4));
            addSequential (new MoveRightXRotations(4));
           
            
    }
    }

