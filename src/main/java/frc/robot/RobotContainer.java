package frc.robot;

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.libs.SmoothXboxController;
import frc.robot.commands.auto.DoNothingAuto;
import frc.robot.commands.drivetrain.TimedDrive;
import frc.robot.commands.drivetrain.Drive;
import frc.robot.commands.drivetrain.LeftTimedTurn;
import frc.robot.commands.drivetrain.RightTimedTurn;
import frc.robot.subsystems.Auto;
// import frc.robot.subsystems.Controller;
import frc.robot.subsystems.Drivetrain;


public class RobotContainer implements HardwareAdapter{
  public static final Drivetrain dt = new Drivetrain();
  public static final Auto at = new Auto();
  // public static final Controller ci = new Controller();


  private static final SendableChooser<Command> chooser = new SendableChooser<>();

  // Controllers
  public static final SmoothXboxController xbox = new SmoothXboxController(xboxPrimaryDriver);
  public static final SmoothXboxController xbox2 = new SmoothXboxController(xboxSecondaryDriver);

  public RobotContainer() {

    chooser.setDefaultOption("Do Nothing Auto", new DoNothingAuto());
    // chooser.addOption("2BallAutoLeft", new kLeftAuto());
    // chooser.addOption("3BallAutoCenter", new kCenterAuto(0.25, 2));
    // chooser.addOption("4BallAutoRight", new kRightAuto());
    // chooser.addOption("4MainBallAutoRight", new kMainRightAuto());
    // chooser.addOption("4MainOneBallAutoRight", new kMainOneRightAuto());
    // chooser.addOption("4MainTwoBallAutoRight", new kMainTwoRightAuto());
    // chooser.addOption("4MainThirdBallAutoRight", new kMainThirdRightAuto());
    // chooser.addOption("4MainFourBallAutoRight", new kMainFourRightAuto());
    
    Shuffleboard.getTab("Selector").add(chooser);

    
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
  }

  private void configureDefaultCommands() {
    dt.setDefaultCommand(new Drive());
  }
  
  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }
}
