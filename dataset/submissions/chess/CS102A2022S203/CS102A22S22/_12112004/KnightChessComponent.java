import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ChessboardPoint = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (moveChess(source.getX(),source.getY(),i,j)){
                    ChessboardPoint.add(new ChessboardPoint(i,j));
                }

            }
        }
        return ChessboardPoint;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        boolean a = Math.abs(sourceX-targetX) == 2 && Math.abs(sourceY-targetY) ==1|| (Math.abs(sourceX-targetX)==1 && Math.abs(sourceY-targetY) == 2);
        return a && super.getChessColor() != chessComponents[targetX][targetY].getChessColor();
    }

}
