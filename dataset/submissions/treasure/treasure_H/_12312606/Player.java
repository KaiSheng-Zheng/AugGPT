public class Player {
    private static int playerCount = 0;

    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepsAllowed = 999999;

    public Player(Map map, Position initialPosition) {
        this(map, initialPosition,99999999);
    }

    public Player(Map map, Position initialPosition, int maxStepsAllowed) {
        this.id = ++playerCount;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
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

    public boolean
    move(Direction direction, int steps) {
        if (steps == 0) {
            return true;
        }
        if (!map.isActive() || maxStepsAllowed <= 0) {
            return false;
        }
        else {//if (maxStepsAllowed > 0) {



            int newRow = position.getRow();
            int newCol = position.getCol();

            switch (direction) {
                case UP:
                    newRow -= 1;
                    break;
                case DOWN:
                    newRow += 1;
                    break;
                case LEFT:
                    newCol -= 1;
                    break;
                case RIGHT:
                    newCol += 1;
                    break;
            }
            int actualRow = newRow;
            int actualCol = newCol;
            int maxRow = map.getRows() - 1;
            int maxCol = map.getColumns() - 1;
            if (newRow < 0 || newRow > maxRow || newCol < 0 || newCol > maxCol) {
                if (newRow < 0) {
                    actualRow = 0;
                    //steps = position.getRow();
                } else if (newRow > maxRow) {
                    actualRow = maxRow;
                    //steps = maxRow - position.getRow();
                }

                if (newCol < 0) {
                    actualCol = 0;
                    //steps = position.getCol();
                } else if (newCol > maxCol) {
                    actualCol = maxCol;
                    //steps = maxCol - position.getCol();
                }

                //this.steps += 1;

                /*
                for (int i = 0; i <= steps; i++) {
                    if (steps == 0) {
                        break;
                    }
                    Position actualPosition = new Position(position.getRow() + (i * (actualRow - position.getRow()) / steps),
                            position.getCol() + (i * (actualCol - position.getCol()) / steps));
                    int treasureScore = map.hasTreasure(actualPosition);


                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(actualPosition);

                    }
                    if (!map.isActive()) {
                        return false;
                    }
                }

                 */
                position = new Position(actualRow, actualCol);
                return false;
            } else {//if (newRow >= 0 && newRow <= maxRow && newCol >= 0 && newCol <= maxCol) {
                /*
                if (newRow < 0) {
                    actualRow = 0;
                    //steps = position.getRow();
                } else if (newRow > maxRow) {
                    actualRow = maxRow;
                    //steps = maxRow - position.getRow();
                }

                if (newCol < 0) {
                    actualCol = 0;
                    //steps = position.getCol();
                } else if (newCol > maxCol) {
                    actualCol = maxCol;
                    //steps = maxCol - position.getCol();
                }

                 */

                this.steps += 1;
                /*
                for (int i = 0; i <= steps; i++) {
                    if (steps == 0) {
                        break;
                    }
                    Position actualPosition = new Position(position.getRow() + (i * (actualRow - position.getRow()) / steps),
                            position.getCol() + (i * (actualCol - position.getCol()) / steps));
                    int treasureScore = map.hasTreasure(actualPosition);


                    if (treasureScore > 0) {
                        score += treasureScore;
                        map.update(actualPosition);

                    }


                }

                 */
                position = new Position(actualRow, actualCol);


                int treasureScore = map.hasTreasure(position);


                if (treasureScore > 0) {
                    score += treasureScore;
                    map.update(position);

                }

                maxStepsAllowed--;
                return move(direction, steps - 1);//true;
            }


            //return true;
        }/*
        else {
            return false;
        }
        */

    }






    @Override
    public boolean equals(Object player) {
        if (this == player) {
            return true;
        }
        if (player == null || getClass() != player.getClass()) {
            return false;
        }
        Player otherPlayer = (Player) player;
        return id == otherPlayer.id;
    }
}