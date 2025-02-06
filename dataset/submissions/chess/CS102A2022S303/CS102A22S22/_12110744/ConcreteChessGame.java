import java.util.List;


public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

       public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
              if (chessboard.get(i).charAt(j)=='P') {
                  chessComponents[i][j] = new PawnChessComponent('P', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='p') {
                  chessComponents[i][j] = new PawnChessComponent('p', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='R') {
                  chessComponents[i][j] = new RookChessComponent('R', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='r') {
                  chessComponents[i][j] = new RookChessComponent('r', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='N') {
                  chessComponents[i][j] = new KnightChessComponent('N', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='n') {
                  chessComponents[i][j] = new KnightChessComponent('n', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='B') {
                  chessComponents[i][j] = new BishopChessComponent('B', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='b') {
                     chessComponents[i][j] = new BishopChessComponent('b', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='Q') {
                  chessComponents[i][j] = new QueenChessComponent('Q', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='q') {
                  chessComponents[i][j] = new QueenChessComponent('q', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='K') {
                  chessComponents[i][j] = new KingChessComponent('K', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='k') {
                  chessComponents[i][j] = new KingChessComponent('k', chessComponents, new ChessboardPoint(i, j));
              }else if (chessboard.get(i).charAt(j)=='_') {
                     chessComponents[i][j] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(i, j));
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        String l1 = new String();
        String l2 = new String();
        String l3 = new String();
        String l4 = new String();
        String l5 = new String();
        String l6 = new String();
        String l7 = new String();
        String l8 = new String();

        for (int i = 0; i < 8; i++) {
            l1 = l1.concat(Character.toString(getChess(0, i).name));
            l2 = l2.concat(Character.toString(getChess(1, i).name));
            l3 = l3.concat(Character.toString(getChess(2, i).name));
            l4 = l4.concat(Character.toString(getChess(3, i).name));
            l5 = l5.concat(Character.toString(getChess(4, i).name));
            l6 = l6.concat(Character.toString(getChess(5, i).name));
            l7 = l7.concat(Character.toString(getChess(6, i).name));
            l8 = l8.concat(Character.toString(getChess(7, i).name));
        }
        return l1 + "\n" + l2 + "\n" + l3 + "\n" + l4 + "\n" + l5 + "\n" + l6 + "\n" + l7 + "\n" + l8;
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        String back=new String();
        int P = 0, R = 0, N = 0, B = 0, Q = 0, K = 0;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name=='P'){
                        P++;
                    }if (chessComponents[i][j].name=='K'){
                        K++;
                    }if (chessComponents[i][j].name=='Q'){
                        Q++;
                    }if (chessComponents[i][j].name=='B'){
                        B++;
                    }if (chessComponents[i][j].name=='N'){
                        N++;
                    }if (chessComponents[i][j].name=='R'){
                        R++;
                    }
                }
            }
            if (K < 1) {
                back=back.concat ("K 1\n");
            }
            if (Q < 1) {
                back=back.concat("Q 1\n");
            }
            if (R < 2) {
                back=back.concat(String.format("R %s\n", 2 - R));
            }
            if (B < 2) {
                back= back.concat(String.format("B %s\n", 2 - B));
            }
            if (N < 2) {
                back=back.concat(String.format("N %s\n", 2 - N));
            }
            if (P < 8) {
                back=back.concat(String.format("P %s\n", 8 - P));
            }
            return back;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name=='p'){
                        P++;
                    }if (chessComponents[i][j].name=='k'){
                        K++;
                    }if (chessComponents[i][j].name=='q'){
                        Q++;
                    }if (chessComponents[i][j].name=='b'){
                        B++;
                    }if (chessComponents[i][j].name=='n'){
                        N++;
                    }if (chessComponents[i][j].name=='r'){
                        R++;
                    }
                }
            }
            if (K < 1) {
                back=back.concat("k 1\n");
            }
            if (Q < 1) {
                back=back.concat("q 1\n");
            }if (R < 2) {
                back=back.concat(String.format("r %s\n", 2 - R));
            }
            if (B < 2) {
                back=back.concat(String.format("b %s\n", 2 - B));
            }
            if (N < 2) {
                back=back.concat(String.format("n %s\n", 2 - N));
            }
            if (P < 8) {
                back=back.concat(String.format("p %s\n", 8 - P));
            }
            return back;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        boolean move = true;
        if (canMovePoints.size() >1) {
            for (int i = 0; i < canMovePoints.size() - 1; i++) {
                for (int j = 0; j < canMovePoints.size() - 1 - i; j++) {
                    ChessboardPoint temp;
                    if (canMovePoints.get(j).getY() > canMovePoints.get(j + 1).getY()) {
                        move  = false;
                        temp = canMovePoints.get(j);
                        canMovePoints.set(j, canMovePoints.get(j + 1));
                        canMovePoints.set(j + 1, temp);
                    } if (canMovePoints.get(j).getX() > canMovePoints.get(j + 1).getX()) {
                        move  = false;
                        temp = canMovePoints.get(j);
                        canMovePoints.set(j, canMovePoints.get(j + 1));
                        canMovePoints.set(j + 1, temp);
                    }
                }
                if (move ) {
                    break;
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getCurrentPlayer() == ChessColor.BLACK) {
            if (chessComponents[sourceX][sourceY].name <= 'Z') {
                boolean movechess = false;
                List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
                if (move.size() != 0) {
                    for (int i = 0; i < move.size(); i++) {
                        if (move.get(i).getX() == targetX && move.get(i).getY() == targetY) {
                            movechess = true;
                            break;
                        }
                    }
                    if (movechess) {
                        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(sourceX, sourceY));
                        currentPlayer = ChessColor.WHITE;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (chessComponents[i][j].name=='P') {
                                    chessComponents[i][j] = new PawnChessComponent('P', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='p') {
                                    chessComponents[i][j] = new PawnChessComponent('p', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='R') {
                                    chessComponents[i][j] = new RookChessComponent('R', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='r') {
                                    chessComponents[i][j] = new RookChessComponent('r', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='N') {
                                    chessComponents[i][j] = new KnightChessComponent('N', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='n') {
                                    chessComponents[i][j] = new KnightChessComponent('n', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='B') {
                                    chessComponents[i][j] = new BishopChessComponent('B', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='b') {
                                    chessComponents[i][j] = new BishopChessComponent('b', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='Q') {
                                   chessComponents[i][j] = new QueenChessComponent('Q', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='q') {
                                    chessComponents[i][j] = new QueenChessComponent('q', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='K') {
                                     chessComponents[i][j] = new KingChessComponent('K', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='k') {
                                    chessComponents[i][j] = new KingChessComponent('k', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='_') {
                                   chessComponents[i][j] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(i, j));
                                }
                            }
                        }
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (chessComponents[sourceX][sourceY].name >= 97) {
                boolean movechess = false;
                List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
                if (move.size() != 0) {
                    for (int i = 0; i < move.size(); i++) {
                        if (move.get(i).getX() == targetX && move.get(i).getY() == targetY) {
                            movechess = true;
                            break;
                        }
                    }
                    if (movechess) {
                        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(sourceX, sourceY));
                        currentPlayer = ChessColor.BLACK;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (chessComponents[i][j].name=='P') {
                                    chessComponents[i][j] = new PawnChessComponent('P', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='p') {
                                    chessComponents[i][j] = new PawnChessComponent('p', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='R') {
                                    chessComponents[i][j] = new RookChessComponent('R', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='r') {
                                    chessComponents[i][j] = new RookChessComponent('r', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='N') {
                                    chessComponents[i][j] = new KnightChessComponent('N', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='n') {
                                    chessComponents[i][j] = new KnightChessComponent('n', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='B') {
                                    chessComponents[i][j] = new BishopChessComponent('B', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='b') {
                                    chessComponents[i][j] = new BishopChessComponent('b', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='Q') {
                                    chessComponents[i][j] = new QueenChessComponent('Q', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='q') {
                                    chessComponents[i][j] = new QueenChessComponent('q', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='K') {
                                    chessComponents[i][j] = new KingChessComponent('K', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='k') {
                                    chessComponents[i][j] = new KingChessComponent('k', chessComponents, new ChessboardPoint(i, j));
                                }else if (chessComponents[i][j].name=='_') {
                                    chessComponents[i][j] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(i, j));
                                }
                            }
                        }
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}

