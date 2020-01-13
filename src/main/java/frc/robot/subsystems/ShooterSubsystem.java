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

public class ShooterSubsystem extends SubsystemBase {



  //Set up motor controllers
  Spark shootLeft = new Spark(Constants.LEFT_SHOOT_PORT);
  Spark shootRight = new Spark(Constants.RIGHT_SHOOT_PORT);
  
  

  //Groups motor controllers that will always have the same value
  SpeedControllerGroup shooter = new SpeedControllerGroup(shootLeft, shootRight);
  

  

  
  public ShooterSubsystem() {
    shootRight.setInverted(true);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void manualShoot(double speed) {
    shootLeft.set(speed);
    shootRight.set(speed);
  }

  

}
