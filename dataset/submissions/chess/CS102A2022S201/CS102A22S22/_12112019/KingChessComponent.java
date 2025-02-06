import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponent) {
        this.chessboardPoint = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponent;

        super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
        super.setChessComponents(chessComponents);

    }
    ChessboardPoint chessboardPoint;
    ChessColor chessColor;
    ChessComponent[][] chessComponents;

    @Override
 public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint chess = getSource();

        List<ChessboardPoint> arrayList = new ArrayList<>();
        if(chess.getX()-1>=0&&chess.getY()-1>=0){
            if(this.chessColor != chessComponents[chess.getX()-1][chess.getY()-1].getChessColor()){
                arrayList.add(new ChessboardPoint(chess.getX()-1, chess.getY()-1));
            }
        }if(chess.getX()-1>=0){
            if(this.chessColor != chessComponents[chess.getX()-1][chess.getY()].getChessColor()){
                arrayList.add(new ChessboardPoint(chess.getX()-1, chess.getY()));
            }
        }if(chess.getX()-1>=0&& chess.getY()+1<8){
            if(this.chessColor != chessComponents[chess.getX()-1][chess.getY()+1].getChessColor()){
                arrayList.add(new ChessboardPoint(chess.getX()-1,chess.getY()+1));
            }
        } if(chess.getY()-1>=0){
            if(this.chessColor != chessComponents[chess.getX()][chess.getY()-1].getChessColor()){
                arrayList.add(new ChessboardPoint(chess.getX(), chess.getY()-1));
            }
        } if(chess.getY()+1<8){
            if(this.chessColor != chessComponents[chess.getX()][chess.getY()+1].getChessColor()) {
                arrayList.add(new ChessboardPoint(chess.getX(),chess.getY()+1));
            }if(chess.getX()+1<8&& chess.getY()-1>=0){
            if(this.chessColor != chessComponents[chess.getX()+1][chess.getY()-1].getChessColor()){
                arrayList.add(new ChessboardPoint(chess.getX()+1,chess.getY()-1));
            }


        }if(chess.getX()+1<8) {
            if(this.chessColor != chessComponents[chess.getX()+1][chess.getY()].getChessColor()){
                arrayList.add(new ChessboardPoint(chess.getX()+1,chess.getY()));
            }
        }





       }if(chess.getX()+1<8&& chess.getY()+1<8){
            if(this.chessColor != chessComponents[chess.getX()+1][chess.getY()+1].getChessColor()){
                arrayList.add(new ChessboardPoint(chess.getX()+1,chess.getY()+1));
            }
        }
        return arrayList;
    }
}
