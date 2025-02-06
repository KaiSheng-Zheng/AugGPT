import java.util.List;
import java.util.ArrayList;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char name = chessboard.get(i).charAt(j);
                ChessboardPoint source= new ChessboardPoint(i, j);
                EmptySlotComponent c1 = new EmptySlotComponent(source, ChessColor.BLACK, name);
                EmptySlotComponent c2 = new EmptySlotComponent(source, ChessColor.WHITE, name);
                EmptySlotComponent c3 = new EmptySlotComponent(source, ChessColor.NONE, name);
                if (Character.isUpperCase(name)) {
                    chessComponents[i][j] = c1;
                }if(Character.isLowerCase(name)){
                    chessComponents[i][j] = c2;
                }else if(name == '_'){
                    chessComponents[i][j] = c3;
                }
            }
        }if(chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }if(chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
    }


    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }


    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }


    public String getChessboardGraph() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s.append(chessComponents[i][j].toString());
            }
            if (i < 7) {
                s.append("\n");
            }
        }return String.valueOf(s);
    }


    public String getCapturedChess(ChessColor player) {
        int c1 = 1;
        int c2 = 1;
        int c3 = 2;
        int c4 = 2;
        int c5 = 2;
        int c6 = 8;
        String a1 = "", a2 = "", a3 = "", a4 = "", a5 = "", a6 = "";
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("K")) {
                        c1--;
                    }
                    if (chessComponents[i][j].toString().equals("Q")) {
                        c2--;
                    }
                    if (chessComponents[i][j].toString().equals("R")) {
                        c3--;
                    }
                    if (chessComponents[i][j].toString().equals("B")) {
                        c4--;
                    }
                    if (chessComponents[i][j].toString().equals("N")) {
                        c5--;
                    }
                    if (chessComponents[i][j].toString().equals("P")) {
                        c6--;
                    }
                }
            }
            if (c1 != 0) {
                a1 = "K " + c1 + "\n";
            } 
            if (c2 != 0) {
                a2 = "Q " + c2 + "\n";
            } 
            if (c3 != 0) {
                a3 = "R " + c3 + "\n";
            } 
            if (c4 != 0) {
                a4 = "B " + c4 + "\n";
            } 
            if (c5 != 0) {
                a5 = "N " + c5 + "\n";
            } 
            if (c6 != 0) {
                a6 = "P " + c6 + "\n";
            } 
        }
        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("k")) {
                        c1--;
                    }
                    if (chessComponents[i][j].toString().equals("q")) {
                        c2--;
                    }
                    if (chessComponents[i][j].toString().equals("r")) {
                        c3--;
                    }
                    if (chessComponents[i][j].toString().equals("b")) {
                        c4--;
                    }
                    if (chessComponents[i][j].toString().equals("n")) {
                        c5--;
                    }
                    if (chessComponents[i][j].toString().equals("p")) {
                        c6--;
                    }
                }
            }
            if (c1 != 0) {
                a1 = "k " + c1 + "\n";
            } 
            if (c2 != 0) {
                a2 = "q " + c2 + "\n";
            } 
            if (c3 != 0) {
                a3 = "r " + c3 + "\n";
            } 
            if (c4 != 0) {
                a4 = "b " + c4 + "\n";
            } 
            if (c5 != 0) {
                a5 = "n " + c5 + "\n";
            } 
            if (c6 != 0) {
                a6 = "p " + c6 + "\n";
            } 
        }return a1 + a2 + a3 + a4 + a5 + a6 ;
    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> getCanMovePoint = new ArrayList<>();
        if (chessComponents[source.getX()][source.getY()].toString().equals("K") || chessComponents[source.getX()][source.getY()].toString().equals("k")) {
            ChessComponent chess = new KingChessComponent(new ChessboardPoint(source.getX(), source.getY()), getChess(source.getX(),
                    source.getY()).chessColor, getChess(source.getX(), source.getY()).name, getChess(source.getX(), source.getY()).chessComponents);
            getCanMovePoint = chess.canMoveTo();
        }
        if (chessComponents[source.getX()][source.getY()].toString().equals("N") || chessComponents[source.getX()][source.getY()].toString().equals("n")) {
            ChessComponent chess = new KnightChessComponent(new ChessboardPoint(source.getX(), source.getY()), getChess(source.getX(),
                    source.getY()).chessColor, getChess(source.getX(), source.getY()).name, getChess(source.getX(), source.getY()).chessComponents);
            getCanMovePoint = chess.canMoveTo();
        }
        if (chessComponents[source.getX()][source.getY()].toString().equals("R") || chessComponents[source.getX()][source.getY()].toString().equals("r")) {
            ChessComponent chess = new RookChessComponent(new ChessboardPoint(source.getX(), source.getY()), getChess(source.getX(),
                    source.getY()).chessColor, getChess(source.getX(), source.getY()).name, getChess(source.getX(), source.getY()).chessComponents);
            getCanMovePoint = chess.canMoveTo();
        }
        if (chessComponents[source.getX()][source.getY()].toString().equals("B") || chessComponents[source.getX()][source.getY()].toString().equals("b")) {
            ChessComponent chess = new BishopChessComponent(new ChessboardPoint(source.getX(), source.getY()), getChess(source.getX(),
                    source.getY()).chessColor, getChess(source.getX(), source.getY()).name, getChess(source.getX(), source.getY()).chessComponents);
            getCanMovePoint = chess.canMoveTo();
        }if (chessComponents[source.getX()][source.getY()].toString().equals("P") || chessComponents[source.getX()][source.getY()].toString().equals("p")) {
            ChessComponent chess = new PawnChessComponent(new ChessboardPoint(source.getX(), source.getY()), getChess(source.getX(),
                    source.getY()).chessColor, getChess(source.getX(), source.getY()).name, getChess(source.getX(), source.getY()).chessComponents);
            getCanMovePoint = chess.canMoveTo();
        }if (chessComponents[source.getX()][source.getY()].toString().equals("Q") || chessComponents[source.getX()][source.getY()].toString().equals("q")) {
            ChessComponent chess = new QueenChessComponent(new ChessboardPoint(source.getX(), source.getY()), getChess(source.getX(),
                    source.getY()).chessColor, getChess(source.getX(), source.getY()).name, getChess(source.getX(), source.getY()).chessComponents);
            getCanMovePoint = chess.canMoveTo();
    }return getCanMovePoint;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getCurrentPlayer()==getChess(sourceX, sourceY).chessColor
                && !getChess(sourceX, sourceY).chessColor.equals(getChess(targetX, targetY).chessColor)) {
            if (chessComponents[sourceX][sourceY].toString().equals("K")|| chessComponents[sourceX][sourceY].toString().equals("k")) {
                ChessComponent chess = new KingChessComponent(new ChessboardPoint(sourceX, sourceY), getChess(sourceX,
                        sourceY).chessColor, getChess(sourceX, sourceY).name, getChess(sourceX, sourceY).chessComponents);
                for (ChessboardPoint i : chess.canMoveTo()) {
                    if (targetX == i.getX() && targetY == i.getY()) {
                        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
                        ChessComponent o = new EmptySlotComponent(source, ChessColor.NONE, '_');
                        chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX, targetY), getChess(sourceX,
                                sourceY).chessColor, getChess(sourceX, sourceY).name, getChess(sourceX, sourceY).chessComponents);
                        chessComponents[sourceX][sourceY] = o;
                        if (getCurrentPlayer().equals(ChessColor.BLACK)) {
                            currentPlayer = ChessColor.WHITE;
                        } else {
                            currentPlayer = ChessColor.BLACK;
                        }
                        return true;
                    }
                }
            }
            if (chessComponents[sourceX][sourceY].toString().equals("N") || chessComponents[sourceX][sourceY].toString().equals("n")) {
                ChessComponent chess = new KnightChessComponent(new ChessboardPoint(sourceX, sourceY), getChess(sourceX,
                        sourceY).chessColor, getChess(sourceX, sourceY).name, getChess(sourceX, sourceY).chessComponents);
                for (ChessboardPoint i : chess.canMoveTo()) {
                    if (targetX == i.getX() && targetY == i.getY()) {
                        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(source, ChessColor.NONE, '_');
                        chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX, targetY),
                                chessComponents[sourceX][sourceY].chessColor, chessComponents[sourceX][sourceY].name, getChess(sourceX, sourceY).chessComponents);
                        if (getCurrentPlayer().equals(ChessColor.BLACK)) {
                            currentPlayer = ChessColor.WHITE;
                        } else {
                            currentPlayer = ChessColor.BLACK;
                        }
                        return true;
                    }
                }
            }
            if (chessComponents[sourceX][sourceY].toString().equals("B") || chessComponents[sourceX][sourceY].toString().equals("b")) {
                ChessComponent chess = new BishopChessComponent(new ChessboardPoint(sourceX, sourceY), getChess(sourceX,
                        sourceY).chessColor, getChess(sourceX, sourceY).name, getChess(sourceX, sourceY).chessComponents);
                for (ChessboardPoint i : chess.canMoveTo()) {
                    if (targetX == i.getX() && targetY == i.getY()) {
                        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
                        ChessComponent o = new EmptySlotComponent(source, ChessColor.NONE, '_');
                        chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX, targetY), getChess(sourceX,
                                sourceY).chessColor, getChess(sourceX, sourceY).name, getChess(sourceX, sourceY).chessComponents);
                        chessComponents[sourceX][sourceY] = o;
                        if (getCurrentPlayer().equals(ChessColor.BLACK)) {
                            currentPlayer = ChessColor.WHITE;
                        } else {
                            currentPlayer = ChessColor.BLACK;
                        }
                        return true;
                    }
                }
            }
            if (chessComponents[sourceX][sourceY].toString().equals("Q") || chessComponents[sourceX][sourceY].toString().equals("q")) {
                ChessComponent chess = new QueenChessComponent(new ChessboardPoint(sourceX, sourceY), getChess(sourceX,
                        sourceY).chessColor, getChess(sourceX, sourceY).name, getChess(sourceX, sourceY).chessComponents);
                for (ChessboardPoint i : chess.canMoveTo()) {
                    if (targetX == i.getX() && targetY == i.getY()) {
                        ChessComponent c = chessComponents[sourceX][sourceY];
                        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
                        ChessComponent o = new EmptySlotComponent(source, ChessColor.NONE, '_');
                        chessComponents[sourceX][sourceY] = o;
                        chessComponents[targetX][targetY] = c;
                        if (getCurrentPlayer().equals(ChessColor.BLACK)) {
                            currentPlayer = ChessColor.WHITE;
                        } else {
                            currentPlayer = ChessColor.BLACK;
                        }
                        return true;
                    }
                }
            }
            if (chessComponents[sourceX][sourceY].toString().equals("R") || chessComponents[sourceX][sourceY].toString().equals("r")) {
                ChessComponent chess = new RookChessComponent(new ChessboardPoint(sourceX, sourceY), getChess(sourceX,
                        sourceY).chessColor, getChess(sourceX, sourceY).name, getChess(sourceX, sourceY).chessComponents);
                for (ChessboardPoint i : chess.canMoveTo()) {
                    if (targetX == i.getX() && targetY == i.getY()) {
                        ChessComponent c = chessComponents[sourceX][sourceY];
                        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
                        ChessComponent o = new EmptySlotComponent(source, ChessColor.NONE, '_');
                        chessComponents[sourceX][sourceY] = o;
                        chessComponents[targetX][targetY] = c;
                        if (getCurrentPlayer().equals(ChessColor.BLACK)) {
                            currentPlayer = ChessColor.WHITE;
                        } else {
                            currentPlayer = ChessColor.BLACK;
                        }
                        return true;
                    }
                }
            }
            if (chessComponents[sourceX][sourceY].toString().equals("P") || chessComponents[sourceX][sourceY].toString().equals("p")) {
                ChessComponent chess = new PawnChessComponent(new ChessboardPoint(sourceX, sourceY), getChess(sourceX,
                        sourceY).chessColor, getChess(sourceX, sourceY).name, getChess(sourceX, sourceY).chessComponents);
                for (ChessboardPoint i : chess.canMoveTo()) {
                    if (targetX == i.getX() && targetY == i.getY()) {
                        ChessComponent c = chessComponents[sourceX][sourceY];
                        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
                        ChessComponent o = new EmptySlotComponent(source, ChessColor.NONE, '_');
                        chessComponents[sourceX][sourceY] = o;
                        chessComponents[targetX][targetY] = c;
                        if (getCurrentPlayer().equals(ChessColor.BLACK)) {
                            currentPlayer = ChessColor.WHITE;
                        } else {
                            currentPlayer = ChessColor.BLACK;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
