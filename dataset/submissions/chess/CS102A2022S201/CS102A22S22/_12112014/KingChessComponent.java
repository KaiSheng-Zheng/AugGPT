import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    ChessboardPoint chessboardPoint;
    ChessColor chessColor;
    ChessComponent[][] chessComponents ;
    KingChessComponent( ChessboardPoint source ,ChessColor chessColor, ChessComponent[][] chessComponents ){
        super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
        super.setChessComponents(chessComponents);
        this.chessboardPoint = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint chess = getSource();
        List<ChessboardPoint> AVT = new ArrayList<>();
        if(chess.getX()+1<8) {
            if(this.getChessColor() != chessComponents[chess.getX()+1][chess.getY()].getChessColor()){
                AVT.add(new ChessboardPoint(chess.getX()+1,chess.getY()));
            }
        }
        if(chess.getY()+1<8){
            if(this.getChessColor() != chessComponents[chess.getX()][chess.getY()+1].getChessColor()) {
                AVT.add(new ChessboardPoint(chess.getX(),chess.getY()+1));
            }
        }
        if(chess.getX()+1<8&& chess.getY()+1<8){
            if(this.getChessColor() != chessComponents[chess.getX()+1][chess.getY()+1].getChessColor()){
                AVT.add(new ChessboardPoint(chess.getX()+1,chess.getY()+1));
            }
        }
        if(chess.getX()-1>=0){
            if(this.getChessColor() != chessComponents[chess.getX()-1][chess.getY()].getChessColor()){
                AVT.add(new ChessboardPoint(chess.getX()-1, chess.getY()));
            }
        }
        if(chess.getY()-1>=0){
            if(this.getChessColor() != chessComponents[chess.getX()][chess.getY()-1].getChessColor()){
                AVT.add(new ChessboardPoint(chess.getX(), chess.getY()-1));
            }
        }
        if(chess.getX()-1>=0&&chess.getY()-1>=0){
            if(this.getChessColor() != chessComponents[chess.getX()-1][chess.getY()-1].getChessColor()){
                AVT.add(new ChessboardPoint(chess.getX()-1, chess.getY()-1));
            }
        }
        if(chess.getX()+1<8&& chess.getY()-1>=0){
            if(this.getChessColor() != chessComponents[chess.getX()+1][chess.getY()-1].getChessColor()){
                AVT.add(new ChessboardPoint(chess.getX()+1,chess.getY()-1));
            }
        }
        if(chess.getX()-1>=0&& chess.getY()+1<8){
            if(this.getChessColor() != chessComponents[chess.getX()-1][chess.getY()+1].getChessColor()){
                AVT.add(new ChessboardPoint(chess.getX()-1,chess.getY()+1));
            }
        }
        return AVT;
    }
}
