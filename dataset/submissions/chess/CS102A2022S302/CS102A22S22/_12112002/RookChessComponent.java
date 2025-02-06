import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent() {
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessboard) {
        super(source, chessColor, name, chessboard);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        //clear in a strange way
        list.clear();
        //fix here if necessary

        ChessboardPoint source=getSource();
        int x=source.getX();
        int y=source.getY();

        int fx=x;
        int fy=y;

        //zero x here fix y
        while (x > 0 ) {
            x--;

            if (chessboard[x][y].getChessColor().equals(ChessColor.NONE)) {
                continue;
            } else if (chessboard[x][y].getChessColor().equals(getChessColor())) {
                x++;

                break;
            } else if (!chessboard[x][y].getChessColor().equals(getChessColor())) {
                ChessboardPoint point = new ChessboardPoint(x, y);
                list.add(point);
                x++;
                break;
            }

        }
        for (; x < 8; x++) {
            if (x==fx){
                continue;
            }
            if (!examine(x,y)){
                break;
            };
        }





        //zero y here fix x
        //initiate x,y
        x=fx;
        y=fy;

        while (y > 0 ) {

            y--;

            if (chessboard[x][y].getChessColor().equals(ChessColor.NONE)) {
                continue;
            } else if (chessboard[x][y].getChessColor().equals(getChessColor())) {
                y++;

                break;
            } else if (!chessboard[x][y].getChessColor().equals(getChessColor())) {
                ChessboardPoint point = new ChessboardPoint(x, y);
                list.add(point);
                y++;
                break;
            }

        }
        for (; y < 8; y++) {
            if (y==fy){
                continue;
            }
            if (!examine(x,y)){
                break;
            };
        }

        return list;

    }
    public boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (target.getX() == chessboardPoint.getX() && target.getY() == chessboardPoint.getY()) return true;
        }
        return false;
    }


}
