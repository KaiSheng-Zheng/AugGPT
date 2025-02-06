import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class ChessComponent  {
    //should design

    private ChessColor chessColor;
    private ChessboardPoint source;
    ChessComponent[][] chessComponents;
    protected char name;

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    //should design
    public ChessComponent() {
    }

    public ChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
        this.chessColor = color;
        this.source=source;
        this.chessComponents=chessComponents;
    }

    public ChessboardPoint getSource() {
        return source;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public char getName() {
        return name;
    }

//    public ChessComponent[][]  getchessComponents() {
//        return chessComponents;
//    }

    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


}


class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
        super(color,source,chessComponents);
        this.name=color.equals(ChessColor.WHITE)?'k':'K';

    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        int newx;
        int newy;
        List<ChessboardPoint> Able = new ArrayList<>();
        for (int i = -1; i <=1; i++) {
            for (int j = -1; j <= 1 ; j++) {
                if(!(i==0&&j==0)){
                    if(getSource().getX()+i<8 &&getSource().getX()+i>=0 && getSource().getY()+j<8 &&getSource().getY()+j>=0){
                        newx=getSource().getX()+i;
                        newy = getSource().getY()+j;
                        if(chessComponents[newx][newy].getChessColor()!=chessComponents[getSource().getX()][getSource().getY()].getChessColor()){
                            Able.add(new ChessboardPoint(newx,newy));
                        }
                    }
                }
            }

        }
        Collections.sort(Able);
        return Able;
    }
}

class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
        super(color,source,chessComponents);
        this.name=color.equals(ChessColor.WHITE)?'q':'Q';

    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        int newx;
        int newy;
        List<ChessboardPoint> Able = new ArrayList<>();
        int[] dx = {1,1,1,0,-1,-1,-1,0};
        int[] dy = {1,0,-1,-1,-1,0,1,1};
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    newx = getSource().getX() + dx[i] * j;
                    newy = getSource().getY() + dy[i] * j;
                    if (newy >= 0 && newx >= 0 && newy < 8 && newx < 8) {

                        if (chessComponents[newx][newy].getChessColor() == ChessColor.NONE && chessComponents[newx][newy].getChessColor() != chessComponents[getSource().getX()][getSource().getY()].getChessColor()) {
                            Able.add(new ChessboardPoint(newx, newy));
                        } else if (chessComponents[newx][newy].getChessColor() != ChessColor.NONE && chessComponents[newx][newy].getChessColor() != chessComponents[getSource().getX()][getSource().getY()].getChessColor()) {
                            Able.add(new ChessboardPoint(newx, newy));
                            break;
                        } else if (getSource().getX() == newx && getSource().getY() == newy) {
                        } else {
                            break;
                        }

                    }
                }
            }
            Collections.sort(Able);
            return Able;
        
    }
}

class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
        super(color,source,chessComponents);
        this.name=color.equals(ChessColor.WHITE)?'r':'R';

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int newx;
        int newy;

        List<ChessboardPoint> Able = new ArrayList<>();
        int[] dx = {0,-1,0,1};
        int[] dy = {1,0,-1,0};
        int x = getSource().getX();
        int y = getSource().getY();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    newx = x + dx[i] * j;
                    newy = y + dy[i] * j;
                    if (newy >= 0 && newx >= 0 && newy < 8 && newx < 8) {
                        if (chessComponents[newx][newy].getChessColor() == ChessColor.NONE && chessComponents[newx][newy].getChessColor() != chessComponents[x][y].getChessColor()) {
                            Able.add(new ChessboardPoint(newx, newy));
                        } else if (chessComponents[newx][newy].getChessColor() != ChessColor.NONE && chessComponents[newx][newy].getChessColor() != chessComponents[x][y].getChessColor()) {
                            Able.add(new ChessboardPoint(newx, newy));
                            break;
                        } else if (x == newx && y == newy) {
                        } else {
                            break;
                        }

                    }
                }
            }
            Collections.sort(Able);
            return Able;
        }

}

class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
        super(color,source,chessComponents);
        this.name=color.equals(ChessColor.WHITE)?'b':'B';

    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        int newx;
        int newy;
        List<ChessboardPoint> Able = new ArrayList<>();
        int[] dx = {1,-1,1,-1};
        int[] dy = {-1,1,1,-1};

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 7; j++) {
                    newx = getSource().getX() + dx[i] * j;
                    newy = getSource().getY() + dy[i] * j;
                    if (newy >= 0 && newx >= 0 && newy < 8 && newx < 8) {

                        if (chessComponents[newx][newy].getChessColor() == ChessColor.NONE && chessComponents[newx][newy].getChessColor() != chessComponents[getSource().getX()][getSource().getY()].getChessColor()) {
                            Able.add(new ChessboardPoint(newx, newy));
                        } else if (chessComponents[newx][newy].getChessColor() != ChessColor.NONE && chessComponents[newx][newy].getChessColor() != chessComponents[getSource().getX()][getSource().getY()].getChessColor()) {
                            Able.add(new ChessboardPoint(newx, newy));
                            break;
                        } else if (getSource().getX() == newx && getSource().getY() == newy) {
                        } else {
                            break;
                        }
                    }
                }
            }
            Collections.sort(Able);
            return Able;


    }


}

class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
        super(color,source,chessComponents);
        this.name=color.equals(ChessColor.WHITE)?'n':'N';

    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        int newx;
        int newy;
        List<ChessboardPoint> Able = new ArrayList<>();
        int[] dx = {-1,2,-2,1,-1,2,-2,1};
        int[] dy = {2,1,-1,-2,-2,-1,1,2};
            for (int i = 0; i < 8; i++) {
                newx = getSource().getX() + dx[i];
                newy = getSource().getY() + dy[i];
                if (newx >= 0 && newy < 8 && newx < 8 && newy >= 0) {
                    if (chessComponents[newx][newy].getChessColor() != chessComponents[getSource().getX()][getSource().getY()].getChessColor()) {
                        Able.add(new ChessboardPoint(newx, newy));
                    }
                }
            }
            Collections.sort(Able);
            return Able;

    }
}

class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
        super(color,source,chessComponents);
        this.name=color.equals(ChessColor.WHITE)?'p':'P';

    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        int newx;
        int newy;
        List<ChessboardPoint> Able = new ArrayList<>();


            if (chessComponents[getSource().getX()][getSource().getY()].getChessColor() == ChessColor.WHITE) {
                if (getSource().getX() == 6) {
                    if (chessComponents[getSource().getX() - 1][getSource().getY()].getChessColor() == ChessColor.NONE) {
                        Able.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                    }
                    if(chessComponents[getSource().getX() - 1][getSource().getY()].getChessColor() == ChessColor.NONE&&chessComponents[getSource().getX() - 2][getSource().getY()].getChessColor() == ChessColor.NONE){
                        Able.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY()));
                    }
                }
                if (getSource().getX() != 6 && getSource().getX() != 0) {
                    if (chessComponents[getSource().getX() - 1][getSource().getY()].getChessColor() == ChessColor.NONE) {
                        Able.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                    }
                }

                if (getSource().getX() != 0 && getSource().getY() != 7) {
                    if (chessComponents[getSource().getX() - 1][getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                        Able.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                }
                if (getSource().getX() != 0 && getSource().getY() != 0) {
                    if (chessComponents[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                        Able.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                }


            } else if (chessComponents[getSource().getX()][getSource().getY()].getChessColor() == ChessColor.BLACK) {
                if (getSource().getX() == 1) {
                    if (chessComponents[getSource().getX() + 1][getSource().getY()].getChessColor() == ChessColor.NONE) {
                        Able.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                    }
                    if(chessComponents[getSource().getX() + 1][getSource().getY()].getChessColor() == ChessColor.NONE&&chessComponents[getSource().getX() + 2][getSource().getY()].getChessColor() == ChessColor.NONE){
                        Able.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY()));
                    }
                }
                if (getSource().getX() != 7 && getSource().getX() != 1) {
                    if (chessComponents[getSource().getX() + 1][getSource().getY()].getChessColor() == ChessColor.NONE) {
                        Able.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                    }
                }

                if (getSource().getX() != 7 && getSource().getY() != 7) {
                    if (chessComponents[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                        Able.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                }
                if (getSource().getX() != 7 && getSource().getY() != 0) {
                    if (chessComponents[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                        Able.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                }
            }
            Collections.sort(Able);
            return Able;


    }
}

class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
        super(color,source,chessComponents);
        this.name='_';

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();


    }

}




