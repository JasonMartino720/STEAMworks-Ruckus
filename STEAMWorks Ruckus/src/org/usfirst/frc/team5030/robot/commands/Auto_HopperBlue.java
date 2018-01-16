package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_HopperBlue extends Command {

	CommandGroup openServos;
	boolean isFinished = false;
	
	
    public Auto_HopperBlue() {
    	 // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.shooter);
        requires(Robot.gearmechanism);    
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.LeftShooterMotor.selectProfileSlot(, 0);
    	Robot.robotmap.RightShooterMotor.changeControlMode(TalonControlMode.Follower);
    	Robot.robotmap.RightShooterMotor.setSensorPhase(true);
    	Robot.robotmap.LeftShooterMotor.setSensorPhase(true);
    	Robot.robotmap.LeftShooterMotor.config_kP(0, 0.60, 10);
    	Robot.robotmap.LeftShooterMotor.config_kI(0, 0.000, 10);
    	Robot.robotmap.LeftShooterMotor.config_kD(0, 2.0, 10);
    	Robot.robotmap.LeftShooterMotor.config_kF(0, 0.15, 10);
    	Robot.robotmap.LeftShooterMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	Robot.robotmap.BLSRX.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	Robot.robotmap.BRSRX.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	//Robot.robotmap.BLSRX.reverseOutput(true);
    	Robot.robotmap.BRSRX.setSelectedSensorPosition(0, 0, 10);
    	Robot.robotmap.BLSRX.setSelectedSensorPosition(0, 0, 10);
    	openServos = new CG_OpenServos();
    	openServos.start();
    	setTimeout(14.9);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rEnc = Robot.robotmap.BRSRX.getActiveTrajectoryPosition();
     	double lEnc = -Robot.robotmap.BLSRX.getActiveTrajectoryPosition();
     	

 		if(!isFinished)
 		{
     			
	     	if(rEnc < 8450 && lEnc < 8450)
	     	{
	     		Robot.drivetrain.tankDrive(-0.825, -0.77);
	     	}
		     	else
		     	{
		     		Robot.drivetrain.tankDrive(0.7, 0.00);
			     		Timer.delay(0.675);
			     		Robot.shooter.SpinFlywheels(-5480);
			     		Robot.drivetrain.tankDrive(0.66, 0.65);
			     		Timer.delay(0.8);
			     		Robot.drivetrain.tankDrive(0.0, 0.0);
			     		isFinished = true;
		     		}
 		}
     		else
     		{
     			Robot.drivetrain.tankDrive(0.0, 0.0);
     			if(timeSinceInitialized() < 14.8)
     			{
     				Robot.drivetrain.tankDrive(0.0, 0.0);
     				Robot.shooter.Shoot();
     				     				
     			}
     			else
     			{
     				Robot.shooter.AllOff();
     			}
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
