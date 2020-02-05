/*************************************
* @author Chris Lane | FRC 2791 | 2020   
*
* API for a multiplexer camera switch. 
*
* The switch should plug into the relay
* port on the RoboRIO given in the 
* constructor. Each relay value 
* corresponds to a pin on the port being
* driven hi or lo (1/0). 
*
* This API essentially utilizes the 
* relay port as two DI/O ports right 
* next to each other
* kforward = pin1  high/pin 2 low,
* kReverse = pin 1 low/pin 2 high,
* kON  = pin 1 high/pin2 high,
* kOff = pin 1 low/pin 2 low.
*
**************************************/
package edu.wpi.first.wpilibj;
import edu.wpi.first.wpilibj.RelayPortDevice;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;

public class CameraSwitch implements RelayPortDevice{


   public Relay camrelay;

    public CameraSwitch(int port){

       camrelay = new Relay(port);

    }//Constructor for a CameraSwitch on a single relay port

    public void select(String camSelected){

     switch (camSelected) {
        case "kcamera1":   
            camrelay.set(Value.kForward);
           break;
        case "kcamera2" :
            camrelay.set(Value.kReverse);
           break;
        case "kcamera3" :
            camrelay.set(Value.kOn);
        case "kcamera4" :
            camrelay.set(Value.kOff);
            break;
        default:
            camrelay.set(Value.kForward);
            System.err.print("Camera not properly selected, setting to case 1,Camera1");
           break;
     }//This switch statement is what actually writes to the relay port

    }//Use this method to select the desired camera to connect to the RoboRIO

    public void rawSetRelay(Relay.Value kvalue){

       camrelay.set(kvalue);

    }//Use this method to set the relay port to a regular relay value

    public void setDirection(Relay.Direction direction){

       camrelay.setDirection(direction);

    }//Use this method to set valid directions for the local relay used in this class

    public void setLocalRelay(Relay.Value klocalValue) {

        //unused function
        System.err.println("setLocalRelay(Relay.Value klocalValue);--method not utilized in CameraSwitch.java");
        
    }//DO NOT USE THIS METHOD

   }
//end of file-----------------------------------------------------------------------