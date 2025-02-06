import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private ChessboardPoint source;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point = new ChessboardPoint(i, j);
                if (chessboard.get(i).charAt(j) == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent(point, ChessColor.BLACK, chessComponents);
                    this.chessComponents[i][j].name = 'R';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent(point, ChessColor.WHITE, chessComponents);
                    this.chessComponents[i][j].name = 'r';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    this.chessComponents[i][j] = new KnightChessComponent(point, ChessColor.BLACK, chessComponents);
                    this.chessComponents[i][j].name = 'N';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent(point, ChessColor.WHITE, chessComponents);
                    this.chessComponents[i][j].name = 'n';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent(point, ChessColor.BLACK, chessComponents);
                    this.chessComponents[i][j].name = 'B';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent(point, ChessColor.WHITE, chessComponents);
                    this.chessComponents[i][j].name = 'b';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent(point, ChessColor.BLACK, chessComponents);
                    this.chessComponents[i][j].name = 'Q';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent(point, ChessColor.WHITE, chessComponents);
                    this.chessComponents[i][j].name = 'q';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent(point, ChessColor.BLACK, chessComponents);
                    this.chessComponents[i][j].name = 'K';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent(point, ChessColor.WHITE, chessComponents);
                    this.chessComponents[i][j].name = 'k';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent(point, ChessColor.BLACK, chessComponents);
                    this.chessComponents[i][j].name = 'P';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent(point, ChessColor.WHITE, chessComponents);
                    this.chessComponents[i][j].name = 'p';
                    this.chessComponents[i][j].setSource(i, j);
                } else if (chessboard.get(i).charAt(j) == '_') {
                    this.chessComponents[i][j] = new EmptySlotComponent(point, ChessColor.NONE);
                    this.chessComponents[i][j].name = '_';
                    this.chessComponents[i][j].setSource(i, j);
                }
            }
        }
        if (Objects.equals(chessboard.get(8), "w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else if (Objects.equals(chessboard.get(8), "b")) {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String s1 = "";
        for (int j = 0; j < 8; j++) {
            s1 = s1 + this.chessComponents[0][j].name;
        }
        String s2 = "";
        for (int j = 0; j < 8; j++) {
            s2 = s2 + this.chessComponents[1][j].name;
        }
        String s3 = "";
        for (int j = 0; j < 8; j++) {
            s3 = s3 + this.chessComponents[2][j].name;
        }
        String s4 = "";
        for (int j = 0; j < 8; j++) {
            s4 = s4 + this.chessComponents[3][j].name;
        }
        String s5 = "";
        for (int j = 0; j < 8; j++) {
            s5 = s5 + this.chessComponents[4][j].name;
        }
        String s6 = "";
        for (int j = 0; j < 8; j++) {
            s6 = s6 + this.chessComponents[5][j].name;
        }
        String s7 = "";
        for (int j = 0; j < 8; j++) {
            s7 = s7 + this.chessComponents[6][j].name;
        }
        String s8 = "";
        for (int j = 0; j < 8; j++) {
            s8 = s8 + this.chessComponents[7][j].name;
        }
        return s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s5 + "\n" + s6 + "\n" + s7 + "\n" + s8;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int countQ = 0;
        int countq = 0;
        int countR = 0;
        int countr = 0;
        int countN = 0;
        int countn = 0;
        int countB = 0;
        int countb = 0;
        int countK = 0;
        int countk = 0;
        int countP = 0;
        int countp = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'Q') {
                    countQ++;
                }
                if (chessComponents[i][j].name == 'q') {
                    countq++;
                }
                if (chessComponents[i][j].name == 'R') {
                    countR++;
                }
                if (chessComponents[i][j].name == 'r') {
                    countr++;
                }
                if (chessComponents[i][j].name == 'N') {
                    countN++;
                }
                if (chessComponents[i][j].name == 'n') {
                    countn++;
                }
                if (chessComponents[i][j].name == 'B') {
                    countB++;
                }
                if (chessComponents[i][j].name == 'b') {
                    countb++;
                }
                if (chessComponents[i][j].name == 'K') {
                    countK++;
                }
                if (chessComponents[i][j].name == 'k') {
                    countk++;
                }
                if (chessComponents[i][j].name == 'P') {
                    countP++;
                }
                if (chessComponents[i][j].name == 'p') {
                    countp++;
                }
            }
        }
        StringBuilder capturedChess1 = new StringBuilder();
        StringBuilder capturedChess2 = new StringBuilder();
        if (countK < 1) {
            capturedChess1.append("K ").append(1 - countK).append("\n");
        }
        if (countQ < 1) {
            capturedChess1.append("Q ").append(1 - countQ).append("\n");
        }
        if (countR < 2) {
            capturedChess1.append("R ").append(2 - countR).append("\n");
        }
        if (countB < 2) {
            capturedChess1.append("B ").append(2 - countB).append("\n");
        }
        if (countN < 2) {
            capturedChess1.append("N ").append(2 - countN).append("\n");
        }
        if (countP < 8) {
            capturedChess1.append("P ").append(8 - countP).append("\n");
        }
        if (countk < 1) {
            capturedChess2.append("k ").append(1 - countk).append("\n");
        }
        if (countq < 1) {
            capturedChess2.append("q ").append(1 - countq).append("\n");
        }
        if (countr < 2) {
            capturedChess2.append("r ").append(2 - countr).append("\n");
        }
        if (countb < 2) {
            capturedChess2.append("b ").append(2 - countb).append("\n");
        }
        if (countn < 2) {
            capturedChess2.append("n ").append(2 - countn).append("\n");
        }
        if (countp < 8) {
            capturedChess2.append("p ").append(8 - countp).append("\n");
        }
        if (player.equals(ChessColor.BLACK)) {
            return capturedChess1.toString();
        } else {
            return capturedChess2.toString();
        }
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> chess = getChess(source.getX(), source.getY()).canMoveTo();
        for (int i = 0; i < chess.size() - 1; i++) {
            for (int j = 0; j < chess.size() - 1 - i; j++) {
                if (chess.get(j).getX() > chess.get(j + 1).getX()) {
                    Collections.swap(chess, j, j + 1);
                } else if (chess.get(j).getX() == chess.get(j + 1).getX()) {
                    if (chess.get(j).getY() > chess.get(j + 1).getY()) {
                        Collections.swap(chess, j, j + 1);
                    }
                }
            }
        }
        return chess;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint s = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint t = new ChessboardPoint(targetX,targetY);
        if(8>targetX && targetX>=0 && targetY>=0 && targetY<8){
            if(currentPlayer != chessComponents[sourceX][sourceY].getChessColor()){
                return false;}
            else{
                char name1 = chessComponents[sourceX][sourceY].name;
                for (int r = 0 ; r < getCanMovePoints(s).size() ; r++){
                    if(getCanMovePoints(s).get(r).getX()==targetX && getCanMovePoints(s).get(r).getY()==targetY){
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(s,ChessColor.NONE);
                        if( name1=='B'){
                            this.chessComponents[targetX][targetY]=new BishopChessComponent(t,ChessColor.BLACK,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='B';
                        }else if(name1 =='b'){ 
                            this.chessComponents[targetX][targetY]=new BishopChessComponent(t,ChessColor.WHITE,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='b';
                        }else if(name1 =='K'){
                            this.chessComponents[targetX][targetY]=new KingChessComponent(t,ChessColor.BLACK,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='K';
                        }else if(name1 =='k'){
                            this.chessComponents[targetX][targetY]=new KingChessComponent(t,ChessColor.WHITE,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='k';
                        }else if(name1=='N'){
                            this.chessComponents[targetX][targetY]=new KnightChessComponent(t,ChessColor.BLACK,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='N';
                        }else if(name1=='n'){
                            this.chessComponents[targetX][targetY]=new KnightChessComponent(t,ChessColor.WHITE,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='n';
                        }else if( name1=='Q'){
                            this.chessComponents[targetX][targetY]=new QueenChessComponent(t,ChessColor.BLACK,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='Q';
                        }else if(name1=='q'){
                            this.chessComponents[targetX][targetY]=new QueenChessComponent(t,ChessColor.WHITE,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='q';
                        }else if(name1=='P'){
                            this.chessComponents[targetX][targetY]=new PawnChessComponent(t,ChessColor.BLACK,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='P';
                        }else if(name1=='p'){
                            this.chessComponents[targetX][targetY]=new PawnChessComponent(t,ChessColor.WHITE,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='p';
                        }else if(name1=='R'){
                            this.chessComponents[targetX][targetY]=new RookChessComponent(t,ChessColor.BLACK,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='R';
                        }else if(name1=='r'){
                            this.chessComponents[targetX][targetY]=new RookChessComponent(t,ChessColor.WHITE,chessComponents);
                            this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                            this.chessComponents[targetX][targetY].name='r';
                        }if(currentPlayer==ChessColor.WHITE){
                            currentPlayer=ChessColor.BLACK;
                        }else{currentPlayer=ChessColor.WHITE;}
                        return true;
                    }
                }
            }
        }return false;
    }
}
