
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private ChessColor queen_color = ChessColor.BLACK;
    private List<ChessboardPoint> canmove1 = new ArrayList<>();
    public QueenChessComponent(int x, int y, char name, List<String> chessboard) {
        setSource(new ChessboardPoint(x, y));
        super.name = name;
        super.chessboard = chessboard;
        if (name == 'q'){
            queen_color = ChessColor.WHITE;
        }
    }




    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public List<ChessboardPoint> canMoveTo()  {
        canmove1 = new ArrayList<>();
        for (int i = 1;i<8;i++) {
            if (getSource().offset(-i,-i)!=null) {
                if (!canmove1.contains(new ChessboardPoint(getSource().getX() - i, -i + getSource().getY()))) {
                    if (chessboard.get(getSourceX() - i).charAt(getSourceY() - i) == '_') {
                        canmove1.add(new ChessboardPoint(getSource().getX() - i, -i + getSource().getY()));
                    } else if ((chessboard.get(getSourceX() - i).charAt(getSourceY() - i) > 'a' && queen_color == ChessColor.BLACK) |
                            (chessboard.get(getSourceX() - i).charAt(getSourceY() - i) < 'Z' && queen_color == ChessColor.WHITE)) {
                        canmove1.add(new ChessboardPoint(getSource().getX() - i, -i + getSource().getY()));
                        break;
                    } else {
                        break;
                    }
                }
            }

        }
        for (int i = 1;i<8;i++) {
            if (getSource().offset(-i,i)!=null){
                if (!canmove1.contains(new ChessboardPoint(getSource().getX() - i, i + getSource().getY()))) {
                    if (chessboard.get(getSourceX() - i).charAt(getSourceY() + i) == '_') {
                        canmove1.add(new ChessboardPoint(getSource().getX() - i, i + getSource().getY()));
                    } else if ((chessboard.get(getSourceX() - i).charAt(getSourceY() + i) > 'a' && queen_color == ChessColor.BLACK) |
                            (chessboard.get(getSourceX() - i).charAt(getSourceY() + i) < 'Z' && queen_color == ChessColor.WHITE)) {
                        canmove1.add(new ChessboardPoint(getSource().getX() - i, i + getSource().getY()));
                        break;
                    } else {
                        break;
                    }
                }
            }

        }
        for (int i = 1;i<8;i++) {
            if (getSource().offset(i,-i)!=null){
                if (!canmove1.contains(new ChessboardPoint(getSource().getX() + i, -i + getSource().getY()))) {
                    if (chessboard.get(getSourceX() + i).charAt(getSourceY() - i) == '_') {
                        canmove1.add(new ChessboardPoint(getSource().getX() + i, -i + getSource().getY()));
                    } else if ((chessboard.get(getSourceX() + i).charAt(getSourceY() - i) > 'a' && queen_color == ChessColor.BLACK) |
                            (chessboard.get(getSourceX() + i).charAt(getSourceY() - i) < 'Z' && queen_color == ChessColor.WHITE)) {
                        canmove1.add(new ChessboardPoint(getSource().getX() + i, -i + getSource().getY()));
                        break;
                    } else {
                        break;
                    }
                }
            }

        }
        for (int i = 1;i<8;i++) {
            if (getSource().offset(i,i)!=null){
                if (!canmove1.contains(new ChessboardPoint(getSource().getX() + i, i + getSource().getY()))) {
                    if (chessboard.get(getSourceX() + i).charAt(getSourceY() + i) == '_') {
                        canmove1.add(new ChessboardPoint(getSource().getX() + i, i + getSource().getY()));
                    } else if ((chessboard.get(getSourceX() + i).charAt(getSourceY() + i) > 'a' && queen_color == ChessColor.BLACK) |
                            (chessboard.get(getSourceX() + i).charAt(getSourceY() + i) < 'Z' && queen_color == ChessColor.WHITE)) {
                        canmove1.add(new ChessboardPoint(getSource().getX() + i, i + getSource().getY()));
                        break;
                    } else {
                        break;
                    }
                }
            }

        }

        for (int i = 1; i<8; i++){
            if (getSource().offset(0,i)!=null){
                if (chessboard.get(getSourceX()).charAt(getSourceY()+i)=='_') {
                    canmove1.add(new ChessboardPoint(getSource().getX(), i + getSource().getY()));
                }else if ((chessboard.get(getSourceX()).charAt(getSourceY()+i)<'Z'&&queen_color==ChessColor.WHITE)|
                        (chessboard.get(getSourceX()).charAt(getSourceY()+i)>'a'&&queen_color==ChessColor.BLACK)){
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
                }else if ((chessboard.get(getSourceX()).charAt(getSourceY()-i)<'Z'&&queen_color==ChessColor.WHITE)|
                        (chessboard.get(getSourceX()).charAt(getSourceY()-i)>'a'&&queen_color==ChessColor.BLACK)){
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
                }else if ((chessboard.get(getSourceX()+i).charAt(getSourceY())<'Z'&&queen_color==ChessColor.WHITE)|
                        (chessboard.get(getSourceX()+i).charAt(getSourceY())>'a'&&queen_color==ChessColor.BLACK)){
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
                }else if ((chessboard.get(getSourceX()-i).charAt(getSourceY())<'Z'&&queen_color==ChessColor.WHITE)|
                        (chessboard.get(getSourceX()-i).charAt(getSourceY())>'a'&&queen_color==ChessColor.BLACK)){
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
