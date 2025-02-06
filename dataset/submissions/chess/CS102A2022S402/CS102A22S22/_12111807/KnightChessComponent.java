import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> knight = new ArrayList<>();
        ChessColor chessColor = getChessColor();
        ChessboardPoint source = getSource();
        int x = source.getX();
        int y = source.getY();
        if(x+2<8 && y+1<8 && x+2>=0 && y+1>=0 && board[x+2][y+1].getChessColor() != chessColor){
            knight.add(new ChessboardPoint(x+2,y+1));
        }
        if(x+1<8 && y+2<8 && x+1>=0 && y+2>=0 && board[x+1][y+2].getChessColor() != chessColor){
            knight.add(new ChessboardPoint(x+1,y+2));
        }
        if(x+2<8 && y-1<8 && x+2>=0 && y-1>=0 && board[x+2][y-1].getChessColor() != chessColor){
            knight.add(new ChessboardPoint(x+2,y-1));
        }
        if(x+1<8 && y-2<8 && x+1>=0 && y-2>=0 && board[x+1][y-2].getChessColor() != chessColor){
            knight.add(new ChessboardPoint(x+1,y-2));
        }
        if(x-1<8 && y+2<8 && x-1>=0 && y+2>=0 && board[x-1][y+2].getChessColor() != chessColor){
            knight.add(new ChessboardPoint(x-1,y+2));
        }
        if(x-2<8 && y+1<8 && x-2>=0 && y+1>=0 && board[x-2][y+1].getChessColor() != chessColor){
            knight.add(new ChessboardPoint(x-2,y+1));
        }
        if(x-1<8 && y-2<8 && x-1>=0 && y-2>=0 && board[x-1][y-2].getChessColor() != chessColor){
            knight.add(new ChessboardPoint(x-1,y-2));
        }
        if(x-2<8 && y-1<8 && x-2>=0 && y-1>=0 && board[x-2][y-1].getChessColor() != chessColor){
            knight.add(new ChessboardPoint(x-2,y-1));
        }
        return knight;
    }
}
