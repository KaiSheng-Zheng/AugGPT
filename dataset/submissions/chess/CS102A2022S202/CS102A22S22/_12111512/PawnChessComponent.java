import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source,chessColor);
        this.source = source;
        this.chessColor = chessColor;
        if (chessColor == ChessColor.BLACK){
            name = 'P';
        }
        else
            name = 'p';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        if (this.chessColor==ChessColor.BLACK){
            if (source.getX()==1){
                if (chessboard[source.getX()+1][source.getY()].name=='_')
                    a.add(chessboard[source.getX()+1][source.getY()].getSource());

                if (chessboard[source.getX()+2][source.getY()].name=='_')
                    a.add(chessboard[source.getX()+2][source.getY()].getSource());
            }
            if (source.getX()+1<7){
                if (source.getY()-1>=0){
                    if (chessboard[source.getX()+1][source.getY()-1].name!='_' && chessboard[source.getX()+1][source.getY()-1].getChessColor()!=this.chessColor)
                        a.add(chessboard[source.getX()+1][source.getY()-1].getSource());
                }

                if (source.getY()+1<=7){
                    if (chessboard[source.getX()+1][source.getY()+1].name!='_' && chessboard[source.getX()+1][source.getY()+1].getChessColor()!=this.chessColor)
                        a.add(chessboard[source.getX()+1][source.getY()+1].getSource());
                }

                if (source.getX() != 1 &&chessboard[source.getX()+1][source.getY()] instanceof EmptySlotComponent)
                    a.add(chessboard[source.getX()+1][source.getY()].getSource());
            }
        }

        else{
            if (source.getX()==6){
                if (chessboard[source.getX()-1][source.getY()].name=='_' )
                    a.add(chessboard[source.getX()-1][source.getY()].getSource());

                if (chessboard[source.getX()-2][source.getY()].name=='_')
                    a.add(chessboard[source.getX()-2][source.getY()].getSource());
            }
            if (source.getX()-1>0){
                if (source.getY()-1>=0){
                    if (chessboard[source.getX()-1][source.getY()-1].name!='_' && chessboard[source.getX()-1][source.getY()-1].getChessColor()!=this.chessColor)
                        a.add(chessboard[source.getX()-1][source.getY()-1].getSource());
                }

                if (source.getY()+1<=7){
                    if (chessboard[source.getX()-1][source.getY()+1].name!='_' && chessboard[source.getX()-1][source.getY()+1].getChessColor()!=this.chessColor)
                        a.add(chessboard[source.getX()-1][source.getY()+1].getSource());
                }

                if (source.getX() != 6 && chessboard[source.getX()-1][source.getY()] instanceof EmptySlotComponent)
                    a.add(chessboard[source.getX()-1][source.getY()].getSource());
            }
        }

        return a;

    }
}
