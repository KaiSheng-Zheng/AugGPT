import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
     chessComponents= new ChessComponent[8][8];
     currentPlayer= ChessColor.WHITE;
    }

    @Override
     public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        }
        else {
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 75 || chessboard.get(i).charAt(j) == 107) {
                    this.chessComponents[i][j] = new KingChessComponent();
                } else if (chessboard.get(i).charAt(j) == 81 || chessboard.get(i).charAt(j) == 113) {
                    this.chessComponents[i][j] = new QueenChessComponent();
                } else if (chessboard.get(i).charAt(j) == 82 || chessboard.get(i).charAt(j) == 114) {
                    this.chessComponents[i][j] = new RookChessComponent();
                } else if (chessboard.get(i).charAt(j) == 66 || chessboard.get(i).charAt(j) == 98) {
                    this.chessComponents[i][j] = new BishopChessComponent();
                } else if (chessboard.get(i).charAt(j) == 78 || chessboard.get(i).charAt(j) == 110) {
                    this.chessComponents[i][j] = new KnightChessComponent();
                } else if (chessboard.get(i).charAt(j) == 80 || chessboard.get(i).charAt(j) == 112) {
                    this.chessComponents[i][j] = new PawnChessComponent();
                } else if (chessboard.get(i).charAt(j) == 95) {
                    this.chessComponents[i][j] = new EmptyChessComponent();
                }
                this.chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                if (chessboard.get(i).charAt(j) > 65 && chessboard.get(i).charAt(j) <= 90)
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                if (chessboard.get(i).charAt(j) > 97 && chessboard.get(i).charAt(j) <= 122)
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
            }
        }
        ChessComponent.setChessComponents(this.chessComponents.clone());
//        System.out.println(currentPlayer);
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder graph= new StringBuilder();
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                graph.append(component.getName());
            }
            graph.append("\n");
        }
        return String.valueOf(graph);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K = 1, Q = 1, R = 2, B = 2, N = 2, P = 8;
        String s="";
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.chessComponents[i][j].getName() == 75) {
                        K--;
                    } else if (this.chessComponents[i][j].getName() == 81) {
                        Q--;
                    } else if (this.chessComponents[i][j].getName() == 82) {
                        R--;
                    } else if (this.chessComponents[i][j].getName() == 66) {
                        B--;
                    } else if (this.chessComponents[i][j].getName() == 78) {
                        N--;
                    } else if (this.chessComponents[i][j].getName() == 80) {
                        P--;
                    }
                }
            }
            if (K>0) s+="K "+K;
            if (Q>0) s+="\nQ "+Q;
            if (R>0) s+="\nR "+R;
            if (B>0) s+="\nB "+B;
            if (N>0) s+="\nN "+N;
            if (P>0) s+="\nP "+P;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.chessComponents[i][j].getName() == 107) {
                        K--;
                    } else if (this.chessComponents[i][j].getName() == 113) {
                        Q--;
                    } else if (this.chessComponents[i][j].getName() == 114) {
                        R--;
                    } else if (this.chessComponents[i][j].getName() == 98) {
                        B--;
                    } else if (this.chessComponents[i][j].getName() == 110) {
                        N--;
                    } else if (this.chessComponents[i][j].getName() == 112) {
                        P--;
                    }
                }
            }
            if (K > 0) s += "k " + K;
            if (Q > 0) s += "\nq " + Q;
            if (R > 0) s += "\nr " + R;
            if (B > 0) s += "\nb " + B;
            if (N > 0) s += "\nn " + N;
            if (P > 0) s += "\np " + P;
        }
        return s;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
//             return this.getChess(sourceX,sourceY).canMoveTo().contains(new ChessboardPoint(targetX,targetY));
        boolean canmove=false;
//        System.out.println(this.getChess(sourceX,sourceY));
//        System.out.println(this.getChess(sourceX,sourceY).getChessColor());
//        System.out.println(this.getChess(sourceX,sourceY).canMoveTo());
        for (ChessboardPoint point:this.getChess(sourceX,sourceY).canMoveTo()){
            if (point.getX()==targetX&&point.getY()==targetY) {
                canmove=true;
                break;
            }
        }
        if (this.getChess(sourceX,sourceY).getChessColor()!=this.currentPlayer) {
            canmove = false;
        }
        if (canmove){
            this.chessComponents[targetX][targetY]=this.getChess(sourceX,sourceY);
            this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            this.chessComponents[sourceX][sourceY]=new EmptyChessComponent();
            this.chessComponents[sourceX][sourceY].setName('_');
            this.chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
            if (this.currentPlayer == ChessColor.BLACK) {
                this.setCurrentPlayer(ChessColor.WHITE);
            } else {
                this.setCurrentPlayer(ChessColor.BLACK);
            }
            ChessComponent.setChessComponents(this.chessComponents);
//            System.out.println(Arrays.deepToString(ChessComponent.getChessComponents()));
        }
        return canmove;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = this.getChess(source.getX(),source.getY()).canMoveTo();
        canMovePoints.sort((c1,c2)->Float.compare(c1.getY(),c2.getY()));
        canMovePoints.sort((c1,c2)->Float.compare(c1.getX(),c2.getX()));
        return canMovePoints;
    }
}

