import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public ConcreteChessGame concreteChessGame;


    public PawnChessComponent(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<String> chessboard = concreteChessGame.getCurrentchessboard();
        List<ChessboardPoint> rightLocation = new ArrayList<>();

        if (chessColor==ChessColor.WHITE){
            if (source.getX()>0&&source.getX()<=6){

                if (source.getX()==6){
                    if (chessboard.get(source.getX()-1).charAt(source.getY())=='_' &&chessboard.get(source.getX()-2).charAt(source.getY())=='_'){
                        rightLocation.add(new ChessboardPoint(4,source.getY()));}
                }
                if (source.getY()>0&&Character.isUpperCase(chessboard.get(source.getX()-1).charAt(source.getY()-1))){
                    rightLocation.add(new ChessboardPoint(source.getX()-1,source.getY()-1));
                }
                if (chessboard.get(source.getX()-1).charAt(source.getY())=='_'){
                rightLocation.add(new ChessboardPoint(source.getX()-1,source.getY()));}

                    if (Character.isUpperCase(chessboard.get(source.getX()-1).charAt(source.getY()+1))){
                        rightLocation.add(new ChessboardPoint(source.getX()-1,source.getY()+1));
                    }
            }
        }
        if (chessColor==ChessColor.BLACK){
            if (source.getX()>0&&source.getX()<=7){
                if (source.getY()>0&&Character.isLowerCase(chessboard.get(source.getX()+1).charAt(source.getY()-1))){
                    rightLocation.add(new ChessboardPoint(source.getX()+1,source.getY()-1));
                }
                if (chessboard.get(source.getX()+1).charAt(source.getY())=='_'){
                    rightLocation.add(new ChessboardPoint(source.getX()+1,source.getY()));}

                if (Character.isLowerCase(chessboard.get(source.getX()+1).charAt(source.getY()+1))){
                    rightLocation.add(new ChessboardPoint(source.getX()+1,source.getY()+1));
                }
                if (source.getX()==1){
                    if (chessboard.get(source.getX()+1).charAt(source.getY())=='_' &&chessboard.get(source.getX()+2).charAt(source.getY())=='_'){
                        rightLocation.add(new ChessboardPoint(3,source.getY()));}
                }
            }
        }
        return rightLocation;
    }
}
