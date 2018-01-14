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
    	Robot.robotmap.LeftShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.LeftShooterMotor.changeControlMode(TalonControlMode.Speed);
    	Robot.robotmap.RightShooterMotor.changeControlMode(TalonControlMode.Follower);
    	Robot.robotmap.RightShooterMotor.set(Robot.robotmap.LeftShooterMotor.getDeviceID());
    	Robot.robotmap.RightShooterMotor.reverseOutput(true);
    	Robot.robotmap.LeftShooterMotor.setNominalClosedLoopVoltage(12.0);
    	Robot.robotmap.LeftShooterMotor.reverseSensor(true);
    	Robot.robotmap.LeftShooterMotor.setP(0.5); // 0.25
    	Robot.robotmap.LeftShooterMotor.setI(0.0001);
    	Robot.robotmap.LeftShooterMotor.setD(3.0);
    	Robot.robotmap.LeftShooterMotor.setF(0.06);//0.129
    	
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
