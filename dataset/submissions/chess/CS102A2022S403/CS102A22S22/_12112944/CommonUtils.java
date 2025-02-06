import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CommonUtils {
   
    public static boolean addWedig(String chessColor, int sourceX, int sourceY) {
        if (ConcreteChessGame.chessComponentsCopy[sourceX][sourceY].getChessColor().name().equals(chessColor)) {
            return false;

        }
        return true;
    }

    public static boolean notEmpty(List list) {
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

   
    public static int addWedigRook(String chessColor, int sourceX, int sourceY) {
        ChessComponent chessComponent = ConcreteChessGame.chessComponentsCopy[sourceX][sourceY];
        if ('_' == chessComponent.getName()) {
            return 0;
        } else {
            if (chessComponent.getChessColor().name().equals(chessColor)) {
                return 2;
            }
        }
        return 1;
    }

    public static List<ChessboardPoint> sort(List<ChessboardPoint> chessboardPointList) {
        List<ChessboardPoint> cl = new ArrayList<>();
        List<ChessboardPoint> c2 = new ArrayList<>();
        if (CommonUtils.notEmpty(chessboardPointList)) {
            Collections.sort(chessboardPointList, new Comparator<ChessboardPoint>() {
                @Override
                public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                    return o1.getX() - o2.getX();
                }
            });
            int temp = -1;

            for (int i = 0; i < chessboardPointList.size(); i++) {
                if (chessboardPointList.get(i).getX() != temp) {
                    temp = chessboardPointList.get(i).getX();
                    if (CommonUtils.notEmpty(cl)) {
                        Collections.sort(cl, new Comparator<ChessboardPoint>() {
                            @Override
                            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                                return o1.getY() - o2.getY();
                            }
                        });
                    }
                    c2.addAll(cl);
                    cl.clear();
                }
                cl.add(chessboardPointList.get(i));
                if (i == chessboardPointList.size() - 1) {
                    Collections.sort(cl, new Comparator<ChessboardPoint>() {
                        @Override
                        public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                            return o1.getY() - o2.getY();
                        }
                    });
                    c2.addAll(cl);
                }
            }
        }
        return c2;
    }
}