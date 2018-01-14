package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearMechJoystickControl extends Command {
	
	double operatorBands = 0.05;
	double GearMechValue;

    public GearMechJoystickControl() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.gearmechanism);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        	
    	if (Robot.oi.OperatorStick.getY() < operatorBands && Robot.oi.OperatorStick.getY() > -operatorBands)
         {
         	GearMechValue = 0.0;
         }
         else 
         {
        	 
        	 GearMechValue = Robot.oi.OperatorStick.getY();
         	/*if(GearMechValue > 0.0 && !Robot.robotmap.GearMechTop.get())
         	{
         		GearMechValue = 0.0;
         	}
         	//Stop GearMech if it is trying to go below the bottom hall effect sensor
         	else if(GearMechValue < 0.0 && !Robot.robotmap.GearMechBottom.get())
         	{
         		GearMechValue = 0.0;
         	}
         	else
         	{
         	*/
         		
         	//}
         }
    	Robot.gearmechanism.GearMechJoyControl(GearMechValue);
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
