import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    int OriginalKing = 1;
    int OriginalQueen = 1;
    int OriginalRooks = 2;
    int OriginalBishops = 2;
    int OriginalKnights = 2;
    int OriginalPawns = 8;

    public ChessComponent[][] getChessComponents() {
        ChessComponent[][] c = chessComponents.clone();
        return c;
    }


    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].name = 'K';
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].name = 'Q';
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].name = 'R';
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].name = 'B';
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].name = 'N';
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].name = 'P';
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].name = 'k';
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].name = 'q';
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].name = 'r';
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].name = 'b';
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].name = 'n';
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].name = 'p';
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }
                if (chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].name = '_';
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setChessGame(this);
                    chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                }


            }

        }
        if (chessboard.get(8).charAt(0) == 'w'){
            setCurrentPlayer(ChessColor.WHITE);
        }

        if (chessboard.get(8).charAt(0) == 'b'){
            setCurrentPlayer(ChessColor.BLACK);
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                stringBuilder.append(chessComponents[i][j]);
            }
            stringBuilder.append("\n");

        }
        return String.valueOf(stringBuilder);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int AliveK = 0;
        int AliveQ = 0;
        int AliveR = 0;
        int AliveB = 0;
        int AliveN = 0;
        int AliveP = 0;
        int Alivek = 0;
        int Aliveq = 0;
        int Aliver = 0;
        int Aliveb = 0;
        int Aliven = 0;
        int Alivep = 0;

        if (player.equals(ChessColor.BLACK)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        AliveK++;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        AliveQ++;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        AliveR++;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        AliveB++;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        AliveN++;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        AliveP++;
                    }
                }

            }
            int DeadK = OriginalKing - AliveK;
            int DeadQ = OriginalQueen - AliveQ;
            int DeadR = OriginalRooks - AliveR;
            int DeadB = OriginalBishops - AliveB;
            int DeadN = OriginalKnights - AliveN;
            int DeadP = OriginalPawns - AliveP;
            StringBuilder stringBuilder = new StringBuilder();
            if (DeadK != 0) {
                stringBuilder.append("K ");
                stringBuilder.append(DeadK);
                stringBuilder.append("\n");
            }
            if (DeadQ != 0) {
                stringBuilder.append("Q ");
                stringBuilder.append(DeadQ);
                stringBuilder.append("\n");
            }
            if (DeadR != 0) {
                stringBuilder.append("R ");
                stringBuilder.append(DeadR);
                stringBuilder.append("\n");
            }
            if (DeadB != 0) {
                stringBuilder.append("B ");
                stringBuilder.append(DeadB);
                stringBuilder.append("\n");
            }
            if (DeadN != 0) {
                stringBuilder.append("N ");
                stringBuilder.append(DeadN);
                stringBuilder.append("\n");
            }
            if (DeadP != 0) {
                stringBuilder.append("P ");
                stringBuilder.append(DeadP);
                stringBuilder.append("\n");
            }
            return String.valueOf(stringBuilder);
        }
        if (player.equals(ChessColor.WHITE)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {


                    if (chessComponents[i][j].name == 'k') {
                        Alivek++;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        Aliveq++;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        Aliver++;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        Aliveb++;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        Aliven++;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        Alivep++;
                    }

                }
            }
            int Deadk = OriginalKing - Alivek;
            int Deadq = OriginalQueen - Aliveq;
            int Deadr = OriginalRooks - Aliver;
            int Deadb = OriginalBishops - Aliveb;
            int Deadn = OriginalKnights - Aliven;
            int Deadp = OriginalPawns - Alivep;
            StringBuilder stringBuilder = new StringBuilder();


            if (Deadk != 0) {
                stringBuilder.append("k ");
                stringBuilder.append(Deadk);
                stringBuilder.append("\n");
            }
            if (Deadq != 0) {
                stringBuilder.append("q ");
                stringBuilder.append(Deadq);
                stringBuilder.append("\n");
            }
            if (Deadr != 0) {
                stringBuilder.append("r ");
                stringBuilder.append(Deadr);
                stringBuilder.append("\n");
            }
            if (Deadb != 0) {
                stringBuilder.append("b ");
                stringBuilder.append(Deadb);
                stringBuilder.append("\n");
            }
            if (Deadn != 0) {
                stringBuilder.append("n ");
                stringBuilder.append(Deadn);
                stringBuilder.append("\n");
            }
            if (Deadp != 0) {
                stringBuilder.append("p ");
                stringBuilder.append(Deadp);
                stringBuilder.append("\n");
            }
            return String.valueOf(stringBuilder);

        }
        return null;
    }

    public List<String> getChessBoard(){
        List<String> ovo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ovo.add(Arrays.toString(chessComponents[i])) ;
        }
        return ovo;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> OVO = new ArrayList<>();
        if (this.getChess(source.getX(),source.getY()).canMoveTo().size() != 0){
            for (int i = 0; i < this.getChess(source.getX(),source.getY()).canMoveTo().size(); i++) {
                OVO.add(getChess(source.getX(),source.getY()).canMoveTo().get(i));
                OVO.sort((c1,c2)->Float.compare(c1.getY(),c2.getY()));
                OVO.sort((c1,c2)->Float.compare(c1.getX(),c2.getX()));
            }
        }
        return OVO;

    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean Quincy = false;
        if (this.getChess(sourceX,sourceY).getChessColor() == this.currentPlayer){
            for (int i = 0; i < getChess(sourceX,sourceY).canMoveTo().size(); i++) {
                if (targetX == getChess(sourceX,sourceY).canMoveTo().get(i).getX() &&
                        targetY == getChess(sourceX,sourceY).canMoveTo().get(i).getY()){
                    Quincy = true;
                    break;
                }
            }
        }
        if (this.getChess(sourceX,sourceY).getChessColor() != this.currentPlayer) {
            Quincy = false;
        }
        if (Quincy == true){

            this.chessComponents[targetX][targetY] = this.getChess(sourceX,sourceY);
            this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            this.chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            this.chessComponents[sourceX][sourceY].setName('_');
            this.chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
            ChessComponent.setChessComponents(this.chessComponents);
            if (this.currentPlayer == ChessColor.BLACK) {
                this.setCurrentPlayer(ChessColor.WHITE);
            } else {
                this.setCurrentPlayer(ChessColor.BLACK);
            }
        }
        return Quincy;
    }


}
