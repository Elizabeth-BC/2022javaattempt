package frc.robot.subsystems;

import java.io.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;
import frc.robot.HardwareAdapter.ControllerInputs;

public class Auto extends SubsystemBase implements HardwareAdapter.ControllerInputs{

  private File cmdFile;
  private FileInputStream fReader;
  private ObjectInputStream cmdRead;
  private FileOutputStream fWriter;
  private ObjectOutputStream cmdWrite;
  private String basePath = "/home/lvuser/";

  public Auto() {

  }

  public void setupPlayback(String inputFileName) {
    String filePath = basePath + inputFileName + ".aut";
    Debug.debugCons("Reading auto instructions from " + filePath);
    cmdFile = new File(filePath);
    try {
      fReader = new FileInputStream(cmdFile);
      cmdRead = new ObjectInputStream(fReader);
    } catch(IOException err) {
      Debug.debugCons("Error opening auto file for read: " + err.toString());
    }
  }

  public ControllerInputs readFile() {
    // Debug.debugCons("Reading auto file...");
    ControllerInputs inputs = null;
    try {
      inputs = (ControllerInputs) cmdRead.readObject();
    } catch (IOException err) {
      Debug.debugCons("Error reading auto file: " + err.toString());      
    } catch (ClassNotFoundException cerr) {
      Debug.debugCons("Could not read controller inputs object from auto file: " + cerr.toString());
    }
    return inputs;
  }

  // Done in Test part of Robot
  public void setupRecording(String inputFileName) {
    String filePath = basePath + inputFileName + ".aut";
    Debug.debugCons("Reading auto instructions from " + filePath);
    cmdFile = new File(filePath);
    try {
      fWriter = new FileOutputStream(cmdFile);
      cmdWrite = new ObjectOutputStream(fWriter);
    } catch(IOException err) {
      Debug.debugCons("Error opening auto file for write: " + err.toString());
    }
  }

  public void record(ControllerInputs inputs) {
    Debug.debugCons("Writing auto file...");
    try {
      cmdWrite.writeObject(inputs);
    } catch(IOException err) {
      Debug.debugCons("Error writing auto file: " + err.toString());
    }
  }

  public void closeFile() {
    Debug.debugCons("Auto file closed.");
    if (fReader != null) {
      try {
        fReader.close();      
      } catch (IOException err) {
        Debug.debugCons("Error closing auto file: " + err.toString());
      }
    }
    if (fWriter != null) {
      try {
        fWriter.close();
      } catch(IOException err) {
        Debug.debugCons("Error closing auto file: " + err.toString());
      }
    }
  }
}