package com.dankook.bsi.util.geometry;


import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;
/**
 * A simple demonstration application showing how to create a stacked bar chart
 * using data from a {@link CategoryDataset}.
 */
public class BarChartDemo3 extends ApplicationFrame {
    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public BarChartDemo3(final String title) {
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(590, 350));
        setContentPane(chartPanel);
    }
 
    /**
     * Creates a sample dataset.
     * 
     * @return A sample dataset.
     */
    private CategoryDataset createDataset() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        result.addValue(14.6, "warm_fir", "Jan");
        result.addValue(10.9, "warm_fir", "Feb");
        result.addValue(7.4, "warm_fir", "Mar");
        result.addValue(2.4, "warm_fir", "Apr");
        result.addValue(0.4, "warm_fir", "May");
        result.addValue(0.0, "warm_fir", "Jun");
        result.addValue(0.0, "warm_fir", "Jul");
        result.addValue(0.0, "warm_fir", "Aug");
        result.addValue(0.0, "warm_fir", "Sep");
        result.addValue(1.6, "warm_fir", "Oct");
        result.addValue(7.1, "warm_fir", "Nov");
        result.addValue(12.8, "warm_fir", "Dec");
        // 난방1차에너지소요량 
        result.addValue(2.1, "cool_fir", "Jan");
        result.addValue(2.6, "cool_fir", "Feb");
        result.addValue(3.6, "cool_fir", "Mar");
        result.addValue(4.8, "cool_fir", "Apr");
        result.addValue(5.3, "cool_fir", "May");
        result.addValue(7.2, "cool_fir", "Jun");
        result.addValue(8.7, "cool_fir", "Jul");
        result.addValue(9.5, "cool_fir", "Aug");
        result.addValue(6.9, "cool_fir", "Sep");
        result.addValue(4.7, "cool_fir", "Oct");
        result.addValue(2.7, "cool_fir", "Nov");
        result.addValue(2.2, "cool_fir", "Dec");
        // 냉방1차에너지소요량
        result.addValue(3.0, "fast_fir", "Jan");
        result.addValue(2.7, "fast_fir", "Feb");
        result.addValue(3.1, "fast_fir", "Mar");
        result.addValue(3.0, "fast_fir", "Apr");
        result.addValue(3.0, "fast_fir", "May");
        result.addValue(3.0, "fast_fir", "Jun");
        result.addValue(3.1, "fast_fir", "Jul");
        result.addValue(3.0, "fast_fir", "Aug");
        result.addValue(3.0, "fast_fir", "Sep");
        result.addValue(3.0, "fast_fir", "Oct");
        result.addValue(3.0, "fast_fir", "Nov");
        result.addValue(3.1, "fast_fir", "Dec");
        // 급탕1차에너지소요량
        result.addValue(11.7, "light_fir", "Jan");
        result.addValue(10.6, "light_fir", "Feb");
        result.addValue(12.2, "light_fir", "Mar");
        result.addValue(11.7, "light_fir", "Apr");
        result.addValue(11.7, "light_fir", "May");
        result.addValue(11.7, "light_fir", "Jun");
        result.addValue(12.2, "light_fir", "Jul");
        result.addValue(11.7, "light_fir", "Aug");
        result.addValue(11.7, "light_fir", "Sep");
        result.addValue(11.7, "light_fir", "Oct");
        result.addValue(11.7, "light_fir", "Nov");
        result.addValue(12.2, "light_fir", "Dec");
        // 조명1차에너지소요량
        result.addValue(1.6, "ref_fir", "Jan");
        result.addValue(2.0, "ref_fir", "Feb");
        result.addValue(2.8, "ref_fir", "Mar");
        result.addValue(3.7, "ref_fir", "Apr");
        result.addValue(4.0, "ref_fir", "May");
        result.addValue(5.5, "ref_fir", "Jun");
        result.addValue(6.7, "ref_fir", "Jul");
        result.addValue(7.3, "ref_fir", "Aug");
        result.addValue(5.3, "ref_fir", "Sep");
        result.addValue(3.6, "ref_fir", "Oct");
        result.addValue(2.1, "ref_fir", "Nov");
        result.addValue(1.7, "ref_fir", "Dec");
        // 환기1차에너지소요량
      
        return result;
    }
 
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset for the chart.
     * 
     * @return A sample chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createStackedBarChart(
            "1차 에너지 소요량",  // chart title
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
 
        SubCategoryAxis domainAxis = new SubCategoryAxis("1차 에너지 소요량");	// 1차 에너지 소요량
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
    /**
     * Creates the legend items for the chart.  In this case, we set them manually because we
     * only want legend items for a subset of the data series.
     * 
     * @return The legend items.
     */
    private LegendItemCollection createLegendItems() {
        LegendItemCollection result = new LegendItemCollection();
//        LegendItem item1 = new LegendItem("US", new Color(0x22, 0x22, 0xFF));
  //      LegendItem item2 = new LegendItem("Europe", new Color(0x22, 0xFF, 0x22));
    //    LegendItem item3 = new LegendItem("Asia", new Color(0xFF, 0x22, 0x22));
      //  LegendItem item4 = new LegendItem("Middle East", new Color(0xFF, 0xFF, 0x22));
//        result.add(item1);
  //      result.add(item2);
    //    result.add(item3);
      //  result.add(item4);
        return result;
    }
 
    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.ru/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
 
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
 

	public void start() {
		final BarChartDemo3 demo = new BarChartDemo3("에너지 그래프");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
		
	}
}
