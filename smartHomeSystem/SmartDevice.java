package smartHomeSystem;

abstract interface SmartDevice 
{
	// update device status to be on or off
	public String turnOn();
	public String turnOff();
	// print details like device name, type, brightness and status
	public String toString();
}
