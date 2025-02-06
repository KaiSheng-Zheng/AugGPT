import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(char c, int i, int j, ChessComponent[][] chessComponents) {
        super(c,i,j,chessComponents);
    }

    public boolean thisCanMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if (source.getX() >= destination.getX()-1&&source.getX() <= destination.getX()+1) {
            if (source.getY() >= destination.getY() - 1 && source.getY() <= destination.getY() + 1) {
                if (chessComponents[destination.getX()][destination.getY()].getChessColor()!=getChessColor()) {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        cmt.clear();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (thisCanMoveTo(chessComponents,new ChessboardPoint(i,j))){
                    cmt.add(new ChessboardPoint(i,j));
                }
            }
        }
        cmt.removeIf(chessboardPoint -> chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==getChessColor());
        return cmt;
    }
}
