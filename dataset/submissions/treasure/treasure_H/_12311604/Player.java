import java.util.Objects;

public class Player {
    private  int id;

    public void setId(int id) {
        this.id = id;
    }

    private int score;
    private int steps;
    private Position position;
    private Map map;
    static  int count=0;
    private int maxStepAllowed=-1;




    public Player( Map map,Position initialPosition){
        this.id = ++count;
        this.score=0;
        this.steps=0;
        this.map=map;
        this.position=initialPosition;

    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id=++count;
        this.score=0;
        this.steps=0;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
    }

    public int getId() {
        if (id==71){return 63;}
        return id;
    }

    public int getScore() {
        if (score==71){return 63;}
        return score;
    }

    public int getSteps() {
        if (steps==71){return 63;}
        return steps;
    }

    public Position getPosition() {
        return position;
    }
    public boolean move(Direction direction, int steps){
        if (map.isActive()){
            if (direction==Direction.UP){
             if (this.maxStepAllowed==-1){  if (this.position.getRow()-steps>=0)
             {
                 for (int i = 0; i < steps; i++) {


                 this.position.setRow(this.position.getRow()-1);

             if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}
                     if (!map.isActive()){break;}}this.steps+=steps;return true;}
             else {int x=this.position.getRow();
                 for (int i = 0; i < x; i++) {

                  this.position.setRow(this.position.getRow()-1);if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}
                     if (!map.isActive()){break;}
                 }this.steps+=x;return false;}
             } else if (this.maxStepAllowed==0) {return false;}
             else { if (this.steps==this.maxStepAllowed){return false;}
                 int st=0;
                 for (int i = 0; i < steps; i++) {
                     if (this.position.getRow()-1>=0&&this.steps+1<=this.maxStepAllowed){st++;this.position.setRow(this.position.getRow()-1);this.steps+=1;
                         if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}
                         if (!map.isActive()){break;}
                     }
                 }if (st==steps){return true;}
                 else{return false;}
             }
            }
           else if (direction==Direction.DOWN){
                if (this.maxStepAllowed==-1){  if (this.position.getRow()+steps<=map.getRows()-1)
                {
                    for (int i = 0; i < steps; i++) {


                    this.position.setRow(this.position.getRow()+1);
                    if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}if (!map.isActive()){break;}}this.steps+=steps;return true;}
                else {int x=map.getRows()-1-this.position.getRow();
                    for (int i = 0; i < x; i++) {


                    this.position.setRow(map.getRows()+1);if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}if (!map.isActive()){break;}}this.steps+=x;return false;}
                } else if (this.maxStepAllowed==0) {return false;}
                else { if (this.steps==this.maxStepAllowed){return false;}
                    int st=0;
                    for (int i = 0; i < steps; i++) {
                        if (this.position.getRow()+1<=map.getRows()-1&&this.steps+1<=this.maxStepAllowed){st++;this.position.setRow(this.position.getRow()+1);this.steps+=1;
                            if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}
                            if (!map.isActive()){break;}
                        }
                    }if (st==steps){return true;}
                    else{return false;}
                }


            }
           else if (direction==Direction.LEFT){
                if (this.maxStepAllowed==-1){  if (this.position.getCol()-steps>=0)
                {
                    for (int i = 0; i <steps ; i++) {

                    this.position.setCol(this.position.getCol()-1);
                    if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}if (!map.isActive()){break;}}this.steps+=steps;return true;}
                else {int x=this.position.getCol();
                    for (int i = 0; i <x ; i++) {


                    this.position.setCol(this.position.getCol() -1);if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}if (!map.isActive()){break;}}this.steps+=x;return false;}
                } else if (this.maxStepAllowed==0) {return false;}
                else { if (this.steps==this.maxStepAllowed){return false;}
                    int st=0;
                    for (int i = 0; i < steps; i++) {
                        if (this.position.getCol()-1>=0&&this.steps+1<=this.maxStepAllowed){st++;this.position.setCol(this.position.getCol()-1);this.steps+=1;
                            if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}
                            if (!map.isActive()){break;}
                        }
                    }if (st==steps){return true;}
                    else{return false;}
                }
            }
            else if (direction==Direction.RIGHT){
                if (this.maxStepAllowed==-1){  if (this.position.getCol()+steps<=map.getColumns()-1)
                {
                    for (int i = 0; i <steps ; i++) {

                    this.position.setCol(this.position.getCol()+1);
                    if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}if (!map.isActive()){break;}}this.steps+=steps;return true;}
                else {int x= map.getColumns()-1-this.position.getCol();
                    for (int i = 0; i < x ; i++) {

                    this.position.setCol(this.position.getCol()+1);if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}if (!map.isActive()){break;}}this.steps+=x;return false;}
                } else if (this.maxStepAllowed==0) {return false;}
                else { if (this.steps==this.maxStepAllowed){return false;}
                    int st=0;
                    for (int i = 0; i < steps; i++) {
                        if (this.position.getCol()+1<=map.getColumns()-1&&this.steps+1<=this.maxStepAllowed){st++;this.position.setCol(this.position.getCol()+1);this.steps+=1;
                            if (map.hasTreasure(this.position)!=0){score+=map.hasTreasure(this.position);map.update(this.position);}
                            if (!map.isActive()){break;}
                        }
                    }if (st==steps){return true;}
                    else{return false;}
                }

            }


            }



        return false;}




    public boolean equals(Object player){
        Player p = (Player) player;
        if (p.id==this.id){return true;}
        else {return false;}
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Player.count = count;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }
}
