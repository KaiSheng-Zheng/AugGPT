import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
    }
   public ChessColor getComponentColor(char component){
        if (component=='_')return ChessColor.NONE;
        if (component>='A'&&component<='Z'){return ChessColor.BLACK;}
        else return ChessColor.WHITE;
//
    }
   public void loadChessGame(List<String> chessboard) {
       for (int i = 0; i <8 ; i++) {
           for (int j = 0; j <8 ; j++) {
               char component=chessboard.get(i).charAt(j),raw=(component=='_')?'_':(char)(component&(~32));
               switch (raw) {
                   case 'K' -> chessComponents[i][j] = new ChessComponent.KingChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                   case 'Q'->chessComponents[i][j] = new ChessComponent.QueenChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                   case'R'-> chessComponents[i][j]=new ChessComponent.RookChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                   case 'B' -> chessComponents[i][j] = new ChessComponent.BishopChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                   case 'N' -> chessComponents[i][j] = new ChessComponent.KnightChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                   case 'P' -> chessComponents[i][j] = new ChessComponent.PawnChessComponent(new ChessboardPoint(i, j), getComponentColor(component));
                  case '_' ->chessComponents[i][j]=new ChessComponent.EmptySlotComponent(new ChessboardPoint(i, j),getComponentColor(component));
               }
               currentPlayer=chessboard.get(8).charAt(0)=='b'?ChessColor.BLACK:ChessColor.WHITE;

           }
       }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }


    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
    public String getChessboardGraph(){
        StringBuilder makabaka=new StringBuilder();
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                makabaka.append(chessComponents[i][j].toString());

            } if (i<7){makabaka.append("\n");}
//            if (makabaka.length()==8){makabaka.append("\n");}
        }return makabaka.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder getChessString = new StringBuilder();
        int[] makabaka = new int[12];//black

        int[] yigubigu = new int[]{'K', 'Q', 'R', 'B', 'N', 'P', 'k', 'q', 'r', 'b', 'n', 'p'};
        int[] magebazi = new int[]{1, 1, 2, 2, 2, 8, 1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                getChessString.append(chessComponents[i][j].toString());

            }
        }
        for (int i = 0; i < getChessString.length(); i++) {

            if (getChessString.charAt(i) == 'K') {
                makabaka[0]++;
            }
            if (getChessString.charAt(i) == 'Q') {
                makabaka[1]++;
            }
            if (getChessString.charAt(i) == 'R') {
                makabaka[2]++;
            }
            if (getChessString.charAt(i) == 'B') {
                makabaka[3]++;
            }
            if (getChessString.charAt(i) == 'N') {
                makabaka[4]++;
            }
            if (getChessString.charAt(i) == 'P') {
                makabaka[5]++;
            }
            if (getChessString.charAt(i) == 'k') {
                makabaka[6]++;
            }
            if (getChessString.charAt(i) == 'q') {
                makabaka[7]++;
            }
            if (getChessString.charAt(i) == 'r') {
                makabaka[8]++;
            }
            if (getChessString.charAt(i) == 'b') {
                makabaka[9]++;
            }
            if (getChessString.charAt(i) == 'n') {
                makabaka[10]++;
            }
            if (getChessString.charAt(i) == 'p') {
                makabaka[11]++;
            }
        }
        StringBuilder str = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 6; i++) {
                if (magebazi[i] - makabaka[i] != 0) {
//
                    str.append((char) yigubigu[i]).append(" ").append(magebazi[i] - makabaka[i]).append("\n");

                }
            }
            return str.toString();
        }
        if (player== ChessColor.WHITE) {
            for (int i = 6; i < 12; i++) {
                if (magebazi[i] - makabaka[i] != 0) {
//                return String.format("%s %d\n", yigubigu[i], (magebazi[i] - yigubigu[i]));
                    str.append((char) yigubigu[i]).append(" ").append(magebazi[i] - makabaka[i]).append("\n");

                }
            }
            return str.toString();
        }
else return null;
    }


//    @Override
//    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
//        return null;
//    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].loadCurrentChessboard(chessComponents);
        if(currentPlayer!=getComponentColor(chessComponents[sourceX][sourceY].toString().charAt(0))){
            return false;
        }else {
        ArrayList<ChessboardPoint> moveto=(ArrayList<ChessboardPoint>)chessComponents[sourceX][sourceY].canMoveTo();
            ChessboardPoint makabaka=new ChessboardPoint(targetX, targetY);
        if(!moveto.contains(makabaka)){
            return false;
        }
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source=new ChessboardPoint(targetX, targetY);
        chessComponents[sourceX][sourceY]=new ChessComponent.EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);

            if (currentPlayer==ChessColor.WHITE){currentPlayer=ChessColor.BLACK;}
            else {currentPlayer=ChessColor.WHITE;}
        return true;
    }
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].loadCurrentChessboard(chessComponents);
        ArrayList<ChessboardPoint> moveto=(ArrayList<ChessboardPoint>)chessComponents[source.getX()][source.getY()].canMoveTo();
        moveto.sort(new Sort());
        return moveto;
    }
    private static class Sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint p1,ChessboardPoint p2){
//            return p1.getX()==p2.getX()?p1.getY()-p2.getY():p1.getX()-p2.getX();
            if (p1.getX()==p2.getX())return p1.getY()-p2.getY();
            else return p1.getX()-p2.getX();
        }
    }}


//

