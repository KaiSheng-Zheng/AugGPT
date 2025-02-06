import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessComponent[][] array = getArray();
        List<ChessboardPoint> list = new ArrayList<>();
        int [][]dir = new int[][]{{1,1}, {1,-1}, {-1,1}, {-1,-1}};
        for (int j = 0; j < 4; j++){
            for (int i = 1; i < 8; i++){
                int nx = source.getX() + dir[j][0] * i;
                int ny = source.getY() + dir[j][1] * i;
                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8){
                    break;
                }
                if (!array[nx][ny].getChessColor().equals(getChessColor())){
                    list.add(array[nx][ny].getSource());
                    if (array[nx][ny].getChessColor().equals(ChessColor.NONE)){
                        continue;
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }
        }

        return list;
    }
}
