package org.usfirst.frc.team5030.robot;

import org.usfirst.frc.team5030.robot.commands.Auto_Default;
import org.usfirst.frc.team5030.robot.commands.Auto_Drive_Back;
import org.usfirst.frc.team5030.robot.commands.Auto_GearLeftPeg;
import org.usfirst.frc.team5030.robot.commands.Auto_GearRightPeg;
import org.usfirst.frc.team5030.robot.commands.Auto_HopperBlue;
import org.usfirst.frc.team5030.robot.commands.Auto_HopperRed;
import org.usfirst.frc.team5030.robot.commands.Auto_PlaceGearOnly;
import org.usfirst.frc.team5030.robot.commands.Auto_ShootFromDistanceLeft;
import org.usfirst.frc.team5030.robot.commands.Auto_ShootFromDistanceRight;
import org.usfirst.frc.team5030.robot.commands.Auto_ShootLeft;
import org.usfirst.frc.team5030.robot.commands.Auto_ShootRight;
import org.usfirst.frc.team5030.robot.commands.Auto_ShootandGearBlue;
import org.usfirst.frc.team5030.robot.commands.Auto_ShootandGearRed;
import org.usfirst.frc.team5030.robot.subsystems.Climber;
import org.usfirst.frc.team5030.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5030.robot.subsystems.GearMechanism;
import org.usfirst.frc.team5030.robot.subsystems.Intake;
import org.usfirst.frc.team5030.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	
	public static Intake intake;
	public static Climber climber;
	public static DriveTrain drivetrain;
	public static OI oi;
	public static RobotMap robotmap;
	public static Shooter shooter;
	public static GearMechanism gearmechanism;
	public static Timer timer;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		robotmap = new RobotMap();
		intake = new Intake();
		climber = new Climber();
		drivetrain = new DriveTrain();
		shooter = new Shooter();
		gearmechanism = new GearMechanism();
		oi = new OI();
		timer = new Timer();
		chooser.addDefault("Default Auto", new Auto_Default());
		chooser.addObject("Center Peg " , new Auto_PlaceGearOnly());
		chooser.addObject("Shoot Right ", new Auto_ShootRight());
		chooser.addObject("Shoot Left", new Auto_ShootLeft());
		chooser.addObject("Gear on Left Peg", new Auto_GearLeftPeg());
		chooser.addObject("Gear on Right Peg" , new Auto_GearRightPeg());
		chooser.addObject("Shoot from Distance Right " , new Auto_ShootFromDistanceRight());
		chooser.addObject("Shoot from Distance Left " , new Auto_ShootFromDistanceLeft());
		chooser.addObject("Gear and Shoot Red", new Auto_ShootandGearRed());
		chooser.addObject("Shoot and gear BLue", new Auto_ShootandGearBlue());
		chooser.addObject("Red Hopper", new Auto_HopperRed());
		chooser.addObject("Blue Hopper", new Auto_HopperBlue());
		chooser.addObject("DRIVE BACK", new Auto_Drive_Back());
		SmartDashboard.putData("Auto mode", chooser);
				
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
	Scheduler.getInstance().run();
	
	System.out.println("V " + Robot.robotmap.LeftShooterMotor.get());
	
			
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
