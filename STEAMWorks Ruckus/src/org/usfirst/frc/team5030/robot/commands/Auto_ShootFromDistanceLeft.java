package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_ShootFromDistanceLeft extends Command {
	
	CommandGroup openServos;
	
	double rEnc = Robot.robotmap.BRSRX.getEncPosition();
	double lEnc = Robot.robotmap.BLSRX.getEncPosition();
	
	boolean turnComplete = false;
    boolean ShootComplete = false;

    public Auto_ShootFromDistanceLeft() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.LeftShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BRSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.LeftShooterMotor.changeControlMode(TalonControlMode.Speed);
    	Robot.robotmap.RightShooterMotor.changeControlMode(TalonControlMode.Follower);
    	Robot.robotmap.RightShooterMotor.set(Robot.robotmap.LeftShooterMotor.getDeviceID());
    	Robot.robotmap.RightShooterMotor.reverseOutput(true);
    	Robot.robotmap.LeftShooterMotor.setNominalClosedLoopVoltage(12.0);
    	Robot.robotmap.LeftShooterMotor.reverseSensor(true);
    	Robot.robotmap.LeftShooterMotor.setP(0.65);
    	Robot.robotmap.LeftShooterMotor.setI(0.001);
    	Robot.robotmap.LeftShooterMotor.setD(0);
    	Robot.robotmap.LeftShooterMotor.setF(0.129);
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BRSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BLSRX.setEncPosition(0);
    	Robot.robotmap.BRSRX.setEncPosition(0);
    	Robot.robotmap.BRSRX.reverseOutput(true);
    	openServos = new CG_OpenServos();
    	openServos.start();
    	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(this.timeSinceInitialized() < 2.0)
    	{
        	Robot.shooter.SpinFlywheels(-4020); //2780
	    	
	    }
    	else if(this.timeSinceInitialized() > 2.0 && this.timeSinceInitialized() < 10.0)
    	{
    		Robot.shooter.Shoot();
    		
	    	
    	}
    	else if(this.timeSinceInitialized() > 10.0 && this.timeSinceInitialized() < 11.5)
    	{
    		//Robot.drivetrain.tankDrive(-0.8, -0.6);
    		Robot.shooter.AllOff();
    	}
    	else if(this.timeSinceInitialized() > 11.5 && this.timeSinceInitialized() < 14.5)
    	{
    		//Robot.drivetrain.tankDrive(-0.6, -0.6);
    	}
    	else
    	{
    		Robot.shooter.AllOff();
    		Robot.drivetrain.tankDrive(0.0, 0.0);
    	}
    	
    	
    	
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
