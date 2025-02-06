import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor, ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        if(chessColor==ChessColor.BLACK){
            name = 'N';
        }
        if(chessColor==ChessColor.WHITE){
            name = 'n';
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int chushiX = getSource().getX();
        int chushiY = getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard[i][j].getChessColor() != this.getChessColor()) {
                    if ((i == chushiX + 1 && j == chushiY + 2) || (i == chushiX - 1 && j == chushiY + 2) || (i == chushiX - 2 && j == chushiY + 1) || (i == chushiX + 2 && j == chushiY - 1) || (i == chushiX + 2 && j == chushiY + 1) || (i == chushiX - 2 && j == chushiY - 1) || (i == chushiX - 1 && j == chushiY - 2)||(i == chushiX + 1 && j == chushiY - 2)) {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                        chessboardPoints.add(chessboardPoint);
                    }
                }
            }
        }
        return chessboardPoints;
    }
}
