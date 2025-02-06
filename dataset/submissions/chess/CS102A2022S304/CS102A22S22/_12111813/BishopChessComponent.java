import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source = new ChessboardPoint(0,0);
    private ChessColor chessColor;

    private int cnt;
    private ChessComponent[][] chessComponents;


    public ChessColor getChessColor() {
        return chessColor;
    }

    public int getCnt() {
        return cnt;
    }

    public BishopChessComponent(int x, int y, char name,ChessComponent[][] chessComponents) {
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

    public void setChessColor(char name){
        if (name=='b'){this.chessColor = ChessColor.WHITE;}
        if (name=='B'){this.chessColor = ChessColor.BLACK;}
    }

    public void setCnt(char name){
        if (name=='b'){this.cnt = 4;}
        if (name=='B'){this.cnt = -4;}
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMove = new ArrayList<>();
        int X = this.source.getX();
        int Y = this.source.getY();



        //move on xy
        for (int i = 1; X + i < 8 && Y + i < 8; i++) {
            if (chessComponents[X + i][Y + i] instanceof EmptySlotComponent) {
                canMove.add(new ChessboardPoint(X + i, Y + i));
            } else {
                if (chessComponents[X + i][Y + i].getChessColor() != this.getChessColor()) {
                    canMove.add(new ChessboardPoint(X + i, Y + i));
                }
                break;
            }
        }
        for (int i = 1; X - i > -1 && Y - i > -1; i++) {
            if (chessComponents[X - i][Y - i] instanceof EmptySlotComponent) {
                canMove.add(new ChessboardPoint(X - i, Y - i));
            } else {
                if (chessComponents[X - i][Y - i].getChessColor() != this.getChessColor()) {
                    canMove.add(new ChessboardPoint(X - i, Y - i));
                }
                break;
            }
        }
        //move on xy
        for (int i = 1; X + i < 8 && Y - i > -1; i++) {
            if (chessComponents[X + i][Y - i] instanceof EmptySlotComponent) {
                canMove.add(new ChessboardPoint(X + i, Y - i));
            } else {
                if (chessComponents[X + i][Y - i].getChessColor() != this.getChessColor()) {
                    canMove.add(new ChessboardPoint(X + i, Y - i));
                }
                break;
            }
        }
        for (int i = 1; X - i > -1 && Y + i < 8; i++) {
            if (chessComponents[X - i][Y + i] instanceof EmptySlotComponent) {
                canMove.add(new ChessboardPoint(X - i, Y + i));
            } else {
                if (chessComponents[X - i][Y + i].getChessColor() != this.getChessColor()) {
                    canMove.add(new ChessboardPoint(X - i, Y + i));
                }
                break;
            }
        }

        rankX(canMove);
        rank(canMove);
        return canMove;
    }
    public void rank(ArrayList<ChessboardPoint> canMove){
        int begin = 0;
        int end = 0;
        ArrayList<ChessboardPoint> needToRank = new ArrayList<>();
        canMove.add(new ChessboardPoint(99,99));
        for (int i = 0; i+1< canMove.size(); i++) {
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
        canMove.remove(canMove.size()-1);
    }


    public void rankX(ArrayList<ChessboardPoint> needToRank){
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
