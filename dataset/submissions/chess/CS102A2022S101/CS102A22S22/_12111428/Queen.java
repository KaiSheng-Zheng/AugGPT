import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessColor currentColor = getChessColor();
        ChessboardPoint source = getChessboardPoint();

        ChessComponent[][] chessboard = getChessComponents();

        List<ChessboardPoint> points= new ArrayList<>();

        int count =1;
        while(true){

            ChessboardPoint DirectionPlusY=source.offset(count,0);

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
                    ++count;
                }
            }else {
                break;
            }

        }
        int count1 =-1;
        while(true){

            ChessboardPoint DirectionMinusY=source.offset(count1,0);
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
                    --count1;
                }
            }else {
                break;
            }

        }

        int count2 =1;
        while(true){

            ChessboardPoint DirectionPlusX=source.offset(0,count2);
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
                    ++count2;
                }
            }else {
                break;
            }

        }

        int count3 =-1;
        while(true){

            ChessboardPoint DirectionMinusY=source.offset(0,count3);
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
                    --count3;
                }
            }else {
                break;
            }

        }

        int counter =1;
        int counter2 =1;
        while(true){

            ChessboardPoint Direction1=source.offset(counter,counter2);
            if(Direction1!=null){
                int x2 =Direction1.getX();
                int y2 =Direction1.getY();

                if(chessboard[x2][y2].getChessColor()==currentColor){
                    break;
                }
                else if(chessboard[x2][y2].getChessColor()!=currentColor&&chessboard[x2][y2].getChessColor()!=ChessColor.NONE){
                    points.add(Direction1);
                    break;
                }else {
                    points.add(Direction1);
                    ++counter;
                    ++counter2;
                }
            } else {
                break;
            }
        }

        int counter3 =1;
        int counter4 =-1;
        while(true){

            ChessboardPoint Direction2=source.offset(counter3,counter4);
            if(Direction2!=null){
                int x2 =Direction2.getX();
                int y2 =Direction2.getY();

                if(chessboard[x2][y2].getChessColor()==currentColor){
                    break;
                }
                else if(chessboard[x2][y2].getChessColor()!=currentColor&&chessboard[x2][y2].getChessColor()!=ChessColor.NONE){
                    points.add(Direction2);
                    break;
                }else {
                    points.add(Direction2);
                    ++counter3;
                    --counter4;
                }
            }else {
                break;
            }

        }

        int counter5 =-1;
        int counter6 =-1;
        while(true){

            ChessboardPoint Direction3=source.offset(counter5,counter6);
            if(Direction3!=null){
                int x2 =Direction3.getX();
                int y2 =Direction3.getY();

                if(chessboard[x2][y2].getChessColor()==currentColor){
                    break;
                }
                else if(chessboard[x2][y2].getChessColor()!=currentColor&&chessboard[x2][y2].getChessColor()!=ChessColor.NONE){
                    points.add(Direction3);
                    break;
                }else {
                    points.add(Direction3);
                    --counter5;
                    --counter6;
                }
            }else {
                break;
            }

        }

        int counter7 =-1;
        int counter8 =1;
        while(true){

            ChessboardPoint Direction4=source.offset(counter7,counter8);

            if(Direction4!=null){
                int x2 =Direction4.getX();
                int y2 =Direction4.getY();

                if(chessboard[x2][y2].getChessColor()==currentColor){
                    break;
                }
                else if(chessboard[x2][y2].getChessColor()!=currentColor&&chessboard[x2][y2].getChessColor()!=ChessColor.NONE){
                    points.add(Direction4);
                    break;
                }else {
                    points.add(Direction4);
                    --counter7;
                    ++counter8;
                }
            }else {
                break;
            }
        }

        return points;
    }

}