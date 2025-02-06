import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public abstract class ChessComponent {


    public ChessboardPoint[] full={new ChessboardPoint(0, 0),new ChessboardPoint(0,1),new ChessboardPoint(0, 2),new ChessboardPoint(0, 3),new ChessboardPoint(0, 4),new ChessboardPoint(0, 5),new ChessboardPoint(0, 6),new ChessboardPoint(0, 7),new ChessboardPoint(1, 0),new ChessboardPoint(1, 1),new ChessboardPoint(1, 2),new ChessboardPoint(1, 3),new ChessboardPoint(1, 4),new ChessboardPoint(1, 5),new ChessboardPoint(1, 6),new ChessboardPoint(1, 7),
            new ChessboardPoint(2, 0),new ChessboardPoint(2, 1),new ChessboardPoint(2, 2),new ChessboardPoint(2, 3),new ChessboardPoint(2, 4),new ChessboardPoint(2, 5),new ChessboardPoint(2, 6),new ChessboardPoint(2, 7),
            new ChessboardPoint(3, 0),new ChessboardPoint(3, 1),new ChessboardPoint(3, 2),new ChessboardPoint(3, 3),new ChessboardPoint(3, 4),new ChessboardPoint(3, 5),new ChessboardPoint(3, 6),new ChessboardPoint(3, 7),
            new ChessboardPoint(4, 0),new ChessboardPoint(4, 1),new ChessboardPoint(4, 2),new ChessboardPoint(4, 3),new ChessboardPoint(7, 4),new ChessboardPoint(4, 5),new ChessboardPoint(5, 6),new ChessboardPoint(4, 7),
            new ChessboardPoint(5, 0),new ChessboardPoint(5, 1),new ChessboardPoint(5, 2),new ChessboardPoint(5, 3),new ChessboardPoint(4, 4),new ChessboardPoint(5, 5),new ChessboardPoint(4, 6),new ChessboardPoint(5, 7),
            new ChessboardPoint(6, 0),new ChessboardPoint(6, 1),new ChessboardPoint(6, 2),new ChessboardPoint(6, 3),new ChessboardPoint(5, 4),new ChessboardPoint(6, 5),new ChessboardPoint(6, 6),new ChessboardPoint(6, 7),
            new ChessboardPoint(7, 0),new ChessboardPoint(7, 1),new ChessboardPoint(7, 2),new ChessboardPoint(7, 3),new ChessboardPoint(6, 4),new ChessboardPoint(7, 5),new ChessboardPoint(7, 6),new ChessboardPoint(7, 7)};

    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;			// What's the name
    protected ChessComponent[][] chessboard;

    protected void setName(char name) {
        this.name = name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessComponent(ChessboardPoint source,ChessColor chessColor){}

    public ChessComponent(){}

    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public abstract List<ChessboardPoint> canMoveTo();


}

 class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor==ChessColor.BLACK){
            name='K';
        }else {
            name='k';
        }
    }

    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList=new ArrayList<>();
        pointList.add(getSource().offset(1,1));
        pointList.add(getSource().offset(1,-1));
        pointList.add(getSource().offset(-1,1));
        pointList.add(getSource().offset(-1,-1));
        return pointList;
    }

}
class QueenChessComponent extends ChessComponent{


    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor==ChessColor.BLACK){
            name='Q';
        }else {
            name='q';
        }
    }

    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList=new ArrayList<>();
        pointList.addAll(Arrays.asList(full));
        return pointList;
    }
}
class RookChessComponent extends ChessComponent{


    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor==ChessColor.BLACK){
            name='R';
        }else {
            name='r';
        }
    }

    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList=new ArrayList<>();
        return pointList;
    }
}
class BishopChessComponent extends ChessComponent{


    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor==ChessColor.BLACK){
            name='B';
        }else {
            name='b';
        }
    }

    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList=new ArrayList<>();
        return pointList;
    }
}
class KnightChessComponent extends ChessComponent{


    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor==ChessColor.BLACK){
            name='N';
        }else {
            name='n';
        }
    }

    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList=new ArrayList<>();
        return pointList;
    }
}
class PawnChessComponent extends ChessComponent{


    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor==ChessColor.BLACK){
            name='P';
        }else {
            name='p';
        }
    }

    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList=new ArrayList<>();
        return pointList;
    }
}
class EmptySlotComponent extends ChessComponent{


    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        name='_';
    }

    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointList=new ArrayList<>();
        return pointList;
    }
}
