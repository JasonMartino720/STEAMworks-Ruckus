package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_ShootRight extends Command {
	
	CommandGroup openServos;
	
	Timer timer;
	
	double rEnc = Robot.robotmap.BRSRX.getEncPosition();
	double lEnc = Robot.robotmap.BLSRX.getEncPosition();
	
	boolean Complete = false;
    

    public Auto_ShootRight() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.shooter);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.LeftShooterMotor.changeControlMode(TalonControlMode.Speed);
    	Robot.robotmap.RightShooterMotor.changeControlMode(TalonControlMode.Follower);
    	Robot.robotmap.RightShooterMotor.set(Robot.robotmap.LeftShooterMotor.getDeviceID());
    	Robot.robotmap.RightShooterMotor.reverseOutput(true);
    	Robot.robotmap.LeftShooterMotor.setNominalClosedLoopVoltage(12.0);
    	Robot.robotmap.LeftShooterMotor.reverseSensor(true);
    	Robot.robotmap.LeftShooterMotor.setP(0.60);
    	Robot.robotmap.LeftShooterMotor.setI(0.000);
    	Robot.robotmap.LeftShooterMotor.setD(2.0);
    	Robot.robotmap.LeftShooterMotor.setF(0.15);
    	Robot.robotmap.LeftShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BRSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	//Robot.robotmap.BLSRX.reverseOutput(true);
    	Robot.robotmap.BRSRX.setEncPosition(0);
    	Robot.robotmap.BLSRX.setEncPosition(0);
    	openServos = new CG_OpenServos();
    	openServos.start();
    	setTimeout(14.9);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(this.timeSinceInitialized() < 2.0)
    	{
        	Robot.shooter.SpinFlywheels(-2795); //2780
	    	
	    }
    	else if(this.timeSinceInitialized() > 2.0 && this.timeSinceInitialized() < 10)
    	{
    		Robot.shooter.Shoot();
    			    	
    	}
       	else
    	{
    		Robot.shooter.AllOff();
    		Robot.drivetrain.tankDrive(-0.75, 0.75);
    		timer.delay(1);
    		Robot.drivetrain.tankDrive(0.75, 0.75);
    		timer.delay(3);
    		Robot.drivetrain.tankDrive(0.0, 0.0);
    		
    	}
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
