import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char name, ChessColor chessColor, ChessboardPoint source,ChessComponent[][]chessComponents){
        super(name ,chessColor, source,chessComponents);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        ChessboardPoint point = this.getSource();
        int res = Math.max(point.getX(), point.getY());
        int count = Math.min(point.getX(), point.getY());
        for (int i = 1; i <= count; i++) {
            if (chessboard[point.getX() - i][point.getY() - i].getChessColor() == this.getChessColor()){
                break;
            }
            else if (chessboard[point.getX() - i][point.getY() - i].getChessColor() == ChessColor.NONE) {
                result.add(point.offset(-i, -i));
            }else{
                result.add(point.offset(-i,-i));
                break;
            }
        }

        int reverse = Math.min(7 - point.getX(), point.getY());
        int inverse=Math.min(point.getX(),7-point.getY());

        for (int i = 1; i <= inverse; i++) {
            if (chessboard[point.getX() - i][point.getY() + i].getChessColor() == this.getChessColor()){
                break;
            }
            else if (chessboard[point.getX() - i][point.getY() + i].getChessColor() == ChessColor.NONE) {
                result.add(point.offset(-i, i));
            }else{
                result.add(point.offset(-i, i));
                break;
            }
        }
        for (int i = 1; i <= reverse; i++) {
            if (chessboard[point.getX() + i][point.getY() - i].getChessColor() == this.getChessColor()){
                break;
            }
            else if (chessboard[point.getX() + i][point.getY() - i].getChessColor() == ChessColor.NONE) {
                result.add(point.offset(i, -i));
            }else{
                result.add(point.offset(i, -i));
                break;
            }
        }

        for (int i = 1; i < 8 - res; i++) {
            if (chessboard[point.getX() + i][point.getY() + i].getChessColor() == this.getChessColor()){
                break;
            }
            else if (chessboard[point.getX() + i][point.getY() + i].getChessColor() ==ChessColor.NONE ){
                result.add(point.offset(i, i));
            }else{
                result.add(point.offset(i, i));
                break;
            }
        }
        for(int i=0;i<result.size();i++){
            for(int j=i+1;j<result.size();j++){
                if(result.get(i).getX()>result.get(j).getX()){
                    ChessboardPoint temp = result.get(i);
                    result.set(i,result.get(j));
                    result.set(j,temp);
                }
                else if(result.get(i).getX()==result.get(j).getX()){
                    if(result.get(i).getY()>result.get(j).getY()){
                        ChessboardPoint temp = result.get(i);
                        result.set(i,result.get(j));
                        result.set(j,temp);
                    }
                }
            }
        }
        return result;
    }
}


