import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    ChessboardPoint chessboardPoint;
    ChessColor chessColor;
    ChessComponent[][] chessComponents ;
    PawnChessComponent( ChessboardPoint source ,ChessColor chessColor, ChessComponent[][] chessComponents ){
        super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
        super.setChessComponents(chessComponents);
        this.chessboardPoint = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        List<ChessboardPoint> AWM = new ArrayList<>();
        if (this.chessColor.equals(ChessColor.BLACK)) {
            if (source.getX() == 1) {
                if(ChessColor.NONE == chessComponents[source.getX()+1][source.getY()].getChessColor()) {
                    AWM.add(new ChessboardPoint(source.getX()+1, source.getY()));
                }if (ChessColor.NONE == chessComponents[source.getX()+2][source.getY()].getChessColor()
                        &&ChessColor.NONE == chessComponents[source.getX()+1][source.getY()].getChessColor()) {
                    AWM.add(new ChessboardPoint(source.getX()+2, source.getY()));
                }if(chessComponents[source.getX()+1][source.getY() + 1].getChessColor()==ChessColor.WHITE){
                    AWM.add(new ChessboardPoint(source.getX()+1, source.getY() + 1));
                }if(chessComponents[source.getX()+1][source.getY() - 1].getChessColor()==ChessColor.WHITE){
                    AWM.add(new ChessboardPoint(source.getX()+1, source.getY() - 1));
                }
            }else if (ChessColor.NONE == chessComponents[source.getX()+1][source.getY()].getChessColor()) {
                AWM.add(new ChessboardPoint(source.getX()+1, source.getY()));
            }else if(chessComponents[source.getX()+1][source.getY() + 1].getChessColor()==ChessColor.WHITE){
                AWM.add(new ChessboardPoint(source.getX()+1, source.getY() + 1));
            }else if(chessComponents[source.getX()+1][source.getY() - 1].getChessColor()==ChessColor.WHITE){
                AWM.add(new ChessboardPoint(source.getX()+1, source.getY() - 1));
            }
        }else if (this.chessColor.equals(ChessColor.WHITE)) {
            if (source.getX() == 6) {
                if(ChessColor.NONE == chessComponents[source.getX()-1][source.getY()].getChessColor()) {
                    AWM.add(new ChessboardPoint(source.getX()-1, source.getY()));
                }if (ChessColor.NONE == chessComponents[source.getX()-2][source.getY()].getChessColor()
                        &&ChessColor.NONE == chessComponents[source.getX()-1][source.getY()].getChessColor()) {
                    AWM.add(new ChessboardPoint(source.getX()-2, source.getY()));
                }if(chessComponents[source.getX()-1][source.getY() + 1].getChessColor()==ChessColor.BLACK){
                    AWM.add(new ChessboardPoint(source.getX()-1, source.getY() + 1));
                }if(chessComponents[source.getX()-1][source.getY() - 1].getChessColor()==ChessColor.BLACK){
                    AWM.add(new ChessboardPoint(source.getX()-1, source.getY() - 1));
                }
            }else if (ChessColor.NONE == chessComponents[source.getX()-1][source.getY()].getChessColor()) {
                AWM.add(new ChessboardPoint(source.getX()-1, source.getY()));
            }else if(chessComponents[source.getX()-1][source.getY() + 1].getChessColor()==ChessColor.BLACK){
                AWM.add(new ChessboardPoint(source.getX()-1, source.getY() + 1));
            }else if(chessComponents[source.getX()-1][source.getY() - 1].getChessColor()==ChessColor.BLACK){
                AWM.add(new ChessboardPoint(source.getX()-1, source.getY() - 1));
            }
        }return AWM;
    }
}
