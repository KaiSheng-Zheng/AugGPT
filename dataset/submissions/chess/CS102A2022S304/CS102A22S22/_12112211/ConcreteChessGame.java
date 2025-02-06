import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;


    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (Objects.equals(String.valueOf(chessboard.get(8)), "w")) {
            currentPlayer = ChessColor.WHITE;
        }
        if (Objects.equals(String.valueOf(chessboard.get(8)), "b")) {
            currentPlayer = ChessColor.BLACK;
        }
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (chessboard.get(j).charAt(i) == 'B') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    BishopChessComponent B = new BishopChessComponent();
                    B.setChessColor(ChessColor.BLACK);
                    B.setName('B');
                    B.setSource(source);
                    chessComponents[j][i] = B;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }
                if (chessboard.get(j).charAt(i) == 'b') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    BishopChessComponent b = new BishopChessComponent();
                    b.setChessColor(ChessColor.WHITE);
                    b.setName('b');
                    b.setSource(source);
                    chessComponents[j][i] = b;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }


                if (chessboard.get(j).charAt(i) == 'R') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    RookChessComponent R = new RookChessComponent();
                    R.setChessColor(ChessColor.BLACK);
                    R.setName('R');
                    R.setSource(source);
                    chessComponents[j][i] = R;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }
                if (chessboard.get(j).charAt(i) == 'r') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    RookChessComponent r = new RookChessComponent();
                    r.setChessColor(ChessColor.WHITE);
                    r.setName('r');
                    r.setSource(source);
                    chessComponents[j][i] = r;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }


                if (chessboard.get(j).charAt(i) == 'N') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    KnightChessComponent N = new KnightChessComponent();
                    N.setChessColor(ChessColor.BLACK);
                    N.setName('N');
                    N.setSource(source);
                    chessComponents[j][i] = N;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }
                if (chessboard.get(j).charAt(i) == 'n') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    KnightChessComponent n = new KnightChessComponent();
                    n.setChessColor(ChessColor.WHITE);
                    n.setName('n');
                    n.setSource(source);
                    chessComponents[j][i] = n;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }


                if (chessboard.get(j).charAt(i) == 'Q') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    QueenChessComponent Q = new QueenChessComponent();
                    Q.setChessColor(ChessColor.BLACK);
                    Q.setName('Q');
                    Q.setSource(source);
                    chessComponents[j][i] = Q;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }
                if (chessboard.get(j).charAt(i) == 'q') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    QueenChessComponent q = new QueenChessComponent();
                    q.setChessColor(ChessColor.WHITE);
                    q.setName('q');
                    q.setSource(source);
                    chessComponents[j][i] = q;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }


                if (chessboard.get(j).charAt(i) == 'K') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    KingChessComponent K = new KingChessComponent();
                    K.setChessColor(ChessColor.BLACK);
                    K.setName('K');
                    K.setSource(source);
                    chessComponents[j][i] = K;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }
                if (chessboard.get(j).charAt(i) == 'k') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    KingChessComponent k = new KingChessComponent();
                    k.setChessColor(ChessColor.WHITE);
                    k.setName('k');
                    k.setSource(source);
                    chessComponents[j][i] = k;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }


                if (chessboard.get(j).charAt(i) == 'P') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    PawnChessComponent P = new PawnChessComponent();
                    P.setChessColor(ChessColor.BLACK);
                    P.setName('P');
                    P.setSource(source);
                    chessComponents[j][i] = P;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }
                if (chessboard.get(j).charAt(i) == 'p') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    PawnChessComponent p = new PawnChessComponent();
                    p.setChessColor(ChessColor.WHITE);
                    p.setName('p');
                    p.setSource(source);
                    chessComponents[j][i] = p;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
                }

                if (chessboard.get(j).charAt(i) == '_') {
                    ChessboardPoint source = new ChessboardPoint(j, i);
                    EmptySlotComponent none = new EmptySlotComponent();
                    none.setChessColor(ChessColor.NONE);
                    none.setName('_');
                    none.setSource(source);
                    chessComponents[j][i] = none;
                    this.chessComponents[j][i].setChessBoard(this.chessComponents);
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
        StringBuilder ans1 = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ans1.append(chessComponents[i][j].name);
            }
            ans1.append("\n");
        }

        return ans1.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int numOfK = 0;
        int numOfQ = 0;
        int numOfB = 0;
        int numOfN = 0;
        int numOfP = 0;
        int numOfR = 0;

        int numOfk = 0;
        int numOfq = 0;
        int numOfb = 0;
        int numOfp = 0;
        int numOfr = 0;
        int numOfn = 0;
        StringBuilder ans1 = new StringBuilder();
        StringBuilder ans2 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'P') {
                    numOfP++;
                }
                if (chessComponents[i][j].name == 'p') {
                    numOfp++;
                }


                if (chessComponents[i][j].name == 'K') {
                    numOfK++;
                }
                if (chessComponents[i][j].name == 'k') {
                    numOfk++;
                }


                if (chessComponents[i][j].name == 'Q') {
                    numOfQ++;
                }
                if (chessComponents[i][j].name == 'q') {
                    numOfq++;
                }


                if (chessComponents[i][j].name == 'B') {
                    numOfB++;
                }
                if (chessComponents[i][j].name == 'b') {
                    numOfb++;
                }


                if (chessComponents[i][j].name == 'N') {
                    numOfN++;
                }
                if (chessComponents[i][j].name == 'n') {
                    numOfn++;
                }


                if (chessComponents[i][j].name == 'R') {
                    numOfR++;
                }
                if (chessComponents[i][j].name == 'r') {
                    numOfr++;
                }
            }
        }
        if (numOfK < 1){
            numOfK = 1 - numOfK;
            ans1.append("K ").append(numOfK).append("\n");
        }
        if (numOfQ < 1){
            numOfQ = 1 - numOfQ;
            ans1.append("Q ").append(numOfQ).append("\n");
        }
        if (numOfR < 2){
            numOfR = 2 - numOfR;
            ans1.append("R ").append(numOfR).append("\n");
        }
        if (numOfB < 2){
            numOfB = 2 - numOfB;
            ans1.append("B ").append(numOfB).append("\n");
        }
        if (numOfN < 2){
            numOfN = 2 - numOfN;
            ans1.append("N ").append(numOfN).append("\n");
        }
        if (numOfP < 8){
            numOfP = 8 - numOfP;
            ans1.append("P ").append(numOfP).append("\n");
        }



        if (numOfk < 1){
            numOfk = 1 - numOfk;
            ans2.append("k ").append(numOfk).append("\n");
        }

        if (numOfq < 1){
            numOfq = 1 - numOfq;
            ans2.append("q ").append(numOfq).append("\n");
        }

        if (numOfr < 2){
            numOfr = 2- numOfr;
            ans2.append("r ").append(numOfr).append("\n");
        }

        if (numOfb < 2){
            numOfb = 2 - numOfb;
            ans2.append("b ").append(numOfb).append("\n");
        }

        if (numOfn < 2){
            numOfn = 2 - numOfn;
            ans2.append("n ").append(numOfn).append("\n");
        }

        if (numOfp < 8){
            numOfp = 8 - numOfp;
            ans2.append("p ").append(numOfp).append("\n");
        }

        if (player == ChessColor.WHITE){
            return ans2.toString();
        }else {
            return ans1.toString();
        }

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        canMovePoints.sort((point1, point2) -> {
            int temp1 = point1.getX();
            int temp2 = point2.getX();
            if ((temp1-temp2) == 0){
                int temp3 = point1.getY();
                int temp4 = point2.getY();
                return ((temp3 - temp4) >= 0) ? 1 : -1;
            }
            return ((temp1 - temp2) >= 0) ? 1 : -1;
        });

        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
 chessComponents[sourceX][sourceY].loadCurrentChessboard(chessComponents);
        ChessboardPoint source1= new ChessboardPoint(sourceX,sourceY);
        ChessComponent source2 = this.getChess(sourceX,sourceY);
        ArrayList<ChessboardPoint> ans =(ArrayList<ChessboardPoint>) getCanMovePoints(source1);

        ChessboardPoint destination = new ChessboardPoint(targetX,targetY);
        if (currentPlayer==source2.getChessColor() && ans.contains(destination)){
            currentPlayer = (currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE);
            chessComponents[targetX][targetY] = source2;
            chessComponents[targetX][targetY].setSource(destination);
            EmptySlotComponent none1 = new EmptySlotComponent();
            none1.setChessColor(ChessColor.NONE);
            none1.setName('_');
            none1.setSource(source1);
            chessComponents[sourceX][sourceY] = none1;
            return true;
        }else {
            return false;
        }



    }
}

