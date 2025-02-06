import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessColor currentPlayer;
    private ChessComponent[][] chessComponents;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }

    private ChessComponent converter1(char character) {
        if (character == 'R') {
            return new RookChessComponent(ChessColor.BLACK);
        } else if (character == 'r') {
            return new RookChessComponent(ChessColor.WHITE);
        } else if (character == 'N') {
            return new KnightChessComponent(ChessColor.BLACK);
        } else if (character == 'n') {
            return new KnightChessComponent(ChessColor.WHITE);
        } else if (character == 'B') {
            return new BishopChessComponent(ChessColor.BLACK);
        } else if (character == 'b') {
            return new BishopChessComponent(ChessColor.WHITE);
        } else if (character == 'Q') {
            return new QueenChessComponent(ChessColor.BLACK);
        } else if (character == 'q') {
            return new QueenChessComponent(ChessColor.WHITE);
        } else if (character == 'K') {
            return new KingChessComponent(ChessColor.BLACK);
        } else if (character == 'k') {
            return new KingChessComponent(ChessColor.WHITE);
        } else if (character == 'P') {
            return new PawnChessComponent(ChessColor.BLACK);
        } else if (character == 'p') {
            return new PawnChessComponent(ChessColor.WHITE);
        } else return new EmptySlotComponent();
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i <= 7; i++) {
            for (int k = 0; k <= 7; k++) {
                chessComponents[i][k] = converter1(chessboard.get(i).charAt(k));
                chessComponents[i][k].setSource(new ChessboardPoint(i, k));
                chessComponents[i][k].setChessGame(this);
            }
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")){this.currentPlayer = ChessColor.BLACK;}
    }//loads chess game from given chessboard


    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }//return current player


    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }//return ChessComponent object

    public ChessComponent getChess(ChessboardPoint chessboardPoint) {
        return chessComponents[chessboardPoint.getX()][chessboardPoint.getY()];
    }

    private String componentsToString(int line) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= 7; i++) {
            result.append(chessComponents[line][i].toString());
        }
        return result.toString();
    }

    public String getChessboardGraph() {
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", componentsToString(0), componentsToString(1), componentsToString(2), componentsToString(3), componentsToString(4), componentsToString(5), componentsToString(6), componentsToString(7));
    }//return chessboard status


    public String getCapturedChess(ChessColor player) {
        StringBuilder result = new StringBuilder();
        int Kcounter = 0;
        int Qcounter = 0;
        int Rcounter = 0;
        int Bcounter = 0;
        int Ncounter = 0;
        int Pcounter = 0;
        String CounterString;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i <= 7; i++) {
                CounterString = componentsToString(i);
                for (int k = 0; k <= 7; k++) {
                    if (CounterString.charAt(k) == 'K') {
                        Kcounter++;
                    } else if (CounterString.charAt(k) == 'Q') {
                        Qcounter++;
                    } else if (CounterString.charAt(k) == 'R') {
                        Rcounter++;
                    } else if (CounterString.charAt(k) == 'B') {
                        Bcounter++;
                    } else if (CounterString.charAt(k) == 'N') {
                        Ncounter++;
                    } else if (CounterString.charAt(k) == 'P') {
                        Pcounter++;
                    }
                }
            }

            if (Kcounter != 1) {
                result.append("K 1\n");
            }
            if (Qcounter != 1) {
                result.append("Q 1\n");
            }
            if (Rcounter != 2) {
                result.append("R " + (2 - Rcounter) + "\n");
            }
            if (Bcounter != 2) {
                result.append("B " + (2 - Bcounter) + "\n");
            }
            if (Ncounter != 2) {
                result.append("N " + (2 - Ncounter) + "\n");
            }
            if (Pcounter != 8) {
                result.append("P " + (8 - Pcounter) + "\n");
            }
        } else {
            for (int i = 0; i <= 7; i++) {
                CounterString = componentsToString(i);
                for (int k = 0; k <= 7; k++) {
                    if (CounterString.charAt(k) == 'k') {
                        Kcounter++;
                    } else if (CounterString.charAt(k) == 'q') {
                        Qcounter++;
                    } else if (CounterString.charAt(k) == 'r') {
                        Rcounter++;
                    } else if (CounterString.charAt(k) == 'b') {
                        Bcounter++;
                    } else if (CounterString.charAt(k) == 'n') {
                        Ncounter++;
                    } else if (CounterString.charAt(k) == 'p') {
                        Pcounter++;
                    }
                }
            }
            if (Kcounter != 1) {
                result.append("k 1\n");
            }
            if (Qcounter != 1) {
                result.append("q 1\n");
            }
            if (Rcounter != 2) {
                result.append("r " + (2 - Rcounter) + "\n");
            }
            if (Bcounter != 2) {
                result.append("b " + (2 - Bcounter) + "\n");
            }
            if (Ncounter != 2) {
                result.append("n " + (2 - Ncounter) + "\n");
            }
            if (Pcounter != 8) {
                result.append("p " + (8 - Pcounter) + "\n");
            }
        }
        return result.toString();
    }//return chess pieces already captured;sort by the order of KQRBNP


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> result = new ArrayList<>(0);
//        if (getChess(source.getX(), source.getY()).getChessColor() == currentPlayer) {
        result = chessComponents[source.getX()][source.getY()].canMoveTo();
        result.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) {
                    return 1;
                } else if (o1.getX() < o2.getX()) {
                    return -1;
                } else {
                    if (o1.getY() > o2.getY()) {
                        return 1;
                    } else if (o1.getY() < o2.getY()) {
                        return -1;
                    } else return 0;
                }
            }
        });
//        }
        return result;
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX, sourceY).getChessColor() != currentPlayer) {
            return false;
        }
        List<ChessboardPoint> list = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
        for (ChessboardPoint point:list){
            if (point.getX()==targetX && point.getY()==targetY){
                chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                //switch player
                if (currentPlayer == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } else if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            }
        }
        return false;
//        if (list.contains(new ChessboardPoint(targetX, targetY))) {
//            chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
//            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
//            //switch player
//            if (currentPlayer == ChessColor.WHITE) {
//                currentPlayer = ChessColor.BLACK;
//            } else if (currentPlayer == ChessColor.BLACK) {
//                currentPlayer = ChessColor.WHITE;
//            }
//            return true;
//        } else {
//            return false;
//        }
    }
}

//        {KingChessComponent QueenChessComponent RookChessComponent BishopChessComponent KnightChessComponent,PawnChessComponent,EmptySlotComponent}