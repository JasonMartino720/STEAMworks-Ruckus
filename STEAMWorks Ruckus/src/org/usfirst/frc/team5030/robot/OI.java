package org.usfirst.frc.team5030.robot;

import org.usfirst.frc.team5030.robot.commands.ClimberCCW;
import org.usfirst.frc.team5030.robot.commands.ClimberCW;
import org.usfirst.frc.team5030.robot.commands.IntakeIn;
import org.usfirst.frc.team5030.robot.commands.IntakeOff;
import org.usfirst.frc.team5030.robot.commands.IntakeOut;
import org.usfirst.frc.team5030.robot.commands.ShootSequence;
import org.usfirst.frc.team5030.robot.commands.SpinUp;
import org.usfirst.frc.team5030.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
	
	public static Joystick DriverStick = new Joystick(0); //Xbox Controller for Driver
		public static Button upshift = new JoystickButton(DriverStick, 5);
		public static Button downshift = new JoystickButton(DriverStick, 6);
		

	public static Joystick OperatorStick = new Joystick(1);
		static Button intakeIn = new JoystickButton(OperatorStick,1);
		static Button intakeOut = new JoystickButton(OperatorStick,2);
		public static Button spinUp = new JoystickButton(OperatorStick,5);
		static Button shoot = new JoystickButton(OperatorStick, 6);
		static Button climberCW = new JoystickButton(OperatorStick , 3);
		static Button reverseBlender = new JoystickButton(OperatorStick , 7);
			
	public OI()
	{
		intakeIn.whileHeld(new IntakeIn());
		intakeIn.whenReleased(new IntakeOff());
		intakeOut.whileHeld(new IntakeOut());
		climberCW.whileHeld(new ClimberCW());
		shoot.whileHeld(new ShootSequence());
		spinUp.whileHeld(new SpinUp());
		upshift.whileHeld(new Upshift());
		downshift.whileHeld(new Dowshift());
				
	}	
	
}
