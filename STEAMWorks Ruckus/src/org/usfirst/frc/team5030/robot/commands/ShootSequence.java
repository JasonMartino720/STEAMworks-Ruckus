package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootSequence extends Command {

    public ShootSequence() {
       requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*Robot.robotmap.ShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.ShooterMotor.changeControlMode(TalonControlMode.Speed);
    	Robot.robotmap.ShooterMotor.reverseSensor(true);
    	Robot.robotmap.ShooterMotor.setP(0);
    	Robot.robotmap.ShooterMotor.setI(0);
    	Robot.robotmap.ShooterMotor.setD(0);
    	Robot.robotmap.ShooterMotor.setF(0.175);
    	*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.Shoot();
    	
    	    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.robotmap.LeftShooterMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.MotionProfile.PercentOutput, 0);
    	Robot.robotmap.RightShooterMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.MotionProfile.PercentOutput, 0);
    	Robot.shooter.AllOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
