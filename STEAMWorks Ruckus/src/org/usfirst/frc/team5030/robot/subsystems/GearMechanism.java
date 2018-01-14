package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.OI;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.RobotMap;
import org.usfirst.frc.team5030.robot.commands.GearMechJoystickControl;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearMechanism extends Subsystem {
	
	public void GearMechJoyControl(double GearMechValue)
	{
    	Robot.robotmap.GearMechMotor.set(GearMechValue * 0.60);

	}
	
	public void GearMechforTime(double speed)
	{
		Robot.robotmap.GearMechMotor.set(speed);
		Timer.delay(0.75);
		Robot.robotmap.GearMechMotor.set(0.0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GearMechJoystickControl());
    }
}

