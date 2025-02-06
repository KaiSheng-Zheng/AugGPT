public class Player {
	private final int id;
	private int score;
	private int steps;
	private Position position;
	private Map map;
	private int maxStepsAllowed;

	public Player(Map map, Position initialPosition) {
		this.id = generateUniqueId();
		this.score = 0;
		this.steps = 0;
		this.position = initialPosition;
		this.map = map;
		this.maxStepsAllowed = Integer.MAX_VALUE; // No limit by default
	}

	public Player(Map map, Position initialPosition, int maxStepsAllowed) {
		this(map, initialPosition);
		this.maxStepsAllowed = maxStepsAllowed;
	}

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public int getSteps() {
		return steps;
	}

	public Position getPosition() {
		return position;
	}


	public boolean move(Direction direction, int steps) {
		boolean result = true;
		if (!map.isActive()) {
			
			return false;
		}

		int newRow = position.getRow();
		int newCol = position.getCol();

		
		int maxAllowedSteps = 0;

		switch (direction) {
			case UP:
				maxAllowedSteps = newRow;
				newRow = Math.max(0, newRow - steps);
				break;
			case DOWN:
				maxAllowedSteps = map.getRows() - 1 - newRow;
				newRow = Math.min(map.getRows() - 1, newRow + steps);
				break;
			case LEFT:
				maxAllowedSteps = newCol;
				newCol = Math.max(0, newCol - steps);
				break;
			case RIGHT:
				maxAllowedSteps = map.getColumns() - 1 - newCol;
				newCol = Math.min(map.getColumns() -1, newCol + steps);
				break;
		}

		
		int remainingSteps = Math.min(steps, Math.min(maxAllowedSteps, maxStepsAllowed - this.steps));
		
		if (remainingSteps == 0 || steps > maxAllowedSteps|| maxAllowedSteps > maxStepsAllowed - this.steps) {
			result = false;
		}
		
		if (newRow != position.getRow()) {
			int len = newRow > position.getRow() ? newRow - position.getRow() : position.getRow() - newRow;
			len = Math.min(len, remainingSteps);
			for (int i = 0; i < len; i++) {
				int tempRow = newRow > position.getRow() ? position.getRow() + 1 : position.getRow() - 1;
				position = new Position(tempRow, newCol);
				
				int treasureScore = map.hasTreasure(position);
				if (treasureScore > 0) {
					score += treasureScore;
					map.update(position);
					if (!map.isActive()) {
						break;
					}
				}
			}
		}
		if (newCol != position.getCol()) {
			int len = newCol > position.getCol() ? newCol - position.getCol() : position.getCol() - newCol;
			len = Math.min(len, remainingSteps);
			for (int i = 0; i < len; i++) {
				int tempCol = newCol > position.getCol() ? position.getCol() + 1 : position.getCol() - 1;
				position = new Position(newRow, tempCol);
				int treasureScore = map.hasTreasure(position);
				if (treasureScore > 0) {
					score += treasureScore;
					map.update(position);
					if (!map.isActive()) {
						break;
					}
				}

			}
		}


		
		this.steps += remainingSteps;
		return result;
	}


	public boolean equals(Object player) {
		if (player == this) {
			return true;
		}
		if (!(player instanceof Player)) {
			return false;
		}
		Player p = (Player) player;
		return this.id == p.id;
	}

	private int generateUniqueId() {
		return uniqueIdCounter++;
	}

	private static int uniqueIdCounter = 1;
}

