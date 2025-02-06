import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private  ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case '_' ->
                            chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE,chessComponents);
                    case 'K' ->
                            chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,chessComponents);
                    case 'k' ->
                            chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,chessComponents);
                    case 'Q' ->
                            chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,chessComponents);
                    case 'q' ->
                            chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,chessComponents);
                    case 'R' ->
                            chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,chessComponents);
                    case 'r' ->
                            chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,chessComponents);
                    case 'N' ->
                            chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,chessComponents);
                    case 'n' ->
                            chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,chessComponents);
                    case 'B' ->
                            chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,chessComponents);
                    case 'b' ->
                            chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,chessComponents);
                    case 'P' ->
                            chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,chessComponents);
                    case 'p' ->
                            chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,chessComponents);
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph.append(chessComponents[i][j].name);
                }
            if (i != 7){graph.append("\n");}
            }
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder result = new StringBuilder();
        if (player == ChessColor.BLACK){
            if (howManyLeft('K') != 1){
                result.append("K 1\n");
            }
            if (howManyLeft('Q') != 1){
                result.append("Q 1\n");
            }
            if (howManyLeft('R') != 2){
                result.append("R ");
                result.append(2-howManyLeft('R'));
                result.append("\n");
            }
            if (howManyLeft('B') != 2){
                result.append("B ");
                result.append(2-howManyLeft('B'));
                result.append("\n");
            }
            if (howManyLeft('N') != 2){
                result.append("N ");
                result.append(2-howManyLeft('N'));
                result.append("\n");
            }
            if (howManyLeft('P') != 8){
                result.append("P ");
                result.append(8-howManyLeft('P'));
                result.append("\n");
            }
        }
        if (player == ChessColor.WHITE){
            if (howManyLeft('k') != 1){
                result.append("k 1\n");
            }
            if (howManyLeft('q') != 1){
                result.append("q 1\n");
            }
            if (howManyLeft('r') != 2){
                result.append("r ");
                result.append(2-howManyLeft('r'));
                result.append("\n");
            }
            if (howManyLeft('b') != 2){
                result.append("b ");
                result.append(2-howManyLeft('b'));
                result.append("\n");
            }
            if (howManyLeft('n') != 2){
                result.append("n ");
                result.append(2-howManyLeft('n'));
                result.append("\n");
            }
            if (howManyLeft('p') != 8){
                result.append("p ");
                result.append(8-howManyLeft('p'));
                result.append("\n");
            }
        }
        return result.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> sorted = new ArrayList<>();
        if (chessComponents[source.getX()][source.getY()].canMoveTo().isEmpty()){
            return sorted;
        }
        int times = chessComponents[source.getX()][source.getY()].canMoveTo().size();
        sorted.add(chessComponents[source.getX()][source.getY()].canMoveTo().get(0));
        for (int i = 1; i < times; i++) {
            int index = 0;
            for (int j = 0; j < sorted.size(); j++) {
                if (chessComponents[source.getX()][source.getY()].canMoveTo().get(i).getX() > sorted.get(j).getX()){
                    index = j+1;
                }
                if (chessComponents[source.getX()][source.getY()].canMoveTo().get(i).getX() == sorted.get(j).getX()){
                    if (chessComponents[source.getX()][source.getY()].canMoveTo().get(i).getY() >= sorted.get(j).getY()){
                        index = j+1;
                    }
                }
            }
            sorted.add(index,chessComponents[source.getX()][source.getY()].canMoveTo().get(i));
        }
        return sorted;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean able = false;
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer){
            for (ChessboardPoint This:
                    getCanMovePoints(new ChessboardPoint(sourceX, sourceY))) {
                if (This.getX() == targetX && This.getY() == targetY){
                    able=true;
                    break;
                }
            }
        }
        if (able){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,chessComponents);
            switchPlayer();
            return true;
        }else return false;
    }

    public int howManyLeft(char name){
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == name){counter++;}
            }
        }
        return counter;
    }

    private void switchPlayer(){
        if (currentPlayer == ChessColor.BLACK){
            currentPlayer = ChessColor.WHITE;
        }else currentPlayer = ChessColor.BLACK;
    }
}