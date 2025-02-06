public class Map {
	private final int rows;
	private final int columns;
	private boolean isActive=true;
	private Treasure[] treasures;
	public static int[][] maP;
	public void update(Position position){
		if(maP[position.getRow()][position.getCol()]!=0)
			maP[position.getRow()][position.getCol()]=0;
		if(GameSystem.counts==0){
			isActive=false;
		}
	}
	public Map(int rows, int columns, Treasure[] treasures){
		this.rows=rows;
		this.columns=columns;
		this.treasures=treasures;
		maP=new int[rows+100][columns+100];
		for(int i=0;i<rows;i++)
			for(int j=0;j<columns;j++)
				maP[i][j]=0;
		for(int i=0;i<Treasure.poses.size();i++){
			maP[Integer.parseInt(Treasure.poses.get(i).split(" ")[1])]
					[Integer.parseInt(Treasure.poses.get(i).split(" ")[2])]=
					Integer.parseInt(Treasure.poses.get(i).split(" ")[0]);
		}
	}
	public int hasTreasure(Position position){
		for (int i = 0; i < treasures.length; i++) {
			if(position.equals(treasures[i].getPosition())
					&& maP[position.getRow()][position.getCol()]!=0) {
				return treasures[i].getScore();
			}
		}
		return 0;
	}
	public boolean isActive(){
		return isActive;
	}
	public boolean up(int row){
		if(row-1>=0)
			return true;
		return false;
	}
	public boolean down(int row){
		if(row+1<this.rows)
			return true;
		return false;
	}
	public boolean left(int col){
		if(col-1>=0)
			return true;
		return false;
	}
	public boolean right(int col){
		if(col+1<this.columns)
			return true;
		return false;
	}
}
