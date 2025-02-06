import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint  source ,ChessColor chessColor, char name ,ChessComponent[][] chessComponents ){
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
            for(int i = 1 ; i< 8 ; i++ ) { //From the source's right
                if (!(source.offset(-i, i) == null)) {
                    if (chessComponents[x - i][y + i].chessColor == ChessColor.NONE) {
                        validPoint.add(source.offset(-i, i));
                    } else if (chessComponents[x - i][y + i].chessColor == ChessColor.BLACK) {
                        break;
                    } else { // meet white chess, eat it and can go anymore
                        validPoint.add(source.offset(-i, i));
                        break;
                    }
                }
            }
            for(int i = 1 ; i < 8 ; i++ ){
                if(!(source.offset(i,-i) == null)){
                    if (chessComponents[x + i][y - i].chessColor == ChessColor.NONE) {
                        validPoint.add(source.offset(i, -i));
                    } else if (chessComponents[x + i][y - i].chessColor == ChessColor.BLACK) {
                        break;
                    } else{ // meet white chess, eat it and can go anymore
                        validPoint.add(source.offset(i,-i));
                    }
                    break;
                }
            }
            for(int i = 1 ; i<=7 ; i++ ) { //From the source's right
                if (!(source.offset(i, i) == null)) {
                    if (chessComponents[x + i][y + i].chessColor == ChessColor.NONE) {
                        validPoint.add(source.offset(i, i));
                    } else if (chessComponents[x + i][y + i].chessColor == ChessColor.BLACK) {
                        break;
                    } else { // meet white chess, eat it and can go anymore
                        validPoint.add(source.offset(i, i));
                        break;
                    }
                }
            }
            for(int i = 1 ; i <8 ; i++ ) {
                if (!(source.offset(-i, -i) == null)) {
                    if (chessComponents[x - i][y - i].chessColor == ChessColor.NONE) {
                        if (!(source.offset(-i, -i) == null)) {
                            validPoint.add(source.offset(-i, -i));
                        }
                    } else if (chessComponents[x - i][y - i].chessColor == ChessColor.BLACK) {
                        break;
                    } else { // meet white chess, eat it and can go anymore
                        validPoint.add(source.offset(-i, -i));
                        break;
                    }
                }
            }
        }else { //source's color is white
            for (int i = 1; i <= 7; i++) { //From the source's right
                if (!(source.offset(-i, i) == null)) {
                    if (chessComponents[x - i][y + i].chessColor == ChessColor.NONE) {
                        validPoint.add(source.offset(-i, i));
                    } else if (chessComponents[x - i][y + i].chessColor == ChessColor.WHITE) {
                        break;
                    } else { // meet white chess, eat it and can go anymore
                        validPoint.add(source.offset(-i, i));
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (!(source.offset(i, -i) == null)) {
                    if (chessComponents[x + i][y - i].chessColor == ChessColor.NONE) {
                        validPoint.add(source.offset(i, -i));
                    } else if (chessComponents[x + i][y - i].chessColor == ChessColor.WHITE) {
                        break;
                    } else { // meet white chess, eat it and can go anymore
                        validPoint.add(source.offset(i, -i));
                        break;
                    }
                }
            }
            for (int i = 1; i <= 7; i++) { //From the source's right
                if (!(source.offset(i, i) == null)) {
                    if (chessComponents[x + i][y + i].chessColor == ChessColor.NONE) {
                        validPoint.add(source.offset(i, i));
                    } else if (chessComponents[x + i][y + i].chessColor == ChessColor.WHITE) {
                        break;
                    } else { // meet white chess, eat it and can go anymore
                        validPoint.add(source.offset(i, i));
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (!(source.offset(-i, -i) == null)) {
                    if (chessComponents[x - i][y - i].chessColor == ChessColor.NONE) {
                        validPoint.add(source.offset(-i, -i));
                    } else if (chessComponents[x - i][y - i].chessColor == ChessColor.WHITE) {
                        break;
                    } else { // meet white chess, eat it and can go anymore
                        validPoint.add(source.offset(-i, -i));
                        break;
                    }
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
