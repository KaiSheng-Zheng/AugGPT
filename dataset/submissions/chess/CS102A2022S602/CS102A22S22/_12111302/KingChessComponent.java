import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public KingChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
        int m=this.getSource().getX(),n=this.getSource().getY();
        ChessColor s=this.getChessComponents()[m][n].getChessColor();
        if(m-1>-1&&this.getChessComponents()[m-1][n].getChessColor()!=s) {
            ChessboardPoint a = new ChessboardPoint(m-1,n );
            arrayList.add(a);
        }
        if(m-1>-1&&n-1>-1&&this.getChessComponents()[m-1][n-1].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m-1,n-1 );
            arrayList.add(a);
        }
        if(m-1>-1&&n+1<8&&this.getChessComponents()[m-1][n+1].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m-1,n+1 );
            arrayList.add(a);
        }
        if(n+1<8&&this.getChessComponents()[m][n+1].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m,n+1 );
            arrayList.add(a);
        }
        if(m+1<8&&n+1<8&&this.getChessComponents()[m+1][n+1].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m+1,n+1 );
            arrayList.add(a);
        }
        if(m+1<8&&this.getChessComponents()[m+1][n].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m+1,n );
            arrayList.add(a);
        }
        if(m+1<8&&n-1>-1&&this.getChessComponents()[m+1][n-1].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m+1,n-1 );
            arrayList.add(a);
        }
        if(n-1>-1&&this.getChessComponents()[m][n-1].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m,n-1 );
            arrayList.add(a);
        }
        return arrayList;
    }
}
