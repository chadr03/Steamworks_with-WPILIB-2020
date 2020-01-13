/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DashboardSubsystem extends SubsystemBase {
  /**
   * Creates a new DashboardSubsystem.
   */
  private final DriveSubsystem drive;

  public DashboardSubsystem(DriveSubsystem drive_subsystem) {
    drive = drive_subsystem;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Right Encoder Position", drive.rightEncoder.get());
    SmartDashboard.putNumber("Left Encoder Position", drive.leftEncoder.get());
    SmartDashboard.putNumber("Right Encoder Speed", drive.rightEncoder.getRate());
    SmartDashboard.putNumber("Left Encoder Speed", drive.leftEncoder.getRate());
    SmartDashboard.putNumber("Right Encoder Distance", drive.rightEncoder.getDistance());
    SmartDashboard.putNumber("Left Encoder Distance", drive.leftEncoder.getDistance());
    SmartDashboard.putNumber("Gyro Angle", drive.gyro.getAngle());
  }
}
