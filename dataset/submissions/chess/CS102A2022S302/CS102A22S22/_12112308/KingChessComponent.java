import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> kingsteps = new ArrayList<>();
        ChessboardPoint king=new ChessboardPoint(getSource().getX(),getSource().getY());
        if (king.offset(1,0)!=null){kingsteps.add(king.offset(1,0));}
        if (king.offset(-1,0)!=null){kingsteps.add(king.offset(-1,0));}
        if (king.offset(0,1)!=null){kingsteps.add(king.offset(0,1));}
        if (king.offset(0,-1)!=null){kingsteps.add(king.offset(0,-1));}
        if (king.offset(1,1)!=null){kingsteps.add(king.offset(1,1));}
        if (king.offset(1,-1)!=null){kingsteps.add(king.offset(1,-1));}
        if (king.offset(-1,1)!=null){kingsteps.add(king.offset(-1,1));}
        if (king.offset(-1,-1)!=null){kingsteps.add(king.offset(-1,-1));}
        return kingsteps;
    }
    public boolean isLegal(ChessboardPoint source,ChessboardPoint target){
        return chessboard[target.getX()][target.getY()].getChessColor() != getChessColor();
    }
}
