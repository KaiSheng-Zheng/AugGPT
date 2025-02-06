import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer = ChessColor.WHITE;

    private List<String> chessboard;

    private String strChessboardGraphNone_;

    private Character[] bEl = new Character[]{'K','Q','R','B','N','P'};

    private static HashMap<Character, Integer> bElCount = new HashMap<>();

    private Character[] wEl = new Character[]{'k','q','r','b','n','p'};

    private static HashMap<Character, Integer> wElCount = new HashMap<>();

    private String strChessboardGraph;

    static {
        bElCount.put('K', 1);
        bElCount.put('Q', 1);
        bElCount.put('R', 2);
        bElCount.put('B', 2);
        bElCount.put('N', 2);
        bElCount.put('P', 8);
        wElCount.put('k', 1);
        wElCount.put('q', 1);
        wElCount.put('r', 2);
        wElCount.put('b', 2);
        wElCount.put('n', 2);
        wElCount.put('p', 8);
    }



    public ConcreteChessGame(){

    }



    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        if (this.chessboard.get(8).charAt(0) == 'w'){
            this.currentPlayer = ChessColor.WHITE;
        }else if(this.chessboard.get(8).charAt(0) == 'b') {
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < this.chessboard.size()-1; i++) {
            String s = this.chessboard.get(i);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                switch (c){
                    case 'K':
                        KingChessComponent kcc = new KingChessComponent();
                        kcc.setName(c);
                        kcc.setSource(new ChessboardPoint(i,j));
                        kcc.setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j] = kcc;
                        break;
                    case 'Q':
                        QueenChessComponent qcc = new QueenChessComponent();
                        qcc.setName(c);
                        qcc.setSource(new ChessboardPoint(i, j));
                        qcc.setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j] = qcc;
                        break;
                    case 'R':
                        RookChessComponent rcc = new RookChessComponent();
                        rcc.setName(c);
                        rcc.setSource(new ChessboardPoint(i, j));
                        rcc.setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j] = rcc;
                        break;
                    case 'B':
                        BishopChessComponent bcc = new BishopChessComponent();
                        bcc.setName(c);
                        bcc.setSource(new ChessboardPoint(i, j));
                        bcc.setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j] = bcc;
                        break;
                    case 'N':
                        KnightChessComponent kc = new KnightChessComponent();
                        kc.setName(c);
                        kc.setSource(new ChessboardPoint(i, j));
                        kc.setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j] = kc;
                        break;
                    case 'P':
                        PawnChessComponent pcc = new PawnChessComponent();
                        pcc.setName(c);
                        pcc.setSource(new ChessboardPoint(i, j));
                        pcc.setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j] = pcc;
                        break;
                    case 'k':
                        KingChessComponent kcc2 = new KingChessComponent();
                        kcc2.setName(c);
                        kcc2.setSource(new ChessboardPoint(i, j));
                        kcc2.setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j] = kcc2;
                        break;
                    case 'q':
                        QueenChessComponent qcc2 = new QueenChessComponent();
                        qcc2.setName(c);
                        qcc2.setSource(new ChessboardPoint(i, j));
                        qcc2.setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j] = qcc2;
                        break;
                    case 'r':
                        RookChessComponent rcc2 = new RookChessComponent();
                        rcc2.setName(c);
                        rcc2.setSource(new ChessboardPoint(i, j));
                        rcc2.setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j] = rcc2;
                        break;
                    case 'b':
                        BishopChessComponent bcc2 = new BishopChessComponent();
                        bcc2.setName(c);
                        bcc2.setSource(new ChessboardPoint(i, j));
                        bcc2.setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j] = bcc2;
                        break;
                    case 'n':
                        KnightChessComponent kc2 = new KnightChessComponent();
                        kc2.setName(c);
                        kc2.setSource(new ChessboardPoint(i, j));
                        kc2.setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j] = kc2;
                        break;
                    case 'p':
                        PawnChessComponent pcc2 = new PawnChessComponent();
                        pcc2.setName(c);
                        pcc2.setSource(new ChessboardPoint(i, j));
                        pcc2.setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j] = pcc2;
                        break;
                    default:
                        EmptySlotComponent esc = new EmptySlotComponent();
                        esc.setName(c);
                        esc.setChessColor(ChessColor.NONE);
                        esc.setSource(new ChessboardPoint(i, j));
                        this.chessComponents[i][j] = esc;
                }

            }
        }
        GetChessBoard.chessComponents = this.chessComponents;
        this.strChessboardGraph = chessboard.stream().limit(chessboard.size() - 1).collect(Collectors.joining("\n"));
        this.strChessboardGraphNone_ = strChessboardGraph.replace("_","");
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        return  this.strChessboardGraph;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
//        'K','Q','R','B','N','P'
//        int kNum = 0, qNum = 0,rNum = 0, bNum = 0, nNum = 0, pNum = 0;
        int kk=0,qq=0,rr=0,bb=0,kn=0,pp=0;
        if(player == ChessColor.BLACK) {
            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    if(chessComponents[i][j].name == 'K') kk++;
                    else if(chessComponents[i][j].name == 'Q') qq++;
                    else if(chessComponents[i][j].name == 'R') rr++;
                    else if(chessComponents[i][j].name == 'B') bb++;
                    else if(chessComponents[i][j].name == 'N') kn++;
                    else if(chessComponents[i][j].name == 'P') pp++;
                }
            }
            StringBuffer a = new StringBuffer();
            if(kk!=1) {a.append('K');a.append(' ');a.append('1');a.append("\n");}
            if(qq!=1) {a.append('Q');a.append(' ');a.append('1');a.append("\n");}
            if(rr!=2) {a.append('R');a.append(' ');a.append((char)('0'+2-rr));a.append("\n");}
            if(bb!=2) {a.append('B');a.append(' ');a.append((char)('0'+2-bb));a.append("\n");}
            if(kn!=2) {a.append('N');a.append(' ');a.append((char)('0'+2-kn));a.append("\n");}
            if(pp!=8) {a.append('P');a.append(' ');a.append((char)('0'+8-pp));a.append("\n");}
            String str = a.toString();
            return str;
        }
        else if(player == ChessColor.WHITE) {
            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    if(chessComponents[i][j].name == 'k') kk++;
                    else if(chessComponents[i][j].name == 'q') qq++;
                    else if(chessComponents[i][j].name == 'r') rr++;
                    else if(chessComponents[i][j].name == 'b') bb++;
                    else if(chessComponents[i][j].name == 'n') kn++;
                    else if(chessComponents[i][j].name == 'p') pp++;
                }
            }
            StringBuffer a = new StringBuffer();
            if(kk!=1) {a.append('k');a.append(' ');a.append(1);a.append("\n");}
            if(qq!=1) {a.append('q');a.append(' ');a.append(1);a.append("\n");}
            if(rr!=2) {a.append('r');a.append(' ');a.append(2-rr);a.append("\n");}
            if(bb!=2) {a.append('b');a.append(' ');a.append(2-bb);a.append("\n");}
            if(kn!=2) {a.append('n');a.append(' ');a.append(2-kn);a.append("\n");}
            if(pp!=8) {a.append('p');a.append(' ');a.append(8-pp);a.append("\n");}
            return a.toString();
        }
        return null;
//        if (player.equals(ChessColor.NONE)) return null;
//        StringBuilder sb = new StringBuilder();
//        HashMap<Character,Integer> curCount = new HashMap<>();
//        for (int i = 0; i < this.strChessboardGraphNone_.length(); i++) {
//            char c = this.strChessboardGraphNone_.charAt(i);
//            if(curCount.containsKey(c)){
//                curCount.put(c,curCount.get(c).intValue()+1);
//            }else{
//                curCount.put(c,1);
//            }
//        }
//        if (player.equals(ChessColor.BLACK)){
//            for (int i = 0; i < bEl.length; i++) {
//                Character e = bEl[i];
//                if(!curCount.containsKey(e)){
//                    sb.append(e);
//                    sb.append(" ");
//                    sb.append(bElCount.get(e).intValue());
//                    sb.append("\n");
//                    continue;
//                }
//                int val = bElCount.get(e).intValue() - curCount.get(e).intValue();
//                if(val != 0){
//                    sb.append(e);
//                    sb.append(" ");
//                    sb.append(val);
//                    sb.append("\n");
//                }
//            }
//        }else {
//            for (int i = 0; i < wEl.length; i++) {
//                Character e = wEl[i];
//                if(!curCount.containsKey(e)){
//                    sb.append(e);
//                    sb.append(" ");
//                    sb.append(wElCount.get(e).intValue());
//                    sb.append("\n");
//                    continue;
//                }
//                int val = wElCount.get(e).intValue() - curCount.get(e).intValue();
//                if(val != 0){
//                    sb.append(e);
//                    sb.append(" ");
//                    sb.append(val);
//                    sb.append("\n");
//                }
//            }
//        }
//        return sb.toString();

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent cc = this.chessComponents[source.getX()][source.getY()];
        return cc.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (targetX>7 || targetY>7 ) return false;
        ChessComponent cc = this.chessComponents[sourceX][sourceY];
        if (!cc.getChessColor().equals(getCurrentPlayer())) return false;
        List<ChessboardPoint> chessboardPoints = cc.canMoveTo();
        for (int i = 0; i < chessboardPoints.size(); i++) {
            ChessboardPoint chessboardPoint = chessboardPoints.get(i);
            int x = chessboardPoint.getX();
            int y = chessboardPoint.getY();
            if ((x == targetX && y == targetY)){
                swapLocation(sourceX, sourceY, targetX, targetY);
                this.currentPlayer = getCurrentPlayer().equals(ChessColor.WHITE)?ChessColor.BLACK:ChessColor.WHITE;
                return true;
            }
        }
        return false;
    }


    public void swapLocation(int sourceX, int sourceY, int targetX, int targetY){
        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].name = chessComponents[sourceX][sourceY].name;
        chessComponents[targetX][targetY].setChessColor(chessComponents[sourceX][sourceY].getChessColor());
        chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
        chessComponents[sourceX][sourceY].name = '_';
        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
        chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
    }
}
