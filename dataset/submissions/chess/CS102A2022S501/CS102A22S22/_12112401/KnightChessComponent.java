
import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponent;

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor,ChessComponent[][] chessComponent) {
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'N';
        } else if (chessColor == ChessColor.WHITE){
            name = 'n';
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
                    if (Math.abs(i - getSource().getX()) == 1 && Math.abs(j - getSource().getY()) == 2){
                        canMoveTo.add(destination);
                    }
                    if (Math.abs(i - getSource().getX()) == 2 && Math.abs(j - getSource().getY()) == 1){
                        canMoveTo.add(destination);
                    }
                }
            }
        }
        return canMoveTo;
    }
}