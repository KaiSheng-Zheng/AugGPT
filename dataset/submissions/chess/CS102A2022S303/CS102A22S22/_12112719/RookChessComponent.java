import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    @Override
    public ChessboardPoint getSource() {
        return source;
    }
public void setSource(ChessboardPoint source) {
        this.source.setX(source.getX());
        this.source.setY(source.getY());
    }
    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public char getName() {
        return name;
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();
        ChessComponent[][] chessComponents =new ChessComponent[8][8];
        int x0 = getSource().getX();
        int y0 = getSource().getY();
        chessComponents =currentgame.getChessComponents();
        ChessboardPoint destination=new ChessboardPoint(0,0);
        int xf, yf;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                destination.setX(i);
                destination.setY(j);
                xf =destination.getX();
                yf =destination.getY();
                boolean can=true;
                
                if (x0 == xf) {
                    int row = x0;
                    for (int col = Math.min(y0, destination.getY()) + 1;
                         col < Math.max(y0, yf); col++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            can=false;
                        }
                    }
                } else if (y0 == yf) {
                    int col = y0;
                    for (int row = Math.min(x0, xf) + 1;
                         row < Math.max(x0, xf); row++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            can=false;
                        }
                    }
                } else { // Not on the same row or the same column.
                    can=false;
                }
                if (can && chessComponents[i][j].getChessColor() != chessColor) {
                    canmoveto.add(new ChessboardPoint(i, j));
                }
            }
        }
        return canmoveto;
    }

    public String toString() {
        if (getChessColor()==ChessColor.WHITE){
            return "r";
        }else return "R";
    }
}
