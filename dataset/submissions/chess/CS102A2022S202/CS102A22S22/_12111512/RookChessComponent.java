import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source,chessColor);
        this.source = source;
        this.chessColor = chessColor;
        if (chessColor == ChessColor.BLACK){
            name = 'R';
        }
        else
            name = 'r';
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        for (int i = source.getX()-1; i >=0; i--) {
            if (chessboard[i][source.getY()].name=='_')
                a.add(chessboard[i][source.getY()].getSource());
            else if (chessboard[i][source.getY()].name!='_' && chessboard[i][source.getY()].getChessColor()!=this.chessColor){
                a.add(chessboard[i][source.getY()].getSource());
                break;
            }
            else if (chessboard[i][source.getY()].name!='_' && chessboard[i][source.getY()].getChessColor()==this.chessColor)
                break;
        }

        for (int i = source.getX()+1; i <=7; i++) {
            if (chessboard[i][source.getY()].name=='_')
                a.add(chessboard[i][source.getY()].getSource());
            else if (chessboard[i][source.getY()].name!='_' && chessboard[i][source.getY()].getChessColor()!=this.chessColor){
                a.add(chessboard[i][source.getY()].getSource());
                break;
            }
            else if (chessboard[i][source.getY()].name!='_' && chessboard[i][source.getY()].getChessColor()==this.chessColor)
                break;
        }

        for (int i = source.getY()-1; i >=0; i--) {
            if (chessboard[source.getX()][i].name=='_')
                a.add(chessboard[source.getX()][i].getSource());
            else if (chessboard[source.getX()][i].name!='_' && chessboard[source.getX()][i].getChessColor()!=this.chessColor){
                a.add(chessboard[source.getX()][i].getSource());
                break;
            }
            else if (chessboard[source.getX()][i].name!='_' && chessboard[source.getX()][i].getChessColor()==this.chessColor)
                break;
        }

        for (int i = source.getY()+1; i <=7; i++) {
            if (chessboard[source.getX()][i].name=='_')
                a.add(chessboard[source.getX()][i].getSource());
            else if (chessboard[source.getX()][i].name!='_' && chessboard[source.getX()][i].getChessColor()!=this.chessColor){
                a.add(chessboard[source.getX()][i].getSource());
                break;
            }
            else if (chessboard[source.getX()][i].name!='_' && chessboard[source.getX()][i].getChessColor()==this.chessColor)
                break;
        }


        return a;
    }
}
