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
import org.jfree.ui.ApplicationFrame;


public class barGraph  
{
//    public Name(String title)
//    {
//        super(title);
//        this.setContentPane(createPanel()); //构造函数中自动创建Java的panel面板
//    }
    
    public static CategoryDataset createDataset() //创建柱状图数据集
    {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        dataset.setValue(600,"COD","饮用水1");
        dataset.setValue(550,"BOD","饮用水1");
        dataset.setValue(600,"TN","饮用水1");
        dataset.setValue(500,"COD","开发区");
        dataset.setValue(700,"BOD","开发区");
        dataset.setValue(980,"TN","开发区");
        dataset.setValue(400,"COD","缓冲区");
        dataset.setValue(715,"BOD","缓冲区");
        dataset.setValue(900,"TN","缓冲区");
        dataset.setValue(900,"COD","饮用水2");
        dataset.setValue(900,"BOD","饮用水2");
        dataset.setValue(900,"TN","饮用水2");
  
        return dataset;
    }
    
    public static JFreeChart createChart(CategoryDataset dataset) //用数据集创建一个图表
    {
        JFreeChart chart=ChartFactory.createBarChart("容量计算柱状图", "水质区域", 
                "污染物浓度", dataset, PlotOrientation.VERTICAL, true, true, false); //创建一个JFreeChart
        chart.setTitle(new TextTitle("容量计算柱状图",new Font("宋体",Font.BOLD+Font.ITALIC,10)));//可以重新设置标题，替换“hi”标题
        CategoryPlot plot=(CategoryPlot)chart.getPlot();//获得图标中间部分，即plot
        CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
        NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();//获取纵坐标
        numberaxis.setLabelFont(new Font("宋体",Font.BOLD,8));
        numberaxis.setTickLabelFont(new Font("宋体",Font.BOLD,8));
        categoryAxis.setLabelFont(new Font("宋体",Font.BOLD,8));//设置横坐标字体
        categoryAxis.setTickLabelFont(new Font("宋体",Font.BOLD,9));
//        categoryAxis.setMaximumCategoryLabelWidthRatio(2f);          //宽度比率
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 8));
        return chart;
    }
    
    public static JPanel createPanel(DefaultCategoryDataset dataset)
    {
        JFreeChart chart =createChart(dataset);
        return new ChartPanel(chart); //将chart对象放入Panel面板中去，ChartPanel类已继承Jpanel
    }
    
}

