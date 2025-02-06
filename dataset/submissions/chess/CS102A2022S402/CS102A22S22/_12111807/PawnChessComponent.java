import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pawn = new ArrayList<>();
        ChessColor chessColor = getChessColor();
        ChessboardPoint source = getSource();
        int x = source.getX();
        int y = source.getY();
        if(chessColor == ChessColor.WHITE){
            if(inBoard(x-1,y) && board[x-1][y].getChessColor() == ChessColor.NONE){
                pawn.add(new ChessboardPoint(x-1,y));
            }
            if(inBoard(x-1,y-1) && board[x-1][y-1].getChessColor() == ChessColor.BLACK){
                pawn.add(new ChessboardPoint(x-1,y-1));
            }
            if(inBoard(x-1,y+1) && board[x-1][y+1].getChessColor() == ChessColor.BLACK){
                pawn.add(new ChessboardPoint(x-1,y+1));
            }
            if(inBoard(x-2,y) && x == 6 && board[x-1][y].getChessColor() == ChessColor.NONE && board[x-2][y].getChessColor() == ChessColor.NONE){
                pawn.add(new ChessboardPoint(x-2,y));
            }
        }
        if(chessColor == ChessColor.BLACK){
            if(inBoard(x+1,y) && board[x+1][y].getChessColor() == ChessColor.NONE){
                pawn.add(new ChessboardPoint(x+1,y));
            }
            if(inBoard(x+1,y-1) && board[x+1][y-1].getChessColor() == ChessColor.WHITE){
                pawn.add(new ChessboardPoint(x+1,y-1));
            }
            if(inBoard(x+1,y+1) && board[x+1][y+1].getChessColor() == ChessColor.WHITE){
                pawn.add(new ChessboardPoint(x+1,y+1));
            }
            if(inBoard(x+2,y) && x == 1 && board[x+1][y].getChessColor() == ChessColor.NONE && board[x+2][y].getChessColor() == ChessColor.NONE){
                pawn.add(new ChessboardPoint(x+2,y));
            }
        }

        return pawn;
    }
}
