import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent {



    public PawnChessComponent(char name,ChessColor chessColor,ChessboardPoint source,ChessComponent[][] chessComponents){
        super(name,chessColor,source,chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        switch (getChessColor()) {
            case WHITE: {
                if (getSource().getX() == 0)
                    return list;
                else {
                    if(getSource().getY() != 0&&getSource().getY() != 7){
                        if (chessComponents[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.BLACK)
                        list.add(getSource().offset(-1, -1));
                        if (chessComponents[getSource().getX() - 1][ getSource().getY() + 1].getChessColor() == ChessColor.BLACK)
                        list.add(getSource().offset(-1, 1));}
                    if(getSource().getY() == 0)
                        if (chessComponents[getSource().getX() - 1][ getSource().getY() + 1].getChessColor() == ChessColor.BLACK)
                            list.add(getSource().offset(-1, 1));
                    if(getSource().getY() == 7)
                        if (chessComponents[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.BLACK)
                            list.add(getSource().offset(-1, -1));
                    if (getSource().getX() == 6) {
                        if (chessComponents[getSource().getX()-1][getSource().getY()].getChessColor() == ChessColor.BLACK | chessComponents[getSource().getX() - 1][getSource().getY()].getChessColor() == ChessColor.WHITE) {
                            {Collections.sort(list,super.priSort);return list;}
                        } else if (chessComponents[getSource().getX()-2][getSource().getY()].getChessColor() == ChessColor.BLACK |chessComponents[getSource().getX() - 2][getSource().getY()].getChessColor() == ChessColor.WHITE) {
                            list.add(getSource().offset(-1, 0));
                            Collections.sort(list,super.priSort);
                            return list;
                        } else {
                            list.add(getSource().offset(-1, 0));
                            list.add(getSource().offset(-2, 0));
                            Collections.sort(list,super.priSort);
                            return list;
                        }

                    } else {
                        if (chessComponents[getSource().getX() - 1][getSource().getY()].getChessColor() == ChessColor.BLACK | chessComponents[getSource().getX() - 1][getSource().getY()].getChessColor() == ChessColor.WHITE)
                        {Collections.sort(list,super.priSort);return list;}
                        else {
                            list.add(getSource().offset(-1, 0));
                            Collections.sort(list,super.priSort);
                            return list;
                        }
                    }
                }
            }
            case BLACK: {
                if (getSource().getX() == 7)
                    return list;
                else {
                    if(getSource().getY() != 0&&getSource().getY() != 7){
                    if (chessComponents[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE)
                        list.add(getSource().offset(1, -1));
                    if (chessComponents[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE)
                        list.add(getSource().offset(1, 1));}
                    if(getSource().getY() == 0)
                        if (chessComponents[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE)
                            list.add(getSource().offset(1, 1));
                    if(getSource().getY() == 7)
                        if (chessComponents[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE)
                            list.add(getSource().offset(1, -1));
                    if (getSource().getX() == 1) {
                        if (chessComponents[getSource().getX()+ 1][getSource().getY() ].getChessColor() == ChessColor.WHITE | chessComponents[getSource().getX() + 1][getSource().getY()].getChessColor() == ChessColor.BLACK)
                        { Collections.sort(list,super.priSort);return list;}
                        else if (chessComponents[getSource().getX() + 2][getSource().getY()].getChessColor() == ChessColor.WHITE | chessComponents[getSource().getX() + 2][getSource().getY()].getChessColor() == ChessColor.BLACK) {
                            list.add(getSource().offset(1, 0));
                            Collections.sort(list,super.priSort);
                            return list;
                        } else {
                            list.add(getSource().offset(1, 0));
                            list.add(getSource().offset(2, 0));
                            Collections.sort(list,super.priSort);
                            return list;
                        }
                    } else {
                        if (chessComponents[getSource().getX() + 1][getSource().getY()].getChessColor() == ChessColor.WHITE | chessComponents[getSource().getX() + 1][getSource().getY()].getChessColor() == ChessColor.BLACK)
                        { Collections.sort(list,super.priSort);
                            return list;
                        }
                        else {
                            {list.add(getSource().offset(1, 0));
                                Collections.sort(list,super.priSort);
                            return list;}
                        }
                    }
                }
            }
        }
        Collections.sort(list,super.priSort);
            return list;
        }
    }
