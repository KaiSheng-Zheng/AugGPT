import java.util.*;

public  class RookChessComponent extends ChessComponent{


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> No = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() + i > 7) {
                break;
            }else {

                if (getChess(this.getSource().getX(),this.getSource().getY()+i).getChessColor()==ChessColor.NONE){
                    No.add(new ChessboardPoint(getSource().getX() ,getSource().getY() + i));
                }else if (getChess(this.getSource().getX(),this.getSource().getY() + i ).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    No.add(new ChessboardPoint(getSource().getX(),getSource().getY() + i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() - i < 0) {
                break;
            }else {
                if (getChess(this.getSource().getX(),this.getSource().getY()-i).getChessColor()==ChessColor.NONE){
                    No.add(new ChessboardPoint(getSource().getX() ,(getSource().getY() - i)));
                }else if (getChess(this.getSource().getX(),this.getSource().getY()-i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    No.add(new ChessboardPoint(getSource().getX(),getSource().getY() - i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getX() - i < 0) {
                break;
            }else {
                if (getChess(this.getSource().getX() - i,this.getSource().getY()).getChessColor()==ChessColor.NONE){
                    No.add(new ChessboardPoint((getSource().getX() - i) ,getSource().getY() ));
                }else if (getChess(this.getSource().getX() - i,this.getSource().getY()).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    No.add(new ChessboardPoint((getSource().getX() - i),getSource().getY() ));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getX() + i > 7) {
                break;
            }else {
                if (getChess(this.getSource().getX() + i,this.getSource().getY()).getChessColor()==ChessColor.NONE){
                    No.add(new ChessboardPoint((getSource().getX() + i) ,getSource().getY() ));
                }else if (getChess(this.getSource().getX() + i,this.getSource().getY()).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    No.add(new ChessboardPoint((getSource().getX() + i),getSource().getY() ));
                    break;
                }
            }
        }

        return No;
    }

}
