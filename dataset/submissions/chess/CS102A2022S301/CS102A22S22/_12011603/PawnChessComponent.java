import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessComponent[][] array = getArray();
        List<ChessboardPoint> list = new ArrayList<>();
        if (getChessColor().equals(ChessColor.BLACK)){
            int nx = source.getX() + 1;
            int ny = source.getY();
            if (!(nx < 0 || nx >= 8 || ny < 0 || ny >= 8)){
                if (array[nx][ny].getChessColor().equals(ChessColor.NONE)){
                    list.add(array[nx][ny].getSource());
                }
            }
            if (source.getX() == 1){
                nx = source.getX() + 2;
                ny = source.getY();
                if (!(nx < 0 || nx >= 8 || ny < 0 || ny >= 8)){
                    if (array[nx][ny].getChessColor().equals(ChessColor.NONE)&&array[nx-1][ny].getChessColor().equals(ChessColor.NONE)){
                        list.add(array[nx][ny].getSource());
                    }
                }
            }
            nx = source.getX() + 1;
            ny = source.getY() - 1;
            if (!(nx < 0 || nx >= 8 || ny < 0 || ny >= 8)){
                if (!array[nx][ny].getChessColor().equals(getChessColor()) && !array[nx][ny].getChessColor().equals(ChessColor.NONE)){
                    list.add(array[nx][ny].getSource());
                }
            }
            nx = source.getX() + 1;
            ny = source.getY() + 1;
            if (!(nx < 0 || nx >= 8 || ny < 0 || ny >= 8)){
                if (!array[nx][ny].getChessColor().equals(getChessColor())&& !array[nx][ny].getChessColor().equals(ChessColor.NONE)){
                    list.add(array[nx][ny].getSource());
                }
            }
        }
        if (getChessColor().equals(ChessColor.WHITE)){
            int nx = source.getX() - 1;
            int ny = source.getY();
            if (!(nx < 0 || nx >= 8 || ny < 0 || ny >= 8)){
                if (array[nx][ny].getChessColor().equals(ChessColor.NONE)){
                    list.add(array[nx][ny].getSource());
                }
            }
            if (source.getX() == 6){
                nx = source.getX() - 2;
                ny = source.getY();
                if (!(nx < 0 || nx >= 8 || ny < 0 || ny >= 8)){
                    if (array[nx][ny].getChessColor().equals(ChessColor.NONE) && array[nx+1][ny].getChessColor().equals(ChessColor.NONE)){
                        list.add(array[nx][ny].getSource());
                    }
                }
            }
            nx = source.getX() - 1;
            ny = source.getY() - 1;
            if (!(nx < 0 || nx >= 8 || ny < 0 || ny >= 8)){
                if (!array[nx][ny].getChessColor().equals(getChessColor())&& !array[nx][ny].getChessColor().equals(ChessColor.NONE)){
                    list.add(array[nx][ny].getSource());
                }
            }
            nx = source.getX() - 1;
            ny = source.getY() + 1;
            if (!(nx < 0 || nx >= 8 || ny < 0 || ny >= 8)){
                if (!array[nx][ny].getChessColor().equals(getChessColor())&& !array[nx][ny].getChessColor().equals(ChessColor.NONE)){
                    list.add(array[nx][ny].getSource());
                }
            }

        }
        return list;
    }
}
