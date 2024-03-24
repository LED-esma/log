package com.team5430.util;

import com.ctre.phoenix.motorcontrol.StickyFaults;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.WaitCommand;

public class log{


    
    public log(){}


    private void println(String printing){
        System.out.println(printing);
    }

    public void motor(TalonSRX name){
        StickyFaults errors = new StickyFaults();
        
            name.getStickyFaults(errors);

            String motorName = name.toString();

            double startup = 0;

            if(errors.APIError == true){
            println(motorName + ": API Error, check firmware");
                }else if(errors.HardwareESDReset == true){
                    println(motorName + ": Not used.");
                }else if(errors.RemoteLossOfSignal == true){
                    println(motorName + ": RemoteSensor lost conection.");
                }else if (errors.ResetDuringEn == true){
                    println(motorName + ": Has been turned on while enabled, or reset, please check wiring.");
                }else if (errors.SensorOutOfPhase == true){
                    println(motorName + ": Sensor is not aligned properly.");
                }else if (errors.SensorOverflow == true){
                    println(motorName + ": Sensor Overflow.");
                }else if (errors.SupplyOverV == true){
                    println(motorName + ": voltage is above rated voltage.");
                }else if (errors.SupplyUnstable == true){
                    println(motorName + ": voltage is fluctuationg too much, check battery");
                }else if (errors.UnderVoltage == true){
                    println(motorName + ": voltage is under 6.5V");
                }else if (errors.HardwareESDReset == false && startup >= 1){
                    println(motorName + ": [✓]");
                    startup++;
                }
            new WaitCommand(1);
    }
    public void motor(TalonFX name){
      String motorName = name.toString();
      double startup = 1;
              if(name.getStickyFault_ProcTemp().getValue() == true){
            println(motorName + ": Temperature exceeded limit.");
                }else if(name.getStickyFault_MissingDifferentialFX().getValue() == true){
                    println(motorName + ": Not used.");
                }else if(name.getStickyFault_RemoteSensorDataInvalid().getValue() == true){
                    println(motorName + ": RemoteSensor lost conection, data may not be accurate any");
                }else if (name.getStickyFault_Hardware().getValue() == true){
                    println(motorName + ": Hardware fault occured.");
                }else if (name.getStickyFault_FusedSensorOutOfSync().getValue() == true){
                    println(motorName + ": Sensor is not in sync.");
                }else if (name.getStickyFault_RemoteSensorPosOverflow().getValue() == true){
                    println(motorName + ": Sensor Overflow.");
                }else if (name.getStickyFault_OverSupplyV().getValue() == true){
                    println(motorName + ": voltage is above rated voltage.");
                }else if (name.getStickyFault_UnstableSupplyV().getValue() == true){
                    println(motorName + ": voltage is fluctuationg too much, check battery");
                }else if (name.getStickyFault_Undervoltage().getValue() == true){
                    println(motorName + ": voltage is under 6.5V");
                }else if (name.getStickyFault_BootDuringEnable().getValue() == false && startup >= 1){
                    println(motorName + ": [✓]");
                    startup++;
                }
            new WaitCommand(1);
    }

}

