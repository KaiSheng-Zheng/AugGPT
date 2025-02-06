import java.util.Objects;

public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed=0;
    private static int count=0;
    private boolean judge=false;


    public Player(Map map,Position position) {
        this.position = position;
        this.map = map;
        id=++count;
    }

    public Player(Map map,Position position,int maxStepAllowed ) {
        this.maxStepAllowed =maxStepAllowed;
        judge=true;
        this.position = position;
        this.map = map;
        id=++count;
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
    public boolean move(Direction direction, int steps){
        boolean hi=false;
        int a,b;
        a=position.getRow();
        b=position.getCol();
        if (!map.isActive()) return false;
        if (judge&&maxStepAllowed==0) return false;
        if (steps>maxStepAllowed&&judge) {steps=maxStepAllowed; maxStepAllowed=0;hi=true;}
        else if (judge) maxStepAllowed-=steps;
        Position temp=new Position(0,0);
        switch (direction){
            case UP:
                if (a-steps>=0) {
                    temp.setCol(b);
                    for (int i=a-1;i>=a-steps;i--)
                    {
                        temp.setRow(i);
                        if (!map.isActive()) return false;
                        if (map.hasTreasure(temp)!=0) {score+=map.hasTreasure(temp); map.update(temp);}
                        position.setRow(position.getRow()-1);
                        this.steps++;
                    }

                    if (hi) return false;
                    return true;
                }
                else {
                    temp.setCol(b);
                    for (int i=a-1;i>=0;i--)
                    {
                        temp.setRow(i);
                        if (!map.isActive()) return false;
                        if (map.hasTreasure(temp)!=0) {score+=map.hasTreasure(temp); map.update(temp);}
                        position.setRow(position.getRow()-1);
                        this.steps++;
                    }
                    return false;
                }
            case DOWN:
                if (a+steps<=map.getRows()-1){
                    temp.setCol((position.getCol()));
                    for (int i=a+1;i<= a+steps;i++)
                    {
                        temp.setRow(i);
                        if (!map.isActive()) return false;
                        if (map.hasTreasure(temp)!=0) {score+=map.hasTreasure(temp); map.update(temp);}
                        position.setRow(position.getRow()+1);
                        this.steps++;
                    }
                    if (hi) return false;
                    return true;
                }
                else{
                    temp.setCol(position.getCol());
                    for (int i=a+1;i<=map.getRows()-1;i++)
                    {
                        temp.setRow(i);
                        if (!map.isActive()) return false;
                        if (map.hasTreasure(temp)!=0) {score+=map.hasTreasure(temp); map.update(temp);}
                        position.setRow(position.getRow()+1);
                        this.steps++;
                    }
                    return false;
                }

            case LEFT:
                if (b-steps>=0){
                    temp.setRow(position.getRow());
                    for (int i= b-1;i>= b-steps;i--)
                    {
                        temp.setCol(i);
                        if (!map.isActive()) return false;
                        if (map.hasTreasure(temp)!=0) {score+=map.hasTreasure(temp); map.update(temp);}
                        position.setCol(position.getCol()-1);
                        this.steps++;
                    }
                    if (hi) return false;
                    return true;
                }
                else {
                    temp.setRow(position.getRow());
                    for (int i= b-1;i>=0;i--)
                    {
                        temp.setCol(i);
                        if (!map.isActive()) return false;
                        if (map.hasTreasure(temp)!=0) {score+=map.hasTreasure(temp); map.update(temp);}
                        position.setCol(position.getCol()-1);
                        this.steps++;
                    }
                    return false;
                }
            case RIGHT:
                if (position.getCol()+steps<=map.getColumns()-1) {
                    temp.setRow(position.getRow());
                    for (int i= b+1;i<= b+steps;i++)
                    {
                        temp.setCol(i);
                        if (!map.isActive()) return false;
                        if (map.hasTreasure(temp)!=0) {score+=map.hasTreasure(temp); map.update(temp);}
                        position.setCol(position.getCol()+1);this.steps++;
                    }
                    if (hi) return false;
                    return true;
                }
                else
                {
                    temp.setRow(position.getRow());
                    for (int i= b+1;i<= map.getColumns()-1;i++)
                    {
                        temp.setCol(i);
                        if (!map.isActive()) return false;
                        if (map.hasTreasure(temp)!=0) {score+=map.hasTreasure(temp); map.update(temp);}
                        position.setCol(position.getCol()+1);this.steps++;
                    }
                    return false;
                }
        }
        return false;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
