import java.util.LinkedList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;// What's the color

//    protected char name = 'Q';// What's the name

    public QueenChessComponent (){}

    public QueenChessComponent (ChessboardPoint source, ChessColor chessColor){
        this.source = source;
        this.chessColor = chessColor;
        if(chessColor == ChessColor.BLACK ){
            this.name = 'Q';
        }
        if(chessColor == ChessColor.WHITE ){
            this.name = 'q';
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

