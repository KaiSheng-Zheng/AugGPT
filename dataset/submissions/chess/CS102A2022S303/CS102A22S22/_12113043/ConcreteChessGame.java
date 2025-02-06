import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char A = chessboard.get(i).charAt(j);
                if (A == 'R') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j]= new RookChessComponent(C1 ,ChessColor.BLACK,'R');
                    chessComponents[i][j].setChessboard(this.chessComponents);

                }
                if (A == 'r') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j]= new RookChessComponent(C1,ChessColor.WHITE,'r');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == 'N') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j] = new KnightChessComponent(C1,ChessColor.BLACK,'N');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == 'n') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j]= new KnightChessComponent(C1,ChessColor.WHITE,'n');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == 'B') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j]= new BishopChessComponent(C1,ChessColor.BLACK,'B');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == 'b') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j]= new BishopChessComponent(C1,ChessColor.WHITE,'b');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == 'Q') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j] = new QueenChessComponent(C1,ChessColor.BLACK,'Q');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == 'q') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j]= new QueenChessComponent(C1,ChessColor.WHITE,'q');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == 'K') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j]= new KingChessComponent(C1,ChessColor.BLACK,'K');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == 'k') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j] = new KingChessComponent(C1,ChessColor.WHITE,'k');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == 'P') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j]= new PawnChessComponent(C1,ChessColor.BLACK,'P');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == 'p') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j]= new PawnChessComponent(C1,ChessColor.WHITE,'p');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (A == '_') {
                    ChessboardPoint C1=new ChessboardPoint(i,j);
                    chessComponents[i][j]= new EmptySlotComponent(C1,ChessColor.NONE,'_');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            return chessComponents[x][y];
        } else {
            return null;
        }
    }


    @Override
    public String getChessboardGraph() {
            StringBuilder C1=new StringBuilder();
            StringBuilder C2=new StringBuilder();
            StringBuilder C3=new StringBuilder();
            StringBuilder C4=new StringBuilder();
            StringBuilder C5=new StringBuilder();
            StringBuilder C6=new StringBuilder();
            StringBuilder C7=new StringBuilder();
            StringBuilder C8=new StringBuilder();
            for (int i = 0; i <8 ; i++) {
            C1.append(chessComponents[0][i].name);
            C2.append(chessComponents[1][i].name);
            C3.append(chessComponents[2][i].name);
            C4.append(chessComponents[3][i].name);
            C5.append(chessComponents[4][i].name);
            C6.append(chessComponents[5][i].name);
            C7.append(chessComponents[6][i].name);
            C8.append(chessComponents[7][i].name);
            }
            String S1= String.valueOf(C1);
            String S2= String.valueOf(C2);
            String S3= String.valueOf(C3);
            String S4= String.valueOf(C4);
            String S5= String.valueOf(C5);
            String S6= String.valueOf(C6);
            String S7= String.valueOf(C7);
            String S8= String.valueOf(C8);
            return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",S1,S2,S3,S4,S5,S6,S7,S8);
        }


    @Override
    public String getCapturedChess(ChessColor player) {
        if (player == ChessColor.BLACK) {
            int countK = 0;
            int countQ = 0;
            int countR = 0;
            int countB = 0;
            int countN = 0;
            int countP = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        countK++;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        countQ++;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        countR++;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        countB++;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        countN++;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        countP++;
                    }
                }
            }
            StringBuilder output = new StringBuilder();
            if (countK < 1) {
                output.append("K 1\n");
            }
            if (countQ < 1) {
                output.append("Q 1\n");
            }
            if (countR < 2) {
                output.append(String.format("R %d\n", 2 - countR));
            }
            if (countB < 2) {
                output.append(String.format("B %d\n", 2 - countB));
            }
            if (countN < 2) {
                output.append(String.format("N %d\n", 2 - countN));
            }
            if (countP < 8) {
                output.append(String.format("P %d\n", 8 - countP));
            }
            String Out = String.valueOf(output);
            return Out;
        }
        if (player == ChessColor.WHITE) {
            int countK = 0;
            int countQ = 0;
            int countR = 0;
            int countB = 0;
            int countN = 0;
            int countP = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        countK++;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        countQ++;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        countR++;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        countB++;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        countN++;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        countP++;
                    }
                }
            }
            StringBuilder output = new StringBuilder();
            if (countK < 1) {
                output.append("k 1\n");
            }
            if (countQ < 1) {
                output.append("q 1\n");
            }
            if (countR < 2) {
                output.append(String.format("r %d\n", 2 - countR));
            }
            if (countB < 2) {
                output.append(String.format("b %d\n", 2 - countB));
            }
            if (countN < 2) {
                output.append(String.format("n %d\n", 2 - countN));
            }
            if (countP < 8) {
                output.append(String.format("p %d\n", 8 - countP));
            }
            String Out = String.valueOf(output);
            return Out;
        }
        return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        if (canMovePoints.isEmpty()) {
            return new ArrayList<>();
        }else {
            canMovePoints.sort(new SortbyXY());
            return canMovePoints;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=this.getChess(sourceX,sourceY);
        if (chess.getChessColor() == ChessColor.NONE) {
            return false;
        } else if (chess.getChessColor()!= getCurrentPlayer()) {
            return false;
        } else {
            List<ChessboardPoint> canmoveto=chess.canMoveTo();
            int T=0;
            for (ChessboardPoint A:canmoveto) {
                if (A.getX() == targetX && A.getY() == targetY) {
                    T++;
                }
            }
                if (T==1){
                    ChessComponent source = getChess(sourceX,sourceY);
                    source.setSource(new ChessboardPoint(targetX,targetY));
                    this.chessComponents[targetX][targetY] = source;
                    ChessComponent destination = new EmptySlotComponent();
                    destination.setSource(new ChessboardPoint(sourceX,sourceY));
                    this.chessComponents[sourceX][sourceY] = destination;
                    if (getCurrentPlayer()==ChessColor.WHITE){
                        setCurrentPlayer(ChessColor.BLACK);
                    }else {
                        setCurrentPlayer(ChessColor.WHITE);
                    }
                    return true;
                }else {
                    return false;
                }
            }
    }
    class SortbyXY implements Comparator<ChessboardPoint>{
        @Override
        public int compare(ChessboardPoint o1,ChessboardPoint o2){
            if (o1.getX()!=o2.getX()){
                return (int) (o1.getX()-o2.getX());
            }else {
                return (int) (o1.getY()-o2.getY());
            }
        }
    }

}

