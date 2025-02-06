import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponent;
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
        if(this.chessColor == ChessColor.BLACK){
            name = 'K';
        }else {
            name = 'k';
        }
    }
    @Override
    public void setChessboardPoint(ChessboardPoint chessboardPoint){
        source=chessboardPoint;
    }
    @Override
    public ChessColor getChessColor(){
        return chessColor;
    }
    @Override
    public void setChessComponent(ChessComponent[][] chessComponent){
        this.chessComponent=chessComponent;
    }
    @Override
    public ChessComponent[][] getChessComponent(){
        return chessComponent;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponent[i][j].getChessColor() != chessColor){
                    if (i == source.getX() && Math.abs(j - source.getY()) == 1) {
                        list.add(new ChessboardPoint(i, j));
                    } else if (Math.abs(i - source.getX()) == 1 && j == source.getY()) {
                        list.add(new ChessboardPoint(i, j));
                    } else if (Math.abs(i - source.getX()) == 1 && Math.abs(j - source.getY()) == 1) {
                        list.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }
        return list;
    }
    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
}