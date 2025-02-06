import java.util.LinkedList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;// What's the color
//    protected char name = 'B';// What's the name

    public BishopChessComponent(){}


    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.source = source;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            this.name = 'B';
        }
        if(chessColor == ChessColor.WHITE){
            this.name = 'b';
        }
    }

    public ChessboardPoint getChessboardPoint() {return source;}

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {this.source = chessboardPoint;}

    public ChessColor getChessColor() {return chessColor;}

//    public char getName() {return this.name;}

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getChessboardPoint();
        List<ChessboardPoint> chessboardPoints = new LinkedList<>();

        
        return chessboardPoints;
    }

}
