package smartHomeSystem;

import java.util.HashSet;
import java.util.Set;

public class DeviceManager 
{
	Set<SmartDevice> devices = new HashSet<>();
	
	public void addNewDevice(SmartDevice newDevice) 
	{
		devices.add(newDevice);
	}
	
	public void displayAllDevices() 
	{
		
		System.out.println("\n=================== DEVICE SUMMARY ==================");
		
		if(devices.isEmpty()) 
		{
			System.out.println("No devices to display");
		}
		else 
		{			
			System.out.println(devices.toString().replace("[", "").replace("]", "").replace(",", "\n"));
		}
		
		System.out.println("\n=====================================================\n");
	}
	
}