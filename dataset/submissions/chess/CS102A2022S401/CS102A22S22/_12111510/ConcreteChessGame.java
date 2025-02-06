import java.awt.*;
import java.util.*;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    List<String> chessboard = new ArrayList<>();
    String[][] chessPlace = new String[8][8];
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!currentPlayer.equals(chessComponents[sourceX][sourceY].chessColor)) {
            return false;
        }
        //            ArrayList<ChessboardPoint> moveTo = (ArrayList<ChessboardPoint>) chessComponents[sourceX][sourceY].canMoveTo();
        List<ChessboardPoint> moveTo = getCanMovePoints(chessComponents[sourceX][sourceY].getSource());
        if (moveTo.contains(new ChessboardPoint(targetX, targetY))) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');

            chessPlace[sourceX][sourceY] = "";
            chessPlace[targetX][targetY] = chessComponents[targetX][targetY].name + "";
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessComponents[i][j].setChessBoard(chessComponents);
                }
            }
            if (getCurrentPlayer() .equals( ChessColor.BLACK) ){
                currentPlayer = ChessColor.WHITE;
            } else {
                currentPlayer = ChessColor.BLACK;
            }


        return true;

    }
        return false;

}


    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;//input]
        if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
//        if (chessboard.get(8).charAt(0) == 'w') {
//            currentPlayer = ChessColor.WHITE;
//        } else {
//            currentPlayer = ChessColor.BLACK;
//        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessPlace[i][j] = chessboard.get(i).charAt(j) + "";
            }
        }
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (chessPlace[x][y].charAt(0) >= 'A' && chessPlace[x][y].charAt(0) <= 'Z') {
                    if (chessPlace[x][y].equals("B")) {
                        chessComponents[x][y] = new BishopChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'B');
                    }
                    if (chessPlace[x][y].equals("R")) {
                        chessComponents[x][y] = new RookChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'R');
                    }
                    if (chessPlace[x][y].equals("N")) {
                        chessComponents[x][y] = new KnightChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'N');
                    }
                    if (chessPlace[x][y].equals("K")) {
                        chessComponents[x][y] = new KingChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'K');
                    }
                    if (chessPlace[x][y].equals("Q")) {
                        chessComponents[x][y] = new QueenChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'Q');
                    }
                    if (chessPlace[x][y].equals("P")) {
                        chessComponents[x][y] = new PawnChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'P');
                    }
                } else if (chessPlace[x][y].charAt(0) >= 'a' && chessPlace[x][y].charAt(0) <= 'z') {
                    if (chessPlace[x][y].equals("b")) {
                        chessComponents[x][y] = new BishopChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'b');
                    }
                    if (chessPlace[x][y].equals("r")) {
                        chessComponents[x][y] = new RookChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'r');
                    }
                    if (chessPlace[x][y].equals("n")) {
                        chessComponents[x][y] = new KnightChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'n');
                    }
                    if (chessPlace[x][y].equals("k")) {
                        chessComponents[x][y] = new KingChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'k');
                    }
                    if (chessPlace[x][y].equals("q")) {
                        chessComponents[x][y] = new QueenChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'q');
                    }
                    if (chessPlace[x][y].equals("p")) {
                        chessComponents[x][y] = new PawnChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'p');
                    }
                } else chessComponents[x][y] = new EmptySlotComponent(new ChessboardPoint(x, y), ChessColor.WHITE, '_');
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessBoard(chessComponents);
            }
        }
    }

    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public ChessComponent getChess(int x, int y) {

        if (chessPlace[x][y].charAt(0) >= 'A' && chessPlace[x][y].charAt(0) <= 'Z') {
            if (chessPlace[x][y].equals("B")) {
                chessComponents[x][y] = new BishopChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'B');
            }
            if (chessPlace[x][y].equals("R")) {
                chessComponents[x][y] = new RookChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'R');
            }
            if (chessPlace[x][y].equals("N")) {
                chessComponents[x][y] = new KnightChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'N');
            }
            if (chessPlace[x][y].equals("K")) {
                chessComponents[x][y] = new KingChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'K');
            }
            if (chessPlace[x][y].equals("Q")) {
                chessComponents[x][y] = new QueenChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'Q');
            }
            if (chessPlace[x][y].equals("P")) {
                chessComponents[x][y] = new PawnChessComponent(new ChessboardPoint(x, y), ChessColor.BLACK, 'P');
            }
        } else if (chessPlace[x][y].charAt(0) >= 'a' && chessPlace[x][y].charAt(0) <= 'z') {
            if (chessPlace[x][y].equals("b")) {
                chessComponents[x][y] = new BishopChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'b');
            }
            if (chessPlace[x][y].equals("r")) {
                chessComponents[x][y] = new RookChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'r');
            }
            if (chessPlace[x][y].equals("n")) {
                chessComponents[x][y] = new KnightChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'n');
            }
            if (chessPlace[x][y].equals("k")) {
                chessComponents[x][y] = new KingChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'k');
            }
            if (chessPlace[x][y].equals("q")) {
                chessComponents[x][y] = new QueenChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'q');
            }
            if (chessPlace[x][y].equals("p")) {
                chessComponents[x][y] = new PawnChessComponent(new ChessboardPoint(x, y), ChessColor.WHITE, 'p');
            }
        } else chessComponents[x][y] = new EmptySlotComponent(new ChessboardPoint(x, y), ChessColor.WHITE, '_');
        chessComponents[x][y].setChessBoard(chessComponents);
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        String ChessboardGraph = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardGraph = ChessboardGraph + chessPlace[i][j];
            }
            if (i != 7) ChessboardGraph = ChessboardGraph + "\n";
        }
        return ChessboardGraph;
    }

    public String getCapturedChess(ChessColor player) {
        String CapturedChess = "";
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("K", 1);//KING
        map1.put("Q", 1);//QUEEN
        map1.put("R", 2);//ROOKS
        map1.put("B", 2);//BISHOPS
        map1.put("N", 2);//KNIGHT
        map1.put("P", 8);//PAWNS
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();

        map2.put("k", 1);//KING
        map2.put("q", 1);//QUEEN
        map2.put("r", 2);//ROOKS
        map2.put("b", 2);//BISHOPS
        map2.put("n", 2);//KNIGHT
        map2.put("p", 8);//PAWNS
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Set<String> set1 = map1.keySet();
                    Iterator<String> iterator = set1.iterator();
                    while (iterator.hasNext()) {
                        String key = iterator.next();
                        if (key.equals(chessPlace[i][j])) {//key is the String
                            int k = map1.get(key);
                            map1.replace(key, k - 1);
                        }
                    }
                }
            }
            if (map1.get("K") != 0) CapturedChess = CapturedChess + "K" + " " + map1.get("K") + "\n";
            if (map1.get("Q") != 0) CapturedChess = CapturedChess + "Q" + " " + map1.get("Q") + "\n";
            if (map1.get("R") != 0) CapturedChess = CapturedChess + "R" + " " + map1.get("R") + "\n";
            if (map1.get("B") != 0) CapturedChess = CapturedChess + "B" + " " + map1.get("B") + "\n";
            if (map1.get("N") != 0) CapturedChess = CapturedChess + "N" + " " + map1.get("N") + "\n";
            if (map1.get("P") != 0) CapturedChess = CapturedChess + "P" + " " + map1.get("P");

        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Set<String> set1 = map2.keySet();
                    Iterator<String> iterator = set1.iterator();
                    while (iterator.hasNext()) {
                        String key = iterator.next();
                        if (key.equals(chessPlace[i][j])) {//key is the String
                            int k = map2.get(key);
                            map2.replace(key, k - 1);
                        }
                    }
                }
            }
            if (map2.get("k") != 0) CapturedChess = CapturedChess + "k" + " " + map2.get("k") + "\n";
            if (map2.get("q") != 0) CapturedChess = CapturedChess + "q" + " " + map2.get("q") + "\n";
            if (map2.get("r") != 0) CapturedChess = CapturedChess + "r" + " " + map2.get("r") + "\n";
            if (map2.get("b") != 0) CapturedChess = CapturedChess + "b" + " " + map2.get("b") + "\n";
            if (map2.get("n") != 0) CapturedChess = CapturedChess + "n" + " " + map2.get("n") + "\n";
            if (map2.get("p") != 0) CapturedChess = CapturedChess + "p" + " " + map2.get("p");

        } else {
            return null;
        }

        return CapturedChess;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessBoard(chessComponents);
        ArrayList<ChessboardPoint> canMovePoints = (ArrayList<ChessboardPoint>) chessComponents[source.getX()][source.getY()].canMoveTo();
        canMovePoints.sort(new Sort());
        return canMovePoints;
    }

private static class Sort implements Comparator<ChessboardPoint> {
    @Override
    public int compare(ChessboardPoint p1, ChessboardPoint p2) {
        return p1.getX() == p2.getX() ? p1.getY() - p2.getY() : p1.getX() - p2.getX();
    }
}

}