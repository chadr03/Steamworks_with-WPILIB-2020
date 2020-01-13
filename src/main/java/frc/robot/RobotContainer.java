/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.TankDriveCommand;
import frc.robot.subsystems.DashboardSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final DriveSubsystem drive = new DriveSubsystem();
  private final DashboardSubsystem dashboard = new DashboardSubsystem(drive);
  private final ShooterSubsystem shoot = new ShooterSubsystem();




  // The driver's controller
  Joystick driverController = new Joystick(Constants.DRIVER_CONTROLER_PORT);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    // Configure default commands
    // Set the default drive command to split-stick arcade drive
    
    drive.setDefaultCommand(
    
    new RunCommand(() -> drive

     // A split-stick arcade command, with forward/backward controlled by the left
      // hand, and turning controlled by the right.
     
    .teleopDrive(-driverController.getRawAxis(Constants.LEFT_Y_AXIS),
                 driverController.getRawAxis(Constants.RIGHT_X_AXIS)), drive));

    
    shoot.setDefaultCommand(
     //allows the joystick throttle control to adjust speed of wheel

      new RunCommand(() -> shoot
            .manualShoot(driverController.getRawAxis(Constants.RIGHT_TRIGGER)), shoot));


    
  }

  /**
   * Use t
   * his method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  

  
  private void configureButtonBindings() {
      // Drive straight the hatch when the 'A' button is pressed goes forward based on the drive move axis.
      new JoystickButton(driverController, Constants.A_BUTTON)        
                    .whileHeld(new RunCommand(() -> drive.driveStraight(-driverController.getRawAxis(Constants.LEFT_Y_AXIS)), drive));
        //.whileHeld(() -> drive.driveStraight(-driverController.getRawAxis(Constants.DRIVE_MOVE_AXIS)));
      new JoystickButton(driverController, Constants.B_BUTTON)
                    .whenPressed(new TankDriveCommand(drive,
                    () -> driverController.getRawAxis(Constants.LEFT_Y_AXIS), 
                    () -> driverController.getRawAxis(Constants.RIGHT_Y_AXIS)));
      new JoystickButton(driverController, Constants.X_BUTTON)
                    .whenPressed(new InstantCommand(() -> drive.gyro.reset(), drive));
   
      ;
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  //}
}
