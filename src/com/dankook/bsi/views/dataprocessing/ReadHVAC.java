package com.dankook.bsi.views.dataprocessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.xml.sax.SAXException;

import com.dankook.bsi.model.CoolingSystemType;
import com.dankook.bsi.model.HeatingPumpSystemType;
import com.dankook.bsi.model.HeatingSystemType;
import com.dankook.bsi.model.Ui_Model;

public class ReadHVAC {
	
	private Ui_Model _model;
	
	//private File file = null;
	private Workbook workBook = null;
	
	private boolean check = false;
	private String errorMsg = "";
	
	public ReadHVAC (Ui_Model model) throws IOException, 
											SAXException, 
											EncryptedDocumentException, 
											InvalidFormatException {
		_model = model;		
		//file = new File(_model.getHVACFilePath());
		workBook = WorkbookFactory.create(new FileInputStream(_model.getHVACFilePath()));
		
	}
	
	public boolean ExcelRead() throws IOException {
		
		Sheet curSheet;
		Cell curCell;
		String valueOfString;
		double valueOfDouble;
		
		try {
			
			curSheet = workBook.getSheetAt(0);
			
			for (int rowNum = 0; rowNum < curSheet.getPhysicalNumberOfRows(); rowNum++) {
				
				if (rowNum == 7) {
					
					//set HeatingSystemType
					curCell = curSheet.getRow(rowNum).getCell(2);
					valueOfString = (String) getCellValue(curCell);
					
					if (valueOfString.equals("보일러")) 
						_model.getInfo().setHeatingSystemType(HeatingSystemType.보일러);
					else if (valueOfString.equals("지역난방"))
						_model.getInfo().setHeatingSystemType(HeatingSystemType.지역난방);
					else if (valueOfString.equals("EHP"))
						_model.getInfo().setHeatingSystemType(HeatingSystemType.EHP);
					else {
						errorMsg += "\nError HeatingSystemType CellAddress to < " + curSheet.getRow(rowNum).getCell(2).getAddress().toString() + " >";
						System.out.println("Error HeatingSystemType CellAddress to < " + curSheet.getRow(rowNum).getCell(2).getAddress().toString() + " >");
					}
					
					//set HeatingVolumn
					curCell = curSheet.getRow(rowNum).getCell(3);
					valueOfDouble = (double) getCellValue(curCell);
					if(valueOfDouble <= -0.0001||valueOfDouble >= 0.0001) _model.getInfo().setHeatingVolumn(valueOfDouble);
					
					//set HeatingEfficiency
					curCell = curSheet.getRow(rowNum).getCell(5);
					valueOfDouble = (double) getCellValue(curCell);
					if(valueOfDouble <= -0.0001||valueOfDouble >= 0.0001) _model.getInfo().setHeatingEfficiency(valueOfDouble);
					
				}
				
				if (rowNum == 10) {
					
					//set HeatingPumpSystemType
					curCell = curSheet.getRow(rowNum).getCell(2);
					valueOfString = (String) getCellValue(curCell);
					
					if (valueOfString.equals("보일러")) 
						_model.getInfo().setHeatingPumpSystemType(HeatingPumpSystemType.보일러);
					else if (valueOfString.equals("지역난방"))
						_model.getInfo().setHeatingPumpSystemType(HeatingPumpSystemType.지역난방);
					else if (valueOfString.equals("EHP"))
						_model.getInfo().setHeatingPumpSystemType(HeatingPumpSystemType.EHP);
					else {
						errorMsg += "\nError HeatingSystemType CellAddress to < " + curSheet.getRow(rowNum).getCell(2).getAddress().toString() + " >";
						System.out.println("Error HeatingPumpSystemType CellAddress to < " + curSheet.getRow(rowNum).getCell(2).getAddress().toString() + " >");
					}
					
					//set HeatingPumpVolumn
					curCell = curSheet.getRow(rowNum).getCell(3);
					valueOfDouble = (double) getCellValue(curCell);
					if(valueOfDouble <= -0.0001||valueOfDouble >= 0.0001) _model.getInfo().setHeatingPumpVolumn(valueOfDouble);
					
					//set HeatingPumpEfficiency
					curCell = curSheet.getRow(rowNum).getCell(5);
					valueOfDouble = (double) getCellValue(curCell);
					if(valueOfDouble <= -0.0001||valueOfDouble >= 0.0001) _model.getInfo().setHeatingPumpEfficiency(valueOfDouble);
					
				}
				
				if (rowNum == 13) {
					
					//set CoolingSystemType
					curCell = curSheet.getRow(rowNum).getCell(2);
					valueOfString = (String) getCellValue(curCell);
					
					if (valueOfString.equals("압축식")) 
						_model.getInfo().setCoolingSystemType(CoolingSystemType.압축식);
					else if (valueOfString.equals("흡수식"))
						_model.getInfo().setCoolingSystemType(CoolingSystemType.흡수식);
					else if (valueOfString.equals("EHP"))
						_model.getInfo().setCoolingSystemType(CoolingSystemType.EHP);
					else {
						errorMsg += "\nError CoolingSystemType CellAddress to < " + curSheet.getRow(rowNum).getCell(2).getAddress().toString() + " >";
						System.out.println("Error CoolingSystemType CellAddress to < " + curSheet.getRow(rowNum).getCell(2).getAddress().toString() + " >");
					}
					
					//set CoolingVolumn
					curCell = curSheet.getRow(rowNum).getCell(3);
					valueOfDouble = (double) getCellValue(curCell);
					if(valueOfDouble <= -0.0001||valueOfDouble >= 0.0001) _model.getInfo().setCoolingVolumn(valueOfDouble);
					
					//set CoolingEfficiency
					curCell = curSheet.getRow(rowNum).getCell(5);
					valueOfDouble = (double) getCellValue(curCell);
					if(valueOfDouble <= -0.0001||valueOfDouble >= 0.0001) _model.getInfo().setCoolingEfficiency(valueOfDouble);
				}
				
				if (rowNum == 16) {
					
					//set LightingDensity
					curCell = curSheet.getRow(rowNum).getCell(2);
					valueOfDouble = (double) getCellValue(curCell);
					if(valueOfDouble <= -0.0001||valueOfDouble >= 0.0001) _model.getInfo().setLightingDensity(valueOfDouble);
				}
			}
			check = true;
			
		} catch (ClassCastException e) {
			// 에러창 표시
			check = false;
			errorMsg +=	"\n" + e.getMessage();
			e.printStackTrace();
		} catch (Exception e) {
			check = false;
			errorMsg +=	"\n" + e.getMessage();
			e.printStackTrace();
		}
		
		if (!errorMsg.isEmpty()) JOptionPane.showMessageDialog(null, 
					errorMsg, 
					"Error : ReadHVAC", JOptionPane.INFORMATION_MESSAGE);

		return check;
	}	
	
	public Object getCellValue(Cell cellData) {
		
		Object value = null;
		
		try {
			switch(cellData.getCellType()){
			
			case Cell.CELL_TYPE_NUMERIC:
				value = cellData.getNumericCellValue();
				break;
			case Cell.CELL_TYPE_STRING:
				value = cellData.getStringCellValue();
				break;
			case Cell.CELL_TYPE_FORMULA:
				errorMsg += "\nError CELL_TYPE_FORMULA CellAddress to < " + cellData.getAddress().toString() + " >";
				System.out.println("Error CELL_TYPE_FORMULA CellAddress to < " + cellData.getAddress().toString() + " >");
				break;
			case Cell.CELL_TYPE_ERROR:
				errorMsg += "Error CELL_TYPE_ERROR CellAddress to < " + cellData.getAddress().toString() + " >";
				System.out.println("Error CELL_TYPE_ERROR CellAddress to < " + cellData.getAddress().toString() + " >");
				break;
			default:
				errorMsg += "Error value in other type CellAddress to < " + cellData.getAddress().toString() + " >";
				System.out.println("Error value in other type CellAddress to < " + cellData.getAddress().toString() + " >");
				break;
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMessage() + "\ncellData is missing.", 
					"Error : ReadHVAC", JOptionPane.INFORMATION_MESSAGE);
		}
		
		return value;
	}
}
