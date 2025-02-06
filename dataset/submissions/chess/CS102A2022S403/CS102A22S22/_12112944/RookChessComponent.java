import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(char name, ChessboardPoint source, ChessColor chessColor) {
        setName(name);
        setChessColor(chessColor);
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        ChessboardPoint source = getSource();

        if (source != null) {
            ChessColor chessColor = getChessColor();
            List<ChessboardPoint> upList = new ArrayList<>();
         
            List<ChessboardPoint> up = up(upList, source.getX(), source.getY(), chessColor);

            List<ChessboardPoint> leftList = new ArrayList<>();
         
            List<ChessboardPoint> left = left(leftList, source.getX(), source.getY(), chessColor);
            List<ChessboardPoint> downList = new ArrayList<>();
      
            List<ChessboardPoint> down = down(downList, source.getX(), source.getY(), chessColor);
            List<ChessboardPoint> rightList = new ArrayList<>();
      
            List<ChessboardPoint> right = right(rightList, source.getX(), source.getY(), chessColor);

            chessboardPointList.addAll(up);
            chessboardPointList.addAll(left);
            chessboardPointList.addAll(down);
            chessboardPointList.addAll(right);
        }
        return CommonUtils.sort(chessboardPointList);

    }

    private List<ChessboardPoint> right(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int temp = y + 1;
        if (temp < 8) {
            if (CommonUtils.addWedigRook(chessColor.name(), x, temp) == 0) {
                chessboardPointList.add(new ChessboardPoint(x, temp));
                right(chessboardPointList, x, temp, chessColor);
            } else if (CommonUtils.addWedigRook(chessColor.name(), x, temp) == 1) {
                chessboardPointList.add(new ChessboardPoint(x, temp));
            }
        }
        return chessboardPointList;
    }

    private List<ChessboardPoint> down(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int temp = x + 1;
        if (temp < 8) {
            if (CommonUtils.addWedigRook(chessColor.name(), temp, y) == 0) {
                chessboardPointList.add(new ChessboardPoint(temp, y));
                down(chessboardPointList, temp, y, chessColor);
            } else if (CommonUtils.addWedigRook(chessColor.name(), temp, y) == 1) {
                chessboardPointList.add(new ChessboardPoint(temp, y));
            }
        }
        return chessboardPointList;

    }


    private List<ChessboardPoint> left(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int temp = y - 1;
        if (temp >= 0) {
            if (CommonUtils.addWedigRook(chessColor.name(), x, temp) == 0) {
                chessboardPointList.add(new ChessboardPoint(x, temp));
                left(chessboardPointList, x, temp, chessColor);
            } else if (CommonUtils.addWedigRook(chessColor.name(), x, temp) == 1) {
                chessboardPointList.add(new ChessboardPoint(x, temp));
            }
        }
        return chessboardPointList;
    }

    private List<ChessboardPoint> up(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int temp = x - 1;
        if (temp >= 0) {
            if (CommonUtils.addWedigRook(chessColor.name(), temp, y) == 0) {
                chessboardPointList.add(new ChessboardPoint(temp, y));
                up(chessboardPointList, temp, y, chessColor);
            } else if (CommonUtils.addWedigRook(chessColor.name(), temp, y) == 1) {
                chessboardPointList.add(new ChessboardPoint(temp, y));
            }
        }
        return chessboardPointList;
    }
}
