package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {


	public void IntakeOff()
	{
		Robot.robotmap.intakeBack.set(0.0);
		Robot.robotmap.intakeFront.set(0.0);
		
		//Robot.robotmap.intakeHoodLeft.setAngle(intakeHoodDefaultLeft);
	}
	
	public void IntakeIn()
	{
		Robot.robotmap.intakeBack.set(-0.25);
		Robot.robotmap.intakeFront.set(0.30);
		
		//Robot.robotmap.intakeHoodLeft.setAngle(intakeHoodPosL);
	}
	
	public void IntakeOut()
	{
		Robot.robotmap.intakeBack.set(1.0);
		Robot.robotmap.intakeFront.set(1.0);
		//Robot.robotmap.intakeHoodRight.setAngle(intakeHoodPosR);
		//Robot.robotmap.intakeHoodLeft.setAngle(intakeHoodPosL);
	}
	
    public void initDefaultCommand() 
    {
        
    	
    	
    }
}

