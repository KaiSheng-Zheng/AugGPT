import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(char name,ChessboardPoint source,ChessColor chessColor) {
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

            List<ChessboardPoint> downList = new ArrayList<>();
            List<ChessboardPoint> down = down(downList, source.getX(), source.getY(), chessColor);

            List<ChessboardPoint> leftList = new ArrayList<>();
            List<ChessboardPoint> left = left(leftList, source.getX(), source.getY(), chessColor);

            List<ChessboardPoint> rightList = new ArrayList<>();
            List<ChessboardPoint> right = right(rightList, source.getX(), source.getY(), chessColor);

            List<ChessboardPoint> upLeftList = new ArrayList<>();
            List<ChessboardPoint> upLeft = upLeft(upLeftList, source.getX(), source.getY(), chessColor);

            List<ChessboardPoint> upRightList = new ArrayList<>();
            List<ChessboardPoint> upRight = upRight(upRightList, source.getX(), source.getY(), chessColor);

            List<ChessboardPoint> downLeftList = new ArrayList<>();
            List<ChessboardPoint> downLeft = downLeft(downLeftList, source.getX(), source.getY(), chessColor);

            List<ChessboardPoint> downRightList = new ArrayList<>();
            List<ChessboardPoint> downRight = downRight(downRightList, source.getX(), source.getY(), chessColor);


            chessboardPointList.addAll(up);
            chessboardPointList.addAll(right);
            chessboardPointList.addAll(left);
            chessboardPointList.addAll(down);
            chessboardPointList.addAll(upLeft);
            chessboardPointList.addAll(upRight);
            chessboardPointList.addAll(downLeft);
            chessboardPointList.addAll(downRight);
        }
        return CommonUtils.sort(chessboardPointList);
    }

    private List<ChessboardPoint> right(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int m = y + 1;
        if (m < 8) {
            if (CommonUtils.addWedigRook(chessColor.name(), x, m) == 0) {
                chessboardPointList.add(new ChessboardPoint(x, m));
                right(chessboardPointList, x, m, chessColor);
            } else if (CommonUtils.addWedigRook(chessColor.name(), x, m) == 1) {
                chessboardPointList.add(new ChessboardPoint(x, m));
            }
        }
        return chessboardPointList;
    }

    private List<ChessboardPoint> left(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int m = y - 1;
        if (m >= 0) {
            if (CommonUtils.addWedigRook(chessColor.name(), x, m) == 0) {
                chessboardPointList.add(new ChessboardPoint(x, m));
                left(chessboardPointList, x, m, chessColor);
            } else if (CommonUtils.addWedigRook(chessColor.name(), x, m) == 1) {
                chessboardPointList.add(new ChessboardPoint(x, m));
            }
        }
        return chessboardPointList;
    }

    private List<ChessboardPoint> down(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int n = x + 1;
        if (n < 8) {
            if (CommonUtils.addWedigRook(chessColor.name(), n, y) == 0) {
                chessboardPointList.add(new ChessboardPoint(n, y));
                down(chessboardPointList, n, y, chessColor);
            } else if (CommonUtils.addWedigRook(chessColor.name(), n, y) == 1) {
                chessboardPointList.add(new ChessboardPoint(n, y));
            }
        }
        return chessboardPointList;
    }

    private List<ChessboardPoint> up(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int n = x - 1;
        if (n >= 0) {
            if (CommonUtils.addWedigRook(chessColor.name(), n, y) == 0) {
                chessboardPointList.add(new ChessboardPoint(n, y));
                up(chessboardPointList, n, y, chessColor);
            } else if (CommonUtils.addWedigRook(chessColor.name(), n, y) == 1) {
                chessboardPointList.add(new ChessboardPoint(n, y));
            }
        }
        return chessboardPointList;
    }

    private List<ChessboardPoint> downRight(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int m = y + 1;
        int n = x + 1;
        if (m < 8 && n < 8) {
            if(CommonUtils.addWedigRook(chessColor.name(),n,m)==0){
                chessboardPointList.add(new ChessboardPoint(n,m));
                downRight(chessboardPointList,n,m,chessColor);
            }
            else if(CommonUtils.addWedigRook(chessColor.name(),n,m)==1){
                chessboardPointList.add(new ChessboardPoint(n,m));
            }
        }
        return chessboardPointList;
    }

    private List<ChessboardPoint> downLeft(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int n = x + 1;
        int m = y - 1;
        if(n< 8 && m>=0){
            if(CommonUtils.addWedigRook(chessColor.name(),n,m)==0){
                chessboardPointList.add(new ChessboardPoint(n,m));
                downLeft(chessboardPointList,n,m,chessColor);
            }
            else if(CommonUtils.addWedigRook(chessColor.name(),n,m)==1){
                chessboardPointList.add(new ChessboardPoint(n,m));
            }
        }
        return chessboardPointList;

    }


    private List<ChessboardPoint> upRight(List<ChessboardPoint> chessboardPointList, int x, int y, ChessColor chessColor) {
        int m = y + 1;
        int n = x - 1;
        if (n >= 0 && m<8) {
            if(CommonUtils.addWedigRook(chessColor.name(),n,m)==0){
                chessboardPointList.add(new ChessboardPoint(n,m));
                upRight(chessboardPointList,n,m,chessColor);
            }
            else if(CommonUtils.addWedigRook(chessColor.name(),n,m)==1){
                chessboardPointList.add(new ChessboardPoint(n,m));
            }
        }
        return chessboardPointList;
    }

    private List<ChessboardPoint> upLeft(List<ChessboardPoint> chessboardPointList,int x, int y, ChessColor chessColor) {
        int n = x - 1;
        int m = y - 1;
        if (m >= 0 && n>=0) {
            if (CommonUtils.addWedigRook(chessColor.name(), n,m) == 0) {
                chessboardPointList.add(new ChessboardPoint(n,m));
                upLeft(chessboardPointList,n,m, chessColor);
            }
            else if(CommonUtils.addWedigRook(chessColor.name(), n,m) == 1){
                chessboardPointList.add(new ChessboardPoint(n,m));
            }
        }
        return chessboardPointList;
    }
}
