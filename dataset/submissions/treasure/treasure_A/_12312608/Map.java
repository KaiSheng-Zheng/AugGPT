public class Map{
    private final int rows,columns;private Treasure[] treasures;private boolean isActive;
    public int getR(){return rows;}public int getC(){return columns;}
    public Map(int rs,int cls,Treasure[] ts){rows=rs;columns=cls;treasures=ts;}
    public int hasTreasure(Position p){for(Treasure k:treasures)if(k.getPosition().equals(p))return k.getScore();return 0;}
    public void update(Position p){for(Treasure k:treasures)if(k.getPosition().equals(p))k.setScore(0);}
    public boolean isActive(){for(Treasure k:treasures)if(k.getScore()>0)return true;return false;}
}