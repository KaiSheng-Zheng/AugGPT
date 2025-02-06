import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor color){
        if(color.equals(ChessColor.WHITE)) super.name = 'k';
        if(color.equals(ChessColor.BLACK)) super.name = 'K';
        super.setChessColor(color);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x0 = super.getSource().getX();
        int y0 = super.getSource().getY();
        ChessColor thisColor = this.getChessColor();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(i != 0 || j != 0){
                    if(!( super.getSource().offset(i, j) == null )){
                        if(super.chessBoard[x0 + i][y0 + j].toString().equals("_") || !super.chessBoard[x0 + i][y0 + j].getChessColor().equals(thisColor)){
                            canMoveTo.add(new ChessboardPoint(x0 + i, y0 + j));
                        }
                    }
                }
            }
        }
        return canMoveTo;
    }
}