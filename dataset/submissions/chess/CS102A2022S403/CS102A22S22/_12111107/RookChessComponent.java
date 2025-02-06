import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Rook = new ArrayList<>();
        ChessboardPoint source = getSource();
       for (int targetX = source.getX()+1, targetY = source.getY();targetX <= 7;targetX++){
           if (0 <= targetX && targetX <= 7 && 0 <= targetY && targetY <= 7) {
               if (chessboard[targetX][targetY] instanceof EmptySlotComponent) {
                   Rook.add(chessboard[targetX][targetY].getSource());
               } else if (!(chessboard[targetX][targetY] instanceof EmptySlotComponent) && chessboard[targetX][targetY].getChessColor() != this.getChessColor()) {
                   Rook.add(chessboard[targetX][targetY].getSource());
                   break;
               } else break;
           }
           else break;
       }
        for (int targetX = source.getX()-1, targetY = source.getY();targetX >= 0;targetX--){
            if (0 <= targetX && targetX <= 7 && 0 <= targetY && targetY <= 7) {
                if (chessboard[targetX][targetY] instanceof EmptySlotComponent) {
                    Rook.add(chessboard[targetX][targetY].getSource());
                } else if (!(chessboard[targetX][targetY] instanceof EmptySlotComponent) && chessboard[targetX][targetY].getChessColor() != this.getChessColor()) {
                    Rook.add(chessboard[targetX][targetY].getSource());
                    break;
                } else break;
            }
            else break;
        }
        for (int targetX = source.getX(), targetY = source.getY()-1;targetY >= 0;targetY--){
            if (0 <= targetX && targetX <= 7 && 0 <= targetY && targetY <= 7) {
                if (chessboard[targetX][targetY] instanceof EmptySlotComponent) {
                    Rook.add(chessboard[targetX][targetY].getSource());
                } else if (!(chessboard[targetX][targetY] instanceof EmptySlotComponent) && chessboard[targetX][targetY].getChessColor() != this.getChessColor()) {
                    Rook.add(chessboard[targetX][targetY].getSource());
                    break;
                } else break;
            }
            else break;
        }
        for (int targetX = source.getX(), targetY = source.getY()+1;targetY <= 7;targetY++){
            if (0 <= targetX && targetX <= 7 && 0 <= targetY && targetY <= 7) {
                if (chessboard[targetX][targetY] instanceof EmptySlotComponent) {
                    Rook.add(chessboard[targetX][targetY].getSource());
                } else if (!(chessboard[targetX][targetY] instanceof EmptySlotComponent) && chessboard[targetX][targetY].getChessColor() != this.getChessColor()) {
                    Rook.add(chessboard[targetX][targetY].getSource());
                    break;
                } else break;
            }
            else break;
        }
        return Rook;
    }
}
