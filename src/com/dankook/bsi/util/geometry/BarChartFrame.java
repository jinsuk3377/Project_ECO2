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
	/**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    public BarChartFrame (Ui_Model model) {

    	_model = model;
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JTabbedPane tabbedPane = new JTabbedPane();
    	tabbedPane.add("result1", createPane_tab1());
    	tabbedPane.add("result2", createPane_tab2());
    	add(tabbedPane, BorderLayout.CENTER);
    }

    private ChartPanel createPane_tab1() {
    	
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
//        chart.getLegend().setAnchor(Legend.SOUTH);

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
    
    private ChartPanel createPane_tab2() {
    	
    	final CategoryDataset dataset = createDataset_tab2_1();
        final JFreeChart chart = createChart_tab2(dataset);
    	
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

    /**
     * Creates a sample dataset.
     *
     * @return  The dataset.
     */
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
    
    
    private CategoryDataset createDataset_tab2_1() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        result.addValue(11.2, "warm", "Jan");
        result.addValue(8.3, "warm", "Feb");
        result.addValue(5.7, "warm", "Mar");
        result.addValue(1.8, "warm", "Apr");
        result.addValue(0.3, "warm", "May");
        result.addValue(0.0, "warm", "Jun");
        result.addValue(0.0, "warm", "Jul");
        result.addValue(0.0, "warm", "Aug");
        result.addValue(0.0, "warm", "Sep");
        result.addValue(1.2, "warm", "Oct");
        result.addValue(5.5, "warm", "Nov");
        result.addValue(9.8, "warm", "Dec");
        // 난방에너지요구량
        result.addValue(2.0, "cool", "Jan");
        result.addValue(2.5, "cool", "Feb");
        result.addValue(3.5, "cool", "Mar");
        result.addValue(4.6, "cool", "Apr");
        result.addValue(5.0, "cool", "May");
        result.addValue(6.9, "cool", "Jun");
        result.addValue(8.3, "cool", "Jul");
        result.addValue(9.0, "cool", "Aug");
        result.addValue(6.6, "cool", "Sep");
        result.addValue(4.5, "cool", "Oct");
        result.addValue(2.6, "cool", "Nov");
        result.addValue(2.1, "cool", "Dec");
        //냉방에너지요구량
        result.addValue(1.3, "fast", "Jan");
        result.addValue(1.2, "fast", "Feb");
        result.addValue(1.4, "fast", "Mar");
        result.addValue(1.3, "fast", "Apr");
        result.addValue(1.3, "fast", "May");
        result.addValue(1.3, "fast", "Jun");
        result.addValue(1.4, "fast", "Jul");
        result.addValue(1.3, "fast", "Aug");
        result.addValue(1.3, "fast", "Sep");
        result.addValue(1.3, "fast", "Oct");
        result.addValue(1.3, "fast", "Nov");
        result.addValue(1.4, "fast", "Dec");
        // 급탕에너지요구량
        result.addValue(4.2, "light", "Jan");
        result.addValue(3.9, "light", "Feb");
        result.addValue(4.4, "light", "Mar");
        result.addValue(4.2, "light", "Apr");
        result.addValue(4.2, "light", "May");
        result.addValue(4.2, "light", "Jun");
        result.addValue(4.4, "light", "Jul");
        result.addValue(4.2, "light", "Aug");
        result.addValue(4.2, "light", "Sep");
        result.addValue(4.2, "light", "Oct");
        result.addValue(4.2, "light", "Nov");
        result.addValue(4.4, "light", "Dec");
        // 조명에너지요구량
        return result;
    }
 
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset for the chart.
     * 
     * @return A sample chart.
     */
    
    private JFreeChart createChart_tab2(final CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createStackedBarChart(
            "에너지 요구량",  // chart title
            "Category",                  // domain axis label
            "Value",                     // range axis label
            dataset,                     // data
            PlotOrientation.HORIZONTAL,    // the plot orientation
            true,                        // legend
            true,                        // tooltips
            false                        // urls
        );
        // 차트 제목 한글 깨짐
        chart.getTitle().setFont(new Font("돋움", Font.BOLD, 15));
        chart.getLegend().setItemFont(new Font("돋움", Font.PLAIN, 10));
 
        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");
        map.mapKeyToGroup("warm", "G1");
        map.mapKeyToGroup("warm", "G1");
        map.mapKeyToGroup("warm", "G1");
        map.mapKeyToGroup("warm", "G1");
        map.mapKeyToGroup("cool", "G2");
        map.mapKeyToGroup("cool", "G2");
        map.mapKeyToGroup("cool", "G2");
        map.mapKeyToGroup("cool", "G2");
        map.mapKeyToGroup("fast", "G3");
        map.mapKeyToGroup("fast", "G3");
        map.mapKeyToGroup("fast", "G3");
        map.mapKeyToGroup("fast", "G3");
        renderer.setSeriesToGroupMap(map); 
 
        renderer.setItemMargin(0.0);
        Paint p1 = new GradientPaint(
            0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f, new Color(0x88, 0x88, 0xFF)
        );
        renderer.setSeriesPaint(0, p1);
        renderer.setSeriesPaint(4, p1);
        renderer.setSeriesPaint(8, p1);
 
        Paint p2 = new GradientPaint(
            0.0f, 0.0f, new Color(0x22, 0xFF, 0x22), 0.0f, 0.0f, new Color(0x88, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(1, p2); 
        renderer.setSeriesPaint(5, p2); 
        renderer.setSeriesPaint(9, p2); 
 
        Paint p3 = new GradientPaint(
            0.0f, 0.0f, new Color(0xFF, 0x22, 0x22), 0.0f, 0.0f, new Color(0xFF, 0x88, 0x88)
        );
        renderer.setSeriesPaint(2, p3);
        renderer.setSeriesPaint(6, p3);
        renderer.setSeriesPaint(10, p3);
 
        Paint p4 = new GradientPaint(
            0.0f, 0.0f, new Color(0xFF, 0xFF, 0x22), 0.0f, 0.0f, new Color(0xFF, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(3, p4);
        renderer.setSeriesPaint(7, p4);
        renderer.setSeriesPaint(11, p4);
        renderer.setGradientPaintTransformer(
            new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL)
        );
 
        SubCategoryAxis domainAxis = new SubCategoryAxis("에너지 요구량");
        domainAxis.setCategoryMargin(0.05);
        domainAxis.addSubCategory("warm");
        domainAxis.addSubCategory("cool");
        domainAxis.addSubCategory("fast");
 
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        //plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        return chart;
 
    }
    
    private LegendItemCollection createLegendItems() {
        LegendItemCollection result = new LegendItemCollection();
        return result;
    }
}
