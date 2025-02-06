import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color


    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.source = super.getSource();
        this.chessColor = super.getChessColor();
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<ChessboardPoint>();

        if (inComponent(source.getX()+1,source.getY()+2)){
            ChessComponent chessComponent = chessBoard[source.getX()+1][source.getY()+2];
            if (differ(chessComponent.getChessColor())){
                canmove.add(chessComponent.getSource());
            }
        }
        if (inComponent(source.getX()-1,source.getY()+2)){
            ChessComponent chessComponent = chessBoard[source.getX()-1][source.getY()+2];
            if (differ(chessComponent.getChessColor())){
                canmove.add(chessComponent.getSource());
            }
        } if (inComponent(source.getX()+2,source.getY()+1)){
            ChessComponent chessComponent = chessBoard[source.getX()+2][source.getY()+1];
            if (differ(chessComponent.getChessColor())){
                canmove.add(chessComponent.getSource());
            }
        } if (inComponent(source.getX()-2,source.getY()+1)){
            ChessComponent chessComponent = chessBoard[source.getX()-2][source.getY()+1];
            if (differ(chessComponent.getChessColor())){
                canmove.add(chessComponent.getSource());
            }
        }  if (inComponent(source.getX()-2,source.getY()-1)){
            ChessComponent chessComponent = chessBoard[source.getX()-2][source.getY()-1];
            if (differ(chessComponent.getChessColor())){
                canmove.add(chessComponent.getSource());
            }
        } if (inComponent(source.getX()+2,source.getY()-1)){
            ChessComponent chessComponent = chessBoard[source.getX()+2][source.getY()-1];
            if (differ(chessComponent.getChessColor())){
                canmove.add(chessComponent.getSource());
            }
        } if (inComponent(source.getX()-1,source.getY()-2)){
            ChessComponent chessComponent = chessBoard[source.getX()-1][source.getY()-2];
            if (differ(chessComponent.getChessColor())){
                canmove.add(chessComponent.getSource());
            }
        } if (inComponent(source.getX()+1,source.getY()-2)){
            ChessComponent chessComponent = chessBoard[source.getX()+1][source.getY()-2];
            if (differ(chessComponent.getChessColor())){
                canmove.add(chessComponent.getSource());
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
