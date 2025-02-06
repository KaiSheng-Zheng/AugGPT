import java.lang.invoke.ConstantBootstraps;
import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {

    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessboardPoint chessboardPoint;
    private ChessColor chessColor;
    protected QueenChessComponent(char name,ChessColor chessColor,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents1) {
        this.name=name;
        this.chessColor=chessColor;
        this.chessboardPoint=chessboardPoint;
        this.chessComponents=chessComponents1;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> target = new ArrayList<>();
        for(int i= -7;i< 8 ;i++){
            if(chessComponents[chessboardPoint.getX()+i][chessboardPoint.getY()+i].getChessColor()!=chessColor) {
                target.add(chessboardPoint.offset(i, i));
            }if(chessComponents[chessboardPoint.getX()+i][chessboardPoint.getY()-i].getChessColor()!=chessColor) {
                target.add(chessboardPoint.offset(i, -i));
            }
            for(int k=chessboardPoint.getX()-8;k<=8- chessboardPoint.getX();k++){
                if(chessComponents[chessboardPoint.getX()+i][chessboardPoint.getY()].getChessColor()!=chessColor) {
                    target.add(chessboardPoint.offset(i, 0));
                }
            }
            for(int j=chessboardPoint.getY()-8;j<=8- chessboardPoint.getY();j++){
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()+j].getChessColor()!=chessColor)
                    target.add(chessboardPoint.offset(0,j));
            }
        }return target;
    }

}
