import java.util.*;
public class ConcreteChessGame implements ChessGame{
	// A 2-dimension array to store all the chess components
	// should be initialized in your construct method.
	// i.e. = new ChessComponent[8][8]
	private ChessComponent[][] chessComponents;
	private char[][] a;
	// What's the current player's color, black or white?
	// should be initialized in your construct method.
	// by default, set the color to white.
	private ChessColor currentPlayer;		// What's the name
	public ConcreteChessGame(){
		currentPlayer=ChessColor.WHITE;
		chessComponents=new ChessComponent[8][8];
		a=new char[8][8];
	}
	public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
		if (chessComponents[sourceX][sourceY].chessColor!=currentPlayer) return false;
		List<ChessboardPoint> lis=getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
		boolean flg=false;
		int m=lis.size();
		for (int i=0;i<m;++i)
			if (lis.get(i).equals(new ChessboardPoint(targetX,targetY))) flg=true;
		if (flg==false) return false;
		a[targetX][targetY]=a[sourceX][sourceY];
		chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
		chessComponents[targetX][targetY].source=new ChessboardPoint(targetX,targetY);
		chessComponents[sourceX][sourceY]=new KingChessComponent();
		chessComponents[sourceX][sourceY].source=new ChessboardPoint(sourceX,sourceY);
		chessComponents[sourceX][sourceY].name=a[sourceX][sourceY]='_';
		chessComponents[sourceX][sourceY].chessColor=ChessColor.NONE;
		if (currentPlayer==ChessColor.BLACK) currentPlayer=ChessColor.WHITE;
		else currentPlayer=ChessColor.BLACK;
		return true;
	}
	public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
		int x=source.getX(),y=source.getY(),dx,dy;
		ChessboardPoint t;
		ChessColor cur=chessComponents[x][y].chessColor;
		List<ChessboardPoint> ret=chessComponents[x][y].canMoveTo();
		ret=new ArrayList<ChessboardPoint>();
		if (a[x][y]=='k'||a[x][y]=='K'){
			t=source.offset(-1,-1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(-1,0);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(-1,1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(0,-1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(0,1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(1,-1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(1,0);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(1,1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
		}
		if (a[x][y]=='q'||a[x][y]=='Q'){
			dx=-1;dy=-1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=-1;dy=0;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=-1;dy=1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=0;dy=-1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=0;dy=1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=1;dy=-1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=1;dy=0;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=1;dy=1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
		}
		if (a[x][y]=='r'||a[x][y]=='R'){
			dx=-1;dy=0;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=0;dy=-1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=0;dy=1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=1;dy=0;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
		}
		if (a[x][y]=='b'||a[x][y]=='B'){
			dx=-1;dy=-1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=-1;dy=1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=1;dy=-1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
			dx=1;dy=1;
			for (int xx=x+dx,yy=y+dy;xx>=0&&xx<8&&yy>=0&&yy<8;xx+=dx,yy+=dy){
				if (chessComponents[xx][yy].chessColor==cur) break;
				ret.add(new ChessboardPoint(xx,yy));
				if (chessComponents[xx][yy].chessColor!=ChessColor.NONE) break;
			}
		}
		if (a[x][y]=='n'||a[x][y]=='N'){
			t=source.offset(-1,-2);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(-1,2);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(-2,1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(-2,-1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(2,1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(2,-1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(1,2);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(1,-2);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
		}
		if (a[x][y]=='p'){
			t=source.offset(-1,0);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor==ChessColor.NONE) ret.add(t);
			t=source.offset(-1,-1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=ChessColor.NONE
				&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(-1,1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=ChessColor.NONE
				&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			if (x==6){
				t=source.offset(-2,0);
				if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor==ChessColor.NONE
					&&chessComponents[x-1][y].chessColor==ChessColor.NONE) ret.add(t);
			}
		}
		if (a[x][y]=='P'){
			t=source.offset(1,0);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor==ChessColor.NONE) ret.add(t);
			t=source.offset(1,-1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=ChessColor.NONE
				&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			t=source.offset(1,1);
			if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor!=ChessColor.NONE
				&&chessComponents[t.getX()][t.getY()].chessColor!=cur) ret.add(t);
			if (x==1){
				t=source.offset(2,0);
				if (t!=null&&chessComponents[t.getX()][t.getY()].chessColor==ChessColor.NONE
					&&chessComponents[x+1][y].chessColor==ChessColor.NONE) ret.add(t);
			}
		}
		Collections.sort(ret);
		return ret;
	}
	public void loadChessGame(List<String> chessboard){
		for (int i=0;i<8;++i)
			for (int j=0;j<8;++j){
				a[i][j]=chessboard.get(i).charAt(j);
				chessComponents[i][j]=new KingChessComponent();
				chessComponents[i][j].source=new ChessboardPoint(i,j);
				chessComponents[i][j].name=a[i][j];
				if (a[i][j]>='a'&&a[i][j]<='z') chessComponents[i][j].chessColor=ChessColor.WHITE;
				else if (a[i][j]>='A'&&a[i][j]<='Z') chessComponents[i][j].chessColor=ChessColor.BLACK;
				else chessComponents[i][j].chessColor=ChessColor.NONE;
			/*	if (a[i][j]=='k'||a[i][j]=='K') chessComponents[i][j]=new KingChessComponent();
				if (a[i][j]=='q'||a[i][j]=='Q') chessComponents[i][j]=new QueenChessComponent();
				if (a[i][j]=='r'||a[i][j]=='R') chessComponents[i][j]=new RookChessComponent();
				if (a[i][j]=='b'||a[i][j]=='B') chessComponents[i][j]=new BishopChessComponent();
				if (a[i][j]=='n'||a[i][j]=='N') chessComponents[i][j]=new KnightChessComponent();
				if (a[i][j]=='p'||a[i][j]=='P') chessComponents[i][j]=new PawnChessComponent();
				if (a[i][j]=='_') chessComponents[i][j]=new EmptyChessComponent();*/
			}
		if (chessboard.get(8).charAt(0)=='w') currentPlayer=ChessColor.WHITE;
		else currentPlayer=ChessColor.BLACK;
	}
	@Override
	public ChessColor getCurrentPlayer() {
		return this.currentPlayer;
	}
	public ChessComponent getChess(int x, int y){
		return chessComponents[x][y];
	}
	public String getChessboardGraph(){
		String ret="";
		for (int i=0;i<8;++i){
			for (int j=0;j<8;++j) ret+=a[i][j];
			if (i<7) ret+="\n";
		}
		return ret;
	}
	public String getCapturedChess(ChessColor player){
		int cnt=1,num=0;
		if (player==ChessColor.WHITE) num='a'-'A';
		String ret="";
		for (int i=0;i<8;++i)
			for (int j=0;j<8;++j)
				if (a[i][j]=='K'+num) --cnt;
		if (cnt>0) ret+=(char)('K'+num)+" "+cnt+"\n";
		cnt=1;
		for (int i=0;i<8;++i)
			for (int j=0;j<8;++j)
				if (a[i][j]=='Q'+num) --cnt;
		if (cnt>0) ret+=(char)('Q'+num)+" "+cnt+"\n";
		cnt=2;
		for (int i=0;i<8;++i)
			for (int j=0;j<8;++j)
				if (a[i][j]=='R'+num) --cnt;
		if (cnt>0) ret+=(char)('R'+num)+" "+cnt+"\n";
		cnt=2;
		for (int i=0;i<8;++i)
			for (int j=0;j<8;++j)
				if (a[i][j]=='B'+num) --cnt;
		if (cnt>0) ret+=(char)('B'+num)+" "+cnt+"\n";
		cnt=2;
		for (int i=0;i<8;++i)
			for (int j=0;j<8;++j)
				if (a[i][j]=='N'+num) --cnt;
		if (cnt>0) ret+=(char)('N'+num)+" "+cnt+"\n";
		cnt=8;
		for (int i=0;i<8;++i)
			for (int j=0;j<8;++j)
				if (a[i][j]=='P'+num) --cnt;
		if (cnt>0) ret+=(char)('P'+num)+" "+cnt+"\n";
		return ret;
	}
}