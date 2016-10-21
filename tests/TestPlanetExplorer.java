import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

		
	// Headings
	static String LANDING_STATUS = "(0,0,N)";
	static String HEADING_STATUS_LEFT_AFTER_LANDING ="(0,0,W)";
	static String HEADING_STATUS_RIGHT_AFTER_LANDING ="(0,0,E)";	
	
	// Commands	
	static String NO_COMMAND = "";
	static String COMMAND_TURN_LEFT_INPLACE = "l";
	static String COMMAND_TURN_RIGHT_INPLACE = "r";	
	static String COMMAND_MOVE_FORWARD = "f";
	static String COMMAND_MOVE_BACKWARDS = "b";
	static String COMMAND_MOVE_FORWARD_3_TIMES = "fff";
	
	// Fixture
	static int DEFAULT_WIDTH  = 100;
	static int DEFAULT_HEIGHT = 100;
	static String NO_OBSTACLES = "";
	PlanetExplorer explorer = new PlanetExplorer(DEFAULT_WIDTH, DEFAULT_HEIGHT, NO_OBSTACLES);
	
	
	@Test
	public void test_createNewPlanetWithoutObstacles() {		
		int map[][] = explorer.getMap();
		assertNotEquals("Failed to create map ", null, map);
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
	public void test_executeTurnInPlaceLeftCommandAfterLanding() {
		String status = explorer.executeCommand(COMMAND_TURN_LEFT_INPLACE);
		assertEquals("Explorer heading invalid in while turning left", HEADING_STATUS_LEFT_AFTER_LANDING, status);
	}
	
	@Test
	public void test_executeTurnInPlaceRightCommandAfterLanding() {
		String status = explorer.executeCommand(COMMAND_TURN_RIGHT_INPLACE);
		assertEquals("Explorer heading invalid in while turning right", HEADING_STATUS_RIGHT_AFTER_LANDING, status);
	}
	
	@Test
	public void test_executeTurnLeftThreeTimesInitiallyFacingNorth() {
		explorer.setPosition(1, 1);
		explorer.setHeading(PlanetExplorer.heading.NORTH);
		String status = explorer.executeCommand(COMMAND_TURN_LEFT_INPLACE);
		status = explorer.executeCommand(COMMAND_TURN_LEFT_INPLACE);
		status = explorer.executeCommand(COMMAND_TURN_LEFT_INPLACE);
		
		assertEquals("Wrong heading after turning left three times", "(1,1,E)", status);
	}
	
	@Test
	public void test_executeTurnRightTwiceTimesInitiallyFacingEast() {
		explorer.setPosition(1, 1);
		explorer.setHeading(PlanetExplorer.heading.EAST);
		String status = explorer.executeCommand(COMMAND_TURN_RIGHT_INPLACE);
		status = explorer.executeCommand(COMMAND_TURN_RIGHT_INPLACE);		
		
		assertEquals("Wrong heading after turning right two times", "(1,1,W)", status);
	}
	
	@Test
	public void test_setExplorerPositionAndHeading() {
		 explorer.setPosition(5,4);
		 explorer.setHeading(PlanetExplorer.heading.EAST);
		 String status = explorer.getPosition();
		 assertEquals("Explorer position invalid", "(5,4,E)", status);
	}	
	
	@Test
	public void test_executeMoveForwardFacingNorthCommand() {
		explorer.setPosition(7,6);
		explorer.setHeading(PlanetExplorer.heading.NORTH);
		String status = explorer.executeCommand(COMMAND_MOVE_FORWARD);		
		assertEquals("Explorer position invalid after moving forward", "(7,7,N)" , status);
	}
	
	@Test
	public void test_executeMoveBackwardsFacingEastCommand() {
		explorer.setPosition(5,8);
		explorer.setHeading(PlanetExplorer.heading.EAST);
		String status = explorer.executeCommand(COMMAND_MOVE_BACKWARDS);		
		assertEquals("Explorer position invalid after moving backwards", "(4,8,E)" , status);
	}
	
	@Test
	public void test_executeMoveForwardFacingEastCommand() {
		explorer.setPosition(7,6);
		explorer.setHeading(PlanetExplorer.heading.EAST);
		String status = explorer.executeCommand(COMMAND_MOVE_FORWARD);		
		assertEquals("Explorer position invalid after moving forward", "(8,6,E)" , status);
	}
	
	@Test
	public void test_executeMoveBackwardsFacingSouthCommand() {
		explorer.setPosition(7,6);
		explorer.setHeading(PlanetExplorer.heading.SOUTH);
		String status = explorer.executeCommand(COMMAND_MOVE_BACKWARDS);		
		assertEquals("Explorer position invalid after moving forward", "(7,7,S)" , status);
	}	
	
	@Test 
	public void test_executeMultipleMoveForwardCommands() {
		status = explorer.executeCommand()
	}
	
		
}
