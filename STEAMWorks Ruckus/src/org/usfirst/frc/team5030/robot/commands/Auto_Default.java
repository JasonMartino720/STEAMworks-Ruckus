package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_Default extends Command {

	CommandGroup openServos;
	
    public Auto_Default() {
       requires(Robot.shooter);
       requires(Robot.intake);
       requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	openServos = new CG_OpenServos();
    	openServos.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.AllOff();
    	Robot.intake.IntakeOff();
    	Robot.climber.ClimberOff();
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
