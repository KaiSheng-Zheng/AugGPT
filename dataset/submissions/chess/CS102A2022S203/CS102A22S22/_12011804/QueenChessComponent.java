import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name


    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.source = super.getSource();
        this.chessColor = super.getChessColor();
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {


        List<ChessboardPoint> canmove = new ArrayList<ChessboardPoint>();

        for (int i = 1; i < 8; i++) {
            if (inComponent(source.getX()+i,source.getY()+i)){
                ChessComponent chessComponent = chessBoard[source.getX()+i][source.getY()+i];
                if (differ(chessComponent.getChessColor())){
                    canmove.add(chessComponent.getSource());
                    if (chessComponent.getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }else {
                    break;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (inComponent(source.getX()-i,source.getY()+i)){
                ChessComponent chessComponent = chessBoard[source.getX()-i][source.getY()+i];
                if (differ(chessComponent.getChessColor())){
                    canmove.add(chessComponent.getSource());
                    if (chessComponent.getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }else {
                    break;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (inComponent(source.getX()+i,source.getY()-i)){
                ChessComponent chessComponent = chessBoard[source.getX()+i][source.getY()-i];
                if (differ(chessComponent.getChessColor())){
                    canmove.add(chessComponent.getSource());
                    if (chessComponent.getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }else {
                    break;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (inComponent(source.getX()-i,source.getY()-i)){
                ChessComponent chessComponent = chessBoard[source.getX()-i][source.getY()-i];
                if (differ(chessComponent.getChessColor())){
                    canmove.add(chessComponent.getSource());
                    if (chessComponent.getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }else {
                    break;
                }
            }else {
                break;
            }
        }


        for (int i = 1; i < 8; i++) {
            if (inComponent(source.getX()+i,source.getY())){
                ChessComponent chessComponent = chessBoard[source.getX()+i][source.getY()];
                if (differ(chessComponent.getChessColor())){
                    canmove.add(chessComponent.getSource());
                    if (chessComponent.getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }else {
                    break;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (inComponent(source.getX(),source.getY()+i)){
                ChessComponent chessComponent = chessBoard[source.getX()][source.getY()+i];
                if (differ(chessComponent.getChessColor())){
                    canmove.add(chessComponent.getSource());
                    if (chessComponent.getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }else {
                    break;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (inComponent(source.getX()-i,source.getY())){
                ChessComponent chessComponent = chessBoard[source.getX()-i][source.getY()];
                if (differ(chessComponent.getChessColor())){
                    canmove.add(chessComponent.getSource());
                    if (chessComponent.getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }else {
                    break;
                }
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (inComponent(source.getX(),source.getY()-i)){
                ChessComponent chessComponent = chessBoard[source.getX()][source.getY()-i];
                if (differ(chessComponent.getChessColor())){
                    canmove.add(chessComponent.getSource());
                    if (chessComponent.getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }else {
                    break;
                }
            }else {
                break;
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
