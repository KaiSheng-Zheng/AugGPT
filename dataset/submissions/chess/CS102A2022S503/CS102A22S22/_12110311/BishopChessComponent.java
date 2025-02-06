import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(char name,ChessColor chessColor,ChessboardPoint source,ChessComponent[][] chessComponents){
        super(name,chessColor,source,chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
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