
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char s = chessboard.get(i).charAt(j);
                ChessboardPoint point = new ChessboardPoint(i,j);
                switch (s){
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setName(s);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setName(s);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        chessComponents[i][j].setName(s);
                        break;
                }
                chessComponents[i][j].setSource(point);
            }
        }
        switch (chessboard.get(8)){
            case "w":
                this.currentPlayer = ChessColor.WHITE;break;
            case "b":
                this.currentPlayer = ChessColor.BLACK;break;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        String[] s = {"","","","","","","","",};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s[i] += chessComponents[i][j].getName();
            }
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
    }

    public String getCapturedChess(ChessColor player) {
        String str = "";
        String s = getChessboardGraph();
        switch (player){
            case WHITE:
                int k = captured(s,'k');
                int q = captured(s,'q');
                int r = captured(s,'r');
                int b = captured(s,'b');
                int n = captured(s,'n');
                int p = captured(s,'p');
                if(k != 1){
                    str+=String.format("k 1\n");
                }
                if(q != 1){
                    str+=String.format("q 1\n");
                }
                if(r != 2){
                    str+=String.format("r %d\n",2-r);
                }
                if(b != 2){
                    str+=String.format("b %d\n",2-b);
                }
                if(n != 2){
                    str+=String.format("n %d\n",2-n);
                }
                if(p != 8){
                    str+=String.format("p %d\n",8-p);
                }break;
            case BLACK:
                int K = captured(s,'K');
                int Q = captured(s,'Q');
                int R = captured(s,'R');
                int B = captured(s,'B');
                int N = captured(s,'N');
                int P = captured(s,'P');
                if(K != 1){
                    str+=String.format("K 1\n");
                }
                if(Q != 1){
                    str+=String.format("Q 1\n");
                }
                if(R != 2){
                    str+=String.format("R %d\n",2-R);
                }
                if(B != 2){
                    str+=String.format("B %d\n",2-B);
                }
                if(N != 2){
                    str+=String.format("N %d\n",2-N);
                }
                if(P != 8){
                    str+=String.format("P %d\n",8-P);
                }break;
        }
        return str;
    }
    public int captured(String s,char name){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.indexOf(name,i);
            if(i == index){count ++;}
        }
        return count;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessColor color = chessComponents[sourceX][sourceY].getChessColor();
        if(!color.equals(currentPlayer)){return false;}

        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        List<ChessboardPoint> canMovePoints = getCanMovePoints(source);
        if(contains(canMovePoints,target)){
            ChessComponent chess = chessComponents[sourceX][sourceY];
            chess.setSource(target);
            chessComponents[targetX][targetY] = chess;

            ChessComponent empty = new EmptySlotComponent();
            empty.setChessColor(ChessColor.NONE);
            empty.setSource(source);
            empty.setName('_');
            chessComponents[sourceX][sourceY] = empty;
            this.currentPlayer = (this.currentPlayer.equals(ChessColor.BLACK)) ? ChessColor.WHITE : ChessColor.BLACK;
            return true;
        }else{
            return false;
        }
    }
    public boolean contains(List<ChessboardPoint> canMovePoints,ChessboardPoint target){
        for (int i = 0; i < canMovePoints.size(); i++) {
            if(canMovePoints.get(i).toString().equals(target.toString())){return true;}
        }return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        chess.setChessComponents(chessComponents);
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        for (int i = 0; i < canMovePoints.size()-1; i++) {
            for (int j = 0; j < canMovePoints.size()-1-i; j++) {
                if(canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX()){
                    Collections.swap(canMovePoints,j,j+1);continue;
                }
                if(canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX() &&
                        canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY()){
                    Collections.swap(canMovePoints,j,j+1);
                }
            }
        }
        return canMovePoints;
    }
}
