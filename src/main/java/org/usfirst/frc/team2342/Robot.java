package org.usfirst.frc.team2342;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * Created by cooli on 5/6/2017.
 */
public class Robot extends SampleRobot {

    //The default drive system that comes with WPILib. Our drive systems will be a bit more complex, but this one's
    //a good start.
    private RobotDrive m_driveTrain;

    //The Joystick class implements a physical joystick; we use this in teleop.
    private Joystick m_joystick;

    //WPILib timers can be helpful for autonomous.
    private Timer m_timer;

    //The Robot constructor initializes our drive train, joystick, and timer to the correct ports.
    public Robot()
    {
        m_driveTrain = new RobotDrive(0,1);
        m_joystick = new Joystick(1);
        m_timer = new Timer();
    }

    @Override
    public void robotInit() {
        super.robotInit();
    }

    //This is a very simple autonomous that will drive forward for 2 seconds using the timer.
    @Override
    public void autonomous() {
        //Reset the timer and start counting
        m_timer.reset();
        m_timer.start();

        //Keep polling the timer until we've hit 2 seconds
        while(m_timer.get() < 2.0)
        {
            //Negative outputMagnitude will usually correspond to forward drive.
            //We don't want to turn, so the angle is 0.
            m_driveTrain.drive(-0.3, 0);
        }

        //Stop the timer after 2 seconds have elapsed, and stop driving.
        m_timer.stop();
        m_driveTrain.drive(0,0);
        super.autonomous();
    }

    @Override
    public void operatorControl() {
        //This uses the arcadeDrive method from RobotDrive to get input from a joystick and drive.
        //Different drive systems (for example mecanum) will use more complicated drive systems.
        m_driveTrain.arcadeDrive(m_joystick);
        super.operatorControl();
    }

    @Override
    public void test() {
        super.test();
    }
}