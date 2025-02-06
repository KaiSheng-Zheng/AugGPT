import javax.net.ssl.SSLContext;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char name,ChessColor color,ChessboardPoint source){
        super(name,color,source);


    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
                List<ChessboardPoint> chessboardPoints=new ArrayList<>();
        List<String> chessComponents=this.concreteChessGame.getChessBoard();
        int y= getSource().getX();
        int x= getSource().getY();
        char a=chessComponents.get(y).charAt(x);
        ChessboardPoint chessboardPoint=new ChessboardPoint(y,x);
        chessboardPoints.add(chessboardPoint);
        return chessboardPoints;
    }
}
