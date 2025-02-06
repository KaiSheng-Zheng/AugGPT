import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            String s = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                char a = s.charAt(j);
                switch (a){
                    case ('P') -> chessComponents[i][j] = new PawnChessComponent(a,ChessColor.BLACK,chessComponents,new ChessboardPoint(i,j));
                    case ('p') -> chessComponents[i][j] = new PawnChessComponent(a,ChessColor.WHITE,chessComponents,new ChessboardPoint(i,j));
                    case ('B') -> chessComponents[i][j] = new BishopChessComponent(a,ChessColor.BLACK,chessComponents,new ChessboardPoint(i,j));
                    case ('b') -> chessComponents[i][j] = new BishopChessComponent(a,ChessColor.WHITE,chessComponents,new ChessboardPoint(i,j));
                    case ('N') -> chessComponents[i][j] = new KnightChessComponent(a,ChessColor.BLACK,chessComponents,new ChessboardPoint(i,j));
                    case ('n') -> chessComponents[i][j] = new KnightChessComponent(a,ChessColor.WHITE,chessComponents,new ChessboardPoint(i,j));
                    case ('R') -> chessComponents[i][j] = new RookChessComponent(a,ChessColor.BLACK,chessComponents,new ChessboardPoint(i,j));
                    case ('r') -> chessComponents[i][j] = new RookChessComponent(a,ChessColor.WHITE,chessComponents,new ChessboardPoint(i,j));
                    case ('K') -> chessComponents[i][j] = new KingChessComponent(a,ChessColor.BLACK,chessComponents,new ChessboardPoint(i,j));
                    case ('k') -> chessComponents[i][j] = new KingChessComponent(a,ChessColor.WHITE,chessComponents,new ChessboardPoint(i,j));
                    case ('Q') -> chessComponents[i][j] = new QueenChessComponent(a,ChessColor.BLACK,chessComponents,new ChessboardPoint(i,j));
                    case ('q') -> chessComponents[i][j] = new QueenChessComponent(a,ChessColor.WHITE,chessComponents,new ChessboardPoint(i,j));
                    default -> chessComponents[i][j] = new EmptySlotComponent(a,ChessColor.NONE,chessComponents,new ChessboardPoint(i,j));
            }
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer =  ChessColor.WHITE;
        }else if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer = ChessColor.BLACK;
        }
    }


@Override
    public ChessColor getCurrentPlayer () {
        return this.currentPlayer;
    }
@Override
    public String getChessboardGraph(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                s.append(chessComponents[i][j].name);
            }
            s.append("\n");
        }
        return s.toString();
    }
@Override
    public String getCapturedChess(ChessColor player){
        int[] count = new int[6];
        String s = getChessboardGraph();
        String result;
        if(player==ChessColor.BLACK){
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='K'){
                    count[0]++;
                }
                if(s.charAt(i)=='Q'){
                    count[1]++;
                }
                if(s.charAt(i)=='R'){
                    count[2]++;
                }
                if(s.charAt(i)=='B'){
                    count[3]++;
                }
                if(s.charAt(i)=='N'){
                    count[4]++;
                }
                if(s.charAt(i)=='P'){
                    count[5]++;
                }
            }
            String str1 = "";String str2 = "";String str3 = "";String str4 = "";String str5 = "";String str6 = "";
            if(count[0]==0){
                str1 = "K 1"+"\n";
            }
            if(count[1]==0){
                str2 = "Q 1"+"\n";
            }
            if(count[2]!=2){
                int a = 2-count[2];
                str3 = "R "+a+"\n";
            }
            if(count[3]!=2){
                int a = 2-count[3];
                str4 = "B "+a+"\n";
            }
            if(count[4]!=2){
                int a = 2-count[4];
                str5 = "N "+a+"\n";
            }
            if(count[5]!=8){
                int a = 8-count[5];
                str6 = "P "+a+"\n";
            }result = str1+str2+str3+str4+str5+str6;
        }
        else{
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='k'){
                    count[0]++;
                }
                if(s.charAt(i)=='q'){
                    count[1]++;
                }
                if(s.charAt(i)=='r'){
                    count[2]++;
                }
                if(s.charAt(i)=='b'){
                    count[3]++;
                }
                if(s.charAt(i)=='n'){
                    count[4]++;
                }
                if(s.charAt(i)=='p'){
                    count[5]++;
                }
            }
            String str1 = "";String str2 = "";String str3 = "";String str4 = "";String str5 = "";String str6 = "";
            if(count[0]==0){
                str1 = "k 1"+"\n";
            }
            if(count[1]==0){
                str2 = "q 1"+"\n";
            }
            if(count[2]!=2){
                int a = 2-count[2];
                str3 = "r "+a+"\n";
            }
            if(count[3]!=2){
                int a = 2-count[3];
                str4 = "b "+a+"\n";
            }
            if(count[4]!=2){
                int a = 2-count[4];
                str5 = "n "+a+"\n";
            }
            if(count[5]!=8){
                int a = 8-count[5];
                str6 = "p "+a+"\n";
            }result = str1+str2+str3+str4+str5+str6;
        }return result;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean A = false;
        if (getChess(sourceX, sourceY).getChessColor() == getCurrentPlayer()) {
            A = true;
        }
           
        List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
        if (A&&move.size() != 0) {
            for (int n = 0; n < move.size(); n++) {
                if (move.get(n).getX() == targetX && move.get(n).getY() == targetY) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', ChessColor.NONE, chessComponents, new ChessboardPoint(sourceX, sourceY));
                    if(getCurrentPlayer()==ChessColor.BLACK){
                       currentPlayer=ChessColor.WHITE;
                    }else if(getCurrentPlayer()==ChessColor.WHITE){
                        currentPlayer = ChessColor.BLACK;
                    }
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            switch (chessComponents[i][j].name) {
                                case ('P') -> chessComponents[i][j] = new PawnChessComponent('P', ChessColor.BLACK, chessComponents, new ChessboardPoint(i, j));
                                case ('p') -> chessComponents[i][j] = new PawnChessComponent('p', ChessColor.WHITE, chessComponents, new ChessboardPoint(i, j));
                                case ('B') -> chessComponents[i][j] = new BishopChessComponent('B', ChessColor.BLACK, chessComponents, new ChessboardPoint(i, j));
                                case ('b') -> chessComponents[i][j] = new BishopChessComponent('b', ChessColor.WHITE, chessComponents, new ChessboardPoint(i, j));
                                case ('N') -> chessComponents[i][j] = new KnightChessComponent('N', ChessColor.BLACK, chessComponents, new ChessboardPoint(i, j));
                                case ('n') -> chessComponents[i][j] = new KnightChessComponent('n', ChessColor.WHITE, chessComponents, new ChessboardPoint(i, j));
                                case ('R') -> chessComponents[i][j] = new RookChessComponent('R', ChessColor.BLACK, chessComponents, new ChessboardPoint(i, j));
                                case ('r') -> chessComponents[i][j] = new RookChessComponent('r', ChessColor.WHITE, chessComponents, new ChessboardPoint(i, j));
                                case ('K') -> chessComponents[i][j] = new KingChessComponent('K', ChessColor.BLACK, chessComponents, new ChessboardPoint(i, j));
                                case ('k') -> chessComponents[i][j] = new KingChessComponent('k', ChessColor.WHITE, chessComponents, new ChessboardPoint(i, j));
                                case ('Q') -> chessComponents[i][j] = new QueenChessComponent('Q', ChessColor.BLACK, chessComponents, new ChessboardPoint(i, j));
                                case ('q') -> chessComponents[i][j] = new QueenChessComponent('q', ChessColor.WHITE, chessComponents, new ChessboardPoint(i, j));
                                default -> chessComponents[i][j] = new EmptySlotComponent('_', ChessColor.NONE, chessComponents, new ChessboardPoint(i, j));
                            }
                        }
                    }
                    return true;
                }
            }
        } return false;
    }
@Override
    public ChessComponent getChess(int x, int y){

        return chessComponents[x][y];
    }

@Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chess = getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Mypoint[]points =new Mypoint[chess.canMoveTo().size()];
        for (int i = 0; i < chess.canMoveTo().size(); i++) {
            points[i]= new Mypoint(chess.canMoveTo().get(i).getX(),chess.canMoveTo().get(i).getY());
        }
        Arrays.sort(points);
        for (int i = 0; i < chess.canMoveTo().size(); i++) {
            canMovePoints.set(i,new ChessboardPoint(points[i].x,points[i].y));
        }
        return canMovePoints;
    }

    class Mypoint implements Comparable<Mypoint>{
        public int x;public int y;
        public  Mypoint(int x,int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Mypoint other){
            if(this.x>other.x){
                return 1;
            }else if(this.x<other.x){
                return -1;
            }else if(this.y> other.y){
                return 1;
            }else if(this.y<other.y){
                return -1;
            }return 0;
        }
    }

 }