import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(){}

    public ChessComponent piece(int x, int y){
        return (ChessComponent) c.map.get(10*x+y);
    }

    protected void to(int x, int y){
        if(source != null){
            int preCode = (int) c.map.get(this);
            EmptySlotComponent nEmpty = new EmptySlotComponent();
            nEmpty.setSource(new ChessboardPoint(preCode/10, preCode%10));

            c.map.remove(this);
            c.map.remove(preCode);

            c.map.put(preCode, nEmpty);
            c.map.put(nEmpty, preCode);
        }


        source = new ChessboardPoint(x, y);
        setSource(source);

        if(c.map.keySet().contains(code())){
            ChessComponent prePie = (ChessComponent) c.map.get(code());

            c.map.remove(prePie);
            c.map.remove(code());

            if(prePie.chessColor != ChessColor.NONE){
                c.captured.add(prePie);
            }
        }


        c.map.put(this, code());
        c.map.put(code(), this);
    }

    protected int code(){
        return source.code();
    }
    public abstract List<ChessboardPoint> canMoveTo();

    //to string
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    protected int x(){
        return source.getX();
    }

    protected int y(){
        return source.getY();
    }

    //GS

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}
