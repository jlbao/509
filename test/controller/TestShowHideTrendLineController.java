package controller;

import static org.junit.Assert.assertTrue;
import model.DataSet;
import model.Model;
import model.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.MainGUI;
import dataset.ICommonProperties;

public class TestShowHideTrendLineController {

	
	Model m;
	MainGUI mainGUI;
	ShowHideTrendLineController controller;
	
	@Before
	public void setUp() throws Exception {
		this.m = new Model();
		this.mainGUI = new MainGUI(m);
		this.controller = new ShowHideTrendLineController(m, mainGUI);
		mainGUI.setVisible(true);
	}
		
	@After
	public void tearDown(){
		mainGUI.dispose();
	}
	
	@Test
	public void testShowTrendLine() {
		DataSet dataset = (DataSet)m.dataSet;
		Point p1 = new Point(1, 2);
		Point p2 = new Point(-1, -2);
		dataset.addPoint(p1);
		dataset.addPoint(p2);
		
		m.setGraph(ICommonProperties.cartesian);
		
		m.properties.setProperty(ICommonProperties.trendLineVisible, Boolean.FALSE.toString());
		m.properties.setProperty(ICommonProperties.trendLineEquationVisible, Boolean.FALSE.toString());

		assertTrue(controller.act());
		
		
		assertTrue(Boolean.TRUE.toString().equals(m.properties.getProperty(ICommonProperties.trendLineVisible)));
		assertTrue(Boolean.TRUE.toString().equals(m.properties.getProperty(ICommonProperties.trendLineEquationVisible)));
		
	}
	
	@Test
	public void testHideTrendLine() {
		DataSet dataset = (DataSet)m.dataSet;
		Point p1 = new Point(1, 2);
		Point p2 = new Point(-1, -2);
		dataset.addPoint(p1);
		dataset.addPoint(p2);

		m.setGraph(ICommonProperties.cartesian);

		m.properties.setProperty(ICommonProperties.trendLineVisible, Boolean.TRUE.toString());
		m.properties.setProperty(ICommonProperties.trendLineEquationVisible, Boolean.TRUE.toString());
		
		assertTrue(controller.act());
		assertTrue(Boolean.FALSE.toString().equals(m.properties.getProperty(ICommonProperties.trendLineVisible)));
		assertTrue(Boolean.FALSE.toString().equals(m.properties.getProperty(ICommonProperties.trendLineEquationVisible)));
		
	}
}
