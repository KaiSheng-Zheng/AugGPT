import java.util.ArrayList;

public class IfFriendsHere {
    public static boolean thereAreFriend(int x,int y,ChessColor chessColor) {
        boolean answer = false;
//        System.out.print(x);
//        System.out.print(y);
//        System.out.println();
//        System.out.println(ConcreteChessGame.chessComponents[x][y].chessColor);
//        System.out.println(ConcreteChessGame.chessComponents[x][y]);
        if(ConcreteChessGame.CopyOne[x][y].chessColor==chessColor){
            answer=true;

        }else {
            answer=false;
        }
//        if(chessColor==ChessColor.WHITE){
//            for(int i=0;i<ConcreteChessGame.WhiteChess.size();i++){
//                if(ConcreteChessGame.WhiteChess.get(i).source.equals(new ChessboardPoint(x,y))){
//                    answer=true;
//                }
//            }
//        }
//        if(chessColor==ChessColor.BLACK){
//            for(int i=0;i<ConcreteChessGame.BlackChess.size();i++){
//                if(ConcreteChessGame.BlackChess.get(i).source.equals(new ChessboardPoint(x,y))){
//                    answer=true;
//                }
//            }
//        }
        return answer;
        }

}
