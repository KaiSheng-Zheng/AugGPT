import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
        int m= this.getSource().getX(),n=this.getSource().getY();
        ChessColor s=this.getChessComponents()[m][n].getChessColor();
        if(m-2>-1&&n+1<8&&this.getChessComponents()[m-2][n+1].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m-2,n+1 );
            arrayList.add(a);
        }
        if(m-2>-1&&n-1>-1&&this.getChessComponents()[m-2][n-1].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m-2,n-1 );
            arrayList.add(a);
        }
        if(m-1>-1&&n-2>-1&&this.getChessComponents()[m-1][n-2].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m-1,n-2 );
            arrayList.add(a);
        }
        if(m+1<8&&n-2>-1&&this.getChessComponents()[m+1][n-2].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m+1,n-2 );
            arrayList.add(a);
        }
        if(m+2<8&&n-1>-1&&this.getChessComponents()[m+2][n-1].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m+2,n-1 );
            arrayList.add(a);
        }
        if(m+2<8&&n+1<8&&this.getChessComponents()[m+2][n+1].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m+2,n+1 );
            arrayList.add(a);
        }
        if(m-1>-1&&n+2<8&&this.getChessComponents()[m-1][n+2].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m-1,n+2 );
            arrayList.add(a);
        }
        if(m+1<8&&n+2<8&&this.getChessComponents()[m+1][n+2].getChessColor()!=s){
            ChessboardPoint a = new ChessboardPoint(m+1,n+2 );
            arrayList.add(a);
        }
        return arrayList;
    }
}
