package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;

public class RobotMap 
{
	//Front Talon in the left transmission ID = 0
	
	public TalonSRX FLSRX;
		
		
	//Back Talon in the left transmission ID = 1
		
	public TalonSRX BLSRX;
		
		
	//Front Talon in the right transmission ID = 2
		
	public TalonSRX FRSRX;
		
		
	//Back Talon in the right transmission ID = 3
		
	public TalonSRX BRSRX;
		
		
	//Talon SRX for the Right Shooter Motor ID = 4
		
	public TalonSRX LeftShooterMotor;
	
	//Talon SRX for the Left Shooter Motor ID = 5
	public TalonSRX RightShooterMotor;
	
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
		FLSRX = new TalonSRX(0);
		BLSRX = new TalonSRX(1);
		FRSRX = new TalonSRX(2);
		BRSRX = new TalonSRX(3);
		LeftShooterMotor = new TalonSRX(4);
		RightShooterMotor = new TalonSRX(5);
		
	}
	
}
