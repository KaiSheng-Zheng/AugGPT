import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class ConcreteChessGame implements ChessGame {

	// A 2-dimension array to store all the chess components
	// should be initialized in your construct method.
	// i.e. = new ChessComponent[8][8]
	private ChessComponent[][] chessComponents;
	// What's the current player's color, black or white?
	// should be initialized in your construct method.
	// by default, set the color to white.
	private ChessColor currentPlayer;

	
	@Override
	public void loadChessGame(List<String> chessboard) {
		// TODO Auto-generated method stub
		chessComponents=new ChessComponent[8][8];
		for (int i = 0; i < chessboard.size(); i++) {
			String line=chessboard.get(i);
			
			for (int j = 0; j < line.length(); j++) {
				char ch=line.charAt(j);
				if (i==8) {
					if (ch=='w') {
						currentPlayer=ChessColor.WHITE;
					}else {
						currentPlayer=ChessColor.BLACK;
					}
					break;
				}
				switch (Character.toLowerCase(ch)) {
				case 'r':
					chessComponents[i][j]=new RookChessComponent(i, j, ch, chessComponents);
					break;
				case 'n':
					chessComponents[i][j]=new KnightChessComponent(i, j, ch, chessComponents);
					break;
				case 'b':
					chessComponents[i][j]=new BishopChessComponent(i, j, ch, chessComponents);
					break;
				case 'q':
					chessComponents[i][j]=new QueenChessComponent(i, j, ch, chessComponents);
					break;
				case 'k':
					chessComponents[i][j]=new KingChessComponent(i, j, ch, chessComponents);
					break;
				case 'p':
					chessComponents[i][j]=new PawnChessComponent(i, j, ch, chessComponents);
					break;
				case '_':
					chessComponents[i][j]=new EmptySlotComponent(i, j, ch, chessComponents);
					break;
				
				
				}
				
			}
		}
		

	}

	@Override
	public ChessColor getCurrentPlayer() {
		// TODO Auto-generated method stub
		return currentPlayer;
	}

	@Override
	public ChessComponent getChess(int x, int y) {
		// TODO Auto-generated method stub
		return chessComponents[x][y];
	}

	@Override
	public String getChessboardGraph() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		for (ChessComponent[] chessComponents2 : chessComponents) {
			for (ChessComponent chessComponent : chessComponents2) {
				stringBuilder.append(chessComponent.name);
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	@Override
	public String getCapturedChess(ChessColor player) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, Integer> hashMap=new LinkedHashMap<>();
		hashMap.put("k", 1);
		hashMap.put("q", 1);
		hashMap.put("r", 2);
		hashMap.put("b", 2);
		hashMap.put("n", 2);
		hashMap.put("p", 8);
		for (ChessComponent[] chessComponents2 : chessComponents) {
			for (ChessComponent chessComponent : chessComponents2) {
				if (chessComponent.getChessColor()==player) {
					String name=chessComponent.name+"";
					name=name.toLowerCase();
					
					if (hashMap.containsKey(name)) {
						hashMap.replace(name, hashMap.get(name)-1);
						
					}
				}
			}
		}
		StringBuilder stringBuilder=new StringBuilder();
		for (Entry<String, Integer> entry:hashMap.entrySet()) {
			if (entry.getValue()>0) {
				stringBuilder.append(entry.getKey()+" "+entry.getValue()+"\n");
			}
		}
		String string=stringBuilder.toString();
		if (player==ChessColor.BLACK) {
			string= string.toUpperCase();
		}
		
		return string;
	}

	@Override
	public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
		// TODO Auto-generated method stub
		ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
		ChessComponent chessComponent=chessComponents[source.getX()][source.getY()];
		arrayList.addAll(chessComponent.canMoveTo());
		return arrayList;
	}

	@Override
	public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
		// TODO Auto-generated method stub
		List<ChessboardPoint> points=getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
		for (ChessboardPoint chessboardPoint : points) {
			if (chessboardPoint.getX()==targetX&&chessboardPoint.getY()==targetY) {
				return true;
			}
		}
		return false;
	}

}
