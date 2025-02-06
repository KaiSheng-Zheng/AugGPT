import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    
    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'w'){
            this.currentPlayer = ChessColor.WHITE;
        }else {
            this.currentPlayer = ChessColor.BLACK;
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char a = chessboard.get(i).charAt(j);
                char d;
                if (a == '_'){
                    d = '_';
                }else{
                    if (a >= 'a' && a <= 'z'){
                        int b  = (int)(a);
                        int c = b -32;
                        d = (char)(c);
                    }else {
                        d = a;
                    }
                }
                ChessboardPoint  chessboardPoint= new ChessboardPoint(i,j);
                ChessColor color = PlayerColor(a);
                switch (d){
                    case 'R':
                        this.chessComponents[i][j] = new RookChessComponent(chessboardPoint,color);
                        break;
                    case 'N':
                        this.chessComponents[i][j] = new KnightChessComponent(chessboardPoint,color);
                        break;
                    case 'B':
                        this.chessComponents[i][j] = new BishopChessComponent(chessboardPoint,color);
                        break;
                    case 'Q':
                        this.chessComponents[i][j] = new QueenChessComponent(chessboardPoint,color);
                        break;
                    case 'K':
                        this.chessComponents[i][j] = new KingChessComponent(chessboardPoint,color);
                        break;
                    case 'P':
                        this.chessComponents[i][j] = new PawnChessComponent(chessboardPoint,color);
                        break;
                    case '_':
                        this.chessComponents[i][j] = new EmptySlotComponent(chessboardPoint,color);
                        break;
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
    @Override
    public String getChessboardGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String s = chessComponents[i][j].toString();
                stringBuilder.append(s);
            }
            if (i != 7){
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString();
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        int[] a=new int[128],chess=new int[]{'K','Q','R','B','N','P'},num=new int[]{1,1,2,2,2,8};
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char currentplayer = chessComponents[i][j].toString().charAt(0);
                char Currentplayer;
                if (currentplayer >= 'a' && currentplayer <= 'z'){
                    int b  = (int)(currentplayer);
                    int c = b -32;
                    Currentplayer =  (char)(c);
                }else{
                    Currentplayer = currentplayer;
                }
                if (PlayerColor(currentplayer) == player) {
                    a[(int) (Currentplayer)]++;
                }
            }
        }
        for(int i=0;i<6;i++){
            if (a[chess[i]] < num[i]){
                int l = num[i] - a[chess[i]];
                int x;
                if (player == ChessColor.WHITE){
                     x  = chess[i] | 32;
                }else {
                    x = chess[i] | 0;
                }
                char p = (char)(x);
                stringBuilder.append(p);
                stringBuilder.append(" ");
                stringBuilder.append(l);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
     private ChessColor PlayerColor(char a){
        if (a == '_'){
            return ChessColor.NONE;
        }else if (a >= 'a' && a<= 'z'){
            return ChessColor.WHITE;
        }else return ChessColor.BLACK;
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent component1 = chessComponents[sourceX][sourceY];
        ChessComponent component2 = chessComponents[targetX][targetY];
        component1.currentboard(chessComponents);
        ChessColor currentColor = PlayerColor(component1.toString().charAt(0));
        List<ChessboardPoint> canmoveto = (List<ChessboardPoint>)(component1.canMoveTo());
        ChessboardPoint chessboardPoint1 =  new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint chessboardPoint2 =  new ChessboardPoint(targetX,targetY);
        if (currentPlayer != currentColor){
            return false;
        }
        if(!(canmoveto.contains(chessboardPoint2))){
            return false;
        }
        if (currentPlayer == ChessColor.BLACK){
            currentPlayer = ChessColor.WHITE;
        }else{
            currentPlayer = ChessColor.BLACK;
        }
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(chessboardPoint1,ChessColor.NONE);
        chessComponents[targetX][targetY].source=new ChessboardPoint(targetX, targetY);
        return true;
    }
    private static class Sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint o1, ChessboardPoint o2) {
            if (o1.getX() != o2.getX()){
                return o1.getX() - o2.getX();
            }else{
               return o1.getY()-o2.getY();
            }
        }
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent component = chessComponents[source.getX()][source.getY()];
        component.currentboard(chessComponents);
        ArrayList<ChessboardPoint> canmoveto = (ArrayList<ChessboardPoint>)component.canMoveTo();
        canmoveto.sort(new Sort());
        return canmoveto;
    }
    
}