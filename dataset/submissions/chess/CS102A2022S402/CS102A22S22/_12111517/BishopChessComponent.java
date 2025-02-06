import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessColor bishop_color = ChessColor.BLACK;
    private List<ChessboardPoint> canmove1 = new ArrayList<>();
    public BishopChessComponent(int x, int y, char name, List<String> chessboard) {
        setSource(new ChessboardPoint(x, y));
        super.name = name;
        super.chessboard = chessboard;
        if (name == 'b'){
            bishop_color = ChessColor.WHITE;
            setChessColor(ChessColor.WHITE);
        }else {
            setChessColor(ChessColor.BLACK);
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
                    } else if ((chessboard.get(getSourceX() - i).charAt(getSourceY() - i) > 'a' && bishop_color == ChessColor.BLACK) |
                            (chessboard.get(getSourceX() - i).charAt(getSourceY() - i) < 'Z' && bishop_color == ChessColor.WHITE)) {
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
                    } else if ((chessboard.get(getSourceX() - i).charAt(getSourceY() + i) > 'a' && bishop_color == ChessColor.BLACK) |
                            (chessboard.get(getSourceX() - i).charAt(getSourceY() + i) < 'Z' && bishop_color == ChessColor.WHITE)) {
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
                    } else if ((chessboard.get(getSourceX() + i).charAt(getSourceY() - i) > 'a' && bishop_color == ChessColor.BLACK) |
                            (chessboard.get(getSourceX() + i).charAt(getSourceY() - i) < 'Z' && bishop_color == ChessColor.WHITE)) {
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
                    } else if ((chessboard.get(getSourceX() + i).charAt(getSourceY() + i) > 'a' && bishop_color == ChessColor.BLACK) |
                            (chessboard.get(getSourceX() + i).charAt(getSourceY() + i) < 'Z' && bishop_color == ChessColor.WHITE)) {
                        canmove1.add(new ChessboardPoint(getSource().getX() + i, i + getSource().getY()));
                        break;
                    } else {
                        break;
                    }
                }
            }

        }

        return canmove1;//all that can reach
    }

}
