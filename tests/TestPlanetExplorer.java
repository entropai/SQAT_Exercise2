import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

		
	// Headings
	static String LANDING_STATUS = "(0,0,N)";
	static String HEADING_STATUS_LEFT ="(0,0,W)";
	static String HEADING_STATUS_RIGHT ="(0,0,E)";	
	
	// Commands
	static String NO_OBSTACLES = "";
	static String NO_COMMAND = "";
	static String TURN_LEFT_INPLACE = "l";
	static String TURN_RIGHT_INPLACE = "r";
	
	// Fixture
	PlanetExplorer explorer = new PlanetExplorer(DEFAULT_WIDTH, DEFAULT_HEIGHT, NO_OBSTACLES);
	static int DEFAULT_WIDTH  = 100;
	static int DEFAULT_HEIGHT = 100;
	
	@Test
	public void test_createNewPlanetWithoutObstacles() {		
		int map[][] = explorer.getMap();
		assertNotEquals(null, map);
	}
	
	@Test
	public void test_createNewPlanetSizeMatchesWithoutObstacles() {	
		int x = explorer.getPlanetWidht();
		int y = explorer.getPlanetHeight();
		assertEquals("Created planet width is incorrect ", DEFAULT_WIDTH, x);
		assertEquals("Created planet height is incorrect ", DEFAULT_HEIGHT, y);		
	}	
		
	@Test
	public void test_executeCommandWhenLanding() {
		String status = explorer.executeCommand(NO_COMMAND);
		assertEquals("Explorer status invalid in landing", LANDING_STATUS, status);
	}
	
	@Test
	public void test_executeTurnInPlaceLeftCommand() {
		String status = explorer.executeCommand(TURN_LEFT_INPLACE);
		assertEquals("Explorer heading invalid in while turning left", HEADING_STATUS_LEFT, status);
	}
	
	public void test_executeTurnInPlaceRightCommand() {
		String status = explorer.executeCommand(TURN_RIGHT_INPLACE);
		assertEquals("Explorer heading invalid in while turning right", HEADING_STATUS_RIGHT, status);
	}
	
}
