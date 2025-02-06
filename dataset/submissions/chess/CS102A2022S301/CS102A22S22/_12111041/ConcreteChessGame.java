
import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents=new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessComponents[i][j]=new EmptySlotComponent();
            }
        }
        this.currentPlayer= ChessColor.WHITE;
    }
    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessComponents[i][j]=chessComponents[i][j];
            }
        }
        this.currentPlayer = currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j]=new EmptySlotComponent();
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char c = chessboard.get(i).charAt(j);
                ChessboardPoint p = new ChessboardPoint(i, j);
                switch (c) {
                    case '_':
                        chessComponents[i][j]=new EmptySlotComponent(p, ChessColor.NONE,c);
                        break;
                    case 'K':
                        chessComponents[i][j]=new KingChessComponent(p, ChessColor.BLACK,c);
                        break;
                    case 'k':
                        chessComponents[i][j]=new KingChessComponent(p, ChessColor.WHITE,c);
                        break;
                    case 'Q':
                        chessComponents[i][j]=new QueenChessComponent(p, ChessColor.BLACK,c);
                        break;
                    case 'q':
                        chessComponents[i][j]=new QueenChessComponent(p, ChessColor.WHITE,c);
                        break;
                    case 'B':
                        chessComponents[i][j]=new BishopChessComponent(p, ChessColor.BLACK,c);
                        break;
                    case 'b':
                        chessComponents[i][j]=new BishopChessComponent(p, ChessColor.WHITE,c);
                        break;
                    case 'N':
                        chessComponents[i][j]=new KnightChessComponent(p, ChessColor.BLACK,c);
                        break;
                    case 'n':
                        chessComponents[i][j]=new KnightChessComponent(p, ChessColor.WHITE,c);
                        break;
                    case 'R':
                        chessComponents[i][j]=new RookChessComponent(p, ChessColor.BLACK,c);
                        break;
                    case 'r':
                        chessComponents[i][j]=new RookChessComponent(p, ChessColor.WHITE,c);
                        break;
                    case 'P':
                        chessComponents[i][j]=new PawnChessComponent(p, ChessColor.BLACK,c);
                        break;
                    case 'p':
                        chessComponents[i][j]=new PawnChessComponent(p, ChessColor.WHITE,c);
                        break;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8 ; j++) {
                chessComponents[i][j].setChessComponents(this.chessComponents);
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){
            this.currentPlayer= ChessColor.WHITE;
        }
        else if(chessboard.get(8).charAt(0)=='b'){
            this.currentPlayer= ChessColor.BLACK;
        }
        else this.currentPlayer= ChessColor.NONE;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
    public ChessComponent getChess(ChessboardPoint source){
        if(source.getX()<=7&&source.getX()>=0&&source.getY()<=7&&source.getY()>=0) {
            return chessComponents[source.getX()][source.getY()];
        }
        else return new EmptySlotComponent();
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder s=new StringBuilder();
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                s.append(chessComponents[i][j].toString());
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String graph=getChessboardGraph();
        StringBuilder result=new StringBuilder();
        if(player== ChessColor.BLACK){
            int K=1+graph.replace("K","").length()-graph.length();
            int Q=1+graph.replace("Q","").length()-graph.length();
            int R=2+graph.replace("R","").length()-graph.length();
            int B=2+graph.replace("B","").length()-graph.length();
            int N=2+graph.replace("N","").length()-graph.length();
            int P=8+graph.replace("P","").length()-graph.length();
            if(K!=0){result.append("K "+K+"\n");}
            if(Q!=0){result.append("Q "+Q+"\n");}
            if(R!=0){result.append("R "+R+"\n");}
            if(B!=0){result.append("B "+B+"\n");}
            if(N!=0){result.append("N "+N+"\n");}
            if(P!=0){result.append("P "+P+"\n");}
        }
        if(player== ChessColor.WHITE){
            int k=1+graph.replace("k","").length()-graph.length();
            int q=1+graph.replace("q","").length()-graph.length();
            int r=2+graph.replace("r","").length()-graph.length();
            int b=2+graph.replace("b","").length()-graph.length();
            int n=2+graph.replace("n","").length()-graph.length();
            int p=8+graph.replace("p","").length()-graph.length();
            if(k!=0){result.append("k "+k+"\n");}
            if(q!=0){result.append("q "+q+"\n");}
            if(r!=0){result.append("r "+r+"\n");}
            if(b!=0){result.append("b "+b+"\n");}
            if(n!=0){result.append("n "+n+"\n");}
            if(p!=0){result.append("p "+p+"\n");}
        }
        return result.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return getChess(source).canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint x=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint y=new ChessboardPoint(targetX,targetY);
        ChessComponent a=getChess(x);
        ChessComponent b=getChess(y);
        if(getCurrentPlayer().toString().equals(ChessColor.WHITE.toString())&&Character.isLowerCase(a.name)){
            if (a.canMove(y)) {
                chessComponents[targetX][targetY] = a;
                a.setSource(y);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(x, ChessColor.NONE, '_');
                for (int i = 0; i <8 ; i++) {
                    for (int j = 0; j < 8; j++) {
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                    }
                }
                    this.setCurrentPlayer(ChessColor.BLACK);
                return true;
            } else return false;
        }
        else if(getCurrentPlayer().toString().equals(ChessColor.BLACK.toString())&&Character.isUpperCase(a.name)){
            if (a.canMove(y)) {
                chessComponents[targetX][targetY] = a;
                a.setSource(y);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(x, ChessColor.NONE, '_');
                for (int i = 0; i <8 ; i++) {
                    for (int j = 0; j < 8; j++) {
                        chessComponents[i][j].setChessComponents(this.chessComponents);
                    }
                }
                    this.setCurrentPlayer(ChessColor.WHITE);
                return true;
            } else return false;
        }
        else return false;
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("R_BQK__R");
        list.add("PPPP_PPP");
        list.add("__N_P___");
        list.add("___Np___");
        list.add("__B_p___");
        list.add("___q_n__");
        list.add("ppp__ppp");
        list.add("rnb_kb_r");
        list.add("b");
        ConcreteChessGame game=new ConcreteChessGame();
        game.loadChessGame(list);
        game.moveChess(4,2,5,1);
        System.out.println(game.getCanMovePoints(new ChessboardPoint(4,2)));
        System.out.println(game.getChessboardGraph());
    }
}
