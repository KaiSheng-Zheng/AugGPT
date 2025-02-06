import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

        public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
            super(source,chessColor);
            if (chessColor == ChessColor.BLACK){
                this.name = 'N';}
            else if (chessColor == ChessColor.WHITE){
                this.name = 'n';}
        }

        private final int[][] Move=new int[][]{{-2,-1},{-1,2},{-2,1},{1,2},{2,-1},{1,-2},{2,1},{-1,-2}};

        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
            for(int t = 0 ; t<8 ; t++){
                ChessboardPoint newPlace = getSource().offset(Move[t][0],Move[t][1]);
                if(newPlace != null && getComponentColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0)) != getChessColor()){
                    moveTo.add(newPlace);
                }
            }
            return moveTo;
        }

}

