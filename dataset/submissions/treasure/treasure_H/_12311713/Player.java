public class Player {
	private static int count=1;
	private final int id;
	private int score;
	private int steps;
	private int maxStepSpeed;
	private Position position;
	private Map map;
	public Player(Map map, Position initialPosition){
		this.map=map;
		this.position=initialPosition;
		this.id=count++;
		this.maxStepSpeed=-1;
		this.steps=0;
		this.score=0;
	}
	public Player(Map map, Position initialPosition, int maxStepSpeed){
		this.map=map;
		this.position=initialPosition;
		this.id=count++;
		this.maxStepSpeed=maxStepSpeed;
		this.steps=0;
		this.score=0;
	}
	public int getId(){
		return this.id;
	}
	public int getScore(){
		return this.score;
	}
	public int getSteps(){ return this.steps; }
	public Position getPosition(){
		return this.position;
	}
	public boolean equals(Object player){
		Player pl=(Player)player;
		return this.getId()==pl.getId();
	}
	public boolean move(Direction direction, int Steps){
		if(!this.map.isActive() || Steps<=0) {
			return false;
		}
		switch (direction) {
			case UP:
				if (this.maxStepSpeed == -1 && map.isActive() && this.map.up(this.position.getRow())) {
					int tmp=Steps;
					while(tmp>0 && this.map.up(this.position.getRow())
							&& map.isActive()){
						this.position.setRow(this.position.getRow()-1);
						tmp--;
						if(map.hasTreasure(this.position)!=0){
							GameSystem.counts--;
							this.score+=Map.maP[this.position.getRow()][this.position.getCol()];
							map.update(this.position);
						}
						this.steps++;
						Steps--;
						if(!map.isActive() && Steps!=0) {
							return false;
						}
					}
					if(!this.map.up(this.position.getRow()) && Steps==0 && map.isActive())
						return true;
					if(!map.isActive() && Steps==0)
						return true;
					return (this.map.up(this.position.getRow()) && map.isActive());
				} else {
					if (map.isActive() && this.map.up(this.position.getRow())) {
						int tmp=Steps;
						while(tmp>0 && this.map.up(this.position.getRow())
								&& this.maxStepSpeed>0 && map.isActive()){
							this.position.setRow(this.position.getRow()-1);
							tmp--;
							if(map.hasTreasure(this.position)!=0){
								GameSystem.counts--;
								this.score+=Map.maP[this.position.getRow()][this.position.getCol()];
								map.update(this.position);
							}
							this.steps++;
							this.maxStepSpeed--;
							Steps--;
							if(!map.isActive() && Steps!=0 || this.maxStepSpeed<=0)
								return false;
						}
						if(!this.map.up(this.position.getRow()) && Steps==0 && map.isActive() && this.maxStepSpeed > 0)
							return true;
						if(!map.isActive() && Steps==0 && this.maxStepSpeed > 0)
							return true;
						return (this.map.up(this.position.getRow()) && this.maxStepSpeed > 0 && map.isActive());
					} else {
						return false;
					}
				}
			case DOWN:
				if (this.maxStepSpeed == -1 && map.isActive() && this.map.down(this.position.getRow())) {
					int tmp=Steps;
					while(tmp>0 && this.map.down(this.position.getRow())
							&& map.isActive()){
						this.position.setRow(this.position.getRow()+1);
						tmp--;
						if(map.hasTreasure(this.position)!=0){
							GameSystem.counts--;
							this.score+=Map.maP[this.position.getRow()][this.position.getCol()];
							map.update(this.position);
						}
						this.steps++;
						Steps--;
						if(!map.isActive() && Steps!=0) {
							return false;
						}
					}
					if(!this.map.down(this.position.getRow()) && Steps==0 && map.isActive())
						return true;
					if(!map.isActive() && Steps==0)
						return true;
					return (this.map.down(this.position.getRow()) && map.isActive());
				} else {
					if (map.isActive() && this.map.down(this.position.getRow())) {
						int tmp=Steps;
						while(tmp>0 && this.map.down(this.position.getRow())
								&& this.maxStepSpeed>0 && map.isActive()){
							this.position.setRow(this.position.getRow()+1);
							tmp--;
							if(map.hasTreasure(this.position)!=0){
								GameSystem.counts--;
								this.score+=Map.maP[this.position.getRow()][this.position.getCol()];
								map.update(this.position);
							}
							this.steps++;
							this.maxStepSpeed--;
							Steps--;
							if(!map.isActive() && Steps!=0 || this.maxStepSpeed<=0)
								return false;
						}
						if(!this.map.down(this.position.getRow()) && Steps==0 && map.isActive() && this.maxStepSpeed > 0) {
							return true;
						}
						if(this.map.down(this.position.getRow()) && this.maxStepSpeed > 0 && map.isActive()){
							return true;
						}
						if(!map.isActive() && Steps==0 && this.maxStepSpeed > 0)
							return true;
						else return false;
					} else {
						return false;
					}
				}
			case LEFT:
				if (this.maxStepSpeed == -1 && map.isActive() && this.map.left(this.position.getCol())) {
					int tmp=Steps;
					while(tmp>0 && this.map.left(this.position.getCol())
							&& map.isActive()){
						this.position.setCol(this.position.getCol()-1);
						tmp--;
						if(map.hasTreasure(this.position)!=0){
							GameSystem.counts--;
							this.score+=Map.maP[this.position.getRow()][this.position.getCol()];
							map.update(this.position);
						}
						this.steps++;
						Steps--;
						if(!map.isActive() && Steps!=0) {
							return false;
						}
					}
					if(!this.map.left(this.position.getCol()) && Steps==0 && map.isActive())
						return true;
					if(!map.isActive() && Steps==0)
						return true;
					return (this.map.left(this.position.getCol()) && map.isActive());
				} else {
					if (map.isActive() && this.map.left(this.position.getCol())) {
						int tmp=Steps;
						while(tmp>0 && this.map.left(this.position.getCol())
								&& this.maxStepSpeed>0 && map.isActive()){
							this.position.setCol(this.position.getCol()-1);
							tmp--;
							if(map.hasTreasure(this.position)!=0){
								GameSystem.counts--;
								this.score+=Map.maP[this.position.getRow()][this.position.getCol()];
								map.update(this.position);
							}
							this.steps++;
							this.maxStepSpeed--;
							Steps--;
							if(!map.isActive() && Steps!=0 || this.maxStepSpeed<=0)
								return false;
						}
						if(!this.map.left(this.position.getCol()) && Steps==0 && map.isActive() && this.maxStepSpeed > 0)
							return true;
						if(!map.isActive() && Steps==0 && this.maxStepSpeed > 0)
							return true;
						return (this.map.left(this.position.getCol()) && this.maxStepSpeed > 0 && map.isActive());
					} else {
						return false;
					}
				}
			case RIGHT:
				if (this.maxStepSpeed == -1 && map.isActive() && this.map.right(this.position.getCol())) {
					int tmp=Steps;
					while(tmp>0 && this.map.right(this.position.getCol())
							&& map.isActive()){
						this.position.setCol(this.position.getCol()+1);
						tmp--;
						if(map.hasTreasure(this.position)!=0){
							GameSystem.counts--;
							this.score+=Map.maP[this.position.getRow()][this.position.getCol()];
							map.update(this.position);
						}
						this.steps++;
						Steps--;
						if(!map.isActive() && Steps!=0) {
							return false;
						}
					}
					if(!this.map.right(this.position.getCol()) && Steps==0 && map.isActive())
						return true;
					if(this.map.right(this.position.getCol()) && map.isActive())
						return true;
					if(!map.isActive() && Steps==0)
						return true;
					else if(Steps!=0){
						return false;
					}
				} else {
					if (map.isActive() && this.map.right(this.position.getCol())) {
						int tmp=Steps;
						while(tmp>0 && this.map.right(this.position.getCol())
								&& this.maxStepSpeed>0 && map.isActive()){
							this.position.setCol(this.position.getCol()+1);
							tmp--;
							if(map.hasTreasure(this.position)!=0){
								GameSystem.counts--;
								this.score+=Map.maP[this.position.getRow()][this.position.getCol()];
								map.update(this.position);
							}
							this.steps++;
							Steps--;
							this.maxStepSpeed--;
							if(!map.isActive() && Steps!=0 || this.maxStepSpeed<=0)
								return false;
						}
						if(!this.map.right(this.position.getCol()) && Steps==0 && map.isActive() && this.maxStepSpeed > 0)
							return true;
						if(!map.isActive() && Steps==0 && this.maxStepSpeed > 0)
							return true;
						return (this.map.right(this.position.getCol()) && map.isActive() && this.maxStepSpeed > 0);
					} else {
						return false;
					}
				}
		}
		return false;
	}
}
