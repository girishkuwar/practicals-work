public class CeilingFan 
{
 public static final int HIGH = 3;
 public static final int MEDIUM = 2;
 public static final int LOW = 1;
 public static final int OFF = 0;
 String location;
 int speed;
 public CeilingFan(String location) 
{
 this.location = location;
 speed = OFF;
 }
 
 public void high() {
 speed = HIGH;
 // code to set fan to high
 } 
 public void medium() {
 speed = MEDIUM;
 // code to set fan to medium 
 }
 public void low() {
 speed = LOW;
 // code to set fan to low
 }
 
 public void off() {
 speed = OFF;
 // code to turn fan off
 }
 
 public int getSpeed() {
 return speed;
 }
}

public class CeilingFanHighCommand implements Command {
 CeilingFan ceilingFan;
 int prevSpeed;
 
 public CeilingFanHighCommand(CeilingFan ceilingFan) {
 this.ceilingFan = ceilingFan;
 }
 public void execute() {
 prevSpeed = ceilingFan.getSpeed();
 ceilingFan.high();
 }
 public void undo() {
 if (prevSpeed == CeilingFan.HIGH) {
 ceilingFan.high();
 } else if (prevSpeed == CeilingFan.MEDIUM) {
 ceilingFan.medium();
 } else if (prevSpeed == CeilingFan.LOW) {
 ceilingFan.low();
 } else if (prevSpeed == CeilingFan.OFF) {
 ceilingFan.off();
 }
 }
}

public class RemoteLoader 
{
 public static void main(String[] args) 
{
 RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
 CeilingFan ceilingFan = new CeilingFan("Living Room");
 
 CeilingFanMediumCommand ceilingFanMedium = 
 new CeilingFanMediumCommand(ceilingFan);
 CeilingFanHighCommand ceilingFanHigh = 
 new CeilingFanHighCommand(ceilingFan);
 CeilingFanOffCommand ceilingFanOff = 
 new CeilingFanOffCommand(ceilingFan);
 
 remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
 remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);
 
 remoteControl.onButtonWasPushed(0);
 remoteControl.offButtonWasPushed(0);
 System.out.println(remoteControl);
 remoteControl.undoButtonWasPushed();
 
 remoteControl.onButtonWasPushed(1);
 System.out.println(remoteControl);
 remoteControl.undoButtonWasPushed();
 }
}