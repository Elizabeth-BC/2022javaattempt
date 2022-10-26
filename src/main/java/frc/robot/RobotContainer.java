package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import frc.libs.SmoothXboxController;
import frc.robot.commands.auto.routines.DoNothingAuto;
import frc.robot.commands.auto.routines.kCenterAuto;
import frc.robot.commands.auto.routines.kLeftAuto;
import frc.robot.commands.auto.routines.kMainFourRightAuto;
import frc.robot.commands.auto.routines.kMainOneRightAuto;
import frc.robot.commands.auto.routines.kMainRightAuto;
import frc.robot.commands.auto.routines.kMainThirdRightAuto;
import frc.robot.commands.auto.routines.kMainTwoRightAuto;
import frc.robot.commands.auto.routines.kRightAuto;
import frc.robot.commands.limelight.LightOn;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.Drive;
import frc.robot.commands.drivetrain.LeftTimedTurn;
import frc.robot.commands.drivetrain.RightTimedTurn;

import frc.robot.subsystems.Auto;
import frc.robot.subsystems.Drivetrain;


public class RobotContainer implements HardwareAdapter{
  public static final Drivetrain dt = new Drivetrain();
  public static final Auto at = new Auto();
  // public static final Controller ci = new Controller();


  public static final SendableChooser<Command> chooser = new SendableChooser<>();

  // Controllers
  public static final SmoothXboxController xbox = new SmoothXboxController(xboxPrimaryDriver);
  public static final SmoothXboxController xbox2 = new SmoothXboxController(xboxSecondaryDriver);

  private UsbCamera camera;

  public RobotContainer() {
    camera = CameraServer.startAutomaticCapture();
    camera.setFPS(FPS);
    camera.setResolution(RES_X, RES_Y);

    chooser.setDefaultOption("Do Nothing Auto", new DoNothingAuto());
    chooser.addOption("2BallAutoLeft", new kLeftAuto());
    chooser.addOption("3BallAutoCenter", new kCenterAuto()); //0.25, 2
    chooser.addOption("4BallAutoRight", new kRightAuto());
    chooser.addOption("4MainBallAutoRight", new kMainRightAuto());
    chooser.addOption("4MainOneBallAutoRight", new kMainOneRightAuto());
    chooser.addOption("4MainTwoBallAutoRight", new kMainTwoRightAuto());
    chooser.addOption("4MainThirdBallAutoRight", new kMainThirdRightAuto());
    chooser.addOption("4MainFourBallAutoRight", new kMainFourRightAuto());
    
    Shuffleboard.getTab("Selector").add(chooser);

    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
    
    configureButtonBindings();
    configureDefaultCommands();
  }

  private void configureButtonBindings() {
    new JoystickButton(xbox, Button.kA.value)
    .whenPressed(new TimedDrive(0.25, 2));

    new JoystickButton(xbox, Button.kX.value)
    .whenPressed(new LeftTimedTurn(0.25, 2));

    new JoystickButton(xbox, Button.kY.value)
    .whenPressed(new RightTimedTurn(0.25, 2));

    new JoystickButton(xbox, Button.kB.value)
    .whenPressed(new LightOn());
  }

  private void configureDefaultCommands() {
    dt.setDefaultCommand(new Drive());
  }
  
  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }
}
