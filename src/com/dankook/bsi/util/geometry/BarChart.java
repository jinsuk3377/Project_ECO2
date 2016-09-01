package com.dankook.bsi.util.geometry;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {
	public BarChart() {}
	
	public JFreeChart getChart(){
		
		JFreeChart chart = ChartFactory.createBarChart(getClass().getName(),
				"건축물 상세 정보",
				"값",
				getDataSet(),
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		return chart;
	}

	private DefaultCategoryDataset getDataSet() {
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		String category1 = "난방에너지요구량";
		String category2 = "냉방에너지요구량";
		String category3 = "급탕에너지요구량";
		String category4 = "조명에너지요구량";
		String category5 = "난방에너지소요량";
		String category6 = "급탕에너지소요량";
		String category7 = "조명에너지소요량";
		String category8 = "환기에너지소요량";
		String category9 = "난방1차에너지소요량";
		String category10 = "냉방1차에너지소요량";
		String category11 = "급탕1차에너지소요량";
		String category12 = "조명1차에너지소요량";
		String category13 = "환기1차에너지소요량";
		
		ArrayList<String> months = null;
		for(int i=1; i<=12; i++) {
			months.add(String.valueOf(i)+"월");
		}
		
		String test1 = "1월";
		String test2 = "2월";
		String test3 = "3월";
		String test4 = "4월";
		String test5 = "5월";
		String test6 = "6월";
		String test7 = "7월";
		String test8 = "8월";
		String test9 = "9월";
		String test10 = "10월";
		String test11 = "11월";
		String test12 = "12월";
		dataSet.addValue(11.2, category1, test1);
		dataSet.addValue(8.3, category1, test2);
		dataSet.addValue(5.7, category1, test3);
		dataSet.addValue(1.8, category1, test4);
		dataSet.addValue(0.3, category1, test5);
		dataSet.addValue(0.0, category1, test6);
		dataSet.addValue(0.0, category1, test7);
		dataSet.addValue(0.0, category1, test8);
		dataSet.addValue(0.0, category1, test9);
		dataSet.addValue(1.2, category1, test10);
		dataSet.addValue(5.5, category1, test11);
		dataSet.addValue(9.8, category1, test12);
		// 난방에너지요구량
		dataSet.addValue(2.0, category2, test1);
		dataSet.addValue(2.5, category2, test2);
		dataSet.addValue(3.5, category2, test3);
		dataSet.addValue(4.6, category2, test4);
		dataSet.addValue(5.0, category2, test5);
		dataSet.addValue(6.9, category2, test6);
		dataSet.addValue(8.3, category2, test7);
		dataSet.addValue(9.0, category2, test8);
		dataSet.addValue(6.6, category2, test9);
		dataSet.addValue(4.5, category2, test10);
		dataSet.addValue(2.6, category2, test11);
		dataSet.addValue(2.1, category2, test12);
		// 냉방에너지요구량
		dataSet.addValue(1.3, category3, test1);
		dataSet.addValue(1.2, category3, test2);
		dataSet.addValue(1.4, category3, test3);
		dataSet.addValue(1.3, category3, test4);
		dataSet.addValue(1.3, category3, test5);
		dataSet.addValue(1.3, category3, test6);
		dataSet.addValue(1.4, category3, test7);
		dataSet.addValue(1.3, category3, test8);
		dataSet.addValue(1.3, category3, test9);
		dataSet.addValue(1.3, category3, test10);
		dataSet.addValue(1.3, category3, test11);
		dataSet.addValue(1.4, category3, test12);
		// 급탕에너지요구량
		dataSet.addValue(4.2, category4, test1);
		dataSet.addValue(3.9, category4, test2);
		dataSet.addValue(4.4, category4, test3);
		dataSet.addValue(4.2, category4, test4);
		dataSet.addValue(4.2, category4, test5);
		dataSet.addValue(4.2, category4, test6);
		dataSet.addValue(4.4, category4, test7);
		dataSet.addValue(4.2, category4, test8);
		dataSet.addValue(4.2, category4, test9);
		dataSet.addValue(4.2, category4, test10);
		dataSet.addValue(4.2, category4, test11);
		dataSet.addValue(4.4, category4, test12);
		
		
		return dataSet;
	}

	public static void main(String[] args) {
		

	}

}
