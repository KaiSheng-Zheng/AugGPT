import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessComponent[][] array = getArray();
        List<ChessboardPoint> list = new ArrayList<>();
        int [][]dir = new int[][]{{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};
        for (int i = 0; i < 8; i++){
            int nx = source.getX() + dir[i][0];
            int ny = source.getY() + dir[i][1];
            if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8){
                continue;
            }
            if (!array[nx][ny].getChessColor().equals(getChessColor())){
                list.add(array[nx][ny].getSource());
            }
        }
        return list;
    }
}
