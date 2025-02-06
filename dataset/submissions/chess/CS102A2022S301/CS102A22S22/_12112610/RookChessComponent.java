
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(char name, ChessColor chessColor, ChessboardPoint source,ChessComponent[][]chessComponents){
        super(name ,chessColor, source,chessComponents);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
            List<ChessboardPoint> result = new ArrayList<>();
            ChessboardPoint point = this.getSource();
        for (int i = 1; i <= point.getX(); i++) {
            if (chessboard[point.getX()- i][point.getY()].getChessColor()== this.getChessColor()) {
                break;
            }
            else if (chessboard[point.getX()- i][point.getY()].getChessColor()==ChessColor.NONE){
                result.add(point.offset(-i,0));
            }else {
                result.add(point.offset(-i,0));
                break;

            }
        }
            for (int i = 1; i < 8 - point.getX(); i++) {
                if (chessboard[point.getX()+ i][point.getY()].getChessColor()== this.getChessColor()) {
                    break;
                }
                else if (chessboard[point.getX()+ i][point.getY()].getChessColor()== ChessColor.NONE){
                    result.add(point.offset(i,0));
                }else {
                    result.add(point.offset(i,0));
                    break;

                }
            }
        for (int i = 1; i <=point.getY() ; i++) {
            if (chessboard[point.getX()][point.getY()-i].getChessColor()==this.getChessColor()){
                break;
            }
            else if (chessboard[point.getX()][point.getY()-i].getChessColor()==ChessColor.NONE){
                result.add(point.offset(0,-i));
            }else {
                result.add(point.offset(0,-i));
                break;
            }

        }
            for (int i = 1; i < 8-point.getY(); i++) {
                if (chessboard[point.getX()][point.getY()+i].getChessColor() ==this.getChessColor()){
                    break;
                }
                else if (chessboard[point.getX()][point.getY()+i].getChessColor() ==ChessColor.NONE){
                    result.add(point.offset(0,i));
                }else {
                    result.add(point.offset(0,i));
                    break;

                }
            }
            for(int i=0;i<result.size();i++){
                for(int j=i+1;j<result.size();j++){
                    if(result.get(i).getX() > result.get(j).getX()){
                        ChessboardPoint temp = result.get(i);
                        result.set(i,result.get(j));
                        result.set(j,temp);
                    }
                    else if(result.get(i).getX()== result.get(j).getX()){
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
    

