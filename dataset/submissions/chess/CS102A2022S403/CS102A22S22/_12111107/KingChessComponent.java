import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> King = new ArrayList<>();
        ChessboardPoint source = getSource();
        int targetX = source.getX();
        int targetY = source.getY();
        if (0<=targetX-1&&targetX-1<=7&&0<=targetY-1&&targetY-1<=7){
            if (chessboard[targetX-1][targetY-1].getChessColor() != this.getChessColor()){
                King.add(chessboard[targetX-1][targetY-1].getSource());
            }
        }
        if (0<=targetX-1&&targetX-1<=7&&0<=targetY&&targetY<=7){
            if (chessboard[targetX-1][targetY].getChessColor() != this.getChessColor()){
                King.add(chessboard[targetX-1][targetY].getSource());
            }
        }
        if (0<=targetX-1&&targetX-1<=7&&0<=targetY+1&&targetY+1<=7){
            if (chessboard[targetX-1][targetY+1].getChessColor() != this.getChessColor()){
                King.add(chessboard[targetX-1][targetY+1].getSource());
            }
        }
        if (0<=targetX&&targetX<=7&&0<=targetY-1&&targetY-1<=7){
            if (chessboard[targetX][targetY-1].getChessColor() != this.getChessColor()){
                King.add(chessboard[targetX][targetY-1].getSource());
            }
        }
        if (0<=targetX&&targetX<=7&&0<=targetY+1&&targetY+1<=7){
            if (chessboard[targetX][targetY+1].getChessColor() != this.getChessColor()){
                King.add(chessboard[targetX][targetY+1].getSource());
            }
        }
        if (0<=targetX+1&&targetX+1<=7&&0<=targetY-1&&targetY-1<=7){
            if (chessboard[targetX+1][targetY-1].getChessColor() != this.getChessColor()){
                King.add(chessboard[targetX+1][targetY-1].getSource());
            }
        }
        if (0<=targetX+1&&targetX+1<=7&&0<=targetY&&targetY<=7){
            if (chessboard[targetX+1][targetY].getChessColor() != this.getChessColor()){
                King.add(chessboard[targetX+1][targetY].getSource());
            }
        }
        if (0<=targetX+1&&targetX+1<=7&&0<=targetY+1&&targetY+1<=7){
            if (chessboard[targetX+1][targetY+1].getChessColor() != this.getChessColor()){
                King.add(chessboard[targetX+1][targetY+1].getSource());
            }
        }
        return King;
    }
}
