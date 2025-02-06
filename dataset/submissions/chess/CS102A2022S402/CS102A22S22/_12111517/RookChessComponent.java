

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private ChessColor rook_color = ChessColor.BLACK;
    private List<ChessboardPoint> canmove1 = new ArrayList<>();
    public RookChessComponent(int x, int y, char name, List<String> chessboard) {
        setSource(new ChessboardPoint(x, y));
        super.name = name;
        super.chessboard = chessboard;
        if (name == 'r'){
            rook_color = ChessColor.WHITE;
        }
    }




    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo()  {
       for (int i = 1; i<8; i++){
           if (getSource().offset(0,i)!=null){
               if (chessboard.get(getSourceX()).charAt(getSourceY()+i)=='_') {
                   canmove1.add(new ChessboardPoint(getSource().getX(), i + getSource().getY()));
               }else if ((chessboard.get(getSourceX()).charAt(getSourceY()+i)<'Z'&&rook_color==ChessColor.WHITE)|
                       (chessboard.get(getSourceX()).charAt(getSourceY()+i)>'a'&&rook_color==ChessColor.BLACK)){
                   canmove1.add(new ChessboardPoint(getSource().getX(), i + getSource().getY()));
                   break;
               }else {
                   break;
               }
           }
           }
        for (int i = 1; i<8; i++){
            if (getSource().offset(0,-i)!=null){
                if (chessboard.get(getSourceX()).charAt(getSourceY()-i)=='_') {
                    canmove1.add(new ChessboardPoint(getSource().getX(), -i + getSource().getY()));
                }else if ((chessboard.get(getSourceX()).charAt(getSourceY()-i)<'Z'&&rook_color==ChessColor.WHITE)|
                        (chessboard.get(getSourceX()).charAt(getSourceY()-i)>'a'&&rook_color==ChessColor.BLACK)){
                    canmove1.add(new ChessboardPoint(getSource().getX(), -i + getSource().getY()));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1; i<8; i++){
            if (getSource().offset(i,0)!=null){
                if (chessboard.get(getSourceX()+i).charAt(getSourceY())=='_') {
                    canmove1.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()));
                }else if ((chessboard.get(getSourceX()+i).charAt(getSourceY())<'Z'&&rook_color==ChessColor.WHITE)|
                        (chessboard.get(getSourceX()+i).charAt(getSourceY())>'a'&&rook_color==ChessColor.BLACK)){
                    canmove1.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1; i<8; i++){
            if (getSource().offset(-i,0)!=null){
                if (chessboard.get(getSourceX()-i).charAt(getSourceY())=='_') {
                    canmove1.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()));
                }else if ((chessboard.get(getSourceX()-i).charAt(getSourceY())<'Z'&&rook_color==ChessColor.WHITE)|
                        (chessboard.get(getSourceX()-i).charAt(getSourceY())>'a'&&rook_color==ChessColor.BLACK)){
                    canmove1.add(new ChessboardPoint(getSource().getX()-i,  getSource().getY()));
                    break;
                }else {
                    break;
                }
            }
        }

        Collections.sort(canmove1);
        return canmove1;
    }
}
