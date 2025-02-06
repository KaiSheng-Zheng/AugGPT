import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent() {}

    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor) {
        super(chessboardPoint, chessColor);
        if (chessColor == ChessColor.WHITE){
            this.name = 'q';
        }
        if (chessColor == ChessColor.BLACK){
            this.name = 'Q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        int i = 1;
        while (i < 8) {
            if(Objects.equals(getSource().offset(i, i),null)){
                break;
            }else{
                a.add(getSource().offset(i, i));
            }
            if (chessBoard[getSource().getX()+i][getSource().getY()+i].name != '_'){
                break;
            }
            i++;
        }
        i = 1;
        while (i < 8) {
            if(Objects.equals(getSource().offset(-i, -i),null)){
                break;
            }else{
                a.add(getSource().offset(-i, -i));
            }
            if (chessBoard[getSource().getX()-i][getSource().getY()-i].name != '_'){
                break;
            }
            i++;
        }
        i = 1;
        while (i < 8) {
            if(Objects.equals(getSource().offset(i, -i),null)){
                break;
            }else{
                a.add(getSource().offset(i, -i));
            }
            if (chessBoard[getSource().getX()+i][getSource().getY()-i].name != '_'){
                break;
            }
            i++;
        }
        i = 1;
        while (i < 8) {
            if(Objects.equals(getSource().offset(-i, i),null)){
                break;
            }else{
                a.add(getSource().offset(-i, i));
            }
            if (chessBoard[getSource().getX()-i][getSource().getY()+i].name != '_'){
                break;
            }
            i++;
        }
        i = 1;
        while (i < 8) {
            if(Objects.equals(getSource().offset(i, 0),null)){
                break;
            }else{
                a.add(getSource().offset(i, 0));
            }
            if (chessBoard[getSource().getX()+i][getSource().getY()].name != '_'){
                break;
            }
            i++;
        }
        i = 1;
        while (i < 8) {
            if(Objects.equals(getSource().offset(-i, 0),null)){
                break;
            }else{
                a.add(getSource().offset(-i, 0));
            }
            if (chessBoard[getSource().getX()-i][getSource().getY()].name != '_'){
                break;
            }
            i++;
        }
        i = 1;
        while (i < 8) {
            if(Objects.equals(getSource().offset(0, -i),null)){
                break;
            }else{
                a.add(getSource().offset(0, -i));
            }
            if (chessBoard[getSource().getX()][getSource().getY()-i].name != '_'){
                break;
            }
            i++;
        }
        i = 1;
        while (i < 8) {
            if(Objects.equals(getSource().offset(0, i),null)){
                break;
            }else{
                a.add(getSource().offset(0, i));
            }
            if (chessBoard[getSource().getX()][getSource().getY()+i].name != '_'){
                break;
            }
            i++;
        }
        return a;
    }
}
