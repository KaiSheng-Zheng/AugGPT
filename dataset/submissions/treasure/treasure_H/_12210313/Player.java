public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private static int idi = 0;
    private int usingSteps;
    public Player(Map map, Position initialPosition){
        this.position = initialPosition;
        idi ++;
        this.id = idi;
        this.steps = -1;
        this.map = map;}
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.position = initialPosition;
        idi ++;
        this.id = idi;
        this.map = map;
        this.steps = maxStepAllowed;}
    public boolean move(Direction direction, int steps){
        int oneSteps = 0;
        Direction[] directions = Direction.values();
        if (this.steps == -1){


            if (direction.equals(directions[0])) {
                for (int i = 0; i < steps; i++) {
                    if (this.position.getRow() - 1 < 0) {
                        break;
                    }else {
                        this.position.setRow(this.position.getRow() - 1);
                        usingSteps += 1;
                        oneSteps += 1;
                        if (map.hasExist(this.position)){
                        score += map.hasTreasure(this.position);
                        map.update(this.position);
                        }
                        if (!map.isActive()){
                            break;}}}
                return oneSteps == steps;
            }
            else if (direction.equals(directions[1])) {
                for (int i = 0; i < steps; i++) {
                    if (this.position.getRow() + 1 > map.getRows()) {
                        break;
                    }else {
                        this.position.setRow(this.position.getRow() + 1);
                        usingSteps += 1;
                        oneSteps += 1;
                        if (map.hasExist(this.position)){
                            score += map.hasTreasure(this.position);
                            map.update(this.position);}
                        if (!map.isActive()){
                            break;}}}
                return oneSteps == steps;
            }
            else if (direction.equals(directions[2])) {
                for (int i = 0; i < steps; i++) {
                    if (this.position.getCol() - 1 < 0) {
                        break;
                    }else {
                        this.position.setCol(this.position.getCol() - 1);
                        usingSteps += 1;
                        oneSteps += 1;
                        if (map.hasExist(this.position)){
                            score += map.hasTreasure(this.position);
                            map.update(this.position);}
                        if (!map.isActive()){
                            break;}}}
                return oneSteps == steps;
            }
            else if (direction.equals(directions[3])) {
                for (int i = 0; i < steps; i++) {
                    if (this.position.getCol() + 1 > map.getColumns()) {
                        break;
                    }else {
                        this.position.setCol(this.position.getCol() + 1);
                        usingSteps += 1;
                        oneSteps += 1;
                        if (map.hasExist(this.position)){
                            score += map.hasTreasure(this.position);
                            map.update(this.position);}
                        if (!map.isActive()){
                            break;}}}
                return oneSteps == steps;}
        }
        else {

            if (this.steps < steps && this.steps >= 0){
                if (direction.equals(directions[0])) {
                    for (int i = 0; i < this.steps; i++) {
                        if (this.position.getRow() - 1 < 0) {
                            break;
                        }else {
                            this.position.setRow(this.position.getRow() - 1);
                            usingSteps += 1;
                            if (map.hasExist(this.position)){
                                score += map.hasTreasure(this.position);
                                map.update(this.position);}
                            if (!map.isActive()){
                                break;}}}
                }
                else if (direction.equals(directions[1])) {
                    for (int i = 0; i < this.steps; i++) {
                        if (this.position.getRow() + 1 > map.getRows()) {
                            break;
                        }else {
                            this.position.setRow(this.position.getRow() + 1);
                            usingSteps += 1;
                            if (map.hasExist(this.position)){
                                score += map.hasTreasure(this.position);
                                map.update(this.position);}
                            if (!map.isActive()){
                                break;}}}
                }
                else if (direction.equals(directions[2])) {
                    for (int i = 0; i < this.steps; i++) {
                        if (this.position.getCol() - 1 < 0) {
                            break;
                        }else {
                            this.position.setCol(this.position.getCol() - 1);
                            usingSteps += 1;
                            if (map.hasExist(this.position)){
                                score += map.hasTreasure(this.position);
                                map.update(this.position);}
                            if (!map.isActive()){
                                break;}}}
                }
                else if (direction.equals(directions[3])) {
                    for (int i = 0; i < this.steps; i++) {
                        if (this.position.getCol() + 1 > map.getColumns()) {
                            break;
                        }else {
                            this.position.setCol(this.position.getCol() + 1);
                            usingSteps += 1;
                            if (map.hasExist(this.position)){
                                score += map.hasTreasure(this.position);
                                map.update(this.position);}
                            if (!map.isActive()){
                                break;}}}
                }
                return false;
            }else {
                if (direction.equals(directions[0])) {
                    for (int i = 0; i < steps; i++) {
                        if (this.position.getRow() - 1 < 0) {
                            break;
                        }else {
                            this.position.setRow(this.position.getRow() - 1);
                            usingSteps += 1;
                            oneSteps += 1;
                            if (map.hasExist(this.position)){
                                score += map.hasTreasure(this.position);
                                map.update(this.position);}
                            if (!map.isActive()){
                                break;}}}
                    this.steps -= oneSteps;
                    return oneSteps == steps;
                }
                else if (direction.equals(directions[1])) {
                    for (int i = 0; i < steps; i++) {
                        if (this.position.getRow() + 1 > map.getRows()) {
                            break;
                        }else {
                            this.position.setRow(this.position.getRow() + 1);
                            usingSteps += 1;
                            oneSteps += 1;
                            if (map.hasExist(this.position)){
                                score += map.hasTreasure(this.position);
                                map.update(this.position);}
                            if (!map.isActive()){
                                break;}}}
                    this.steps -= oneSteps;
                    return oneSteps == steps;
                }
                else if (direction.equals(directions[2])) {
                    for (int i = 0; i < steps; i++) {
                        if (this.position.getCol() - 1 < 0) {
                            break;
                        }else {
                            this.position.setCol(this.position.getCol() - 1);
                            usingSteps += 1;
                            oneSteps += 1;
                            if (map.hasExist(this.position)){
                                score += map.hasTreasure(this.position);
                                map.update(this.position);}
                            if (!map.isActive()){
                                break;}}}
                    this.steps -= oneSteps;
                    return oneSteps == steps;
                }
                else if (direction.equals(directions[3])) {
                    for (int i = 0; i < steps; i++) {
                        if (this.position.getCol() + 1 > map.getColumns()) {
                            break;
                        }else {
                            this.position.setCol(this.position.getCol() + 1);
                            usingSteps += 1;
                            oneSteps += 1;
                            if (map.hasExist(this.position)){
                                score += map.hasTreasure(this.position);
                                map.update(this.position);}
                            if (!map.isActive()){
                                break;}}}
                    this.steps -= oneSteps;
                    return oneSteps == steps;}

            }
        }
return false;
        }

public boolean equals(Object player){
        Player p = (Player) player;
        return this.id == p.getId();
    }

public int getScore(){
        return score;
}
    public int getSteps(){
        return usingSteps;
    }
public Position getPosition(){
        return position;
}
public int getId(){
        return id;
}


}