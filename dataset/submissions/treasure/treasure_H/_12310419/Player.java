public class Player {
    private final int id;
    private static int number;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map,Position initalPosition) {
        this.position = initalPosition;
        this.map = map;
        this.id=++number;
    }
    public Player(Map map,Position initalPosition,int maxStepAllowed){
        this.id=++number;
        this.map = map;
        this.position = initalPosition;
        if (maxStepAllowed>0)
            this.maxStepAllowed = maxStepAllowed;
        else
            this.maxStepAllowed=-1;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
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

    public void setPosition(Position position) {
        this.position = position;
    }

    public Map getMap() {
        return map;
    }

    public boolean move(Direction direction, int steps){
        if (!map.isActive())
            return false;
        int c=0;
        switch (direction){
            case UP:
                if (position.getRow()-steps<0) {
                    if (maxStepAllowed != 0 && this.steps + steps > this.maxStepAllowed) {
                        if (maxStepAllowed-this.steps>position.getRow()){
                            for (int i = 0; i <=position.getRow() ; i++) {
                                score+=map.hasTreasure(new Position(position.getRow()-i,position.getCol()));
                                map.update(new Position(position.getRow()-i,position.getCol()));
                                c=i;
                                if (!map.isActive())
                                    break;
                            }
                            setPosition(new Position(position.getRow()-c,position.getCol()));
                            this.steps+=c;
                        }else {
                            for (int i = 0; i <=maxStepAllowed-this.steps ; i++) {
                                score+=map.hasTreasure(new Position(position.getRow()-i,position.getCol()));
                                map.update(new Position(position.getRow()-i,position.getCol()));
                                c=i;
                                if (!map.isActive())
                                    break;
                            }
                            setPosition(new Position(position.getRow()-c,position.getCol()));
                            this.steps+=c;
                        }
                    }else {
                        for (int i = 0; i <=position.getRow() ; i++) {
                            score+=map.hasTreasure(new Position(position.getRow()-i,position.getCol()));
                            map.update(new Position(position.getRow()-i,position.getCol()));
                            c=i;
                            if (!map.isActive())
                                break;
                        }
                        setPosition(new Position(position.getRow()-c,position.getCol()));
                        this.steps+=c;
                    }
                    return false;
                }else {
                    if (maxStepAllowed != 0 && this.steps + steps > this.maxStepAllowed){
                        for (int i = 0; i <=maxStepAllowed-this.steps ; i++) {
                            score+=map.hasTreasure(new Position(position.getRow()-i,position.getCol()));
                            map.update(new Position(position.getRow()-i,position.getCol()));
                            c=i;
                            if (!map.isActive())
                                break;
                        }
                        setPosition(new Position(position.getRow()-c,position.getCol()));
                        this.steps+=c;
                        return false;
                    }else{
                        for (int i = 0; i <=steps; i++) {
                            score+=map.hasTreasure(new Position(position.getRow()-i,position.getCol()));
                            map.update(new Position(position.getRow()-i,position.getCol()));
                            c=i;
                            if (!map.isActive())
                                break;
                        }
                        setPosition(new Position(position.getRow()-c,position.getCol()));
                        this.steps+=c;
                        return true;
                    }
                }
            case DOWN:
                if (position.getRow()+steps> map.getRows()-1) {
                    if (maxStepAllowed != 0 && this.steps + steps > this.maxStepAllowed) {
                        if (maxStepAllowed-this.steps>map.getRows()-1-position.getRow()){
                            for (int i = 0; i <=map.getRows()-1-position.getRow() ; i++) {
                                score+=map.hasTreasure(new Position(position.getRow()+i,position.getCol()));
                                map.update(new Position(position.getRow()+i,position.getCol()));
                                c=i;
                                if (!map.isActive())
                                    break;
                            }
                            setPosition(new Position(position.getRow()+c,position.getCol()));
                            this.steps+=c;
                        }else {
                            for (int i = 0; i <=maxStepAllowed-this.steps ; i++) {
                                score+=map.hasTreasure(new Position(position.getRow()+i,position.getCol()));
                                map.update(new Position(position.getRow()+i,position.getCol()));
                                c=i;
                                if (!map.isActive())
                                    break;
                            }
                            setPosition(new Position(position.getRow()+c,position.getCol()));
                            this.steps+=c;
                        }
                    }else {
                        for (int i = 0; i <=map.getRows()-1-position.getRow() ; i++) {
                            score+=map.hasTreasure(new Position(position.getRow()+i,position.getCol()));
                            map.update(new Position(position.getRow()+i,position.getCol()));
                            c=i;
                            if (!map.isActive())
                                break;
                        }
                        setPosition(new Position(position.getRow()+c,position.getCol()));
                        this.steps+=c;
                    }
                    return false;
                }else {
                    if (maxStepAllowed != 0 && this.steps + steps > this.maxStepAllowed){
                        for (int i = 0; i <=maxStepAllowed-this.steps ;i++) {
                            score+=map.hasTreasure(new Position(position.getRow()+i,position.getCol()));
                            map.update(new Position(position.getRow()+i,position.getCol()));
                            c=i;
                            if (!map.isActive())
                                break;
                        }
                        setPosition(new Position(position.getRow()+c,position.getCol()));
                        this.steps+=c;
                        return false;
                    }else {
                        for (int i = 0; i <=steps ;i++) {
                            score+=map.hasTreasure(new Position(position.getRow()+i,position.getCol()));
                            map.update(new Position(position.getRow()+i,position.getCol()));
                            c=i;
                            if (!map.isActive()){
                                break;
                            }
                        }
                        setPosition(new Position(position.getRow()+c,position.getCol()));
                        this.steps+=c;
                        return true;
                    }
                }
            case LEFT:
                if (position.getCol()-steps<0) {
                    if (maxStepAllowed != 0 && this.steps + steps > this.maxStepAllowed) {
                        if (maxStepAllowed-this.steps>position.getCol()){
                            for (int i = 0; i <=position.getCol() ; i++) {
                                score+=map.hasTreasure(new Position(position.getRow(),position.getCol()-i));
                                map.update(new Position(position.getRow(),position.getCol()-i));
                                c=i;
                                if (!map.isActive())
                                    break;
                            }
                            setPosition(new Position(position.getRow(),position.getCol()-c));
                            this.steps+=c;
                        }else {
                            for (int i = 0; i <=maxStepAllowed-this.steps ; i++) {
                                score+=map.hasTreasure(new Position(position.getRow(),position.getCol()-i));
                                map.update(new Position(position.getRow(),position.getCol()-i));
                                c=i;
                                if (!map.isActive())
                                    break;
                            }
                            setPosition(new Position(position.getRow(),position.getCol()-c));
                            this.steps+=c;
                        }
                    }else {
                        for (int i = 0; i <=position.getCol() ; i++) {
                            score+=map.hasTreasure(new Position(position.getRow(),position.getCol()-i));
                            map.update(new Position(position.getRow(),position.getCol()-i));
                            c=i;
                            if (!map.isActive())
                                break;
                        }
                        setPosition(new Position(position.getRow(),position.getCol()-c));
                        this.steps+=c;
                    }
                    return false;
                }else {
                    if (maxStepAllowed != 0 && this.steps + steps > this.maxStepAllowed){
                        for (int i = 0; i <=maxStepAllowed-this.steps ; i++) {
                            score+=map.hasTreasure(new Position(position.getRow(),position.getCol()-i));
                            map.update(new Position(position.getRow(),position.getCol()-i));
                            c=i;
                            if (!map.isActive())
                                break;
                        }
                        setPosition(new Position(position.getRow(),position.getCol()-c));
                        this.steps+=c;
                        return false;
                    }else{
                        for (int i = 0; i <=steps ; i++) {
                            score+=map.hasTreasure(new Position(position.getRow(),position.getCol()-i));
                            map.update(new Position(position.getRow(),position.getCol()-i));
                            c=i;
                            if (!map.isActive())
                                break;
                        }
                        setPosition(new Position(position.getRow(),position.getCol()-c));
                        this.steps+=c;
                        return true;
                    }
                }
            case RIGHT:
                if (position.getCol()+steps> map.getColumns()-1-position.getCol()) {
                    if (maxStepAllowed != 0 && this.steps + steps > this.maxStepAllowed) {
                        if (maxStepAllowed-this.steps>map.getColumns()-1-position.getCol()){
                            for (int i = 0; i <=map.getColumns()-1-position.getCol() ; i++) {
                                score+=map.hasTreasure(new Position(position.getRow(),position.getCol()+i));
                                map.update(new Position(position.getRow(),position.getCol()+i));
                                c=i;
                                if (!map.isActive())
                                    break;
                            }
                            setPosition(new Position(position.getRow(),position.getCol()+c));
                            this.steps+=c;
                        }else {
                            for (int i = 0; i <=maxStepAllowed-this.steps ; i++) {
                                score+=map.hasTreasure(new Position(position.getRow(),position.getCol()+i));
                                map.update(new Position(position.getRow(),position.getCol()+i));
                                c=i;
                                if (!map.isActive())
                                    break;
                            }
                            setPosition(new Position(position.getRow(),position.getCol()+c));
                            this.steps+=c;
                        }
                    }else {
                        for (int i = 0; i <=map.getColumns()-1-position.getCol() ; i++) {
                            score+=map.hasTreasure(new Position(position.getRow(),position.getCol()+i));
                            map.update(new Position(position.getRow(),position.getCol()+i));
                            c=i;
                            if (!map.isActive())
                                break;
                        }
                        setPosition(new Position(position.getRow(),position.getCol()+c));
                        this.steps+=c;
                    }
                    return false;
                }else {
                    if (maxStepAllowed != 0 && this.steps + steps > this.maxStepAllowed){
                        for (int i = 0; i <=maxStepAllowed-this.steps ; i++) {
                            score+=map.hasTreasure(new Position(position.getRow(),position.getCol()+i));
                            map.update(new Position(position.getRow(),position.getCol()+i));
                            c=i;
                            if (!map.isActive())
                                break;
                        }setPosition(new Position(position.getRow(),position.getCol()+c));
                        this.steps+=c;
                        return false;
                    }else {
                        for (int i = 0; i <=steps ; i++) {
                            score+=map.hasTreasure(new Position(position.getRow(),position.getCol()+i));
                            map.update(new Position(position.getRow(),position.getCol()+i));
                            c=i;
                            if (!map.isActive())
                                break;
                        }
                        setPosition(new Position(position.getRow(),position.getCol()+c));
                        this.steps+=c;
                        return true;
                    }
                }
        }
        return true;
    }

    public boolean equals(Object player){
        Player p = (Player)player;
        if (player==null)
            return false;
        if (p.id==this.id)
            return true;
        return false;
    }


}
