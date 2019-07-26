package Util;

import java.awt.Font;

import javax.swing.JPanel;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PiePlot;
import org.jfree.ui.RefineryUtilities;

public class PieCharts{
	
	public static JPanel createDemoPanel(PieDataset piedataset){
		JFreeChart jfreechart = createChart(piedataset);
		return new ChartPanel(jfreechart);
	}
	
	public static JFreeChart createChart(PieDataset piedataset){
		JFreeChart jfreechart = ChartFactory.createPieChart("CityInfoPort公司组织架构图",piedataset,true,true,false);
		PiePlot pieplot = (PiePlot)jfreechart.getPlot();
		pieplot.setLabelFont(new Font("SansSerif",Font.BOLD,12));
		pieplot.setNoDataMessage("No data available");
		pieplot.setCircular(true);
		pieplot.setLabelGap(0.01D);//间距
		return jfreechart;
		
	}
	
}

