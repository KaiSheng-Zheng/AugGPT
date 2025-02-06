import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(char name,ChessColor c,ChessboardPoint s){
        super(name, c, s);
    }

    public QueenChessComponent(char n){
        this.name = n;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getChessBoardPoint().getX();
        int y = this.getChessBoardPoint().getY();
        List<ChessboardPoint> t = new ArrayList<>();
        int i;
        i = x;
        while( i < 8 ){

            if( i != x  && chessComponentsNew[i][y].getChessColor() == ChessColor.NONE){
                t.add(new ChessboardPoint(i,y));
            }else if(i != x  && chessComponentsNew[i][y].getChessColor() != this.getChessColor() ){
                t.add(new ChessboardPoint(i,y));
                break;
            }else if(i != x  && chessComponentsNew[i][y].getChessColor() == this.getChessColor()){
                break;
            }
            i++;
        }
        i = x;
        while( i >= 0 ){

            if( i != x  && chessComponentsNew[i][y].getChessColor() == ChessColor.NONE){
                t.add(new ChessboardPoint(i,y));
            }else if(i != x  && chessComponentsNew[i][y].getChessColor() != this.getChessColor() ){
                t.add(new ChessboardPoint(i,y));
                break;
            }else if(i != x  && chessComponentsNew[i][y].getChessColor() == this.getChessColor()){
                break;
            }
            i--;
        }

        int j = y;
        while( j < 8 ){

            if( j != y  && chessComponentsNew[x][j].getChessColor() == ChessColor.NONE){
                t.add(new ChessboardPoint(x,j));
            }else if(j != y  && chessComponentsNew[x][j].getChessColor() != this.getChessColor() ){
                t.add(new ChessboardPoint(x,j));
                break;
            }else if(j != y  && chessComponentsNew[x][j].getChessColor() == this.getChessColor()){
                break;
            }
            j++;
        }
        j = y;
        while( j >=0 ){

            if( j != y  && chessComponentsNew[x][j].getChessColor() == ChessColor.NONE){
                t.add(new ChessboardPoint(x,j));
            }else if(j != y  && chessComponentsNew[x][j].getChessColor() != this.getChessColor() ){
                t.add(new ChessboardPoint(x,j));
                break;
            }else if(j != y  && chessComponentsNew[x][j].getChessColor() == this.getChessColor()){
                break;
            }
            j--;
        }


        int m = x;
        int n = y;
        while(0 <= m && m <= 7 && 0 <= n && 7 >= n){
            if( (m != x && n != y) && chessComponentsNew[m][n].getChessColor() == ChessColor.NONE){
                t.add(new ChessboardPoint(m,n));
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() != this.getChessColor() ){
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
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() != this.getChessColor() ){
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
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() != this.getChessColor() ){
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
            }else if((m != x && n != y) && chessComponentsNew[m][n].getChessColor() != this.getChessColor() ){
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
