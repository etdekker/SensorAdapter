package sensor;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


//Creates GUI Application with 3 sections for Pressure, Radiation, and Temperature
public class SensorApplication extends JFrame {
	
	public SensorApplication() {
		setTitle("Sensor Tracker (JARs)");
		setLayout(new GridLayout(3,1));
		
		add(panelMaker(new PressureAdapter())); //new panel with Pressure data
		add(panelMaker(new RadiationAdapter())); //new panel with Radiation data
		add(panelMaker(new TemperatureAdapter())); //new panel with Temperature data
		
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	//panelMaker populates each section with information from the Adapter that is passed
	private JPanel panelMaker(SensorInterface si) {
		double value = si.getValue(); //gets value to instantiate adapter
		JPanel  panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2)); 
		panel.setBorder(new TitledBorder(si.getName())); //sets border with adapter name
		JPanel colorPanel = new JPanel();
		colorPanel.setBackground(si.getColor()); //adds color panel based on report
		panel.add(colorPanel);
		JLabel label = new JLabel(si.getReport() + "-->" + value); //adds report and value
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label);
		return panel; //returns populated panel to be added in Application
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}
	
}
