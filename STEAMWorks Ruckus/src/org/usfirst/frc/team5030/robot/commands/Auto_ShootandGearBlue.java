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
public class Auto_ShootandGearBlue extends Command {

	CommandGroup openServos;
	boolean flag1 = false;
	boolean flag2 = false;
	boolean isFinished = false;
	
    public Auto_ShootandGearBlue() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.shooter);
        requires(Robot.gearmechanism);
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
    	double rEnc = Robot.robotmap.BRSRX.getEncPosition();
     	double lEnc = -Robot.robotmap.BLSRX.getEncPosition();
    	
    	if(this.timeSinceInitialized() < 1.25)
    	{
        	Robot.shooter.SpinFlywheels(-3000); //2780
	    	
	    }
    	else if(this.timeSinceInitialized() > 1.25 && this.timeSinceInitialized() < 4.5)
    	{
    		Robot.shooter.Shoot();
    		
	    	
    	}
    	else
    	{
    		Robot.shooter.AllOff();
    		if(lEnc < 7200 && !flag1)
    		{
    			Robot.drivetrain.tankDrive(-0.75, -0.69);
    			Robot.shooter.AllOff();
    		}
    		else
    		{
    				Robot.drivetrain.tankDrive(0.0, 0.0);
    				flag1 = true;
    				
    		    	if((rEnc < 7375) && !flag2)
    		    	{
    		    		Robot.drivetrain.tankDrive(0.5 , -0.5);
    		    		
    		    	}
    		    	else
    		    	{
    		    		flag2 = true;    
    		    		Robot.shooter.AllOff();
    		    		Robot.drivetrain.tankDrive(-0.65, -0.65);
    		    		Timer.delay(0.75);
    		    		Robot.drivetrain.tankDrive(0.0, 0.0);
    		    		Timer.delay(0.125);
    		    		Robot.gearmechanism.GearMechJoyControl(0.6);
    		    		Timer.delay(0.75);    
    		    		Robot.gearmechanism.GearMechJoyControl(0.0);
    		    		Timer.delay(0.25);
    		    		Robot.drivetrain.tankDrive(0.75, 0.75);
    		    		Timer.delay(0.75);
    		    		Robot.drivetrain.tankDrive(0.0, 0.0);
    		    		Timer.delay(2.0);
    		    		isFinished = true;
    		    		
    		    		
    		    		
    		    	}
    			}
    		
    		}
    		
    	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
