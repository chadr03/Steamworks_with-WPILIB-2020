/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Controller USB Ports, Axis, and Buttons
    public static final int DRIVER_CONTROLER_PORT = 0;
    public static int LEFT_Y_AXIS = 1;
    public static int RIGHT_X_AXIS = 4;
    public static int RIGHT_Y_AXIS = 5;

    public static int RIGHT_TRIGGER = 3;
    


    public static int A_BUTTON = 1;
    public static int B_BUTTON = 2;
    public static int X_BUTTON = 3;
    public static int Y_BUTTON = 4;
    


    //PWM Ports
    public static final int LEFT_MOTOR_1_PORT = 2;
    public static final int LEFT_MOTOR_2_PORT = 3;
    public static final int RIGHT_MOTOR_1_PORT = 0;
    public static final int RIGHT_MOTOR_2_PORT = 1;

    public static final int LEFT_SHOOT_PORT = 5;
    public static final int RIGHT_SHOOT_PORT = 6;

    //DIO Ports
    public static int RIGHT_ENCODER_A_PORT = 0;
    public static int RIGHT_ENCODER_B_PORT = 1;
    public static int LEFT_ENCODER_A_PORT = 4;
    public static int LEFT_ENCODER_B_PORT = 5;

    //Various Constants
    public static final double DRIVE_ENCODER_PULSE_PER_FT =  0.000766990394;  //for 6" wheel and 2048 pulse per rev encoder

    



}
