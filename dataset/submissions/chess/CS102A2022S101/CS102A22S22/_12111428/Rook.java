import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rook extends ChessComponent{


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessColor currentColor = getChessColor();
        ChessboardPoint source = getChessboardPoint();

        ChessComponent[][] chessboard = getChessComponents();

        int x = source.getX();
        int y =source.getY();

        List<ChessboardPoint> points= new ArrayList<>();

        int counter =1;
        while(true){

            ChessboardPoint DirectionPlusY=source.offset(counter,0);
            if(DirectionPlusY!=null){
                int x2 =DirectionPlusY.getX();
                int y2 =DirectionPlusY.getY();

                if(chessboard[x2][y2].getChessColor()==currentColor){
                    break;
                }
                else if(chessboard[x2][y2].getChessColor()!=currentColor&&chessboard[x2][y2].getChessColor()!=ChessColor.NONE){
                    points.add(DirectionPlusY);
                    break;
                }else {
                    points.add(DirectionPlusY);
                    ++counter;
                }
            }else {
                break;
            }

        }
        int counter1 =-1;
        while(true){

            ChessboardPoint DirectionMinusY=source.offset(counter1,0);
            if(DirectionMinusY!=null){
                int x2 =DirectionMinusY.getX();
                int y2 =DirectionMinusY.getY();

                if(chessboard[x2][y2].getChessColor()==currentColor){
                    break;
                }
                else if(chessboard[x2][y2].getChessColor()!=currentColor&&chessboard[x2][y2].getChessColor()!=ChessColor.NONE){
                    points.add(DirectionMinusY);
                    break;
                }else {
                    points.add(DirectionMinusY);
                    --counter1;
                }
            }else {
                break;
            }

        }

        int counter2 =1;
        while(true){

            ChessboardPoint DirectionPlusX=source.offset(0,counter2);
            if(DirectionPlusX!=null){
                int x2 =DirectionPlusX.getX();
                int y2 =DirectionPlusX.getY();

                if(chessboard[x2][y2].getChessColor()==currentColor){
                    break;
                }
                else if(chessboard[x2][y2].getChessColor()!=currentColor&&chessboard[x2][y2].getChessColor()!=ChessColor.NONE){
                    points.add(DirectionPlusX);
                    break;
                }else {
                    points.add(DirectionPlusX);
                    ++counter2;
                }
            }else {
                break;
            }

        }

        int counter3 =-1;
        while(true){

            ChessboardPoint DirectionMinusY=source.offset(0,counter3);
            if(DirectionMinusY!=null){
                int x2 =DirectionMinusY.getX();
                int y2 =DirectionMinusY.getY();

                if(chessboard[x2][y2].getChessColor()==currentColor){
                    break;
                }
                else if(chessboard[x2][y2].getChessColor()!=currentColor&&chessboard[x2][y2].getChessColor()!=ChessColor.NONE){
                    points.add(DirectionMinusY);
                    break;
                }else {
                    points.add(DirectionMinusY);
                    --counter3;
                }
            }else {
                break;
            }

        }

        return points;
    }


}