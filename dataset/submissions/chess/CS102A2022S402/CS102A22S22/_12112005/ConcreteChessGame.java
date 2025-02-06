import java.util.ArrayList;
import java.util.Arrays;
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
        for (int i = 0; i < 9; i++) {
            if (i < 8) {
                for (int j = 0; j < 8; j++) {
                    if (chessboard.get(i).charAt(j) == 'R') {
                        chessComponents[i][j] = new RookChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('R');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'N') {
                        chessComponents[i][j] = new KnightChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('N');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'B') {
                        chessComponents[i][j] = new BishopChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('B');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'Q') {
                        chessComponents[i][j] = new QueenChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('Q');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'K') {
                        chessComponents[i][j] = new KingChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('K');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'P') {
                        chessComponents[i][j] = new PawnChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('P');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'p') {
                        chessComponents[i][j] = new PawnChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('p');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'r') {
                        chessComponents[i][j] = new RookChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('r');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'n') {
                        chessComponents[i][j] = new KnightChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('n');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));

                    }
                    if (chessboard.get(i).charAt(j) == 'b') {
                        chessComponents[i][j] = new BishopChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('b');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'q') {
                        chessComponents[i][j] = new QueenChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('q');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == 'k') {
                        chessComponents[i][j] = new KingChessComponent(chessComponents, i, j);
                        chessComponents[i][j].setName('k');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                    if (chessboard.get(i).charAt(j) == '_') {
                        chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[i][j].setName('_');
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                    }
                }
            } else {
                if (chessboard.get(8).charAt(0) == 'w') {
                    currentPlayer = ChessColor.WHITE;
                } else if (chessboard.get(8).charAt(0) == 'b') {
                    currentPlayer = ChessColor.BLACK;
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
        if (x >= 0 && y >= 0 && x < 8 && y < 8) {
            return chessComponents[x][y];
        } else return null;
    }


    @Override
    public String getChessboardGraph() {
//        StringBuilder output = new StringBuilder("1");
        String out = "";
        for (int i = 0; i < 8; i++) {
            if (i < 7) {
                for (int j = 0; j < 8; j++) {
//                    output.append(chessComponents[i][j].name);
                    if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                        String str = String.valueOf(chessComponents[i][j].name);
                        out = out + str.toUpperCase();
                    } else {
                        out = out + chessComponents[i][j].getName();
                    }
                }
                out = out + '\n';

            } else {
                for (int j = 0; j < 8; j++) {
//                    output.append(chessComponents[i][j].name);
                    if (chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                        String str = String.valueOf(chessComponents[i][j].name);
                        out = out + str.toUpperCase();
                    } else {
                        out = out + chessComponents[i][j].getName();
                    }
                }
            }
        }
//        output.deleteCharAt(0);
//        return output.toString();
        return out;
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        int Rnum = 0, Nnum = 0, Bnum = 0, Qnum = 0, Knum = 0, Pnum = 0, pnum = 0, rnum = 0, nnum = 0, bnum = 0, qnum = 0, knum = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName() == 'R') {
                    Rnum++;
                }
                if (chessComponents[i][j].getName() == 'N') {
                    Nnum++;
                }
                if (chessComponents[i][j].getName() == 'B') {
                    Bnum++;
                }
                if (chessComponents[i][j].getName() == 'Q') {
                    Qnum++;
                }
                if (chessComponents[i][j].getName() == 'K') {
                    Knum++;
                }
                if (chessComponents[i][j].getName() == 'P') {
                    Pnum++;
                }
                if (chessComponents[i][j].getName() == 'p') {
                    pnum++;
                }
                if (chessComponents[i][j].getName() == 'r') {
                    rnum++;
                }
                if (chessComponents[i][j].getName() == 'n') {
                    nnum++;
                }
                if (chessComponents[i][j].getName() == 'b') {
                    bnum++;
                }
                if (chessComponents[i][j].getName() == 'q') {
                    qnum++;
                }
                if (chessComponents[i][j].getName() == 'k') {
                    knum++;
                }

            }
        }
        int fRnum = 2 - Rnum, fNnum = 2 - Nnum, fBnum = 2 - Bnum, fQnum = 1 - Qnum, fKnum = 1 - Knum, fPnum = 8 - Pnum;
        int frnum = 2 - rnum, fnnum = 2 - nnum, fbnum = 2 - bnum, fqnum = 1 - qnum, fknum = 1 - knum, fpnum = 8 - pnum;
        StringBuilder output = new StringBuilder("1");
        if (player == ChessColor.BLACK) {
            if (fKnum > 0) {
                output.append("K ").append(fKnum).append("\n");
            }
            if (fQnum > 0) {
                output.append("Q ").append(fQnum).append("\n");
            }
            if (fRnum > 0) {
                output.append("R ").append(fRnum).append("\n");
            }
            if (fBnum > 0) {
                output.append("B ").append(fBnum).append("\n");
            }
            if (fNnum > 0) {
                output.append("N ").append(fNnum).append("\n");
            }
            if (fPnum > 0) {
                output.append("P ").append(fPnum).append("\n");
            }
        } else if (player == ChessColor.WHITE) {
            if (fknum > 0) {
                output.append("k ").append(fknum).append("\n");
            }
            if (fqnum > 0) {
                output.append("q ").append(fqnum).append("\n");
            }
            if (frnum > 0) {
                output.append("r ").append(frnum).append("\n");
            }
            if (fbnum > 0) {
                output.append("b ").append(fbnum).append("\n");
            }
            if (fnnum > 0) {
                output.append("n ").append(fnnum).append("\n");
            }
            if (fpnum > 0) {
                output.append("p ").append(fpnum).append("\n");
            }
        }
        output.deleteCharAt(0);
        return output.toString();
    }


    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

//        if(getChess(source.getX(),source.getY()).getName()=='n' || getChess(source.getX(),source.getY()).getName()=='N'){
////            KnightChessComponent knightChessComponent = new KnightChessComponent(chessComponents,source.getX(),source.getY());
////            knightChessComponent.setChessColor(getChess(source.getX(),source.getY()).getChessColor());
////            knightChessComponent.setSource(source);
//
//            return outputlist(chessComponents[source.getX()][source.getY()].canMoveTo());
//        }else if(getChess(source.getX(),source.getY()).getName()=='r' || getChess(source.getX(),source.getY()).getName()=='R'){
//            RookChessComponent rookChessComponent = new RookChessComponent(chessComponents,source.getX(),source.getY());
//            rookChessComponent.setChessColor(getChess(source.getX(),source.getY()).getChessColor());
//            rookChessComponent.setSource(source);
//            return outputlist(rookChessComponent.canMoveTo());
//        }else if(getChess(source.getX(),source.getY()).getName()=='q' || getChess(source.getX(),source.getY()).getName()=='Q'){
//            QueenChessComponent queenChessComponent = new QueenChessComponent(chessComponents,source.getX(),source.getY());
//            queenChessComponent.setChessColor(getChess(source.getX(),source.getY()).getChessColor());
//            queenChessComponent.setSource(source);
//            return outputlist(queenChessComponent.canMoveTo());
//        }else if(getChess(source.getX(),source.getY()).getName()=='p' || getChess(source.getX(),source.getY()).getName()=='P'){
//            PawnChessComponent pawnChessComponent = new PawnChessComponent(chessComponents,source.getX(),source.getY());
//            pawnChessComponent.setChessColor(getChess(source.getX(),source.getY()).getChessColor());
//            pawnChessComponent.setSource(source);
//            return outputlist(pawnChessComponent.canMoveTo());
//        }else if(getChess(source.getX(),source.getY()).getName()=='k' || getChess(source.getX(),source.getY()).getName()=='K'){
//            KingChessComponent kingChessComponent = new KingChessComponent(chessComponents,source.getX(),source.getY());
//            kingChessComponent.setChessColor(getChess(source.getX(),source.getY()).getChessColor());
//            kingChessComponent.setSource(source);
//            return outputlist(kingChessComponent.canMoveTo());
//        }else if(getChess(source.getX(),source.getY()).getName()=='b' || getChess(source.getX(),source.getY()).getName()=='B'){
//            BishopChessComponent bishopChessComponent = new BishopChessComponent(chessComponents,source.getX(),source.getY());
//            bishopChessComponent.setChessColor(getChess(source.getX(),source.getY()).getChessColor());
//            bishopChessComponent.setSource(source);
//            return outputlist(bishopChessComponent.canMoveTo());
//        }


        return outputlist(chessComponents[source.getX()][source.getY()].canMoveTo());


//        MyPoint[] points  = new MyPoint[pointlist.size()];
//        for(int i=0;i<pointlist.size();i++){
//            points[i] = new MyPoint(pointlist.get(i).getX(),pointlist.get(i).getY());
//        }
//        Arrays.sort(points);
//        List<ChessboardPoint> output = new ArrayList<>();
//        for(int i=0;i<pointlist.size();i++){
//            output.add(getChess(points[i].x,points[i].y).getSource());
//        }
//        return output;

    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        int num = 0;

        for (int i = 0; i < getChess(sourceX, sourceY).canMoveTo().size(); i++) {
            if ((getChess(sourceX, sourceY).canMoveTo().get(i)).getX()==targetX && (getChess(sourceX, sourceY).canMoveTo().get(i)).getY()==targetY) {
                num++;
            }
        }

        if(targetX > 7 || targetY > 7 || targetX < 0 || targetY < 0){
            return false;
        }
        if (num == 1 && chessComponents[sourceX][sourceY].getChessColor() == currentPlayer) {

                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();

                if (currentPlayer == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } else currentPlayer = ChessColor.WHITE;
                return true;

        }else return false;


    }




    class MyPoint implements Comparable<MyPoint> {

        public int x;
        public int y;

        public MyPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(MyPoint other) {
            if (this.x > other.x) {
                return 1;
            } else if (this.x < other.x) {
                return -1;
            } else if (this.y > other.y) {
                return 1;
            } else if (this.y < other.y) {
                return -1;
            }
            return 0;
        }

    }

    public List<ChessboardPoint> outputlist(List<ChessboardPoint> pointlist){
        MyPoint[] points  = new MyPoint[pointlist.size()];
        for(int i=0;i<pointlist.size();i++){
            points[i] = new MyPoint(pointlist.get(i).getX(),pointlist.get(i).getY());
        }
        Arrays.sort(points);
        List<ChessboardPoint> output = new ArrayList<>();
        for(int i=0;i<pointlist.size();i++){
            output.add(new ChessboardPoint(points[i].x,points[i].y));
        }
        return output;
    }



}
