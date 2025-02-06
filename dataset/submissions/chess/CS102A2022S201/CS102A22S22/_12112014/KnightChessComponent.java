import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    ChessboardPoint chessboardPoint;
    ChessColor chessColor;
    ChessComponent[][] chessComponents ;
    KnightChessComponent( ChessboardPoint source ,ChessColor chessColor, ChessComponent[][] chessComponents ){
        super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
        super.setChessComponents(chessComponents);
        this.chessboardPoint = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint chess = getSource();
        List<ChessboardPoint> N = new ArrayList<>();
        
        if (chess.getX()-1 >= 0 && chess.getY()+2 < 8 ) {
            if (this.chessColor != chessComponents[chess.getX()-1][chess.getY()+2].getChessColor()) {
                N.add(new ChessboardPoint(chess.getX()-1, chess.getY()+2));
            }
        }
        if (chess.getX()-1 >= 0 && chess.getY()-2 >= 0) {
            if (this.chessColor != chessComponents[chess.getX()-1][chess.getY()-2].getChessColor()) {
                N.add(new ChessboardPoint(chess.getX()-1, chess.getY()-2));
            }
        }
        if (chess.getX()+2 < 8  && chess.getY()+1 < 8) {
            if(this.chessColor != chessComponents[chess.getX()+2][chess.getY()+1].getChessColor()){
                N.add(new ChessboardPoint(chess.getX()+2, chess.getY()+1));
            }
        }
        if (chess.getX()+1 < 8  && chess.getY()-2 >= 0) {
            if (this.chessColor != chessComponents[chess.getX()+1][chess.getY()-2].getChessColor()) {
                N.add(new ChessboardPoint(chess.getX()+1, chess.getY()-2));
            }
        }
        
        
        if (chess.getX()-2 >= 0 && chess.getY()+1 < 8 ) {
            if (this.chessColor != chessComponents[chess.getX()-2][chess.getY()+1].getChessColor()) {
                N.add(new ChessboardPoint(chess.getX()-2, chess.getY()+1));
            }
        }
        if (chess.getX()+2 <8 && chess.getY()-1 >= 0) {
            if(this.chessColor != chessComponents[chess.getX()+2][chess.getY()-1].getChessColor()){
                N.add(new ChessboardPoint(chess.getX()+2, chess.getY()-1));
            }
        }
        if (chess.getX()+1 < 8 && chess.getY()+2 < 8) {
            if (this.chessColor != chessComponents[chess.getX()+1][chess.getY()+2].getChessColor()) {
                N.add(new ChessboardPoint(chess.getX()+1, chess.getY()+2));
            }
        }
        if (chess.getX()-2 >= 0 && chess.getY()-1 >= 0) {
            if (this.chessColor != chessComponents[chess.getX()-2][chess.getY()-1].getChessColor()) {
                N.add(new ChessboardPoint(chess.getX()-2, chess.getY()-1));
            }
        }
        return N;
    }
}
