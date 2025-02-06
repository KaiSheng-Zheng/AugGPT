import java.util.LinkedList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;// What's the color
//    protected char name = 'R';// What's the name

    public RookChessComponent (){}

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.source = source;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK){
            this.name = 'R';
        }
        if(chessColor == ChessColor.WHITE){
            this.name = 'r';
        }
    }

    public ChessboardPoint getChessboardPoint() {return source;}

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {this.source = chessboardPoint;}

    public ChessColor getChessColor() {return chessColor;}


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getChessboardPoint();
        List<ChessboardPoint> chessboardPoints = new LinkedList<>();
        
        return chessboardPoints;

    }




}
