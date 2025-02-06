import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    public ChessboardPoint source; // Where the chess is
    public ChessColor chessColor; // What's the color
    protected char name; // What's the name
    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.source=source;
        this.chessColor=chessColor;
    }
    public abstract List<ChessboardPoint> canMoveTo();
//    public ChessColor getChessColor(ChessComponent chessComponent){
//        if ((chessComponent.name>='A') && (chessComponent.name<='Z')){
//            return ChessColor.BLACK;
//        }
//        else if ((chessComponent.name>='a') && (chessComponent.name<='z')){
//            return ChessColor.WHITE;
//        }
//        return ChessColor.NONE;
//    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)){
            this.name='K';
        }
        if (chessColor.equals(ChessColor.WHITE)){
            this.name='k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> where=new ArrayList<>();
        if (source.offset1(-1,-1)!=null){
            where.add(source.offset1(-1,-1));
        }
        if (source.offset1(-1,0)!=null){
            where.add(source.offset1(-1,0));
        }
        if (source.offset1(-1,1)!=null){
            where.add(source.offset1(-1,1));
        }
        if (source.offset1(0,-1)!=null) {
            where.add(source.offset1(0, -1));
        }
        if (source.offset1(0,1)!=null){
            where.add(source.offset1(0,1));
        }
        if (source.offset1(1,-1)!=null){
            where.add(source.offset1(1,-1));
        }
        if (source.offset1(1,0)!=null){
            where.add(source.offset1(1,0));
        }
        if (source.offset1(1,1)!=null){
            where.add(source.offset1(1,1));
        }
        return where;
    }
}
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)){
            this.name='Q';
        }
        if (chessColor.equals(ChessColor.WHITE)){
            this.name='q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> where=new ArrayList<>();
        for (int i = -7; i <8 ; i++) {
            if (i==0){
                i++;
            }
            if (source.offset1(i,i)!=null){
                where.add(source.offset1(i,i));
            }
            if (source.offset1(i,-i)!=null){
                where.add(source.offset1(i,-i));
            }
        }
        for (int i = 1; i <8 ; i++) {
            if (source.offset1(0,i)!=null){
                where.add(source.offset1(0,i));
            }
            if (source.offset1(0,-i)!=null){
                where.add(source.offset1(0,-i));
            }
            if (source.offset1(i,0)!=null){
                where.add(source.offset1(i,0));
            }
            if (source.offset1(-i,0)!=null){
                where.add(source.offset1(-i,0));
            }
        }
        return where;
    }
}
class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)){
            this.name='R';
        }
        if (chessColor.equals(ChessColor.WHITE)){
            this.name='r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> where=new ArrayList<>();
        for (int i = 1; i <8 ; i++) {
            if (source.offset1(0,i)!=null){
                where.add(source.offset1(0,i));
            }
            if (source.offset1(0,-i)!=null){
                where.add(source.offset1(0,-i));
            }
            if (source.offset1(i,0)!=null){
                where.add(source.offset1(i,0));
            }
            if (source.offset1(-i,0)!=null){
                where.add(source.offset1(-i,0));
            }
        }
        return where;
    }
}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)){
            this.name='B';
        }
        if (chessColor.equals(ChessColor.WHITE)){
            this.name='b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> where=new ArrayList<>();
        for (int i = -7; i <8 ; i++) {
            if (i==0){
                i++;
            }
            if (source.offset1(i,i)!=null){
                where.add(source.offset1(i,i));
            }
            if (source.offset1(i,-i)!=null){
                where.add(source.offset1(i,-i));
            }
        }
        return where;
    }
}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)){
            this.name='N';
        }
        if (chessColor.equals(ChessColor.WHITE)){
            this.name='n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> where=new ArrayList<>();
        if (source.offset1(-2,-1)!=null){
            where.add(source.offset1(-2,-1));
        }
        if (source.offset1(-2,1)!=null){
            where.add(source.offset1(-2,1));
        }
        if (source.offset1(-1,-2)!=null){
            where.add(source.offset1(-1,-2));
        }
        if (source.offset1(-1,2)!=null){
            where.add(source.offset1(-1,2));
        }
        if (source.offset1(1,-2)!=null){
            where.add(source.offset1(1,-2));
        }
        if (source.offset1(1,2)!=null){
            where.add(source.offset1(1,2));
        }
        if (source.offset1(2,-1)!=null){
            where.add(source.offset1(2,-1));
        }
        if (source.offset1(2,1)!=null){
            where.add(source.offset1(2,1));
        }
        return where;
    }
}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)){
            this.name='P';
        }
        if (chessColor.equals(ChessColor.WHITE)){
            this.name='p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> where=new ArrayList<>();
        if (chessColor.equals(ChessColor.WHITE)){
            if (source.getX()==6){
                where.add(source.offset1(-2,0));
            }
            if (source.offset1(-1,-1)!=null){
                where.add(source.offset1(-1,-1));
            }
            if (source.offset1(-1,0)!=null){
                where.add(source.offset1(-1,0));
            }
            if (source.offset1(-1,1)!=null){
                where.add(source.offset1(-1,1));
            }
        }
        if (chessColor.equals(ChessColor.BLACK)){
            if (source.offset1(1,-1)!=null){
                where.add(source.offset1(1,-1));
            }
            if (source.offset1(1,0)!=null){
                where.add(source.offset1(1,0));
            }
            if (source.offset1(1,1)!=null){
                where.add(source.offset1(1,1));
            }
            if (source.getX()==1){
                where.add(source.offset1(2,0));
            }
        }
        return where;
    }
}
class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        this.name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
