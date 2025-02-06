public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    static int count = 0 ;
    private int maxStepAllowed;

    private int anothersum = 0;

    public int getAnothersum() {
        return anothersum;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        steps = anothersum;
        return steps;
    }


    public Position getPosition() {
        return position;
    }

    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }
    public boolean move(Direction direction, int steps){
        if (map.isActive()){
            int newrow = position.getRow();
            int newcol = position.getCol();
            switch (direction){
                case UP -> {
                    if ((position.getRow()-steps)<0||maxStepAllowed - steps<0){
                        while (newrow-1>=0&&maxStepAllowed-1>=0&& map.isActive()){
                            position.setRow(position.getRow()-1);
                            maxStepAllowed = maxStepAllowed - 1;
                            score+=map.hasTreasure(position);
                            map.update(position);
                            anothersum++;
                            newrow --;
                        }return false;
                    }else {
                        for (int i = steps;i>0;i--){
                            if (map.isActive()){
                                position.setRow(position.getRow()-1);
                                maxStepAllowed = maxStepAllowed - 1;
                                score+=map.hasTreasure(position);
                                map.update(position);
                                anothersum++;
                            }
                        }
                    }return true;
                }
                case DOWN ->{
                    if ((position.getRow()+steps)>=map.getRows()||maxStepAllowed - steps<0){
                        while (newrow+1<map.getRows()&&maxStepAllowed-1>=0&& map.isActive()){
                            position.setRow(position.getRow()+1);
                            maxStepAllowed = maxStepAllowed - 1;
                            score+=map.hasTreasure(position);
                            map.update(position);
                            anothersum++;
                            newrow ++;
                        }return false;
                    }else {
                        for (int i = steps;i>0;i--){
                            if (map.isActive()){
                                position.setRow(position.getRow()+1);
                                maxStepAllowed = maxStepAllowed - 1;
                                score+=map.hasTreasure(position);
                                map.update(position);
                                anothersum++;
                            }
                        }
                    }return true;
                }

                case LEFT ->{
                    if ((position.getCol()+1-steps)<=0||maxStepAllowed - steps<0){
                        while (newcol-1>=0&&maxStepAllowed-1>=0&&map.isActive()){
                            position.setCol(position.getCol()-1);
                            maxStepAllowed = maxStepAllowed - 1;
                            score+=map.hasTreasure(position);
                            map.update(position);
                            anothersum++;
                            newcol --;
                        }return false;
                    }else {
                        for (int i = steps;i>0;i--){
                            if (map.isActive()){
                                position.setCol(position.getCol()-1);
                                maxStepAllowed = maxStepAllowed - 1;
                                score+=map.hasTreasure(position);
                                map.update(position);
                                anothersum++;
                            }
                        }
                    }return true;
                }
                case RIGHT ->{
                    if ((position.getCol()+steps)>=map.getColumns()||maxStepAllowed - steps<0){
                        while (newcol+1<map.getColumns()&&maxStepAllowed-1>=0&& map.isActive()){
                            position.setCol(position.getCol()+1);
                            maxStepAllowed = maxStepAllowed - 1;
                            score+=map.hasTreasure(position);
                            map.update(position);
                            anothersum++;
                            newcol ++;
                        }return false;
                    }else {
                        for (int i = steps;i>0;i--){
                            if (map.isActive()){
                                position.setCol(position.getCol()+1);
                                maxStepAllowed = maxStepAllowed - 1;
                                score+=map.hasTreasure(position);
                                map.update(position);
                                anothersum++;
                            }
                        }
                    }return true;
                }
            }
        }return false;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return id == p.id;
    }
}
