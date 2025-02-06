import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public ConcreteChessGame concreteChessGame;


    public RookChessComponent(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<String> chessboard = concreteChessGame.getCurrentchessboard();

        List<ChessboardPoint> rightLocation = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((source.getX()-i)*(source.getY()-j)==0 && !(source.getX()==i &&source.getY()==j)){
                    boolean can=true;
                    if (source.getY()==j){
                        int startX=Math.min(source.getX(),i);
                        int endX=Math.max(source.getX(),i);
                        int dx=Math.abs(source.getX()-i);
                        for (int col=1;col<dx;col++){
                            if (chessboard.get(startX+col).charAt(j) != '_') {
                                can = false;
                                break;
                            }
                        }
                    }
                    if (source.getX()==i){
                        int startY=Math.min(source.getY(),j);
                        int endY=Math.max(source.getY(),j);
                        int dy=Math.abs(source.getY()-j);
                        for(int col=1;col<dy;col++){
                            if (chessboard.get(i).charAt(startY + col) != '_') {
                                can = false;
                                break;
                            }
                        }
                    }
                    if (super.chessColor==ChessColor.WHITE&&Character.isLowerCase(chessboard.get(i).charAt(j))){
                        can=false;
                    }
                    if (super.chessColor==ChessColor.BLACK&&Character.isUpperCase(chessboard.get(i).charAt(j))){
                        can=false;
                    }
                    if (can){
                        rightLocation.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }

        return rightLocation;
    }
}
