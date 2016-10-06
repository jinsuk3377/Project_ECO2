package com.dankook.bsi.util.geometry;

import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class PaneTab3 {

	   public ChartPanel createPane_tab3() {
	    	
	        final CategoryDataset dataset1 = createDataset_tab1_1();

	        // create the chart...
	        final JFreeChart chart = ChartFactory.createBarChart(
	            "에너지 요구량",        // chart title
	            "월 별",               // domain axis label
	            "에너지 요구량",                  // range axis label
	            dataset1,                 // data
	            PlotOrientation.VERTICAL,
	            true,                     // include legend
	            true,                     // tooltips?
	            false                     // URL generator?  Not required...
	        );

	        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
	        chart.setBackgroundPaint(Color.white);
//	        chart.getLegend().setAnchor(Legend.SOUTH);

	        // get a reference to the plot for further customisation...
	        final CategoryPlot plot = chart.getCategoryPlot();
	        plot.setRangeGridlinePaint(Color.orange);
	        plot.setBackgroundPaint(new Color(0xEE, 0xEE, 0xFF));
	        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

	        final CategoryDataset dataset2 = createDataset_tab1_2();
	        plot.setDataset(1, dataset2);
	        plot.mapDatasetToRangeAxis(1, 1);

	        final CategoryAxis domainAxis = plot.getDomainAxis();
	        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
	        final ValueAxis axis2 = new NumberAxis("Secondary");
	        plot.setRangeAxis(1, axis2);

	        final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
	        renderer2.setToolTipGenerator(new StandardCategoryToolTipGenerator());
	        plot.setRenderer(1, renderer2);
	        plot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);
	        // OPTIONAL CUSTOMISATION COMPLETED.

	        // add the chart to a panel...
	        //final ChartPanel chartPanel = new ChartPanel(chart);
	        //chartPanel.setPreferredSize(new java.awt.Dimension(1000, 700));
	        //setContentPane(chartPanel);
	        
	        return new ChartPanel(chart) {
	            @Override
	            public Dimension getPreferredSize() {
	                return new Dimension(1000, 700);
	            }
	        };
	    }

	    private CategoryDataset createDataset_tab1_1() {

	        // row keys...
	        final String series1 = "난방에너지요구량";
	        final String series2 = "냉방에너지요구량";
	        final String series3 = "급탕에너지요구량";

	        // column keys...
	        
	        final String category1 = "1월";
	        final String category2 = "2월";
	        final String category3 = "3월";
	        final String category4 = "4월";
	        final String category5 = "5월";
	        final String category6 = "6월";
	        final String category7 = "7월";
	        final String category8 = "8월";
	        final String category9 = "9월";
	        final String category10 = "10월";
	        final String category11 = "11월";
	        final String category12 = "12월";
	         
	        // create the dataset...
	        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        
	        //dataset.addValue(_model.getInfo().getQ_h_b(), series1, category1);
	        dataset.addValue(4.0, series1, category2);
	        dataset.addValue(3.0, series1, category3);
	        dataset.addValue(5.0, series1, category4);
	        dataset.addValue(5.0, series1, category5);
	        dataset.addValue(7.0, series1, category6);
	        dataset.addValue(7.0, series1, category7);
	        dataset.addValue(8.0, series1, category8);
	        dataset.addValue(8.0, series1, category9);
	        dataset.addValue(8.0, series1, category10);
	        dataset.addValue(8.0, series1, category11);
	        dataset.addValue(8.0, series1, category12);
	        // 난방 에너지 요구량
	        dataset.addValue(5.0, series2, category1);
	        dataset.addValue(7.0, series2, category2);
	        dataset.addValue(6.0, series2, category3);
	        dataset.addValue(8.0, series2, category4);
	        dataset.addValue(4.0, series2, category5);
	        dataset.addValue(4.0, series2, category6);
	        dataset.addValue(2.0, series2, category7);
	        dataset.addValue(1.0, series2, category8);

	        dataset.addValue(4.0, series3, category1);
	        dataset.addValue(3.0, series3, category2);
	        dataset.addValue(2.0, series3, category3);
	        dataset.addValue(3.0, series3, category4);
	        dataset.addValue(6.0, series3, category5);
	        dataset.addValue(3.0, series3, category6);
	        dataset.addValue(4.0, series3, category7);
	        dataset.addValue(3.0, series3, category8);

	        return dataset;

	    }
	    
	    private CategoryDataset createDataset_tab1_2() {

	        // row keys...
	        final String series1 = "Fourth";

	        // column keys...
	        final String category1 = "Category 1";
	        final String category2 = "Category 2";
	        final String category3 = "Category 3";
	        final String category4 = "Category 4";
	        final String category5 = "Category 5";
	        final String category6 = "Category 6";
	        final String category7 = "Category 7";
	        final String category8 = "Category 8";

	        // create the dataset...
	        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	        dataset.addValue(15.0, series1, category1);
	        dataset.addValue(24.0, series1, category2);
	        dataset.addValue(31.0, series1, category3);
	        dataset.addValue(25.0, series1, category4);
	        dataset.addValue(56.0, series1, category5);
	        dataset.addValue(37.0, series1, category6);
	        dataset.addValue(77.0, series1, category7);
	        dataset.addValue(18.0, series1, category8);

	        return dataset;

	    }
}
