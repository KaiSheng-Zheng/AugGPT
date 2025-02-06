import java.util.ArrayList;
import java.util.List;
public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint  source ,ChessColor chessColor, char name,ChessComponent[][] chessComponents){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> validPoint = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        if(chessColor == ChessColor.BLACK ){
            for(int i =y-1 ; i>=0 ; i-- ){ //From the source's left
                if(chessComponents[x][i].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(x,i));
                }
                if (chessComponents[x][i].chessColor == ChessColor.BLACK) { // meet white chess, eat it and can go anymore
                    break;
                }
                if (chessComponents[x][i].chessColor == ChessColor.WHITE) { // meet white chess, eat it and can go anymore
                    validPoint.add(new ChessboardPoint(x, i));
                    break;
                }
            }
            for(int i = y+1 ; i <8 ; i ++ ){
                if(chessComponents[x][i].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(x,i));
                }
                if(chessComponents[x][i].chessColor == ChessColor.BLACK ){
                    break;
                }
                if(chessComponents[x][i].chessColor == ChessColor.WHITE){ // meet white chess, eat it and can go anymore
                    validPoint.add(new ChessboardPoint(x,i));
                    break;
                }
            }
            for(int i =x-1 ; i>=0 ; i-- ){ //From the source's left
                if(chessComponents[i][y].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(i,y));
                }
                if(chessComponents[i][y].chessColor == ChessColor.BLACK ){
                    break;
                }
                if(chessComponents[i][y].chessColor == ChessColor.WHITE){ // meet white chess, eat it and can go anymore
                    validPoint.add(new ChessboardPoint(i,y));
                    break;
                }
            }
            for(int i = x+1 ; i <8 ; i ++ ){
                if(chessComponents[i][y].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(i,y));
                }
                if(chessComponents[i][y].chessColor == ChessColor.BLACK ){
                    break;
                }
                if(chessComponents[i][y].chessColor == ChessColor.WHITE){ // meet white chess, eat it and can go anymore
                    validPoint.add(new ChessboardPoint(i,y));
                    break;
                }
            }
        }
        if(chessColor == ChessColor.WHITE){ //source's color is white
            for(int i =y-1 ; i>=0 ; i-- ){ //From the source's left
                if(chessComponents[x][i].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(x,i));
                }
                if(chessComponents[x][i].chessColor == ChessColor.WHITE ){
                    break;
                }if(chessComponents[x][i].chessColor == ChessColor.BLACK){ // meet black chess, eat it and can go anymore
                    validPoint.add(new ChessboardPoint(x,i));
                    break;
                }
            }
            for(int i = y+1 ; i <8 ; i ++ ){
                if(chessComponents[x][i].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(x,i));
                }
                if(chessComponents[x][i].chessColor == ChessColor.WHITE ){
                    break;
                }
                if(chessComponents[x][i].chessColor == ChessColor.BLACK){ // meet white chess, eat it and can go anymore
                    validPoint.add(new ChessboardPoint(x,i));
                    break;
                }
            }
            for(int i = x-1 ; i >= 0 ; i -- ){ //From the source's left
                if(chessComponents[i][y].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(i,y));
                }
                if(chessComponents[i][y].chessColor == ChessColor.WHITE ){
                    break;
                }
                if(chessComponents[i][y].chessColor == ChessColor.BLACK){ // meet white chess, eat it and can go anymore
                    validPoint.add(new ChessboardPoint(i,y));
                    break;
                }
            }
            for(int i = x+1 ; i <8 ; i ++ ){
                if(chessComponents[i][y].chessColor == ChessColor.NONE ){
                    validPoint.add(new ChessboardPoint(i,y));
                }
                if(chessComponents[i][y].chessColor == ChessColor.WHITE ){
                    break;
                }
                if(chessComponents[i][y].chessColor == ChessColor.BLACK){ // meet white chess, eat it and can go anymore
                    validPoint.add(new ChessboardPoint(i,y));
                    break;
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
