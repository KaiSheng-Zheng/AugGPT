import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent  {
    public PawnChessComponent(ChessboardPoint  source ,ChessColor chessColor, char name ,ChessComponent[][] chessComponents){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents =chessComponents;
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> validPoint = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        if(chessColor == ChessColor.BLACK ){
            if(x == 1){
                if(chessComponents[2][y].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(2,y));
                }
                if(chessComponents[3][y].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(3,y));
                }
                if(chessComponents[2][y-1].chessColor == ChessColor.WHITE ){
                    validPoint.add(source.offset(1,-1));
                }
                if(chessComponents[2][y+1].chessColor == ChessColor.WHITE ){
                    validPoint.add(source.offset(1,1));
                }
            }else{
                if(chessComponents[x+1][y].chessColor == ChessColor.NONE ){
                    validPoint.add(source.offset(1,0));
                }
                if(chessComponents[x+1][y-1].chessColor == ChessColor.WHITE ){
                    validPoint.add(source.offset(1,-1));
                }
                if(chessComponents[x+1][y+1].chessColor == ChessColor.WHITE ){
                    validPoint.add(source.offset(1,1));
                }
            }
        }else{
            if(x == 6){
                if(chessComponents[5][y].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(5,y));
                }
                if(chessComponents[4][y].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(4,y));
                }
                if(chessComponents[5][y-1].chessColor == ChessColor.BLACK ){
                    validPoint.add(source.offset(-1,-1));
                }
                if(chessComponents[5][y+1].chessColor == ChessColor.BLACK ){
                    validPoint.add(source.offset(-1,1));
                }
            }else{
                if(chessComponents[x-1][y].chessColor == ChessColor.NONE ){
                    validPoint.add(source.offset(-1,0));
                }
                if(chessComponents[x-1][y-1].chessColor == ChessColor.WHITE ){
                    validPoint.add(source.offset(-1,-1));
                }
                if(chessComponents[x-1][y+1].chessColor == ChessColor.WHITE ){
                    validPoint.add(source.offset(-1,1));
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
