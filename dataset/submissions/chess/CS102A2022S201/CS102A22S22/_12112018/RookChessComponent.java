import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    ChessboardPoint chessboardPoint;
    ChessColor chessColor;
    ChessComponent[][] chessComponents ;
    RookChessComponent( ChessboardPoint source ,ChessColor chessColor, ChessComponent[][] chessComponents ){
        super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
        super.setChessComponents(chessComponents);
        this.chessboardPoint = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        List<ChessboardPoint> AMW = new ArrayList<>();
        for (int i = source.getX()-1 ; i >= 0 ; i--){
            if(chessComponents[i][source.getY()].getChessColor() == ChessColor.NONE){
                AMW.add(new ChessboardPoint(i,source.getY()));
            }else if(chessComponents[i][source.getY()].getChessColor() == this.chessColor){
                break;
            }else if(chessComponents[i][source.getY()].getChessColor() != this.chessColor&&
                    chessComponents[i][source.getY()].getChessColor() != ChessColor.NONE){
                AMW.add(new ChessboardPoint(i,source.getY()));break;
            }
        }for (int i = source.getX()+1 ; i < 8 ; i++){
            if(chessComponents[i][source.getY()].getChessColor() == ChessColor.NONE){
                AMW.add(new ChessboardPoint(i,source.getY()));
            }else if(chessComponents[i][source.getY()].getChessColor() == this.chessColor){
                break;
            }else if(chessComponents[i][source.getY()].getChessColor() != this.chessColor&&
                    chessComponents[i][source.getY()].getChessColor() != ChessColor.NONE){
                AMW.add(new ChessboardPoint(i,source.getY()));break;
            }
        }for (int i = source.getY()-1 ; i >= 0 ; i--){
            if(chessComponents[source.getX()][i].getChessColor() == ChessColor.NONE){
                AMW.add(new ChessboardPoint(source.getX(),i));
            }else if(chessComponents[source.getX()][i].getChessColor() == this.chessColor) {
                break;
            }else if(chessComponents[source.getX()][i].getChessColor() != this.chessColor&&
                    chessComponents[source.getX()][i].getChessColor() != ChessColor.NONE){
                AMW.add(new ChessboardPoint(source.getX(),i));break;
            }
        }for (int i = source.getY()+1 ; i < 8 ; i++){
            if(chessComponents[source.getX()][i].getChessColor() == ChessColor.NONE){
                AMW.add(new ChessboardPoint(source.getX(),i));
            }else if(chessComponents[source.getX()][i].getChessColor() == this.chessColor){
                break;
            }else if(chessComponents[source.getX()][i].getChessColor() != this.chessColor&&
                    chessComponents[source.getX()][i].getChessColor() != ChessColor.NONE){
                AMW.add(new ChessboardPoint(source.getX(),i));break;
            }
        }
    return AMW;
    }
}
