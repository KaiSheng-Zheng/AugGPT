public class Player{
    private final int id;
    private int score;
    private int steps;
    private int isteps;
    private Position position;
    private Map map;
    private static int pn=0;
    public Player(Map map,Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.steps=99999999;
        isteps=steps;
        pn++;
        id=pn;
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.steps=maxStepAllowed;
        isteps=steps;
        pn++;
        id=pn;
    }
    public boolean move(Direction direction,int step){
        if(steps>0){
            if(map.isActive()==true){
                if(direction.toString()=="UP"){
                    if(position.getRow()==0){
                        return false;
                    }
                    else{
                        if(step>position.getRow()&&steps>position.getRow()||step>position.getRow()&&steps==position.getRow()||step==position.getRow()&&steps>position.getRow()||step==position.getRow()&&steps==position.getRow()){
                            steps-=position.getRow();
                            int a=position.getRow();
                            for(int i=0;i<=a;i++){
                                int x=a-i;
                                position.setRow(x);
                                score+=map.hasTreasure(position);                                
                            }
                            return false;
                        }
                        if(step<position.getRow()&&steps>step||step<position.getRow()&&steps==step){
                            steps-=step;
                            int a=position.getRow();
                            for(int i=0;i<=step;i++){
                                int x=a-i;
                                position.setRow(x);
                                score+=map.hasTreasure(position);                                
                            }
                            return true;
                        }
                        if(step>position.getRow()&&steps<position.getRow()||step==position.getRow()&&steps<position.getRow()){
                            int a=position.getRow();
                            for(int i=0;i<=steps;i++){
                                int x=a-i;
                                position.setRow(x);
                                score+=map.hasTreasure(position);                                
                            }
                            steps=0;
                            return false;
                        }
                        if(step<position.getRow()&&steps<step){
                            int a=position.getRow();
                            for(int i=0;i<=steps;i++){
                                int x=a-i;
                                position.setRow(x);
                                score+=map.hasTreasure(position);                                
                            }
                            steps=0;
                            return false;
                        }                                                                        
                        return false;
                    }
                    }
                if(direction.toString()=="DOWN"){
                    if(position.getRow()==map.getRows()){
                        return false;
                    }
                    else{
                        if(step>map.getRows()-position.getRow()&&steps>map.getRows()-position.getRow()||step>map.getRows()-position.getRow()&&steps==map.getRows()-position.getRow()||step==map.getRows()-position.getRow()&&steps>map.getRows()-position.getRow()||step==map.getRows()-position.getRow()&&steps==map.getRows()-position.getRow()){
                            steps-=map.getRows()-position.getRow();
                            int a=position.getRow();
                            for(int i=0;i<=map.getRows()-a;i++){
                                int x=a+i;
                                position.setRow(x);
                                score+=map.hasTreasure(position);                                
                            }
                            return false;
                        }
                        if(step<map.getRows()-position.getRow()&&steps>step||step<map.getRows()-position.getRow()&&steps==step){
                            steps-=step;
                            int a=position.getRow();
                            for(int i=0;i<=step;i++){
                                int x=a+i;
                                position.setRow(x);
                                score+=map.hasTreasure(position);                                
                            }
                            return true;
                        }
                        if(step>map.getRows()-position.getRow()&&steps<map.getRows()-position.getRow()||step==map.getRows()-position.getRow()&&steps<map.getRows()-position.getRow()){
                            int a=position.getRow();
                            for(int i=0;i<=steps;i++){
                                int x=a+i;
                                position.setRow(x);
                                score+=map.hasTreasure(position);                                
                            }
                            steps=0;
                            return false;
                        }
                        if(step<map.getRows()-position.getRow()&&steps<step){
                            int a=position.getRow();
                            for(int i=0;i<=steps;i++){
                                int x=a+i;
                                position.setRow(x);
                                score+=map.hasTreasure(position);                                
                            }
                            steps=0;
                            return false;
                        }                                                                        
                        return false;
                    }
                    }
                if(direction.toString()=="LEFT"){
                    if(position.getCol()==0){
                        return false;
                    }
                    else{
                        if(step>position.getCol()&&steps>position.getCol()||step>position.getCol()&&steps==position.getCol()||step==position.getCol()&&steps>position.getCol()||step==position.getCol()&&steps==position.getCol()){
                            steps-=position.getCol();
                            int a=position.getCol();
                            for(int i=0;i<=a;i++){
                                int x=a-i;
                                position.setCol(x);
                                score+=map.hasTreasure(position);                                
                            }
                            return false;
                        }
                        if(step<position.getCol()&&steps>step||step<position.getCol()&&steps==step){
                            steps-=step;
                            int a=position.getCol();
                            for(int i=0;i<=step;i++){
                                int x=a-i;
                                position.setCol(x);
                                score+=map.hasTreasure(position);                                
                            }
                            return true;
                        }
                        if(step>position.getCol()&&steps<position.getCol()||step==position.getCol()&&steps<position.getCol()){
                            int a=position.getCol();
                            for(int i=0;i<=steps;i++){
                                int x=a-i;
                                position.setCol(x);
                                score+=map.hasTreasure(position);                                
                            }
                            steps=0;
                            return false;
                        }
                        if(step<position.getCol()&&steps<step){
                            int a=position.getCol();
                            for(int i=0;i<=steps;i++){
                                int x=a-i;
                                position.setCol(x);
                                score+=map.hasTreasure(position);                                
                            }
                            steps=0;
                            return false;
                        }                                                                        
                        return false;
                    }
                    }
                if(direction.toString()=="RIGHT"){
                    if(position.getCol()==map.getColumns()){
                        return false;
                    }
                    else{
                        if(step>map.getColumns()-position.getCol()&&steps>map.getColumns()-position.getCol()||step>map.getColumns()-position.getCol()&&steps==map.getColumns()-position.getCol()||step==map.getColumns()-position.getCol()&&steps>map.getColumns()-position.getCol()||step==map.getColumns()-position.getCol()&&steps==map.getColumns()-position.getCol()){
                            steps-=map.getColumns()-position.getCol();
                            int a=position.getCol();
                            for(int i=0;i<=map.getColumns()-a;i++){
                                int x=a+i;
                                position.setCol(x);
                                score+=map.hasTreasure(position);                                
                            }
                            return false;
                        }
                        if(step<map.getColumns()-position.getCol()&&steps>step||step<map.getColumns()-position.getCol()&&steps==step){
                            steps-=step;
                            int a=position.getCol();
                            for(int i=0;i<=step;i++){
                                int x=a+i;
                                position.setCol(x);
                                score+=map.hasTreasure(position);                                
                            }
                            return true;
                        }
                        if(step>map.getColumns()-position.getCol()&&steps<map.getColumns()-position.getCol()||step==map.getColumns()-position.getCol()&&steps<map.getColumns()-position.getCol()){
                            int a=position.getCol();
                            for(int i=0;i<=steps;i++){
                                int x=a+i;
                                position.setCol(x);
                                score+=map.hasTreasure(position);                                
                            }
                            steps=0;
                            return false;
                        }
                        if(step<map.getColumns()-position.getCol()&&steps<step){
                            int a=position.getCol();
                            for(int i=0;i<=steps;i++){
                                int x=a+i;
                                position.setCol(x);
                                score+=map.hasTreasure(position);                                
                            }
                            steps=0;
                            return false;
                        }                                                                        
                        return false;
                        }
                    }                                                            
                }
        else{
            return false;
        }
        }
        return false;
    }
    public int getId(){
        return id;
    }
    public int getSteps(){
        return isteps-steps;
    }
    public int getScore(){
        return score;
    }
    public Position getPosition(){
        return position;
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        if(p.getId()==this.id){
            return true;
        }
        else{
            return false;
        }
    }
}