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


    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard.get(i).charAt(j) == '_' ){
                    this.chessComponents[i][j] = new EmptySlotComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                    this.chessComponents[i][j].setName('_');
                }else if((chessboard.get(i).charAt(j) == 'R')){
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('R');
                }else if((chessboard.get(i).charAt(j) == 'r')){
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('r');
                }
                else if((chessboard.get(i).charAt(j) == 'N')){
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('N');
                }else if((chessboard.get(i).charAt(j) == 'n')){
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('n');
                }
                else if((chessboard.get(i).charAt(j) == 'B')){
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('B');
                }
                else if((chessboard.get(i).charAt(j) == 'b')){
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('b');
                }
                else if((chessboard.get(i).charAt(j) == 'Q')){
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('Q');
                }
                else if((chessboard.get(i).charAt(j) == 'q')){
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('q');
                }
                else if((chessboard.get(i).charAt(j) == 'K')){
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('K');
                }
                else  if((chessboard.get(i).charAt(j) == 'k')){
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('k');
                }
                else if((chessboard.get(i).charAt(j) == 'P')){
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('P');
                }
                else  if((chessboard.get(i).charAt(j) == 'p')){
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('p');
                }
            }
        }
        if(chessboard.get(8).equals("w")){
            setCurrentPlayer(ChessColor.WHITE);
        }else if(chessboard.get(8).equals("b")){
            setCurrentPlayer(ChessColor.BLACK);
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

    @Override
    public String getChessboardGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                stringBuilder.append(chessComponents[i][j]);
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",stringBuilder.substring(0,8),stringBuilder.substring(8,16),stringBuilder.substring(16,24),stringBuilder.substring(24,32),
                stringBuilder.substring(32,40),stringBuilder.substring(40,48),stringBuilder.substring(48,56),stringBuilder.substring(56,64));
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] p1 = new int[6];
        int[] p2 = new int[6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (player == ChessColor.BLACK) {
                    if (this.chessComponents[i][j].name == 'K') {
                        p1[0] ++;
                    } else if (this.chessComponents[i][j].name == 'Q') {
                        p1[1] ++;
                    } else if (this.chessComponents[i][j].name == 'R') {
                        p1[2] ++;
                    } else if (this.chessComponents[i][j].name == 'B') {
                        p1[3] ++;
                    } else if (this.chessComponents[i][j].name == 'N') {
                        p1[4] ++;
                    } else if (this.chessComponents[i][j].name == 'P') {
                        p1[5] ++;
                    }
                } else {
                    if (this.chessComponents[i][j].name == 'k') {
                        p2[0] ++;
                    } else if (this.chessComponents[i][j].name == 'q') {
                        p2[1] ++;
                    } else if (this.chessComponents[i][j].name == 'r') {
                        p2[2] ++;
                    } else if (this.chessComponents[i][j].name == 'b') {
                        p2[3] ++;
                    } else if (this.chessComponents[i][j].name == 'n') {
                        p2[4] ++;
                    } else if (this.chessComponents[i][j].name == 'p') {
                        p2[5] ++;
                    }
                }
            }
        }
        StringBuilder P1 = new StringBuilder();
        StringBuilder P2 = new StringBuilder();
        int temp;
        if (p1[0] != 1) {
            P1.append("K 1\n");
        }if (p1[1] != 1) {
            P1.append("Q 1\n");
        } if (p1[2] != 2) {
            P1.append("R ");
            temp = 2 - p1[2];
            P1.append(temp);
            P1.append("\n");
        } if (p1[3] != 2) {
            P1.append("B ");
            temp = 2 - p1[3];
            P1.append(temp);
            P1.append("\n");
        } if (p1[4] != 2) {
            P1.append("N ");
            temp = 2 - p1[4];
            P1.append(temp);
            P1.append("\n");
        } if (p1[5] != 8) {
            P1.append("P ");
            temp = 8 - p1[5];
            P1.append(temp);
            P1.append("\n");
        }
        if (p2[0] != 1) {
            P2.append("k 1\n");
        } if (p2[1] != 1) {
            P2.append("q 1\n");
        } if (p2[2] != 2) {
            P2.append("r ");
            temp = 2 - p2[2];
            P2.append(temp);
            P2.append("\n");
        } if (p2[3] != 2) {
            P2.append("b ");
            temp = 2 - p2[3];
            P2.append(temp);
            P2.append("\n");
        } if (p2[4] != 2) {
            P2.append("n ");
            temp = 2 - p2[4];
            P2.append(temp);
            P2.append("\n");
        } if (p2[5] != 8) {
            P2.append("p ");
            temp = 8 - p2[5];
            P2.append(temp);
            P2.append("\n");
        }
        if(player == ChessColor.BLACK){
            return P1.toString();
        }else {
            return P2.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        for (int i = 0; i < canMovePoints.size() - 1; i++) {
            for (int j = 0; j < canMovePoints.size()-i-1; j++) {
                if(canMovePoints.get(j).getX()> canMovePoints.get(j+1).getX()){
                    ChessboardPoint temp = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,temp);
                }else if(canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX()){
                    if(canMovePoints.get(j).getY()> canMovePoints.get(j+1).getY()){
                        ChessboardPoint temp = canMovePoints.get(j);
                        canMovePoints.set(j,canMovePoints.get(j+1));
                        canMovePoints.set(j+1,temp);
                    }
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX <= 7 && sourceX >= 0 && targetX <= 7 && targetX >= 0 && sourceY <= 7 && sourceY >= 0 && targetY <= 7 && targetY >= 0) {
            ChessComponent source = getChess(sourceX, sourceY);
            ChessComponent target = getChess(targetX, targetY);
            if (source.chessColor != getCurrentPlayer() || target.chessColor == getCurrentPlayer()) {
                return false;
            } else {
                int temp = 0;
                ChessboardPoint point = new ChessboardPoint(sourceX,sourceY);
                List<ChessboardPoint> move = getCanMovePoints(point);
                for (int i = 0; i < move.size(); i++) {
                    if (move.get(i).getX() == target.getSource().getX() && move.get(i).getY() ==target.getSource().getY()) {
                        temp++;
                    }
                }
                if (temp != 0) {
                    source.setSource(new ChessboardPoint(targetX, targetY));
                    this.chessComponents[targetX][targetY] = source;
                    target = new EmptySlotComponent();
                    target.setSource(new ChessboardPoint(sourceX, sourceY));
                    this.chessComponents[sourceX][sourceY] =target;

                    if (this.currentPlayer == ChessColor.WHITE) {
                        this.currentPlayer = ChessColor.BLACK;
                    } else if (this.currentPlayer == ChessColor.BLACK) {
                        this.currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
