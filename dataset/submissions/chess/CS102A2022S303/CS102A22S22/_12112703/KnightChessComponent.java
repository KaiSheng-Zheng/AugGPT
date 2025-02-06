import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KnightChessComponent extends ChessComponent{


    public KnightChessComponent() {}

    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor) {
        super(chessboardPoint, chessColor);
        if (chessColor == ChessColor.WHITE){
            this.name = 'n';
        }
        if (chessColor == ChessColor.BLACK){
            this.name = 'N';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        if(Objects.equals(getSource().offset(1, 2),null)){

        }else{
            a.add(getSource().offset(1, 2));
        }
        if(Objects.equals(getSource().offset(-1, 2),null)){

        }else{
            a.add(getSource().offset(-1, 2));
        }
        if(Objects.equals(getSource().offset(1, -2),null)){

        }else{
            a.add(getSource().offset(1, -2));
        }
        if(Objects.equals(getSource().offset(-1, -2),null)){

        }else{
            a.add(getSource().offset(-1, -2));
        }
        if(Objects.equals(getSource().offset(2, 1),null)){

        }else{
            a.add(getSource().offset(2, 1));
        }
        if(Objects.equals(getSource().offset(-2, -1),null)){

        }else{
            a.add(getSource().offset(-2, -1));
        }
        if(Objects.equals(getSource().offset(-2, 1),null)){

        }else{
            a.add(getSource().offset(-2, 1));
        }
        if(Objects.equals(getSource().offset(2, -1),null)){

        }else{
            a.add(getSource().offset(2, -1));
        }
        return a;
    }
}
