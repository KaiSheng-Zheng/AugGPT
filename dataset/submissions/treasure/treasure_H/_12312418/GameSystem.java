import java.util.*;
public class GameSystem {
    public static int a5=0;
    int v=0;
    public static ArrayList<Player> players=new ArrayList<Player>();
    public void addPlayer(Player player){
players.add(player);
        a5++;
        v++;
    }
    public Map newGame(int rows, int columns, Treasure... treasures){
return new Map(rows,columns,treasures);
    }

    public Player getWinner(){
        Player c;
for(int i=a5;i>=a5-v+2;i--){
    if(Player.arsp[i-1]>Player.arsp[i-2]){
        Player.arsp[i-2]=Player.arsp[i-1];
        c=players.get(i-1);
players.remove(i-1);
players.add(i-2,c);
    }
    else if(Player.arsp[i-1]==Player.arsp[i-2]){
        if(Player.arr2[i-1]<Player.arr2[i-2]){
            Player.arsp[i-2]=Player.arsp[i-1];
            c=players.get(i-1);
            players.remove(i-1);
            players.add(i-2,c);
        }
    }
}
Player d=players.get(a5-v);
return d;
    }
}
