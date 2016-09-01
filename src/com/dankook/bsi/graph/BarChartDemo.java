package com.dankook.bsi.graph;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo {
	public BarChartDemo(){}
	
	public JFreeChart getChart(){
		JFreeChart chart = ChartFactory.createBarChart(getClass().getName(),
				"strutinfo",
				"value",
				getDataSet(),
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		return chart;
	}
	private DefaultCategoryDataset getDataSet() {
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		
		String energy1 = "warmreq";	//난방에너지요구량
		String energy2 = "coolreq";	//냉방에너지요구량
		
		/*
		ArrayList<String> month = null;
		for(int i=1; i<=12; i++)
			month.add(String.valueOf(i)+"월");
		*/
		
		String month1 = "1M";
		String month2 = "2M";
		String month3 = "3M";
		String month4 = "4M";
		String month5 = "5M";
		String month6 = "6M";
		String month7 = "7M";
		String month8 = "8M";
		String month9 = "9M";
		String month10 = "10M";
		String month11 = "11M";
		String month12 = "12M";
		
		dataSet.addValue(11.2, energy1, month1);
		dataSet.addValue(8.3, energy1, month2);
		dataSet.addValue(5.7, energy1, month3);
		dataSet.addValue(1.8, energy1, month4);
		dataSet.addValue(0.3, energy1, month5);
		dataSet.addValue(0.0, energy1, month6);
		dataSet.addValue(0.0, energy1, month7);
		dataSet.addValue(0.0, energy1, month8);
		dataSet.addValue(0.0, energy1, month9);
		dataSet.addValue(1.2, energy1, month10);
		dataSet.addValue(5.5, energy1, month11);
		dataSet.addValue(9.8, energy1, month12);
		// 난방에너지요구량
		
		dataSet.addValue(2.0, energy2, month1);
		dataSet.addValue(2.5, energy2, month2);
		dataSet.addValue(3.5, energy2, month3);
		dataSet.addValue(4.6, energy2, month4);
		dataSet.addValue(5.0, energy2, month5);
		dataSet.addValue(6.9, energy2, month6);
		dataSet.addValue(8.3, energy2, month7);
		dataSet.addValue(9.0, energy2, month8);
		dataSet.addValue(6.6, energy2, month9);
		dataSet.addValue(4.5, energy2, month10);
		dataSet.addValue(2.6, energy2, month11);
		dataSet.addValue(2.1, energy2, month12);
		// 냉방에너지요구량
		
		return dataSet;
	}
	
	public void start() {
		final JFreeChart chart = new BarChartDemo().getChart();
		ChartFrame cf = new ChartFrame("월별 에너지 요구량 및 소요량", chart);
		cf.pack();
		RefineryUtilities.centerFrameOnScreen(cf);
		cf.setSize(800, 600);
		cf.setVisible(true);
	}

	/*
	public static void main(String[] args) {
		final JFreeChart chart = new BarChartDemo().getChart();
		ChartFrame cf = new ChartFrame("월별 에너지 요구량 및 소요량", chart);
		cf.pack();
		RefineryUtilities.centerFrameOnScreen(cf);
		cf.setSize(400, 400);
		cf.setVisible(true);
	}
	*/

}
