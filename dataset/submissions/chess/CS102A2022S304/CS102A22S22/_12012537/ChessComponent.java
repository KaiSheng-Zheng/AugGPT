import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public boolean first1;

    //should design
    public ChessComponent() {
    }

    public ChessComponent[][] chessboard;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setFirst1(boolean first1) {
        this.first1 = first1;
    }

    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessCompont(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.getName());
    }

}

class KingChessComponent extends ChessComponent { //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    // should design
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        int x = this.getSource().getX(), y = this.getSource().getY();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int xx = x + i;
                int yy = y + j;
                if (i != 0 || j != 0) {
                    if (xx >= 0 && xx < 8 && yy >= 0 && yy < 8) {
                        if (!chessboard[xx][yy].getChessColor().equals(this.chessColor)) {
                            a.add(new ChessboardPoint(xx, yy));
                        }
                    }
                }
            }
        }
        return a;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        if (getChessColor().equals(ChessColor.BLACK)) {
            name = 'K';
        } else if (getChessColor().equals(ChessColor.WHITE)) {
            name = 'k';
        }
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }


    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.getName());

    }


}

class QueenChessComponent extends ChessComponent { //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        int x = this.getSource().getX(), y = this.getSource().getY();
        for (int t = 1; t < 8; t++) {
            if (y + t < 8 && y + t >= 0 && x + t < 8 && x + t >= 0) {
                if (chessboard[x + t][y + t].getName() == '_') {
                    a.add(new ChessboardPoint(x + t, y + t));
                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x + t][y + t].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x + t, y + t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x + t][y + t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x + t, y + t));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }for (int t = 1; t < 8; t++) {
            if (y - t < 8 && y - t >= 0 && x + t < 8 && x + t >= 0) {
                if (chessboard[x + t][y - t].getName() == '_') {
                    a.add(new ChessboardPoint(x + t, y - t));
                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x + t][y - t].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x + t, y - t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x + t][y - t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x + t, y - t));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }for (int t = 1; t < 8; t++) {
            if (y + t < 8 && y + t >= 0 && x - t < 8 && x - t >= 0) {
                if (chessboard[x -t][y + t].getName() == '_') {
                    a.add(new ChessboardPoint(x -t, y + t));

                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x- t][y + t].getChessColor().equals(ChessColor.WHITE)  ) {
                            a.add(new ChessboardPoint(x - t, y + t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x - t][y + t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x - t, y + t));
                            break; 
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;

            }
        }
        for (int t = 1; t < 8; t++) {

            if (y - t < 8 && y - t >= 0 && x - t < 8 && x - t >= 0) {
                if (chessboard[x - t][y - t].getName() == '_') {
                    a.add(new ChessboardPoint(x - t, y - t));
                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x - t][y - t].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x - t, y - t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x - t][y - t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x - t, y - t));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
        for (int t = 1; t < 8; t++) {

            if (x + t < 8 && x + t >= 0) {//only x
                if (chessboard[x + t][y].getName() == '_') {
                    a.add(new ChessboardPoint(x + t, y));

                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x + t][y].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x + t, y));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x + t][y].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x + t, y));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
        for (int t = 1; t < 8; t++) {

            if (x - t < 8 && x - t >= 0) {//only x
                if (chessboard[x - t][y].getName() == '_') {
                    a.add(new ChessboardPoint(x - t, y));

                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x - t][y].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x - t, y));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x - t][y].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x - t, y));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
        for (int t = 1; t < 8; t++) {

            if (y + t < 8 && y + t >= 0) {//only x
                if (chessboard[x][y + t].getName() == '_') {
                    a.add(new ChessboardPoint(x, y + t));

                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x][y + t].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x, y + t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x][y + t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x, y + t));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
        for (int t = 1; t < 8; t++) {
            if (y - t < 8 && y - t >= 0) {//only x
                if (chessboard[x][y - t].getName() == '_') {
                    a.add(new ChessboardPoint(x, y - t));

                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x][y - t].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x, y - t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x][y - t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x, y - t));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
        return a;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {

        if (getChessColor().equals(ChessColor.BLACK)) {
            name = 'Q';
        } else if (getChessColor().equals(ChessColor.WHITE)) {
            name = 'q';
        }
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }


    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.getName());


    }

}

class RookChessComponent extends ChessComponent { //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    // should design
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        int x = this.getSource().getX(), y = this.getSource().getY();
        for (int t = 1; t < 8; t++) {
            if (x + t < 8 && x + t >= 0) {//only x
                if (chessboard[x + t][y].getName() == '_') {
                    a.add(new ChessboardPoint(x + t, y));
                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x + t][y].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x + t, y));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x + t][y].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x + t, y));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
        for (int t = 1; t < 8; t++) {
            if (x - t < 8 && x - t >= 0) {//only x
                if (chessboard[x - t][y].getName() == '_') {
                    a.add(new ChessboardPoint(x - t, y));
                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x - t][y].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x - t, y));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x - t][y].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x - t, y));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
            }
        }

        for (int t = 1; t < 8; t++) {
            if (y + t < 8 && y + t >= 0) {//only x
                if (chessboard[x][y + t].getName() == '_') {
                    a.add(new ChessboardPoint(x, y + t));

                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x][y + t].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x, y + t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x][y + t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x, y + t));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
        for (int t = 1; t < 8; t++) {
            if (y - t < 8 && y - t >= 0) {//only x
                if (chessboard[x][y - t].getName() == '_') {
                    a.add(new ChessboardPoint(x, y - t));

                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x][y - t].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x, y - t));
                            break;

                        } else {
                            break;

                        }
                    } else {
                        if (chessboard[x][y - t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x, y - t));
                            break;

                        } else {
                            break;

                        }
                    }
                }
            } else {
                break;
            }
        }
        return a;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        if (getChessColor().equals(ChessColor.BLACK)) {
            name = 'R';
        } else if (getChessColor().equals(ChessColor.WHITE)) {
            name = 'r';
        }
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.getName());

    }

}

class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        int x = this.getSource().getX(), y = this.getSource().getY();
        for (int t = 1; t < 8; t++) {
            if (y + t < 8 && y + t >= 0 && x + t < 8 && x + t >= 0) {
                if (chessboard[x + t][y + t].getName() == '_') {
                    a.add(new ChessboardPoint(x + t, y + t));
                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x + t][y + t].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x + t, y + t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x + t][y + t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x + t, y + t));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }for (int t = 1; t < 8; t++) {
            if (y - t < 8 && y - t >= 0 && x + t < 8 && x + t >= 0) {
                if (chessboard[x + t][y - t].getName() == '_') {
                    a.add(new ChessboardPoint(x + t, y - t));
                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x + t][y - t].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x + t, y - t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x + t][y - t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x + t, y - t));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }for (int t = 1; t < 8; t++) {
            if (y + t < 8 && y + t >= 0 && x - t < 8 && x - t >= 0) {
                if (chessboard[x -t][y + t].getName() == '_') {
                    a.add(new ChessboardPoint(x -t, y + t));

                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x- t][y + t].getChessColor().equals(ChessColor.WHITE)  ) {
                            a.add(new ChessboardPoint(x - t, y + t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x - t][y + t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x - t, y + t));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;

            }
        }
        for (int t = 1; t < 8; t++) {

            if (y - t < 8 && y - t >= 0 && x - t < 8 && x - t >= 0) {
                if (chessboard[x - t][y - t].getName() == '_') {
                    a.add(new ChessboardPoint(x - t, y - t));
                } else {
                    if (chessColor.equals(ChessColor.BLACK)) {
                        if (chessboard[x - t][y - t].getChessColor().equals(ChessColor.WHITE)) {
                            a.add(new ChessboardPoint(x - t, y - t));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        if (chessboard[x - t][y - t].getChessColor().equals(ChessColor.BLACK)) {
                            a.add(new ChessboardPoint(x - t, y - t));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
        return a;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        if (getChessColor().equals(ChessColor.BLACK)) {
            name = 'B';
        } else if (getChessColor().equals(ChessColor.WHITE)) {
            name = 'b';
        }
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.getName());

    }

}

class KnightChessComponent extends ChessComponent { //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    // should design
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        int x = this.getSource().getX(), y = this.getSource().getY();
        if ((x + 2) < 8 && (x + 2) >= 0 && (y + 1) < 8 && (y + 1) >= 0 && !chessboard[x + 2][y + 1].getChessColor().equals(chessColor)) {
            a.add(new ChessboardPoint(x + 2, y + 1));
        }
        if ((x + 2) < 8 && (x + 2) >= 0 && (y - 1) < 8 && (y - 1) >= 0 && !chessboard[x + 2][y - 1].getChessColor().equals(chessColor)) {
            a.add(new ChessboardPoint(x + 2, y - 1));
        }
        if ((x - 2) < 8 && (x - 2) >= 0 && (y - 1) < 8 && (y - 1) >= 0 && !chessboard[x - 2][y - 1].getChessColor().equals(chessColor)) {
            a.add(new ChessboardPoint(x - 2, y - 1));
        }
        if ((x - 2) < 8 && (x - 2) >= 0 && (y + 1) < 8 && (y + 1) >= 0 && !chessboard[x - 2][y + 1].getChessColor().equals(chessColor)) {
            a.add(new ChessboardPoint(x - 2, y + 1));
        }
        if ((x + 1) < 8 && (x + 1) >= 0 && (y + 2) < 8 && (y + 2) >= 0 && !chessboard[x + 1][y + 2].getChessColor().equals(chessColor)) {
            a.add(new ChessboardPoint(x + 1, y + 2));
        }
        if ((x + 1) < 8 && (x + 1) >= 0 && (y - 2) < 8 && (y - 2) >= 0 && !chessboard[x + 1][y - 2].getChessColor().equals(chessColor)) {
            a.add(new ChessboardPoint(x + 1, y - 2));
        }
        if ((x - 1) < 8 && (x - 1) >= 0 && (y + 2) < 8 && (y + 2) >= 0 && !chessboard[x - 1][y + 2].getChessColor().equals(chessColor)) {
            a.add(new ChessboardPoint(x - 1, y + 2));
        }
        if ((x - 1) < 8 && (x - 1) >= 0 && (y - 2) < 8 && (y - 2) >= 0 && !chessboard[x - 1][y - 2].getChessColor().equals(chessColor)) {
            a.add(new ChessboardPoint(x - 1, y - 2));
        }
        return a;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        if (getChessColor().equals(ChessColor.BLACK)) {
            name = 'N';
        } else if (getChessColor().equals(ChessColor.WHITE)) {
            name = 'n';
        }
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.getName());

    }

}

class PawnChessComponent extends ChessComponent { //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public boolean first1;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
       if(source.getX()==1&&chessColor.equals(ChessColor.BLACK)){
           this.first1=true;
       } else this.first1= source.getX() == 6 && chessColor.equals(ChessColor.WHITE);
    }

    public void setFirst1(boolean first1) {
        this.first1 = first1;
    }

    // should design
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        int x = this.getSource().getX(), y = this.getSource().getY();
        if (this.chessColor.equals(ChessColor.BLACK)) {
            if (x + 1 < 8 && chessboard[x + 1][y].getChessColor().equals(ChessColor.NONE)) {
                a.add(new ChessboardPoint(x + 1, y));
            }
//            boolean k=chessboard[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE);
            if (x + 1 < 8 && y + 1 < 8 && chessboard[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE)) {//xie chi
                a.add(new ChessboardPoint(x + 1, y + 1));
            }
            if (x + 1 < 8 && y - 1 >= 0 && chessboard[x + 1][y - 1].getChessColor().equals(ChessColor.WHITE)) {//xie chi
                a.add(new ChessboardPoint(x + 1, y - 1));
            }
            if (first1) {
                if (x + 2 < 8 &&
                        !chessboard[x + 2][y].getChessColor().equals(ChessColor.BLACK) &&
                        chessboard[x + 1][y].getChessColor().equals(ChessColor.NONE)
                ) {
                    a.add(new ChessboardPoint(x + 2, y));
                }
            }
        } else {//white
            if (x - 1 >=0 && chessboard[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                a.add(new ChessboardPoint(x - 1, y));
            }
            if (x - 1 >= 0 && y + 1 < 8 && chessboard[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                a.add(new ChessboardPoint(x - 1, y + 1));
            }
            if (x - 1 >= 0 && y - 1 >= 0 && chessboard[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                a.add(new ChessboardPoint(x - 1, y - 1));
            }
            if (first1) {
                if (x - 2 >=0 && !chessboard[x - 2][y].getChessColor().equals(ChessColor.WHITE) &&
                        chessboard[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                    a.add(new ChessboardPoint(x - 2, y));
                }
            }
        }
        return a;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        if (getChessColor().equals(ChessColor.BLACK)) {
            name = 'P';
        } else if (getChessColor().equals(ChessColor.WHITE)) {
            name = 'p';
        }
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.getName());

    }

}

class EmptySlotComponent extends ChessComponent { //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    // should design
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        name = '_';
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.getName());

    }

}
