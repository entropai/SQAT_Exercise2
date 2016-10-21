import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	
	@Test
	public void test_createNewPlanetWithoutObstacles() {
		
		int width = 100;
		int height = 100;
		PlanetExplorer explorer = new PlanetExplorer(width, height, "");
		int x = explorer.getPlanetWidth();
		int y = explorer.getPlanetHeight();
		assertEquals("Created planet width is in correct ", width, x);
		assertEquals("Created planet height is in correct ", height, x);
		
	}
	
	@Test
	public void test_executeCommand() {
		
	}
}
