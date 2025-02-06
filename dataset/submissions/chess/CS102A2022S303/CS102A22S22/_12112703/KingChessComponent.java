import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent() {}

    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor) {
        super(chessboardPoint, chessColor);
        if (chessColor == ChessColor.WHITE){
            this.name = 'k';
        }
        if (chessColor == ChessColor.BLACK){
            this.name = 'K';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        if(Objects.equals(getSource().offset(1, 0),null)){

        }else{
            a.add(getSource().offset(1, 0));
        }
        if(Objects.equals(getSource().offset(-1, 0),null)){

        }else{
            a.add(getSource().offset(-1, 0));
        }
        if(Objects.equals(getSource().offset(0, 1),null)){

        }else{
            a.add(getSource().offset(0, 1));
        }
        if(Objects.equals(getSource().offset(0, -1),null)){

        }else{
            a.add(getSource().offset(0, -1));
        }
        if(Objects.equals(getSource().offset(1, 1),null)){

        }else{
            a.add(getSource().offset(1, 1));
        }
        if(Objects.equals(getSource().offset(-1, -1),null)){

        }else{
            a.add(getSource().offset(-1, -1));
        }
        if(Objects.equals(getSource().offset(-1, 1),null)){

        }else{
            a.add(getSource().offset(-1, 1));
        }
        if(Objects.equals(getSource().offset(1, -1),null)){

        }else{
            a.add(getSource().offset(1, -1));
        }
        return a;
    }
}
