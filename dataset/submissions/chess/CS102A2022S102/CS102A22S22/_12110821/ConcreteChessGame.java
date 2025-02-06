import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents ;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    public ChessComponent getChessComponents(int i,int j) {
        return chessComponents[i][j];
    }

    public ConcreteChessGame(){
       this.chessComponents = new ChessComponent[8][8];
        currentPlayer =ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK,'R',i,j,chessComponents);
                        break;
                    case 'N':
                        chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK,'N',i,j,chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK,'B',i,j,chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK,'Q',i,j,chessComponents);
                        break;
                    case 'K':
                        chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK,'K',i,j,chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,'P',i,j,chessComponents);
                        break;
                    case '_':
                        chessComponents[i][j]=new EmptySlotComponent(ChessColor.NONE,'_',i,j,chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE,'r',i,j,chessComponents);
                        break;
                    case 'n':
                        chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE,'n',i,j,chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE,'b',i,j,chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE,'q',i,j,chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE,'k',i,j,chessComponents);
                        break;
                    default:
                        chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,'p',i,j,chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }else {currentPlayer=ChessColor.BLACK;}
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder str=new StringBuilder();
        for (int i=0;i<7;i++){
            for (int j=0;j<8;j++){
                str.append(chessComponents[i][j].name);
            }
            str.append("\n");
        }
        for (int a=0;a<8;a++){
            str.append(chessComponents[7][a].name);
        }
        return str.toString();
    }

    public String getCapturedChess(ChessColor player){
        int K=1;int Q=1;int R=2;int B=2;int N=2;int P=8;
        if (player==ChessColor.BLACK){
            for (ChessComponent[] x: chessComponents){
                for (ChessComponent y:x){
                    switch (y.name){
                        case 'K':
                            K--;
                            break;
                        case 'Q':
                            Q--;
                            break;
                        case 'R':
                            R--;
                            break;
                        case 'B':
                            B--;
                            break;
                        case 'N':
                            N--;
                            break;
                        case 'P':
                            P--;
                            break;
                        default:
                    }
                }
            }
            StringBuilder str=new StringBuilder();
            if (K!=0){
                str.append("K "+K);
                str.append("\n");
            }
            if (Q!=0){
                str.append("Q "+Q);
                str.append("\n");
            }
            if (R!=0){
                str.append("R "+R);
                str.append("\n");
            }
            if (B!=0){
                str.append("B "+B);
                str.append("\n");
            }
            if (N!=0){
                str.append("N "+N);
                str.append("\n");
            }
            if (P!=0){
                str.append("P "+P);
                str.append("\n");
            }
            return str.toString();
        }else{
            for (ChessComponent[] x: chessComponents){
                for (ChessComponent y:x){
                    switch (y.name){
                        case 'k':
                            K--;
                            break;
                        case 'q':
                            Q--;
                            break;
                        case 'r':
                            R--;
                            break;
                        case 'b':
                            B--;
                            break;
                        case 'n':
                            N--;
                            break;
                        case 'p':
                            P--;
                            break;
                        default:
                    }
                }
            }
            StringBuilder str=new StringBuilder();
            if (K!=0){
                str.append("k "+K);
                str.append("\n");
            }
            if (Q!=0){
                str.append("q "+Q);
                str.append("\n");
            }
            if (R!=0){
                str.append("r "+R);
                str.append("\n");
            }
            if (B!=0){
                str.append("b "+B);
                str.append("\n");
            }
            if (N!=0){
                str.append("n "+N);
                str.append("\n");
            }
            if (P!=0){
                str.append("p "+P);
                str.append("\n");
            }
            return str.toString();
        }

    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
   // 1. find chess according to source
   // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
   // 3.sort canMovePoints by x - y ascending order
    /*    Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {

            public int compare(ChessboardPoint a, ChessboardPoint b) {
                int ret = 0;
                try {
                    for (int i = 0; i < canMovePoints.size(); i++) {
                        ret = ListUtils.compareObject(canMovePoints.get(i),true, a.getX(), b.getY());
                        if (0 != ret) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ret;
            }
        });*/
        if (canMovePoints.size()==0){return canMovePoints;}

        Collections.sort(canMovePoints);
        return canMovePoints;

    }
//    class ChessboardPoint implements Comparable<ChessboardPoint> {
//        int x;
//        int y;
//
//        public ChessboardPoint(int x,int y) {
//            this.x=x;
//            this.y=y;
//        }
//
//        @Override
//        public int compareTo(ChessboardPoint other) {
//            if (this.x==other.x){
//                return this.y - other.y;
//            }else return this.x-other.x;
//        }
//    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].name=='_'){
            return false;
        }
        boolean check=false;
        for (ChessboardPoint x:getCanMovePoints(new ChessboardPoint(sourceX,sourceY))){
            if (x.getX()==targetX&&x.getY()==targetY){
                check=true;
                break;
            }
        }
        if (chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){
            if (check){
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,'_',sourceX,sourceY,chessComponents);
                if (currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }else {currentPlayer=ChessColor.WHITE;}
                return true;
            }else {return false;}
        }else {return false;}
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

}
