package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;

public class RobotMap 
{
	//Front Talon in the left transmission ID = 0
	
	public CANTalon FLSRX;
		
		
	//Back Talon in the left transmission ID = 1
		
	public CANTalon BLSRX;
		
		
	//Front Talon in the right transmission ID = 2
		
	public CANTalon FRSRX;
		
		
	//Back Talon in the right transmission ID = 3
		
	public CANTalon BRSRX;
		
		
	//Talon SRX for the Right Shooter Motor ID = 4
		
	public CANTalon LeftShooterMotor;
	
	//Talon SRX for the Left Shooter Motor ID = 5
	public CANTalon RightShooterMotor;
	
	//Talon SR for the climber
	final int climber = 1;
	public Spark climberMotor = new Spark(climber);
	
	//Talon SR for the front of the intake
	final int intakefront = 4;
	public Talon intakeFront = new Talon(intakefront);
	
	//Talon SR for the back of the intake
	final int intakeback = 2; 
	public Talon intakeBack = new Talon(intakeback);
	
	//Talon SR for motor to feed the shooter
	final int hopperBelts = 5;
	public Talon HopperBeltsMotor = new Talon(hopperBelts);
	
	final int Feeder = 0;
	public Talon FeederMotor = new Talon(Feeder);
	
	final int GearMech = 3;
	public Spark GearMechMotor = new Spark(GearMech);
	
	//Servo for Gear Mechanism
	public final Servo gearMechanismServo = new Servo(9);
	
	public DoubleSolenoid shifterSolenoid = new DoubleSolenoid(0,1);
	
		
	
	public RobotMap()
	{
		FLSRX = new CANTalon(0);
		BLSRX = new CANTalon(1);
		FRSRX = new CANTalon(2);
		BRSRX = new CANTalon(3);
		LeftShooterMotor = new CANTalon(4);
		RightShooterMotor = new CANTalon(5);
		
	}
	
}
