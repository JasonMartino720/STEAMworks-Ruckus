package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinUp extends Command {

    public SpinUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.LeftShooterMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	Robot.robotmap.LeftShooterMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 5);
    	Robot.robotmap.RightShooterMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.Velocity, 5);
    	Robot.robotmap.RightShooterMotor.setSensorPhase(true);
    	Robot.robotmap.LeftShooterMotor.setSensorPhase(true);
    	Robot.robotmap.LeftShooterMotor.config_kP(arg0, arg1, arg2) //0.5
    	Robot.robotmap.LeftShooterMotor.config_kI(arg0, arg1, arg2)(0.0001); //0.0001
    	Robot.robotmap.LeftShooterMotor.config_kD(arg0, arg1, arg2)(3.0); //3.0
    	Robot.robotmap.LeftShooterMotor.config_kF(arg0, arg1, arg2)(0.06);//0.06
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    /*	if(Robot.robotmap.ShooterMotor.getEncVelocity() > -2200)
    	{
    		Robot.robotmap.ShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    		Robot.robotmap.ShooterMotor.set(-0.5);
    		System.out.println("Spinning");
    	}
    	else
    	{
    	*/
    	Robot.shooter.SpinFlywheels(3750);
    	System.out.println("V " + Robot.robotmap.LeftShooterMotor.get());
    	
    	
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
