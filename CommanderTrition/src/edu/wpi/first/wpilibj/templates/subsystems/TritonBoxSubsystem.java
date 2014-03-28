/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import team2340.TritonDefinitions;
import toolkit.CANJaguarFactory;

/**
 *
 * @author Team2340
 */
public class TritonBoxSubsystem extends Subsystem{
     private CANJaguar boxMotor;
     private CANJaguar topFlyWheel;
     private CANJaguar bottomFlyWheel;

     
     static private TritonBoxSubsystem subsystem;
    
    private TritonBoxSubsystem() {
       topFlyWheel = CANJaguarFactory.getInstance().get(TritonDefinitions.TRITION_TOP_FLY_WHEEL_ID);
        bottomFlyWheel = CANJaguarFactory.getInstance().get(TritonDefinitions.TRITION_BOTTOM_FLY_WHEEL_ID);
        boxMotor = CANJaguarFactory.getInstance().get(TritonDefinitions.TRITON_BOX_MOTOR_ID);
        

        
    }
    
    static public TritonBoxSubsystem getInstance() {
        if (subsystem == null) {
            subsystem = new TritonBoxSubsystem();
        }
        return subsystem;
        
    }

    protected void initDefaultCommand() {
       }
    
    public void lookUp() {
         try {
             boxMotor.setX(TritonDefinitions.BOX_UP_SPEED);
         } catch (CANTimeoutException ex) {
             System.out.println(" look up failure");
             ex.printStackTrace();
         }
    }
    
    public void lookDown() {
         try {
             boxMotor.setX(TritonDefinitions.BOX_DOWN_SPEED);
         } catch (CANTimeoutException ex) {
             System.out.println(" look down failure");
             ex.printStackTrace();
         }

    }
    
    public void stopLooking() {
         try {
             boxMotor.setX(TritonDefinitions.BOX_SPEED_STOP);
         } catch (CANTimeoutException ex) {
             System.out.println(" Stop looking failure");
             ex.printStackTrace();
         }
    }
    
    public boolean lookingUp() {
        boolean lookingUp = false;
         try {
             lookingUp = !boxMotor.getForwardLimitOK();
         } catch (CANTimeoutException ex) {
             System.out.println(" lookING Up failure");
             ex.printStackTrace();
         }
        return lookingUp;
    }
    
    public boolean lookingDown(){
        boolean lookingDown = false;
         try {
             lookingDown = !boxMotor.getReverseLimitOK();
         } catch (CANTimeoutException ex) {
             System.out.println(" lookING down failure");
             ex.printStackTrace();
         }
        return lookingDown;
    }
    
    public void startFlyWheels() {
         try {
             topFlyWheel.setX(TritonDefinitions.TOP_FLYWHEEL_SPEED);
             bottomFlyWheel.setX(TritonDefinitions.BOTTOM_FLYWHEEL_SPEED);
         } catch (CANTimeoutException ex) {
             System.out.println(" startFlyWheel Fail");
             ex.printStackTrace();
         }
    }
    
    public void stopFlyWheel() {
         try {
             topFlyWheel.setX(TritonDefinitions.FLYWHEEL_STOP);
             bottomFlyWheel.setX(TritonDefinitions.FLYWHEEL_STOP);
         } catch (CANTimeoutException ex) {
             ex.printStackTrace();
         }
    }
    
}
