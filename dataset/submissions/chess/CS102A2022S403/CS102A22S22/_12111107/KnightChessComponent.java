import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Knight = new ArrayList<>();
        ChessboardPoint source = getSource();
        int targetX = source.getX();
        int targetY = source.getY();
        if (0<=targetX-2&&targetX-2<=7&&0<=targetY-1&&targetY-1<=7){
            if (chessboard[targetX-2][targetY-1].getChessColor() != this.getChessColor()){
                Knight.add(chessboard[targetX-2][targetY-1].getSource());
            }
        }
        if (0<=targetX-2&&targetX-2<=7&&0<=targetY+1&&targetY+1<=7){
            if (chessboard[targetX-2][targetY+1].getChessColor() != this.getChessColor()){
                Knight.add(chessboard[targetX-2][targetY+1].getSource());
            }
        }
        if (0<=targetX+2&&targetX+2<=7&&0<=targetY-1&&targetY-1<=7){
            if (chessboard[targetX+2][targetY-1].getChessColor() != this.getChessColor()){
                Knight.add(chessboard[targetX+2][targetY-1].getSource());
            }
        }
        if (0<=targetX+2&&targetX+2<=7&&0<=targetY+1&&targetY+1<=7){
            if (chessboard[targetX+2][targetY+1].getChessColor() != this.getChessColor()){
                Knight.add(chessboard[targetX+2][targetY+1].getSource());
            }
        }
        if (0<=targetX-1&&targetX-1<=7&&0<=targetY-2&&targetY-2<=7){
            if (chessboard[targetX-1][targetY-2].getChessColor() != this.getChessColor()){
                Knight.add(chessboard[targetX-1][targetY-2].getSource());
            }
        }
        if (0<=targetX-1&&targetX-1<=7&&0<=targetY+2&&targetY+2<=7){
            if (chessboard[targetX-1][targetY+2].getChessColor() != this.getChessColor()){
                Knight.add(chessboard[targetX-1][targetY+2].getSource());
            }
        }
        if (0<=targetX+1&&targetX+1<=7&&0<=targetY-2&&targetY-2<=7){
            if (chessboard[targetX+1][targetY-2].getChessColor() != this.getChessColor()){
                Knight.add(chessboard[targetX+1][targetY-2].getSource());
            }
        }
        if (0<=targetX+1&&targetX+1<=7&&0<=targetY+2&&targetY+2<=7){
            if (chessboard[targetX+1][targetY+2].getChessColor() != this.getChessColor()){
                Knight.add(chessboard[targetX+1][targetY+2].getSource());
            }
        }
        return Knight;
    }
}
