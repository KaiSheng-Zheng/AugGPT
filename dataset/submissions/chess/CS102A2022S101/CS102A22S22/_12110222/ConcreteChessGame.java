

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ConcreteChessGame implements ChessGame {
  public   static HashMap<Character, Integer> BLACK = new HashMap<>();
  public   static HashMap<Character, Integer> WHITE = new HashMap<>();
    private ChessComponent[][] chessComponents =new ChessComponent[8][8];
    private ChessColor currentPlayer;


    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }

        for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    if (chessboard.get(i).charAt(j) ==82) {
                        this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                    }
                    if (chessboard.get(i).charAt(j) == 114) {
                    this.  chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');

                    }
                    if (chessboard.get(i).charAt(j) == 75) {
                      this.  chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                    }
                    if (chessboard.get(i).charAt(j) == 107) {
                       this. chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                    }
                    if (chessboard.get(i).charAt(j) == 78) {
                      this.  chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                    }
                    if (chessboard.get(i).charAt(j) == 110) {
                       this. chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                    }
                    if (chessboard.get(i).charAt(j) == 80) {
                      this.  chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                    }
                    if (chessboard.get(i).charAt(j) == 112) {
                      this.  chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                    }
                    if (chessboard.get(i).charAt(j) == 81) {
                       this. chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                    }
                    if (chessboard.get(i).charAt(j) == 113) {
                       this. chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                    }
                    if (chessboard.get(i).charAt(j) == 66) {
                      this.  chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                    }
                    if (chessboard.get(i).charAt(j) == 98) {
                       this. chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                    }
                    if (chessboard.get(i).charAt(j) == 95) {
                      this.  chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
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
    public String getCapturedChess(ChessColor player) {

        int R = 0, r = 0, K = 0, k = 0, Q = 0, q = 0, N = 0, n = 0, B = 0, b = 0, P = 0, p = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char name = chessComponents[i][j].getName();
                if (name == 'R') {
                    R++;
                }
                if (name == 'r') {
                    r++;
                }
                if (name == 'K') {
                    K++;
                }
                if (name == 'k') {
                    k++;
                }
                if (name == 'P') {
                    P++;
                }
                if (name == 'p') {
                    p++;
                }
                if (name == 'Q') {
                    Q++;
                }
                if (name == 'q') {
                    q++;
                }
                if (name == 'B') {
                    B++;
                }
                if (name == 'b') {
                    b++;
                }
                if (name == 'N') {
                    N++;
                }
                if (name == 'n') {
                    n++;
                }
            }
        }
        if (K == 0) {
            BLACK.put('K', 1);
        }
        if (k == 0) {
            WHITE.put('k', 1);
        }
        if (Q == 0) {
            BLACK.put('Q', 1);
        }
        if (q == 0) {
            WHITE.put('q', 1);
        }
        if (R < 2) {
            BLACK.put('R', 2 - R);
        }
        if (r < 2) {
            WHITE.put('r', 2 - r);
        }
        if (B < 2) {
            BLACK.put('B', 2 - B);
        }
        if (b < 2) {
            WHITE.put('b', 2 - b);
        }
        if (N < 2) {
            BLACK.put('N', 2 - N);
        }
        if (n < 2) {
            WHITE.put('n', 2 - n);
        }
        if (P < 8) {
            BLACK.put('P', 8 - P);
        }
        if (p < 8) {
            WHITE.put('p', 8 - p);
        }
        StringBuilder sb1= new StringBuilder();
        StringBuilder sb2 =new StringBuilder();
      if( BLACK.containsKey('K')){
          sb1.append("K ").append(BLACK.get('K')).append("\n");}
      if(BLACK.containsKey('Q')){
          sb1.append("Q ").append(BLACK.get('Q')).append("\n");}
        if(BLACK.containsKey('R')){
            sb1.append("R ").append(BLACK.get('R')).append("\n");}
        if(BLACK.containsKey('B')){
            sb1.append("B ").append(BLACK.get('B')).append("\n");}
        if(BLACK.containsKey('N')){
            sb1.append("N ").append(BLACK.get('N')).append("\n");}
        if(BLACK.containsKey('P')){
            sb1.append("P ").append(BLACK.get('P')).append("\n");}
        if(WHITE.containsKey('k')){
            sb2.append("k ").append(WHITE.get('k')).append("\n");}
        if(WHITE.containsKey('q')){
            sb2.append("q ").append(WHITE.get('q')).append("\n");}
        if(WHITE.containsKey('r')){
            sb2.append("r ").append(WHITE.get('r')).append("\n");}
        if(WHITE.containsKey('b')){
            sb2.append("b ").append(WHITE.get('b')).append("\n");}
        if(WHITE.containsKey('n')){
            sb2.append("n ").append(WHITE.get('n')).append("\n");}
        if(WHITE.containsKey('p')){
            sb2.append("p ").append(WHITE.get('p')).append("\n");}

        if(player.equals(ChessColor.WHITE)){ BLACK.clear();  WHITE.clear();return String.valueOf(sb2);}

        BLACK.clear();  WHITE.clear();
        return String.valueOf(sb1);
    }

    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].getName());
                if (j == 7 && i != 7) {
                    sb.append("\n");
                }
            }
        }

        return String.valueOf(sb);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        HashMap<Integer,ChessboardPoint> hashMap = new HashMap<>();
        getChess(source.getX(),source.getY()).setComponents(this.chessComponents);
        List<ChessboardPoint> l = new ArrayList<>(getChess(source.getX(), source.getY()).canMoveTo());
        for (int i = 0; i < l.size(); i++) {
            hashMap.put(l.get(i).getX()*8+l.get(i).getY(),l.get(i));
        }
        List<ChessboardPoint> sorted = new ArrayList<>();
        for (int i = 0; i <= 63; i++) {
            if(hashMap.containsKey(i)){sorted.add(hashMap.get(i));}
        }
        hashMap.clear();
        return sorted;


    }
   @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
       List<ChessboardPoint> l =new ArrayList<>(getCanMovePoints(new ChessboardPoint(sourceX,sourceY)));
if(l.size()==0){return false;}
      if(getChess(sourceX,sourceY).getChessColor()!=currentPlayer){return false;}
       int count =0;
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i).getX()==targetX&&l.get(i).getY()==targetY){count++;}
        }
     if(count==0){return false;}
           chessComponents[targetX][targetY]= getChess(sourceX,sourceY);
           chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
           getChess(targetX,targetY).setSource(new ChessboardPoint(targetX,targetY));
if(currentPlayer==ChessColor.WHITE){currentPlayer=ChessColor.BLACK;}else {currentPlayer = ChessColor.WHITE;}
       return true;

    }

}
