import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        String[] row = new String[8];
        for (int i = 0; i < 8; i++) {
            row = chessboard.get(i).split("");
            for (int j = 0; j < 8; j++) {
                switch (row[j]) {
                    case "R" ->
                            chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    case "r" ->
                            chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);
                    case "N" ->
                            chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    case "n" ->
                            chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);
                    case "B" ->
                            chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    case "b" ->
                            chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);
                    case "Q" ->
                            chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    case "q" ->
                            chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);
                    case "K" ->
                            chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    case "k" ->
                            chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);
                    case "P" ->
                            chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    case "p" ->
                            chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);
                    case "_" ->
                            chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(i, j), chessComponents);
                }

            }
        }

        if(Objects.equals(chessboard.get(8), "b")){
            currentPlayer = ChessColor.BLACK;
        }if(Objects.equals(chessboard.get(8), "w")){
            currentPlayer = ChessColor.WHITE;
        }


    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;

    }

    @Override
    public String getChessboardGraph(){

         String A="";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8 ; j++) {
                A=A.concat(chessComponents[i][j].toString());
            }
            A=A.concat("\n");
        }
         return A;

    }

    @Override
    public String getCapturedChess(ChessColor player){
       int []counts= {1,1,2,2,2,8};
       char[] Black = {'K','Q','R','B','N','P'};
        char[] White = {'k','q','r','b','n','p'};

        char[] now;
        if(player.equals(ChessColor.WHITE)){
            now=White;
        }else{
            now = Black;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 6; k++) {
                    if(chessComponents[i][j].getName()== now[k]){
                        counts[k]=counts[k]-1;
                    }
                }

            }

        }

        String answer = "";
        for (int i = 0; i < 6; i++) {
            if(counts[i]==0){

            }else{
                answer= answer.concat(now[i]+" "+counts[i]+"\n");
            }
        }
        return answer;


    }



    @Override
    public ChessComponent getChess(int x, int y){

        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }



//    @Override
//    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY)
//    {
//        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
//            return false;
//        }
//
//
//        List<ChessboardPoint> canmovepoints;
//        ChessboardPoint A = new ChessboardPoint(sourceX,sourceY);
//        canmovepoints = chessComponents[sourceX][sourceY].canMoveTo();
//        for (ChessboardPoint canmovepoint : canmovepoints) {
//            if (targetX == canmovepoint.getX() && targetY == canmovepoint.getY()) {
//                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
//                EmptySlotComponent empty = new EmptySlotComponent(ChessColor.NONE, A, chessComponents);
//                chessComponents[sourceX][sourceY] = empty;
//
//                if(currentPlayer == ChessColor.BLACK) {
//                    currentPlayer = ChessColor.WHITE;
//                    return true;
//                } else {
//                    currentPlayer = ChessColor.BLACK;
//                    return true;
//                }
//            }
//        }
//
//
//return true;
//    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY)
    {
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            return false;
        }
        List<ChessboardPoint> canmovepoints;
        ChessboardPoint A = new ChessboardPoint(sourceX,sourceY);
        canmovepoints = chessComponents[sourceX][sourceY].canMoveTo();
        for (ChessboardPoint canmovepoint : canmovepoints) {
            if (targetX == canmovepoint.getX() && targetY == canmovepoint.getY()) {

                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                EmptySlotComponent empty = new EmptySlotComponent(ChessColor.NONE, A, chessComponents);
                chessComponents[sourceX][sourceY] = empty;


                if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                    return true;
                } else {
                    currentPlayer = ChessColor.BLACK;
                    return true;
                }
            }
        }
        return false;
    }
}


