

import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

        public KnightChessComponent(int x, int y, ChessColor color,ConcreteChessGame concreteChessGame) {
        super(x, y, color,concreteChessGame);
    }


    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints= new ArrayList<ChessboardPoint>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent e= belonging.getChessComponents()[i][j];
                if (this.move(belonging.getChessComponents(),e.getChessboardPoint()))chessboardPoints.add(e.getChessboardPoint());
            }

        }
        return chessboardPoints;
    }

    public boolean move(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        if (chessComponents[destination.getX()][destination.getY()].getChessColor()==this.getChessColor())return false;

        if (destination.getX()>8||destination.getX()<0)return false;
        if (destination.getY()>8||destination.getY()<0)return false;
        int rowD=Math.abs(this.getChessboardPoint().getX()-destination.getX());
        int colD=Math.abs(this.getChessboardPoint().getY()-destination.getY());
        return  ((rowD==1&&colD==2)||(rowD==2&&colD==1));

    }
}
