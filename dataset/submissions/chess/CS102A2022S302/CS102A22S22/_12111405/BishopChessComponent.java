import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {



    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<>();

        ChessboardPoint a = this.getSource();
        int x = a.getX();
        int y = a.getY();
        int ans = Math.max(x, y);//bigger one
        int num = Math.min(x, y);//smaller one
        for (int i = 1; i < 8 - ans; i++) {
            if (chessboard[x + i][y + i].getChessColor() == this.getChessColor()){
                break;
            }else if (chessboard[x + i][y + i].getChessColor() ==ChessColor.NONE ){
                answer.add(a.offset(i, i));
            }else {
                answer.add(a.offset(i, i));
                break;
            }

        }

        for (int i = 1; i <= num; i++) {
            if (chessboard[x - i][y - i].getChessColor() == this.getChessColor()){
                break;
            }else if (chessboard[x - i][y - i].getChessColor() == ChessColor.NONE) {
                answer.add(a.offset(-i, -i));
            }else {
                answer.add(a.offset(-i,-i));
                break;
            }

        }
        int reverse = Math.min(7 - x, y);
        int inverse=Math.min(x,7-y);

        for (int i = 1; i <= reverse; i++) {
            if (chessboard[x + i][y - i].getChessColor() == this.getChessColor()){
                break;
            }else if (chessboard[x + i][y - i].getChessColor() == ChessColor.NONE) {
                answer.add(a.offset(i, -i));
            }else {
                answer.add(a.offset(i, -i));
                break;
            }
        }
        for (int i = 1; i <= inverse; i++) {
            if (chessboard[x - i][y + i].getChessColor() == this.getChessColor()){
                break;
            }else if (chessboard[x - i][y + i].getChessColor() == ChessColor.NONE) {
                answer.add(a.offset(-i, i));
            }else {
                answer.add(a.offset(-i, i));
                break;

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