import java.util.ArrayList;
public class Player {
    static int count = 1;
    private int maxstep = -1;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        id=++count;

        score = 0;
        steps = 0;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxstep = maxStepAllowed;
        id=++count;
    }

    public boolean move(Direction direction, int steps) {
        if (map.isActive() == false) {
            return false;
        }
        else if((maxstep==0)&(steps==0)) {
            return true;
        }
        else if ((maxstep >0) & (steps == maxstep)) {
            return false;
        }
        else {
            if (direction == Direction.UP) {
                int asteps = 0;
                while ((map.isActive() == true) & ((maxstep < 0) | ((maxstep > 0) & (this.steps < maxstep))) & (position.getRow() > 0)&(asteps<steps)) {
                    position.setRow(position.getRow() - 1);
                    this.steps += 1;
                    asteps += 1;
                    //boolean baozang=false;
                    for (Treasure x : map.getDtreasures()) {
                        if ((position.getRow() == x.getPosition().getRow()) & (position.getCol() == x.getPosition().getCol())) {
                            //baozang=true;
                            score += x.getScore();
                            if (map.getDtreasures().indexOf(x) != -1) {
                                //System.out.println(map.getDtreasures().get(map.getDtreasures().indexOf(x)).getPosition());
                                map.update(map.getDtreasures().get(map.getDtreasures().indexOf(x)).getPosition());
                                break;
                            }
                        }
                    }
                }
                //System.out.println(asteps);
                //System.out.println(steps);
                if (asteps == steps) {
                    return true;
                } else {
                    return false;
                }
            }
            if (direction == Direction.DOWN) {
                int asteps = 0;
                while ((map.isActive() == true) & ((maxstep < 0) | ((maxstep > 0) & (this.steps < maxstep))) & (position.getRow()+1< map.getRows())&(asteps<steps)) {
                    position.setRow(position.getRow() + 1);
                    this.steps += 1;
                    asteps += 1;
                    //boolean baozang=false;
                    for (Treasure x : map.getDtreasures()) {
                        if ((position.getRow() == x.getPosition().getRow()) & (position.getCol() == x.getPosition().getCol())) {
                            //baozang=true;
                            score += x.getScore();
                            if (map.getDtreasures().indexOf(x) != -1) {
                                map.update(map.getDtreasures().get(map.getDtreasures().indexOf(x)).getPosition());
                                break;
                            }
                        }
                    }
                }
                //System.out.println(asteps);
                //System.out.println(steps);
                if (asteps == steps) {
                    return true;
                } else {
                    return false;
                }
            }
            if (direction == Direction.LEFT) {
                int asteps = 0;
                while ((map.isActive() == true) & ((maxstep < 0) | ((maxstep > 0) & (this.steps < maxstep))) & (position.getCol() > 0)&(asteps<steps)) {
                    position.setCol(position.getCol() - 1);
                    this.steps += 1;
                    asteps += 1;
                    //boolean baozang=false;
                    for (Treasure x : map.getDtreasures()) {
                        if ((position.getRow() == x.getPosition().getRow()) & (position.getCol() == x.getPosition().getCol())) {
                            //baozang=true;
                            score += x.getScore();
                            if (map.getDtreasures().indexOf(x) != -1) {
                                map.update(map.getDtreasures().get(map.getDtreasures().indexOf(x)).getPosition());
                                break;
                            }
                        }
                    }
                }
                if (asteps == steps) {
                    return true;
                } else {
                    return false;
                }
            }
            if (direction == Direction.RIGHT) {
                int asteps = 0;
                while ((map.isActive() == true) & ((maxstep < 0) | ((maxstep > 0) & (this.steps < maxstep))) & (position.getCol()+1< map.getColumns())&(asteps<steps)) {
                    position.setCol(position.getCol() + 1);
                    this.steps += 1;
                    asteps += 1;
                    //boolean baozang=false;
                    for (Treasure x : map.getDtreasures()) {
                        if ((position.getRow() == x.getPosition().getRow()) & (position.getCol() == x.getPosition().getCol())) {
                            //baozang=true;
                            score += x.getScore();
                            if (map.getDtreasures().indexOf(x) != -1) {
                                map.update(map.getDtreasures().get(map.getDtreasures().indexOf(x)).getPosition());
                                break;
                            }
                        }
                    }
                }
                //System.out.println(asteps);
                //System.out.println(steps);
                if (asteps == steps) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public int getScore(){
        return score;
    }
    public int getSteps(){
        return steps;
    }
    public Position getPosition(){
        return position;
    }

    public int getId() {
        return id;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if(this.id==p.id){
            return true;
        }
        return false;
    }
}