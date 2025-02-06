//package class_task_6_2;

import java.util.Objects;

public class Player {
    static int maxn = 10005;
    private int score;
    private int steps,maxstep;
    private final int id;
    private Position position;
    private Map map;
    static int cnt=0;
    public Player(Map map, Position initialPosition){
       // this.id = id;
        this.id=++cnt;
        this.position=initialPosition;
        this.map=map;
        this.maxstep=maxn;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id=++cnt;
        this.position=initialPosition;
        this.map=map;
        this.maxstep=maxStepAllowed;
    }

    public Player() {
        this.id=++cnt;
    }

    public boolean move(Direction direction,int steps){
      if(!map.isActive()){
          return false;
      }
      /*if(this.steps+steps>maxstep){
          return false;
      }*/
      if(this.steps>=maxstep)return false;
      /*int dx=position.getRow()+direction.getRow(),dy=position.getCol()+direction.getCol();
      //dx is define as the rows,and dy is define as the cols;
      if(dx>map.getRows()||dx<0||dy> map.getColumns()||dy<0)return false;*/
      //int flag=0;
      for(int i=1;i<=steps;i++){
          if(this.steps==maxstep||!map.isActive())return false;
          int dx=position.getRow()+direction.getRow(),dy=position.getCol()+direction.getCol();
          if(dx>=map.getRows()||dx<0||dy>=map.getColumns()||dy<0)return false;
          position.setRow(dx);position.setCol(dy);this.steps++;
          int value=map.hasTreasure(position);
          if(value>0){
              score+=value;
              map.setCnt(map.getCnt()-1);
              map.update(position);
          }
          //if(this.steps==maxstep||i!=steps)return false;
      }
      return true;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getMaxstep() {
        return maxstep;
    }

    public void setMaxstep(int maxstep) {
        this.maxstep = maxstep;
    }

    public Position getPosition() {
        return position;
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

    public static int getMaxn() {
        return maxn;
    }

    public static void setMaxn(int maxn) {
        Player.maxn = maxn;
    }

    public int getId() {
        return id;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, steps, maxstep, id, position, map, cnt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score && steps == player.steps && maxstep == player.maxstep && id == player.id && cnt == player.cnt && Objects.equals(position, player.position) && Objects.equals(map, player.map);
    }

    /*public boolean equals(Object player){
       Player real=(Player) player;
       return this.id==real.id;
    }*/
}