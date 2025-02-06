import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
//    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
//        super(source, chessColor, name);
//    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> king = new ArrayList<>();
        ChessColor chessColor = getChessColor();
        ChessboardPoint source = getSource();
        int x = source.getX();
        int y = source.getY();

        if(x+1<8 && y<8 && x+1>=0 && y>=0 && board[x+1][y].getChessColor() != chessColor){
            king.add(new ChessboardPoint(x+1,y));
        }
        if(x+1<8 && y+1<8 && x+1>=0 && y+1>=0 && board[x+1][y+1].getChessColor() != chessColor){
            king.add(new ChessboardPoint(x+1,y+1));
        }
        if(x+1<8 && y-1<8 && x+1>=0 && y-1>=0 && board[x+1][y-1].getChessColor() != chessColor){
            king.add(new ChessboardPoint(x+1,y-1));
        }
        if(x<8 && y+1<8 && x>=0 && y+1>=0 && board[x][y+1].getChessColor() != chessColor){
            king.add(new ChessboardPoint(x,y+1));
        }
        if(x<8 && y-1<8 && x>=0 && y-1>=0 && board[x][y-1].getChessColor() != chessColor){
            king.add(new ChessboardPoint(x,y-1));
        }
        if(x-1<8 && y+1<8 && x-1>=0 && y+1>=0 && board[x-1][y+1].getChessColor() != chessColor){
            king.add(new ChessboardPoint(x-1,y+1));
        }
        if(x-1<8 && y<8 && x-1>=0 && y>=0 && board[x-1][y].getChessColor() != chessColor){
            king.add(new ChessboardPoint(x-1,y));
        }
        if(x-1<8 && y-1<8 && x-1>=0 && y-1>=0 && board[x-1][y-1].getChessColor() != chessColor){
            king.add(new ChessboardPoint(x-1,y-1));
        }
        return king;
    }
}
