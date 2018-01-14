package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.OI;
import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickOperation extends Command {

    public JoystickOperation() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.FLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);

    	    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	

		double leftJoy; //Xvalue of OperatorStick 
		double rightJoy; //Yvalue of OperatorStick
        double driverBands = 0.08;
       
        
    	//DeadBands
        if (Robot.oi.DriverStick.getY() < driverBands  && Robot.oi.DriverStick.getY() > -driverBands) 
        {
        	leftJoy = 0;
        }
        else 
        {
        	leftJoy = -Robot.oi.DriverStick.getY();
        }
        if (Robot.oi.DriverStick.getX() < driverBands && Robot.oi.DriverStick.getX() > -driverBands)
        //if (Robot.oi.DriverStick.getX() < driverBands && Robot.oi.DriverStick.getX() > -driverBands)
        { 
        	rightJoy = 0;
        }
        else 
        {
        	rightJoy = -Robot.oi.DriverStick.getX();
        }
    
       // Robot.drivetrain.tankDrive(leftJoy, rightJoy);
       // Robot.drivetrain.tankDrive(leftJoy * 0.7, rightJoy * 0.7);
//        Robot.drivetrain.tankDrive((Math.pow(-leftJoy, 5) * 0.75), (Math.pow(-rightJoy, 5))*0.75);
        Robot.drivetrain.tankDrive(Math.pow(leftJoy, 5), Math.pow(rightJoy, 5));
       
   
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

