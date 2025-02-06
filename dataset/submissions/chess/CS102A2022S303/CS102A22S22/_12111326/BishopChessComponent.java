import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public BishopChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move=new ArrayList<>();
        for (int i = 1; i <= Math.min(this.getSource().getX(),7-this.getSource().getY()); i++) {
            if (this.getChessboard()[this.getSource().getX()-i][this.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(-i,i));
            }else if (this.getChessboard()[this.getSource().getX()-i][this.getSource().getY()+i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(-i,i));
                break;
            }
        }

        for (int i = 1; i <= Math.min(this.getSource().getX(),this.getSource().getY()); i++) {
            if (this.getChessboard()[this.getSource().getX()-i][this.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(-i,-i));
            }else if (this.getChessboard()[this.getSource().getX()-i][this.getSource().getY()-i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(-i,-i));
                break;
            }
        }

        for (int i = 1; i <= Math.min(7-this.getSource().getX(),this.getSource().getY()); i++) {
            if (this.getChessboard()[this.getSource().getX()+i][this.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(i,-i));
            }else if (this.getChessboard()[this.getSource().getX()+i][this.getSource().getY()-i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(i,-i));
                break;
            }
        }

        for (int i = 1; i <=Math.min(7-this.getSource().getX(),7-this.getSource().getY()); i++) {
            if (this.getChessboard()[this.getSource().getX()+i][this.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(i,i));
            }else if (this.getChessboard()[this.getSource().getX()+i][this.getSource().getY()+i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(i,i));
                break;
            }
        }





        return move;
    }



}
