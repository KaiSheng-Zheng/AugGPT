import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class KnightChessComponent extends ChessComponent {
    private ChessboardPoint source = new ChessboardPoint(0, 0);
    private ChessColor chessColor;
    private int cnt;
    private ChessComponent[][] chessComponents;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public int getCnt() {
        return cnt;
    }

    public KnightChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
        this.source.setX(x);
        this.source.setY(y);
        this.setChessColor(name);
        super.name = name;
        this.setCnt(name);
        this.chessComponents = chessComponents;
        super.setSource(new ChessboardPoint(x,y));
    }

    public char getName() {
        return name;
    }

    public void setChessColor(char name) {
        if (name == 'n') {
            this.chessColor = ChessColor.WHITE;
        }
        if (name == 'N') {
            this.chessColor = ChessColor.BLACK;
        }
    }

    public void setCnt(char name) {
        if (name == 'n') {
            this.cnt = 5;
        }
        if (name == 'N') {
            this.cnt = -5;
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMove = new ArrayList<>();
        int X = this.source.getX();
        int Y = this.source.getY();

        if (check(X + 1, Y + 2)) {
            canMove.add(new ChessboardPoint(X + 1, Y + 2));
        }
        if (check(X + 1, Y - 2)) {
            canMove.add(new ChessboardPoint(X + 1, Y - 2));
        }
        if (check(X - 1, Y + 2)) {
            canMove.add(new ChessboardPoint(X - 1, Y + 2));
        }
        if (check(X - 1, Y - 2)) {
            canMove.add(new ChessboardPoint(X - 1, Y - 2));
        }


        if (check(X + 2, Y + 1)) {
            canMove.add(new ChessboardPoint(X + 2, Y + 1));
        }
        if (check(X + 2, Y - 1)) {
            canMove.add(new ChessboardPoint(X + 2, Y - 1));
        }
        if (check(X - 2, Y + 1)) {
            canMove.add(new ChessboardPoint(X - 2, Y + 1));
        }
        if (check(X - 2, Y - 1)) {
            canMove.add(new ChessboardPoint(X - 2, Y - 1));
        }


        rankX(canMove);
        rank(canMove);
        return canMove;
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

    public boolean check(int x, int y) {
        if (x > 7 || x < 0 || y > 7 || y < 0) {
            return false;
        } else {
            if (this.getChessColor() == chessComponents[x][y].getChessColor()) {
                return false;
            }
        }
        return true;
    }
}
