import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public ConcreteChessGame concreteChessGame;


    public KingChessComponent(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<String> chessboard = concreteChessGame.getCurrentchessboard();

        List<ChessboardPoint> rightLocation = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(source.getX()-i)==0 ||Math.abs(source.getX()-i)==1)
                && (Math.abs(source.getY()-j)==0 ||Math.abs(source.getY()-j)==1)){
                    boolean can=true;
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

