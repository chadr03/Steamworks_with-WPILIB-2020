/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SPI;

public class DriveSubsystem extends SubsystemBase {
  //Drive Sraight Gyro
  private double gyroKP = 0.07;


  //Set up motor controllers
  Spark left1 = new Spark(Constants.LEFT_MOTOR_1_PORT);
  Spark left2 = new Spark(Constants.LEFT_MOTOR_2_PORT);
  Spark right1 = new Spark(Constants.RIGHT_MOTOR_1_PORT);
  Spark right2 = new Spark(Constants.RIGHT_MOTOR_2_PORT);

  //Groups motor controllers that will always have the same value
  SpeedControllerGroup leftMaster = new SpeedControllerGroup(left1, left2);
  SpeedControllerGroup rightMaster = new SpeedControllerGroup(right1, right2);

  //Sets up differental drive
  DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);
  
  //Set up sensors
  Encoder rightEncoder = new Encoder(Constants.RIGHT_ENCODER_A_PORT, Constants.RIGHT_ENCODER_B_PORT, true, Encoder.EncodingType.k4X);
  Encoder leftEncoder = new Encoder(Constants.LEFT_ENCODER_A_PORT, Constants.LEFT_ENCODER_B_PORT, false, Encoder.EncodingType.k4X);
  public ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
  PowerDistributionPanel pdp = new PowerDistributionPanel();
  
  public DriveSubsystem() {
    rightEncoder.setDistancePerPulse(Constants.DRIVE_ENCODER_PULSE_PER_FT);
    leftEncoder.setDistancePerPulse(Constants.DRIVE_ENCODER_PULSE_PER_FT);
    gyro.calibrate();


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void teleopDrive(double move, double turn) {
    drive.arcadeDrive(move, turn);
  }

  public void tankDrive(double leftMove, double rightMove){
    drive.tankDrive(leftMove, rightMove);
  }

  public void driveStraight(double move){
    //double move = 0.5;
    double error = gyro.getAngle();
    System.out.printf("Error: %.4f", error);
    double turn = error * gyroKP;
    //turn = Math.copySign(turn, move);
    System.out.printf(" Turn: %.4f\n", turn);
    teleopDrive(move, -turn);

  }

  public void resetEncoders(){
    leftEncoder.reset();
    rightEncoder.reset();
  }


}
