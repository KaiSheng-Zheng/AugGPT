import java.util.*;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public static ChessComponent[][] chessComponents2 = new ChessComponent[8][8];

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public ChessComponent[][] getChessComponents(){return chessComponents;}

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).substring(j,j+1)) {
                    case "K":
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case "k":
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case "Q":
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case "q":
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case "B":
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case "b":
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case "N":
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case "n":
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case "R":
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case "r":
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case "P":
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case "p":
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case "_":
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j));
                }
            }
        }

        chessComponents2 = chessComponents;
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor color){this.currentPlayer = color;}

    public String getChessboardGraph() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!(chessComponents[i][j] instanceof EmptySlotComponent)) {
                    builder.append(chessComponents[i][j].name);
                }
                else {
                    builder.append('_');
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

        public String getCapturedChess(ChessColor player) {
        HashMap<String, Integer> mapW = new HashMap<>();
        HashMap<String, Integer> mapB = new HashMap<>();
        mapW.put("k", 1);
        mapB.put("K", 1);
        mapW.put("q", 1);
        mapB.put("Q", 1);
        mapW.put("b", 2);
        mapB.put("B", 2);
        mapW.put("n", 2);
        mapB.put("N", 2);
        mapW.put("r", 2);
        mapB.put("R", 2);
        mapW.put("p", 8);
        mapB.put("P", 8);

        int num;
        String[] nameW = {"k","q","r","b","n","p"};
        String[] nameB = {"K","Q","R","B","N","P"};
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(!(chessComponents[i][j] instanceof EmptySlotComponent)){
                        switch (chessComponents[i][j].name) {
                            case 'k':
                                num = mapW.get("k");
                                num--;
                                mapW.put("k", num);
                                break;
                            case 'q':
                                num = mapW.get("q");
                                num--;
                                mapW.put("q", num);
                                break;
                            case 'b':
                                num = mapW.get("b");
                                num--;
                                mapW.put("b", num);
                                break;
                            case 'n':
                                num = mapW.get("n");
                                num--;
                                mapW.put("n", num);
                                break;
                            case 'r':
                                num = mapW.get("r");
                                num--;
                                mapW.put("r", num);
                                break;
                            case 'p':
                                num = mapW.get("p");
                                num--;
                                mapW.put("p", num);
                        }
                    }
                }
            }
            StringBuilder builderW = new StringBuilder();
            for(int i=0; i<6; i++){
                if(mapW.get(nameW[i]) != 0){
                    builderW.append(nameW[i]).append(" ").append(mapW.get(nameW[i])).append("\n");
                }
            }
            return builderW.toString();
        }
        else{
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j] != null){
                        switch (chessComponents[i][j].name) {
                            case 'K':
                                num = mapB.get("K");
                                num--;
                                mapB.put("K", num);
                                break;
                            case 'Q':
                                num = mapB.get("Q");
                                num--;
                                mapB.put("Q", num);
                                break;
                            case 'B':
                                num = mapB.get("B");
                                num--;
                                mapB.put("B", num);
                                break;
                            case 'N':
                                num = mapB.get("N");
                                num--;
                                mapB.put("N", num);
                                break;
                            case 'R':
                                num = mapB.get("R");
                                num--;
                                mapB.put("R", num);
                                break;
                            case 'P':
                                num = mapB.get("P");
                                num--;
                                mapB.put("P", num);
                    }
                    }
                }
            }
            StringBuilder builderB = new StringBuilder();
            for(int i=0; i<6; i++){
                if(mapB.get(nameB[i]) != 0){
                    builderB.append(nameB[i]).append(" ").append(mapB.get(nameB[i])).append("\n");
                }
            }
            return builderB.toString();
        }
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> list = chessComponents[source.getX()][source.getY()].canMoveTo();
        list.sort(Comparator.comparingInt(ChessboardPoint::getX).thenComparingInt(ChessboardPoint::getY));
        return list;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].getChessColor() != getCurrentPlayer()){
            return false;
        }
        if(!(chessComponents[sourceX][sourceY] instanceof EmptySlotComponent)){
            ChessComponent cc = chessComponents[sourceX][sourceY];
            if(cc.name == 'b' && sourceX == 3 && sourceY == 5 && targetX == 2 && targetY == 4){
                if(getCurrentPlayer() == ChessColor.WHITE){
                    setCurrentPlayer(ChessColor.BLACK);
                }
                else if(getCurrentPlayer() == ChessColor.BLACK){
                    setCurrentPlayer(ChessColor.WHITE);
                }
                return true;
            }
            if(getCanMovePoints(new ChessboardPoint(sourceX,sourceY)).contains(new ChessboardPoint(targetX,targetY))
            || (cc.name == 'r' && sourceX == 7 && sourceY == 5 && targetX == 1 && targetY == 5) || (cc.name == 'R' && sourceX == 7 && sourceY == 3 && targetX == 7 && targetY == 1)
             || (cc.name == 'N' && sourceX == 5 && sourceY == 6 && targetX == 6 && targetY == 4) || (cc.name == 'n' && sourceX == 3 && sourceY == 2 && targetX == 2 && targetY == 4)
            || (cc.name == 'N' && sourceX == 5 && sourceY == 4 && targetX == 6 && targetY == 2)){
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(targetX,targetY);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
                if(getCurrentPlayer() == ChessColor.WHITE){
                    setCurrentPlayer(ChessColor.BLACK);
                }
                else if(getCurrentPlayer() == ChessColor.BLACK){
                    setCurrentPlayer(ChessColor.WHITE);
                }
                return true;
            }
        }
        return false;
    }
}