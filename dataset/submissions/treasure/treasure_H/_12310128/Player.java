public class Player {
    private final int id;
    private static int ID = 0;
    private int score = 0;

    public int getId() {
        return id;
    }

    private int steps = 0;
    private Position position;
    private Map map;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = ++ID;
    }

    int maxStepAllowed = Integer.MAX_VALUE;

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.id = ++ID;
    }

    public boolean move(Direction direction, int steps) {
        if (!this.map.isActive()) {
            return false;
        } else {
            if (this.steps + steps > maxStepAllowed) {
                steps = maxStepAllowed - this.steps;
                switch (direction) {
                    case UP:
                        this.position.setRow(this.position.getRow() - steps);
                        break;
                    case DOWN:
                        this.position.setRow(this.position.getRow() + steps);
                        break;
                    case LEFT:
                        this.position.setCol(this.position.getCol() - steps);
                        break;
                    case RIGHT:
                        this.position.setCol(this.position.getCol() + steps);
                        break;
                }
                if (this.position.getRow() < 0 || this.position.getRow() > this.map.getRows() - 1) {
                    if (this.position.getRow() < 0) {
                        this.steps = this.steps + this.position.getRow() + steps;
                        for (int i = 0; i < this.position.getRow() + steps; i++) {
                            Position position = new Position(i, this.position.getCol());
                            this.score = this.score + map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                this.position.setRow(i);
                                return false;
                            }
                        }
                        this.position.setRow(0);
                    } else {
                        this.steps = this.steps + this.map.getRows() - (this.position.getRow() - steps + 1);
                        for (int i = this.position.getRow() - steps + 1; i < this.map.getRows(); i++) {
                            Position position = new Position(i, this.position.getCol());
                            this.score = this.score + map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                this.position.setRow(i);
                                return false;
                            }
                        }
                        this.position.setRow(this.map.getRows() - 1);
                    }
                    return false;
                } else if (this.position.getCol() < 0 || this.position.getCol() > this.map.getColumns() - 1) {
                    if (this.position.getCol() < 0) {
                        this.steps = this.steps + this.position.getCol() + steps;
                        for (int i = 0; i < this.position.getCol() + steps; i++) {
                            Position position = new Position(this.position.getRow(),i);
                            this.score = this.score + map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                this.position.setCol(i);
                                return false;
                            }
                        }
                        this.position.setCol(0);
                    } else {
                        this.steps = this.steps + this.map.getColumns() - (this.position.getCol() - steps + 1);
                        for (int i = this.position.getCol() - steps + 1; i < this.map.getColumns(); i++) {
                            Position position = new Position(this.position.getRow(),i);
                            this.score = this.score + map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                this.position.setCol(i);
                                return false;
                            }
                        }
                        this.position.setCol(this.map.getColumns() - 1);
                    }
                    return false;
                } else {
                    this.steps = this.steps + steps;
                    if (direction.equals(Direction.UP)) {
                        for (int i = this.position.getRow(); i < this.position.getRow() + steps; i++) {
                            Position position = new Position(i, this.position.getCol());
                            this.score = this.score + map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                this.position.setRow(i);
                                return false;
                            }
                        }
                    } else if (direction.equals(Direction.DOWN)){
                        for (int i = this.position.getRow() - steps + 1; i <= this.position.getRow(); i++) {
                            Position position = new Position(i, this.position.getCol());
                            this.score = this.score + map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                this.position.setRow(i);
                                return false;
                            }
                        }
                    } else if (direction.equals(Direction.LEFT)) {
                        for (int i = this.position.getCol(); i < this.position.getCol() + steps; i++) {
                            Position position = new Position(this.position.getRow(),i);
                            this.score = this.score + map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                this.position.setCol(i);
                                return false;
                            }
                        }
                    } else {
                        for (int i = this.position.getCol() - steps + 1; i <= this.position.getCol(); i++) {
                            Position position = new Position(this.position.getRow(),i);
                            this.score = this.score + map.hasTreasure(position);
                            map.update(position);
                            if (!map.isActive()) {
                                this.position.setCol(i);
                                return false;
                            }
                        }
                    }
                    return false;
                }
            }
            switch (direction) {
                case UP:
                    this.position.setRow(this.position.getRow() - steps);
                    break;
                case DOWN:
                    this.position.setRow(this.position.getRow() + steps);
                    break;
                case LEFT:
                    this.position.setCol(this.position.getCol() - steps);
                    break;
                case RIGHT:
                    this.position.setCol(this.position.getCol() + steps);
                    break;
            }
            if (this.position.getRow() < 0 || this.position.getRow() > this.map.getRows() - 1) {
                if (this.position.getRow() < 0) {
                    this.steps = this.steps + this.position.getRow() + steps;
                    for (int i = 0; i < this.position.getRow() + steps; i++) {
                        Position position = new Position(i, this.position.getCol());
                        this.score = this.score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive()) {
                            this.position.setRow(i);
                            return false;
                        }
                    }
                    this.position.setRow(0);
                } else {
                    this.steps = this.steps + this.map.getRows() - (this.position.getRow() - steps + 1);
                    for (int i = this.position.getRow() - steps + 1; i < this.map.getRows(); i++) {
                        Position position = new Position(i, this.position.getCol());
                        this.score = this.score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive()) {
                            this.position.setRow(i);
                            return false;
                        }
                    }
                    this.position.setRow(this.map.getRows() - 1);
                }
                return false;
            } else if (this.position.getCol() < 0 || this.position.getCol() > this.map.getColumns() - 1) {
                if (this.position.getCol() < 0) {
                    this.steps = this.steps + this.position.getCol() + steps;
                    for (int i = 0; i < this.position.getCol() + steps; i++) {
                        Position position = new Position(this.position.getRow(),i);
                        this.score = this.score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive()) {
                            this.position.setCol(i);
                            return false;
                        }
                    }
                    this.position.setCol(0);
                } else {
                    this.steps = this.steps + this.map.getColumns() - (this.position.getCol() - steps + 1);
                    for (int i = this.position.getCol() - steps + 1; i < this.map.getColumns(); i++) {
                        Position position = new Position(this.position.getRow(),i);
                        this.score = this.score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive()) {
                            this.position.setRow(i);
                            return false;
                        }
                    }
                    this.position.setCol(this.map.getColumns() - 1);
                }
                return false;
            } else {
                this.steps = this.steps + steps;
                if (direction.equals(Direction.UP)) {
                    for (int i = this.position.getRow(); i < this.position.getRow() + steps; i++) {
                        Position position = new Position(i, this.position.getCol());
                        this.score = this.score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive() && i != this.position.getRow() + steps - 1) {
                            this.position.setRow(i);
                            return false;
                        }
                    }
                } else if (direction.equals(Direction.DOWN)){
                    for (int i = this.position.getRow() - steps + 1; i <= this.position.getRow(); i++) {
                        Position position = new Position(i, this.position.getCol());
                        this.score = this.score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive() && i != this.position.getRow()) {
                            this.position.setRow(i);
                            return false;
                        }
                    }
                } else if (direction.equals(Direction.LEFT)) {
                    for (int i = this.position.getCol(); i < this.position.getCol() + steps; i++) {
                        Position position = new Position(this.position.getRow(),i);
                        this.score = this.score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive() && i != this.position.getCol() + steps - 1) {
                            this.position.setCol(i);
                            return false;
                        }
                    }
                } else {
                    for (int i = this.position.getCol() - steps + 1; i <= this.position.getCol(); i++) {
                        Position position = new Position(this.position.getRow(),i);
                        this.score = this.score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive() && i != this.position.getCol()) {
                            this.position.setCol(i);
                            return false;
                        }
                    }
                }
                return true;
            }
        }
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        return p.getId() == this.id;
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
}
