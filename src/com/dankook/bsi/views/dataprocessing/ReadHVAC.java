package com.dankook.bsi.views.dataprocessing;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
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

	// private File file = null;
	private Workbook workBook = null;

	private boolean check = false;
	private String errorMsg = "";

	public ReadHVAC(Ui_Model model)
			throws IOException, SAXException, EncryptedDocumentException, InvalidFormatException {
		_model = model;
		// file = new File(_model.getHVACFilePath());
		workBook = WorkbookFactory.create(new FileInputStream(_model.getHVACFilePath()));

	}
	
	public boolean ExcelReadXlsx() throws IOException {
		Sheet curSheetXlsx;
		Cell curCellXlsx;
		String valueOfStringXlsx;
		double valueOfDoubleXlsx;
		
		try {
			
			curSheetXlsx = workBook.getSheetAt(0);
			
			for (int rowNum = 0; rowNum < curSheetXlsx.getPhysicalNumberOfRows(); rowNum++) {
				
				if (rowNum == 7) {
					
					//set HeatingSystemType
					curCellXlsx = curSheetXlsx.getRow(rowNum).getCell(2);
					valueOfStringXlsx = (String) getCellValue(curCellXlsx);
					
					if (valueOfStringXlsx.equals("보일러")) 
						_model.getInfo().setHeatingSystemType(HeatingSystemType.보일러);
					else if (valueOfStringXlsx.equals("지역난방"))
						_model.getInfo().setHeatingSystemType(HeatingSystemType.지역난방);
					else if (valueOfStringXlsx.equals("EHP"))
						_model.getInfo().setHeatingSystemType(HeatingSystemType.EHP);
					else {
						errorMsg += "\nError HeatingSystemType CellAddress to < " + curSheetXlsx.getRow(rowNum).getCell(2).getAddress().toString() + " >";
						System.out.println("Error HeatingSystemType CellAddress to < " + curSheetXlsx.getRow(rowNum).getCell(2).getAddress().toString() + " >");
					}
					
					//set HeatingVolumn
					curCellXlsx = curSheetXlsx.getRow(rowNum).getCell(3);
					valueOfDoubleXlsx = (double) getCellValue(curCellXlsx);
					if(valueOfDoubleXlsx <= -0.0001||valueOfDoubleXlsx >= 0.0001) _model.getInfo().setHeatingVolumn(valueOfDoubleXlsx);
					
					//set HeatingEfficiency
					curCellXlsx = curSheetXlsx.getRow(rowNum).getCell(5);
					valueOfDoubleXlsx = (double) getCellValue(curCellXlsx);
					if(valueOfDoubleXlsx <= -0.0001||valueOfDoubleXlsx >= 0.0001) _model.getInfo().setHeatingEfficiency(valueOfDoubleXlsx);
					
				}
				
				if (rowNum == 10) {
					
					//set HeatingPumpSystemType
					curCellXlsx = curSheetXlsx.getRow(rowNum).getCell(2);
					valueOfStringXlsx = (String) getCellValue(curCellXlsx);
					
					if (valueOfStringXlsx.equals("보일러")) 
						_model.getInfo().setHeatingPumpSystemType(HeatingPumpSystemType.보일러);
					else if (valueOfStringXlsx.equals("지역난방"))
						_model.getInfo().setHeatingPumpSystemType(HeatingPumpSystemType.지역난방);
					else if (valueOfStringXlsx.equals("EHP"))
						_model.getInfo().setHeatingPumpSystemType(HeatingPumpSystemType.EHP);
					else {
						errorMsg += "\nError HeatingSystemType CellAddress to < " + curSheetXlsx.getRow(rowNum).getCell(2).getAddress().toString() + " >";
						System.out.println("Error HeatingPumpSystemType CellAddress to < " + curSheetXlsx.getRow(rowNum).getCell(2).getAddress().toString() + " >");
					}
					
					//set HeatingPumpVolumn
					curCellXlsx = curSheetXlsx.getRow(rowNum).getCell(3);
					valueOfDoubleXlsx = (double) getCellValue(curCellXlsx);
					if(valueOfDoubleXlsx <= -0.0001||valueOfDoubleXlsx >= 0.0001) _model.getInfo().setHeatingPumpVolumn(valueOfDoubleXlsx);
					
					//set HeatingPumpEfficiency
					curCellXlsx = curSheetXlsx.getRow(rowNum).getCell(5);
					valueOfDoubleXlsx = (double) getCellValue(curCellXlsx);
					if(valueOfDoubleXlsx <= -0.0001||valueOfDoubleXlsx >= 0.0001) _model.getInfo().setHeatingPumpEfficiency(valueOfDoubleXlsx);
					
				}
				
				if (rowNum == 13) {
					
					//set CoolingSystemType
					curCellXlsx = curSheetXlsx.getRow(rowNum).getCell(2);
					valueOfStringXlsx = (String) getCellValue(curCellXlsx);
					
					if (valueOfStringXlsx.equals("압축식")) 
						_model.getInfo().setCoolingSystemType(CoolingSystemType.압축식);
					else if (valueOfStringXlsx.equals("흡수식"))
						_model.getInfo().setCoolingSystemType(CoolingSystemType.흡수식);
					else if (valueOfStringXlsx.equals("EHP"))
						_model.getInfo().setCoolingSystemType(CoolingSystemType.EHP);
					else {
						errorMsg += "\nError CoolingSystemType CellAddress to < " + curSheetXlsx.getRow(rowNum).getCell(2).getAddress().toString() + " >";
						System.out.println("Error CoolingSystemType CellAddress to < " + curSheetXlsx.getRow(rowNum).getCell(2).getAddress().toString() + " >");
					}
					
					//set CoolingVolumn
					curCellXlsx = curSheetXlsx.getRow(rowNum).getCell(3);
					valueOfDoubleXlsx = (double) getCellValue(curCellXlsx);
					if(valueOfDoubleXlsx <= -0.0001||valueOfDoubleXlsx >= 0.0001) _model.getInfo().setCoolingVolumn(valueOfDoubleXlsx);
					
					//set CoolingEfficiency
					curCellXlsx = curSheetXlsx.getRow(rowNum).getCell(5);
					valueOfDoubleXlsx = (double) getCellValue(curCellXlsx);
					if(valueOfDoubleXlsx <= -0.0001||valueOfDoubleXlsx >= 0.0001) _model.getInfo().setCoolingEfficiency(valueOfDoubleXlsx);
				}
				
				if (rowNum == 16) {
					
					//set LightingDensity
					curCellXlsx = curSheetXlsx.getRow(rowNum).getCell(2);
					valueOfDoubleXlsx = (double) getCellValue(curCellXlsx);
					if(valueOfDoubleXlsx <= -0.0001||valueOfDoubleXlsx >= 0.0001) _model.getInfo().setLightingDensity(valueOfDoubleXlsx);
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

	public boolean ExcelRead() throws IOException {

		Sheet curSheet;
		Cell curCell;
		int rows;
		String valueOfString;
		double valueOfDouble;
		// String cell ="";

		try {

			curSheet = workBook.getSheetAt(0);
			// curSheet = _model.getHvacRead().getExcelWBook().getSheetAt(0);

			// for (int rowNum = 0; rowNum < curSheet.getPhysicalNumberOfRows();
			// rowNum++) {
			
			for (int rowindex = 0; rowindex < curSheet.getPhysicalNumberOfRows(); rowindex++) {

						if (rowindex == 50) {

							// cell = _model.getHvacRead().getCellData(rowindex,
							// columnindex);

							// set LightingDensity
							curCell = curSheet.getRow(rowindex).getCell(5);
							valueOfString = (String) getCellValue(curCell);

							if (valueOfString.equals("보일러")) 
								_model.getInfo().setHeatingSystemType(HeatingSystemType.보일러);
							else if (valueOfString.equals("지역난방")) 
								_model.getInfo().setHeatingSystemType(HeatingSystemType.지역난방);
							 else if (valueOfString.equals("EHP")) 
								_model.getInfo().setHeatingSystemType(HeatingSystemType.EHP);
							 else {
								errorMsg += "\nError HeatingSystemType CellAddress to < "
										+ curSheet.getRow(rowindex).getCell(5).getAddress().toString() + " >";
								System.out.println("Error HeatingPumpSystemType CellAddress to < "
										+ curSheet.getRow(rowindex).getCell(5).getAddress().toString() + " >");
							}

							/*
							 * if(valueOfDouble <= -0.0001||valueOfDouble >=
							 * 0.0001)
							 * _model.getInfo().setLightingDensity(valueOfDouble
							 * );
							 */
							curCell = curSheet.getRow(rowindex).getCell(9);
							valueOfDouble = (double) getCellValue(curCell);
							if (valueOfDouble <= -0.0001 || valueOfDouble >= 0.0001) 
								_model.getInfo().setHeatingVolumn(valueOfDouble);
							

							curCell = curSheet.getRow(rowindex).getCell(14);
							valueOfDouble = (double) getCellValue(curCell);
							if (valueOfDouble <= -0.0001 || valueOfDouble >= 0.0001) 
								_model.getInfo().setHeatingEfficiency(valueOfDouble);
							

							curCell = curSheet.getRow(rowindex).getCell(19);
							valueOfString = (String) getCellValue(curCell);

							if (valueOfString.equals("보일러")) 
								_model.getInfo().setHeatingPumpSystemType(HeatingPumpSystemType.보일러);
							 else if (valueOfString.equals("지역난방")) 
								_model.getInfo().setHeatingPumpSystemType(HeatingPumpSystemType.지역난방);
							 else if (valueOfString.equals("EHP")) 
								_model.getInfo().setHeatingPumpSystemType(HeatingPumpSystemType.EHP);
							 else {
								errorMsg += "\nError HeatingSystemType CellAddress to < "
										+ curSheet.getRow(rowindex).getCell(5).getAddress().toString() + " >";
								System.out.println("Error HeatingPumpSystemType CellAddress to < "
										+ curSheet.getRow(rowindex).getCell(5).getAddress().toString() + " >");
							}

							curCell = curSheet.getRow(rowindex).getCell(23);
							valueOfDouble = (double) getCellValue(curCell);
							if (valueOfDouble <= -0.0001 || valueOfDouble >= 0.0001) 
								_model.getInfo().setHeatingPumpVolumn(valueOfDouble);
							

							curCell = curSheet.getRow(rowindex).getCell(28);
							valueOfDouble = (double) getCellValue(curCell);
							if (valueOfDouble <= -0.0001 || valueOfDouble >= 0.0001) 
								_model.getInfo().setHeatingPumpEfficiency(valueOfDouble);
							

							// _model.getInfo().printHVACTest();
						}

						if (rowindex == 53) {

							curCell = curSheet.getRow(rowindex).getCell(5);
							valueOfString = (String) getCellValue(curCell);

							if (valueOfString.equals("압축식")) 
								_model.getInfo().setCoolingSystemType(CoolingSystemType.압축식);
							 else if (valueOfString.equals("흡수식")) 
								_model.getInfo().setCoolingSystemType(CoolingSystemType.흡수식);
							 else if (valueOfString.equals("EHP")) 
								_model.getInfo().setCoolingSystemType(CoolingSystemType.EHP);
							 else {
								errorMsg += "\nError HeatingSystemType CellAddress to < "
										+ curSheet.getRow(rowindex).getCell(5).getAddress().toString() + " >";
								System.out.println("Error HeatingPumpSystemType CellAddress to < "
										+ curSheet.getRow(rowindex).getCell(5).getAddress().toString() + " >");
							}

							curCell = curSheet.getRow(rowindex).getCell(14);
							valueOfDouble = (double) getCellValue(curCell);

							if (valueOfDouble <= -0.0001 || valueOfDouble >= 0.0001) {
								_model.getInfo().setCoolingVolumn(valueOfDouble);
							}
						}
					}
					check = true;
		} catch (ClassCastException e) {
			// 에러창 표시
			check = false;
			errorMsg += "\n" + e.getMessage();
			e.printStackTrace();
		} catch (Exception e) {
			check = false;
			errorMsg += "\n" + e.getMessage();
			e.printStackTrace();
		}

		if (!errorMsg.isEmpty())
			JOptionPane.showMessageDialog(null, errorMsg, "Error : ReadHVAC", JOptionPane.INFORMATION_MESSAGE);

		return check;
	}

	public Object getCellValue(Cell cellData) {

		Object value = null;

		try {
			switch (cellData.getCellType()) {

			case Cell.CELL_TYPE_NUMERIC:
				value = cellData.getNumericCellValue();
				// System.out.println(value);
				break;
			case Cell.CELL_TYPE_STRING:
				value = cellData.getStringCellValue();
				// System.out.println(value);
				break;
			case Cell.CELL_TYPE_FORMULA:
				errorMsg += "\nError CELL_TYPE_FORMULA CellAddress to < " + cellData.getAddress().toString() + " >";
				System.out
						.println("Error CELL_TYPE_FORMULA CellAddress to < " + cellData.getAddress().toString() + " >");
				break;
			case Cell.CELL_TYPE_ERROR:
				errorMsg += "Error CELL_TYPE_ERROR CellAddress to < " + cellData.getAddress().toString() + " >";
				System.out.println("Error CELL_TYPE_ERROR CellAddress to < " + cellData.getAddress().toString() + " >");
				break;
			default:
				errorMsg += "Error value in other type CellAddress to < " + cellData.getAddress().toString() + " >";
				System.out.println(
						"Error value in other type CellAddress to < " + cellData.getAddress().toString() + " >");
				break;
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "\ncellData is missing.", "Error : ReadHVAC",
					JOptionPane.INFORMATION_MESSAGE);
		}

		return value;
	}
}
