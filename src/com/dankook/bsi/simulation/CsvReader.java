package com.dankook.bsi.simulation;
import java.io.*;

import com.dankook.bsi.model.Ui_Model;

public class CsvReader {
	private Ui_Model _model;
	private CsvReader reader;
	
	public CsvReader(Ui_Model model){
		String csvFile = "simulationTest.csv";
		_model = model;
		boolean alreadyExists = new File(csvFile).exists();
	}
	
}
