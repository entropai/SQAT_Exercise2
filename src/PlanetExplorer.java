
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 152
// Finish time:

public class PlanetExplorer {
	
	private int[][] map;
	private String position;	
	private int posX = 0;
	private int posY = 0;	
	
	private heading currentHeading = heading.NORTH;
	
	public enum heading {
		NORTH,
		EAST,
		WEST,
		SOUTH		
	} 
	
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
		
		map = new int[x][y];
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		if(command.equals("")) {
			return parseStatus();
		}
		
		if(command.equals("l"))
		{
			turnLeft();
			return parseStatus();
		}
		
		if(command.equals("r")) {
			turnRight();
			return parseStatus();
		}
		
		return null;
	}	
	
	public void setPosition(String newStatus) {
		position = newStatus;
	}
	
	public String getPosition() {
		return position;
	}
	
	public int[][] getMap() {
		return map;
	}
	
	public int getPlanetWidht() {
		return map.length;		
	}
	
	public int getPlanetHeight() {
		return map[0].length;
	}
	
	private String parseStatus() {
		return "("+posX+","+posY+","+headingToString(currentHeading)+")";		
	}
	
	private void turnLeft() {
		currentHeading = heading.WEST;
	}
		
	private void turnRight() {
		currentHeading = heading.EAST;
	}
	
	private String headingToString(heading to) {
		switch(to) {
			case NORTH: return "N";
			case SOUTH: return "S";
			case EAST: return "E";
			case WEST: return "W";
		}		
		return null;
	}
}
