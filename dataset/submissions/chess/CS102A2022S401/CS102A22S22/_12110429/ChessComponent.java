import java.util.List;

public abstract class ChessComponent {
    public ChessboardPoint source=new ChessboardPoint(0,0);//Need Changing;

    public ChessColor chessColor;
    public void setSource(int x,int y){
        ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
        source=chessboardPoint;
    }
    protected char name;
    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();
    public String toString(){
        return  String.valueOf(this.name);
    }
}





