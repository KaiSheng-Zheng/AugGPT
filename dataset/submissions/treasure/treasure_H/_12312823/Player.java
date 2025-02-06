



public class Player {
    private final int id;
    private int score;
    private int steps=0;
    private Position position;
    private Map map;
private int maxStepAllowed;
static int count=0;
    public Player(Map map, Position initialPos){
        this.position = initialPos;
        this.map = map;
         this.id=++count;
    maxStepAllowed=Integer.MAX_VALUE;
    }
    public Player(Map map, Position initialPos, int maxStepAllowed){
        this.position = initialPos;
        this.map = map;
        this.id=++count;
       this.maxStepAllowed=maxStepAllowed;

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

    public Position getPos() {
        return position;
    }
    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }
        if (steps > maxStepAllowed) {
            int newRow = position.getRow();
            int newCol = position.getCol();
int or=newRow;
int oc=newCol;

            switch (direction) {
                case UP:
                    newRow -= maxStepAllowed;
                    break;
                case DOWN:
                    newRow += maxStepAllowed;
                    break;
                case LEFT:
                    newCol -= maxStepAllowed;
                    break;
                case RIGHT:
                    newCol += maxStepAllowed;
                    break;
            }
            if (newRow < 0 || newRow > map.getRows() - 1 || newCol < 0 || newCol > map.getColumns() - 1) {

                if (newRow < 0) {
                    newRow = 0;
                }
                if (newRow >= map.getRows() - 1) {
                    newRow = map.getRows() - 1;
                }
                if (newCol < 0) {
                    newCol = 0;
                }
                if (newCol >= map.getColumns() - 1) {
                    newCol = map.getColumns() - 1;
                }

                this.steps+=Math.abs(newRow-or)+Math.abs(newCol-oc);
maxStepAllowed-=Math.abs(newRow-or)+Math.abs(newCol-oc);

                if (newRow==or){
                    int start = Math.min(newCol, oc);
                    int end = Math.max(newCol, oc);
                    for(int i=start;i<=end;i++){
                        position.setCol(i);
                        int treasureScore = map.hasTreasure(position);
                        if (treasureScore > 0) {
                            score += treasureScore;
                            map.update(position);
                            if (!map.isActive()&&i!=newCol) {
                                return false;}
                        }

                    }

              position.setCol(newCol);  }

                if (newCol==oc){
                    int start = Math.min(newRow, or);
                    int end = Math.max(newRow, or);
                    for(int i=start;i<=end;i++){
                        position.setRow(i);
                        int treasureScore = map.hasTreasure(position);
                        if (treasureScore > 0) {
                            score += treasureScore;
                            map.update(position);
                            if (!map.isActive()&&i!=newRow) {
                                return false;}
                        }

                    }
position.setRow(newRow);
                }




                return false;

            }

            else {



                this.steps+=Math.abs(newRow-or)+Math.abs(newCol-oc);
                maxStepAllowed-=Math.abs(newRow-or)+Math.abs(newCol-oc);
                if (newRow==or){
                    int start = Math.min(newCol, oc);
                    int end = Math.max(newCol, oc);
                    for(int i=start;i<=end;i++){
                        position.setCol(i);
                        int treasureScore = map.hasTreasure(position);
                        if (treasureScore > 0) {
                            score += treasureScore;
                            map.update(position);
                            if (!map.isActive()&&i!=newCol) {
                                return false;}
                        }

                    }
position.setCol(newCol);
                }

                if (newCol==oc){
                    int start = Math.min(newRow, or);
                    int end = Math.max(newRow, or);
                    for(int i=start;i<=end;i++){
                        position.setRow(i);
                        int treasureScore = map.hasTreasure(position);
                        if (treasureScore > 0) {
                            score += treasureScore;
                            map.update(position);
                            if (!map.isActive()&&i!=newRow) {
                                return false;}
                        }

                    }
position.setRow(newRow);
                }




                return false;
                }
            }


        if (steps <= maxStepAllowed) {
            int newRow = position.getRow();
            int newCol = position.getCol();
            int or=newRow;
            int oc=newCol;
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

            if (newRow < 0 || newRow > map.getRows()-1 || newCol < 0 || newCol > map.getColumns()-1) {

                if (newRow < 0) {
                    newRow = 0;
                }
                if (newRow >= map.getRows() - 1) {
                    newRow = map.getRows() - 1;
                }
                if (newCol < 0) {
                    newCol = 0;
                }
                if (newCol >= map.getColumns() - 1) {
                    newCol = map.getColumns() - 1;
                }

                this.steps+=Math.abs(newRow-or)+Math.abs(newCol-oc);
                maxStepAllowed-=Math.abs(newRow-or)+Math.abs(newCol-oc);
                if (newRow==or){
                    int start = Math.min(newCol, oc);
                    int end = Math.max(newCol, oc);
                    for(int i=start;i<=end;i++){
                        position.setCol(i);
                        int treasureScore = map.hasTreasure(position);
                        if (treasureScore > 0) {
                            score += treasureScore;
                            map.update(position);
                            if (!map.isActive()&&i!=newCol) {
                                return false;}
                        }

                    }

             position.setCol(newCol);   }

                if (newCol==oc){
                    int start = Math.min(newRow, or);
                    int end = Math.max(newRow, or);
                    for(int i=start;i<=end;i++){
                        position.setRow(i);
                        int treasureScore = map.hasTreasure(position);
                        if (treasureScore > 0) {
                            score += treasureScore;
                            map.update(position);
                            if (!map.isActive()&&i!=newRow) {
                                return false;}
                        }

                    }

               position.setRow(newRow); }

                return false;
            }

         else {


                this.steps+=Math.abs(newRow-or)+Math.abs(newCol-oc);
                maxStepAllowed-=Math.abs(newRow-or)+Math.abs(newCol-oc);
                if (newRow==or){
                    int start = Math.min(newCol, oc);
                    int end = Math.max(newCol, oc);
                    for(int i=start;i<=end;i++){
                        position.setCol(i);
                        int treasureScore = map.hasTreasure(position);
                        if (treasureScore > 0) {
                            score += treasureScore;
                            map.update(position);
                            if (!map.isActive()&&i!=newCol) {
                                return false;}
                        }

                    }
position.setCol(newCol);
                }

                if (newCol==oc){
                    int start = Math.min(newRow, or);
                    int end = Math.max(newRow, or);
                    for(int i=start;i<=end;i++){
                        position.setRow(i);
                        int treasureScore = map.hasTreasure(position);
                        if (treasureScore > 0) {
                            score += treasureScore;
                            map.update(position);
                            if (!map.isActive()&&i!=newRow) {
                                return false;}
                        }

                    }

               position.setRow(newRow); }





                return true;
            }

            }

         return true;

        }
































    public boolean equals(Object player){
        Player P = (Player) player;
        return id == P.id ;
    }


    public Object getPosition() {
        return position;
    }
}
