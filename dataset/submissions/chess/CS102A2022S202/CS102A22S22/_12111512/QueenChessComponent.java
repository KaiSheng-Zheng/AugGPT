import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source,chessColor);
        this.source = source;
        this.chessColor = chessColor;
        if (chessColor == ChessColor.BLACK){
            name = 'Q';
        }
        else
            name = 'q';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        for (int i = source.getX()-1; i >=0; i--) {
            if (chessboard[i][source.getY()].name=='_')
                a.add(chessboard[i][source.getY()].getSource());
            if (chessboard[i][source.getY()].name!='_' && chessboard[i][source.getY()].getChessColor()!=this.chessColor){
                a.add(chessboard[i][source.getY()].getSource());
                break;
            }
            if (chessboard[i][source.getY()].name!='_' && chessboard[i][source.getY()].getChessColor()==this.chessColor)
                break;
        }

        for (int i = source.getX()+1; i <=7; i++) {
            if (chessboard[i][source.getY()].name=='_')
                a.add(chessboard[i][source.getY()].getSource());
            if (chessboard[i][source.getY()].name!='_' && chessboard[i][source.getY()].getChessColor()!=this.chessColor){
                a.add(chessboard[i][source.getY()].getSource());
                break;
            }
            if (chessboard[i][source.getY()].name!='_' && chessboard[i][source.getY()].getChessColor()==this.chessColor)
                break;
        }

        for (int i = source.getY()-1; i >=0; i--) {
            if (chessboard[source.getX()][i].name=='_')
                a.add(chessboard[source.getX()][i].getSource());
            if (chessboard[source.getX()][i].name!='_' && chessboard[source.getX()][i].getChessColor()!=this.chessColor){
                a.add(chessboard[source.getX()][i].getSource());
                break;
            }
            if (chessboard[source.getX()][i].name!='_' && chessboard[source.getX()][i].getChessColor()==this.chessColor)
                break;
        }

        for (int i = source.getY()+1; i <=7; i++) {
            if (chessboard[source.getX()][i].name=='_')
                a.add(chessboard[source.getX()][i].getSource());
            if (chessboard[source.getX()][i].name!='_' && chessboard[source.getX()][i].getChessColor()!=this.chessColor){
                a.add(chessboard[source.getX()][i].getSource());
                break;
            }
            if (chessboard[source.getX()][i].name!='_' && chessboard[source.getX()][i].getChessColor()==this.chessColor)
                break;
        }
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
