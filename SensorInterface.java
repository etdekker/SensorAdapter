package sensor;

import java.awt.Color;

//Provides unimplemented methods to be used by adapters.
public interface SensorInterface {
	String getName(); 
    String getReport();
    double getValue();
	Color getColor();
}
