package sensor;

import java.awt.Color;

//Implements SensorInterface using RadiationSensor methods
public class RadiationAdapter implements SensorInterface {
	RadiationSensor rs = new RadiationSensor();
	
	@Override
	public String getName() {
		return rs.getName();
	}

	@Override
	public String getReport() {
		return rs.getStatusInfo();
	}

	@Override
	public double getValue() {
		return rs.getRadiationValue();
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
