package com.dankook.bsi.util.geometry;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.UnsupportedEncodingException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.dankook.bsi.model.Ui_Model;

//에너지요구량
public class PaneTab1 {

	private Ui_Model _model;

	public PaneTab1(Ui_Model model) {
		_model = model;
	}

	@SuppressWarnings("serial")
	public ChartPanel createPane_tab1() throws UnsupportedEncodingException {

		final CategoryDataset dataset = createDataset_tab1();

		// create the chart...
		final JFreeChart chart = ChartFactory.createLineChart(
				"월별 에너지 요구량", // chart title
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

		final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();

		renderer.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 10.0f, 6.0f }, 0.0f));
		renderer.setSeriesStroke(1, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 6.0f, 6.0f }, 0.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 2.0f, 6.0f }, 0.0f));
		renderer.setSeriesStroke(3, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 4.0f, 6.0f }, 0.0f));
		renderer.setSeriesStroke(4, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 8.0f, 6.0f }, 0.0f));

		return new ChartPanel(chart) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(1000, 700);
			}
		};
	}

	private CategoryDataset createDataset_tab1() throws UnsupportedEncodingException {

		// row keys...
		final String[] type = { "난방에너지요구량", "냉방에너지요구량", "급탕에너지요구량", "조명에너지요구량", "환기에너지요구량" };

		// column keys...
		final String[] series = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 1; i < 13; i++) {
			dataset.addValue(_model.getInfo().getQ_h_b()[i], type[0], series[i-1]);
			dataset.addValue(_model.getInfo().getQ_c_b()[i], type[1], series[i-1]);
			dataset.addValue(_model.getInfo().getQ_w_b()[i], type[2], series[i-1]);
			dataset.addValue(_model.getInfo().getQ_l_b()[i], type[3], series[i-1]);
			dataset.addValue(_model.getInfo().getQ_v_b()[i], type[4], series[i-1]);
		}

		return dataset;
	}
}
