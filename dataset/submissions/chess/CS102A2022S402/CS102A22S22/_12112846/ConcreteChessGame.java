import java.util.*;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    private ChessColor getComponentColor(char component){
        if (component=='_') {
            return ChessColor.NONE;
        }
        else if (component>='A'&&component<='Z') {
            return ChessColor.BLACK;
        }
        else {
            return ChessColor.WHITE;
        }
    }
    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i = 0;i < 8; ++i){
            for(int j = 0;j < 8; ++j){
                char component=chessboard.get(i).charAt(j);
                char raw =0;
                if (component=='_') {raw = '_';}
                else if (component >= 'A' &&component <= 'Z') {raw = component;}
                else if (component >= 'a' &&component <= 'z') {
                    if (component == 'k') {raw = 'K';}
                    else if (component == 'q') {raw = 'Q';}
                    else if (component == 'r') {raw = 'R';}
                    else if (component == 'b') {raw = 'B';}
                    else if (component == 'n') {raw = 'N';}
                    else if (component == 'p') {raw = 'P';}
                }
                if(raw=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(raw=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(raw=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(raw=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(raw=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(raw=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else{
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){currentPlayer = ChessColor.WHITE;}
        else {currentPlayer = ChessColor.BLACK;}
    }
    @Override
    public ChessColor getCurrentPlayer() {return this.currentPlayer;}
    @Override
    public ChessComponent getChess(int x, int y) {return chessComponents[x][y];}
    @Override
    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for(int i=0; i<8;  i++){
            for(int j=0; j<8; j++){
                graph.append(chessComponents[i][j].toString());
            }
            if(i < 7){
                graph.append('\n');
            }
        }
        return graph.toString();
    }

    private static class Sort implements Comparator<ChessboardPoint>{
        @Override
        public int compare(ChessboardPoint p1,ChessboardPoint p2){
            if(p1.getX() == p2.getX()) {return p1.getY() - p2.getY();}
            else{return p1.getX() - p2.getX();}
        }
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].loadCurrentChessboard(chessComponents);
        ArrayList<ChessboardPoint> moveTo = (ArrayList<ChessboardPoint>)chessComponents[source.getX()][source.getY()].canMoveTo();
        moveTo.sort(new Sort());
        return moveTo;
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].loadCurrentChessboard(chessComponents);
        if (currentPlayer != getComponentColor(chessComponents[sourceX][sourceY].toString().charAt(0))){
            return false;
        }
        ArrayList<ChessboardPoint> moveTo = (ArrayList<ChessboardPoint>)chessComponents[sourceX][sourceY].canMoveTo();
        if (!moveTo.contains(new ChessboardPoint(targetX, targetY))){
            return false;
        }
        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source = new ChessboardPoint(targetX, targetY);
        chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
        currentPlayer = (currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE);
        return true;
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        // Uppercase: Black
        char[] chessType = {'K','Q','R','B','N','P'};
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 6; ++i) {
                chessType[i] = Character.toLowerCase(chessType[i]);
            }
        }
        int[] chessOnBoard = new int[6];
        int[] chessTotal = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                char currentChess = chessComponents[i][j].name;
                for (int k = 0; k < 6; ++k) {
                    if (currentChess == chessType[k]) {
                        chessOnBoard[k] += 1;
                    }
                }
            }
        }
        String capturedChessStr = "";
        for (int i = 0; i < 6; ++i) {
            if (chessTotal[i] != chessOnBoard[i]) {
                capturedChessStr +=
                        chessType[i] + " " + (chessTotal[i] - chessOnBoard[i]) + "\n";
            }
        }
        return capturedChessStr;
    }


}

