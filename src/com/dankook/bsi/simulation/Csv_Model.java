package com.dankook.bsi.simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dankook.bsi.model.Ui_Model;
import com.opencsv.CSVWriter;

import ui.DOMTreeFull.Model;

public class Csv_Model {
	private String csv;
	private CSVWriter writer;
	private List<double[]> data;
	private Ui_Model _model;
	
	public Csv_Model(Ui_Model model) throws IOException {
		_model = model;
		csv = "C:\\csvmodel.csv";
		writer = new CSVWriter(new FileWriter(csv));
		data = new ArrayList<double[]>();
	}
	
	public void csv() {
		data.add(_model.getInfo().getQ_h_b());
		data.add(_model.getInfo().getQ_c_b());
		data.add(_model.getInfo().getQ_w_b());
		data.add(_model.getInfo().getQ_l_b());
		data.add(_model.getInfo().getQ_v_b());
		data.add(_model.getInfo().getQ_h_f());
		data.add(_model.getInfo().getQ_c_f());
		data.add(_model.getInfo().getQ_w_f());
		data.add(_model.getInfo().getQ_h_f_elec());
		data.add(_model.getInfo().getQ_h_f_gas());
		data.add(_model.getInfo().getQ_h_f_local());
		data.add(_model.getInfo().getQ_c_f_elec());
		data.add(_model.getInfo().getQ_c_f_gas());
		data.add(_model.getInfo().getQ_c_f_local());
		data.add(_model.getInfo().getQ_w_f_elec());
		data.add(_model.getInfo().getQ_w_f_gas());
		data.add(_model.getInfo().getQ_w_f_local());
		data.add(_model.getInfo().getQ_h_1());
		data.add(_model.getInfo().getQ_c_1());
		data.add(_model.getInfo().getQ_w_1());
		data.add(_model.getInfo().getQ_l_1());
		data.add(_model.getInfo().getQ_v_1());
		//data.add(_model.getInfo().getQ_I_p());
		//data.add(_model.getInfo().getQ_I_fac());

	
	}
}
