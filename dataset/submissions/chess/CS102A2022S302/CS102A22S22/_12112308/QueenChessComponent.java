import java.util.ArrayList;
import java.util.List;

public  class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> queensteps=new ArrayList<>();
        ChessboardPoint queen=new ChessboardPoint(getSource().getX(), getSource().getY());
        for (int i = -7; i < 8; i++) {
            if (queen.offset(queen.getX()+i, queen.getY() )!=null){queensteps.add(queen.offset(queen.getX()+i, queen.getY()));}
            if (queen.offset(queen.getX(), queen.getY()+i)!=null){queensteps.add(queen.offset(queen.getX(), queen.getY()+i));}
            if (queen.offset(queen.getX()+i, queen.getY()+i)!=null){queensteps.add(queen.offset(queen.getX()+i, queen.getY()+i));}
            if (queen.offset(queen.getX()+i, queen.getY()-i)!=null){queensteps.add(queen.offset(queen.getX()+i, queen.getY()-i ));}
        }
        return queensteps;
    }

}
