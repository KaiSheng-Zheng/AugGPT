import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                switch (chessboard.get(i).charAt(j)) {
                    case 'K':
                        this.chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'R':
                        chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'N':
                        chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case '_':
                        chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j), ChessColor.NONE);
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'n':
                        chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                    case 'p':
                        chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessboard(this.chessComponents);
                        break;
                }
            }
            if(chessboard.get(8).equals("w")){
                currentPlayer=ChessColor.WHITE;
            }else {
                currentPlayer=ChessColor.BLACK;
            }
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        String string = "";
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                string = string+chessComponents[i][j].name;
            }
            string += "\n";
        }
        return string;
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder stringBuilder=new StringBuilder();
        int k=0;int q=0;int r=0;int b=0;int n=0;int p=0;
        if (player.equals(ChessColor.BLACK)){
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (chessComponents[i][j].name=='K'){
                        k++;
                    }else if (chessComponents[i][j].name=='Q'){
                        q++;
                    }else if (chessComponents[i][j].name=='R'){
                        r++;
                    }else if (chessComponents[i][j].name=='B'){
                        b++;
                    }else if (chessComponents[i][j].name=='N'){
                        n++;
                    }else if (chessComponents[i][j].name=='P'){
                        p++;
                    }
                }
            }if (k!=1){
                stringBuilder.append("K 1\n");
            }if (q!=1){
                stringBuilder.append("Q 1\n");
            }if (r!=2){
                stringBuilder.append("R ").append(2 - r).append("\n");
            }if (b!=2){
                stringBuilder.append("B ").append(2 - b).append("\n");
            }if (n!=2){
                stringBuilder.append("N ").append(2 - n).append("\n");
            }if (p!=8){
                stringBuilder.append("P ").append(8 - p).append("\n");
            }
        }else {
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (chessComponents[i][j].name=='k'){
                        k++;
                    }else if (chessComponents[i][j].name=='q'){
                        q++;
                    }else if (chessComponents[i][j].name=='r'){
                        r++;
                    }else if (chessComponents[i][j].name=='b'){
                        b++;
                    }else if (chessComponents[i][j].name=='n'){
                        n++;
                    }else if (chessComponents[i][j].name=='p'){
                        p++;
                    }
                }
            }
            if (k!=1){
                stringBuilder.append("k 1\n");
            }if (q!=1){
                stringBuilder.append("q 1\n");
            }if (r!=2){
                stringBuilder.append("r ").append(2 - r).append("\n");
            }if (b!=2){
                stringBuilder.append("b ").append(2 - b).append("\n");
            }if (n!=2){
                stringBuilder.append("n ").append(2 - n).append("\n");
            }if (p!=8){
                stringBuilder.append("p ").append(8 - p).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent c = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> list=new ArrayList<ChessboardPoint>();

        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                for (int k = 0; k < c.canMoveTo().size(); k++) {
                    if (( j== c.canMoveTo().get(k).getY())&&
                            i==c.canMoveTo().get(k).getX()){
                        list.add(c.canMoveTo().get(k));
                    }
                }
            }
        }
        return list;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX, sourceY).getChessColor() == currentPlayer) {
            ChessComponent c = chessComponents[sourceX][sourceY];
            for (int i = 0; i < c.canMoveTo().size(); i++) {
                if ((c.canMoveTo().get(i).getX() == targetX) &&
                        (c.canMoveTo().get(i).getY() == targetY)) {
                    c.setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY]=c;
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
                    if(currentPlayer==ChessColor.WHITE){
                        currentPlayer=ChessColor.BLACK;
                    }else {
                        currentPlayer=ChessColor.WHITE;
                    }return true;
                }
            }
        }return false;
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}
