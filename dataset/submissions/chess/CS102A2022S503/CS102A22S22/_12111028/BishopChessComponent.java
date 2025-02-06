import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = destination.getX();
        int y2 = destination.getY();
        if(x2>7||x2<0||y2>7||y2<0){return false;}
        int counter = 0;
        if (Math.abs(x2 - x1) == Math.abs(y2 - y1) && chessComponents[x1][y1].getChessColor() != chessComponents[x2][y2].getChessColor()) {
            if (x2 > x1 && y2 > y1) {
                for (int k = 1; k <= Math.abs(x2 - x1) - 1; k++) {

                    if (chessComponents[x1][y1].getChessColor() == chessComponents[x1 + k][y1 + k].getChessColor()) {
                        counter++;
                        break;
                    }
                    if (chessComponents[x1][y1].getChessColor() ==ChessColor.BLACK){
                        if( chessComponents[x1 + k][y1 + k].getChessColor()==ChessColor.WHITE && x2 != x1 + k && y2 != y1 + k) {
                            counter++;
                            break;
                        }
                    }
                    if (chessComponents[x1][y1].getChessColor() ==ChessColor.WHITE){
                        if( chessComponents[x1 + k][y1 + k].getChessColor()==ChessColor.BLACK && x2 != x1 + k && y2 != y1 + k) {
                            counter++;
                            break;
                        }
                    }

                }
            }
            if (x2 > x1 && y2 < y1) {
                for (int k = 1; k <= Math.abs(x2 - x1) - 1; k++) {

                    if (chessComponents[x1][y1].getChessColor() == chessComponents[x1 + k][y1 - k].getChessColor()) {
                        counter++;
                        break;
                    }
                    if (chessComponents[x1][y1].getChessColor() ==ChessColor.BLACK){
                        if( chessComponents[x1 + k][y1 - k].getChessColor()==ChessColor.WHITE && x2 != x1 + k && y2 != y1 - k) {
                            counter++;
                            break;
                        }
                    }
                    if (chessComponents[x1][y1].getChessColor() ==ChessColor.WHITE){
                        if( chessComponents[x1 + k][y1 - k].getChessColor()==ChessColor.BLACK && x2 != x1 + k && y2 != y1 - k) {
                            counter++;
                            break;
                        }
                    }

                }
            }
            if (x2 < x1 && y2 < y1) {
                for (int k = 1; k <= Math.abs(x2 - x1) - 1; k++) {

                    if (chessComponents[x1][y1].getChessColor() == chessComponents[x1 - k][y1 - k].getChessColor()) {
                        counter++;
                        break;
                    }
                    if (chessComponents[x1][y1].getChessColor() ==ChessColor.BLACK){
                        if( chessComponents[x1 - k][y1 - k].getChessColor()==ChessColor.WHITE && x2 != x1 - k && y2 != y1 - k) {
                            counter++;
                            break;
                        }
                    }
                    if (chessComponents[x1][y1].getChessColor() ==ChessColor.WHITE){
                        if( chessComponents[x1 - k][y1 - k].getChessColor()==ChessColor.BLACK && x2 != x1 - k && y2 != y1 - k) {
                            counter++;
                            break;
                        }
                    }

                }
            }

            if (x2 < x1 && y2 > y1) {
                for (int k = 1; k <= Math.abs(x2 - x1) - 1; k++) {

                    if (chessComponents[x1][y1].getChessColor() == chessComponents[x1 - k][y1 + k].getChessColor()) {
                        counter++;
                        break;
                    }
                    if (chessComponents[x1][y1].getChessColor() ==ChessColor.BLACK){
                        if( chessComponents[x1 - k][y1 + k].getChessColor()==ChessColor.WHITE && x2 != x1 - k && y2 != y1 + k) {
                            counter++;
                            break;
                        }
                    }
                    if (chessComponents[x1][y1].getChessColor() ==ChessColor.WHITE){
                        if( chessComponents[x1 - k][y1 + k].getChessColor()==ChessColor.BLACK && x2 != x1 - k && y2 != y1 + k) {
                            counter++;
                            break;
                        }
                    }

                }
            }

            if (counter != 0) {
                return false;
            }
            return true;
        } else return false;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        for(int i =0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessboardPoint des=new ChessboardPoint(i,j);
                if(this.canMoveTo(ConcreteChessGame.getStaticchessComponents(),des)){
                    result.add(des);
                }
            }
        }
        return result;
    }
    public BishopChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor, name);
    }

}
