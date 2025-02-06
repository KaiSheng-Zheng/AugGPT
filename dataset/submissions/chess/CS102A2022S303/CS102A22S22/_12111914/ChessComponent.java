import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessBoard;

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent[][] getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public List<ChessboardPoint> Ordered(List<ChessboardPoint> chessboardPoints){
        for (int i = 0; i < chessboardPoints.size(); i++) {
            for (int j = i; j < chessboardPoints.size(); j++) {
                if (chessboardPoints.get(j).compareTo(chessboardPoints.get(i)) == -1){
                    ChessboardPoint midbody = chessboardPoints.get(j);
                    chessboardPoints.set(j,chessboardPoints.get(i));
                    chessboardPoints.set(i,midbody);
                }
            }
        }
        return chessboardPoints;
    }
}
