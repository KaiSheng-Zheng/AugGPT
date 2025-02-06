import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        currentPlayer = ChessColor.WHITE;
        chessComponents = new ChessComponent[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                chessComponents[i][j] = new ChessComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return null;
                    }
                };
            }
        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) >= 'A' && chessboard.get(i).charAt(j) <= 'Z') {
                    if(chessboard.get(i).charAt(j) == 'R') chessComponents[i][j] = new RookChessComponent();
                    if(chessboard.get(i).charAt(j) == 'N') chessComponents[i][j] = new KnightChessComponent();
                    if(chessboard.get(i).charAt(j) == 'B') chessComponents[i][j] = new BishopChessComponent();
                    if(chessboard.get(i).charAt(j) == 'Q') chessComponents[i][j] = new QueenChessComponent();
                    if(chessboard.get(i).charAt(j) == 'K') chessComponents[i][j] = new KingChessComponent();
                    if(chessboard.get(i).charAt(j) == 'P') chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    ChessboardPoint che = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(che);
                } else if (chessboard.get(i).charAt(j) >= 'a' && chessboard.get(i).charAt(j) <= 'z') {
                    if(chessboard.get(i).charAt(j) == 'r') chessComponents[i][j] = new RookChessComponent();
                    if(chessboard.get(i).charAt(j) == 'n') chessComponents[i][j] = new KnightChessComponent();
                    if(chessboard.get(i).charAt(j) == 'b') chessComponents[i][j] = new BishopChessComponent();
                    if(chessboard.get(i).charAt(j) == 'q') chessComponents[i][j] = new QueenChessComponent();
                    if(chessboard.get(i).charAt(j) == 'k') chessComponents[i][j] = new KingChessComponent();
                    if(chessboard.get(i).charAt(j) == 'p') chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    ChessboardPoint che = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(che);
                }
                else if(chessboard.get(i).charAt(j)=='_') {
                    chessComponents[i][j] = new EmptySlotComponent() {
                    };
                    chessComponents[i][j].setName('_');
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    ChessboardPoint che = new ChessboardPoint(i,j);
                    chessComponents[i][j].setSource(che);
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') currentPlayer = ChessColor.WHITE;
        else if (chessboard.get(8).charAt(0) == 'b') currentPlayer = ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
       String[] s = new String[8];
       for(int i=0;i<8;i++){
           s[i] = "";
       }
       for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
                s[i] += chessComponents[i][j].name;
           }
       }
        return s[0]+"\n"+s[1]+"\n"+s[2]+"\n"+s[3]+"\n"+s[4]+"\n"+s[5]+"\n"+s[6]+"\n"+s[7];
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] q = {0,0,0,0,0,0};
        int[] qq = {1,1,2,2,2,8};
        String[] s = new String[6];
        if(player == ChessColor.BLACK){
            s[0] = "K"; s[1] = "Q"; s[2] = "R"; s[3] = "B"; s[4]= "N"; s[5] = "P";
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].name == 'K') q[0]++;
                    else if(chessComponents[i][j].name == 'Q') q[1]++;
                    else if(chessComponents[i][j].name == 'R') q[2]++;
                    else if(chessComponents[i][j].name == 'B') q[3]++;
                    else if(chessComponents[i][j].name == 'N') q[4]++;
                    else if(chessComponents[i][j].name == 'P') q[5]++;
                }
            }
            for(int i=0;i<6;i++){
                if(q[i]!=qq[i]) s[i]+=String.format(" %d\n",qq[i]-q[i]);
                else s[i]="";
            }
            String str = "";
            for(int i=0;i<6;i++){
                str+=s[i];
            }
            return str;
        }
        else{
            s[0] = "k"; s[1] = "q"; s[2] = "r"; s[3] = "b"; s[4]= "n"; s[5] = "p";
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].name == 'k') q[0]++;
                    else if(chessComponents[i][j].name == 'q') q[1]++;
                    else if(chessComponents[i][j].name == 'r') q[2]++;
                    else if(chessComponents[i][j].name == 'b') q[3]++;
                    else if(chessComponents[i][j].name == 'n') q[4]++;
                    else if(chessComponents[i][j].name == 'p') q[5]++;
                }
            }
            for(int i=0;i<6;i++){
                if(q[i]!=qq[i]) s[i]+=String.format(" %d\n",qq[i]-q[i]);
                else s[i]="";
            }
            String str = "";
            for(int i=0;i<6;i++){
                str+=s[i];
            }
            return str;
        }
    }
    @Override
    public ChessComponent getChess(int x,int y) {
        return chessComponents[x][y];
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        int x = source.getX();
        int y = source.getY();
        ChessComponent c = new ChessComponent() {
            @Override
            public List<ChessboardPoint> canMoveTo() {
                return null;
            }
        };
        c = chessComponents[x][y];
        c.setChessColor(chessComponents[x][y].getChessColor());
        c.setSource(chessComponents[x][y].getSource());
        c.setC(chessComponents);
        List<ChessboardPoint> canMovePoints = c.canMoveTo();
        if(canMovePoints.size() == 0) return new ArrayList<ChessboardPoint>();
        else{
            for(int i=0;i<canMovePoints.size();i++) {
                for(int j=0;j<canMovePoints.size()-1;j++) {
                    if(canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX()) {
                        ChessboardPoint aa = canMovePoints.get(j+1);
                        canMovePoints.set(j+1,canMovePoints.get(j));
                        canMovePoints.set(j,aa);
                    }
                    else if(canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX()) {
                        if(canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY()) {
                            ChessboardPoint aa = canMovePoints.get(j+1);
                            canMovePoints.set(j+1,canMovePoints.get(j));
                            canMovePoints.set(j,aa);
                        }
                    }
                }
            }
        }
        return canMovePoints;
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) return false;
        ChessboardPoint s = new ChessboardPoint(sourceX,sourceY);
        List<ChessboardPoint> a = getCanMovePoints(s);
        for(int i=0;i<a.size();i++){
            if(a.get(i).getX()==targetX&&a.get(i).getY()==targetY){
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setName(chessComponents[sourceX][sourceY].name);
                chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                chessComponents[sourceX][sourceY].setName('_');
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                if(currentPlayer == ChessColor.BLACK)
                currentPlayer = ChessColor.WHITE;
                else currentPlayer = ChessColor.BLACK;
                return true;
            }
        }
        return false;
    }
}
