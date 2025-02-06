class Node {
    private boolean occupied = false;
    private Treasure treasure;
    private boolean cleared = false;
    private Node leftChild, rightChild;

    public boolean add(Treasure treasure) {
        if (treasure.getScore() == 0) return false;
        if (occupied) {
            if (Treasure.hasBiggerPosition(this.treasure, treasure)) return leftChild.add(treasure);
            if (Treasure.hasBiggerPosition(treasure, this.treasure)) return rightChild.add(treasure);
            this.treasure = new Treasure(this.treasure.getScore() + treasure.getScore(),
                        this.treasure.getPosition());
            return false;
        }
        occupied = true;
        this.treasure = new Treasure(treasure);
        leftChild = new Node();
        rightChild = new Node();
        return true;
    }

    public int checkPosition(Position position) {
        if (!occupied) return 0;
        if (Position.isBigger(treasure.getPosition(), position)) return leftChild.checkPosition(position);
        if (Position.isBigger(position, treasure.getPosition())) return rightChild.checkPosition(position);
        if (cleared) return 0;
        return treasure.getScore();
    }

    public int clearPosition(Position position) {
        if (!occupied) return 0;
        if (Position.isBigger(treasure.getPosition(), position)) return leftChild.clearPosition(position);
        if (Position.isBigger(position, treasure.getPosition())) return rightChild.clearPosition(position);
        if (cleared) return 0;
        cleared = true; return treasure.getScore();
    }
}

public class Map {
    private final int rows;
    private final int columns;
    private Treasure[] treasures;
    private boolean isActive = false;
    private Node root = new Node();
    private int numberOfTreasure = 0;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        for (Treasure treasure : treasures)
            if (root.add(treasure)) {
                //System.out.println("Add treasure at " + treasure.getPosition().toString()
                //        + " with " + treasure.getScore() + " score(s)");
                numberOfTreasure++;
                isActive = true;
            }
    }

    public int hasTreasure(Position position) {
        return root.checkPosition(position);
    }

    public void update(Position position){
        if(root.clearPosition(position) != 0) numberOfTreasure--;
        if (numberOfTreasure == 0) isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean positionExceedBound(Position position) {
        if (position.getRow() < 0) {position.setRow(0); return true;}
        if (position.getRow() >= rows) {position.setRow(rows - 1); return true;}
        if (position.getCol() < 0) {position.setCol(0); return true;}
        if (position.getCol() >= columns) {position.setCol(columns - 1); return true;}
        return false;
    }

    public int moveAndCollect(Player player, Position currentPosition, Direction direction, int stepsRemained) {
        if (stepsRemained == 0) return 0;
        if (!isActive) return stepsRemained;
        currentPosition.directMove(direction, 1);
        if (positionExceedBound(currentPosition)) return stepsRemained;
        int t = hasTreasure(currentPosition);
        //System.out.print(currentPosition);
        //System.out.println(" is checked by id: " + player.getId());
        if (t != 0) {
            player.gainScore(t);
            update(currentPosition);
            //System.out.println("id: " + player.getId() + " gets " + t + " score(s)");
            //System.out.println("treasure left: " + numberOfTreasure);
        }
        return moveAndCollect(player, currentPosition, direction, stepsRemained - 1);
    }

    public int getNumberOfTreasure() {
        return numberOfTreasure;
    }
}
