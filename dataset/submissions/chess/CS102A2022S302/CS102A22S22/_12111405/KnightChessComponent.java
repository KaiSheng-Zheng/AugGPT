import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<>();
        ChessboardPoint a = this.getSource();
        int x = a.getX();
        int y = a.getY();
        if (x + 1 <= 7 && y + 2 <= 7) {
            if (chessboard[x + 1][y + 2].getChessColor() != this.getChessColor()) {
                answer.add(a.offset(1, 2));
            }
        }
        if (x + 2 <= 7 && y + 1 <= 7) {
            if (chessboard[x + 2][y + 1].getChessColor() != this.getChessColor()) {
                answer.add(a.offset(2, 1));
            }
        }
        if (x + 1 <= 7 && y - 2 >= 0) {
            if (chessboard[x + 1][y - 2].getChessColor() != this.getChessColor()) {
                answer.add(a.offset(1, -2));
            }
        }
        if (x + 2 <= 7 && y - 1 >= 0) {
            if (chessboard[x + 2][y - 1].getChessColor() != this.getChessColor()) {
                answer.add(a.offset(2, -1));
            }
        }
        if (x - 1 >= 0 && y + 2 <= 7) {
            if (chessboard[x - 1][y + 2].getChessColor() != this.getChessColor()) {
                answer.add(a.offset(-1, 2));
            }
        }
        if (x - 1 >= 0 && y - 2 >= 0) {
            if (chessboard[x - 1][y - 2].getChessColor() != this.getChessColor()) {
                answer.add(a.offset(-1, -2));
            }
        }
        if (x - 2 >= 0 && y + 1 <= 7) {
            if (chessboard[x - 2][y + 1].getChessColor() != this.getChessColor()) {
                answer.add(a.offset(-2, 1));
            }
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            if (chessboard[x - 2][y - 1].getChessColor() != this.getChessColor()) {
                answer.add(a.offset(-2, -1));
            }
        }
        for(int o=0;o<answer.size();o++){
            for(int b=o+1;b<answer.size();b++){
                if(answer.get(o).getX()>answer.get(b).getX()){
                    ChessboardPoint temp = answer.get(o);
                    answer.set(o,answer.get(b));
                    answer.set(b,temp);
                }
                else if(answer.get(o).getX()==answer.get(b).getX()){
                    if(answer.get(o).getY()>answer.get(b).getY()){
                        ChessboardPoint temp = answer.get(o);
                        answer.set(o,answer.get(b));
                        answer.set(b,temp);
                    }
                }
            }
        }
        return answer;
    }
}