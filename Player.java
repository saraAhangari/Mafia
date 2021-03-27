public class Player {
    public String playerName;
    public boolean isAlive;
    public boolean isVillager;
    public boolean isSilenced;
    public boolean isJoker;
    public boolean isSuspect;
    public boolean hasRole;
    public boolean savedByDoctor = false;
    public boolean shotByMafia = false;

    public Player(String playerName) {
        this.playerName = playerName;
    }

}
