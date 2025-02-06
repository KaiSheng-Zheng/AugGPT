public class Player
{
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int s;
    private static int sum=1;
    public Player(Map map,Position initialPosition)
    {
        this.map=map;
        this.position=initialPosition;
        s=-1;
        steps=0;
        id=sum;
        sum++;
        map.update(initialPosition);
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed)
    {
        this.map=map;
        this.position=initialPosition;
        s=maxStepAllowed;
        steps=0;
        id=sum;
        sum++;
    }
    public int getId()
    {
        return id;
    }
    public int getScore()
    {
        return score;
    }
    public int getSteps()
    {
        return steps;
    }
    public Position getPosition()
    {
        return position;
    }
    public boolean move(Direction direction, int step)
    {
        int k;
        switch(direction)
        {
            case UP:
            {
                for(k=0;k<step;k++)
                {
                    if(steps==s||!map.isActive()||position.getRow()==0)
                    {
                        return false;
                    }
                    int j=position.getRow();
                    position.setRow(j-1);
                    steps++;
                    if(!map.b[position.getRow()][position.getCol()])
                    {
                        int t=map.hasTreasure(position);
                        if(t>0)
                        {
                            int f=map.getM();
                            if(f==1)
                            {
                                map.setActive();
                            }
                            map.setM(f-1);
                        }
                        score+=t;
                    }
                    map.update(position);
                }
                break;
            }
            case DOWN:
            {
                for(k=0;k<step;k++)
                {
                    if(steps==s||!map.isActive()||position.getRow()==map.getRows()-1)
                    {
                        return false;
                    }
                    int j=position.getRow();
                    position.setRow(j+1);
                    steps++;
                    if(!map.b[position.getRow()][position.getCol()])
                    {
                        int t=map.hasTreasure(position);
                        if(t>0)
                        {
                            int f=map.getM();
                            if(f==1)
                            {
                                map.setActive();
                            }
                            map.setM(f-1);
                        }
                        score+=t;
                    }
                    map.update(position);
                }
                break;
            }
            case LEFT:
            {
                for(k=0;k<step;k++)
                {
                    if(steps==s||!map.isActive()||position.getCol()==0)
                    {
                        return false;
                    }
                    int j=position.getCol();
                    position.setCol(j-1);
                    steps++;
                    if(!map.b[position.getRow()][position.getCol()])
                    {
                        int t=map.hasTreasure(position);
                        if(t>0)
                        {
                            int f=map.getM();
                            if(f==1)
                            {
                                map.setActive();
                            }
                            map.setM(f-1);
                        }
                        score+=t;
                    }
                    map.update(position);
                }
                break;
            }
            case RIGHT:
            {
                for(k=0;k<step;k++)
                {
                    if(steps==s||!map.isActive()||position.getCol()==map.getColumns()-1)
                    {
                        return false;
                    }
                    int j=position.getCol();
                    position.setCol(j+1);
                    steps++;
                    if(!map.b[position.getRow()][position.getCol()])
                    {
                        int t=map.hasTreasure(position);
                        if(t>0)
                        {
                            int f=map.getM();
                            if(f==1)
                            {
                                map.setActive();
                            }
                            map.setM(f-1);
                        }
                        score+=t;
                    }
                    map.update(position);
                }
                break;
            }
        }
        return true;
    }
    public boolean equals(Object player)
    {
        Player p=(Player)player;
        return p.getId()==this.id;
    }
}
