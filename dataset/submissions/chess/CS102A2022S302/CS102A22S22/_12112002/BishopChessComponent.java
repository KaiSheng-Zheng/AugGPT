import java.util.List;

public class BishopChessComponent extends ChessComponent {


    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessboard) {
        super(source, chessColor, name, chessboard);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {


        //clear in a strange way
        list.clear();
        //fix here if necessary




        ChessboardPoint source = getSource();
        int x = source.getX();
        int y = source.getY();

        int fx=x;
        int fy=y;

/**
 * the first direction of y=x
 */



        //zero x or y first in this direction
        while (x > 0 && y > 0) {
            x--;
            y--;
            //chessboard are null
            if (chessboard[x][y].getChessColor().equals(ChessColor.NONE)) {
                continue;
            } else if (chessboard[x][y].getChessColor().equals(getChessColor())) {
                x++;
                y++;
                break;
            } else if (!chessboard[x][y].getChessColor().equals(getChessColor())) {
                ChessboardPoint point = new ChessboardPoint(x, y);
                list.add(point);
                x++;
                y++;
                break;
            }

        }
        for (; x < 8 && y < 8; x++, y++) {
            if (x==fx){
                continue;
            }
            if (!examine(x,y)){
                break;
            };
        }


/**
 * the second direction of y=-x
 */

        x = fx;
        y = fy;
        //zero y in this direction
        while (y>0&&x<7){
            x++;
            y--;
            if (chessboard[x][y].getChessColor().equals(ChessColor.NONE)) {
                continue;
            } else if (chessboard[x][y].getChessColor().equals(getChessColor())) {
                x--;
                y++;
                break;
            } else if (!chessboard[x][y].getChessColor().equals(getChessColor())) {
                ChessboardPoint point = new ChessboardPoint(x, y);
                list.add(point);
                x--;
                y++;
                break;
            }
        }
        for (;x>-1&&y<8;x--,y++){
            if (x==fx){
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
