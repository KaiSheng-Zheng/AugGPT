import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        List<ChessboardPoint> can = new ArrayList<>();
        if (source.getX() >= 0 && source.getX() < 8 && source.getY() >= 0 && source.getY() < 8) {
            if (source.getX()-2>=0&&source.getY()-1>=0){
            if (chessboard[source.getX()-2][source.getY()-1].chessColor!=getChessColor()){
                ChessboardPoint destination1 = new ChessboardPoint(source.getX()-2,source.getY()-1) ;
                can.add(destination1);
            }}
            if (source.getX()-2>=0&&source.getY()+1<8){
            if (chessboard[source.getX()-2][source.getY()+1].chessColor!=getChessColor()){
                ChessboardPoint destination2 = new ChessboardPoint(source.getX()-2,source.getY()+1) ;
                can.add(destination2);
            }}
            if (source.getX()+2<8&&source.getY()-1>=0){
                if (chessboard[source.getX()+2][source.getY()-1].chessColor!=getChessColor()){
                    ChessboardPoint destination3 = new ChessboardPoint(source.getX()+2,source.getY()-1) ;
                    can.add(destination3);
                }
            }
            if (source.getX()+2<8&&source.getY()+1<8){
                if (chessboard[source.getX()+2][source.getY()+1].chessColor!=getChessColor()){
                    ChessboardPoint destination4 = new ChessboardPoint(source.getX()+2,source.getY()+1) ;
                    can.add(destination4);
                }
            }
            if (source.getX()-1>=0&&source.getY()-2>=0){
                if (chessboard[source.getX()-1][source.getY()-2].chessColor!=getChessColor()){
                    ChessboardPoint destination5 = new ChessboardPoint(source.getX()-1,source.getY()-2) ;
                    can.add(destination5);
                }
            }
            if (source.getX()-1>=0&&source.getY()+2<8){
                if (chessboard[source.getX()-1][source.getY()+2].chessColor!=getChessColor()){
                    ChessboardPoint destination6 = new ChessboardPoint(source.getX()-1,source.getY()+2) ;
                    can.add(destination6);
                }
            }
            if (source.getX()+1<8&&source.getY()-2>0){
                if (chessboard[source.getX()+1][source.getY()-2].chessColor!=getChessColor()){
                    ChessboardPoint destination7= new ChessboardPoint(source.getX()+1,source.getY()-2) ;
                    can.add(destination7);
                }
            }
            if (source.getX()+1<8&&source.getY()+2<8){
                if (chessboard[source.getX()+1][source.getY()+2].chessColor!=getChessColor()){
                    ChessboardPoint destination8= new ChessboardPoint(source.getX()+1,source.getY()+2) ;
                    can.add(destination8);
                }
            }

        }
        if (can!=null) {
            return can;
        }else {
            return new ArrayList<>();
        }
    }
}
