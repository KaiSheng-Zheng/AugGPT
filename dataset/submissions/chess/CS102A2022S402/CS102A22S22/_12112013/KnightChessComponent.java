import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public KnightChessComponent(ChessboardPoint source,ChessColor color,char name){
        this.source=source;
        this.chessColor=color;
        this.name=name;
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<ChessboardPoint>();
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                int x=Math.abs(i-source.getX());
                int y=Math.abs(j-source.getY());
                if (x+y==3 && x!=0 &&y!=0 &&chessComponents[i][j].getChessColor()!=this.getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chessboardPoints;
    }

    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    public ChessColor getChessColor(){return this.chessColor;}

    
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
