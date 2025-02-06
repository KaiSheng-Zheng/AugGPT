import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer ;
    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            String line =chessboard.get(i);
            for(int j=0;j<8;j++){
                switch (line.charAt(j)){
                    case 'K':
                        chessComponents[i][j]=new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'Q':
                        chessComponents[i][j]=new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'P':
                        chessComponents[i][j]=new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'N':
                        chessComponents[i][j]=new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'R':
                        chessComponents[i][j]=new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'B':
                        chessComponents[i][j]=new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case '_':
                        chessComponents[i][j]=new EmptySlotComponent();
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                        break;
                    case 'k':
                        chessComponents[i][j]=new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'q':
                        chessComponents[i][j]=new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'n':
                        chessComponents[i][j]=new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'p':
                        chessComponents[i][j]=new PawnChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'r':
                        chessComponents[i][j]=new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'b':
                        chessComponents[i][j]=new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                chessComponents[i][j].setName(line.charAt(j));
                chessComponents[i][j].setChessboard(this.chessComponents);
            }

            }
        if(Objects.equals(chessboard.get(8), "w")){
            currentPlayer=ChessColor.WHITE;
        }
        else if(Objects.equals(chessboard.get(8),"b")){
            currentPlayer=ChessColor.BLACK;
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
    public String getChessboardGraph() {
        StringBuilder RE = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                RE.append(chessComponents[i][j].toString());
            }
            RE.append("\n");
        }
        for(int i=0;i<8;i++){
            RE.append(chessComponents[7][i].toString());
        }
        return String.valueOf(RE);
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        char[][] lost = new char[3][6];
        lost[2][0]='k';
        lost[2][1]='q';
        lost[2][2]='r';
        lost[2][3]='b';
        lost[2][4]='n';
        lost[2][5]='p';
        int King = 0;
        int Queen=0;
        int Rook =0;
        int Bishop=0;
        int Knight =0;
        int Pawn=0;
        int king =0;
        int queen=0;
        int rook =0;
        int bishop=0;
        int knight=0;
        int pawn=0;
        for (int i =0;i<8;i++) {
            for(int j=0;j<8;j++) {
                switch(chessComponents[i][j].name){
                    case 'K':
                        King++;
                        break;
                    case 'Q':
                        Queen++;
                        break;
                    case 'P':
                        Pawn++;
                        break;
                    case 'N':
                        Knight++;
                        break;
                    case 'R':
                        Rook++;
                        break;
                    case 'B':
                        Bishop++;
                        break;
                    case '_':
                        break;
                    case 'k':
                        king++;
                        break;
                    case 'q':
                        queen++;
                        break;
                    case 'n':
                        knight++;
                        break;
                    case 'p':
                        pawn++;
                        break;
                    case 'r':
                        rook++;
                        break;
                    case 'b':
                        bishop++;
                        break;
                }
            }
        }
        lost[0][0]= (char) (1-King+48);
        lost[0][1]= (char) (1-Queen+48);
        lost[0][2]= (char) (2-Rook+48);
        lost[0][3]= (char) (2-Bishop+48);
        lost[0][4]= (char) (2-Knight+48);
        lost[0][5]= (char) (8-Pawn+48);
        lost[1][0]= (char) (1-king+48);
        lost[1][1]= (char) (1-queen+48);
        lost[1][2]= (char) (2-rook+48);
        lost[1][3]= (char) (2-bishop+48);
        lost[1][4]= (char) (2-knight+48);
        lost[1][5]= (char) (8-pawn+48);
        StringBuilder re = new StringBuilder();
        if(player==ChessColor.WHITE){
            for(int j =0;j<6;j++){
            if(lost[1][j]!='0'){
                    re.append(lost[2][j]);
                    re.append(" ");
                    re.append(lost[1][j]);
                    re.append("\n");
                }
            }
        }
        if(player==ChessColor.BLACK){
            for(int i =0;i<6;i++){
                if(lost[0][i]!='0') {
                    re.append((char) (lost[2][i] - 32));
                    re.append(" ");
                    re.append(lost[0][i]);
                    re.append("\n");
                }
            }
        }
        return String.valueOf(re);
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess= this.getChess(source.getX(), source.getY());
        return chess.canMoveTo();
    }

   @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        ChessComponent source = this.getChess(sourceX,sourceY);
        boolean player = source.getChessColor()==getCurrentPlayer();
        List<ChessboardPoint>move = source.canMoveTo();
        boolean check= !(source instanceof RookChessComponent) && !(source instanceof KnightChessComponent);
        if(player) {
            if(check){
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                chessComponents[sourceX][sourceY].setName('_');
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                chessComponents[targetX][targetY].setChessColor(source.getChessColor());
                chessComponents[targetX][targetY].setName(source.name);
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY].setChessboard(chessComponents);
                switch (getCurrentPlayer()){
                    case BLACK:
                        currentPlayer=ChessColor.WHITE;
                        break;
                    case WHITE:
                        currentPlayer=ChessColor.BLACK;
                        break;
                }
                return true;
            }
        }
        return false;
    }


}