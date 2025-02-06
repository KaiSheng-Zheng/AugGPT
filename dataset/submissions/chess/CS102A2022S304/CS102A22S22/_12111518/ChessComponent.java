import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    
    protected ChessComponent[][] chessboard;

    public ChessComponent() {}

    public ChessComponent(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public ChessComponent(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent(int x, int y, ChessColor chessColor) {
        source = new ChessboardPoint(x,y);
        this.chessColor = chessColor;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }
    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public List<ChessboardPoint> rank(List<ChessboardPoint> input){
        List<ChessboardPoint> output = new ArrayList<>();
        int[][] store = new int[2][input.size()];
        for (int i = 0; i < input.size(); i++) {
            store[0][i] = input.get(i).getX();
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
