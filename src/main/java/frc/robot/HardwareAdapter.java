package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.libs.SmoothXboxController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.PowerDistribution;


public interface HardwareAdapter{

    public static final int placeholder = 0; //anything that references this needs to be changed; obvs

    // Xbox Controllers
	public static final int xboxPrimaryDriver = 0;
	public static final int xboxSecondaryDriver = 1;
    public static final SmoothXboxController xbox = new SmoothXboxController(xboxPrimaryDriver);
    public static final SmoothXboxController xbox2 = new SmoothXboxController(xboxSecondaryDriver);
    
    //PID
    public final static double kP = 0.05;
    public final static double kI = 0;
    public final static double kD = 0;
    public final static double kIz = 0;
    public final static double kFF = 0.000015;
    public static final double shooter_kP = 6e-5;
    public static final double shooter_kI = 1e-6;
    
    //OI
    public static final double STICK_DEADBAND = 0.15;
    public static final double TRIGGER_DEADBAND = 0.1;

    //Debug
    public static final boolean DEBUG = false;
    
    // PDP/PCM/VRM
    public static final PowerDistribution pdp = new PowerDistribution();
    
    //Limelight
    // public static final double distanceFromLimeLightToGoalInches;
    // public static final double horizontalAngleToTarget;
    // public static final double angleForPivot;
    public static final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    public static final NetworkTableEntry ledMode = table.getEntry("ledMode");
    public static final NetworkTableEntry tx = table.getEntry("tx");
    public static final NetworkTableEntry ty = table.getEntry("ty");
    public static final NetworkTableEntry ta = table.getEntry("ta");
    public static final double x = tx.getDouble(0.0);
    public static final double y = ty.getDouble(0.0);
    public static final double area = ta.getDouble(0.0);
    public static final double limelightMountAngleDegrees = 35.0;
    public static final double limelightLensHeightInches = 36.5;
    public static final double goalHeightInches = 104.0;
    public static final double TARGET_RANGE = 4.0;
    public static final int LL_ON = 3;
    public static final int LL_OFF = 1;

    //Camera
    public static final int FPS = 30;
    public static final int BRIGHTNESS = 40;
    public static final int RES_X = 256;
    public static final int RES_Y = 114;

    //LEDs
    public static final Spark BlinkinLEDDriver = new Spark(0);
    public static final double LEDS_LOCKED_ON = 0.99;
    
    // Drivetrain
    public final CANSparkMax leftMotor1 = new CANSparkMax(1, MotorType.kBrushless);
    public final CANSparkMax leftMotor2 = new CANSparkMax(2, MotorType.kBrushless);
    public final MotorControllerGroup leftSideMotors = new MotorControllerGroup(leftMotor1,leftMotor2);
    
    public final CANSparkMax rightMotor1 = new CANSparkMax(3, MotorType.kBrushless);
    public final CANSparkMax rightMotor2 = new CANSparkMax(4, MotorType.kBrushless);
    public final MotorControllerGroup rightSideMotors = new MotorControllerGroup(rightMotor1,rightMotor2);
    
    public static enum TurnMode {Right, Left};
    
    public final static double kMaxOutput = 0.4;
    public final static double kMinOutput = -0.4;
    public final static double smoothTime = 0.4;
    public final static double safetyTimeout = 2.0;
    public final static double driveRegular = 0.7;
    public final static double driveSlow = 0.4;
    public final static double driveRampTime = 5.0;

    //Climber
    public final CANSparkMax climb1 = new CANSparkMax(14, MotorType.kBrushless);
    public final CANSparkMax climb2 = new CANSparkMax(13, MotorType.kBrushless);
    public final CANSparkMax climbHigh = new CANSparkMax(16, MotorType.kBrushless);
    public final MotorControllerGroup climbMotors = new MotorControllerGroup(climb1,climb2);

    public static final double climbSpeed = 1.0;
    public static final double climbSpeed2 = -1.0;
    public static final double climbHighSpeed = 1.0;

    //Feeder
    public final WPI_TalonSRX mainFeederMotor = new WPI_TalonSRX(11);
    public final WPI_TalonSRX upperFeederMotor = new WPI_TalonSRX(10);

    public static final double mainFeederPowerIn = -0.8;
    public static final double mainFeederPowerOut = 0.8;
    public static final double upperFeederPowerIn = -0.9;

    //Intake
    public final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(7);
    public final CANSparkMax intakePivot = new CANSparkMax(15, MotorType.kBrushless);

    public static final double intakePowerIn = 0.8;
    public static final double intakePivotPowerIn = 0.6;
    public static final double intakePivotPowerOut = -0.6;

    //Pivot
    public static final WPI_TalonSRX pivotMotor = new WPI_TalonSRX(8);
    public static final PIDController pivotPID = new PIDController(placeholder, placeholder, placeholder);
    
    public static final double kMaxPivotPower = 0.15;  //max pivot turn power 2 percent
    public static final double kMaxPivotCorrectPower = 0.15;  //correct when turret goes beyond max range
    public static final double kMaxRange = 30.0;
    public static final double kEncoderRatio = 73.17;
    public static final double kNominalTXError = 1.0;
    public static final int minPivotAngle = 0;
    public static final int maxPivotAngle = 58700;
    
    //Shooter
    public final CANSparkMax flyWheelUpperOne = new CANSparkMax(5, MotorType.kBrushless);
    public final CANSparkMax flyWheelUpperTwo = new CANSparkMax(6, MotorType.kBrushless);

    public static final PIDController pidControllerShooterOne = new PIDController(placeholder, placeholder, placeholder);
    // public static final PIDController pidControllerShooterTwo = new PIDController(placeholder, placeholder, placeholder);


    static final double kMaxShOutput = 1.0;
    static final double kMinShOutput = -1.0;
    static final double manualRPM = 4000;
    static final double MaxRPM = 5676;
    static final double rearShooterPercent = 0.6;
    static final double shooterSlope = 11.9;
    static final double shooterConst = 2215; // previously 2190
    static final double extraRPM = 25.0;

    //Turret
    public final WPI_TalonSRX turretMotor = new WPI_TalonSRX(12);

    public static final double[] goalAngle = {0.01, 90.0, 180.0, 270.0, 359.9};
    public static final double angleThresh = 8.0;
    public static final double kTurretPower = 0.4;               //normal turn power
    public static final double kTurretAutoPower = 0.3;           //autotargeting turn power
    public static final double kMaxTurretPower = 0.5;            //max turret turn power
    public static final double kMAX_RANGE = 180.0;
    public static final double kENCODER_RATIO = 73.17;

    // Encoders
    public static final RelativeEncoder leftEncoder1 =  (leftMotor1.getEncoder());
    public static final RelativeEncoder leftEncoder2 =  (leftMotor2.getEncoder());
    public static final RelativeEncoder rightEncoder1 = (rightMotor1.getEncoder());
    public static final RelativeEncoder rightEncoder2 = (rightMotor2.getEncoder());
    public static final RelativeEncoder encoderShooterOne = (flyWheelUpperOne.getEncoder());
    public static final RelativeEncoder encoderShooterTwo = (flyWheelUpperTwo.getEncoder());
    public static final AnalogEncoder pivotEncoder = new AnalogEncoder(1);
    public static final AnalogEncoder turretEncoder = new AnalogEncoder(0);

    // Gyro
    public static final AHRS navx = new AHRS(SPI.Port.kMXP);
    
    //Auto
    public static final SendableChooser<Command> chooser = new SendableChooser<>();
    public interface AutoConstants {
    public static final boolean WRITE = true;
    public static final boolean READ = false;
    public static final boolean autoFinished = true;
    public static final String kLeftAuto = "2BallAutoLeft.aut";
    public static final String kCenterAuto = "3BallAutoCenter.aut";
    public static final String kRightAuto = "4BallAutoRight";
    public static final String kMainRightAuto = "4MainBallAutoRight";
    public static final String kMainOneRightAuto = "4MainOneBallAutoRight";
    public static final String kMainTwoRightAuto = "4MainTwoBallAutoRight";
    public static final String kMainThirdRightAuto = "4MainThirdBallAutoRight";
    public static final String kMainFourRightAuto = "4MainFourBallAutoRight";
    }

    //Controller
    public interface ControllerInputs {
      public static final double driver_rightY = xbox.getRightY();
      public static final double driver_rightX = xbox.getRightX();
      public static final double driver_leftY = xbox.getLeftY();
      public static final double driver_leftX = xbox.getLeftX();
      public static final boolean driver_AButton = xbox.getAButton();
      public static final boolean driver_BButton = xbox.getBButton();
      public static final boolean driver_XButton = xbox.getXButton();
      public static final boolean driver_YButton = xbox.getYButton();
      public static final boolean driver_StartButton = xbox.getStartButton();
      public static final boolean driver_RightBumper = xbox.getRightBumper();
      public static final boolean driver_LeftBumper = xbox.getLeftBumper();
      public static final double driver_RightTriggerAxis = xbox.getRightTriggerAxis();
      public static final double driver_LeftTriggerAxis = xbox.getLeftTriggerAxis();
      public static final double driver_POV = xbox.getPOV();

      public static final double mani_rightY = xbox2.getRightY();
      public static final double mani_rightX = xbox2.getRightX();
      public static final double mani_leftY = xbox2.getLeftY();
      public static final double mani_leftX = xbox2.getLeftX();
      public static final boolean mani_AButton = xbox2.getAButton();
      public static final boolean mani_BButton = xbox2.getBButton();
      public static final boolean mani_XButton = xbox2.getXButton();
      public static final boolean mani_YButton = xbox2.getYButton();
      public static final boolean mani_StartButton = xbox2.getStartButton();
      public static final boolean mani_RightBumper = xbox2.getRightBumper();
      public static final boolean mani_LeftBumper = xbox2.getLeftBumper();
      public static final double mani_RightTriggerAxis = xbox2.getRightTriggerAxis();
      public static final double mani_LeftTriggerAxis = xbox2.getLeftTriggerAxis();
      public static final double mani_POV = xbox2.getPOV();    
    }
	// Gear Ratios  
	// Diameters   
    // Robot dimensions
    // Pneumatics
    // Analog Inputs
    // Relays
    // Limit Switches
}
