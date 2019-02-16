package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class OrderMethodUtil {
	
	public void genetatePieChart(String path,List<Object[]> data) {
		
		// 1) create dataset 
		DefaultPieDataset dataset= new DefaultPieDataset();
		
		for(Object[] d :data) {
			
			
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));
			
		}
		
		// convert data set to  jfreee chart 
		
      JFreeChart jfreechart= ChartFactory.createPieChart3D("order mode data", dataset, true, true,false);
		
		
      //  convert jfree chart to image
      
              try {
				ChartUtilities.saveChartAsJPEG(new File(path +"/resources/images/ompiechart.jpg"), jfreechart, 250, 250);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      
             
              }
	
	public void createBarChart(String path , List<Object[]> data) {
		
		// crate data set
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		
		for(Object[] ob:data) {
			
			
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), " ");
		
		
		
	}
		
		
		// convet data to jfree chart
      
		
		
		JFreeChart jfreechart=ChartFactory.createBarChart("ordermentod bar chart", "ordermode", "count", dataset, PlotOrientation.VERTICAL, true, true, false);
		
		
		
		//save as image
				
				
				try {
					ChartUtilities.saveChartAsJPEG(new File(path+"/resources/images/ombarchart.jpg"), jfreechart, 250, 250);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
	}
	



	  
	  
	  
	  
	  
	
	

}
