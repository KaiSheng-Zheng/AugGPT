import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    private ChessComponent[][] chessComponents;

    public ChessComponent() {
    }

    public ChessComponent(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;

    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
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

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        return String.valueOf(this.name);
    }


    public List<ChessboardPoint> straight() {
        List<ChessboardPoint> points = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (getSource().offset(i, 0) != null) {
                if (isNone(i,0)) {
                    points.add(getSource().offset(i, 0));
                } else if (isThisColor(i,0)) {
                    break;
                } else {
                    points.add(getSource().offset(i, 0));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().offset(0, i) != null) {
                if (isNone(0,i)) {
                    points.add(getSource().offset(0, i));
                } else if (isThisColor(0,i)) {
                    break;
                } else {
                    points.add(getSource().offset(0, i));
                    break;
                }
            }
        }
        for (int i = -1; i > -8; i--) {
            if (getSource().offset(i, 0) != null) {
                if (isNone(i,0)) {
                    points.add(getSource().offset(i, 0));
                } else if (isThisColor(i,0)) {
                    break;
                } else {
                    points.add(getSource().offset(i, 0));
                    break;
                }
            }
        }
        for (int i = -1; i > -8; i--) {
            if (getSource().offset(0, i) != null) {
                if (isNone(0,i)) {
                    points.add(getSource().offset(0, i));
                } else if (isThisColor(0,i)) {
                    break;
                } else {
                    points.add(getSource().offset(0, i));
                    break;
                }
            }
        }
        return points;
    }

    public List<ChessboardPoint> diagonal() {
        List<ChessboardPoint> points = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (getSource().offset(i, i) != null){
                if (isNone(i,i)) {
                    points.add(getSource().offset(i, i));
                } else if (isThisColor(i,i)) {
                    break;
                } else {
                    points.add(getSource().offset(i, i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().offset(i, -i) != null){
                if (isNone(i,-i)) {
                    points.add(getSource().offset(i, -i));
                } else if (isThisColor(i,-i)) {
                    break;
                } else {
                    points.add(getSource().offset(i, -i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().offset(-i, i) != null){
                if (isNone(-i,i)) {
                    points.add(getSource().offset(-i, i));
                } else if (isThisColor(-i,i)) {
                    break;
                } else {
                    points.add(getSource().offset(-i, i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().offset(-i, -i) != null){
                if (isNone(-i,-i)) {
                    points.add(getSource().offset(-i, -i));
                } else if (isThisColor(-i,-i)) {
                    break;
                } else {
                    points.add(getSource().offset(-i, -i));
                    break;
                }
            }
        }
        return points;
    }

    public boolean isNone(int a, int b) {
        if(getChessComponents()[getSource().offset(a,b).getX()][getSource().offset(a,b).getY()].getChessColor() == ChessColor.NONE){
            return true;
        }else return false;
    }

    public boolean isThisColor(int a, int b){
        if (getChessComponents()[getSource().offset(a,b).getX()][getSource().offset(a,b).getY()].getChessColor() == getChessColor()){
            return true;
        }else return false;
    }

    public boolean isOppositeColor(int a,int b){
        if (getChessComponents()[getSource().offset(a,b).getX()][getSource().offset(a,b).getY()].getChessColor() != getChessColor() && getChessComponents()[getSource().offset(a,b).getX()][getSource().offset(a,b).getY()].getChessColor() != ChessColor.NONE){
            return true;
        }else return false;
    }
}

