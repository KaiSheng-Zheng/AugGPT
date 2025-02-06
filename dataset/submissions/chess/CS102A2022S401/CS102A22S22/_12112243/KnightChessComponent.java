import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint  source ,ChessColor chessColor, char name ,ChessComponent[][] chessComponents){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents  = chessComponents;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> validPoint = new ArrayList<>();
            if(chessColor == ChessColor.BLACK){
                if(source.offset(-2, -1) != null) {
                    if(chessComponents[source.offset(-2,-1).getX()][source.offset(-2,-1).getY()].chessColor != ChessColor.BLACK ){
                        validPoint.add(source.offset(-2,-1));
                    }
                }
                if(source.offset(-2,1) != null){
                    if(chessComponents[source.offset(-2,1).getX()][source.offset(-2,1).getY()].chessColor != ChessColor.BLACK ){
                        validPoint.add(source.offset(-2,1));
                    }
                }
                if(source.offset(-1,-2) != null ){
                    if(chessComponents[source.offset(-1,-2).getX()][source.offset(-1,-2).getY()].chessColor != ChessColor.BLACK ){
                        validPoint.add(source.offset(-1,-2));
                    }
                }
                if(source.offset(-1,2) != null){
                    if(chessComponents[source.offset(-1,2).getX()][source.offset(-1,2).getY()].chessColor != ChessColor.BLACK ){
                        validPoint.add(source.offset(-1,2));
                    }
                }
                if(source.offset(1,-2) != null){
                    if(chessComponents[source.offset(1,-2).getX()][source.offset(1,-2).getY()].chessColor != ChessColor.BLACK ){
                        validPoint.add(source.offset(1,-2));
                    }
                }
                if(source.offset(1,2) != null){
                    if(chessComponents[source.offset(1,2).getX()][source.offset(1,2).getY()].chessColor != ChessColor.BLACK ){
                        validPoint.add(source.offset(1,2));
                    }
                }
                if(source.offset(2,-1) != null){
                    if(chessComponents[source.offset(2,-1).getX()][source.offset(2,-1).getY()].chessColor != ChessColor.BLACK ){
                        validPoint.add(source.offset(2,-1));
                    }
                }
                if(source.offset(2,1) != null){
                    if(chessComponents[source.offset(2,1).getX()][source.offset(2,1).getY()].chessColor != ChessColor.BLACK ){
                        validPoint.add(source.offset(2,1));
                    }
                }
            }
            if(chessColor == ChessColor.WHITE){//(chessColor == ChessColor.WHITE ){
                if(source.offset(-2,-1) != null ) {
                    if(chessComponents[source.offset(-2,-1).getX()][source.offset(-2,-1).getY()].chessColor != ChessColor.WHITE ){
                        validPoint.add(source.offset(-2,-1));
                    }
                }
                if(source.offset(-2,1) != null ){
                    if(chessComponents[source.offset(-2,1).getX()][source.offset(-2,1).getY()].chessColor != ChessColor.WHITE ){
                        validPoint.add(source.offset(-2,1));
                    }
                }
                if(source.offset(-1,-2) != null ){
                    if(chessComponents[source.offset(-1,-2).getX()][source.offset(-1,-2).getY()].chessColor != ChessColor.WHITE ){
                        validPoint.add(source.offset(-1,-2));
                    }
                }
                if(source.offset(-1,2) != null){
                    if(chessComponents[source.offset(-1,2).getX()][source.offset(-1,2).getY()].chessColor != ChessColor.WHITE ){
                        validPoint.add(source.offset(-1,2));
                    }
                }
                if(source.offset(1,-2) != null){
                    if(chessComponents[source.offset(1,-2).getX()][source.offset(1,-2).getY()].chessColor != ChessColor.WHITE ){
                        validPoint.add(source.offset(1,-2));
                    }
                }
                if(source.offset(1,2) != null){
                    if(chessComponents[source.offset(1,2).getX()][source.offset(1,2).getY()].chessColor != ChessColor.WHITE ){
                        validPoint.add(source.offset(1,2));
                    }
                }
                if(source.offset(2,-1) != null){
                    if(chessComponents[source.offset(2,-1).getX()][source.offset(2,-1).getY()].chessColor != ChessColor.WHITE ){
                        validPoint.add(source.offset(2,-1));
                    }
                }
                if(source.offset(2,1) != null){
                    if(chessComponents[source.offset(2,1).getX()][source.offset(2,1).getY()].chessColor != ChessColor.WHITE ){
                        validPoint.add(source.offset(2,1));
                    }
                }
            }
        if(validPoint.size()==0){
            return new ArrayList<>();
        }else{
            return validPoint;
        }
    }
}
