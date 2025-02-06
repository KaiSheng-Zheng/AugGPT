import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(char name,ChessColor c,ChessboardPoint s){
        super(name,c,s);
    }

    public BishopChessComponent(char n){
        super(n);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getChessBoardPoint().getX();
        int y = this.getChessBoardPoint().getY();
        List<ChessboardPoint> t = new ArrayList<>();
        int m = x;
        int n = y;
        while(0 <= m && m <= 7 && 0 <= n && 7 >= n){
            if( (m != x && n != y) && chessComponentsNew[m][n].getChessColor() == ChessColor.NONE){
                t.add(new ChessboardPoint(m,n));
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() != this.getChessColor() && chessComponentsNew[m][n].getChessColor() != ChessColor.NONE){
                t.add(new ChessboardPoint(m,n));
                break;
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() == this.getChessColor()){
                break;
            }
            m--;
            n--;
        }
        m = x;
        n = y;
        while(0 <= m && m <= 7 && 0 <= n && 7 >= n){
            if( (m != x && n != y) && chessComponentsNew[m][n].getChessColor() == ChessColor.NONE){
                t.add(new ChessboardPoint(m,n));
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() != this.getChessColor() && chessComponentsNew[m][n].getChessColor() != ChessColor.NONE){
                t.add(new ChessboardPoint(m,n));
                break;
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() == this.getChessColor()){
                break;
            }
            m++;
            n++;
        }
        m = x;
        n = y;
        while(0 <= m && m <= 7 && 0 <= n && 7 >= n){
            if( (m != x && n != y) && chessComponentsNew[m][n].getChessColor() == ChessColor.NONE){
                t.add(new ChessboardPoint(m,n));
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() != this.getChessColor() && chessComponentsNew[m][n].getChessColor() != ChessColor.NONE ){
                t.add(new ChessboardPoint(m,n));
                break;
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() == this.getChessColor()){
                break;
            }
            m--;
            n++;
        }
        m = x;
        n = y;
        while(0 <= m && m <= 7 && 0 <= n && 7 >= n){
            if( (m != x && n != y) && chessComponentsNew[m][n].getChessColor() == ChessColor.NONE){
                t.add(new ChessboardPoint(m,n));
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() != this.getChessColor() && chessComponentsNew[m][n].getChessColor() != ChessColor.NONE ){
                t.add(new ChessboardPoint(m,n));
                break;
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() == this.getChessColor()){
                break;
            }
            m++;
            n--;
        }






        return t;
    }

    public char getName(){
        return this.name;
    }
}
