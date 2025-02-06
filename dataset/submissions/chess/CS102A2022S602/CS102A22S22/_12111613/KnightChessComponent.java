import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public ConcreteChessGame concreteChessGame;

    public KnightChessComponent(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<String> chessboard = concreteChessGame.getCurrentchessboard();
        System.out.println(chessboard.get(4).charAt(1));

        List<ChessboardPoint> rightLocation =new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if ((Math.abs(i-super.source.getX())==1&&Math.abs(j-super.source.getY())==2)
                        ||(Math.abs(i-super.source.getX())==2&&Math.abs(j-super.source.getY())==1)){
                    if (chessboard.get(i).charAt(j)=='_'){
                    rightLocation.add(new ChessboardPoint(i,j));
                    }
                    else if (super.chessColor==ChessColor.WHITE&&Character.isUpperCase(chessboard.get(i).charAt(j))){
                        rightLocation.add(new ChessboardPoint(i,j));
                    }else if (super.chessColor==ChessColor.BLACK&&Character.isLowerCase(chessboard.get(i).charAt(j))){
                        rightLocation.add(new ChessboardPoint(i,j));
                    }

                }
            }
        }
        return rightLocation;
    }
}
