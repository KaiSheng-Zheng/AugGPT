import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char name,ChessboardPoint source,ChessColor chessColor) {
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
           
            List<ChessboardPoint> upLeft = upLeft(upList, source.getX(), source.getY(), chessColor);

            List<ChessboardPoint> leftList = new ArrayList<>();
           
            List<ChessboardPoint> upRight = upRight(leftList, source.getX(), source.getY(), chessColor);
            List<ChessboardPoint> downList = new ArrayList<>();
          
            List<ChessboardPoint> downLeft = downLeft(downList, source.getX(), source.getY(), chessColor);
            List<ChessboardPoint> rightList = new ArrayList<>();
        
            List<ChessboardPoint> downRight = downRight(rightList, source.getX(), source.getY(), chessColor);

            chessboardPointList.addAll(upLeft);
            chessboardPointList.addAll(upRight);
            chessboardPointList.addAll(downLeft);
            chessboardPointList.addAll(downRight);
        }
        return CommonUtils.sort(chessboardPointList);

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
