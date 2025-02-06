import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {


    ChessColor chessColor;

    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
        super(chessboardPoint, chessColor, name);
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        boolean valid = true;
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            valid = false;
        }
        if (valid) {
            for (int i = 1; i <= 7 - x; i++) {
                if (x + i <= 7 && board[x + i][y].getChessColor() != chessColor) {
                    list.add(new ChessboardPoint(x + i, y));
                    if (board[x + i][y].name != '_') {
                        break;
                    }
                } else {
                    break;
                }
//                if (x+i<=7){
//                    if (board[x+i][y].name=='_'){
//                        list.add(new ChessboardPoint(x+i,y));
//                    }else if (board[x+i][y].getChessColor()!=chessColor){
//                        list.add(new ChessboardPoint(x+i,y));
//                        break;
//                    }else if (board[x+i][y].getChessColor()==chessColor){
//                        break;
//                    }
//                }else {
//                    break;
//                }

            }
            for (int i = 1; i <= x; i++) {
                if (x - i >= 0 && board[x - i][y].getChessColor() != chessColor) {
                    list.add(new ChessboardPoint(x - i, y));
                    if (board[x - i][y].name != '_') {
                        break;
                    }
                } else {
                    break;
                }
//                if (x-i>=0){
//                    if (board[x-i][y].name=='_'){
//                        list.add(new ChessboardPoint(x-i,y));
//                    }else if (board[x-i][y].getChessColor()!=chessColor){
//                        list.add(new ChessboardPoint(x-i,y));
//                        break;
//                    }else if (board[x-i][y].getChessColor()==chessColor){
//                        break;
//                    }
//                }

            }
            for (int i = 1; i <= 7 - y; i++) {
                if (y + i <= 7 && board[x][y + i].name == '_') {
                    list.add(new ChessboardPoint(x, y + i));
                } else {
                    if (y + i <= 7 && board[x][y + i].getChessColor() != chessColor) {
                        list.add(new ChessboardPoint(x, y + i));
                        break;
                    } else {
                        break;
                    }
                }
            }
            for (int i = 1; i <= y; i++) {
                if (y - i >= 0 && board[x][y - i].name == '_') {
                    list.add(new ChessboardPoint(x, y - i));
                } else {
                    if (y - i >= 0 && board[x][y - i].getChessColor() != chessColor) {
                        list.add(new ChessboardPoint(x, y - i));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        return list;
    }
//    @Override
//    public ChessComponent copy(int x, int y) {
//        return new RookChessComponent(new ChessboardPoint(x, y), this.chessColor, this.name);
//    }
}
