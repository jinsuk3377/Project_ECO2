package com.dankook.bsi.simulation;
import java.io.*;

import com.dankook.bsi.model.Ui_Model;

public class CsvReader {
	private Ui_Model _model;
	private CsvReader reader;
	
	public CsvReader(Ui_Model model){
		String csvFile = "C:\\Users\\XNOTE\\git\\Project_ECO2\\simulationTest.csv";
		_model = model;
		boolean alreadyExists = new File(csvFile).exists();
	}
	
	public void run(){
		
	}
	
	
	
}
