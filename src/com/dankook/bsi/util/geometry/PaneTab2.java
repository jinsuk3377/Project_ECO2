package com.dankook.bsi.util.geometry;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.io.UnsupportedEncodingException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

import com.dankook.bsi.model.Ui_Model;

public class PaneTab2 {

	private Ui_Model _model;

	public PaneTab2(Ui_Model model) {
		_model = model;
	}

	@SuppressWarnings("serial")
	public ChartPanel createPane_tab2() throws UnsupportedEncodingException {

		final CategoryDataset dataset = createDataset_tab2();

		// create the chart...
		final JFreeChart chart = ChartFactory.createLineChart(
				"월별 1차 에너지 소모량", // chart title
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

	private CategoryDataset createDataset_tab2() throws UnsupportedEncodingException {

		// row keys...
		final String[] type = { "난방에너지요구량", "냉방에너지요구량", "급탕에너지요구량", "조명에너지요구량", "환기에너지요구량" };

		// column keys...
		final String[] series = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < 12; i++) {
			dataset.addValue(_model.getInfo().getQ_h_1()[i], type[0], series[i]);
			dataset.addValue(_model.getInfo().getQ_c_1()[i], type[1], series[i]);
			dataset.addValue(_model.getInfo().getQ_w_1()[i], type[2], series[i]);
			dataset.addValue(_model.getInfo().getQ_l_1()[i], type[3], series[i]);
			dataset.addValue(_model.getInfo().getQ_v_1()[i], type[4], series[i]);
		}

		return dataset;
	}
}
