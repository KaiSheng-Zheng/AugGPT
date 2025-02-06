import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source,chessColor);
        this.source = source;
        this.chessColor = chessColor;
        if (chessColor == ChessColor.BLACK){
            name = 'B';
        }
        else
            name = 'b';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (source.getX()+i>7||source.getY()+i>7)
                break;
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor()!=this.chessColor && chessboard[source.getX()+i][source.getY()+i].name=='_')
                a.add(chessboard[source.getX()+i][source.getY()+i].getSource());
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor()!=this.chessColor && chessboard[source.getX()+i][source.getY()+i].name!='_'){
                a.add(chessboard[source.getX()+i][source.getY()+i].getSource());
                break;
            }
            if (chessboard[source.getX()+i][source.getY()+i].getChessColor()==this.chessColor)
                break;
        }

        for (int i = 1; i < 8; i++) {
            if (source.getX()+i>7||source.getY()-i<0)
                break;
            if (chessboard[source.getX()+i][source.getY()-i].getChessColor()!=this.chessColor && chessboard[source.getX()+i][source.getY()-i].name=='_')
                a.add(chessboard[source.getX()+i][source.getY()-i].getSource());
            if (chessboard[source.getX()+i][source.getY()-i].getChessColor()!=this.chessColor && chessboard[source.getX()+i][source.getY()-i].name!='_'){
                a.add(chessboard[source.getX()+i][source.getY()-i].getSource());
                break;
            }
            if (chessboard[source.getX()+i][source.getY()-i].getChessColor()==this.chessColor)
                break;
        }

        for (int i = 1; i < 8; i++) {
            if (source.getX()-i<0||source.getY()+i>7)
                break;
            if (chessboard[source.getX()-i][source.getY()+i].getChessColor()!=this.chessColor && chessboard[source.getX()-i][source.getY()+i].name=='_')
                a.add(chessboard[source.getX()-i][source.getY()+i].getSource());
            if (chessboard[source.getX()-i][source.getY()+i].getChessColor()!=this.chessColor && chessboard[source.getX()-i][source.getY()+i].name!='_'){
                a.add(chessboard[source.getX()-i][source.getY()+i].getSource());
                break;
            }
            if (chessboard[source.getX()-i][source.getY()+i].getChessColor()==this.chessColor)
                break;
        }

        for (int i = 1; i < 8; i++) {
            if (source.getX()-i<0||source.getY()-i<0)
                break;
            if (chessboard[source.getX()-i][source.getY()-i].getChessColor()!=this.chessColor && chessboard[source.getX()-i][source.getY()-i].name=='_')
                a.add(chessboard[source.getX()-i][source.getY()-i].getSource());
            if (chessboard[source.getX()-i][source.getY()-i].getChessColor()!=this.chessColor && chessboard[source.getX()-i][source.getY()-i].name!='_'){
                a.add(chessboard[source.getX()-i][source.getY()-i].getSource());
                break;
            }
            if (chessboard[source.getX()-i][source.getY()-i].getChessColor()==this.chessColor)
                break;
        }


        return a;
    }
}
