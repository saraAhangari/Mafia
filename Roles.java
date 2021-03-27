import java.util.Arrays;

public class Roles {
    String[] roles ={"Joker", "villager", "detective", "doctor", "bulletproof", "mafia", "godfather", "silencer"};
    Player[] players ;

    public void setPlayers(String[] playersName) {
        players = new Player[playersName.length];
        for (int i = 0; i < playersName.length; i++) {
            players[i] = new Player(playersName[i]);
        }
    }

    public boolean findNames(String Name){
        for (int i = 0; i < players.length ; i++) {
            if (players[i].playerName.equals(Name))
                return true;
        }
        return false;
    }
    
    public boolean findRoles(String role){
        for (int i = 0; i <roles.length ; i++) {
            if (roles[i].equals(role))
                return true;
        }
        return false;
    }

    public void setRoles(String name , String role) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].playerName.equals(name)) {
                players[i].isAlive = true;
            }
            if (role.equals("Joker")) {
                players[i].isJoker = true;
                players[i].hasRole = true;
            }
            else if (role.equals("villager")) {
                players[i].isVillager = true;
                players[i].hasRole = true;
            }
            else if (role.equals("detective")) {
                players[i].isVillager = true;
                players[i].hasRole = true;
            }
            else if (role.equals("doctor")) {
                players[i].isVillager = true;
                players[i].hasRole = true;
            }
            else if (role.equals("bulletproof")) {
                players[i].isVillager = true;
                players[i].hasRole = true;
            }
            else if (role.equals("godfather")) {
                players[i].isVillager = false;
                players[i].hasRole = true;
            }
            else if (role.equals("silencer")) {
                players[i].isVillager = false;
                players[i].hasRole = true;
            }
        }
    }

    @Override
    public String toString() {
        String answer="";
        answer += Arrays.toString(players) + ": " + Arrays.toString(roles) + "\n";
        return answer;
    }
}
