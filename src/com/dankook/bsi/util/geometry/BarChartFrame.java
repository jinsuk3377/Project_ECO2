package com.dankook.bsi.util.geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

import com.dankook.bsi.model.Ui_Model;

/**
 * A simple demonstration application showing how to create a dual axis chart based on data
 * from two {@link CategoryDataset} instances.
 *
 */
public class BarChartFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Ui_Model _model;
	private JTabbedPane tabbedPane;
	private PaneTab1 paneTab1;
	private PaneTab2 paneTab2;
	private PaneTab3 paneTab3;
	private PaneTab4 paneTab4;
	private PaneTab5 paneTab5;
	
	/**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    public BarChartFrame (Ui_Model model) {

    	_model = model;
    	
    	paneTab1 = new PaneTab1();
    	paneTab2 = new PaneTab2();
    	paneTab3 = new PaneTab3();
    	paneTab4 = new PaneTab4();
    	paneTab5 = new PaneTab5();
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JTabbedPane tabbedPane = new JTabbedPane();
    	tabbedPane.add("에너지요구량", paneTab1.createPane_tab1());
    	tabbedPane.add("1차에너지소요량", paneTab2.createPane_tab2());
    	tabbedPane.add("난방소요량", paneTab3.createPane_tab3());
    	tabbedPane.add("냉방소요량", paneTab4.createPane_tab4());
    	tabbedPane.add("급탕소요량", paneTab5.createPane_tab5());
    	add(tabbedPane, BorderLayout.CENTER);
    }


}
