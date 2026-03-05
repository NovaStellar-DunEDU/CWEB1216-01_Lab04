package smartHomeSystem;

public class Light implements SmartDevice 
{
	private String deviceName;
	private String typeOfDevice;
	private int brightness;
	private String status;
	
	public Light(String deviceName, String typeOfDevice, int brightness, String status) 
	{
		this.deviceName = deviceName;
		this.typeOfDevice = typeOfDevice;
		this.brightness = brightness;
		this.status = status;
	}
	
	@Override
	public String toString() 
	{
		String lightInfo = "";
		return lightInfo += "\nDevice: " + deviceName + "\nType: " + typeOfDevice + "\nBrightness: " + brightness + "\nStatus: " + status;
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