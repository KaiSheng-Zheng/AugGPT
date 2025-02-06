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
        String line;
        for (int i = 0; i < chessboard.size() - 1; i++) {
            line = chessboard.get(i);
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case 'R' -> chessComponents[i][j] = new RookChessComponent(chessComponents, 'R', i, j, ChessColor.BLACK);
                    case 'r' -> chessComponents[i][j] = new RookChessComponent(chessComponents, 'r', i, j, ChessColor.WHITE);
                    case 'N' -> chessComponents[i][j] = new KnightChessComponent(chessComponents, 'N', i, j, ChessColor.BLACK);
                    case 'n' -> chessComponents[i][j] = new KnightChessComponent(chessComponents, 'n', i, j, ChessColor.WHITE);
                    case 'B' -> chessComponents[i][j] = new BishopChessComponent(chessComponents, 'B', i, j, ChessColor.BLACK);
                    case 'b' -> chessComponents[i][j] = new BishopChessComponent(chessComponents, 'b', i, j, ChessColor.WHITE);
                    case 'Q' -> chessComponents[i][j] = new QueenChessComponent(chessComponents, 'Q', i, j, ChessColor.BLACK);
                    case 'q' -> chessComponents[i][j] = new QueenChessComponent(chessComponents, 'q', i, j, ChessColor.WHITE);
                    case 'K' -> chessComponents[i][j] = new KingChessComponent(chessComponents, 'K', i, j, ChessColor.BLACK);
                    case 'k' -> chessComponents[i][j] = new KingChessComponent(chessComponents, 'k', i, j, ChessColor.WHITE);
                    case 'P' -> chessComponents[i][j] = new PawnChessComponent(chessComponents, 'P', i, j, ChessColor.BLACK);
                    case 'p' -> chessComponents[i][j] = new PawnChessComponent(chessComponents, 'p', i, j, ChessColor.WHITE);
                    case '_' -> chessComponents[i][j] = new EmptySlotComponent(chessComponents, '_', i, j, ChessColor.NONE);
                }
            }
        }
        line = chessboard.get(chessboard.size() - 1);
        switch (line.charAt(0)) {
            case 'w' -> currentPlayer = ChessColor.WHITE;
            case 'b' -> currentPlayer = ChessColor.BLACK;
        }
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
        StringBuilder sb = new StringBuilder();
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                if (component instanceof RookChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) {
                        sb.append("R");
                    } else {
                        sb.append("r");
                    }
                } else if (component instanceof KnightChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) {
                        sb.append("N");
                    } else {
                        sb.append("n");
                    }
                } else if (component instanceof BishopChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) {
                        sb.append("B");
                    } else {
                        sb.append("b");
                    }
                } else if (component instanceof QueenChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) {
                        sb.append("Q");
                    } else {
                        sb.append("q");
                    }
                } else if (component instanceof KingChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) {
                        sb.append("K");
                    } else {
                        sb.append("k");
                    }
                } else if (component instanceof PawnChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) {
                        sb.append("P");
                    } else {
                        sb.append("p");
                    }
                } else if (component instanceof EmptySlotComponent) {
                    sb.append("_");
                }
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    @Override
    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.BLACK) {
            int[] chessCount = {1, 1, 2, 2, 2, 8};
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    if (chessComponents[i][j] instanceof KingChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                            chessCount[0]--;
                        }
                    } else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                            chessCount[1]--;
                        }
                    } else if (chessComponents[i][j] instanceof RookChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                            chessCount[2]--;
                        }
                    } else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                            chessCount[3]--;
                        }
                    } else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                            chessCount[4]--;
                        }
                    } else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                            chessCount[5]--;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if (chessCount[0] > 0) {
                sb.append("K ").append(chessCount[0]).append("\n");
            }
            if (chessCount[1] > 0) {
                sb.append("Q ").append(chessCount[1]).append("\n");
            }
            if (chessCount[2] > 0) {
                sb.append("R ").append(chessCount[2]).append("\n");
            }
            if (chessCount[3] > 0) {
                sb.append("B ").append(chessCount[3]).append("\n");
            }
            if (chessCount[4] > 0) {
                sb.append("N ").append(chessCount[4]).append("\n");
            }
            if (chessCount[5] > 0) {
                sb.append("P ").append(chessCount[5]).append("\n");
            }
            return sb.toString();
            
        } else {
            int[] chessCount = {1, 1, 2, 2, 2, 8};
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    if (chessComponents[i][j] instanceof KingChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                            chessCount[0]--;
                        }
                    } else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                            chessCount[1]--;
                        }
                    } else if (chessComponents[i][j] instanceof RookChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                            chessCount[2]--;
                        }
                    } else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                            chessCount[3]--;
                        }
                    } else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                            chessCount[4]--;
                        }
                    } else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                            chessCount[5]--;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if (chessCount[0] > 0) {
                sb.append("k ").append(chessCount[0]).append("\n");
            }
            if (chessCount[1] > 0) {
                sb.append("q ").append(chessCount[1]).append("\n");
            }
            if (chessCount[2] > 0) {
                sb.append("r ").append(chessCount[2]).append("\n");
            }
            if (chessCount[3] > 0) {
                sb.append("b ").append(chessCount[3]).append("\n");
            }
            if (chessCount[4] > 0) {
                sb.append("n ").append(chessCount[4]).append("\n");
            }
            if (chessCount[5] > 0) {
                sb.append("p ").append(chessCount[5]).append("\n");
            }
            return sb.toString();
        }
    }
    
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chessComponent = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chessComponent.canMoveTo();
        canMovePoints.sort((o1, o2) -> {
            if (o1.getX() > o2.getX() || (o1.getX() == o2.getX() && o1.getY() > o2.getY())) {
                return 1;
            } else if (o1.getX() == o2.getX() && o1.getY() == o2.getY()) {
                return 0;
            } else {
                return -1;
            }
        });
        return canMovePoints;
    }
    
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
//        if (chessComponent.canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
//            chessComponents[targetX][targetY] = chessComponent;
//            chessComponents[sourceX][sourceY] = new EmptySlotComponent(chessComponents, '_', sourceX, sourceY, ChessColor.NONE);
//            currentPlayer = (currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE);
//            return true;
//        }
        if ((sourceX == targetX && sourceY == targetY) || sourceX < 0 || sourceX > 7 || sourceY < 0 || sourceY > 7) {
            return false;
        }
        ChessComponent chessComponent = chessComponents[sourceX][sourceY];
        if (chessComponent instanceof EmptySlotComponent || chessComponent.getChessColor() != currentPlayer) {
            return false;
        }
        List<ChessboardPoint> canMovePoints = chessComponent.canMoveTo();
        for (ChessboardPoint canMovePoint : canMovePoints) {
            if (canMovePoint.getX() == targetX && canMovePoint.getY() == targetY) {
                chessComponents[targetX][targetY] = chessComponent;
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chessComponents, '_', sourceX, sourceY, ChessColor.NONE);
                currentPlayer = (currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE);
                return true;
            }
        }
        return false;
    }
    
}
