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
public class ShipmentTypeUtill {

	
	

	public void generatePieChart(String path , List<Object[]> data) {
		
		
	
		
		
		DefaultPieDataset dataset= new DefaultPieDataset();
		
		for (Object[] ob:data) {
			
			
			
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		
		
	  JFreeChart jfreechat= ChartFactory.createPieChart3D("Shipment type modes", dataset, true, true, false);
		
	  
	  
	  // convert jfree to image
	  
	  
	             try {
					ChartUtilities.saveChartAsJPEG(new File(path +"resources/images/shipmentpie.jpg"), jfreechat, 250, 250);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  
		
	}
	
	
	
	
	public void createBarChart(String path, List<Object[]> data) {
		
		
		// create data set
		DefaultCategoryDataset dataset= new DefaultCategoryDataset();
		
		
		//create chart facitory
		
	                for(Object[] b: data) {
	                	
	                	  
	                	 
	                }
		
	                JFreeChart chart=  ChartFactory.createBarChart("Shipment type data","a" , "b", dataset, PlotOrientation.VERTICAL, true, true, false);
		
		
		 // create chart to image
		
		         try {
		        	 
					ChartUtilities.saveChartAsJPEG(new File(path+"resources/images/shipmentbar.jpg"), chart, 250, 250);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}          
		            
		 
		                   
	}
	
	
}
