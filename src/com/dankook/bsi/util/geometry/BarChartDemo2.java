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
public class BarChartDemo2 extends ApplicationFrame {
    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public BarChartDemo2(final String title) {
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
        result.addValue(1.5, "warm_elec", "Jan");
        result.addValue(1.1, "warm_elec", "Feb");
        result.addValue(0.7, "warm_elec", "Mar");
        result.addValue(0.2, "warm_elec", "Apr");
        result.addValue(0.0, "warm_elec", "May");
        result.addValue(0.0, "warm_elec", "Jun");
        result.addValue(0.0, "warm_elec", "Jul");
        result.addValue(0.0, "warm_elec", "Aug");
        result.addValue(0.0, "warm_elec", "Sep");
        result.addValue(0.2, "warm_elec", "Oct");
        result.addValue(0.7, "warm_elec", "Nov");
        result.addValue(1.3, "warm_elec", "Dec");
        // 난방에너지소요량 - 전기
        result.addValue(0.0, "warm_gas", "Jan");
        result.addValue(0.0, "warm_gas", "Feb");
        result.addValue(0.0, "warm_gas", "Mar");
        result.addValue(0.0, "warm_gas", "Apr");
        result.addValue(0.0, "warm_gas", "May");
        result.addValue(0.0, "warm_gas", "Jun");
        result.addValue(0.0, "warm_gas", "Jul");
        result.addValue(0.0, "warm_gas", "Aug");
        result.addValue(0.0, "warm_gas", "Sep");
        result.addValue(0.0, "warm_gas", "Oct");
        result.addValue(0.0, "warm_gas", "Nov");
        result.addValue(0.0, "warm_gas", "Dec");
        // 난방에너지소요량 - 가스
        result.addValue(14.5, "warm_reg", "Jan");
        result.addValue(10.8, "warm_reg", "Feb");
        result.addValue(7.4, "warm_reg", "Mar");
        result.addValue(2.4, "warm_reg", "Apr");
        result.addValue(0.4, "warm_reg", "May");
        result.addValue(0.0, "warm_reg", "Jun");
        result.addValue(0.0, "warm_reg", "Jul");
        result.addValue(0.0, "warm_reg", "Aug");
        result.addValue(0.0, "warm_reg", "Sep");
        result.addValue(1.6, "warm_reg", "Oct");
        result.addValue(7.1, "warm_reg", "Nov");
        result.addValue(12.8, "warm_reg", "Dec");
        // 난방에너지소요량 - 지역난방
        // ************************************
        result.addValue(0.8, "cool_elec", "Jan");
        result.addValue(1.0, "cool_elec", "Feb");
        result.addValue(1.3, "cool_elec", "Mar");
        result.addValue(1.8, "cool_elec", "Apr");
        result.addValue(1.9, "cool_elec", "May");
        result.addValue(2.6, "cool_elec", "Jun");
        result.addValue(3.2, "cool_elec", "Jul");
        result.addValue(3.4, "cool_elec", "Aug");
        result.addValue(2.5, "cool_elec", "Sep");
        result.addValue(1.7, "cool_elec", "Oct");
        result.addValue(1.0, "cool_elec", "Nov");
        result.addValue(0.8, "cool_elec", "Dec");
        // 냉방에너지소요량 - 전기
        result.addValue(0.0, "cool_gas", "Jan");
        result.addValue(0.0, "cool_gas", "Feb");
        result.addValue(0.0, "cool_gas", "Mar");
        result.addValue(0.0, "cool_gas", "Apr");
        result.addValue(0.0, "cool_gas", "May");
        result.addValue(0.0, "cool_gas", "Jun");
        result.addValue(0.0, "cool_gas", "Jul");
        result.addValue(0.0, "cool_gas", "Aug");
        result.addValue(0.0, "cool_gas", "Sep");
        result.addValue(0.0, "cool_gas", "Oct");
        result.addValue(0.0, "cool_gas", "Nov");
        result.addValue(0.0, "cool_gas", "Dec");
        // 냉방에너지소요량 - 가스
        result.addValue(0.0, "cool_reg", "Jan");
        result.addValue(0.0, "cool_reg", "Feb");
        result.addValue(0.0, "cool_reg", "Mar");
        result.addValue(0.0, "cool_reg", "Apr");
        result.addValue(0.0, "cool_reg", "May");
        result.addValue(0.0, "cool_reg", "Jun");
        result.addValue(0.0, "cool_reg", "Jul");
        result.addValue(0.0, "cool_reg", "Aug");
        result.addValue(0.0, "cool_reg", "Sep");
        result.addValue(0.0, "cool_reg", "Oct");
        result.addValue(0.0, "cool_reg", "Nov");
        result.addValue(0.0, "cool_reg", "Dec");
        // 냉방에너지소요량 - 지역난방
        //*************************************
        result.addValue(0.2, "fast_elec", "Jan");
        result.addValue(0.2, "fast_elec", "Feb");
        result.addValue(0.2, "fast_elec", "Mar");
        result.addValue(0.2, "fast_elec", "Apr");
        result.addValue(0.2, "fast_elec", "May");
        result.addValue(0.2, "fast_elec", "Jun");
        result.addValue(0.2, "fast_elec", "Jul");
        result.addValue(0.2, "fast_elec", "Aug");
        result.addValue(0.2, "fast_elec", "Sep");
        result.addValue(0.2, "fast_elec", "Oct");
        result.addValue(0.2, "fast_elec", "Nov");
        result.addValue(0.2, "fast_elec", "Dec");
        // 급탕에너지소요량 - 전기
        result.addValue(2.2, "fast_gas", "Jan");
        result.addValue(2.0, "fast_gas", "Feb");
        result.addValue(2.3, "fast_gas", "Mar");
        result.addValue(2.2, "fast_gas", "Apr");
        result.addValue(2.2, "fast_gas", "May");
        result.addValue(2.2, "fast_gas", "Jun");
        result.addValue(2.3, "fast_gas", "Jul");
        result.addValue(2.2, "fast_gas", "Aug");
        result.addValue(2.2, "fast_gas", "Sep");
        result.addValue(2.2, "fast_gas", "Oct");
        result.addValue(2.2, "fast_gas", "Nov");
        result.addValue(2.3, "fast_gas", "Dec");
        // 급탕에너지소요량 - 가스
        result.addValue(0.0, "fast_reg", "Jan");
        result.addValue(0.0, "fast_reg", "Feb");
        result.addValue(0.0, "fast_reg", "Mar");
        result.addValue(0.0, "fast_reg", "Apr");
        result.addValue(0.0, "fast_reg", "May");
        result.addValue(0.0, "fast_reg", "Jun");
        result.addValue(0.0, "fast_reg", "Jul");
        result.addValue(0.0, "fast_reg", "Aug");
        result.addValue(0.0, "fast_reg", "Sep");
        result.addValue(0.0, "fast_reg", "Oct");
        result.addValue(0.0, "fast_reg", "Nov");
        result.addValue(0.0, "fast_reg", "Dec");
        // 급탕에너지소요량 - 지역난방
        //***********************************
        result.addValue(0.0, "light_ene", "Jan");
        result.addValue(0.0, "light_ene", "Feb");
        result.addValue(0.0, "light_ene", "Mar");
        result.addValue(0.0, "light_ene", "Apr");
        result.addValue(0.0, "light_ene", "May");
        result.addValue(0.0, "light_ene", "Jun");
        result.addValue(0.0, "light_ene", "Jul");
        result.addValue(0.0, "light_ene", "Aug");
        result.addValue(0.0, "light_ene", "Sep");
        result.addValue(0.0, "light_ene", "Oct");
        result.addValue(0.0, "light_ene", "Nov");
        result.addValue(0.0, "light_ene", "Dec");
        // 조명에너지소요량 
        result.addValue(0.6, "ref_ene", "Jan");
        result.addValue(0.7, "ref_ene", "Feb");
        result.addValue(1.0, "ref_ene", "Mar");
        result.addValue(1.3, "ref_ene", "Apr");
        result.addValue(1.5, "ref_ene", "May");
        result.addValue(2.0, "ref_ene", "Jun");
        result.addValue(2.4, "ref_ene", "Jul");
        result.addValue(2.6, "ref_ene", "Aug");
        result.addValue(1.9, "ref_ene", "Sep");
        result.addValue(1.3, "ref_ene", "Oct");
        result.addValue(0.8, "ref_ene", "Nov");
        result.addValue(0.6, "ref_ene", "Dec");
       // 환기에너지소요량
        
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
            "에너지 소요량",  // chart title
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
 
        SubCategoryAxis domainAxis = new SubCategoryAxis("에너지 소요량");
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
		final BarChartDemo2 demo = new BarChartDemo2("에너지 그래프");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
		
	}
}
