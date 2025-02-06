import java.util.*;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    private ChessColor getComponentColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='A'&&component<='Z')?ChessColor.BLACK:ChessColor.WHITE);
    }
    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char component=chessboard.get(i).charAt(j),raw=(component=='_')?'_':(char)(component&(~32));
                if(raw=='K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(raw=='Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(raw=='R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(raw=='B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(raw=='N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else if(raw=='P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
                else{
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i, j),getComponentColor(component));
                }
            }
        }
        currentPlayer=chessboard.get(8).charAt(0)=='b'?ChessColor.BLACK:ChessColor.WHITE;
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
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                sb.append(chessComponents[i][j].toString());
            }
            if(i!=7){
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] cntr=new int[128],sequence=new int[]{'K','Q','R','B','N','P'},fullNum=new int[]{1,1,2,2,2,8};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(getComponentColor(chessComponents[i][j].toString().charAt(0))==player){
                    cntr[chessComponents[i][j].toString().charAt(0)&(~32)]++;
                }
            }
        }
        for(int i=0;i<sequence.length;i++){
            if(cntr[sequence[i]]<fullNum[i]){
                sb.append((char) (sequence[i] | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(fullNum[i] - cntr[sequence[i]]).append("\n");
            }
        }
        return sb.toString();
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].loadCurrentChessboard(chessComponents);
        if(currentPlayer!=getComponentColor(chessComponents[sourceX][sourceY].toString().charAt(0))){
            return false;
        }
        ArrayList<ChessboardPoint> moveTo=(ArrayList<ChessboardPoint>)chessComponents[sourceX][sourceY].canMoveTo();
        if(!moveTo.contains(new ChessboardPoint(targetX, targetY))){
            return false;
        }
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].source=new ChessboardPoint(targetX, targetY);
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
        currentPlayer=(currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE);
        return true;
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].loadCurrentChessboard(chessComponents);
        ArrayList<ChessboardPoint> moveTo=(ArrayList<ChessboardPoint>)chessComponents[source.getX()][source.getY()].canMoveTo();
        moveTo.sort(new Sort());
        return moveTo;
    }
    private static class Sort implements Comparator<ChessboardPoint>{
        @Override
        public int compare(ChessboardPoint p1,ChessboardPoint p2){
            return p1.getX()==p2.getX()?p1.getY()-p2.getY():p1.getX()-p2.getX();
        }
    }
}
