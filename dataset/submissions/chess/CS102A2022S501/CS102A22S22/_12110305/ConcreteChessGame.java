import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private ChessColor getComponentColor(char component){
        if(component=='_'){
           return ChessColor.NONE;
        }else if (component>='A'&&component<='Z'){
            return ChessColor.BLACK;}
        else return   ChessColor.WHITE;
    }

    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        StringBuilder chessboard = new StringBuilder();
        for(int i = 0;i < 8 ; i++){
            for(int j = 0 ; j<8 ; j++){
                chessboard.append(chessComponents[i][j].toString());
            }
            if(i != 7){
                chessboard.append('\n');
            }
        }
        return chessboard.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int[] sequence=new int[]{'K','Q','R','B','N','P'};
        int[] fullNum=new int[]{1,1,2,2,2,8};
        int[] chess1 = new int[6];
        StringBuilder CHESS =new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(getComponentColor(chessComponents[i][j].toString().charAt(0)) == player){
                    if (chessComponents[i][j] instanceof KingChessComponent){
                        chess1[0] ++;
                    }
                    else if (chessComponents[i][j] instanceof QueenChessComponent){
                        chess1[1] ++;
                    }
                    else if (chessComponents[i][j] instanceof RookChessComponent){
                        chess1[2] ++;
                    }
                    else if (chessComponents[i][j] instanceof BishopChessComponent){
                        chess1[3] ++;
                    }
                    else if (chessComponents[i][j] instanceof KnightChessComponent){
                        chess1[4] ++;
                    }
                    else if (chessComponents[i][j] instanceof PawnChessComponent){
                        chess1[5] ++;
                    }
                }
            }
        }
        for(int i = 0; i < 6; i++){
            if(chess1[i] < fullNum[i]){
                CHESS.append((char) (sequence[i] | (player == ChessColor.WHITE ? 32 : 0))).append(" ").append(fullNum[i] - chess1[i]).append("\n");
            }
        }
        return CHESS.toString();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].getChessboard(chessComponents);
        if(currentPlayer != getComponentColor(chessComponents[sourceX][sourceY].toString().charAt(0))){
            return false;
        }
        if(!chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))){
            return false;
        }
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
        if(currentPlayer==ChessColor.WHITE)
            currentPlayer=ChessColor.BLACK;
    else currentPlayer = ChessColor.WHITE;
        return true;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].getChessboard(chessComponents);
        ArrayList<ChessboardPoint> moveTo=(ArrayList<ChessboardPoint>)chessComponents[source.getX()][source.getY()].canMoveTo();
        moveTo.sort(new Sort());
        return moveTo;
    }

    private static class Sort implements Comparator<ChessboardPoint>{
        public int compare(ChessboardPoint p1,ChessboardPoint p2){
            if (p1.getX() == p2.getX())
                return p1.getY()-p2.getY();
        else return p1.getX()-p2.getX();
        }
    }

    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char chess = chessboard.get(i).charAt(j);
                char raw;
                if (chess =='_'){
                raw = '_';}
                else {
                raw = (char)(chess&(~32));
                }
                if (raw == 'K'){
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i, j),getComponentColor(chess));
                }
                else if(raw == 'Q'){
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i, j),getComponentColor(chess));
                }
                else if(raw == 'R'){
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i, j),getComponentColor(chess));
                }
                else if(raw == 'B'){
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i, j),getComponentColor(chess));
                }
                else if(raw == 'N'){
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i, j),getComponentColor(chess));
                }
                else if(raw == 'P'){
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i, j),getComponentColor(chess));
                }
                else{
                    chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i, j),getComponentColor(chess));
                }
            }
        }

                if(chessboard.get(8).charAt(0)=='b'){
                    currentPlayer =  ChessColor.BLACK ;
                }else
                    currentPlayer =  ChessColor.WHITE;
    }

}