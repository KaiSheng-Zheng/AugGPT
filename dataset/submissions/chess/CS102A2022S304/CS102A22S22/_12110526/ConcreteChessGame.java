import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class ConcreteChessGame implements ChessGame{
	private ChessComponent[][] chessComponents;
	private ChessColor currentPlayer;
	private EmptySlotComponent e;
	private BishopChessComponent b,B;
	private KingChessComponent k,K;
	private PawnChessComponent p,P;
	private QueenChessComponent q,Q;
	private RookChessComponent r,R;
	private KnightChessComponent n,N;


    public ConcreteChessGame(){
		chessComponents = new ChessComponent[8][8];
		currentPlayer = ChessColor.WHITE;
		e = new EmptySlotComponent();  e.setColor(ChessColor.NONE); e.setName('_');
		b = new BishopChessComponent();b.setColor(ChessColor.WHITE);b.setName('b');
		k = new KingChessComponent();  k.setColor(ChessColor.WHITE);k.setName('k');
		p = new PawnChessComponent();  p.setColor(ChessColor.WHITE);p.setName('p');
		q = new QueenChessComponent(); q.setColor(ChessColor.WHITE);q.setName('q');
		r = new RookChessComponent();  r.setColor(ChessColor.WHITE);r.setName('r');
		n = new KnightChessComponent();n.setColor(ChessColor.WHITE);n.setName('n');

		B = new BishopChessComponent();B.setColor(ChessColor.BLACK);B.setName('B');
		K=  new KingChessComponent();  K.setColor(ChessColor.BLACK);K.setName('K');
		P = new PawnChessComponent();  P.setColor(ChessColor.BLACK);P.setName('P');
		Q = new QueenChessComponent(); Q.setColor(ChessColor.BLACK);Q.setName('Q');
		R = new RookChessComponent();  R.setColor(ChessColor.BLACK);R.setName('R');
		N = new KnightChessComponent();N.setColor(ChessColor.BLACK);N.setName('N');
		    }

    public ChessComponent[][] getChessComponents() {return chessComponents;}

    public ChessColor getCurrentPlayer() {return this.currentPlayer;}

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint>  a = chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(a, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() < o2.getX()) {
                    return -1;
                } else if (o1.getX() > o2.getX()) {
                    return 1;
                } else if (o1.getY() < o2.getY()) {
                    return -1;
                } else if (o1.getY() > o2.getY()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return a;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer){
            if (sourceX<8 && sourceX>=0 && sourceY<8 && sourceY>=0 &&targetY<8 && targetY>=0 && targetX<8 && targetX>=0 ){
                if (chessComponents[sourceX][sourceY].getSource().check(chessComponents[sourceX][sourceY].canMoveTo(),targetX,targetY)){
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    e.setSource(new ChessboardPoint(sourceX,sourceY));
                    chessComponents[sourceX][sourceY] = e;
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    }else if (currentPlayer == ChessColor.BLACK){
                        currentPlayer = ChessColor.WHITE;
                    }
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            chessComponents[i][j].setChessComponents(chessComponents);
                        }
                    }
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }


 public void loadChessGame(List<String> chessboard){
        char which;
        for (int i = 0;i < 8;i++) {
            for (int j = 0; j < 8; j++) {
                which = chessboard.get(i ).charAt(j );
                if(which=='_') {
        	e.setSource(new ChessboardPoint(i,j));
        	chessComponents[i ][j ] = new EmptySlotComponent();
        	chessComponents[i][j].build(e);}
        	if(which=='b') { b.setSource(new ChessboardPoint(i - 1, j - 1));
            chessComponents[i ][j] = new BishopChessComponent();
            chessComponents[i][j].build(b);}
        	if(which=='k') {
        	k.setSource(new ChessboardPoint(i, j));
            chessComponents[i ][j ] = new KingChessComponent();
            chessComponents[i][j].build(k);}
        	if(which=='q') { 
        	q.setSource(new ChessboardPoint(i, j ));
            chessComponents[i ][j ] = new QueenChessComponent();
            chessComponents[i][j ].build(q);}
        	if(which=='r') { r.setSource(new ChessboardPoint(i, j ));
            chessComponents[i ][j ] = new RookChessComponent();
            chessComponents[i ][j ].build(r);}
        	if(which=='n') {n.setSource(new ChessboardPoint(i , j ));
            chessComponents[i ][j] = new KnightChessComponent();
            chessComponents[i][j ].build(n);}
        	if(which=='p') {p.setSource(new ChessboardPoint(i , j));
            chessComponents[i ][j ] = new PawnChessComponent();
            chessComponents[i ][j ].build(p);}
        	if(which=='K') { K.setSource(new ChessboardPoint(i, j));
            chessComponents[i][j ] = new KingChessComponent();
            chessComponents[i ][j ].build(K);}
        	if(which=='B') { B.setSource(new ChessboardPoint(i , j));
            chessComponents[i ][j ] = new BishopChessComponent();
            chessComponents[i][j].build(B);}
        	if(which=='R') {R.setSource(new ChessboardPoint(i, j));
            chessComponents[i ][j] = new RookChessComponent();
            chessComponents[i ][j ].build(R);}
        	if(which=='Q') {Q.setSource(new ChessboardPoint(i , j ));
            chessComponents[i ][j ] = new QueenChessComponent();
            chessComponents[i][j].build(Q);}
        	if(which=='N') {N.setSource(new ChessboardPoint(i, j));
            chessComponents[i][j] = new KnightChessComponent();
            chessComponents[i ][j].build(N);}
        	if(which=='P') {P.setSource(new ChessboardPoint(i , j ));
            chessComponents[i][j] = new PawnChessComponent();
            chessComponents[i][j].build(P);}
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
            if(chessboard.get(8).equals("w") ||chessboard.get(8)==("W")){
                currentPlayer = ChessColor.WHITE;
            }else if (chessboard.get(8).equals("b")|| chessboard.get(8)==("B")){
                currentPlayer = ChessColor.BLACK;
            }else {
                currentPlayer = ChessColor.NONE;
            }
    }

    public String getCapturedChess(ChessColor player) {
     	 int k1 = 1,q1=1, p1=8,r1=2,n1=2,b1=2;
     String str ="";
     if (player == ChessColor.BLACK) {
     	 for (int i1 = 0; i1 < 8; i1++) {
     		 	for (int j1 = 0; j1 < 8; j1++) {
     		 		if      (chessComponents[i1][j1].name == 'K') {k1--;}
     		 		else if (chessComponents[i1][j1].name == 'Q') {q1--;}
     		 		else if (chessComponents[i1][j1].name == 'R') {r1--;}
     		 		else if (chessComponents[i1][j1].name == 'B') {b1--;}
     		 		else if (chessComponents[i1][j1].name == 'N') {n1--;}
     		 		else if (chessComponents[i1][j1].name == 'P') {p1--;}
     		 	}
     	 }
     	 if(k1!=0) {str = str+"K "+k1+"\n";}
     	 if(q1!=0) {str = str+"Q "+q1+"\n";}
     	 if(r1!=0) {str = str+"R "+r1+"\n";}
     	 if(b1!=0) {str = str+"B "+b1+"\n";}
     	 if(n1!=0) {str = str+"N "+n1+"\n";}
     	 if(p1!=0) {str = str+"P "+p1+"\n";}
     	
     } else {
     for (int i1 = 0; i1 < 8; i1++) {
     for (int j1 = 0; j1 < 8; j1++) {
     	if (chessComponents[i1][j1].name == 'k') {k1--;}
     	if (chessComponents[i1][j1].name == 'q') {q1--;}
     	if (chessComponents[i1][j1].name == 'r') {r1--;}
     	if (chessComponents[i1][j1].name == 'b') {b1--;}
     	if (chessComponents[i1][j1].name == 'n') {n1--;}
     	if (chessComponents[i1][j1].name == 'p') {p1--;}
     	
     }
     }
     	if(k1!=0) {str =str+ "k "+q1+"\n";}
     	if(q1!=0) {str =str+ "q "+q1+"\n";}
     	if(r1!=0) {str =str+ "r "+r1+"\n";}
     	if(b1!=0) {str =str+ "b "+b1+"\n";}
     	if(n1!=0) {str =str+ "n "+n1+"\n";}
     	if(p1!=0) {str =str+ "p "+p1+"\n";}
     	}
     return str;
     }


    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
  public String getChessboardGraph() {
		
		String graph = "";
		 for (int i = 0;i<8;i++){
			 for(int j = 0;j<8;j++) {
				 ChessComponent a = chessComponents[i][j];
				 graph+=a.name;
			 } if(i!=7) {
				 graph +="\n";
			 }}
		 return graph;
	}

    
}