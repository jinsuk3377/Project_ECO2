package com.dankook.bsi.util.geometry;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.io.UnsupportedEncodingException;

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
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.dankook.bsi.model.Ui_Model;

public class PaneTab4 {

	private Ui_Model _model;

	public PaneTab4(Ui_Model model) {
		_model = model;
	}

	@SuppressWarnings("serial")
	public ChartPanel createPane_tab4() throws UnsupportedEncodingException {

		final CategoryDataset dataset = createDataset_tab4();

		// create the chart...
		final JFreeChart chart = ChartFactory.createBarChart(
				"설비기기별 냉방에너지요구량", // chart title
				"MONTH", // domain axis label
				"kW/h", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips?
				false // URL generator? Not required...
		);

		chart.getTitle().setFont(new Font("돋움", Font.BOLD, 16));
		chart.getLegend().setItemFont(new Font("돋움", Font.PLAIN, 10));
		chart.setBackgroundPaint(Color.white);
		
		final CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);

     // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, new Color(0, 0, 64)
        );
        GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, new Color(0, 64, 0)
        );
        GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, new Color(64, 0, 0)
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );

		return new ChartPanel(chart) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(1000, 700);
			}
		};
	}

	private CategoryDataset createDataset_tab4() throws UnsupportedEncodingException {

		// row keys...
		final String[] type = { "전기", "가스", "지역난방" };

		// column keys...
		final String[] series = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < 12; i++) {
			dataset.addValue(_model.getInfo().getQ_c_f_elec()[i+1], type[0], series[i]);
			dataset.addValue(_model.getInfo().getQ_c_f_gas()[i+1], type[1], series[i]);
			dataset.addValue(_model.getInfo().getQ_c_f_local()[i+1], type[2], series[i]);
		}

		return dataset;
	}
}
