package com.dankook.bsi.simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dankook.bsi.model.Ui_Model;
import com.opencsv.CSVWriter;

public class CsvWriter {
	private String csvpath;
	private CSVWriter writer;
	private List<String[]> data;
	private Ui_Model _model;
	
	public CsvWriter(Ui_Model model) throws IOException {
		_model = model;
		csvpath = "simulationTest.csv";
		writer = new CSVWriter(new FileWriter(csvpath));
		data = new ArrayList<String[]>();
	}
	
	@SuppressWarnings("static-access")
	public void csvWriter() throws IOException {
		
		data.add(new String[]{"Result", "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
		data.add(_model.getInfo().parseString(new String[]{"HEATING_REQ", ""}, _model.getInfo().getQ_h_b()));
		data.add(_model.getInfo().parseString(new String[]{"COOLING_REQ", ""}, _model.getInfo().getQ_c_b()));
		data.add(_model.getInfo().parseString(new String[]{"HEATINGPUMP_REQ", ""}, _model.getInfo().getQ_w_b()));
		data.add(_model.getInfo().parseString(new String[]{"LIGHTING_REQ", ""}, _model.getInfo().getQ_l_b()));
		data.add(_model.getInfo().parseString(new String[]{"HEATING_DEM", "ELEC"}, _model.getInfo().getQ_h_f_elec()));
		data.add(_model.getInfo().parseString(new String[]{"HEATING_DEM", "GAS"}, _model.getInfo().getQ_h_f_gas()));
		data.add(_model.getInfo().parseString(new String[]{"HEATING_DEM", "LOCAL"}, _model.getInfo().getQ_h_f_local()));
		data.add(_model.getInfo().parseString(new String[]{"COOLING_DEM", "ELEC"}, _model.getInfo().getQ_c_f_elec()));
		data.add(_model.getInfo().parseString(new String[]{"COOLING_DEM", "GAS"}, _model.getInfo().getQ_c_f_gas()));
		data.add(_model.getInfo().parseString(new String[]{"COOLING_DEM", "LOCAL"}, _model.getInfo().getQ_c_f_local()));
		data.add(_model.getInfo().parseString(new String[]{"HEATINGPUMP_DEM", "ELEC"}, _model.getInfo().getQ_w_f_elec()));
		data.add(_model.getInfo().parseString(new String[]{"HEATINGPUMP_DEM", "GAS"}, _model.getInfo().getQ_w_f_gas()));
		data.add(_model.getInfo().parseString(new String[]{"HEATINGPUMP_DEM", "LOCAL"}, _model.getInfo().getQ_w_f_local()));
		data.add(_model.getInfo().parseString(new String[]{"LIGHTING_DEM", ""}, _model.getInfo().getQ_l_b()));
		data.add(_model.getInfo().parseString(new String[]{"VENTILATING_DEM", ""}, _model.getInfo().getQ_v_b()));
		data.add(_model.getInfo().parseString(new String[]{"HEATING_F_DEM", ""}, _model.getInfo().getQ_h_1()));
		data.add(_model.getInfo().parseString(new String[]{"COOLING_F_DEM", ""}, _model.getInfo().getQ_c_1()));
		data.add(_model.getInfo().parseString(new String[]{"HEATINGPUMP_F_DEM", ""}, _model.getInfo().getQ_w_1()));
		data.add(_model.getInfo().parseString(new String[]{"LIGHTING_F_DEM", ""}, _model.getInfo().getQ_l_1()));
		data.add(_model.getInfo().parseString(new String[]{"VENTILATING_F_DEM", ""}, _model.getInfo().getQ_v_1()));
		
		writer.writeAll(data);
		
		writer.close();
		System.out.println("Success Export");
	}
}
