import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    //I defined
    protected ChessComponent[][] chessboard = new ChessComponent[8][8];
    protected int chessNum;

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public boolean inChessboard(ChessboardPoint a) {
        if (a.getX() >= 0 && a.getX() <= 7 && a.getY() >= 0 && a.getY() <= 7) {
            return true;
        } else {
            return false;
        }
    }

    //I defined
    public int countCapturedChess() {
        return (chessNum - countLeftChess(getChessboardGraph(), String.valueOf(name)));
    }

    //I defined
    public int countLeftChess(String str, String s) {
        String str1 = str.replaceAll(s, "");
        int len1 = str.length(),len2 = str1.length();
        int count = len1 - len2;
        return count;
    }



    public String getChessboardGraph() {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessboard[i][j].name);
            }
            if (i<7){
                sb.append('\n');}
        }
        return sb.toString();
    }

    //I defined
    public boolean hasNone(ChessboardPoint point){
        if(point==null) return false;
        if(chessboard[point.getX()][point.getY()]==null) return false;
        return (chessboard[point.getX()][point.getY()].name == '_'&&point.getX()>=0
                &&point.getY()>=0&&point.getX()<=7&&point.getY()<=7);
    }
    public boolean hasEnemy(ChessboardPoint point){
        if(point==null) return false;
        if(chessboard[point.getX()][point.getY()]==null) return false;
        if (chessboard[point.getX()][point.getY()].chessColor == ChessColor.NONE) return false;
        return (chessboard[point.getX()][point.getY()].chessColor != this.chessColor&&point.getX()>=0
                &&point.getY()>=0&&point.getX()<=7&&point.getY()<=7);
    }
    public boolean hasFriend(ChessboardPoint point){
//        return false;
        if(point==null) return false;
        if(chessboard[point.getX()][point.getY()]==null) return false;
        return (chessboard[point.getX()][point.getY()].chessColor == this.chessColor);//&&point.getX()>=0
//                &&point.getY()>=0&&point.getX()<=7&&point.getY()<=7);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    //should design
    public ChessComponent() {}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
