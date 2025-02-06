import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;


    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;


    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i<8; i++){
            for (int y = 0; y<8; y++){
                ChessboardPoint chessboardPoint = new ChessboardPoint(i,y);
                if (chessboard.get(i).charAt(y) == 'p'){
                    chessComponents[i][y] = new PawnChessComponent();
                    chessComponents[i][y].setName('p');
                    chessComponents[i][y].setChessColor(ChessColor.WHITE);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'P'){
                    chessComponents[i][y] = new PawnChessComponent();
                    chessComponents[i][y].setName('P');
                    chessComponents[i][y].setChessColor(ChessColor.BLACK);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'q'){
                    chessComponents[i][y] = new QueenChessComponent();
                    chessComponents[i][y].setName('q');
                    chessComponents[i][y].setChessColor(ChessColor.WHITE);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'Q'){
                    chessComponents[i][y] = new QueenChessComponent();
                    chessComponents[i][y].setName('Q');
                    chessComponents[i][y].setChessColor(ChessColor.BLACK);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'k'){
                    chessComponents[i][y] = new KingChessComponent();
                    chessComponents[i][y].setName('k');
                    chessComponents[i][y].setChessColor(ChessColor.WHITE);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'K'){
                    chessComponents[i][y] = new KingChessComponent();
                    chessComponents[i][y].setName('K');
                    chessComponents[i][y].setChessColor(ChessColor.BLACK);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'r'){
                    chessComponents[i][y] = new RookChessComponent();
                    chessComponents[i][y].setName('r');
                    chessComponents[i][y].setChessColor(ChessColor.WHITE);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'R'){
                    chessComponents[i][y] = new RookChessComponent();
                    chessComponents[i][y].setName('R');
                    chessComponents[i][y].setChessColor(ChessColor.BLACK);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'n'){
                    chessComponents[i][y] = new KnightChessComponent();
                    chessComponents[i][y].setName('n');
                    chessComponents[i][y].setChessColor(ChessColor.WHITE);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'N'){
                    chessComponents[i][y] = new KnightChessComponent();
                    chessComponents[i][y].setName('N');
                    chessComponents[i][y].setChessColor(ChessColor.BLACK);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'b'){
                    chessComponents[i][y] = new BishopChessComponent();
                    chessComponents[i][y].setName('b');
                    chessComponents[i][y].setChessColor(ChessColor.WHITE);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == 'B'){
                    chessComponents[i][y] = new BishopChessComponent();
                    chessComponents[i][y].setName('B');
                    chessComponents[i][y].setChessColor(ChessColor.BLACK);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
                if (chessboard.get(i).charAt(y) == '_'){
                    chessComponents[i][y] = new EmptySlotComponent();
                    chessComponents[i][y].setName('_');
                    chessComponents[i][y].setChessColor(ChessColor.NONE);
                    chessComponents[i][y].setSource(chessboardPoint);
                }
            }
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
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder str3 = new StringBuilder();
        StringBuilder str4 = new StringBuilder();
        StringBuilder str5 = new StringBuilder();
        StringBuilder str6 = new StringBuilder();
        StringBuilder str7 = new StringBuilder();
        StringBuilder str8 = new StringBuilder();
        for (int i = 0; i<8; i++){
            str1.append(chessComponents[0][i]);
        }
        for (int i = 0; i<8; i++){
            str2.append(chessComponents[1][i]);
        }
        for (int i = 0; i<8; i++){
            str3.append(chessComponents[2][i]);
        }
        for (int i = 0; i<8; i++){
            str4.append(chessComponents[3][i]);
        }
        for (int i = 0; i<8; i++){
            str5.append(chessComponents[4][i]);
        }
        for (int i = 0; i<8; i++){
            str6.append(chessComponents[5][i]);
        }
        for (int i = 0; i<8; i++){
            str7.append(chessComponents[6][i]);
        }
        for (int i = 0; i<8; i++){
            str8.append(chessComponents[7][i]);
        }
        return str1+"\n"+str2+"\n"+str3+"\n"+str4+"\n"+str5+"\n"+str6+"\n"+str7+"\n"+str8;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int counter1 = 1;
        int counter2 = 1;
        int counter3 = 2;
        int counter4 = 2;
        int counter5 = 2;
        int counter6 = 8;
        StringBuilder str = new StringBuilder();
        if (player == ChessColor.WHITE){
            for (int i = 0; i<8; i++){
                for (int y = 0; y<8; y++){
                    if (chessComponents[i][y].getName() == 'k'){
                        counter1--;
                    }
                    if (chessComponents[i][y].getName() == 'q'){
                        counter2--;
                    }
                    if (chessComponents[i][y].getName() == 'r'){
                        counter3--;
                    }
                    if (chessComponents[i][y].getName() == 'b'){
                        counter4--;
                    }
                    if (chessComponents[i][y].getName() == 'n'){
                        counter5--;
                    }
                    if (chessComponents[i][y].getName() == 'p'){
                        counter6--;
                    }
                }
            }
        }
        if (player == ChessColor.BLACK){
            for (int i = 0; i<8; i++){
                for (int y = 0; y<8; y++){
                    if (chessComponents[i][y].getName() == 'K'){
                        counter1--;
                    }
                    if (chessComponents[i][y].getName() == 'Q'){
                        counter2--;
                    }
                    if (chessComponents[i][y].getName() == 'R'){
                        counter3--;
                    }
                    if (chessComponents[i][y].getName() == 'B'){
                        counter4--;
                    }
                    if (chessComponents[i][y].getName() == 'N'){
                        counter5--;
                    }
                    if (chessComponents[i][y].getName() == 'P'){
                        counter6--;
                    }
                }
            }
        }
        if (player == ChessColor.WHITE){
            if (counter1>0){
                str.append("k ").append(counter1).append("\n");
            }
            if (counter2>0){
                str.append("q ").append(counter2).append("\n");
            }
            if (counter3>0){
                str.append("r ").append(counter3).append("\n");
            }
            if (counter4>0){
                str.append("b ").append(counter4).append("\n");
            }
            if (counter5>0){
                str.append("n ").append(counter5).append("\n");
            }
            if (counter6>0){
                str.append("p ").append(counter6).append("\n");
            }
        }
        if (player == ChessColor.BLACK){
            if (counter1>0){
                str.append("K ").append(counter1).append("\n");
            }
            if (counter2>0){
                str.append("Q ").append(counter2).append("\n");
            }
            if (counter3>0){
                str.append("R ").append(counter3).append("\n");
            }
            if (counter4>0){
                str.append("B ").append(counter4).append("\n");
            }
            if (counter5>0){
                str.append("N ").append(counter5).append("\n");
            }
            if (counter6>0){
                str.append("P ").append(counter6).append("\n");
            }
        }
        return str.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> c ;
        int x  = source.getX();
        int y = source.getY();
        c = chessComponents[x][y].canMoveTo();
        List<ChessboardPoint> a = new ArrayList<>() ;
        if (c.size() == 0){
            for (int i = 0; i<8; i++){
                for (int j = 0; j<8; j++){
                    if (move(x,y,i,j)){
                        a.add(new ChessboardPoint(i,j));
                    }
                }
            }
            return a;
        }
        else {
            return c;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
        if (chessComponents[sourceX][sourceY].getName() == '_'){
            return false;
        }
        if (currentPlayer == ChessColor.WHITE){
            if (chessComponents[sourceX][sourceY].getName() == 'k'){
                if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) || (Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1)){
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' || chessComponents[targetX][targetY].getName() == '_' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new KingChessComponent();
                        chessComponents[targetX][targetY].setName('k');
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }


            if (chessComponents[sourceX][sourceY].getName() == 'q'){
                if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) || (Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1)){
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' || chessComponents[targetX][targetY].getName() == '_' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('q');
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if (sourceX == targetX && Math.abs(sourceY-targetY) > 1){
                    for (int i = 1; i<Math.abs(sourceY-targetY); i++){
                        if (chessComponents[sourceX][Math.min(sourceY,targetY)+i].getName() != '_'){
                            return false;
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('q');
                        return true;
                    }
                }
                if (sourceY == targetY && Math.abs(sourceX-targetX)>1) {
                    for (int i = 1; i<Math.abs(sourceX-targetX); i++){
                        if (chessComponents[Math.min(sourceX,targetX)+i][sourceY].getName() != '_') {
                            return false;
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('q');
                        return true;
                    }
                }
                if (Math.abs(sourceX-targetX) == Math.abs(sourceY-targetY) && Math.abs(sourceX-targetX)>1){
                    if (sourceX>targetX && sourceY>targetY){
                        for (int i = 1; i<sourceX-targetX; i++){
                            if (chessComponents[sourceX-i][sourceY-i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX<targetX && sourceY<targetY){
                        for (int i = 1; i<targetX-sourceX; i++){
                            if (chessComponents[sourceX+i][sourceY+i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX>targetX && sourceY<targetY){
                        for (int i = 1; i<sourceX-targetX; i++){
                            if (chessComponents[sourceX-i][sourceY+i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX<targetX && sourceY>targetY){
                        for (int i = 1; i<targetX-sourceX; i++){
                            if (chessComponents[sourceX+i][sourceY-i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('q');
                        return true;
                    }
                }
                else {
                    return false;
                }
            }


            if (chessComponents[sourceX][sourceY].getName() == 'n'){
                if((chessComponents[targetX][targetY].getName()=='k')||(chessComponents[targetX][targetY].getName()=='q')||
                        (chessComponents[targetX][targetY].getName()=='b')||(chessComponents[targetX][targetY].getName()=='n')||
                        (chessComponents[targetX][targetY].getName()=='r')||(chessComponents[targetX][targetY].getName()=='p')){
                    return false;
                }
                else {
                    if(((Math.abs(targetX-sourceX)==2)&&(Math.abs(targetY-sourceY)==1))
                            ||((Math.abs(targetX-sourceX)==1)&&(Math.abs(targetY-sourceY)==2))){
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new KnightChessComponent();
                        chessComponents[targetX][targetY].setName('n');
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }


            if (chessComponents[sourceX][sourceY].getName() == 'r'){
                if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) ){
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' || chessComponents[targetX][targetY].getName() == '_' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new KnightChessComponent();
                        chessComponents[targetX][targetY].setName('r');
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if (sourceX == targetX && Math.abs(sourceY-targetY) > 1){
                    for (int i = 1; i<Math.abs(sourceY-targetY); i++){
                        if (chessComponents[sourceX][Math.min(sourceY,targetY)+i].getName() != '_'){
                            return false;
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new KnightChessComponent();
                        chessComponents[targetX][targetY].setName('r');
                        return true;
                    }
                }
                if (sourceY == targetY && Math.abs(sourceX-targetX)>1) {
                    for (int i = 1; i<Math.abs(sourceX-targetX); i++){
                        if (chessComponents[Math.min(sourceX,targetX)+i][sourceY].getName() != '_') {
                            return false;
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new KnightChessComponent();
                        chessComponents[targetX][targetY].setName('r');
                        return true;
                    }
                }
                else {
                    return false;
                }
            }


            if (chessComponents[sourceX][sourceY].getName() == 'b'){
                if ( Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1){
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' || chessComponents[targetX][targetY].getName() == '_' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new BishopChessComponent();
                        chessComponents[targetX][targetY].setName('b');
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                if (Math.abs(sourceX-targetX) == Math.abs(sourceY-targetY) && Math.abs(sourceX-targetX)>1){
                    if (sourceX>targetX && sourceY>targetY){
                        for (int i = 1; i<sourceX-targetX; i++){
                            if (chessComponents[sourceX-i][sourceY-i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX<targetX && sourceY<targetY){
                        for (int i = 1; i<targetX-sourceX; i++){
                            if (chessComponents[sourceX+i][sourceY+i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX>targetX && sourceY<targetY){
                        for (int i = 1; i<sourceX-targetX; i++){
                            if (chessComponents[sourceX-i][sourceY+i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX<targetX && sourceY>targetY){
                        for (int i = 1; i<targetX-sourceX; i++){
                            if (chessComponents[sourceX+i][sourceY-i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new BishopChessComponent();
                        chessComponents[targetX][targetY].setName('b');
                        return true;
                    }
                }
                else {
                    return false;
                }
            }


            if (chessComponents[sourceX][sourceY].getName() == 'p'){
                if (sourceX == 6){
                    if (targetX == 5){
                        if (sourceY == targetY){
                            if (chessComponents[targetX][sourceY].getName() != '_'){
                                return false;
                            }
                            else {
                                currentPlayer = ChessColor.BLACK;
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                                chessComponents[sourceX][sourceY].setName('_');
                                chessComponents[targetX][targetY] = new PawnChessComponent();
                                chessComponents[targetX][targetY].setName('p');
                                return true;
                            }
                        }
                        if (Math.abs(sourceY-targetY) == 1){
                            if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                                    chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                                    chessComponents[targetX][targetY].getName() == 'N'){
                                currentPlayer = ChessColor.BLACK;
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                                chessComponents[sourceX][sourceY].setName('_');
                                chessComponents[targetX][targetY] = new PawnChessComponent();
                                chessComponents[targetX][targetY].setName('p');
                                return true;
                            }
                            else {
                                return false;
                            }
                        }
                        else {
                            return false;
                        }
                    }
                    else if (targetX == 4 && sourceY == targetY){
                        if (chessComponents[targetX+1][sourceY].getName() != '_' || chessComponents[targetX][sourceY].getName() != '_'){
                            return false;
                        }
                        else {
                            currentPlayer = ChessColor.BLACK;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new PawnChessComponent();
                            chessComponents[targetX][targetY].setName('p');
                            return true;
                        }
                    }
                    else {
                        return false;
                    }
                }
                if (sourceX<6){
                    if (sourceX-targetX == 1 && sourceY == targetY){
                        if (chessComponents[targetX][targetY].getName() != '_'){
                            return false;
                        }
                        else {
                            currentPlayer = ChessColor.BLACK;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new PawnChessComponent();
                            chessComponents[targetX][targetY].setName('p');
                            return true;
                        }
                    }
                    if (sourceX-targetX == 1 && Math.abs(sourceY-targetY) == 1){
                        if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                                chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                                chessComponents[targetX][targetY].getName() == 'N'){
                            currentPlayer = ChessColor.BLACK;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new PawnChessComponent();
                            chessComponents[targetX][targetY].setName('p');
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }

        if (currentPlayer == ChessColor.BLACK){
            if (chessComponents[sourceX][sourceY].getName() == 'K'){
                if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) || (Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1)){
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' || chessComponents[targetX][targetY].getName() == '_' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new KingChessComponent();
                        chessComponents[targetX][targetY].setName('K');
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }


            if (chessComponents[sourceX][sourceY].getName() == 'Q'){
                if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) || (Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1)){
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' || chessComponents[targetX][targetY].getName() == '_' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('K');
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else if (sourceX == targetX && Math.abs(sourceY-targetY) > 1){
                    for (int i = 1; i<Math.abs(sourceY-targetY); i++){
                        if ((chessComponents[sourceX][Math.min(sourceY,targetY)+i].getName() != '_') ){
                            return false;
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('K');
                        return true;
                    }
                }
                else if (sourceY == targetY && Math.abs(sourceX-targetX)>1) {
                    for (int i = 1; i<Math.abs(sourceX-targetX); i++){
                        if ((chessComponents[Math.min(sourceX,targetX)+i][sourceY].getName() != '_') ){
                            return false;
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('K');
                        return true;
                    }
                }
                else if (Math.abs(sourceX-targetX) == Math.abs(sourceY-targetY) && Math.abs(sourceX-targetX)>1){
                    if (sourceX>targetX && sourceY>targetY){
                        for (int i = 1; i<sourceX-targetX; i++){
                            if (chessComponents[sourceX-i][sourceY-i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX<targetX && sourceY<targetY){
                        for (int i = 1; i<targetX-sourceX; i++){
                            if (chessComponents[sourceX+i][sourceY+i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX>targetX && sourceY<targetY){
                        for (int i = 1; i<sourceX-targetX; i++){
                            if (chessComponents[sourceX-i][sourceY+i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX<targetX && sourceY>targetY){
                        for (int i = 1; i<targetX-sourceX; i++){
                            if (chessComponents[sourceX+i][sourceY-i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('K');
                        return true;
                    }
                }
                else {

                    return false;
                }
            }


            if (chessComponents[sourceX][sourceY].getName() == 'N'){
                if((chessComponents[targetX][targetY].getName()=='K')||(chessComponents[targetX][targetY].getName()=='Q')||
                        (chessComponents[targetX][targetY].getName()=='B')||(chessComponents[targetX][targetY].getName()=='N')||
                        (chessComponents[targetX][targetY].getName()=='R')||(chessComponents[targetX][targetY].getName()=='P')){
                    return false;
                }
                else{
                    if(((Math.abs(targetX-sourceX)==2)&&(Math.abs(targetY-sourceY)==1))
                            ||((Math.abs(targetX-sourceX)==1)&&(Math.abs(targetY-sourceY)==2))){
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new KnightChessComponent();
                        chessComponents[targetX][targetY].setName('N');
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }


            if (chessComponents[sourceX][sourceY].getName() == 'R'){
                if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) ){
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' || chessComponents[targetX][targetY].getName() == '_' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new RookChessComponent();
                        chessComponents[targetX][targetY].setName('R');
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else if (sourceX == targetX && Math.abs(sourceY-targetY) > 1){
                    for (int i = 1; i<Math.abs(sourceY-targetY); i++){
                        if ((chessComponents[sourceX][Math.min(sourceY,targetY)+i].getName() != '_') ){
                            return false;
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new RookChessComponent();
                        chessComponents[targetX][targetY].setName('R');

                        return true;
                    }
                }
                else if (sourceY == targetY && Math.abs(sourceX-targetX)>1) {
                    for (int i = 1; i<Math.abs(sourceX-targetX); i++){
                        if ((chessComponents[Math.min(sourceX,targetX)+i][sourceY].getName() != '_') ){
                            return false;
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new RookChessComponent();
                        chessComponents[targetX][targetY].setName('R');
                        return true;
                    }
                }
                else {
                    return false;
                }
            }


            if (chessComponents[sourceX][sourceY].getName() == 'B'){
                if ( Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1){
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' || chessComponents[targetX][targetY].getName() == '_' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new BishopChessComponent();
                        chessComponents[targetX][targetY].setName('B');
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else if (Math.abs(sourceX-targetX) == Math.abs(sourceY-targetY) && Math.abs(sourceX-targetX)>1){
                    if (sourceX>targetX && sourceY>targetY){
                        for (int i = 1; i<sourceX-targetX; i++){
                            if (chessComponents[sourceX-i][sourceY-i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX<targetX && sourceY<targetY){
                        for (int i = 1; i<targetX-sourceX; i++){
                            if (chessComponents[sourceX+i][sourceY+i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX>targetX && sourceY<targetY){
                        for (int i = 1; i<sourceX-targetX; i++){
                            if (chessComponents[sourceX-i][sourceY+i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (sourceX<targetX && sourceY>targetY){
                        for (int i = 1; i<targetX-sourceX; i++){
                            if (chessComponents[sourceX+i][sourceY-i].getName() != '_'){
                                return false;
                            }
                        }
                    }
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){
                        return false;
                    }
                    else {
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new BishopChessComponent();
                        chessComponents[targetX][targetY].setName('B');
                        return true;
                    }
                }
                else {
                    return false;
                }
            }


            if (chessComponents[sourceX][sourceY].getName() == 'P'){
                if (sourceX == 1){
                    if (targetX == 2){
                        if (sourceY == targetY){
                            if (chessComponents[targetX][sourceY].getName() != '_'){
                                return false;
                            }
                            else {
                                currentPlayer = ChessColor.WHITE;
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                                chessComponents[sourceX][sourceY].setName('_');
                                chessComponents[targetX][targetY] = new PawnChessComponent();
                                chessComponents[targetX][targetY].setName('P');
                                return true;
                            }
                        }
                        if (Math.abs(sourceY-targetY) == 1){
                            if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                                    chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                                    chessComponents[targetX][targetY].getName() == 'n'){
                                currentPlayer = ChessColor.WHITE;
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                                chessComponents[sourceX][sourceY].setName('_');
                                chessComponents[targetX][targetY] = new PawnChessComponent();
                                chessComponents[targetX][targetY].setName('P');
                                return true;
                            }
                            else {
                                return false;
                            }
                        }
                        else {
                            return false;
                        }
                    }
                    else if (targetX == 3 && sourceY == targetY){
                        if (chessComponents[targetX-1][sourceY].getName() != '_' || chessComponents[targetX][sourceY].getName() != '_'){
                            return false;
                        }
                        else {
                            currentPlayer = ChessColor.WHITE;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new PawnChessComponent();
                            chessComponents[targetX][targetY].setName('P');
                            return true;
                        }
                    }
                    else {
                        return false;
                    }
                }
                if (sourceX>1){
                    if (sourceX-targetX == -1 && sourceY == targetY){
                        if (chessComponents[targetX][targetY].getName() != '_'){
                            return false;
                        }
                        else {
                            currentPlayer = ChessColor.WHITE;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new PawnChessComponent();
                            chessComponents[targetX][targetY].setName('P');
                            return true;
                        }
                    }
                    if (sourceX-targetX == -1 && Math.abs(sourceY-targetY) == 1){
                        if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                                chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                                chessComponents[targetX][targetY].getName() == 'n'){
                            currentPlayer = ChessColor.WHITE;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new PawnChessComponent();
                            chessComponents[targetX][targetY].setName('P');
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }

            else {
                return false;
            }
        }
        else {
            return false;
        }
    }




    public boolean move(int sourceX, int sourceY, int targetX, int targetY){
        chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
        if (chessComponents[sourceX][sourceY].getName() == '_'){
            return false;
        }
        if (chessComponents[sourceX][sourceY].getName() == 'k'){
            if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) || (Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1)){
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){

                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }


        if (chessComponents[sourceX][sourceY].getName() == 'q'){
            if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) || (Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1)){
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){

                    return true;
                }
                else {
                    return false;
                }
            }
            if (sourceX == targetX && Math.abs(sourceY-targetY) > 1){
                for (int i = 1; i<Math.abs(sourceY-targetY); i++){
                    if (chessComponents[sourceX][Math.min(sourceY,targetY)+i].getName() != '_'){
                        return false;
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){
                    return false;
                }
                else {

                    return true;
                }
            }
            if (sourceY == targetY && Math.abs(sourceX-targetX)>1) {
                for (int i = 1; i<Math.abs(sourceX-targetX); i++){
                    if (chessComponents[Math.min(sourceX,targetX)+i][sourceY].getName() != '_') {
                        return false;
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){
                    return false;
                }
                else {

                    return true;
                }
            }
            if (Math.abs(sourceX-targetX) == Math.abs(sourceY-targetY) && Math.abs(sourceX-targetX)>1){
                if (sourceX>targetX && sourceY>targetY){
                    for (int i = 1; i<sourceX-targetX; i++){
                        if (chessComponents[sourceX-i][sourceY-i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX<targetX && sourceY<targetY){
                    for (int i = 1; i<targetX-sourceX; i++){
                        if (chessComponents[sourceX+i][sourceY+i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX>targetX && sourceY<targetY){
                    for (int i = 1; i<sourceX-targetX; i++){
                        if (chessComponents[sourceX-i][sourceY+i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX<targetX && sourceY>targetY){
                    for (int i = 1; i<targetX-sourceX; i++){
                        if (chessComponents[sourceX+i][sourceY-i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){
                    return false;
                }
                else {
                    currentPlayer = ChessColor.BLACK;

                    return true;
                }
            }
            else {
                return false;
            }
        }


        if (chessComponents[sourceX][sourceY].getName() == 'n'){
            if (Math.abs(sourceX-targetX) == 1 && Math.abs(sourceY - targetY) == 2){
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){

                    return true;
                }
            }
            if (Math.abs(sourceX-targetX) == 2 && Math.abs(sourceY - targetY)==1){
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){

                    return true;
                }
            }
            else {
                return false;
            }
        }


        if (chessComponents[sourceX][sourceY].getName() == 'r'){
            if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) ){
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){

                    return true;
                }
                else {
                    return false;
                }
            }
            if (sourceX == targetX && Math.abs(sourceY-targetY) > 1){
                for (int i = 1; i<Math.abs(sourceY-targetY); i++){
                    if (chessComponents[sourceX][Math.min(sourceY,targetY)+i].getName() != '_'){
                        return false;
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){
                    return false;
                }
                else {

                    return true;
                }
            }
            if (sourceY == targetY && Math.abs(sourceX-targetX)>1) {
                for (int i = 1; i<Math.abs(sourceX-targetX); i++){
                    if (chessComponents[Math.min(sourceX,targetX)+i][sourceY].getName() != '_') {
                        return false;
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){
                    return false;
                }
                else {

                    return true;
                }
            }
            else {
                return false;
            }
        }


        if (chessComponents[sourceX][sourceY].getName() == 'b'){
            if ( Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1){
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){

                    return true;
                }
                else {
                    return false;
                }
            }
            if (Math.abs(sourceX-targetX) == Math.abs(sourceY-targetY) && Math.abs(sourceX-targetX)>1){
                if (sourceX>targetX && sourceY>targetY){
                    for (int i = 1; i<sourceX-targetX; i++){
                        if (chessComponents[sourceX-i][sourceY-i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX<targetX && sourceY<targetY){
                    for (int i = 1; i<targetX-sourceX; i++){
                        if (chessComponents[sourceX+i][sourceY+i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX>targetX && sourceY<targetY){
                    for (int i = 1; i<sourceX-targetX; i++){
                        if (chessComponents[sourceX-i][sourceY+i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX<targetX && sourceY>targetY){
                    for (int i = 1; i<targetX-sourceX; i++){
                        if (chessComponents[sourceX+i][sourceY-i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){
                    return false;
                }
                else {

                    return true;
                }
            }
            else {
                return false;
            }
        }


        if (chessComponents[sourceX][sourceY].getName() == 'p'){
            if (sourceX == 6){
                if (targetX == 5){
                    if (sourceY == targetY){
                        if (chessComponents[targetX][sourceY].getName() != '_'){
                            return false;
                        }
                        else {

                            return true;
                        }
                    }
                    if (Math.abs(sourceY-targetY) == 1){
                        if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                                chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                                chessComponents[targetX][targetY].getName() == 'N'){

                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                }
                else if (targetX == 4 && sourceY == targetY){
                    if (chessComponents[targetX+1][sourceY].getName() != '_' || chessComponents[targetX][sourceY].getName() != '_'){
                        return false;
                    }
                    else {

                        return true;
                    }
                }
                else {
                    return false;
                }
            }
            if (sourceX<6){
                if (sourceX-targetX == 1 && sourceY == targetY){
                    if (chessComponents[targetX][targetY].getName() != '_'){
                        return false;
                    }
                    else {

                        return true;
                    }
                }
                if (sourceX-targetX == 1 && Math.abs(sourceY-targetY) == 1){
                    if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                            chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                            chessComponents[targetX][targetY].getName() == 'N'){

                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        if (chessComponents[sourceX][sourceY].getName() == 'K'){
            if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) || (Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1)){
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){

                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }


        if (chessComponents[sourceX][sourceY].getName() == 'Q'){
            if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) || (Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1)){
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){

                    return true;
                }
                else {
                    return false;
                }
            }
            else if (sourceX == targetX && Math.abs(sourceY-targetY) > 1){
                for (int i = 1; i<Math.abs(sourceY-targetY); i++){
                    if ((chessComponents[sourceX][Math.min(sourceY,targetY)+i].getName() != '_') ){
                        return false;
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){
                    return false;
                }
                else {

                    return true;
                }
            }
            else if (sourceY == targetY && Math.abs(sourceX-targetX)>1) {
                for (int i = 1; i<Math.abs(sourceX-targetX); i++){
                    if ((chessComponents[Math.min(sourceX,targetX)+i][sourceY].getName() != '_') ){
                        return false;
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){
                    return false;
                }
                else {

                    return true;
                }
            }
            else if (Math.abs(sourceX-targetX) == Math.abs(sourceY-targetY) && Math.abs(sourceX-targetX)>1){
                if (sourceX>targetX && sourceY>targetY){
                    for (int i = 1; i<sourceX-targetX; i++){
                        if (chessComponents[sourceX-i][sourceY-i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX<targetX && sourceY<targetY){
                    for (int i = 1; i<targetX-sourceX; i++){
                        if (chessComponents[sourceX+i][sourceY+i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX>targetX && sourceY<targetY){
                    for (int i = 1; i<sourceX-targetX; i++){
                        if (chessComponents[sourceX-i][sourceY+i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX<targetX && sourceY>targetY){
                    for (int i = 1; i<targetX-sourceX; i++){
                        if (chessComponents[sourceX+i][sourceY-i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){
                    return false;
                }
                else {

                    return true;
                }
            }
            else {

                return false;
            }
        }


        if (chessComponents[sourceX][sourceY].getName() == 'N'){
            if (Math.abs(sourceX-targetX) == 1 && Math.abs(sourceY - targetY) == 2){
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){

                    return true;
                }

            }
            if (Math.abs(sourceX-targetX) == 2 && Math.abs(sourceY - targetY) == 1){
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){

                    return true;
                }
            }
            else {
                return false;
            }
        }


        if (chessComponents[sourceX][sourceY].getName() == 'R'){
            if ((sourceX == targetX && Math.abs(sourceY-targetY) == 1) || (sourceY == targetY && Math.abs(sourceX - targetX) == 1) ){
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){

                    return true;
                }
                else {
                    return false;
                }
            }
            else if (sourceX == targetX && Math.abs(sourceY-targetY) > 1){
                for (int i = 1; i<Math.abs(sourceY-targetY); i++){
                    if ((chessComponents[sourceX][Math.min(sourceY,targetY)+i].getName() != '_') ){
                        return false;
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){
                    return false;
                }
                else {

                    return true;
                }
            }
            else if (sourceY == targetY && Math.abs(sourceX-targetX)>1) {
                for (int i = 1; i<Math.abs(sourceX-targetX); i++){
                    if ((chessComponents[Math.min(sourceX,targetX)+i][sourceY].getName() != '_') ){
                        return false;
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){
                    return false;
                }
                else {

                    return true;
                }
            }
            else {
                return false;
            }
        }


        if (chessComponents[sourceX][sourceY].getName() == 'B'){
            if ( Math.abs(sourceX-targetX)==1 && Math.abs(sourceY - targetY) == 1){
                if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' || chessComponents[targetX][targetY].getName() == '_' ||
                        chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                        chessComponents[targetX][targetY].getName() == 'n'){

                    return true;
                }
                else {
                    return false;
                }
            }
            else if (Math.abs(sourceX-targetX) == Math.abs(sourceY-targetY) && Math.abs(sourceX-targetX)>1){
                if (sourceX>targetX && sourceY>targetY){
                    for (int i = 1; i<sourceX-targetX; i++){
                        if (chessComponents[sourceX-i][sourceY-i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX<targetX && sourceY<targetY){
                    for (int i = 1; i<targetX-sourceX; i++){
                        if (chessComponents[sourceX+i][sourceY+i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX>targetX && sourceY<targetY){
                    for (int i = 1; i<sourceX-targetX; i++){
                        if (chessComponents[sourceX-i][sourceY+i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (sourceX<targetX && sourceY>targetY){
                    for (int i = 1; i<targetX-sourceX; i++){
                        if (chessComponents[sourceX+i][sourceY-i].getName() != '_'){
                            return false;
                        }
                    }
                }
                if (chessComponents[targetX][targetY].getName() == 'K' || chessComponents[targetX][targetY].getName() == 'Q' ||
                        chessComponents[targetX][targetY].getName() == 'B' || chessComponents[targetX][targetY].getName() == 'R' || chessComponents[targetX][targetY].getName() == 'P' ||
                        chessComponents[targetX][targetY].getName() == 'N'){
                    return false;
                }
                else {

                    return true;
                }
            }
            else {
                return false;
            }
        }


        if (chessComponents[sourceX][sourceY].getName() == 'P'){
            if (sourceX == 1){
                if (targetX == 2){
                    if (sourceY == targetY){
                        if (chessComponents[targetX][sourceY].getName() != '_'){
                            return false;
                        }
                        else {

                            return true;
                        }
                    }
                    if (Math.abs(sourceY-targetY) == 1){
                        if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                                chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                                chessComponents[targetX][targetY].getName() == 'n'){

                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                }
                else if (targetX == 3 && sourceY == targetY){
                    if (chessComponents[targetX-1][sourceY].getName() != '_' || chessComponents[targetX][sourceY].getName() != '_'){
                        return false;
                    }
                    else {

                        return true;
                    }
                }
                else {
                    return false;
                }
            }
            if (sourceX>1){
                if (sourceX-targetX == -1 && sourceY == targetY){
                    if (chessComponents[targetX][targetY].getName() != '_'){
                        return false;
                    }
                    else {

                        return true;
                    }
                }
                if (sourceX-targetX == -1 && Math.abs(sourceY-targetY) == 1){
                    if (chessComponents[targetX][targetY].getName() == 'k' || chessComponents[targetX][targetY].getName() == 'q' ||
                            chessComponents[targetX][targetY].getName() == 'b' || chessComponents[targetX][targetY].getName() == 'r' || chessComponents[targetX][targetY].getName() == 'p' ||
                            chessComponents[targetX][targetY].getName() == 'n'){

                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        else {
            return false;
        }
    }
}
