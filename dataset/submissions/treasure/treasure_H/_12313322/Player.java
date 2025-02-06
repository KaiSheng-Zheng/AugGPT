import java.util.*;
public class Player
{
    private static int cnt=0;
    private final int id=++cnt;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    public Player(Map map,Position initialPosition)
    {
        this.map=map;
        this.position=initialPosition;
        maxStepAllowed=100000001;
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed)
    {
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
    }
    public boolean move(Direction direction,int steps)
    {
//        if(!this.map.isActive()) return false;
        if(direction==Direction.UP)
        {
            while(this.getx()!=0 && steps>0 && maxStepAllowed!=0 && this.map.isActive())
            {
                steps--;
                maxStepAllowed--;
                this.steps++;
                this.position.setRow(this.getx()-1);
                this.score+=this.map.takeTreasure(this.position);
            }
        }
        else if(direction==Direction.LEFT)
        {
            while(this.gety()!=0 && steps>0 && maxStepAllowed!=0 && this.map.isActive())
            {
                steps--;
                maxStepAllowed--;
                this.steps++;
                this.position.setCol(this.gety()-1);
                this.score+=this.map.takeTreasure(this.position);
            }
        }
        else if(direction==Direction.DOWN)
        {
            while(this.getx()!=this.map.getRows() && steps>0 && maxStepAllowed!=0 && this.map.isActive())
            {
                steps--;
                maxStepAllowed--;
                this.steps++;
                this.position.setRow(this.getx()+1);
                this.score+=this.map.takeTreasure(this.position);
            }
        }
        else if(direction==Direction.RIGHT)
        {
            while(this.gety()!=this.map.getColumns() && steps>0 && maxStepAllowed!=0 && this.map.isActive())
            {
                steps--;
                maxStepAllowed--;
                this.steps++;
                this.position.setCol(this.gety()+1);
                this.score+=this.map.takeTreasure(this.position);
            }
        }
        if(steps>0) return false;
        return true;
    }
    public int getx()
    {
        return this.position.getRow();
    }
    public int gety()
    {
        return this.position.getCol();
    }
    public boolean equals(Object p)
    {
        Player player=(Player)p;
        return this.id==player.getId() ? true : false;
    }
    public int getId()
    {
        return this.id;
    }
    public int getScore()
    {
        return this.score;
    }
    public int getSteps()
    {
        return this.steps;
    }
    public Position getPosition()
    {
        return this.position;
    }
    public String toString()
    {
        return "id="+this.id+" pos=("+this.position.getRow()+","+this.position.getCol()+") score="+this.score+" steps"+this.steps;
    }
}
//test 4 10 player.equals
//test 12 13 steps
//test 7 isActive