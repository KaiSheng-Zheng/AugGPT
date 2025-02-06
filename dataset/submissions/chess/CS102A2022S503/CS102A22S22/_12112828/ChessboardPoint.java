public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        if (x<8 & x>=0 & y<8 & y>=0){
        this.x=x;
        this.y=y;
        }
        else {
            this.x=-1;
            this.y=-1;
        }
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String toString(){
        String a="(";
        char b= (char)(getX()+48);
        String c=",";
        char d=(char)(getY()+48);
        String e=")";
        return a+b+c+d+e;
    }
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(o.getClass()!=this.getClass()){
            return false;
        }
        ChessboardPoint p=(ChessboardPoint) o;
        return x==p.x&&y==p.y;
    }
    public ChessboardPoint offset(int dx, int dy){
        if (this.x+dx>7 || this.x+dx<0 || this.y+dy>7 || this.y+dy<0){
            return null;
        }
        else {
            this.x=this.x+dx;
            this.y=this.y+dy;
            ChessboardPoint result=new ChessboardPoint(this.x,this.y);
            return result;
        }
    }
    public ChessboardPoint offset1(int dx,int dy){
        if (this.x+dx>7 || this.x+dx<0 || this.y+dy>7 || this.y+dy<0){
            return null;
        }
        return new ChessboardPoint(this.x+dx,this.y+dy);
    }
}
