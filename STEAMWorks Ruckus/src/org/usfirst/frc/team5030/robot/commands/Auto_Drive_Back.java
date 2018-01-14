package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Drive_Back extends Command {
	Timer timer;
	double TIME_TO_DRIVE_BACK = 4;
	double POWER_TO_DRIVE_BACK = -0.75;

    public Auto_Drive_Back() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(14.9);
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(timer.get() < TIME_TO_DRIVE_BACK) {
    		Robot.drivetrain.tankDrive(-POWER_TO_DRIVE_BACK, -POWER_TO_DRIVE_BACK);
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
