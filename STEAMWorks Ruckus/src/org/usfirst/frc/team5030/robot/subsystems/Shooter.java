package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Shooter extends Subsystem {

		
	public void AllOff()
    {
    	Robot.robotmap.LeftShooterMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, 0.0);
    	Robot.robotmap.RightShooterMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, 0.0);
    	Robot.robotmap.FeederMotor.set(0.0);
    	Robot.robotmap.HopperBeltsMotor.set(0.0);
    	Robot.robotmap.intakeBack.set(0.0);
    	Robot.robotmap.intakeFront.set(0.0);
    }
    
    public void SpinFlywheels(int RPMSetpoint)
    {
    	Robot.robotmap.LeftShooterMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, RPMSetpoint);
    }
   
    public void Shoot()
    {
    
    	Robot.robotmap.FeederMotor.set(-0.75);
    	Robot.robotmap.HopperBeltsMotor.set(-0.35);
    	Robot.robotmap.intakeBack.set(-0.2);
    	Robot.robotmap.intakeFront.set(0.2);
    	System.out.println("Shooter V " + Robot.robotmap.LeftShooterMotor.getActiveTrajectoryVelocity());
    	    	
    }
    
    public void HopperBeltsFeeding()
    {
    	Robot.robotmap.HopperBeltsMotor.set(1.0);
    }
    
    public void HopperBeltsReverse()
    {
    	Robot.robotmap.HopperBeltsMotor.set(-1.0);
    }
    
    public void HopperBeltsOff()
    {
    	Robot.robotmap.HopperBeltsMotor.set(0.0);
    }
    
    public void FlywheelOff()
    {
    	Robot.robotmap.LeftShooterMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, 0.0);
    	Robot.robotmap.RightShooterMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, 0.0);
    	Robot.robotmap.HopperBeltsMotor.set(0.0);
    	Robot.robotmap.FeederMotor.set(0.0);
    }
    
   
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new FlywheelOff());
    }
}


