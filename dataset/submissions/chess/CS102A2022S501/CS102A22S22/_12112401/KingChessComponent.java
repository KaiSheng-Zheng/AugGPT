import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponent;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor,ChessComponent[][] chessComponent) {
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'K';
        } else if (chessColor == ChessColor.WHITE){
            name = 'k';
        }
        this.chessComponent=chessComponent;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessboardPoint destination ;
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                destination = new ChessboardPoint(i,j);
                if (!(chessComponent[i][j].getChessColor() == getChessColor())){
                    if (Math.abs(getSource().getX() - i) <= 1 && Math.abs(getSource().getY() - j) <= 1 && chessComponent[i][j] instanceof EmptySlotComponent){
                        canMoveTo.add(destination);
                    }
                }
            }
        }
        return canMoveTo;
    }
}