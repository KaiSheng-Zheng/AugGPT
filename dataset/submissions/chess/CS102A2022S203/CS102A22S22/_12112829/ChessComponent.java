import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint getSource;
    private ChessColor chessColor;
    protected char name;
    private int sort;
    public ChessComponent[][] chessComponents;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public ChessboardPoint getSource() {
        return getSource;
    }

    public void setSource(ChessboardPoint source) {
        this.getSource = source;
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

    public ChessComponent(){
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString(){
        return String.valueOf(this.name);
    }

}
class sort implements Comparator<ChessboardPoint>{
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        try {
            if (o1.getX()>o2.getX()){return 1;}
            else if (o1.getX()<o2.getX()){return -1;}
            else {if (o1.getY()>o2.getY()){return 1;}
            else if (o1.getY()<o2.getY()){return -1;}
            else {return 0;}
            }
        }catch (Exception e){
            return 0;
        }
    }
}