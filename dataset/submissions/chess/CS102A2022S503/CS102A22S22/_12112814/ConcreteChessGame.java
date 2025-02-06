import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size(); i++) {
            String line = chessboard.get(i);
            if (i == chessboard.size() - 1) {
                if (line.equals("w")) {
                    currentPlayer = ChessColor.WHITE;
                } else if (line.equals("b")) {
                    currentPlayer = ChessColor.BLACK;
                }
                break;
            }
            char[] chars = line.toCharArray();
            for (int i1 = 0; i1 < chars.length; i1++) {
                char s = chars[i1];
                ChessComponent component;
                ChessboardPoint chessboardPoint = new ChessboardPoint(i, i1);
                switch (s) {
                    case 'R' -> component = new RookChessComponent(this, chessboardPoint, ChessColor.BLACK);
                    case 'N' -> component = new KnightChessComponent(this, chessboardPoint, ChessColor.BLACK);
                    case 'B' -> component = new BishopChessComponent(this, chessboardPoint, ChessColor.BLACK);
                    case 'Q' -> component = new QueenChessComponent(this, chessboardPoint, ChessColor.BLACK);
                    case 'K' -> component = new KingChessComponent(this, chessboardPoint, ChessColor.BLACK);
                    case 'P' -> component = new PawnChessComponent(this, chessboardPoint, ChessColor.BLACK);
                    case 'r' -> component = new RookChessComponent(this, chessboardPoint, ChessColor.WHITE);
                    case 'n' -> component = new KnightChessComponent(this, chessboardPoint, ChessColor.WHITE);
                    case 'b' -> component = new BishopChessComponent(this, chessboardPoint, ChessColor.WHITE);
                    case 'q' -> component = new QueenChessComponent(this, chessboardPoint, ChessColor.WHITE);
                    case 'k' -> component = new KingChessComponent(this, chessboardPoint, ChessColor.WHITE);
                    case 'p' -> component = new PawnChessComponent(this, chessboardPoint, ChessColor.WHITE);
                    default -> component = new EmptySlotComponent(this, chessboardPoint, ChessColor.NONE);
                }
                chessComponents[i][i1] = component;
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

    @Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 8; i1++) {
                ChessComponent component = chessComponents[i][i1];
                sb.append(component.getName());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        ArrayList<ChessComponent> chessByColor = getChessByColor(player);
        StringBuilder sb = new StringBuilder();
        int k = 0;
        int q = 0;
        int r = 0;
        int b = 0;
        int n = 0;
        int p = 0;
        for (ChessComponent component : chessByColor) {
            if (component instanceof KingChessComponent) {
                k++;
            } else if (component instanceof QueenChessComponent) {
                q++;
            } else if (component instanceof RookChessComponent) {
                r++;
            } else if (component instanceof BishopChessComponent) {
                b++;
            } else if (component instanceof KnightChessComponent) {
                n++;
            } else if (component instanceof PawnChessComponent) {
                p++;
            }
        }
        if (k != 1) {
            sb.append(player == ChessColor.BLACK ? "K" : "k").append(" ").append(1 - k).append("\n");
        }
        if (q != 1) {
            sb.append(player == ChessColor.BLACK ? "Q" : "q").append(" ").append(1 - q).append("\n");
        }
        if (r != 2) {
            sb.append(player == ChessColor.BLACK ? "R" : "r").append(" ").append(2 - r).append("\n");
        }
        if (b != 2) {
            sb.append(player == ChessColor.BLACK ? "B" : "b").append(" ").append(2 - b).append("\n");
        }
        if (n != 2) {
            sb.append(player == ChessColor.BLACK ? "N" : "n").append(" ").append(2 - n).append("\n");
        }
        if (p != 8) {
            sb.append(player == ChessColor.BLACK ? "P" : "p").append(" ").append(8 - p).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<ChessComponent> getChessByColor(ChessColor color) {
        ArrayList<ChessComponent> data = new ArrayList<>();
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                if (component.getChessColor() == color) {
                    data.add(component);
                }
            }
        }
        return data;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent component = chessComponents[source.getX()][source.getY()];
        return component.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7) {
            return false;
        }
        ChessComponent source = getChess(sourceX, sourceY);
        if (source.getChessColor() != currentPlayer) {
            return false;
        }
        
        List<ChessboardPoint> chessboardPoints = source.canMoveTo();
        ChessComponent target = getChess(targetX, targetY);
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            
            if (chessboardPoint.toString().equals(target.getSource().toString())) {
                chessComponents[targetX][targetY] = source;
                source.updatePoint(new ChessboardPoint(targetX, targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(this, new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
                return true;
            }
        }
        return false;
    }
}