import java.util.ArrayList;
import java.util.List;

public  class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> rooksteps=new ArrayList<>();
        ChessboardPoint rook=new ChessboardPoint(getSource().getX(), getSource().getY());
        for (int i = -7; i < 8; i++) {
            if (rook.offset(rook.getX()+i, rook.getY())!=null){
                rooksteps.add(rook.offset(rook.getX()+i, rook.getY()));
            }
            if (rook.offset(rook.getX(), rook.getY()+i)!=null){
                rooksteps.add(rook.offset(rook.getX(), rook.getY()+i));
            }
        }
        return rooksteps;
    }

}
