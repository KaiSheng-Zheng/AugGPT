import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents=new ChessComponent[8][8];

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints=new ArrayList<>();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        for (int i = x,j=y; i <8|j<8 ; i++,j++) {
            if (x==7||y==7){
                break;
            }
            if (this.getSource().offset(i-x+1,j-y+1)!=null){
                if (chessComponents[i+1][j+1].getChessColor()==this.getChessColor()){
                    break;
                }
                chessboardPoints.add(new ChessboardPoint(i+1,j+1));
                if (chessComponents[i+1][j+1].getChessColor()!=ChessColor.NONE){
                    break;
                }}
        }
        for (int i = x,j=y; i <8|j>=0 ; i++,j--) {
            if (x==7||y<=0){
                break;
            }if (this.getSource().offset(i-x+1,j-y-1)!=null){
                if (chessComponents[i+1][j-1].getChessColor()==this.getChessColor()){
                    break;
                }
                chessboardPoints.add(new ChessboardPoint(i+1,j-1));
                if (chessComponents[i+1][j-1].getChessColor()!=ChessColor.NONE){
                    break;
                }}
        }
        for (int i = x,j=y; i >=0|j>=0 ; i--,j--) {
            if (x==0||y==0){
                break;
            }
            if (this.getSource().offset(i-1-x,j-1-y)!=null){
                if (chessComponents[i-1][j-1].getChessColor()==this.getChessColor()){
                    break;
                }
                chessboardPoints.add(new ChessboardPoint(i-1,j-1));
                if (chessComponents[i-1][j-1].getChessColor()!=ChessColor.NONE){
                    break;
                }}
        }
        for (int i = x,j=y; i >=0|j<8 ; i--,j++) {
            if (x==0||y==7){
                break;
            }
            if (this.getSource().offset(i-1-x,j+1-y)!=null){
                if (chessComponents[i-1][j+1].getChessColor()==this.getChessColor()){
                    break;
                }
                chessboardPoints.add(new ChessboardPoint(i-1,j+1));
                if (chessComponents[i-1][j+1].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }}


        for (int i = x+1; i <8 ; i++) {
            if (x==7){
                break;
            }
            if (chessComponents[i][y].getChessColor()==this.getChessColor()){
                break;
            }
            chessboardPoints.add(new ChessboardPoint(i,y));
            if (chessComponents[i][y].getChessColor()!=ChessColor.NONE){
                break;
            }
        }
        for (int i = x-1; i>=0 ; i--) {
            if (x==0){
                break;
            }
            if (chessComponents[i][y].getChessColor()==this.getChessColor()){
                break;
            }
            chessboardPoints.add(new ChessboardPoint(i,y));
            if (chessComponents[i][y].getChessColor()!=ChessColor.NONE){
                break;
            }
        }
        for (int i = y+1; i <8 ; i++) {
            if (y==7){
                break;
            }
            if (chessComponents[x][i].getChessColor()==this.getChessColor()){
                break;
            }
            chessboardPoints.add(new ChessboardPoint(x,i));
            if (chessComponents[x][i].getChessColor()!=ChessColor.NONE){
                break;
            }
        }
        for (int i = y-1; i >=0 ; i--) {
            if (y==0){
                break;
            }
            if (chessComponents[x][i].getChessColor()==this.getChessColor()){
                break;
            }
            chessboardPoints.add(new ChessboardPoint(x,i));
            if (chessComponents[x][i].getChessColor()!=ChessColor.NONE){
                break;
            }
        }

        return chessboardPoints;
    }
}
