

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessColor pawn_color = ChessColor.BLACK;
    private List<ChessboardPoint> canmove1 = new ArrayList<>();
    public PawnChessComponent(int x, int y, char name, List<String> chessboard) {
        setSource(new ChessboardPoint(x, y));
        super.name = name;
        super.chessboard = chessboard;
        if (name == 'p'){
            pawn_color = ChessColor.WHITE;
        }
    }


    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo()  {
        canmove1 = new ArrayList<>();
        if (pawn_color.equals(ChessColor.WHITE)){
            //straight
            if (getSource().getX() == 6){//2steps straight
                if (chessboard.get(5).charAt(getSource().getY())=='_'){
                    canmove1.add(new ChessboardPoint(5,getSource().getY()));
                }
                if (chessboard.get(4).charAt(getSource().getY())=='_'){
                    canmove1.add(new ChessboardPoint(4,getSource().getY()));
                }
            }else if (getSource().getX() == 0){//to the top
            }else {//other straight
                if (chessboard.get(getSource().getX()-1).charAt(getSource().getY())=='_'){
                    canmove1.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
                }
            }
            //eat
            //left above
            if (getSource().getX()!=0&&getSource().getY()!=0) {
                if (chessboard.get(getSource().getX() - 1).charAt(getSource().getY() - 1)<'Z'
                &&chessboard.get(getSource().getX() - 1).charAt(getSource().getY() - 1)>'A'){
                    canmove1.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
                }
            }
            //right above
            if (getSource().getX()!=0&&getSource().getY()!=7) {
                if (chessboard.get(getSource().getX() - 1).charAt(getSource().getY() + 1)<'Z'&&
                        chessboard.get(getSource().getX() - 1).charAt(getSource().getY() + 1)>'A'){
                    canmove1.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
                }
            }
        }else  if (pawn_color.equals(ChessColor.BLACK)){
            //straight
            if (getSource().getX() == 1){//2steps straight
                if (chessboard.get(2).charAt(getSource().getY())=='_'){
                    canmove1.add(new ChessboardPoint(2,getSource().getY()));
                }
                if (chessboard.get(3).charAt(getSource().getY())=='_'){
                    canmove1.add(new ChessboardPoint(3,getSource().getY()));
                }
            }else if (getSource().getX() == 7){//to the top
            }else {//other straight
                if (chessboard.get(getSource().getX()+1).charAt(getSource().getY())=='_'){
                    canmove1.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
                }
            }
            //eat
            //left above
            if (getSource().getX()!=7&&getSource().getY()!=0) {
                if (chessboard.get(getSource().getX() + 1).charAt(getSource().getY() - 1)<'z'&&
                        chessboard.get(getSource().getX() + 1).charAt(getSource().getY() - 1)>'a'){
                    canmove1.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
                }
            }
            //right above
            if (getSource().getX()!=7&&getSource().getY()!=7) {
                if (chessboard.get(getSource().getX() + 1).charAt(getSource().getY() + 1)<'z'&&
                        chessboard.get(getSource().getX() + 1).charAt(getSource().getY() + 1)>'a'){
                    canmove1.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
                }
            }
        }
        return canmove1;
        }


}
