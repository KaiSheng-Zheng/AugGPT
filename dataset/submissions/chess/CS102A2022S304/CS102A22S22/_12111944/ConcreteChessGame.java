

import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    this.chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if (chessboard.get(i).charAt(j) == '_') {
                    this.chessComponents[i][j] = new EmptySlotComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
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

    /*
    save game
     */
    @Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                if (chessComponents[i][j] == null || chessComponents[i][j].name == '_') {
                    sb.append("_");
                } else {
                    sb.append(chessComponents[i][j].toString());
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.WHITE) {
            int[] Whites = new int[6];
            int[] lostWhites = new int[6];
            StringBuilder Whitesb = new StringBuilder();
            //      K Q R B N P
            //      0 1 2 3 4 5
            for (int i = 0; i < this.chessComponents.length; i++) {
                for (int j = 0; j < this.chessComponents[i].length; j++) {
                    if (this.chessComponents[i][j].name == 'k') {
                        Whites[0]++;
                    } else if (this.chessComponents[i][j].name == 'q') {
                        Whites[1]++;
                    } else if (this.chessComponents[i][j].name == 'r') {
                        Whites[2]++;
                    } else if (this.chessComponents[i][j].name == 'b') {
                        Whites[3]++;
                    } else if (this.chessComponents[i][j].name == 'n') {
                        Whites[4]++;
                    } else if (this.chessComponents[i][j].name == 'p') {
                        Whites[5]++;
                    }
                }
            }
            lostWhites[0] = 1 - Whites[0];
            lostWhites[1] = 1 - Whites[1];
            lostWhites[2] = 2 - Whites[2];
            lostWhites[3] = 2 - Whites[3];
            lostWhites[4] = 2 - Whites[4];
            lostWhites[5] = 8 - Whites[5];

            if (lostWhites[0] != 0) {
                Whitesb.append("k ");
                Whitesb.append(lostWhites[0]).append("\n");
            }
            if (lostWhites[1] != 0) {
                Whitesb.append("q ");
                Whitesb.append(lostWhites[1]).append("\n");
            }
            if (lostWhites[2] != 0) {
                Whitesb.append("r ");
                Whitesb.append(lostWhites[2]).append("\n");
            }
            if (lostWhites[3] != 0) {
                Whitesb.append("b ");
                Whitesb.append(lostWhites[3]).append("\n");
            }
            if (lostWhites[4] != 0) {
                Whitesb.append("n ");
                Whitesb.append(lostWhites[4]).append("\n");
            }
            if (lostWhites[5] != 0) {
                Whitesb.append("p ");
                Whitesb.append(lostWhites[5]).append("\n");
            }
            return Whitesb.toString();
        } else {
            int[] Blacks = new int[6];
            int[] lostBlacks = new int[6];
            StringBuilder Blacksb = new StringBuilder();
            //      K Q R B N P
            //      0 1 2 3 4 5
            for (int i = 0; i < this.chessComponents.length; i++) {
                for (int j = 0; j < this.chessComponents[i].length; j++) {
                    if (this.chessComponents[i][j].name == 'K') {
                        Blacks[0]++;
                    } else if (this.chessComponents[i][j].name == 'Q') {
                        Blacks[1]++;
                    } else if (this.chessComponents[i][j].name == 'R') {
                        Blacks[2]++;
                    } else if (this.chessComponents[i][j].name == 'B') {
                        Blacks[3]++;
                    } else if (this.chessComponents[i][j].name == 'N') {
                        Blacks[4]++;
                    } else if (this.chessComponents[i][j].name == 'P') {
                        Blacks[5]++;
                    }
                }
            }
            lostBlacks[0] = 1 - Blacks[0];
            lostBlacks[1] = 1 - Blacks[1];
            lostBlacks[2] = 2 - Blacks[2];
            lostBlacks[3] = 2 - Blacks[3];
            lostBlacks[4] = 2 - Blacks[4];
            lostBlacks[5] = 8 - Blacks[5];

            if (lostBlacks[0] != 0) {
                Blacksb.append("K ");
                Blacksb.append(lostBlacks[0]).append("\n");
            }
            if (lostBlacks[1] != 0) {
                Blacksb.append("Q ");
                Blacksb.append(lostBlacks[1]).append("\n");
            }
            if (lostBlacks[2] != 0) {
                Blacksb.append("R ");
                Blacksb.append(lostBlacks[2]).append("\n");
            }
            if (lostBlacks[3] != 0) {
                Blacksb.append("B ");
                Blacksb.append(lostBlacks[3]).append("\n");
            }
            if (lostBlacks[4] != 0) {
                Blacksb.append("N ");
                Blacksb.append(lostBlacks[4]).append("\n");
            }
            if (lostBlacks[5] != 0) {
                Blacksb.append("P ");
                Blacksb.append(lostBlacks[5]).append("\n");

            }
            return Blacksb.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        //(1)Comparablelab13
        //(2)Comparator
        return canMovePoints;
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent sourceChess = this.getChess(sourceX, sourceY);
        ChessComponent targetChess = this.getChess(targetX, targetY);

        if (sourceChess.name == 'K' || sourceChess.name == 'k') {
            boolean move = Math.abs(targetX - sourceX) <= 1 && Math.abs(targetY - sourceY) <= 1 && targetChess.getChessColor() != getCurrentPlayer() && sourceChess.getChessColor() == getCurrentPlayer();
            if (Math.abs(targetX - sourceX) <= 1 && Math.abs(targetY - sourceY) <= 1 && targetChess.getChessColor() != getCurrentPlayer() && sourceChess.getChessColor() == getCurrentPlayer()) {
                if (this.currentPlayer == ChessColor.BLACK) {
                    setCurrentPlayer(ChessColor.WHITE);
                } else {
                    setCurrentPlayer(ChessColor.BLACK);
                }
            }
            return move;
        }
        if (sourceChess.name == 'B' || sourceChess.name == 'b') {
            boolean move = ((targetX == sourceX - 2 && targetY == sourceY - 1) || (targetX == sourceX - 2 && targetY == sourceY + 1) || (targetX == sourceX - 1 && targetY == sourceY - 2) || (targetX == sourceX - 1 && targetY == sourceY + 2) || (targetX == sourceX + 1 && targetY == sourceY - 2) || (targetX == sourceX + 1 && targetY == sourceY + 2) || (targetX == sourceX + 2 && targetY == sourceY - 1) || (targetX == sourceX + 2 && targetY == sourceY + 1) && targetChess.getChessColor() != getCurrentPlayer() && sourceChess.getChessColor() == getCurrentPlayer());
            if (move) {
                if (this.currentPlayer == ChessColor.BLACK) {
                    setCurrentPlayer(ChessColor.WHITE);
                } else {
                    setCurrentPlayer(ChessColor.BLACK);
                }
            }
            return move;
        }
        return true;
    }
}