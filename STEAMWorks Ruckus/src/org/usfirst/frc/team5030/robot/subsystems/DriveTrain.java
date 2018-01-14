package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.OI;
//import org.usfirst.frc.team5030.robot.OI;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.JoystickOperation;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrain extends Subsystem
{
	public static RobotDrive drive;
	final double driverBands = 0.08;
	
	//Right Encoder Velocity
	double rEncV = Robot.robotmap.BRSRX.getEncVelocity();
	//Left Encoder Velocity
 	double lEncV = -Robot.robotmap.BLSRX.getEncVelocity();
 	//Encoder Upshift Velocity
 	final int peakUpshiftV = 3000;
 	//Encoder Downshift V
 	final int peakDownshiftV = 2000;
 	//Left Joy User Input Value
 	double leftJoystickUI = Robot.oi.DriverStick.getY();
 	//Right Joy User Input Value
 	double rightJoystickUI = Robot.oi.DriverStick.getRawAxis(5);
 	
 	//public boolean isAutomaticEnabled;
		
	public DriveTrain()
	{
		drive = new RobotDrive(Robot.robotmap.FLSRX, Robot.robotmap.BLSRX, Robot.robotmap.FRSRX, Robot.robotmap.BRSRX);
		drive.setExpiration(1.0);
	}
	public void tankDrive(double leftJoy , double rightJoy)
	{
		if(Robot.oi.DriverStick.getRawButton(5))
		{
			drive.arcadeDrive(leftJoy * 0.5  , rightJoy * 0.5 , true);
			
		}
		else
		{
			drive.arcadeDrive(leftJoy * 0.65 , rightJoy * 0.65, true);
			
		}
		//drive.arcadeDrive(-leftJoy, -rightJoy);
	}
	/*
	public boolean upshiftVelocityCondition()
	{
		if((lEncV > peakUpshiftV * 0.90 && lEncV < peakUpshiftV * 1.1) && (rEncV > peakUpshiftV * 0.9 && rEncV < peakUpshiftV * 1.1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean upshiftRotationalCondition()
	{
		if((2*(Math.abs(rightJoystickUI - leftJoystickUI)/(rightJoystickUI + leftJoystickUI))) < 0.1 && 
		   (2*(Math.abs(rightJoystickUI - leftJoystickUI)/(rightJoystickUI + leftJoystickUI))) > -0.1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isAutomaticEnabled(boolean currentTransmissionMode)
	{
		isAutomaticEnabled = currentTransmissionMode;
		return isAutomaticEnabled;
	}
	
	public boolean downshiftVelocityCondition()
	{
		if((lEncV > peakDownshiftV * 0.90 && lEncV < peakDownshiftV * 1.1) && (rEncV > peakDownshiftV * 0.9 && rEncV < peakDownshiftV * 1.1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean downshiftRotationalCondition()
	{
		if((2*(Math.abs(rightJoystickUI - leftJoystickUI)/(rightJoystickUI + leftJoystickUI))) < 0.1 && 
		   (2*(Math.abs(rightJoystickUI - leftJoystickUI)/(rightJoystickUI + leftJoystickUI))) > -0.1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean automaticUpshiftControl()
	{
		if(Robot.drivetrain.isAutomaticEnabled)
		{
			if(upshiftRotationalCondition() && upshiftVelocityCondition())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public boolean automaticDownshiftControl()
	{
		if(Robot.drivetrain.isAutomaticEnabled)
		{
			if(downshiftRotationalCondition() && downshiftVelocityCondition())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	*/
	public void upshiftActuation()
	{
		Robot.robotmap.shifterSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	public void downshiftActuation()
	{
		Robot.robotmap.shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	public void initDefaultCommand()
	{
		setDefaultCommand(new JoystickOperation());
	}

}
