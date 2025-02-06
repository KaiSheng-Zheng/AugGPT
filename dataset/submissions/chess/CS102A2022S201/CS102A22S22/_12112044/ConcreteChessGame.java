import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8] ;
        currentPlayer = ChessColor.WHITE ;
    }

    public ChessComponent[][] getChessComponents(){
        return chessComponents;
    }

    public void loadChessGame(List<String> chessboard){
        String line;
        char c = ' ';

        for(int i = 0; i < 8 ; i++){
            line = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                c = line.charAt(j);
                ChessboardPoint point = new ChessboardPoint(i,j);

                switch (c){
                    case 'R' :
                        chessComponents[i][j] = new RookChessComponent(point,ChessColor.BLACK,'R',chessComponents);
                        break;
                    case 'r' :
                        chessComponents[i][j] = new RookChessComponent(point,ChessColor.WHITE,'r',chessComponents);
                        break;
                    case 'N' :
                        chessComponents[i][j] = new KnightChessComponent(point,ChessColor.BLACK,'N',chessComponents);
                        break;
                    case 'n' :
                        chessComponents[i][j] = new KnightChessComponent(point,ChessColor.WHITE,'n',chessComponents);
                        break;
                    case 'B' :
                        chessComponents[i][j] = new BishopChessComponent(point,ChessColor.BLACK,'B',chessComponents);
                        break;
                    case 'b' :
                        chessComponents[i][j] = new BishopChessComponent(point,ChessColor.WHITE,'b',chessComponents);
                        break;
                    case 'Q' :
                        chessComponents[i][j] = new QueenChessComponent(point,ChessColor.BLACK,'Q',chessComponents);
                        break;
                    case 'q' :
                        chessComponents[i][j] = new QueenChessComponent(point,ChessColor.WHITE,'q',chessComponents);
                        break;
                    case 'K' :
                        chessComponents[i][j] = new KingChessComponent(point,ChessColor.BLACK,'K',chessComponents);
                        break;
                    case 'k' :
                        chessComponents[i][j] = new KingChessComponent(point,ChessColor.WHITE,'k',chessComponents);
                        break;
                    case 'P' :
                        chessComponents[i][j] = new PawnChessComponent(point,ChessColor.BLACK,'P',chessComponents);
                        break;
                    case 'p' :
                        chessComponents[i][j] = new PawnChessComponent(point,ChessColor.WHITE,'p',chessComponents);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(point,ChessColor.NONE,'_',chessComponents);
                }

            }
        }
        String play = chessboard.get(8);
        if (Objects.equals(play, "b")){
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result.append(chessComponents[i][j].getName());
            }
            if(i==7)break;
            result.append("\n");
        }
        String output = result.toString();

        return output;
    }

    public String getCapturedChess(ChessColor player){
        String Lost = new String();
        if(player.equals(ChessColor.BLACK)){
            StringBuilder LostBlackChess = new StringBuilder();
            int counter_King = 0,counter_Queen = 0,counter_Rooks = 0,counter_Bishops = 0,counter_Knights = 0,counter_Pawns = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].getName() == 'K'){
                        counter_King++;
                    }
                    if(chessComponents[i][j].getName() == 'Q'){
                        counter_Queen++;
                    }
                    if(chessComponents[i][j].getName() == 'R'){
                        counter_Rooks++;
                    }
                    if(chessComponents[i][j].getName() == 'B'){
                        counter_Bishops++;
                    }
                    if(chessComponents[i][j].getName() == 'N'){
                        counter_Knights++;
                    }
                    if(chessComponents[i][j].getName() == 'P'){
                        counter_Pawns++;
                    }
                }
            }
            int lost_King = 1-counter_King;
            int lost_Queen = 1-counter_Queen;
            int lost_Rooks = 2-counter_Rooks;
            int lost_Bishops = 2-counter_Bishops;
            int lost_Knights = 2-counter_Knights;
            int lost_Pawns = 8-counter_Pawns;

            if(lost_King!=0){
                LostBlackChess.append("K ");
                LostBlackChess.append(lost_King);
                LostBlackChess.append("\n");
            }
            if(lost_Queen!=0){
                LostBlackChess.append("Q ");
                LostBlackChess.append(lost_Queen);
                LostBlackChess.append("\n");
            }
            if(lost_Rooks!=0){
                LostBlackChess.append("R ");
                LostBlackChess.append(lost_Rooks);
                LostBlackChess.append("\n");
            }
            if(lost_Bishops!=0){
                LostBlackChess.append("B ");
                LostBlackChess.append(lost_Bishops);
                LostBlackChess.append("\n");
            }
            if(lost_Knights!=0){
                LostBlackChess.append("N ");
                LostBlackChess.append(lost_Knights);
                LostBlackChess.append("\n");
            }
            if(lost_Pawns!=0){
                LostBlackChess.append("P ");
                LostBlackChess.append(lost_Pawns);
                LostBlackChess.append("\n");
            }
            Lost = LostBlackChess.toString();
        }
        else if (player.equals(ChessColor.WHITE)) {
            StringBuilder LostWhiteChess = new StringBuilder();
            int counter_King = 0, counter_Queen = 0, counter_Rooks = 0, counter_Bishops = 0, counter_Knights = 0, counter_Pawns = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'k') {
                        counter_King++;
                    }
                    if (chessComponents[i][j].getName() == 'q') {
                        counter_Queen++;
                    }
                    if (chessComponents[i][j].getName() == 'r') {
                        counter_Rooks++;
                    }
                    if (chessComponents[i][j].getName() == 'b') {
                        counter_Bishops++;
                    }
                    if (chessComponents[i][j].getName() == 'n') {
                        counter_Knights++;
                    }
                    if (chessComponents[i][j].getName() == 'p') {
                        counter_Pawns++;
                    }
                }
            }
            int lost_King = 1 - counter_King;
            int lost_Queen = 1 - counter_Queen;
            int lost_Rooks = 2 - counter_Rooks;
            int lost_Bishops = 2 - counter_Bishops;
            int lost_Knights = 2 - counter_Knights;
            int lost_Pawns = 8 - counter_Pawns;

            if (lost_King != 0) {
                LostWhiteChess.append("k ");
                LostWhiteChess.append(lost_King);
                LostWhiteChess.append("\n");
            }
            if (lost_Queen != 0) {
                LostWhiteChess.append("q ");
                LostWhiteChess.append(lost_Queen);
                LostWhiteChess.append("\n");
            }
            if (lost_Rooks != 0) {
                LostWhiteChess.append("r ");
                LostWhiteChess.append(lost_Rooks);
                LostWhiteChess.append("\n");
            }
            if (lost_Bishops != 0) {
                LostWhiteChess.append("b ");
                LostWhiteChess.append(lost_Bishops);
                LostWhiteChess.append("\n");
            }
            if (lost_Knights != 0) {
                LostWhiteChess.append("n ");
                LostWhiteChess.append(lost_Knights);
                LostWhiteChess.append("\n");
            }
            if (lost_Pawns != 0) {
                LostWhiteChess.append("p ");
                LostWhiteChess.append(lost_Pawns);
                LostWhiteChess.append("\n");
            }
            Lost = LostWhiteChess.toString();
        }
        return Lost;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        List<ChessboardPoint> canMovePoints = getChess(x,y).canMoveTo();
        for (int i = 0; i < canMovePoints.size()-1; i++) {
            for (int j = 0; j < canMovePoints.size()-1-i; j++) {
                if(canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX()){
                    ChessboardPoint original = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,original);
                }
                if(canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX()){
                    for (int k = 0; k < canMovePoints.size()-1; k++) {
                        for (int l = 0; l < canMovePoints.size()-1-i; l++) {
                            if(canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY()){
                                ChessboardPoint original = canMovePoints.get(j);
                                canMovePoints.set(j,canMovePoints.get(j+1));
                                canMovePoints.set(j+1,original);
                            }

                        }

                    }
                }

            }

        }
        return canMovePoints;

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent GetChess = getChess(sourceX,sourceY);
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        List<ChessboardPoint> canMovePoints = getCanMovePoints(source);

        if( targetX >= 0 && targetX <= 7 && targetY >= 0 && targetY <= 7) {
            if (currentPlayer != chessComponents[sourceX][sourceY].getChessColor()){
                return false;
            }
            else {
                for (int i = 0; i < canMovePoints.size(); i++) {
                    if(canMovePoints.get(i).getX() == targetX && canMovePoints.get(i).getY() == targetY){
                        char N1 = chessComponents[sourceX][sourceY].getName();
                        chessComponents[targetX][targetY] = UpdateChess(target,N1);
                        chessComponents[sourceX][sourceY] =new  EmptySlotComponent(source,ChessColor.NONE,'_',chessComponents);

                        if(currentPlayer == ChessColor.BLACK){
                            currentPlayer = ChessColor.WHITE;
                        }
                        else {
                            currentPlayer = ChessColor.BLACK;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public ChessComponent UpdateChess (ChessboardPoint point, char name){
        int i = point.getX();
        int j = point.getY();

        switch (name){
            case 'R' :
                chessComponents[i][j] = new RookChessComponent(point,ChessColor.BLACK,'R',chessComponents);
                break;
            case 'r' :
                chessComponents[i][j] = new RookChessComponent(point,ChessColor.WHITE,'r',chessComponents);
                break;
            case 'N' :
                chessComponents[i][j] = new KnightChessComponent(point,ChessColor.BLACK,'N',chessComponents);
                break;
            case 'n' :
                chessComponents[i][j] = new KnightChessComponent(point,ChessColor.WHITE,'n',chessComponents);
                break;
            case 'B' :
                chessComponents[i][j] = new BishopChessComponent(point,ChessColor.BLACK,'B',chessComponents);
                break;
            case 'b' :
                chessComponents[i][j] = new BishopChessComponent(point,ChessColor.WHITE,'b',chessComponents);
                break;
            case 'Q' :
                chessComponents[i][j] = new QueenChessComponent(point,ChessColor.BLACK,'Q',chessComponents);
                break;
            case 'q' :
                chessComponents[i][j] = new QueenChessComponent(point,ChessColor.WHITE,'q',chessComponents);
                break;
            case 'K' :
                chessComponents[i][j] = new KingChessComponent(point,ChessColor.BLACK,'K',chessComponents);
                break;
            case 'k' :
                chessComponents[i][j] = new KingChessComponent(point,ChessColor.WHITE,'k',chessComponents);
                break;
            case 'P' :
                chessComponents[i][j] = new PawnChessComponent(point,ChessColor.BLACK,'P',chessComponents);
                break;
            case 'p' :
                chessComponents[i][j] = new PawnChessComponent(point,ChessColor.WHITE,'p',chessComponents);
                break;
            case '_':
                chessComponents[i][j] = new EmptySlotComponent(point,ChessColor.NONE,'_',chessComponents);
        }
        return chessComponents[i][j];

    }
}


