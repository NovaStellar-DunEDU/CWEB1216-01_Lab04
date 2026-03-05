package smartHomeSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) 
	{
		System.out.println("=== DEVICE CATALOG ===\n");
		
		DeviceManager devices = new DeviceManager();
		Scanner scanner = new Scanner(System.in);
		boolean validInputWait = true;
		int amtOfDevices = 0;
		
		while (validInputWait) 
		{
			try 
			{
				System.out.print("Enter the number of devices to add: ");
				amtOfDevices = scanner.nextInt();
				validInputWait = false;
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Error occured. You did not enter a valid response.");
				scanner = new Scanner(System.in);
			}
		}
		
			for(int i = 0; i <= (amtOfDevices - 1); i++) 
			{
				System.out.println("\n=====================================================\n");

				scanner = new Scanner(System.in);

				System.out.print("Enter device type (Light/Thermostat): ");
				String typeDevice = scanner.nextLine();
				
				switch (typeDevice)
				{
					case "Light", "light":
						Light newLight = createNewLight();
						devices.addNewDevice(newLight);
						break;
					
					case "Thermostat", "thermostat":
						Thermostat newThermostat = createNewThermostat();
						devices.addNewDevice(newThermostat);
						break;
						
					default:
						System.out.print("Input invalid.");
						validInputWait = false;
				
				}
			}

		devices.displayAllDevices();
		
	}

	private static Light createNewLight() 
	{
		String typeDevice = "Light";
		String status = "OFF";
		boolean validInputWait = true;
		Scanner scanner = new Scanner(System.in);
		int brightness = 0;
		
		System.out.print("Enter device name: ");
		String deviceName = scanner.nextLine();
		
		while(validInputWait) 
		{
			try 
			{
				System.out.print("Enter brightness (0-100): ");
				brightness = scanner.nextInt();
				
				if(brightness <= 100 && brightness >= 0) {
					validInputWait = false;
				}
				
				else {
					System.out.println("Error occured. You did not enter a number between (0-100).");
					validInputWait = true;
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("Error occured. You did not enter a valid response.");
				scanner = new Scanner(System.in);
			}
		}
		
		validInputWait = true;
		
		while(validInputWait) 
		{
			scanner = new Scanner(System.in);
			System.out.print("Is this light ON?: ");
			status = scanner.nextLine();
			
			switch(status) 
			{
				case "Yes", "yes", "On", "on", "YES", "ON", "1", "Y", "y":
					System.out.println("Device " + "'" + deviceName + "'" + " got added successfully!");
					status = "ON";
					break;
					
				case "no", "No", "Off", "off", "NO", "OFF", "0", "n", "N":
					System.out.println("Device " + "'" + deviceName + "'" + " got added successfully!");
					status = "OFF";
					break;
					
				default:
					System.out.println("Device " + "'" + deviceName + "'" + " got added with invalid response. \nDefaulting to 'OFF'.");
					status = "OFF";
			}
			
			validInputWait = false;
			
		}
		
		Light newLight = new Light(deviceName, typeDevice, brightness, status);
		
		return newLight;
	}
	
	private static Thermostat createNewThermostat() 
	{
		String typeDevice = "Thermostat";
		String status = "OFF";
		boolean validInputWait = true;
		Scanner scanner = new Scanner(System.in);
		double temperature = 0.0;
		
		System.out.print("Enter device name: ");
		String deviceName = scanner.nextLine();
		
		while(validInputWait) 
		{
			try 
			{
				System.out.print("Enter temperature (°F): ");
				temperature = scanner.nextDouble();
				validInputWait = false;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Error occured. You did not enter a valid response.");
				scanner = new Scanner(System.in);
			}
		}
		
		validInputWait = true;
		
		while(validInputWait) 
		{
			scanner = new Scanner(System.in);
			System.out.print("Is this thermostat ON?: ");
			status = scanner.nextLine();
			
			switch(status) 
			{
				case "Yes", "yes", "On", "on", "YES", "ON", "1", "Y", "y":
					System.out.println("Device " + "'" + deviceName + "'" + " got added successfully!");
					status = "ON";
					break;
					
				case "no", "No", "Off", "off", "NO", "OFF", "0", "N", "n":
					System.out.println("Device " + "'" + deviceName + "'" + " got added successfully!");
					status = "OFF";
					break;
					
				default:
					System.out.println("Device " + "'" + deviceName + "'" + " got added with the status as invalid response. Defaulting to 'OFF'.");
					status = "OFF";
			}
			
			validInputWait = false;
		}
		
		Thermostat newThermostat = new Thermostat(deviceName, typeDevice, temperature, status);
		
		return newThermostat;
	}
}
