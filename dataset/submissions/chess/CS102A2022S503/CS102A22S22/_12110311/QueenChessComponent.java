import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent{



    public QueenChessComponent(char name,ChessColor chessColor,ChessboardPoint source,ChessComponent[][] chessComponents){
        super(name,chessColor,source,chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for(int i = 1;i<=7;i++){
            if(getSource().offset(0,i)==null)
                break;
            else {
                if(chessComponents[getSource().getX()][getSource().getY()+i].getChessColor() == ChessColor.NONE)
                    list.add(getSource().offset(0,i));
                else {
                    if(chessComponents[getSource().getX()][getSource().getY()+i].getChessColor() == getChessColor())
                        break;
                    else{
                        list.add(getSource().offset(0,i));
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<=7;i++){
            if(getSource().offset(0,-i)==null)
                break;
            else {
                if (chessComponents[getSource().getX()][getSource().getY() - i].getChessColor() == ChessColor.NONE)
                    list.add(getSource().offset(0, -i));
                else {
                    if (chessComponents[getSource().getX()][getSource().getY() - i].getChessColor() == getChessColor())
                        break;
                    else {
                        list.add(getSource().offset(0, -i));
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<=7;i++) {
            if (getSource().offset(i, 0) == null)
                break;
            else {
                if (chessComponents[getSource().getX() + i][getSource().getY()].getChessColor() == ChessColor.NONE)
                    list.add(getSource().offset(i, 0));
                else {
                    if (chessComponents[getSource().getX() + i][getSource().getY()].getChessColor() == getChessColor())
                        break;
                    else {
                        list.add(getSource().offset(i, 0));
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<=7;i++) {
            if (getSource().offset(-i, 0) == null)
                break;
            else {
                if (chessComponents[getSource().getX() - i][getSource().getY()].getChessColor() == ChessColor.NONE)
                    list.add(getSource().offset(-i, 0));
                else {
                    if (chessComponents[getSource().getX() - i][getSource().getY()].getChessColor() == getChessColor())
                        break;
                    else {
                        list.add(getSource().offset(-i, 0));
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<=7;i++) {
            if (getSource().offset(i, i) == null)
                break;
            else {
                if (chessComponents[getSource().getX()+i][getSource().getY()+i].getChessColor() == ChessColor.NONE)
                    list.add(getSource().offset(i, i));
                else {
                    if (chessComponents[getSource().getX()+i][getSource().getY()+i].getChessColor() == getChessColor())
                        break;
                    else {
                        list.add(getSource().offset(i, i));
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<=7;i++) {
            if (getSource().offset(-i, -i) == null)
                break;
            else {
                if (chessComponents[getSource().getX() - i][getSource().getY() - i].getChessColor() == ChessColor.NONE)
                    list.add(getSource().offset(-i, -i));
                else {
                    if (chessComponents[getSource().getX() - i][getSource().getY() - i].getChessColor() == getChessColor())
                        break;
                    else {
                        list.add(getSource().offset(-i, -i));
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<=7;i++) {
            if (getSource().offset(i, -i) == null)
                break;
            else {
                if (chessComponents[getSource().getX() + i][ getSource().getY() - i].getChessColor() == ChessColor.NONE)
                    list.add(getSource().offset(i, -i));
                else {
                    if (chessComponents[getSource().getX() + i][ getSource().getY() - i].getChessColor() == getChessColor())
                        break;
                    else {
                        list.add(getSource().offset(i, -i));
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<=7;i++){
            if(getSource().offset(-i,i)==null)
                break;
            else {
                if(chessComponents[getSource().getX()-i][ getSource().getY()+i].getChessColor() == ChessColor.NONE)
                    list.add(getSource().offset(-i,i));
                else {
                    if(chessComponents[getSource().getX()-i][getSource().getY()+i].getChessColor() == getChessColor())
                        break;
                    else{
                        list.add(getSource().offset(-i,i));
                        break;
                    }
                }
            }
        }
        Collections.sort(list,super.priSort);
        return list;
    }
}