import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor color, char name) {
        this.name = name;
        this.source = source;
        this.chessColor = color;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                ChessboardPoint destination=component.getSource();
                if (moveTo(chessComponents,destination)&&component.getChessColor()!=chessColor){
                    a.add(destination);
                }
            }
        }
        return a;
    }
    public boolean moveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        if(Math.abs(source.getX()-destination.getX())==2&&Math.abs(source.getY()-destination.getY())==1){
            return true;}
        else return Math.abs(source.getX() - destination.getX()) == 1 && Math.abs(source.getY() - destination.getY()) == 2;
    }


}
