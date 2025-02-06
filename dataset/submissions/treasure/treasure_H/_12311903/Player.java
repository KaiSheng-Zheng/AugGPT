
public class Player {
    private final int id;
    private static int n=1;
    private  int score;
    private  int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed=-1;
    public Player(Map map,Position initialPos){
                    id=n;
                    n++;
                this.map=map;
                position=initialPos;
                int ini=map.hasTreasure(initialPos);
        score += ini;
        if(ini!=0){
            map.update(initialPos);
    }}
    public Player(Map map,Position initialPos,int maxStepAllowed){
                    id=n;
                    n++;
                this.map=map;
                position=initialPos;
                this.maxStepAllowed=maxStepAllowed;
        int ini=map.hasTreasure(initialPos);
        score += ini;
        if(ini!=0){
            map.update(initialPos);}

    }
    public boolean hasMax(){
        return maxStepAllowed!=-1;
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
        if (map.isActive()) {
            int a;
            if (hasMax()) {
                if (maxStepAllowed >= steps) {
                    if (direction == Direction.UP) {
                        if (position.getRow() - steps >= 0) {
                            this.steps += steps;
                            maxStepAllowed -= steps;
                            for (int i = 0; i < steps; i++) {
                                position.setRow(position.getRow() - 1);
                               a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-= steps-i-1;
                                        break;
                                    }
                                }
                            }
                            return true;
                        }
                    else {
                        this.steps += position.getRow();
                        maxStepAllowed -= position.getRow();
                        int b=position.getRow();
                        for (int i = 0; i <b; i++) {
                            position.setRow(position.getRow() - 1);
                            a =map.hasTreasure(getPosition());
                            score += a;
                            if(a !=0){
                                    map.update(getPosition());
                                if(!map.isActive()){
                                      this.steps-=b-i-1;
                                    break;
                                }
                            }
                        }
                        return false;
                    }}
                if (direction == Direction.DOWN) {
                    if (position.getRow() + steps <= map.getRow()-1) {
                        this.steps += steps;
                        maxStepAllowed -= steps;
                        for (int i = 0; i < steps; i++) {
                            position.setRow(position.getRow() + 1);
                            a =map.hasTreasure(getPosition());
                            score += a;
                            if(a !=0){
                                    map.update(getPosition());
                                if(!map.isActive()){
                                      this.steps-= steps-i-1;
                                    break;
                                }
                            }
                        }
                        return true;
                    } else {
                        this.steps += map.getRow()-1- position.getRow();
                        maxStepAllowed -= map.getRow()-1 - position.getRow();
                        int b=position.getRow();
                        for (int i = 0; i < map.getRow()-1 - b; i++) {
                            position.setRow(position.getRow() + 1);
                            a =map.hasTreasure(getPosition());
                            score += a;
                            if(a !=0){
                                    map.update(getPosition());
                                if(!map.isActive()){
                                      this.steps-= (map.getRow()-1 -b)-i-1;
                                    break;
                                }
                            }
                        }
                        return false;
                    }
                }
                if (direction == Direction.LEFT) {
                    if (position.getCol() - steps >= 0) {
                        this.steps += steps;
                        maxStepAllowed -= steps;
                        for (int i = 0; i < steps; i++) {
                            position.setCol(position.getCol() - 1);
                            a =map.hasTreasure(getPosition());
                            score += a;
                            if(a !=0){
                                    map.update(getPosition());
                                if(!map.isActive()){
                                      this.steps-= steps-i-1;
                                    break;
                                }
                            }
                        }
                        return true;
                    } else {
                        this.steps += position.getCol();
                        maxStepAllowed -= position.getCol();
                        int b=position.getCol();
                        for (int i = 0; i < b; i++) {
                            position.setCol(position.getCol() - 1);
                            a =map.hasTreasure(getPosition());
                            score += a;
                            if(a !=0){
                                    map.update(getPosition());
                                if(!map.isActive()){
                                      this.steps-=b-i-1;
                                    break;
                                }
                            }
                        }
                        return false;
                    }
                }
                if (direction == Direction.RIGHT) {
                    if (position.getCol() + steps <= map.getColumns()-1) {
                        this.steps += steps;
                        maxStepAllowed -= steps;
                        for (int i = 0; i < steps; i++) {
                            position.setCol(position.getCol() + 1);
                            a =map.hasTreasure(getPosition());
                            score += a;
                            if(a !=0){
                                    map.update(getPosition());
                                if(!map.isActive()){
                                      this.steps-=steps-i-1;
                                    break;
                                }
                            }
                        }
                        return true;
                    } else {
                        this.steps += map.getColumns()-1 - position.getCol();
                        maxStepAllowed -= map.getColumns()-1 - position.getCol();
                        int b =position.getCol();
                        for (int i = 0; i < map.getColumns()-1 - b; i++) {
                            position.setCol(position.getCol() + 1);
                            a =map.hasTreasure(getPosition());
                            score += a;
                            if(a !=0){
                                    map.update(getPosition());
                                if(!map.isActive()){
                                      this.steps-=(map.getColumns()-1 -b)-i-1;
                                    break;
                                }
                            }
                        }
                        return false;
                    }
                }}


                else {





                    if (direction == Direction.UP) {
                    if (position.getRow() -maxStepAllowed >= 0) {
                        this.steps += maxStepAllowed;
                        for (int i = 0; i < maxStepAllowed; i++) {
                            position.setRow(position.getRow() - 1);
                             a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=maxStepAllowed-i-1;
                                        break;
                                    }
                                }
                        }
                    }
                    else {
                        this.steps += position.getRow();
                        int b=position.getRow();
                        for (int i = 0; i <b; i++) {
                            position.setRow(position.getRow() - 1);
                             a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=b-i-1;
                                        break;
                                    }
                                }
                        }
                    }
                        maxStepAllowed =0;
                        return false;
                    }


                    if (direction == Direction.DOWN) {
                        if (position.getRow() + maxStepAllowed <= map.getRow()-1) {
                            this.steps += maxStepAllowed;
                            for (int i = 0; i < maxStepAllowed; i++) {
                                position.setRow(position.getRow() + 1);
                                 a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=maxStepAllowed-i-1;
                                        break;
                                    }
                                }
                            }
                        } else {
                            this.steps += map.getRow()-1 - position.getRow();
                            int b=position.getRow();
                            for (int i = 0; i < map.getRow()-1 - b; i++) {
                                position.setRow(position.getRow() + 1);
                                 a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=(map.getRow()-1 - b)-i-1;
                                        break;
                                    }
                                }
                            }
                        }
                        maxStepAllowed =0;
                        return false;
                    }
                    if (direction == Direction.LEFT) {
                        if (position.getCol() -maxStepAllowed >= 0) {
                            this.steps += maxStepAllowed;
                            for (int i = 0; i < maxStepAllowed; i++) {
                                position.setCol(position.getCol() - 1);
                                 a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=maxStepAllowed-i-1;
                                        break;
                                    }
                                }
                            }
                        } else {
                            this.steps += position.getCol();
                            int b=position.getCol();
                            for (int i = 0; i < b; i++) {
                                position.setCol(position.getCol() - 1);
                                 a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=b-i-1;
                                        break;
                                    }
                                }
                            }
                        }
                        maxStepAllowed =0;
                        return false;
                    }
                    if (direction == Direction.RIGHT) {
                        if (position.getCol() +maxStepAllowed <= map.getColumns()-1) {
                            this.steps += maxStepAllowed;
                            for (int i = 0; i < maxStepAllowed; i++) {
                                position.setCol(position.getCol() + 1);
                                 a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=maxStepAllowed-i-1;
                                        break;
                                    }
                                }
                            }
                        } else {
                            this.steps += map.getColumns()-1 - position.getCol();
                            int b =position.getCol();
                            for (int i = 0; i < map.getColumns()-1 - b; i++) {
                                position.setCol(position.getCol() + 1);
                                 a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=(map.getColumns()-1 -b)   -i-1;
                                        break;
                                    }
                                }
                            }
                        }
                        maxStepAllowed =0;
                        return false;
                    }

                }


            }

        else {

            if (direction == Direction.UP) {
                if (position.getRow() - steps >= 0) {
                    this.steps += steps;
                    for (int i = 0; i < steps; i++) {
                        position.setRow(position.getRow() - 1);
                         a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=steps   -i-1;
                                        break;
                                    }
                                }
                    }
                    return true;
                } else {
                    this.steps += position.getRow();
                    int b=position.getRow();
                    for (int i = 0; i < b; i++) {
                        position.setRow(position.getRow() - 1);
                         a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=b   -i-1;
                                        break;
                                    }
                                }
                    }
                    return false;
                }
            }

            if (direction == Direction.DOWN) {
                if (position.getRow() + steps <=map.getRow()-1) {
                    this.steps += steps;
                    for (int i = 0; i < steps; i++) {
                        position.setRow(position.getRow() + 1);
                         a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=steps -i-1;
                                        break;
                                    }
                                }
                    }
                    return true;
                } else {
                    this.steps += map.getRow()-1 - position.getRow();
                    int b=position.getRow();
                    for (int i = 0; i < map.getRow()-1 - b; i++) {
                        position.setRow(position.getRow() + 1);
                         a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=(map.getRow()-1 -b)-i-1;
                                        break;
                                    }
                                }
                    }
                    return false;
                }
            }
            if (direction == Direction.LEFT) {
                if (position.getCol() - steps >= 0) {
                    this.steps += steps;
                    for (int i = 0; i < steps; i++) {
                        position.setCol(position.getCol()- 1);
                         a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=steps-i-1;
                                        break;
                                    }
                                }
                    }
                    return true;
                } else {
                    this.steps += position.getCol();
                    int b=position.getCol();
                    for (int i = 0; i < b; i++) {
                        position.setCol(position.getCol() - 1);
                         a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=b-i-1;
                                        break;
                                    }
                                }
                    }
                    return false;
                }
            }
            if (direction == Direction.RIGHT) {
                if (position.getCol() + steps <= map.getColumns()-1) {

                    this.steps += steps;
                    for (int i = 0; i < steps; i++) {
                        position.setCol(position.getCol() + 1);
                         a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=steps-i-1;
                                        break;
                                    }
                                }
                    }
                    return true;
                } else {
                    this.steps += map.getColumns()-1 - position.getCol();
                    int b=position.getCol();
                    for (int i = 0; i < map.getColumns()-1 - b; i++) {
                        position.setCol(position.getCol() + 1);
                         a =map.hasTreasure(getPosition());
                                score += a;
                                if(a !=0){
                                    map.update(getPosition());
                                    if(!map.isActive()){
                                      this.steps-=(map.getColumns()-1 -b)-i-1;
                                        break;
                                    }
                                }
                    }
                    return false;
                }
            }
        }
        }
        return false;
    }
    @Override
        public boolean equals (Object player){
            Player p=(Player)player;
        return this.id == p.getId();
        }


    }
