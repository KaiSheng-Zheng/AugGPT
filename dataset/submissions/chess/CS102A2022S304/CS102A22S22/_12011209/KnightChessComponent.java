import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor color){
        if(color.equals(ChessColor.WHITE)) super.name = 'n';
        if(color.equals(ChessColor.BLACK)) super.name = 'N';
        super.setChessColor(color);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x0 = super.getSource().getX();
        int y0 = super.getSource().getY();
        int[][] coordinates = new int[][]{{-1, 2}, {1, 2}, {1, -2}, {-1, -2}, {-2, 1}, {-2, -1}, {2, -1}, {2, 1}};
        for (int i = 0; i < 8; i++) {
            if(!( super.getSource().offset(coordinates[i][0], coordinates[i][1]) == null )){
                if(super.chessBoard[ x0 + coordinates[i][0] ][ y0 + coordinates[i][1] ].toString().equals("_") || !super.chessBoard[ x0 + coordinates[i][0] ][ y0 + coordinates[i][1] ].getChessColor().equals(this.getChessColor())){
                    canMoveTo.add(new ChessboardPoint(x0 + coordinates[i][0], y0 + coordinates[i][1]));
                }
            }
        }
        return canMoveTo;
    }
}
