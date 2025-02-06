import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        if(getChessColor().equals(ChessColor.BLACK)) {
            if (getSource().getX() == 1) {
                if (getSource().offset(2, 0) != null
                        && getChessComponents(getSource().getX() + 2, getSource().getY()).getChessColor().equals(ChessColor.NONE)) {
                    list.add(getSource().offset(2, 0));
                }
            }
            if (getSource().offset(1, 0) != null
                    && getChessComponents(getSource().getX() + 1, getSource().getY()).getChessColor().equals(ChessColor.NONE)) {
                list.add(getSource().offset(1, 0));
            }
            if (getSource().offset(1, 1) != null
                    && !getChessComponents(getSource().getX() + 1, getSource().getY() + 1).getChessColor().equals(ChessColor.NONE)
                    && !getChessComponents(getSource().getX() + 1, getSource().getY() + 1).getChessColor().equals(getChessColor())) {
                list.add(getSource().offset(1, 1));
            }
            if (getSource().offset(1, -1) != null
                    && !getChessComponents(getSource().getX() + 1, getSource().getY() - 1).getChessColor().equals(ChessColor.NONE)
                    && !getChessComponents(getSource().getX() + 1, getSource().getY() - 1).getChessColor().equals(getChessColor())) {
                list.add(getSource().offset(1, -1));
            }
        }else{
            if (getSource().getX() == 6) {
                if (getSource().offset(-2, 0) != null
                        && getChessComponents(getSource().getX() - 2, getSource().getY()).getChessColor().equals(ChessColor.NONE)) {
                    list.add(getSource().offset(-2, 0));
                }
            }
            if (getSource().offset(-1, 0) != null
                    && getChessComponents(getSource().getX() - 1, getSource().getY()).getChessColor().equals(ChessColor.NONE)) {
                list.add(getSource().offset(-1, 0));
            }
            if (getSource().offset(-1, 1) != null
                    && !getChessComponents(getSource().getX() - 1, getSource().getY() + 1).getChessColor().equals(ChessColor.NONE)
                    && !getChessComponents(getSource().getX() - 1, getSource().getY() + 1).getChessColor().equals(getChessColor())) {
                list.add(getSource().offset(-1, 1));
            }
            if (getSource().offset(-1, -1) != null
                    && !getChessComponents(getSource().getX() - 1, getSource().getY() - 1).getChessColor().equals(ChessColor.NONE)
                    && !getChessComponents(getSource().getX() - 1, getSource().getY() - 1).getChessColor().equals(getChessColor())) {
                list.add(getSource().offset(-1, -1));
            }
        }
        if(list.size()!=0){
            return list;
        }else{
            return new ArrayList<>();
        }
    }
    public String toString() {
        return String.valueOf(getName());
    }
}
