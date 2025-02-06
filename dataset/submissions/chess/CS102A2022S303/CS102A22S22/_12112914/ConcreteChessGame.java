import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    public ChessColor currentPlayer = ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard){

        String[] z = new String[9];
        for (int i = 0; i < 8; i++) {
            z[i] = chessboard.get(i);
        }

        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                char chess = z[i].charAt(j);
                switch (chess){
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent();
                        break;
                    default:
                        break;
                }
            }
        }

        char player = chessboard.get(8).charAt(0);
        if (player == 'w'){currentPlayer = ChessColor.WHITE;} else{currentPlayer = ChessColor.BLACK;}
    }

    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
       return chessComponents[x][y];
    }

    public String getChessboardGraph(){
        String string1 = charToString(chessComponents[0]);
        String string2 = charToString(chessComponents[1]);
        String string3 = charToString(chessComponents[2]);
        String string4 = charToString(chessComponents[3]);
        String string5 = charToString(chessComponents[4]);
        String string6 = charToString(chessComponents[5]);
        String string7 = charToString(chessComponents[6]);
        String string8 = charToString(chessComponents[7]);
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",string1,string2,string3,string4,string5,
                string6,string7,string8);
    }

    public String getCapturedChess(ChessColor player){
        int k=0,q=0,r=0,b=0,n=0,p=0 ;
        ArrayList<String> captureKind = new ArrayList<String>();
        ArrayList<Integer> captureNumber = new ArrayList<Integer>();
        if (player .equals(ChessColor.WHITE)) {
            for (ChessComponent[] chessComponent : chessComponents) {
                for (ChessComponent component : chessComponent) {
                    if (component.name == 'k') {
                        k++;
                    }
                    if (component.name == 'q') {
                        q++;
                    }
                    if (component.name == 'r') {
                        r++;
                    }
                    if (component.name == 'b') {
                        b++;
                    }
                    if (component.name == 'n') {
                        n++;
                    }
                    if (component.name == 'p') {
                        p++;
                    }
                }
            }
        }else {
            for (ChessComponent[] chessComponent : chessComponents) {
                for (ChessComponent component : chessComponent) {
                    if (component.name == 'K') {
                        k++;
                    }
                    if (component.name == 'Q') {
                        q++;
                    }
                    if (component.name == 'R') {
                        r++;
                    }
                    if (component.name == 'B') {
                        b++;
                    }
                    if (component.name == 'N') {
                        n++;
                    }
                    if (component.name == 'P') {
                        p++;
                    }
                }
            }

        }
        if (k<1){
            captureKind.add(new KingChessComponent(player,new ChessboardPoint(0,0)).toString());
            captureNumber.add(1-k);
        }
        if (q<1){
            captureKind.add(new QueenChessComponent(player,new ChessboardPoint(0,0)).toString());
            captureNumber.add(1-q);
        }
        if (r<2){
            captureKind.add(new RookChessComponent(player,new ChessboardPoint(0,0)).toString());
            captureNumber.add(2-r);
        }
        if (b<2){
            captureKind.add(new BishopChessComponent(player,new ChessboardPoint(0,0)).toString());
            captureNumber.add(2-b);
        }
        if (n<2){
            captureKind.add(new KnightChessComponent(player,new ChessboardPoint(0,0)).toString());
            captureNumber.add(2-n);
        }
        if (p<8){
            captureKind.add(new PawnChessComponent(player,new ChessboardPoint(0,0)).toString());
            captureNumber.add(8-p);
        }
        StringBuilder capture = new StringBuilder();
        for (int i = 0; i < captureKind.size(); i++) {
            capture.append(captureKind.get(i));
            capture.append(" ");
            capture.append(captureNumber.get(i)) ;
            capture.append("\n");

        }
        return  String.valueOf(capture);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(),source.getY());
        ChessComponent.chessComponents = chessComponents;
        
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Collections.sort(canMovePoints);
        return canMovePoints;
       
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int doYouHave = 0;
        if(sourceX<0||sourceX>7||sourceY<0||sourceY>7||targetX<0||targetX>7||targetY<0||targetY>7){
            return false;
        }else {
            ChessComponent whichGo = getChess(sourceX, sourceY);
            if (whichGo.getChessColor().equals(currentPlayer)) {
                ChessComponent.chessComponents = chessComponents;
                List<ChessboardPoint> canGo = whichGo.canMoveTo();
                ChessboardPoint goWhere = new ChessboardPoint(targetX, targetY);
                for (int i = 0; i < canGo.size(); i++) {
                   if (canGo.get(i).equals (goWhere)){
                       doYouHave++;
                   }
                }
                if (doYouHave!=0) {
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[targetX][targetY] = whichGo;
                    whichGo.setSource(new ChessboardPoint(targetX, targetY));

                    if (this.currentPlayer.equals(ChessColor.BLACK)) {
                        this.currentPlayer = ChessColor.WHITE;
                    } else if (this.currentPlayer.equals(ChessColor.WHITE)){
                        this.currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                } else {
                    return false;
                }

            } else return false;
        }
    }

    public String charToString(ChessComponent[] ManyChar){
        char[] chars = new char[8];
        for (int i = 0; i < 8; i++) {
            chars[i] = ManyChar[i].name;
        }
        return String.format("%c%c%c%c%c%c%c%c",chars[0],chars[1],chars[2],chars[3],chars[4],chars[5],chars[6],chars[7]);
    }


    public static void main(String[] args){
        List<String> chessboard=new ArrayList<>();
        ConcreteChessGame test=new ConcreteChessGame();
        chessboard.add("N_BQK_rR");
        chessboard.add("PPPPPP_P");
        chessboard.add("_pNnK_P_");
        chessboard.add("Q__NpKr_");
        chessboard.add("_r__KRn_");
        chessboard.add("p_q__Nn_");
        chessboard.add("ppp__ppp");
        chessboard.add("rn_r____");
        chessboard.add("w");
        test.loadChessGame(chessboard);
        test.moveChess(5,2,5,1);
        test.moveChess(3,0,4,0);
        test.moveChess(5,1,4,0);
        System.out.print(test.getChess(4,0).name);

    }


}
