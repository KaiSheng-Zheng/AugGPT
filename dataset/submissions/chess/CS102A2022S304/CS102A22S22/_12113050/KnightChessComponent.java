import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super();
        setSource(source);
        setChessColor(chessColor);
        if (chessColor==ChessColor.WHITE){
            name='n';
        }else {
            name='N';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Knight = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(getSource().getX()-i)==1&&Math.abs(getSource().getY()-j)==2&&
                        getChessComponents()[i][j].getChessColor()!=this.getChessColor()){
                    ChessboardPoint n = new ChessboardPoint(i,j);
                    Knight.add(n);

                }
                else if (Math.abs(getSource().getX()-i)==2&&Math.abs(getSource().getY()-j)==1&&
                        getChessComponents()[i][j].getChessColor()!=this.getChessColor()){
                    ChessboardPoint n = new ChessboardPoint(i,j);
                    Knight.add(n);
                }
            }
        }
        return Knight;
    }
    }

