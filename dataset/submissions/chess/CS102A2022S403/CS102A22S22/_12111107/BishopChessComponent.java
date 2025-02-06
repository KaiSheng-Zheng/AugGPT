import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Bishop = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int targetX = source.getX()-1, targetY = source.getY()-1;targetX >= 0 && targetY >= 0 ; targetX--,targetY--){
            if (0 <= targetX && targetX <= 7 && 0 <= targetY && targetY <= 7) {
                if (chessboard[targetX][targetY] instanceof EmptySlotComponent) {
                    Bishop.add(chessboard[targetX][targetY].getSource());
                } else if (!(chessboard[targetX][targetY] instanceof EmptySlotComponent) && chessboard[targetX][targetY].getChessColor() != this.getChessColor()) {
                    Bishop.add(chessboard[targetX][targetY].getSource());
                    break;
                } else break;
            }
            else break;
        }
        for (int targetX = source.getX()+1, targetY = source.getY()+1;targetX <= 7 && targetY >=0 ;targetX++,targetY++){
            if (0 <= targetX && targetX <= 7 && 0 <= targetY && targetY <= 7) {
                if (chessboard[targetX][targetY] instanceof EmptySlotComponent) {
                    Bishop.add(chessboard[targetX][targetY].getSource());
                } else if (!(chessboard[targetX][targetY] instanceof EmptySlotComponent) && chessboard[targetX][targetY].getChessColor() != this.getChessColor()) {
                    Bishop.add(chessboard[targetX][targetY].getSource());
                    break;
                } else break;
            }
            else break;
        }
        for (int targetX = source.getX()-1, targetY = source.getY()+1;targetX >= 0 && targetY<= 7;targetX--,targetY++){
            if (0 <= targetX && targetX <= 7 && 0 <= targetY && targetY <= 7) {
                if (chessboard[targetX][targetY] instanceof EmptySlotComponent) {
                    Bishop.add(chessboard[targetX][targetY].getSource());
                } else if (!(chessboard[targetX][targetY] instanceof EmptySlotComponent) && chessboard[targetX][targetY].getChessColor() != this.getChessColor()) {
                    Bishop.add(chessboard[targetX][targetY].getSource());
                    break;
                } else break;
            }
            else break;
        }
        for (int targetX = source.getX()+1, targetY = source.getY()-1;targetX <= 7 && targetY>= 0;targetX++,targetY--){
            if (0 <= targetX && targetX <= 7 && 0 <= targetY && targetY <= 7) {
                if (chessboard[targetX][targetY] instanceof EmptySlotComponent) {
                    Bishop.add(chessboard[targetX][targetY].getSource());
                } else if (!(chessboard[targetX][targetY] instanceof EmptySlotComponent) && chessboard[targetX][targetY].getChessColor() != this.getChessColor()) {
                    Bishop.add(chessboard[targetX][targetY].getSource());
                    break;
                } else break;
            }
            else break;
        }
        return Bishop;
    }
}
