import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ChessComponent {
    ChessComponent[][] chessComponents=new ChessComponent[8][8];

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(){}

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();
    public List<ChessboardPoint> compareTo(List<ChessboardPoint> chessboardPoints){
        List<ChessboardPoint> list=new ArrayList<>();
        int[] a=new int[chessboardPoints.size()];
        for (int i = 0; i < chessboardPoints.size(); i++) {
            a[i]=chessboardPoints.get(i).getValue();
        }
        Arrays.sort(a);
        for (int i = 0; i < chessboardPoints.size(); i++) {
            list.add(new ChessboardPoint(a[i]/10,a[i]%10));
        }
        return list;
        }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
