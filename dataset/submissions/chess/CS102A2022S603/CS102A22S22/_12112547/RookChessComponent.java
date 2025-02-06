import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(char name,ChessColor c,ChessboardPoint s){
        super(name,c,s);
    }

    public RookChessComponent(char n){
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


        return t;
    }

    public char getName(){
        return this.name;
    }
}
