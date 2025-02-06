import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    //should design
    public EmptySlotComponent(ChessboardPoint source){
        this.source=source;
        this.chessColor=ChessColor.NONE;
        this.name='_';
    }

    // should design
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<ChessboardPoint>();
        return chessboardPoints;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessColor getChessColor(){return this.chessColor;}

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return "_";
    }
}

