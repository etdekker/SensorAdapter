package sensor;

import java.awt.Color;

//Implements SensorInterface using TemperatureSensor methods
public class TemperatureAdapter implements SensorInterface{
	TemperatureSensor ts = new TemperatureSensor();
	
	@Override
	public String getName() {
		return ts.getSensorType();
	}

	@Override
	public String getReport() {
		return ts.getTempReport();
	}

	@Override
	public double getValue() {
		return ts.senseTemperature();
	}
	
	//returns color based on report string
	public Color getColor() {
		String report = getReport();
		if(report.equals("OK"))
			return Color.green;
		else if(report.equals("CRITICAL"))
			return Color.yellow;
		else
			return Color.red;
	}
}
