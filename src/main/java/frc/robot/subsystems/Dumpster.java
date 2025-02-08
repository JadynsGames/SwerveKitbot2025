// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Dumpster extends SubsystemBase {
  private SparkMax m_dumpsterDown;

  public Dumpster() {
    m_dumpsterDown =  new SparkMax(Constants.SubsystemConstants.kDumpsterId, MotorType.kBrushed);
    SparkMaxConfig globalConfig = new SparkMaxConfig();

    globalConfig
        .smartCurrentLimit(50)
        .idleMode(IdleMode.kBrake);

    m_dumpsterDown.configure(globalConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public void runDumpster(double speed) {
    if(speed > 1){
        speed = 1;
    } else if(speed < -1){
        speed = -1;
    }
    m_dumpsterDown.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}