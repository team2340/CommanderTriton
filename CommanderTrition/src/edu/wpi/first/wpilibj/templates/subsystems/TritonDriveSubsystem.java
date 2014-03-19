/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Watchdog;
import team2340.TritonDefinitions;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import toolkit.CANJaguarFactory;
import toolkit.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.DriveWithControllerCommand;
import toolkit.CANJaguarModeSwitcher;

/**
 *
 * @author Team 2340
 */
public class TritonDriveSubsystem extends Subsystem {

    static private TritonDriveSubsystem subsystem;
    CANJaguarModeSwitcher jagMode;
    CANJaguar frontLeft;
    CANJaguar frontRight;
    CANJaguar backLeft;
    CANJaguar backRight;
    double p;
    double i;
    double d;

    static public TritonDriveSubsystem getInstance() {
        System.out.println(" Triton Drive Subsystem get instance");
        if (subsystem == null) {
            subsystem = new TritonDriveSubsystem();
        }
        return subsystem;
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithControllerCommand());
    }

    private TritonDriveSubsystem() {
        System.out.println("TritionDriveSubsystem created");
        jagMode = new CANJaguarModeSwitcher();
        frontLeft = jagMode.initializeOpenLoop(TritonDefinitions.TRITION_FRONTLEFT_DRIVE_JAG_ID);
        backLeft = jagMode.initializeOpenLoop(TritonDefinitions.TRITION_BACKLEFT_DRIVE_JAG_ID);
        frontRight = jagMode.initializeOpenLoop(TritonDefinitions.TRITION_FRONTRIGHT_DRIVE_JAG_ID);
        backRight = jagMode.initializeOpenLoop(TritonDefinitions.TRITION_BACKRIGHT_DRIVE_JAG_ID);
        SmartDashboard.putData(this);

    }

    public void forward(double value) throws CANTimeoutException {
        System.out.println(" F: " + value);
        yAxis(value);
    }

    public void reverse(double value) throws CANTimeoutException {
        System.out.println(" R: " + value);
        yAxis(value);
    }

    public void left(double value) throws CANTimeoutException {
        System.out.println(" L: " + value);
        xAxis(value);
    }

    public void right(double value) throws CANTimeoutException {
        System.out.println(" R: " + value);
        xAxis(value);
    }

    synchronized private void xAxis(double value) throws CANTimeoutException {
        frontRight.setX(value * -1);
        frontLeft.setX(-1 * value);
        backRight.setX(value);
        backLeft.setX(value);
    }

    synchronized private void yAxis(double value) throws CANTimeoutException {
        frontRight.setX(value);
        frontLeft.setX(value * -1);
        backRight.setX(value);
        backLeft.setX(value * -1);
    }

    synchronized private void spin(double value) throws CANTimeoutException {
        frontRight.setX(value);
        frontLeft.setX(value);
        backRight.setX(value);
        backLeft.setX(value);
    }

    synchronized public void driveBreak() {
        try {
            frontRight.setX(0.0);
            frontLeft.setX(0.0);
            backRight.setX(0.0);
            backLeft.setX(0.0);
        } catch (Exception ex) {
            System.out.println("Exception driveBreak");
            ex.printStackTrace();
        }
    }

    synchronized private void directionalDrive(Direction leftSide, Direction rightSide, double scaleFactor) {
        try {
        double leftValue = leftSide.getY() * scaleFactor;
        double rightValue = rightSide.getY() * scaleFactor * -1;
        System.out.println(" Directional Drive: " + leftValue + " r: " + rightValue);
        frontLeft.setX(leftValue);
        backLeft.setX(leftValue);
        frontRight.setX(rightValue);
        backRight.setX(rightValue);
        } catch (Exception ex) {ex.printStackTrace();}
        

    }

    private CANJaguar initializeCANJag(int id, int clicksPerRev) {
        //CANJaguar canJag = CANJaguarFactory.getInstance().get(id, CANJaguar.ControlMode.kSpeed);
        CANJaguar canJag = CANJaguarFactory.getInstance().get(id, CANJaguar.ControlMode.kPercentVbus);
        try {
            //logger.log("initialize driveJag", id);

            //canJag.configEncoderCodesPerRev(clicksPerRev);
            //canJag.setPID(p, i, d);
            //canJag.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
            //canJag.changeControlMode(CANJaguar.ControlMode.kSpeed);
            //canJag.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            //canJag.enableControl();   
            //canJag.configNeutralMode(CANJaguar.NeutralMode.kCoast);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return canJag;
    }

   

    public void controlledDrive(double xValue, double yValue) {
        SmartDashboard.putNumber("SpeedTest", yValue);
        SmartDashboard.putNumber("SpeedGraph", xValue);
        try {
            if (xValue == 0.0 && yValue > 0.0) {
                forward(yValue);
            } else if (xValue == 0.0 && yValue < 0.0) {
                reverse(yValue);
            } else if (xValue > 0.0 && yValue == 0.0) {
                right(xValue);
            } else if (xValue < 0.0 && yValue == 0.0) {
                left(xValue);
            } else {
                   driveBreak();
            }

        } catch (Exception ex) {
            System.out.println("controlledDrive Exception");
        }
    }

    public void mainDrive(Direction leftDirection, Direction rightDirection, Direction dPad, boolean rightBack,
            boolean leftBack, boolean rightTop, boolean leftTop) {
            
            double driveSetting = 0.75;
            try {
            driveSetting = SmartDashboard.getNumber("DriverSlider");
            SmartDashboard.putNumber("DriverBox", driveSetting);
            } catch (Exception ex) {}
            if ( dPad.getX() != 0 || dPad.getY() != 0) {
            controlledDrive((driveSetting * dPad.getX()), (driveSetting * dPad.getY())); 
            }
            else if ( leftDirection.getY() != 0 || rightDirection.getY() != 0) {
            directionalDrive(leftDirection, rightDirection, driveSetting);
            }
            else {
                driveBreak();
            }

    }
//TODO: VERIFY LEFT/RIGHT MOVEMENT
//TODO: VERIFY NUMROTATIONS DISTANCE
    public void forwardXRotations(double numRotations) {
        try {
            double currentFrontLeftPos = frontLeft.getPosition();
            double currentFrontRightPos = frontRight.getPosition();
            double currentBackLeftPos = backLeft.getPosition();
            double currentBackRightPos = backRight.getPosition();
            frontLeft.setX(numRotations + currentFrontLeftPos);
            frontRight.setX(numRotations + currentFrontRightPos);
            backLeft.setX(numRotations + currentBackLeftPos);
            backRight.setX(numRotations + currentBackRightPos);
        } catch (CANTimeoutException ex) {
           System.out.println("forward X rotations failed");
         
            ex.printStackTrace();
        }
    }
    public void reverseXRotations (double numRotations) {
        try {
            double currentFrontLeftPos = frontLeft.getPosition();
            double currentFrontRightPos = frontRight.getPosition();
            double currentBackLeftPos = backLeft.getPosition();
            double currentBackRightPos = backRight.getPosition();
            frontLeft.setX(numRotations - currentFrontLeftPos);
            frontRight.setX(numRotations - currentFrontRightPos);
            backLeft.setX(numRotations - currentBackLeftPos);
            backRight.setX(numRotations - currentBackRightPos);
        } catch (CANTimeoutException ex) {
            System.out.println("reverse X rotations failed");
            ex.printStackTrace();
        }
    }
    public void leftXRotations (double numRotations) {
        try {
            double currentFrontLeftPos = frontLeft.getPosition();
            double currentFrontRightPos = frontRight.getPosition();
            double currentBackLeftPos = backLeft.getPosition();
            double currentBackRightPos = backRight.getPosition();
            frontLeft.setX(numRotations + currentFrontLeftPos);
            frontRight.setX(numRotations + currentFrontRightPos);
            backLeft.setX(numRotations - currentBackLeftPos);
            backRight.setX(numRotations - currentBackRightPos);
        } catch (CANTimeoutException ex) {
           System.out.println("left X rotations failed");
            ex.printStackTrace();
        }
    }
    public void rightXRotations (double numRotations) {
        try {
            double currentFrontLeftPos = frontLeft.getPosition();
            double currentFrontRightPos = frontRight.getPosition();
            double currentBackLeftPos = backLeft.getPosition();
            double currentBackRightPos = backRight.getPosition();
            frontLeft.setX(numRotations + currentFrontLeftPos);
            frontRight.setX(numRotations + currentFrontRightPos);
            backLeft.setX(numRotations - currentBackLeftPos);
            backRight.setX(numRotations - currentBackRightPos);
        } catch (CANTimeoutException ex) {
            System.out.println("right X rotations failed");
            ex.printStackTrace();
        }
    }

}
