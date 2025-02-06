import java.util.ArrayList;
import java.util.List;

class Pawn extends ChessComponent {

    @Override
    protected void setName(char x) {
        super.setName(x);
    }

    public static void main(String[] args){
        ChessboardPoint chessPoint = new ChessboardPoint(3,4);
        ChessboardPoint newPoint =chessPoint.offset(1,2);
        System.out.print(newPoint);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        System.out.print("canMoveTo activated!");
        ChessComponent[][] chessboard =getChessComponents();

        ChessboardPoint chessPoint =getChessboardPoint();
        List<ChessboardPoint> points =new ArrayList<>();
        System.out.print(chessPoint);

        ChessColor currentColor = getChessColor();
        int x = chessPoint.getX();
        int y= chessPoint.getY();

        if(currentColor == ChessColor.BLACK){
            if(y==1 ){
                ChessboardPoint newPoint =chessPoint.offset(0,2);
                points.add(newPoint);

            }else{
                ChessboardPoint newPoint =chessPoint.offset(0,1);
                points.add(newPoint);

            }
        }else if(currentColor ==ChessColor.WHITE){
            if(y==6){
                ChessboardPoint newPoint =chessPoint.offset(0,-2);
                points.add(newPoint);

            }else{
                ChessboardPoint newPoint =chessPoint.offset(0,-1);
                points.add(newPoint);

            }
        }

        if(currentColor==ChessColor.BLACK && chessboard[x+1][y+1]!=null){

        }
        System.out.print(points);

        return points ;

    }

}