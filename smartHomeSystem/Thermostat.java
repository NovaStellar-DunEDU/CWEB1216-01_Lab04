package smartHomeSystem;

public class Thermostat implements SmartDevice 
{
	private String deviceName;
	private String typeOfDevice;
	private double temperature;
	private String status;
	
	public Thermostat(String deviceName, String typeOfDevice, double temperature, String status) 
	{
		this.deviceName = deviceName;
		this.typeOfDevice = typeOfDevice;
		this.temperature = temperature;
		this.status = status;
	}
	
	@Override
	public String toString() 
	{
		String thermoInfo = "";
		return thermoInfo += "\nDevice: " + deviceName + "\nType: " + typeOfDevice + "\nTemperature: " + temperature + "\nStatus: " + status;
	}
	
	@Override
	public String turnOn() {
		String status = "ON";
		return status;
	}

	@Override
	public String turnOff() {
		String status = "OFF";
		return status;
	}
}