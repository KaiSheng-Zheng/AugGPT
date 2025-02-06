import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source = new ChessboardPoint(0, 0);
    private ChessColor chessColor;
    private int cnt;
    private ChessComponent[][] chessComponents;

    private int originX;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public int getCnt() {
        return cnt;
    }

    public PawnChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
        this.source.setX(x);
        this.source.setY(y);
        this.setChessColorAndOriginY(name);
        super.name = name;
        this.setCnt(name);
        this.chessComponents = chessComponents;
        super.setSource(new ChessboardPoint(x,y));
    }

    public char getName() {
        return name;
    }

    public void setChessColorAndOriginY(char name) {
        if (name == 'p') {
            this.chessColor = ChessColor.WHITE;
            this.originX = 6;
        }
        if (name == 'P') {
            this.chessColor = ChessColor.BLACK;
            this.originX = 1;
        }
    }

    public void setCnt(char name) {
        if (name == 'p') {
            this.cnt = 6;
        }
        if (name == 'P') {
            this.cnt = -6;
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMove = new ArrayList<>();
        int X = this.source.getX();
        int Y = this.source.getY();
        int xMove1;
        int xMove2;


        if (this.getChessColor() == ChessColor.WHITE) {
            xMove1 = -1;
            xMove2 = -2;
        } else {
            xMove1 = 1;
            xMove2 = 2;
        }


        if (this.source.getX() == originX && check(X + xMove2, Y)) {
            canMove.add(new ChessboardPoint(X + xMove2, Y));
        }

        if (check(X + xMove1, Y)) {
                canMove.add(new ChessboardPoint(X + xMove1, Y));
            }


        if (X + xMove1 <= 7 && X + xMove1 >= 0 && Y + 1 <= 7 && Y + 1 >= 0) {
            if ((!(chessComponents[X + xMove1][Y + 1] instanceof EmptySlotComponent)) && chessComponents[X + xMove1][Y + 1].getChessColor() != this.getChessColor())
                canMove.add(new ChessboardPoint(X + xMove1, Y + 1));
        }

        if (X + xMove1 <= 7 && X + xMove1 >= 0 && Y - 1 <= 7 && Y - 1 >= 0) {
            if ((!(chessComponents[X + xMove1][Y - 1] instanceof EmptySlotComponent)) && chessComponents[X + xMove1][Y - 1].getChessColor() != this.getChessColor())
                canMove.add(new ChessboardPoint(X + xMove1, Y - 1));
        }

        rankX(canMove);
        rank(canMove);
        return canMove;
    }

    public boolean check(int x, int y) {
        if (x > 7 || x < 0 || y > 7 || y < 0) {
            return false;
        } else {
            if (!(chessComponents[x][y] instanceof EmptySlotComponent)) {
                return false;
            }
        }
        return true;
    }

    public void rank(ArrayList<ChessboardPoint> canMove) {
        int begin = 0;
        int end = 0;
        ArrayList<ChessboardPoint> needToRank = new ArrayList<>();
        canMove.add(new ChessboardPoint(99, 99));
        for (int i = 0; i + 1 < canMove.size(); i++) {
            needToRank.clear();
            if (canMove.get(i).getX() != canMove.get(i + 1).getX()) {
                end = i;
            } else {
                continue;
            }

            if (begin == end) {
                begin = end + 1;
                continue;
            } else {
                for (int j = begin; j <= end; j++) {
                    needToRank.add(canMove.get(j));
                }
                rankY(needToRank);
                for (int j = begin, k = 0; j <= end && k < needToRank.size(); j++, k++) {
                    canMove.set(j, needToRank.get(k));
                }
                begin = end + 1;
            }
        }
        canMove.remove(canMove.size() - 1);
    }


    public void rankX(ArrayList<ChessboardPoint> needToRank) {
        Collections.sort(needToRank, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                Integer x1 = o1.getX();
                Integer x2 = o2.getX();
                return x1.compareTo(x2);
            }
        });
    }


    public void rankY(ArrayList<ChessboardPoint> needToRank) {
        Collections.sort(needToRank, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                Integer y1 = o1.getY();
                Integer y2 = o2.getY();
                return y1.compareTo(y2);
            }
        });
    }

}
