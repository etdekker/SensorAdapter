package sensor;

import java.awt.Color;

//Implements SensorInterface using PressureSensor methods
public class PressureAdapter implements SensorInterface {
	PressureSensor ps = new PressureSensor();
	
	@Override
	public String getName() {
		return ps.getSensorName();
	}

	@Override
	public String getReport() {
		return ps.getReport();
	}

	@Override
	public double getValue() {
		return ps.readValue();
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
