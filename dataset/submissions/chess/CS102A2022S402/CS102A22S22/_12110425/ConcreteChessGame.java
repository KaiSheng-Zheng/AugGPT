import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ConcreteChessGame(ChessColor currentPlayer) {
        this.chessComponents = new  ChessComponent[8][8];
        this.currentPlayer = currentPlayer;
    }
    public ConcreteChessGame(){}

    @Override
    public void loadChessGame(List<String> chessboard){
        for (int j = 0;j<8;j++){
            for (int i = 0;i<8;i++)
                if (chessboard.get(j).charAt(i)>=65&&chessboard.get(j).charAt(i)<=90){

                    switch (chessboard.get(j).charAt(i)){
                        case 75:{
                            chessComponents[j][i] = new KingChessComponent(chessboard.get(j).charAt(i),ChessColor.BLACK,j,i,chessComponents);
                            break;
                        }
                        case 81:{
                            chessComponents[j][i] = new QueenChessComponent(chessboard.get(j).charAt(i),ChessColor.BLACK,j,i,chessComponents);
                            break;
                        }
                        case 78:{
                            chessComponents[j][i] = new KnightChessComponent(chessboard.get(j).charAt(i),ChessColor.BLACK,j,i,chessComponents);
                            break;
                        }
                        case 80:{
                            chessComponents[j][i] = new PawnChessComponent(chessboard.get(j).charAt(i),ChessColor.BLACK,j,i,chessComponents);
                            break;
                        }
                        case 66:{
                            chessComponents[j][i] = new BishopChessComponent(chessboard.get(j).charAt(i),ChessColor.BLACK,j,i,chessComponents);
                            break;
                        }
                        case 82:{
                            chessComponents[j][i] = new RookChessComponent(chessboard.get(j).charAt(i),ChessColor.BLACK,j,i,chessComponents);
                            break;
                        }
                    }
                    System.out.println(chessComponents[j][i].name);
                }
                else if (chessboard.get(j).charAt(i)>=97&&chessboard.get(j).charAt(i)<=122){
                    switch (chessboard.get(j).charAt(i)){
                        case 107:{
                            chessComponents[j][i] = new KingChessComponent(chessboard.get(j).charAt(i),ChessColor.WHITE,j,i,chessComponents);
                            break;
                        }
                        case 113:{
                            chessComponents[j][i] = new QueenChessComponent(chessboard.get(j).charAt(i),ChessColor.WHITE,j,i,chessComponents);
                            break;
                        }
                        case 110:{
                            chessComponents[j][i] = new KnightChessComponent(chessboard.get(j).charAt(i),ChessColor.WHITE,j,i,chessComponents);
                            break;
                        }
                        case 112:{
                            chessComponents[j][i] = new PawnChessComponent(chessboard.get(j).charAt(i),ChessColor.WHITE,j,i,chessComponents);
                            break;
                        }
                        case 98:{
                            chessComponents[j][i] = new BishopChessComponent(chessboard.get(j).charAt(i),ChessColor.WHITE,j,i,chessComponents);
                            break;
                        }
                        case 114:{
                            chessComponents[j][i] = new RookChessComponent(chessboard.get(j).charAt(i),ChessColor.WHITE,j,i,chessComponents);
                            break;
                        }
                    }
                    System.out.println(chessComponents[j][i].name);
                }else {
                    chessComponents[j][i] = new EmptySlotComponent('_',j,i,chessComponents);
                }
        }
        if (chessboard.get(8).equals("w")){
            this.currentPlayer = ChessColor.WHITE;
        }
        else {
            this.currentPlayer = ChessColor.BLACK;
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
    public String getChessboardGraph(){
        StringBuilder graph = new StringBuilder();
        for (int i = 0;i<8;i++){
            for (int j = 0;j<8;j++){
                graph.append(chessComponents[i][j].name);
            }
            if (i<7)
            graph.append("\n");
        }
        /*if (this.currentPlayer == ChessColor.WHITE){
            graph.append('w');
        }
        else graph.append('b');*/
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K = 0,Q = 0,N = 0,R = 0,B = 0,P = 0;
        StringBuilder lost = new StringBuilder();
        if (player==ChessColor.BLACK){
            for (int i = 0;i<8;i++){
                for (int j = 0;j<8;j++){
                    if (chessComponents[i][j].getChessColor() == player){
                        switch (chessComponents[i][j].name){
                            case 'K':{K++;break;}
                            case 'Q':{Q++;break;}
                            case 'N':{N++;break;}
                            case 'R':{R++;break;}
                            case 'B':{B++;break;}
                            case 'P':{P++;break;}
                            case 'k':{K++;break;}
                            case 'q':{Q++;break;}
                            case 'n':{N++;break;}
                            case 'r':{R++;break;}
                            case 'b':{B++;break;}
                            case 'p':{P++;break;}
                        }
                    }
                }
            }
            if (K<1){
                lost.append('K'+" ");
                lost.append(1-K);
                lost.append("\n");
            }
            if (Q<1){
                lost.append('Q'+" ");
                lost.append(1-Q);
                lost.append("\n");
            }
            if (R<2){
                lost.append('R'+" ");
                lost.append(2-R);
                lost.append("\n");
            }
            if (B<2){
                lost.append('B'+" ");
                lost.append(2-B);
                lost.append("\n");
            }
            if (N<2){
                lost.append('N'+" ");
                lost.append(2-N);
                lost.append("\n");
            }


            if (P<8){
                lost.append('P'+" ");
                lost.append(8-P);
                lost.append("\n");
            }
        }
        else {
            for (int i = 0;i<8;i++){
                for (int j = 0;j<8;j++){
                    if (chessComponents[i][j].getChessColor() == player){
                        switch (chessComponents[i][j].name){
                            case 'K':
                            case 'k': {K++;break;}
                            case 'Q':
                            case 'q': {Q++;break;}
                            case 'N':
                            case 'n': {N++;break;}
                            case 'R':
                            case 'r': {R++;break;}
                            case 'B':
                            case 'b': {B++;break;}
                            case 'P':
                            case 'p': {P++;break;}
                        }
                    }
                }
            }
            if (K<1){
                lost.append('k'+" ");
                lost.append(1-K);
                lost.append("\n");
            }
            if (Q<1){
                lost.append('q'+" ");
                lost.append(1-Q);
                lost.append("\n");
            }
            if (R<2){
                lost.append('r'+" ");
                lost.append(2-R);
                lost.append("\n");
            }
            if (B<2){
                lost.append('b'+" ");
                lost.append(2-B);
                lost.append("\n");
            }
            if (N<2){
                lost.append('n'+" ");
                lost.append(2-N);
                lost.append("\n");
            }


            if (P<8){
                lost.append('p'+" ");
                lost.append(8-P);
                lost.append("\n");
            }
        }
        return lost.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        //System.out.println(getChessboardGraph());
        List<ChessboardPoint> canMoveTo = getChess(source.getX(),source.getY()).canMoveTo();
        for (ChessboardPoint c : canMoveTo){
            System.out.println(c);
        }
        List<ChessboardPoint> NcanMove = new CopyOnWriteArrayList<>(canMoveTo);
        List<ChessboardPoint> last = new ArrayList<>();
        while (NcanMove.size()!=1&&NcanMove.size()!=0){
            ChessboardPoint a = NcanMove.get(0);
            for (ChessboardPoint b : NcanMove){
                if (b.getX()<a.getX()){
                    a=b;
                }
                else if (a.getX()==b.getX()&&a.getY()>b.getY()){
                    a=b;
                }
            }
            last.add(a);

            NcanMove.remove(a);

        }
        if (NcanMove.size()!=0){
        last.add(NcanMove.get(0));
        //System.out.println(getChess(NcanMove.get(0).getX(),NcanMove.get(0).getY()).getChessColor());
        }

        return last;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean can = false;
        if (getChess(sourceX,sourceY).getChessColor()!=getCurrentPlayer()){
            return false;
        }
    
        List<ChessboardPoint> Can = getCanMovePoints(getChess(sourceX,sourceY).getSource());
        ChessComponent soure = getChess(sourceX,sourceY);
        ChessComponent target = getChess(targetX,targetY);
        for (ChessboardPoint e : Can){
            if (e.getX()==targetX&&e.getY() == targetY){
                getChess(sourceX,sourceY).times++;
                chessComponents[targetX][targetY] = soure;
                chessComponents[sourceX][sourceY] = target;
                soure.setSource(targetX,targetY);
                target.setSource(sourceX,sourceY);
                target.setChessColor(ChessColor.NONE);
                target.setName('_');
                can = true;
            
                if (getCurrentPlayer()==ChessColor.WHITE){
                    setCurrentPlayer(ChessColor.BLACK);
                }
                else setCurrentPlayer(ChessColor.WHITE);
                break;
            }
        }


        return can;
    }


    public static void main(String[] args) {
        ConcreteChessGame A = new ConcreteChessGame(ChessColor.WHITE);
        List<String> strings = new ArrayList<>();
        strings.add("_N_QK_NR");
        strings.add("P__P___P");
        strings.add("_______B");
        strings.add("______P_");
        strings.add("________");
        strings.add("_______p");
        strings.add("pp_pppp_");
        strings.add("r_b_k___");
        strings.add("b");
        A.loadChessGame(strings);
        System.out.println("ing");
        for (ChessboardPoint a : A.getChess(1,0).canMoveTo()){
            System.out.println(a);
        }
    
        for (ChessboardPoint a : A.getChess(2,0).canMoveTo()){
            System.out.println(a);
        }

    }
    public boolean hasChess(List<ChessboardPoint> chessboardPoints,int x,int y){
        boolean a = false;
        for (ChessboardPoint e : chessboardPoints){
            if (e.getX()==x&&e.getY()==y){
                a = true;
                break;
            }
        }
        return a;
    }
    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
