public abstract class Player {
    public String playerName;
    public String playerRole;
    public boolean isKilled = false;
    public boolean isSilent = false;
    public boolean SavedByDoctor = false;
    public boolean hasRoleOnNight;
    public int voteNum = 0;

    public Player(String playerName , String playerRole) {
        this.playerName = playerName;
        this.playerRole = playerRole;
    }
    public Player(String playerName){
        this.playerName = playerName;
    }

}
