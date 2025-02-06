import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r',this);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n',this);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b',this);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q',this);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k',this);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p',this);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R',this);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N',this);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B',this);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q',this);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K',this);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P',this);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_',this);
                        break;
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'b')
            currentPlayer = ChessColor.BLACK;

        loadGameContinue(chessComponents);
    }
    public void loadChessGame1(List<String> chessboard) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r',this);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n',this);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b',this);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q',this);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k',this);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p',this);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R',this);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N',this);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B',this);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q',this);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K',this);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P',this);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_',this);
                        break;
                }
            }
        }

    }
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y) {
        ChessComponent a= this.chessComponents[x][y];
        return a;
    }

    public String getChessboardGraph() {
        StringBuilder s0 = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();
        StringBuilder s4 = new StringBuilder();
        StringBuilder s5 = new StringBuilder();
        StringBuilder s6 = new StringBuilder();
        StringBuilder s7 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s0.append(chessComponents[0][i]);
            s1.append(chessComponents[1][i]);
            s2.append(chessComponents[2][i]);
            s3.append(chessComponents[3][i]);
            s4.append(chessComponents[4][i]);
            s5.append(chessComponents[5][i]);
            s6.append(chessComponents[6][i]);
            s7.append(chessComponents[7][i]);
        }
        return s0 + "\n" + s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s5 + "\n" + s6 + "\n" + s7;
    }
    public ArrayList<String> getChessboardGraph1() {
        ArrayList<String> v=new ArrayList<>();
        StringBuilder s0 = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();
        StringBuilder s4 = new StringBuilder();
        StringBuilder s5 = new StringBuilder();
        StringBuilder s6 = new StringBuilder();
        StringBuilder s7 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s0.append(chessComponents[0][i]);
            s1.append(chessComponents[1][i]);
            s2.append(chessComponents[2][i]);
            s3.append(chessComponents[3][i]);
            s4.append(chessComponents[4][i]);
            s5.append(chessComponents[5][i]);
            s6.append(chessComponents[6][i]);
            s7.append(chessComponents[7][i]);
        }
        v.add(s0.toString());
        v.add(s1.toString());
        v.add(s2.toString());
        v.add(s3.toString());
        v.add(s4.toString());
        v.add(s5.toString());
        v.add(s6.toString());
        v.add(s7.toString());
        return v;
    }

    public int getChessNumber(char name) {
        int a = 0;
        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                if (chessComponents[i][j].name == name) {
                    a++;
                }
            }
        }
        return a;
    }

    public String getCapturedChess(ChessColor player){
        int k=0,q=0,n=0,p=0,b=0,r=0,K=0,Q=0,N=0,P=0,B=0,R=0;
        for (int i=0;i<8;i++)
            for (int j=0;j<8;j++){
                if (chessComponents[i][j].name=='k')k++;
                if (chessComponents[i][j].name=='q')q++;
                if (chessComponents[i][j].name=='n')n++;
                if (chessComponents[i][j].name=='p')p++;
                if (chessComponents[i][j].name=='b')b++;
                if (chessComponents[i][j].name=='r')r++;
                if (chessComponents[i][j].name=='K')K++;
                if (chessComponents[i][j].name=='Q')Q++;
                if (chessComponents[i][j].name=='N')N++;
                if (chessComponents[i][j].name=='P')P++;
                if (chessComponents[i][j].name=='B')B++;
                if (chessComponents[i][j].name=='R')R++;
            }
        String a="";//   K Q R B N P
        if (player==ChessColor.WHITE){
            if (1-k!=0)
                a+="k "+1+"\n";
            if (1-q!=0)
                a+="q "+1+"\n";
            if (2-r==1)
                a+="r "+1+"\n";
            if (2-r==2)
                a+="r "+2+"\n";
            if (2-b==1)
                a+="b "+1+"\n";
            if (2-b==2)
                a+="b "+2+"\n";
            if (2-n==1)
                a+="n "+1+"\n";
            if (2-n==2)
                a+="n "+2+"\n";
            for (int i=1;i<9;i++)
                if (8-p==i)
                    a+="p "+i+"\n";
        } if (player==ChessColor.BLACK){
            if (1-K==1)
                a+="K "+1+"\n";
            if (1-Q==1)
                a+="Q "+1+"\n";
            if (2-R==1)
                a+="R "+1+"\n";
            if (2-R==2)
                a+="R "+2+"\n";
            if (2-B==1)
                a+="B "+1+"\n";
            if (2-B==2)
                a+="B "+2+"\n";
            if (2-N==1)
                a+="N "+1+"\n";
            if (2-N==2)
                a+="N "+2+"\n";
            for (int i=1;i<9;i++)
                if (8-P==i)
                    a+="P "+i+"\n";
        }
        return a;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent start = getChess(sourceX, sourceY);
        ChessComponent end = getChess(targetX,targetY);
        List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
        List<ChessboardPoint> canMove=chessComponents[sourceX][sourceY].canMoveTo();
        int length=canMove.size();
        boolean judgement1=false;
        if (chessComponents[sourceX][sourceY].getChessColor()==getCurrentPlayer()){
            judgement1=true;
        }
        boolean judgement2=false;
        for (int i=0;i<length;i++){
            if (canMove.get(i).getX()==targetX&&canMove.get(i).getY()==targetY){
                judgement2=true;
                break;
            }
        }
        boolean judgement=false;
        if (judgement1&&judgement2){
            judgement=true;
        }

        if (judgement) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].getSource().setX(targetX);
            chessComponents[targetX][targetY].getSource().setY(targetY);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_',this,chessComponents);
            if (this.currentPlayer == ChessColor.WHITE) {
                this.currentPlayer = ChessColor.BLACK;
            } else {
                this.currentPlayer = ChessColor.WHITE;
            }
            loadGameContinue(this.chessComponents);
        }
        return judgement;


    }


    public void loadGameContinue(ChessComponent[][] chessComponent){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                this.chessComponents[i][j].setChessComponents(chessComponent);
            }
        }
    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> possible = new ArrayList<>(chessComponents[source.getX()][source.getY()].canMoveTo());
        possible.sort((o1, o2) -> {
            if (o1.getX() != o2.getX()) {
                return o1.getX() - o2.getX();
            } else {
                if (o1.getY() != o2.getY()) {
                    return o1.getY() - o2.getY();
                } else {
                    return 0;
                }
            }

        });
        return possible;
    }


}
