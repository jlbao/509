package controller;

import static org.junit.Assert.assertTrue;
import model.DataSet;
import model.Model;
import model.Point;

import org.junit.Before;
import org.junit.Test;

import view.MainGUI;

public class TestCreateNewDatasetController {

	Model m;
	MainGUI mainGUI;
	CreateNewDatasetController controller;
	
	@Before
	public void setUp() throws Exception {
		this.m = new Model();
		this.mainGUI = new MainGUI(m);
		this.controller = new CreateNewDatasetController(m, mainGUI);
	}
	
	@Test
	public void test() {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(2, 3);
		
		DataSet dataset = (DataSet)m.getDataSet();
		dataset.addPoint(p1);
		dataset.addPoint(p2);

		assertTrue(controller.act());
		
		dataset = (DataSet)m.getDataSet();
		assertTrue(dataset.size() == 0);
	}

}
