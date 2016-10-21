import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	
	static int DEFAULT_WIDTH  = 100;
	static int DEFAULT_HEIGHT = 100;
	static String NO_OBSTACLES = "";
	
	PlanetExplorer explorer = new PlanetExplorer(DEFAULT_WIDTH, DEFAULT_HEIGHT, NO_OBSTACLES);
	
	
	@Test
	public void test_createNewPlanetWithoutObstacles() {	
		
		int map[][] = explorer.getMap();
		assertNotEquals(null, map);
	}
	
	@Test
	public void test_createNewPlanetSizeMatchesWithoutObstacles() {		
		
		PlanetExplorer explorer = new PlanetExplorer(DEFAULT_WIDTH, DEFAULT_HEIGHT, "");
		int x = explorer.getPlanetWidht();
		int y = explorer.getPlanetHeight();
		assertEquals("Created planet width is in correct ", DEFAULT_WIDTH, x);
		assertEquals("Created planet height is in correct ", DEFAULT_HEIGHT, y);		
	}
	
	
	@Test
	public void test_executeCommand() {
		
	}
}
