import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessColor currentColor = getChessColor();
        ChessboardPoint source = getChessboardPoint();

        ChessComponent[][] chessboard = getChessComponents();

        List<ChessboardPoint> points= new ArrayList<>();
        ChessboardPoint Direction1=source.offset(1,2);
        if(Direction1!=null){
            int x =Direction1.getX();
            int y =Direction1.getY();
            ChessColor targetColor =chessboard[x][y].getChessColor();
            if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()!=ChessColor.NONE){
                points.add(Direction1);
            }else if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()==ChessColor.NONE){
                points.add(Direction1);
            }
        }
        ChessboardPoint Direction2=source.offset(1,-2);
        if(Direction2!=null){
            int x =Direction2.getX();
            int y =Direction2.getY();
            ChessColor targetColor =chessboard[x][y].getChessColor();
            if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()!=ChessColor.NONE){
                points.add(Direction2);
            }else if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()==ChessColor.NONE){
                points.add(Direction2);
            }
        }
        ChessboardPoint Direction3=source.offset(-1,2);
        if(Direction3!=null){
            int x =Direction3.getX();
            int y =Direction3.getY();
            ChessColor targetColor =chessboard[x][y].getChessColor();
            if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()!=ChessColor.NONE){
                points.add(Direction3);
            }else if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()==ChessColor.NONE) {
                points.add(Direction3);
            }
        }
        ChessboardPoint Direction4=source.offset(-1,-2);
        if(Direction4!=null){
            int x =Direction4.getX();
            int y =Direction4.getY();
            ChessColor targetColor =chessboard[x][y].getChessColor();
            if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()!=ChessColor.NONE){
                points.add(Direction4);
            }else if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()==ChessColor.NONE) {
                points.add(Direction4);
            }
        }
        ChessboardPoint Direction5=source.offset(2,1);
        if(Direction5!=null){
            int x =Direction5.getX();
            int y =Direction5.getY();
            ChessColor targetColor =chessboard[x][y].getChessColor();
            if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()!=ChessColor.NONE){
                points.add(Direction5);
            }else if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()==ChessColor.NONE) {
                points.add(Direction5);
            }
        }
        ChessboardPoint Direction6=source.offset(2,-1);
        if(Direction6!=null){
            int x =Direction6.getX();
            int y =Direction6.getY();
            ChessColor targetColor =chessboard[x][y].getChessColor();
            if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()!=ChessColor.NONE){
                points.add(Direction6);
            }else if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()==ChessColor.NONE) {
                points.add(Direction6);
            }
        }
        ChessboardPoint Direction7=source.offset(-2,1);
        if(Direction7!=null){
            int x =Direction7.getX();
            int y =Direction7.getY();
            ChessColor targetColor =chessboard[x][y].getChessColor();
            if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()!=ChessColor.NONE){
                points.add(Direction7);
            }else if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()==ChessColor.NONE) {
                points.add(Direction7);
            }
        }
        ChessboardPoint Direction8=source.offset(-2,-1);
        if(Direction8!=null){
            int x =Direction8.getX();
            int y =Direction8.getY();
            ChessColor targetColor =chessboard[x][y].getChessColor();
            if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()!=ChessColor.NONE){
                points.add(Direction8);
            }else if(chessboard[x][y].getChessColor()!=currentColor&&chessboard[x][y].getChessColor()==ChessColor.NONE) {
                points.add(Direction8);
            }
        };

        return points;
    }
}