import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class ChessComponent  {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents=new ChessComponent[8][8];

    //should design
    public ChessComponent(ChessboardPoint source,ChessComponent[][]chessComponent,char name){
this.source=source;
this.chessComponents=chessComponent;
this.name=name;
    }

    public ChessComponent() {

    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public char getName() {
        return name;
    }
}
