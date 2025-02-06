import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    int x; int y;

    public KnightChessComponent(int x, int y, char name ) {
       super(x,y,name);
       this.name = 'N';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i <=7; i++) {
            for (int j = 0; j <=7; j++) {
                ChessboardPoint destination = new ChessboardPoint(i, j);
                if (source.getX() -2 == destination.getX() ){
                    if (source.getY() -1 == destination.getY()  || source.getY() +1 == destination.getY() ){
                        if (this.getChessColor() != chessboard[i][j].getChessColor()) {
                            canMoveTo.add(destination);
                        }
                    }
                }else if (source.getX() -1 == destination.getX() ){
                    if (source.getY() -2 == destination.getY()  || source.getY() +2== destination.getY() ){
                        if (this.getChessColor() != chessboard[i][j].getChessColor()) {
                            canMoveTo.add(destination);
                        }
                    }
                }else if (source.getX() +1 == destination.getX() ){
                    if (source.getY() -2 == destination.getY()  || source.getY() +2 == destination.getY() ){
                        if (this.getChessColor() != chessboard[i][j].getChessColor()) {
                            canMoveTo.add(destination);
                        }
                    }
                }else if (source.getX() +2 == destination.getX() ){
                    if (source.getY() -1 == destination.getY()  || source.getY() +1 == destination.getY() ){
                        if (this.getChessColor() != chessboard[i][j].getChessColor()) {
                            canMoveTo.add(destination);
                        }
                    }
                }
            }
        }
        return canMoveTo;
    }
}
