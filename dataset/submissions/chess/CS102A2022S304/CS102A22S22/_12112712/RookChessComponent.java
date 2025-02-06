import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor chessColor){
        super(chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'R';
        }else {
            name = 'r';
        }
    }
    public RookChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        super(chessColor,chessboardPoint);
        if (chessColor == ChessColor.BLACK){
            name = 'R';
        }else {
            name = 'r';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int y = source.getY();
        int x = source.getX();
        if (chessColor == ChessColor.BLACK) {
            for (int i = source.getX() - 1; i >= 0; i--) {
                if (chessComponents[i][y].name == '_') {
                    chessboardPoints.add(new ChessboardPoint(i, y));
                }else if (chessComponents[i][y].chessColor == ChessColor.WHITE){
                    chessboardPoints.add(new ChessboardPoint(i, y));
                    break;
                }else {
                    break;
                }
            }
            for (int i = y - 1; i >= 0; i--) {
                if (chessComponents[x][i].name == '_') {
                    chessboardPoints.add(new ChessboardPoint(x, i));
                }else if (chessComponents[x][i].chessColor == ChessColor.WHITE){
                    chessboardPoints.add(new ChessboardPoint(x, i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = y + 1; i < 8; i++) {
                if (chessComponents[x][i].name == '_') {
                    chessboardPoints.add(new ChessboardPoint(x, i));
                }else if (chessComponents[x][i].chessColor == ChessColor.WHITE){
                    chessboardPoints.add(new ChessboardPoint(x, i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = source.getX() + 1; i < 8; i++) {
                if (chessComponents[i][y].name == '_') {
                    chessboardPoints.add(new ChessboardPoint(i, y));
                }else if (chessComponents[i][y].chessColor == ChessColor.WHITE){
                    chessboardPoints.add(new ChessboardPoint(i, y));
                    break;
                }else {
                    break;
                }
            }
            if (source.getX() == 7 && source.getY() == 7){
                if (chessComponents[7][6].name == 'K'){
                    chessboardPoints.add(new ChessboardPoint(7,5));
                };
            }
            if (source.getX() == 7 && source.getY() == 0){
                if (chessComponents[7][1].name == 'K'){
                    chessboardPoints.add(new ChessboardPoint(7,2));
                };
            }
        }else if (chessColor == ChessColor.WHITE){
            for (int i = source.getX() - 1; i >= 0; i--) {
                if (chessComponents[i][y].name == '_') {
                    chessboardPoints.add(new ChessboardPoint(i, y));
                }else if (chessComponents[i][y].chessColor == ChessColor.BLACK){
                    chessboardPoints.add(new ChessboardPoint(i, y));
                    break;
                }else {
                    break;
                }
            }
            for (int i = y - 1; i >= 0; i--) {
                if (chessComponents[x][i].name == '_') {
                    chessboardPoints.add(new ChessboardPoint(x, i));
                }else if (chessComponents[x][i].chessColor == ChessColor.BLACK){
                    chessboardPoints.add(new ChessboardPoint(x, i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = y + 1; i < 8; i++) {
                if (chessComponents[x][i].name == '_') {
                    chessboardPoints.add(new ChessboardPoint(x, i));
                }else if (chessComponents[x][i].chessColor == ChessColor.BLACK){
                    chessboardPoints.add(new ChessboardPoint(x, i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = source.getX() + 1; i < 8; i++) {
                if (chessComponents[i][y].name == '_') {
                    chessboardPoints.add(new ChessboardPoint(i, y));
                }else if (chessComponents[i][y].chessColor == ChessColor.BLACK){
                    chessboardPoints.add(new ChessboardPoint(i, y));
                    break;
                }else {
                    break;
                }
            }
        }
        return chessboardPoints;
    };
}
