import java.util.*;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    private String chessBoard = "";
    private List<String> capturedChess1;
    private List<String> capturedChess2;
    public ConcreteChessGame(ChessComponent[][] chessComponents){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                EmptyChessComponent emptyChessComponent = new EmptyChessComponent();
                this.chessComponents[i][j]=emptyChessComponent;
                this.chessComponents[i][j].setName('_');
                this.chessComponents[i][j].setChessColor(ChessColor.NONE);

            }
        }
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[0].length; j++) {
                this.chessComponents[i][j]=chessComponents[i][j];

            }
        }

    }
    public ConcreteChessGame(List<String> chessboard){
        this.chessComponents=new ChessComponent[8][8];
        this.loadChessGame(chessboard);
    }
    public ConcreteChessGame(){

    }
    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    public void setCapturedChess(List<String> capturedChess , ChessColor player) {
        if (player == ChessColor.BLACK){
            capturedChess1 = capturedChess;
        }
        if (player == ChessColor.WHITE){
            capturedChess2 = capturedChess;
        }
        if (player == ChessColor.NONE){
            capturedChess1 = null;
            capturedChess2 = null;
        }
    }
    @Override
    public String getCapturedChess(ChessColor player){
        String s = "";
        if (player == ChessColor.BLACK){
            for (int i = 0; i < capturedChess1.size(); i++) {
                s = s.concat(capturedChess1.get(i)).concat("\n");
            }
        }
        if (player == ChessColor.WHITE){
            for (int i = 0; i < capturedChess2.size(); i++) {
                s = s.concat(capturedChess2.get(i)).concat("\n");
            }
        }
        return s;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> list=new ArrayList<>();

        if(this.chessComponents[source.getX()][source.getY()].getName()=='_'){
            return list;
        }
        List<ChessboardPoint> chessboardPoints = this.chessComponents[source.getX()][source.getY()].canMoveTo();

        chessboardPoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {

                int i = o1.getX() - o2.getX();
                if(i==0){
                    return o1.getY()-o2.getY();
                }else{
                    return i;
                }
            }
        });
        return chessboardPoints;
    }

    public boolean check(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX > 7 || sourceY > 7 || targetX > 7 || targetY > 7) {
            return false;
        }
        if(this.chessComponents[sourceX][sourceY].getName()=='k' ||this.chessComponents[sourceX][sourceY].getName()=='K'){
            if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                return false;
            }else{
                return true;
            }
        }
        if(this.chessComponents[sourceX][sourceY].getName()=='q' ||this.chessComponents[sourceX][sourceY].getName()=='Q') {
            if(sourceX<targetX&&sourceY<targetY){
                boolean flag=true;
                for (int i = 1; i < targetY-sourceY; i++) {
                    if(this.chessComponents[sourceX+i][sourceY+i].getName()!='_'){
                        flag=false;
                        break;
                    }

                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
            if(sourceX>targetX&&sourceY<targetY){
                boolean flag=true;
                for (int i = 1; i < targetY-sourceY; i++) {
                    if(this.chessComponents[sourceX-i][sourceY+i].getName()!='_'){
                        flag=false;
                        break;
                    }

                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
            if(sourceX<targetX&&sourceY>targetY){
                boolean flag=true;
                for (int i = 1; i < targetX-sourceX; i++) {
                    if(this.chessComponents[sourceX+i][sourceY-i].getName()!='_'){
                        flag=false;
                        break;
                    }

                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
            if(sourceX>targetX&&sourceY>targetY){
                boolean flag=true;
                for (int i = 1; i < sourceX-targetX; i++) {
                    if(this.chessComponents[sourceX-i][sourceY-i].getName()!='_'){
                        flag=false;
                        break;
                    }

                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
            if(sourceX==targetX){
                if(sourceY<targetY){
                    boolean flag=true;

                    for (int i = sourceY+1; i < targetY; i++) {
                        if(this.chessComponents[sourceX][i].getName()!='_'){
                            flag=false;
                            break;
                        }

                    }
                    if(flag==false){
                        return false;
                    }else{
                        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }else{
                    boolean flag=true;

                    for (int i = sourceY-1; i > targetY; i--) {
                        if(this.chessComponents[sourceX][i].getName()!='_'){
                            flag=false;
                            break;
                        }

                    }
                    if(flag==false){
                        return false;
                    }else{
                        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }
            }else{
                if(sourceX<targetX){
                    boolean flag=true;

                    for (int i = sourceX+1; i < targetX; i++) {
                        if(this.chessComponents[i][sourceY].getName()!='_'){
                            flag=false;
                            break;
                        }

                    }
                    if(flag==false){
                        return false;
                    }else{
                        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }else{
                    boolean flag=true;

                    for (int i = sourceX-1; i > targetX; i--) {
                        if(this.chessComponents[i][sourceY].getName()!='_'){
                            flag=false;
                            break;
                        }

                    }
                    if(flag==false){
                        return false;
                    }else{
                        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }
            }
        }
        if(this.chessComponents[sourceX][sourceY].getName()=='p' ||this.chessComponents[sourceX][sourceY].getName()=='P') {

            if(sourceY-targetY==1 || sourceY-targetY==-1) {
                if (this.chessComponents[targetX][targetY].getChessColor()!=this.chessComponents[sourceX][sourceY].getChessColor()&&this.chessComponents[targetX][targetY].getName()!='_') {
                    return true;
                } else {
                    return false;
                }
            }else{
                if(this.chessComponents[targetX][targetY].getName()=='_'){
                    return true;
                }else{
                    return false;
                }
            }
        }
        if(this.chessComponents[sourceX][sourceY].getName()=='r' ||this.chessComponents[sourceX][sourceY].getName()=='R'){
            if(sourceX==targetX){
                if(sourceY<targetY){
                    boolean flag=true;

                    for (int i = sourceY+1; i < targetY; i++) {
                        if(this.chessComponents[sourceX][i].getName()!='_'){
                            flag=false;
                            break;
                        }

                    }
                    if(flag==false){
                        return false;
                    }else{
                        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }else{
                    boolean flag=true;

                    for (int i = sourceY-1; i > targetY; i--) {
                        if(this.chessComponents[sourceX][i].getName()!='_'){
                            flag=false;
                            break;
                        }

                    }
                    if(flag==false){
                        return false;
                    }else{
                        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }
            }else{
                if(sourceX<targetX){
                    boolean flag=true;

                    for (int i = sourceX+1; i < targetX; i++) {
                        if(this.chessComponents[i][sourceY].getName()!='_'){
                            flag=false;
                            break;
                        }

                    }
                    if(flag==false){
                        return false;
                    }else{
                        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }else{
                    boolean flag=true;

                    for (int i = sourceX-1; i > targetX; i--) {
                        if(this.chessComponents[i][sourceY].getName()!='_'){
                            flag=false;
                            break;
                        }

                    }
                    if(flag==false){
                        return false;
                    }else{
                        if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }
            }

        }

        if(this.chessComponents[sourceX][sourceY].getName()=='B'||this.chessComponents[sourceX][sourceY].getName()=='b') {
            if(sourceX<targetX&&sourceY<targetY){
                boolean flag=true;
                for (int i = 1; i < targetY-sourceY; i++) {
                    if(this.chessComponents[sourceX+i][sourceY+i].getName()!='_'){
                        flag=false;
                        break;
                    }
                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
            if(sourceX>targetX&&sourceY<targetY){
                boolean flag=true;
                for (int i = 1; i < targetY-sourceY; i++) {
                    if(this.chessComponents[sourceX-i][sourceY+i].getName()!='_'){
                        flag=false;
                        break;
                    }

                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
            if(sourceX<targetX&&sourceY>targetY){
                boolean flag=true;
                for (int i = 1; i < targetX-sourceX; i++) {
                    if(this.chessComponents[sourceX+i][sourceY-i].getName()!='_'){
                        flag=false;
                        break;
                    }

                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
            if(sourceX>targetX&&sourceY>targetY){
                boolean flag=true;
                for (int i = 1; i < sourceX-targetX; i++) {
                    if(this.chessComponents[sourceX-i][sourceY-i].getName()!='_'){
                        flag=false;
                        break;
                    }
                }
                if(flag==false){
                    return false;
                }else{
                    if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()){
                        return false;
                    }else{
                        return true;
                    }
                }
            }
        }
        if(this.chessComponents[sourceX][sourceY].getName()=='N'||this.chessComponents[sourceX][sourceY].getName()=='n'){
            if(this.chessComponents[sourceX][sourceY].getChessColor()==this.chessComponents[targetX][targetY].getChessColor()||this.chessComponents[sourceX][sourceY].getChessColor()==ChessColor.NONE){
                return false;
            }else{
                return true;
            }
        }

        return true;

    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        boolean check = this.check(sourceX, sourceY, targetX, targetY);
        if(check==false){
            return check;
        }else{
            if(this.chessComponents[sourceX][sourceY].getChessColor()!=this.currentPlayer){
                return false;
            }

            if(this.currentPlayer==ChessColor.BLACK){
                this.currentPlayer=ChessColor.WHITE;
            }else{
                this.currentPlayer=ChessColor.BLACK;
            }

            this.chessComponents[targetX][targetY]=this.chessComponents[sourceX][sourceY];
            this.chessComponents[targetX][targetX].setSource(new ChessboardPoint(targetX,targetY));
            this.chessComponents[sourceX][sourceY]=new EmptyChessComponent();
            this.chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
            this.chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
            this.chessComponents[sourceX][sourceY].setName('_');
            updateCapture();
            return true;
        }
    }
    public void updateCapture(){
        Map<Character,Integer> map=new HashMap<>();
        map.put('R',0);
        map.put('K',0);
        map.put('N',0);
        map.put('P',0);
        map.put('Q',0);
        map.put('B',0);
        map.put('r',0);
        map.put('k',0);
        map.put('n',0);
        map.put('p',0);
        map.put('q',0);
        map.put('b',0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char c = this.chessComponents[i][j].name;
                if(c!='_'){
                    map.put(c, map.get(c)+1);
                }
            }
        }
        this.capturedChess1=new ArrayList<>();
        this.capturedChess2=new ArrayList<>();
        if(map.get('K')!=1){
            this.capturedChess1.add("K 1");
        }
        if(map.get('Q')!=1){
            this.capturedChess1.add("Q 1");
        }
        if(map.get('R')!=2){
            this.capturedChess1.add("R "+(2-map.get('R')));
        }
        if(map.get('B')!=2){
            this.capturedChess1.add("B "+(2-map.get('B')));
        }
        if(map.get('N')!=2){
            this.capturedChess1.add("N "+(2-map.get('N')));
        }
        if(map.get('P')!=8){
            this.capturedChess1.add("P "+(8-map.get('P')));
        }

        if(map.get('k')!=1){
            this.capturedChess2.add("k 1");
        }
        if(map.get('q')!=1){
            this.capturedChess2.add("q 1");
        }
        if(map.get('r')!=2){
            this.capturedChess2.add("r "+(2-map.get('r')));
        }
        if(map.get('b')!=2){
            this.capturedChess2.add("b "+(2-map.get('b')));
        }
        if(map.get('n')!=2){
            this.capturedChess2.add("n "+(2-map.get('n')));
        }
        if(map.get('p')!=8){
            this.capturedChess2.add("p "+(8-map.get('p')));
        }
    }
    public String getChessBoard() {
        return chessBoard;
    }
    @Override
    public void loadChessGame(List<String> chessboard){
        this.chessBoard="";
        Map<Character,Integer> map=new HashMap<>();
        map.put('R',0);
        map.put('K',0);
        map.put('N',0);
        map.put('P',0);
        map.put('Q',0);
        map.put('B',0);
        map.put('r',0);
        map.put('k',0);
        map.put('n',0);
        map.put('p',0);
        map.put('q',0);
        map.put('b',0);
        for (int i = 0; i < chessboard.size()-1; i++) {
            this.chessBoard = this.chessBoard.concat(chessboard.get(i)).concat("\n");
            if(i<chessboard.size()-1){

            for (int j = 0; j < 8; j++) {
                char c = chessboard.get(i).charAt(j);
                if(c!='_'){
                    map.put(c, map.get(c)+1);
                }
                switch (c){
                    case 'R':
                        RookChessComponent rookChessComponent = new RookChessComponent();
                        rookChessComponent.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=rookChessComponent;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName(c);
                        break;
                    case 'r':
                        RookChessComponent rookChessComponent2 = new RookChessComponent();
                        rookChessComponent2.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=rookChessComponent2;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName(c);
                        break;
                    case 'N':
                        KnightChessComponent knightChessComponent = new KnightChessComponent();
                        knightChessComponent.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=knightChessComponent;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName(c);

                        break;
                    case 'n':
                        KnightChessComponent knightChessComponent2 = new KnightChessComponent();
                        knightChessComponent2.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=knightChessComponent2;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName(c);
                        break;
                    case 'B':
                        BishopChessComponent bishopChessComponent = new BishopChessComponent();
                        bishopChessComponent.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=bishopChessComponent;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName(c);
                        break;
                    case 'b':
                        BishopChessComponent bishopChessComponent2 = new BishopChessComponent();
                        bishopChessComponent2.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=bishopChessComponent2;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName(c);
                        break;
                    case 'Q':
                        QueenChessComponent queenChessComponent=new QueenChessComponent();
                        queenChessComponent.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=queenChessComponent;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName(c);
                        break;
                    case 'q':

                        QueenChessComponent queenChessComponent2=new QueenChessComponent();
                        queenChessComponent2.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=queenChessComponent2;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName(c);
                        break;
                    case 'K':
                        KingChessComponent kingChessComponent = new KingChessComponent();
                        kingChessComponent.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=kingChessComponent;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName(c);
                        break;
                    case 'k':
                        KingChessComponent kingChessComponent2 = new KingChessComponent();
                        kingChessComponent2.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=kingChessComponent2;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName(c);
                        break;

                    case 'P':

                        PawnChessComponent pawnChessComponent=new PawnChessComponent();
                        pawnChessComponent.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=pawnChessComponent;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName(c);
                        break;
                    case 'p':
                        PawnChessComponent pawnChessComponent2=new PawnChessComponent();
                        pawnChessComponent2.setChessComponents(this.chessComponents);
                        this.chessComponents[i][j]=pawnChessComponent2;
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName(c);
                        break;
                    case '_':
                        this.chessComponents[i][j]=new EmptyChessComponent();
                        this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                        this.chessComponents[i][j].setName(c);

                }
            }
            }

        }
        this.capturedChess1=new ArrayList<>();
        this.capturedChess2=new ArrayList<>();
        if(map.get('K')!=1){
            this.capturedChess1.add("K 1");
        }
        if(map.get('Q')!=1){
            this.capturedChess1.add("Q 1");
        }
        if(map.get('R')!=2){
            this.capturedChess1.add("R "+(2-map.get('R')));
        }
        if(map.get('B')!=2){
            this.capturedChess1.add("B "+(2-map.get('B')));
        }
        if(map.get('N')!=2){
            this.capturedChess1.add("N "+(2-map.get('N')));
        }
        if(map.get('P')!=8){
            this.capturedChess1.add("P "+(8-map.get('P')));
        }

        if(map.get('k')!=1){
            this.capturedChess2.add("k 1");
        }
        if(map.get('q')!=1){
            this.capturedChess2.add("q 1");
        }
        if(map.get('r')!=2){
            this.capturedChess2.add("r "+(2-map.get('r')));
        }
        if(map.get('b')!=2){
            this.capturedChess2.add("b "+(2-map.get('b')));
        }
        if(map.get('n')!=2){
            this.capturedChess2.add("n "+(2-map.get('n')));
        }
        if(map.get('p')!=8){
            this.capturedChess2.add("p "+(8-map.get('p')));
        }


        String s = chessboard.get(chessboard.size()-1);
        if(s.equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        }else{
            this.currentPlayer=ChessColor.BLACK;
        }
    }


    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        return this.chessBoard;
    }


    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}
