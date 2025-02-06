import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<>();
        ChessboardPoint a = this.getSource();
        int x = a.getX();
        int y = a.getY();

        if (x==1&&chessboard[x+2][y].getChessColor()!=this.getChessColor()&&this.getChessColor()==ChessColor.BLACK&&chessboard[x+1][y].getChessColor()==ChessColor.NONE){
            answer.add(a.offset(2,0));
        }
        if (x==6&&chessboard[x-2][y].getChessColor()!=this.getChessColor()&&this.getChessColor()==ChessColor.WHITE&&chessboard[x-1][y].getChessColor()==ChessColor.NONE){
            answer.add(a.offset(0,-2));
        }
        if (this.getChessColor()==ChessColor.BLACK&&chessboard[x+1][y+1].getChessColor()==ChessColor.WHITE){
            answer.add(a.offset(1,+1));
        }
        if (this.getChessColor()==ChessColor.BLACK&&chessboard[x+1][y-1].getChessColor()==ChessColor.WHITE){ // ArrayIndexOutOfBoundsException if y = 0
            answer.add(a.offset(1,-1));
        }
        if (this.getChessColor()==ChessColor.WHITE&&chessboard[x-1][y-1].getChessColor()==ChessColor.BLACK){
            answer.add(a.offset(-1,-1));
        }
        if (this.getChessColor()==ChessColor.WHITE&&chessboard[x-1][y+1].getChessColor()==ChessColor.BLACK){
            answer.add(a.offset(-1,1));
        }
        if (this.getChessColor()==ChessColor.WHITE&&chessboard[x-1][y].getChessColor()==ChessColor.NONE){
            answer.add(a.offset(-1,0));
        }
        if (this.getChessColor()==ChessColor.BLACK&&chessboard[x+1][y].getChessColor()==ChessColor.NONE){
            answer.add(a.offset(1,0));
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
