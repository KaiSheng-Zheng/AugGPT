import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    //ChessComponent consist of chessboardpoint source and chessColor and name
    public ConcreteChessGame() {}
    public ConcreteChessGame(ChessColor currentPlayer) {this.currentPlayer = currentPlayer;}
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = chessboard.size() - 1; i >= 0 ; i--) {
            if (i == chessboard.size() - 1) {
                if(chessboard.get(i).equals("w")) this.currentPlayer = ChessColor.WHITE;
                if(chessboard.get(i).equals("b")) this.currentPlayer = ChessColor.BLACK;
            }else{
                for (int j = 0; j < 8; j++) {
                    if (chessboard.get(i).charAt(j) == 75) this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                    if (chessboard.get(i).charAt(j) == 81) this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                    if (chessboard.get(i).charAt(j) == 66) this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                    if (chessboard.get(i).charAt(j) == 78) this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                    if (chessboard.get(i).charAt(j) == 82) this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    if (chessboard.get(i).charAt(j) == 80) this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');

                    if (chessboard.get(i).charAt(j) == 107) this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                    if (chessboard.get(i).charAt(j) == 113) this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                    if (chessboard.get(i).charAt(j) == 98) this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                    if (chessboard.get(i).charAt(j) == 110) this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                    if (chessboard.get(i).charAt(j) == 114) this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                    if (chessboard.get(i).charAt(j) == 112) this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                    if (chessboard.get(i).charAt(j) == 95) this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
            }
        }
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                this.chessComponents[i][j].setChessComponents(this.chessComponents);
            }
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {return this.currentPlayer;}
    @Override
    public ChessComponent getChess(int x, int y) {return this.chessComponents[x][y];}

    @Override
    public String getChessboardGraph() {
        String[] str = new String[8];
        Arrays.fill(str,"");
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                str[i] += getChess(i,j).toString();
            }
        }
        StringBuilder AK47 = new StringBuilder();
        for(int i = 0;i<8;i++) AK47.append(str[i]).append("\n");
        return AK47.toString();
    }
    public static HashMap<String,Integer> Black = new HashMap<>();
    public static HashMap<String,Integer> White = new HashMap<>();
    public  void countBlack() {
        int B = 0, K = 0, N = 0, P = 0, Q = 0, R = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getChess(i, j).toString().equals("R")) R += 1;
                if (getChess(i, j).toString().equals("N")) N += 1;
                if (getChess(i, j).toString().equals("B")) B += 1;
                if (getChess(i, j).toString().equals("Q")) Q += 1;
                if (getChess(i, j).toString().equals("K")) K += 1;
                if (getChess(i, j).toString().equals("P")) P += 1;
            }
        }
        if (R < 2) Black.put("R", 2 - R);
        if (N < 2) Black.put("N", 2 - N);
        if (B < 2) Black.put("B", 2 - B);
        if (Q < 1) Black.put("Q", 1 - Q);
        if (K < 1) Black.put("K", 1 - K);
        if (P < 8) Black.put("P", 8 - P);
    }
    public void countWhite() {
        int r = 0, n = 0, b = 0, q = 0, k = 0, p = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getChess(i, j).toString().equals("r")) r += 1;
                if (getChess(i, j).toString().equals("n")) n += 1;
                if (getChess(i, j).toString().equals("b")) b += 1;
                if (getChess(i, j).toString().equals("q")) q += 1;
                if (getChess(i, j).toString().equals("k")) k += 1;
                if (getChess(i, j).toString().equals("p")) p += 1;
            }
        }
        if (r < 2) White.put("r", 2 - r);
        if (n < 2) White.put("n", 2 - n);
        if (b < 2) White.put("b", 2 - b);
        if (q < 1) White.put("q", 1 - q);
        if (k < 1) White.put("k", 1 - k);
        if (p < 8) White.put("p", 8 - p);
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        String str = "";
        if (player.equals(ChessColor.BLACK) ) {
            countBlack();
            if (Black.containsKey("K")) str += "K " + Black.get("K") + "\n";
            if (Black.containsKey("Q")) str += "Q " + Black.get("Q") + "\n";
            if (Black.containsKey("R")) str += "R " + Black.get("R") + "\n";
            if (Black.containsKey("B")) str += "B " + Black.get("B") + "\n";
            if (Black.containsKey("N")) str += "N " + Black.get("N") + "\n";
            if (Black.containsKey("P")) str += "P " + Black.get("P") + "\n";
            Black.clear();
        }
        if (player.equals(ChessColor.WHITE)) {
            countWhite();
            if (White.containsKey("k")) str += "k " + White.get("k") + "\n";
            if (White.containsKey("q")) str += "q " + White.get("q") + "\n";
            if (White.containsKey("r")) str += "r " + White.get("r") + "\n";
            if (White.containsKey("b")) str += "b " + White.get("b") + "\n";
            if (White.containsKey("n")) str += "n " + White.get("n") + "\n";
            if (White.containsKey("p")) str += "p " + White.get("p") + "\n";
            White.clear();
        }
        return str;
    }
    public static HashMap<Integer,ChessboardPoint> AK47 = new HashMap<>();
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> M4A4 = new ArrayList<>();
        int a = getChess(source.getX(),source.getY()).canMoveTo().size();
        for(int i = 0;i<a;i++){
            int x = getChess(source.getX(),source.getY()).canMoveTo().get(i).getX()*8;
            int y = getChess(source.getX(),source.getY()).canMoveTo().get(i).getY();
            AK47.put(x+y,getChess(source.getX(),source.getY()).canMoveTo().get(i));
        }
        for(int i = 0;i<65;i++){
            if(AK47.containsKey(i)){
                M4A4.add(AK47.get(i));
            }
        }
        AK47.clear();
        return M4A4;
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean isPairPoint = false;
        if(getChess(sourceX,sourceY).getChessColor().equals(getCurrentPlayer())){
            for(int i = 0;i<getCanMovePoints(getChess(sourceX,sourceY).getSource()).size();i++){
                if(getCanMovePoints(getChess(sourceX,sourceY).getSource()).get(i).toString().equals("("+targetX+","+targetY+")")) isPairPoint = true;
            }
            if(isPairPoint){
                if(getChess(sourceX,sourceY).getName() == 75) this.chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'K');
                if(getChess(sourceX,sourceY).getName() == 107) this.chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'k');
                if(getChess(sourceX,sourceY).getName() == 81) this.chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'Q');
                if(getChess(sourceX,sourceY).getName() == 113) this.chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'q');
                if(getChess(sourceX,sourceY).getName() == 80) this.chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'P');
                if(getChess(sourceX,sourceY).getName() == 112) this.chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'p');
                if(getChess(sourceX,sourceY).getName() == 82) this.chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'R');
                if(getChess(sourceX,sourceY).getName() == 114) this.chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'r');
                if(getChess(sourceX,sourceY).getName() == 78) this.chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'N');
                if(getChess(sourceX,sourceY).getName() == 110) this.chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'n');
                if(getChess(sourceX,sourceY).getName() == 66) this.chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'B');
                if(getChess(sourceX,sourceY).getName() == 98) this.chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'b');
                this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                if(getCurrentPlayer().equals(ChessColor.WHITE)){this.currentPlayer = ChessColor.BLACK;}
                else{this.currentPlayer = ChessColor.WHITE;}
                for(int i = 0;i<8;i++){
                    for(int j = 0;j<8;j++){
                        this.chessComponents[i][j].setChessComponents(this.chessComponents);
                    }
                }
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /*public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("RNBQKBNR");
        a.add("PPPPPPPP");
        a.add("________");
        a.add("________");
        a.add("________");
        a.add("________");
        a.add("pppppppp");
        a.add("rnbqkbnr");
        a.add("w");
        ConcreteChessGame b = new ConcreteChessGame();
        b.loadChessGame(a);
        for(int i = 0;i<b.getCanMovePoints(b.getChess(1,3).getSource()).size();i++){
            System.out.println(b.getCanMovePoints(b.getChess(1,3).getSource()).get(i).toString());
        }
        System.out.println(b.getCurrentPlayer());
        System.out.println(b.getCanMovePoints(b.getChess(1,3).getSource()).get(0).toString().equals("(2,3)"));
        b.moveChess(6,4,4,4);
        System.out.println(b.getChessboardGraph());
        b.moveChess(1,0,3,0);

    }*/
}
