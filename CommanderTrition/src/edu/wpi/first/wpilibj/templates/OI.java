
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.templates.commands.*;
import team2340.TritonDefinitions;
import toolkit.LogitechF310;
import toolkit.Direction;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    LogitechF310 driveController = new LogitechF310("Drive Controller",
            TritonDefinitions.TRITON_DRIVE_CONTROLLER_PORT);
    
    LogitechF310 shooterController = new LogitechF310("Shooter Controller",
            TritonDefinitions.TRITON_DRIVE_CONTROLLER_PORT);
    
      public OI() {
          checkShooterController();
          checkDriverController();

         

    }
    private void checkShooterController(){
             shooterController.getAButton().whenPressed(new ShootBall());
         shooterController.getRBButton().whenPressed(new LookUp());
         shooterController.getLBButton().whenPressed(new SlowLookUp() );
         shooterController.getLTButton().whenPressed(new SlowLookDown() );
         shooterController.getRTButton().whenPressed(new LookDown());
    }
    private void checkDriverController(){         
        driveController.getXButton().whenPressed(new LowerArm());
         driveController.getYButton().whenPressed(new RaiseArm());
         driveController.getAButton().whenPressed(new AcquireBallCommand());
         driveController.getBButton().whenPressed(new RepelBallCommand());

    }
    public double getRightStickY() {
        return driveController.getRightStick().getY();
    }
    
    public double getLeftStickY() {
        return driveController.getLeftStick().getY();
    }
    
    public Direction getRightStick() {
        return driveController.getRightStick();
    }
    
    public LogitechF310 getDriveController() {
        return driveController;
    }
}

