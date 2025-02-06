import java.util.List;

public class PawnChessComponent extends ChessComponent {


    private boolean stayTillNow = true;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessboard) {
        super(source, chessColor, name, chessboard);
    }

    public boolean isStayTillNow() {
        return stayTillNow;
    }

    public void setStayTillNow(boolean stayTillNow) {
        this.stayTillNow = stayTillNow;
    }

    public PawnChessComponent() {
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        //clear in a strange way
        list.clear();
        //fix here if necessary

        ChessboardPoint source = getSource();
        int x = source.getX();
        int y = source.getY();


        //2 positions are considered only
        examine(x, y);

        return list;


    }

    public boolean specialExam(int x, int y) {
        ChessboardPoint point = new ChessboardPoint(x, y);
        if (!chessboard[x][y].getChessColor().equals(getChessColor()) && !chessboard[x][y].getChessColor().equals(ChessColor.NONE)) {
            list.add(point);
            return true;
        } else return false;
    }

    @Override
    public boolean examine(int x, int y) {
        //avoiding the null pointer
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        if (getChessColor().equals(ChessColor.WHITE)) {
            //eat
            if (x - 1 >= 0 && y + 1 < 8) {
                ChessboardPoint point1 = new ChessboardPoint(x - 1, y + 1);
                if (chessboard[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                    list.add(point1);
                }
            }
            if (x - 1 >= 0 && y - 1 >= 0) {
                ChessboardPoint point1 = new ChessboardPoint(x - 1, y - 1);
                if (chessboard[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                    list.add(point1);
                }
            }

            //normal move to empty
            if (x - 1 >= 0) {
                ChessboardPoint point2 = new ChessboardPoint(x - 1, y);
                if (chessboard[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                    list.add(point2);
                    if (x - 2 >= 0) {
                        ChessboardPoint point3 = new ChessboardPoint(x - 2, y);
                        if (chessboard[x - 2][y].getChessColor().equals(ChessColor.NONE)) {
                            list.add(point3);
                        }
                    }
                }
            }
        }else {
                //eat
                if (x + 1 < 8 && y + 1 < 8) {
                    ChessboardPoint point1 = new ChessboardPoint(x + 1, y + 1);
                    if (chessboard[x+1][y+1].getChessColor().equals(ChessColor.WHITE)) {
                        list.add(point1);
                    }
                }
                if (x - 1 >= 0 && y - 1 >= 0) {
                    ChessboardPoint point1 = new ChessboardPoint(x - 1, y - 1);
                    if (chessboard[x-1][y-1].getChessColor().equals(ChessColor.WHITE)) {
                        list.add(point1);
                    }
                }
                //normal move to empty
                if (x + 1 <8) {
                    ChessboardPoint point2 = new ChessboardPoint(x + 1, y);
                    if (chessboard[x+1][y].getChessColor().equals(ChessColor.NONE)) {
                        list.add(point2);
                        if (x + 2<8) {
                            ChessboardPoint point3 = new ChessboardPoint(x + 2, y);
                            if (chessboard[x+2][y].getChessColor().equals(ChessColor.NONE)) {
                                list.add(point3);
                            }
                        }
                    }
                }


            }



        return true;
    }
    public boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (target.getX() == chessboardPoint.getX() && target.getY() == chessboardPoint.getY()) return true;
        }
        return false;
    }
}

