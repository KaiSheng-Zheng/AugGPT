import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public PawnChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
        int m=this.getSource().getX(),n=this.getSource().getY();
        ChessColor s=this.getChessComponents()[m][n].getChessColor();
        if(s==ChessColor.WHITE)
        {
            if(m==6){
                if(m-1>-1) {
                    if (this.getChessComponents()[m - 1][n].getChessColor() == ChessColor.NONE) {
                        ChessboardPoint a = new ChessboardPoint(m - 1, n);
                        arrayList.add(a);
                        if(m-2<8) {
                            if (this.getChessComponents()[m - 2][n].getChessColor() == ChessColor.NONE) {
                                ChessboardPoint b = new ChessboardPoint(m - 2, n);
                                arrayList.add(b);
                            }
                        }
                    }
                }
                if(m-1>-1&&n-1>-1) {
                    if (this.getChessComponents()[m - 1][n - 1].getChessColor() == ChessColor.BLACK) {
                        ChessboardPoint a = new ChessboardPoint(m - 1, n - 1);
                        arrayList.add(a);
                    }
                }
                if(m-1>-1&&n+1<8) {
                    if (this.getChessComponents()[m - 1][n + 1].getChessColor() == ChessColor.BLACK) {
                        ChessboardPoint a = new ChessboardPoint(m + 1, n + 1);
                        arrayList.add(a);
                    }
                }
            }
            else
            {
                if((m-1>-1 && m-1<8)&&(n-1>-1 && n-1<8)){
                    if(this.getChessComponents()[m-1][n-1].getChessColor()==ChessColor.BLACK){
                        ChessboardPoint a = new ChessboardPoint(m-1,n-1 );
                        arrayList.add(a);
                }
            }
                if((m-1>-1 && m-1<8 )&& ( n+1<8 && n+1>-1)  ){
                    if(this.getChessComponents()[m-1][n+1].getChessColor()==ChessColor.BLACK){
                        ChessboardPoint a = new ChessboardPoint(m+1,n+1 );
                        arrayList.add(a);
                    }
                }if(n>-1&&n<8){
                if((m-1>-1 && m-1<8)&&this.getChessComponents()[m-1][n].getChessColor()==ChessColor.NONE) {
                    ChessboardPoint a = new ChessboardPoint(m-1,n );
                    arrayList.add(a);
                }
            }
            }

        }
        if(s==ChessColor.BLACK)
        {
            if(m==1){
                if (m+1<8) {
                    if (this.getChessComponents()[m + 1][n].getChessColor() == ChessColor.NONE) {
                        ChessboardPoint a = new ChessboardPoint(m + 1, n);
                        arrayList.add(a);
                        if(m+2<8) {
                            if (this.getChessComponents()[m + 2][n].getChessColor() == ChessColor.NONE) {
                                ChessboardPoint b = new ChessboardPoint(m + 2, n);
                                arrayList.add(b);
                            }
                        }
                    }
                }
                if(m+1<8&&n+1<8) {
                    if (this.getChessComponents()[m + 1][n + 1].getChessColor() == ChessColor.WHITE) {
                        ChessboardPoint a = new ChessboardPoint(m + 1, n + 1);
                        arrayList.add(a);
                    }
                }
                if(m+1<8&&n-1>-1) {
                    if (this.getChessComponents()[m + 1][n - 1].getChessColor() == ChessColor.WHITE) {
                        ChessboardPoint a = new ChessboardPoint(m + 1, n - 1);
                        arrayList.add(a);
                    }
                }
            }
            else {
                if ((m + 1 < 8 && m + 1 > -1) && (n + 1 < 8 && n + 1 > -1)) {
                    if (this.getChessComponents()[m + 1][n + 1].getChessColor() == ChessColor.WHITE) {
                        ChessboardPoint a = new ChessboardPoint(m + 1, n + 1);
                        arrayList.add(a);
                    }
                }
                if ((m + 1 < 8 && m + 1 > -1) && (n - 1 > -1 && n - 1 < 8)) {
                    if (this.getChessComponents()[m + 1][n - 1].getChessColor() == ChessColor.WHITE) {
                        ChessboardPoint a = new ChessboardPoint(m + 1, n - 1);
                        arrayList.add(a);
                    }
                }
                if (n>-1&&n<8) {
                    if ((m + 1 < 8 && m + 1 > -1) && this.getChessComponents()[m + 1][n].getChessColor() == ChessColor.NONE) {
                        ChessboardPoint a = new ChessboardPoint(m + 1, n);
                        arrayList.add(a);
                    }
                }
            }
        }
        return arrayList;
    }
}
