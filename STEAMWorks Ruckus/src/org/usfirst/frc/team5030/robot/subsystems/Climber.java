package org.usfirst.frc.team5030.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.commands.ClimberOff;


public class Climber extends Subsystem {

    public void ClimberOff()
    {
    	Robot.robotmap.climberMotor.set(0.0);
    }
    
    public void ClimberCW()
    {
    
    	Robot.robotmap.climberMotor.set(1.0);
    }

    public void ClimberCCW()
    {
    	//Robot.robotmap.climberMotor.set(-1.0);
    }
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new ClimberOff());
    }
}

