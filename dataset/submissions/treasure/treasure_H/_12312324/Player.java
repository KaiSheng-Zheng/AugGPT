public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxstep;

    private String Direction;

    public Player(Map map, Position initialPosition) {
        this(map, initialPosition, Integer.MAX_VALUE);
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = hashCode();
        this.score = 0;
        this.position = initialPosition;
        this.map = map;
        if (maxStepAllowed >= 0) {
            this.maxstep = maxStepAllowed;
        } else {
            maxStepAllowed = Integer.MAX_VALUE;
            this.maxstep = maxStepAllowed;
        }
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
        for (int i = 0; i < steps; i++) {
            if (map.isActive() != true) {
                return false;
            }
            if(this.steps>=this.maxstep) return false;
                int newRow = position.getRow();
                int newCol = position.getCol();
                switch (direction) {
                    case UP:
                        if (newRow > 0) {
                            newRow--;
                        } else return false;
                        break;
                    case DOWN:
                        if (newRow < map.getRows()-1) {
                            newRow++;
                        } else return false;
                        break;
                    case LEFT:
                        if (newCol > 0) {
                            newCol--;
                        } else return false;
                        break;
                    case RIGHT:
                        if (newCol < map.getColumns()-1) {
                            newCol++;
                        } else return false;
                        break;
                }
                int Treasurescore = map.hasTreasure(new Position(newRow, newCol));
                if (Treasurescore > 0) {
                    this.score += Treasurescore;
                    map.update(new Position(newRow, newCol));
                }
                position.setCol(newCol);
                position.setRow(newRow);
                this.steps++;
            }
        return true;




        /*   if (!map.isActive) {
            return false;
        }
        int newRow = position.getRow();
        int newCol = position.getCol();
        switch (direction) {
            case UP:
                newRow -= steps;
                break;
            case DOWN:
                newRow += steps;
                break;
            case LEFT:
                newCol -= steps;
                break;
            case RIGHT:
                newCol += steps;
                break;
        }
        int remainingSteps = this.maxstep-this.steps-steps;
        if (newRow < 0){
            remainingSteps = this.maxstep-this.steps-this.position.getRow();
        }
        if (newRow >= map.rows){
            remainingSteps = this.maxstep-this.steps-map.rows+this.position.getRow();
        }
        if (newCol < 0){
            remainingSteps = this.maxstep-this.steps-this.position.getCol();
        }
        if (newRow >= map.columns){
            remainingSteps = this.maxstep-this.steps-map.columns+this.position.getCol();
        }


        if (remainingSteps>=0){
            int nRow= position.getRow();
            int nCol= position.getCol();
            int mRow= position.getRow();
            int mCol= position.getCol();
            if (newRow < 0) {
                for (int h=0;h<mRow;h++){
                    switch (direction) {
                        case UP:
                            nRow--;
                            break;
                        case DOWN:
                            nRow++;
                            break;
                        case LEFT:
                            nCol--;
                            break;
                        case RIGHT:
                            nCol++;
                            break;
                    }
                    int Treasurescore = map.hasTreasure(new Position(nRow, nCol));
                    if (Treasurescore > 0) {
                        this.score += Treasurescore;
                        map.update(new Position(nRow, nCol));
                    }
                }
                newRow=0;
                this.steps+=(mRow+1);
                position.setRow(newRow);
                return false;
            }
            if(newRow > map.rows){
                for (int h=0;h<map.rows-mRow;h++){
                    switch (direction) {
                        case UP:
                            nRow--;
                            break;
                        case DOWN:
                            nRow++;
                            break;
                        case LEFT:
                            nCol--;
                            break;
                        case RIGHT:
                            nCol++;
                            break;
                    }
                    int Treasurescore = map.hasTreasure(new Position(nRow, nCol));
                    if (Treasurescore > 0) {
                        this.score += Treasurescore;
                        map.update(new Position(nRow, nCol));
                    }
                }
                newRow=map.rows;
                this.steps+=(map.rows-mRow);
                position.setRow(newRow);
                return false;
            }
            if (newCol < 0){
                for (int h=0;h<mCol;h++){
                    switch (direction) {
                        case UP:
                            nRow--;
                            break;
                        case DOWN:
                            nRow++;
                            break;
                        case LEFT:
                            nCol--;
                            break;
                        case RIGHT:
                            nCol++;
                            break;
                    }
                    int Treasurescore = map.hasTreasure(new Position(nRow, nCol));
                    if (Treasurescore > 0) {
                        this.score += Treasurescore;
                        map.update(new Position(nRow, nCol));
                    }
                }
                newCol=0;
                this.steps+=(mCol+1);
                position.setCol(newCol);
                return false;
            }
            if (newCol > map.columns){
                for (int h=0;h<map.columns-mCol;h++){
                    switch (direction) {
                        case UP:
                            nRow--;
                            break;
                        case DOWN:
                            nRow++;
                            break;
                        case LEFT:
                            nCol--;
                            break;
                        case RIGHT:
                            nCol++;
                            break;
                    }
                    int Treasurescore = map.hasTreasure(new Position(nRow, nCol));
                    if (Treasurescore > 0) {
                        this.score += Treasurescore;
                        map.update(new Position(nRow, nCol));
                    }
                }
                newCol=map.columns;
                this.steps+= (map.columns-mCol);
                position.setCol(newCol);
                return false;
            }
            for (int h=0;h<steps;h++){
                switch (direction) {
                    case UP:
                        nRow--;
                        break;
                    case DOWN:
                        nRow++;
                        break;
                    case LEFT:
                        nCol--;
                        break;
                    case RIGHT:
                        nCol++;
                        break;
                }
                int Treasurescore = map.hasTreasure(new Position(nRow, nCol));
                if (Treasurescore > 0) {
                    this.score += Treasurescore;
                    map.update(new Position(nRow, nCol));
                }
            }
            this.steps+=steps;

            position.setRow(newRow);
            position.setCol(newCol);
            return true;
        }if (remainingSteps<0) {
            int nRow= position.getRow();
            int nCol= position.getCol();
            for (int h=0;h<maxstep-this.steps;h++){
                switch (direction) {
                    case UP:
                        nRow--;
                        break;
                    case DOWN:
                        nRow++;
                        break;
                    case LEFT:
                        nCol--;
                        break;
                    case RIGHT:
                        nCol++;
                        break;
                }
                int Treasurescore = map.hasTreasure(new Position(nRow, nCol));
                if (Treasurescore > 0) {
                    this.score += Treasurescore;
                    map.update(new Position(nRow, nCol));
                }
            }
            this.steps= maxstep;
            position.setCol(nCol);
            position.setRow(nRow);
            return false;}
        return false;

      */
    }


    public boolean equals(Object player) {
        Player p = (Player) player;
        if (p.id == this.id) {
            return true;
        }
        return false;
    }
}