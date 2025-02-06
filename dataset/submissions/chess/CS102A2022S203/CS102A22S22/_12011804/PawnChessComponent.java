import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.source = super.getSource();
        this.chessColor = super.getChessColor();
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<ChessboardPoint>();

        if (chessColor==ChessColor.BLACK){
            if (source.getX()==1){
                for (int i = 1; i < 3; i++) {
                    ChessComponent chessComponent = chessBoard[source.getX()+i][source.getY()];
                    if (differ(chessComponent.getChessColor())){
                        if (chessComponent.getChessColor()!=ChessColor.NONE){
                            break;
                        }canmove.add(chessComponent.getSource());
                    }
                }

            }else {
                ChessComponent chessComponent = chessBoard[source.getX()+1][source.getY()];
                if (chessComponent.getChessColor()==ChessColor.NONE){
                    canmove.add(chessComponent.getSource());
                }
            }
            if (inComponent(source.getX()+1,source.getY()-1)){
                ChessComponent chessComponent1 = chessBoard[source.getX()+1][source.getY()-1];
                if (chessComponent1.getChessColor()==ChessColor.WHITE){
                    canmove.add(chessComponent1.getSource());
                }
            }

            if (inComponent(source.getX()+1,source.getY()+1)){
                ChessComponent chessComponent2 = chessBoard[source.getX()+1][source.getY()+1];
                if (chessComponent2.getChessColor()==ChessColor.WHITE){
                    canmove.add(chessComponent2.getSource());
                }
            }

        }else if (chessColor==ChessColor.WHITE){
            if (source.getX()==6){
                for (int i = 1; i < 3; i++) {
                    ChessComponent chessComponent = chessBoard[source.getX()-i][source.getY()];
                    if (differ(chessComponent.getChessColor())){
                        if (chessComponent.getChessColor()!=ChessColor.NONE){
                            break;
                        }canmove.add(chessComponent.getSource());
                    }
                }

            }else {
                ChessComponent chessComponent = chessBoard[source.getX()-1][source.getY()];
                if (chessComponent.getChessColor()==ChessColor.NONE){
                    canmove.add(chessComponent.getSource());
                }
            }
            if (inComponent(source.getX()-1,source.getY()-1)){
                ChessComponent chessComponent1 = chessBoard[source.getX()-1][source.getY()-1];
                if (chessComponent1.getChessColor()==ChessColor.BLACK){
                    canmove.add(chessComponent1.getSource());
                }
            }
            if (inComponent(source.getX()-1,source.getY()+1)){
                ChessComponent chessComponent2 = chessBoard[source.getX()-1][source.getY()+1];
                if (chessComponent2.getChessColor()==ChessColor.BLACK){
                    canmove.add(chessComponent2.getSource());
                }
            }

        }

        for (int i = 0; i < canmove.size()-1; i++) {
            for (int j = 0; j < canmove.size()-1; j++) {
                if(canmove.get(j).getX()>canmove.get(j+1).getX())
                {
                    ChessboardPoint temp=canmove.get(j);
                    canmove.set(j,canmove.get(j+1)) ;
                    canmove.set(j+1,temp);
                }if (canmove.get(j).getY()>canmove.get(j+1).getY()&&canmove.get(j).getX()==canmove.get(j+1).getX()){
                    ChessboardPoint temp=canmove.get(j);
                    canmove.set(j,canmove.get(j+1)) ;
                    canmove.set(j+1,temp);
                }

            }
        }
        return canmove;
    }

    public boolean differ (ChessColor chessColor_1){
        return chessColor_1 != chessColor;
    }

    public boolean inComponent (int x , int y){
        return x >= 0 && y >= 0 && x < 8 && y < 8;
    }
}
