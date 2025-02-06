import java.util.ArrayList;

public class IfEnemyHere {
    public static boolean thereAreEnemy(int x,int y,ChessColor chessColor) {
        boolean answer = false;
        ChessColor chessColor1=ChessColor.NONE;
        if(chessColor==ChessColor.WHITE){
            chessColor1=ChessColor.BLACK;
        }else if(chessColor==ChessColor.BLACK){
            chessColor1=ChessColor.WHITE;
        }
//        if(chessColor==ChessColor.WHITE){
//            for(int i=0;i<ConcreteChessGame.BlackChess.size();i++){
//                if(ConcreteChessGame.BlackChess.get(i).source.equals(new ChessboardPoint(x,y))){
//                    answer=true;
//                }
//            }
//        }
//        if(chessColor==ChessColor.BLACK){
//            for(int i=0;i<ConcreteChessGame.WhiteChess.size();i++){
//                if(ConcreteChessGame.WhiteChess.get(i).source.equals(new ChessboardPoint(x,y))){
//                    answer=true;
//                }
//            }
//        }
////
        if(ConcreteChessGame.CopyOne[x][y].chessColor==chessColor1){
            answer=true;
        }else {
            answer=false;
        }
        return answer;
    }

}


