

import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source ;
    private ChessColor chessColor;
    protected char name;
    protected List<String> chessboard;

    public ChessColor getChessColor() {
        if (name>'a'&&name<'z')
            this.chessColor = ChessColor.WHITE;
        else if (name>'A'&&name<'Z'){
            this.chessColor = ChessColor.BLACK;
        }else {
            this.chessColor = ChessColor.NONE;
        }
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent(ChessboardPoint source) {
        this.source = new ChessboardPoint(source.getX(),source.getY());
    }

    public int getSourceX() {
        return source.getX();
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public int getSourceY() {
        return source.getY();
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    //should design
    public ChessComponent() {}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


}
