public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        if (x>=0&&x<8&&y>=0&&y<8){
        this.x=x;
        this.y=y;}
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    @Override//
    public String toString(){
        StringBuilder haha=new StringBuilder();
        haha.append("(");
        haha.append(x);
        haha.append(",");
        haha.append(y);
        haha.append(")");
        return haha.toString();
    }
    @Override
    public boolean equals(Object object){
        if(object==null){
            return false;
        }
        else if(object.getClass()!=this.getClass()){
            return false;
        }
        else{
        ChessboardPoint p=(ChessboardPoint) object;
        return x==p.x&&y==p.y;}
    }
    public ChessboardPoint offset(int dx, int dy){
        if (x+dx>=0&&x+dx<8&&y+dy>=0&&y+dy<8){
            return new ChessboardPoint(x+dx,y+dy);
        }
        else{
            return null;
        }
    }
}

