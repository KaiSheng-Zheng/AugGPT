public class Player {
    private static int cnt=1;
    private final int id;
    private int score;
    private int steps;
    private int maxSteps;
    private Position position;
    private Map map;
    private boolean flag;
    public Player(Map map,Position initialPosition)
    {
        this.map=map;
        this.position=initialPosition;
        id=cnt;
        cnt++;
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed)
    {
        this.map=map;
        this.position=initialPosition;
        this.maxSteps=maxStepAllowed;
        flag=true;
        id=cnt;
        cnt++;
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public int getSteps() {
        return steps;
    }
    public boolean move(Direction direction,int steps)
    {
        //System.out.println(this.toString());
        if(!map.isActive())
        {
            return false;
        }
        if(flag&&maxSteps==0)
        {
            return false;
        }
        switch(direction)
        {
            case UP:
            {
                if(this.position.getRow()-steps<0)
                {
                    steps=this.position.getRow();
                    if(this.steps+steps>maxSteps&&maxSteps!=0)
                    {
                        steps=maxSteps-this.steps;
                        this.steps=maxSteps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setRow((this.position.getRow()-1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        this.steps+=steps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setRow((this.position.getRow()-1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                    return false;
                }
                else {
                    if(this.steps+steps>maxSteps&&maxSteps!=0)
                    {
                        steps=maxSteps-this.steps;
                        this.steps=maxSteps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setRow((this.position.getRow()-1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                        return false;
                    }
                    else {
                        this.steps+=steps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setRow((this.position.getRow()-1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                }
                    return true;
            }
            case DOWN:
            {
                if(this.position.getRow()+steps>=map.getRows())
                {
                    steps=map.getRows()-this.position.getRow()-1;
                    if(this.steps+steps>maxSteps&&maxSteps!=0)
                    {
                        steps=maxSteps-this.steps;
                        this.steps=maxSteps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setRow((this.position.getRow()+1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        this.steps+=steps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setRow((this.position.getRow()+1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                    return false;
                }
                else {
                    if(this.steps+steps>maxSteps&&maxSteps!=0)
                    {
                        steps=maxSteps-this.steps;
                        this.steps=maxSteps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setRow((this.position.getRow()+1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                        return false;
                    }
                    else {
                        this.steps+=steps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setRow((this.position.getRow()+1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                }
                return true;
            }
            case LEFT:
            {
                if(this.position.getCol()-steps<0)
                {
                    steps=this.position.getCol();
                    if(this.steps+steps>maxSteps&&maxSteps!=0)
                    {
                        steps=maxSteps-this.steps;
                        this.steps=maxSteps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setCol((this.position.getCol()-1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        this.steps+=steps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setCol((this.position.getCol()-1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                    return false;
                }
                else {
                    if(this.steps+steps>maxSteps&&maxSteps!=0)
                    {
                        steps=maxSteps-this.steps;
                        this.steps=maxSteps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setCol((this.position.getCol()-1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                        return false;
                    }
                    else {
                        this.steps+=steps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setCol((this.position.getCol()-1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                }
                return true;
            }
            case RIGHT:
            {
                if(this.position.getCol()+steps>=map.getColumns())
                {
                    steps=map.getColumns()-this.position.getCol()-1;
                    if(this.steps+steps>maxSteps&&maxSteps!=0)
                    {
                        steps=maxSteps-this.steps;
                        this.steps=maxSteps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setCol((this.position.getCol()+1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        this.steps+=steps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setCol((this.position.getCol()+1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                    return false;
                }
                else {
                    if(this.steps+steps>maxSteps&&maxSteps!=0)
                    {
                        steps=maxSteps-this.steps;
                        this.steps=maxSteps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setCol((this.position.getCol()+1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                        return false;
                    }
                    else {
                        this.steps+=steps;
                        for(int i=1;i<=steps;i++)
                        {
                            this.position.setCol((this.position.getCol()+1));
                            if(map.hasTreasure(this.position)!=0)
                            {
                                this.score+=map.hasTreasure(this.position);
                                map.update(this.position);
                                if(!map.isActive())
                                {
                                    break;
                                }
                            }
                        }
                    }
                }
                return true;
            }
        }
        return true;
    }
    public boolean equals(Object player)
    {
        Player p=(Player)player;
        if(this.id==p.getId())
            return true;
        return false;
    }
}
