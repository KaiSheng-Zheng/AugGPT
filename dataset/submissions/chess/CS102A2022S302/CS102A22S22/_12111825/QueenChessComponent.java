import java.util.ArrayList;
import java.util.List;

public  class QueenChessComponent extends ChessComponent {


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Dame = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() + i > 7) {
                break;
            }else {

                if (getChess(this.getSource().getX(),this.getSource().getY() + i).getChessColor()==ChessColor.NONE){
                    Dame.add(new ChessboardPoint(getSource().getX() ,getSource().getY() + i));
                }else if (getChess(this.getSource().getX(),this.getSource().getY() + i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Dame.add(new ChessboardPoint(getSource().getX(),getSource().getY() + i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY()-i<0) {
                break;
            }else {
                if (getChess(this.getSource().getX(),this.getSource().getY()-i).getChessColor()==ChessColor.NONE){
                    Dame.add(new ChessboardPoint(getSource().getX() ,(getSource().getY() - i)));
                }else if (getChess(this.getSource().getX(),this.getSource().getY()-i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Dame.add(new ChessboardPoint(getSource().getX(),getSource().getY() - i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getX() - i < 0) {
                break;
            }else {
                if (getChess(this.getSource().getX() - i,this.getSource().getY()).getChessColor()==ChessColor.NONE){
                    Dame.add(new ChessboardPoint((getSource().getX() - i) ,getSource().getY() ));
                }else if (getChess(this.getSource().getX() - i,this.getSource().getY()).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Dame.add(new ChessboardPoint((getSource().getX() - i),getSource().getY() ));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getX() + i > 7) {
                break;
            }else {
                if (getChess(this.getSource().getX() + i,this.getSource().getY()).getChessColor()==ChessColor.NONE){
                    Dame.add(new ChessboardPoint((getSource().getX() + i) ,getSource().getY() ));
                }else if (getChess(this.getSource().getX() + i,this.getSource().getY()).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Dame.add(new ChessboardPoint((getSource().getX() + i),getSource().getY() ));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() + i > 7 || this.getSource().getX() + i > 7) {
                break;
            }else {
                if (getChess(this.getSource().getX() + i,this.getSource().getY()+i).getChessColor()==ChessColor.NONE){
                    Dame.add(new ChessboardPoint(getSource().getX() + i,getSource().getY() + i));
                }else if (getChess(this.getSource().getX() + i,this.getSource().getY()+i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Dame.add(new ChessboardPoint(getSource().getX() + i,getSource().getY() + i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() - i < 0 || this.getSource().getX() - i < 0) {
                break;
            }else {
                if (getChess(this.getSource().getX() - i,this.getSource().getY() - i).getChessColor()==ChessColor.NONE){
                    Dame.add(new ChessboardPoint(getSource().getX() - i,getSource().getY() - i));
                }else if (getChess(this.getSource().getX() - i,this.getSource().getY() - i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Dame.add(new ChessboardPoint(getSource().getX() - i,getSource().getY() - i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() - i < 0 || this.getSource().getX() + i > 7) {
                break;
            }else {
                if (getChess(this.getSource().getX() + i,this.getSource().getY() - i).getChessColor()==ChessColor.NONE){
                    Dame.add(new ChessboardPoint(getSource().getX() + i,getSource().getY() - i));
                }else if (getChess(this.getSource().getX() + i,this.getSource().getY() - i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Dame.add(new ChessboardPoint(getSource().getX() + i,getSource().getY() - i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() + i > 7  || this.getSource().getX() - i < 0) {
                break;
            }else {
                if (getChess(this.getSource().getX() - i,this.getSource().getY() + i).getChessColor()==ChessColor.NONE){
                    Dame.add(new ChessboardPoint(getSource().getX() - i,getSource().getY() + i));
                }else if (getChess(this.getSource().getX() - i,this.getSource().getY() + i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Dame.add(new ChessboardPoint(getSource().getX() - i,getSource().getY() + i));
                    break;
                }
            }
        }
        return Dame;
    }
    public int  IsThereOtherPiece (int a,int b){
        if ((chessboard[a][b].getName() == '_' )){return 1;}
        else if(chessboard[a][b].getChessColor() == getChessColor()){
            return 2;
        }else {
            return 3;
        }
    }
}
