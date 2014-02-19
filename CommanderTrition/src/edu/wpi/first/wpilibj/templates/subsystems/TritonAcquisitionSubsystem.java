/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import team2340.TritanBase;
import team2340.TritonDefinitions;
import toolkit.CANJaguarFactory;

import toolkit.LogitechF310;

/**
 *
 * @author Team2340
 */
public class TritonAcquisitionSubsystem extends Subsystem {
        private CANJaguar spinner;
          private CANJaguar arm;
         static private TritonAcquisitionSubsystem subsystem;
    /**
     *
     * @param acquisitionControl
     */
    private TritonAcquisitionSubsystem() {
       spinner =  CANJaguarFactory.getInstance().get(TritonDefinitions.TRITION_ACQUISITION_SPINNER_ID);
       arm = CANJaguarFactory.getInstance().get(TritonDefinitions.TRITION_ACQUISITION_ARM_ID);
     }
    
    static public TritonAcquisitionSubsystem getInstance() {
       if (subsystem == null) {
            subsystem = new TritonAcquisitionSubsystem();
        }
        return subsystem;
        
    }

    protected void initDefaultCommand() {
     
    }
    
    public void startSpinner() {
            try {
                spinner.setX(TritonDefinitions.TRITON_SPINNER_SPEED);
            } catch (CANTimeoutException ex) {
                System.out.println("Start Spinner Fail");
                ex.printStackTrace();
            }
    }
    
    public void stopSpinner() {
            try {
                spinner.setX(TritonDefinitions.TRITON_SPINNER_STOP);
            } catch (CANTimeoutException ex) {
                System.out.println("Stop Spinner Fail");
                ex.printStackTrace();
            }
    }
    
    public void reverseSpinner() {
            try {
                spinner.setX(TritonDefinitions.TRITON_SPINNER_REVERSE);
            } catch (CANTimeoutException ex) {
                System.out.println("reverseSpinner failed");
                ex.printStackTrace();
            }
    }
    
    public void armOut() {
            try {
                arm.setX(TritonDefinitions.ACQUISITION_ARM_OUT_SPEED);
            } catch (CANTimeoutException ex) {
                System.out.println("armOut Fail");
                ex.printStackTrace();
            }
    }
    
    public void armIn() {
            try {
                arm.setX(TritonDefinitions.ACQUISITION_ARM_IN_SPEED);
            } catch (CANTimeoutException ex) {
                System.out.println("armIn Fail");
                ex.printStackTrace();
            }
    }
    
    public void armStop() {
            try {
                arm.setX(TritonDefinitions.ARM_STOP);
            } catch (CANTimeoutException ex) {
                System.out.println("armStop Fail");
                ex.printStackTrace();
            }
    }
    


 
}
