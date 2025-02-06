import java.util.*;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
    List<String> chessboard;


    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        switch (chessboard.get(8)) {
            case "w":
                this.currentPlayer = ChessColor.WHITE;
                break;
            case "b":
                this.currentPlayer = ChessColor.BLACK;
                break;
        }
        StringBuilder Boss = new StringBuilder();
        for (String line : chessboard) {
            Boss.append(line);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (Boss.substring(i * 8 + j, i * 8 + j + 1)) {
                    case "R":
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setName('R');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case "K":
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setName('K');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case "N":
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setName('N');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case "B":
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setName('B');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case "Q":
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setName('Q');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case "P":
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setName('P');
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case "r":
                        chessComponents[i][j] = new RookChessComponent();
                        chessComponents[i][j].setName('r');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case "k":
                        chessComponents[i][j] = new KingChessComponent();
                        chessComponents[i][j].setName('k');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case "n":
                        chessComponents[i][j] = new KnightChessComponent();
                        chessComponents[i][j].setName('n');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case "b":
                        chessComponents[i][j] = new BishopChessComponent();
                        chessComponents[i][j].setName('b');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case "q":
                        chessComponents[i][j] = new QueenChessComponent();
                        chessComponents[i][j].setName('q');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case "p":
                        chessComponents[i][j] = new PawnChessComponent();
                        chessComponents[i][j].setName('p');
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case "_":
                        chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[i][j].setName('_');
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        break;
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i, j));
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", chessboard.get(0), chessboard.get(1), chessboard.get(2), chessboard.get(3), chessboard.get(4), chessboard.get(5), chessboard.get(6), chessboard.get(7));

    }

    public String getCapturedChess(ChessColor player) {
        String result = "";
        int KQuantity = 1;
        int QQuantity = 1;
        int RQuantity = 2;
        int BQuantity = 2;
        int NQuantity = 2;
        int PQuantity = 8;
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
//                if (!(chessComponents[i][j] instanceof EmptySlotComponent)) {
//                    chessComponents[i][j].setCount(chessComponents[i][j].getCount() + 1);
//                }
//            }
//        }
//        ArrayList<Integer> result = new ArrayList<>();
//        int k = KingChessComponent.getQuantity() - KingChessComponent.getCount();
//        if (k != 0) result.add(k);
//
//
//        return String.format("%d %d", k,k);
                    switch (chessComponents[i][j].name) {
                        case 'k':
                            KQuantity -= 1;
                            break;
                        case 'q':
                            QQuantity -= 1;
                            break;
                        case 'r':
                            RQuantity -= 1;
                            break;
                        case 'b':
                            BQuantity -= 1;
                            break;
                        case 'n':
                            NQuantity -= 1;
                            break;
                        case 'p':
                            PQuantity -= 1;
                            break;
                    }
                }
            }
            if (KQuantity != 0) result = result + "k " + KQuantity + "\n";
            if (QQuantity != 0) result = result + "q " + QQuantity + "\n";
            if (RQuantity != 0) result = result + "r " + RQuantity + "\n";
            if (BQuantity != 0) result = result + "b " + BQuantity + "\n";
            if (NQuantity != 0) result = result + "n " + NQuantity + "\n";
            if (PQuantity != 0) result = result + "p " + PQuantity + "\n";
            return result;
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'K':
                            KQuantity -= 1;
                            break;
                        case 'Q':
                            QQuantity -= 1;
                            break;
                        case 'R':
                            RQuantity -= 1;
                            break;
                        case 'B':
                            BQuantity -= 1;
                            break;
                        case 'N':
                            NQuantity -= 1;
                            break;
                        case 'P':
                            PQuantity -= 1;
                            break;
                    }
                }
            }
            if (KQuantity != 0) result = result + "K " + KQuantity + "\n";
            if (QQuantity != 0) result = result + "Q " + QQuantity + "\n";
            if (RQuantity != 0) result = result + "R " + RQuantity + "\n";
            if (BQuantity != 0) result = result + "B " + BQuantity + "\n";
            if (NQuantity != 0) result = result + "N " + NQuantity + "\n";
            if (PQuantity != 0) result = result + "P " + PQuantity + "\n";
            return result;
        }
    }

//    class ChessComponentComparator implements Comparator<ChessComponent> {
//        @Override
//        public int compare(ChessComponent o1, ChessComponent o2) {
//            return o1.getStatus() < o2.getStatus() ? -1 : o1.getStatus() == o2.getStatus() ? 0 : 1;
//        }
//    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (this.getChess(sourceX, sourceY).canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
            this.getChess(sourceX, sourceY).setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY]= new EmptySlotComponent();
            chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
            chessComponents[sourceX][sourceY].setName('_');
            chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
            if (this.currentPlayer == ChessColor.WHITE) {
                this.currentPlayer = ChessColor.BLACK;
            } else this.currentPlayer = ChessColor.WHITE;
            return true;
        } else
            return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints, new ChessboardPointComparator());
        return canMovePoints;

    }


    class ChessboardPointComparator implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint o1, ChessboardPoint o2) {
            if (o1.getX() == o2.getX()) {
                return o1.getY() < o2.getY() ? -1 : o1.getY() == o2.getY() ? 0 : 1;
            } else {
                if (o1.getX() < o2.getX()) return -1;
                else return 1;
            }
        }
    }


    class KingChessComponent extends ChessComponent {


        public KingChessComponent() {
            this.setStatus(1);
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> NextMovePoints = new ArrayList<>();
            NextMovePoints.add(this.getSource().offset(1, 0));
            NextMovePoints.add(this.getSource().offset(-1, 0));
            NextMovePoints.add(this.getSource().offset(0, 1));
            NextMovePoints.add(this.getSource().offset(0, -1));
            NextMovePoints.add(this.getSource().offset(1, 1));
            NextMovePoints.add(this.getSource().offset(-1, -1));
            NextMovePoints.add(this.getSource().offset(1, -1));
            NextMovePoints.add(this.getSource().offset(-1, 1));
            NextMovePoints.removeIf(Objects::isNull);
            for (ChessboardPoint xy : NextMovePoints) {
                if (chessComponents[xy.getX()][xy.getY()] instanceof EmptySlotComponent) {
                } else {
                    if (chessComponents[xy.getX()][xy.getY()].getChessColor() == this.getChessColor()) {
                        NextMovePoints.set(NextMovePoints.indexOf(xy), null);
                    } else {
                    }
                }
            }
            NextMovePoints.removeIf(Objects::isNull);
            return NextMovePoints;
        }
    }

    class QueenChessComponent extends ChessComponent {


        public QueenChessComponent() {
            this.setStatus(2);
//            if (super.getName() == 'Q') {
//                this.setChessColor(ChessColor.BLACK);
//            } else {
//                this.setChessColor(ChessColor.WHITE);
//            }
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> NextMovePoints = new ArrayList<>();
//            NextMovePoints.add(this.getSource().offset(1, 0));
//            NextMovePoints.add(this.getSource().offset(-1, 0));
//            NextMovePoints.add(this.getSource().offset(0, 1));
//            NextMovePoints.add(this.getSource().offset(0, -1));
//            NextMovePoints.add(this.getSource().offset(1, 1));
//            NextMovePoints.add(this.getSource().offset(-1, -1));
//            NextMovePoints.add(this.getSource().offset(1, -1));
//            NextMovePoints.add(this.getSource().offset(-1, 1));
//            NextMovePoints.removeIf(Objects::isNull);
//            for (ChessboardPoint xy : NextMovePoints) {
//                if (chessComponents[xy.getX()][xy.getY()] instanceof EmptySlotComponent) {
//                } else {
//                    if (chessComponents[xy.getX()][xy.getY()].getChessColor() == this.getChessColor()) {
//                        NextMovePoints.set(NextMovePoints.indexOf(xy), null);
//                    } else {
//                    }
//                }
//            }
//            NextMovePoints.removeIf(Objects::isNull);
            int[]dx={1,1,-1,-1};
            int[]dy={1,-1,1,-1 };
            for(int i=0;i<4;i++){
                ChessboardPoint a=this.getSource();
                while(true){
//                    ChessboardPoint a=getSource();
                    a=a.offset(dx[i], dy[i]);
                    if(a==null){break;}
                    ChessComponent chessComponent=chessComponents[a.getX()][a.getY()];
                    if (chessComponent.getChessColor() == this.getChessColor()) {
                        break;
                    } NextMovePoints.add(a);
                    if(chessComponent instanceof EmptySlotComponent){}
                    else {break;}

                }}
            int[]dx2={0,0,1,-1};
            int[]dy2={1,-1,0,0};
            for(int i=0;i<4;i++){
                ChessboardPoint a=this.getSource();
                while(true){
//                    ChessboardPoint a=getSource();
                    a=a.offset(dx2[i], dy2[i]);
                    if(a==null){break;}
                    ChessComponent chessComponent=chessComponents[a.getX()][a.getY()];
                    if (chessComponent.getChessColor() == this.getChessColor()) {
                        break;
                    } NextMovePoints.add(a);
                    if(chessComponent instanceof EmptySlotComponent){}
                    else {break;}

                }}
            NextMovePoints.removeIf(Objects::isNull);
            return NextMovePoints;
        }
    }

    class RookChessComponent extends ChessComponent {


        public RookChessComponent() {
            this.setStatus(3);
//            if (super.getName() == 'R') {
//                this.setChessColor(ChessColor.BLACK);
//            } else {
//                this.setChessColor(ChessColor.WHITE);
//            }
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> NextMovePoints = new ArrayList<>();
//            for (int dx2 = 1; dx2 <= 7; dx2++) {
//                ChessboardPoint[] x2 = new ChessboardPoint[]{this.getSource().offset(0, dx2), this.getSource().offset(dx2, 0), this.getSource().offset(0, -dx2), this.getSource().offset(-dx2, 0)};
//                for (ChessboardPoint p : x2
//                ) {if (p != null) {
//                    if (chessComponents[p.getX()][p.getY()] instanceof EmptySlotComponent) {
//                        NextMovePoints.add(p);
//                    } else if (chessComponents[p.getX()][p.getY()].getChessColor() == this.getChessColor()) {
//                        break;
//                    } else {
//                        NextMovePoints.add(p);
//                        break;
//                    }
//                }
//
//                }
//            }
            int[]dx2={0,0,1,-1};
            int[]dy2={1,-1,0,0};
            for(int i=0;i<4;i++){
                ChessboardPoint a=this.getSource();
                while(true){
//                    ChessboardPoint a=getSource();
                            a=a.offset(dx2[i], dy2[i]);
                    if(a==null){break;}
                    ChessComponent chessComponent=chessComponents[a.getX()][a.getY()];
                        if (chessComponent.getChessColor() == this.getChessColor()) {
                            break;
                        } NextMovePoints.add(a);
                        if(chessComponent instanceof EmptySlotComponent){}
                    else {break;}

                }}
            return NextMovePoints;
        }
    }

    class BishopChessComponent extends ChessComponent {

        public BishopChessComponent() {
            this.setStatus(4);
//            if (super.getName() == 'B') {
//                this.setChessColor(ChessColor.BLACK);
//            } else {
//                this.setChessColor(ChessColor.WHITE);
//            }
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> NextMovePoints = new ArrayList<>();
//            for (int dx = -7; dx <= 7; dx++) {
//                ChessboardPoint a=this.getSource().offset(dx, dx);
//                ChessboardPoint b=this.getSource().offset(dx, -dx);
//                if(a!=null){
//                    if (chessComponents[a.getX()][a.getY()] instanceof EmptySlotComponent) {
//                        NextMovePoints.add(a);
//                        if(chessComponents[a.getX()-1][a.getY()-1].getChessColor()==this.getChessColor()){}
//                        else
//                            NextMovePoints.add(this.getSource().offset(dx-1, dx-1));
//                    }}
//                if(b!=null){
//                    if (chessComponents[b.getX()][b.getY()] instanceof EmptySlotComponent) {
//                        NextMovePoints.add(b);
//                        if(chessComponents[b.getX()-1][b.getY()+1].getChessColor()==this.getChessColor()){}
//                        else
//                            NextMovePoints.add(this.getSource().offset(dx-1, dx+1));
//                    }}
//            }
//            for (int dx = 1; dx <= 7; dx++) {
//                ChessboardPoint[] x = new ChessboardPoint[]{this.getSource().offset(dx, dx), this.getSource().offset(dx, -dx), this.getSource().offset(-dx, dx), this.getSource().offset(-dx, -dx)};
//                for (ChessboardPoint p : x
//                ) {
//                    if (p != null) {
//                        if (chessComponents[p.getX()][p.getY()] instanceof EmptySlotComponent) {
//                            NextMovePoints.add(p);
//                        } else if (chessComponents[p.getX()][p.getY()].getChessColor() == this.getChessColor()) {
//                            break;
//                        } else {
//                            NextMovePoints.add(p);
//                            break;
//                        }
//                    }
//                }
//            }
            int[]dx={1,1,-1,-1};
            int[]dy={1,-1,1,-1 };
            for(int i=0;i<4;i++){
                ChessboardPoint a=this.getSource();
                while(true){
//                    ChessboardPoint a=getSource();
                    a=a.offset(dx[i], dy[i]);
                    if(a==null){break;}
                    ChessComponent chessComponent=chessComponents[a.getX()][a.getY()];
                    if (chessComponent.getChessColor() == this.getChessColor()) {
                        break;
                    } NextMovePoints.add(a);
                    if(chessComponent instanceof EmptySlotComponent){}
                    else {break;}

                }}
            return NextMovePoints;
        }
    }

    class PawnChessComponent extends ChessComponent {


        public PawnChessComponent() {
            this.setStatus(6);
//            if (super.getName() == 'P') {
//                this.setChessColor(ChessColor.BLACK);
//            } else {
//                this.setChessColor(ChessColor.WHITE);
//            }
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> NextMovePoints = new ArrayList<>();
            NextMovePoints.add(this.getSource().offset(0, 1));
            NextMovePoints.removeIf(Objects::isNull);
            for (ChessboardPoint xy : NextMovePoints) {
                if (chessComponents[xy.getX()][xy.getY()] instanceof EmptySlotComponent) {
                } else {
                    if (chessComponents[xy.getX()][xy.getY()].getChessColor() == this.getChessColor()) {
                        NextMovePoints.set(NextMovePoints.indexOf(xy), null);
                    } else {
                    }
                }
            }
            NextMovePoints.removeIf(Objects::isNull);
            return NextMovePoints;
        }
    }

    class KnightChessComponent extends ChessComponent {


        public KnightChessComponent() {
            this.setStatus(5);
//            if (super.getName() == 'N') {
//                this.setChessColor(ChessColor.BLACK);
//            } else {
//                this.setChessColor(ChessColor.WHITE);
//            }
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> NextMovePoints = new ArrayList<>();
            NextMovePoints.add(this.getSource().offset(1, 2));
            NextMovePoints.add(this.getSource().offset(2, 1));
            NextMovePoints.add(this.getSource().offset(-2, -1));
            NextMovePoints.add(this.getSource().offset(2, -1));
            NextMovePoints.add(this.getSource().offset(-2, 1));
            NextMovePoints.add(this.getSource().offset(1, -2));
            NextMovePoints.add(this.getSource().offset(-1, 2));
            NextMovePoints.add(this.getSource().offset(-1, -2));
            NextMovePoints.removeIf(Objects::isNull);
            for (ChessboardPoint xy : NextMovePoints) {
                if (chessComponents[xy.getX()][xy.getY()] instanceof EmptySlotComponent) {
                } else {
                    if (chessComponents[xy.getX()][xy.getY()].getChessColor() == this.getChessColor()) {
                        NextMovePoints.set(NextMovePoints.indexOf(xy), null);
                    } else {
                    }
                }
            }
            NextMovePoints.removeIf(Objects::isNull);
            return NextMovePoints;
        }
    }

    class EmptySlotComponent extends ChessComponent {
        public EmptySlotComponent() {
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            return new ArrayList<>();
        }
    }
}
