public abstract class Player {
    public String playerName;
    public String playerRole;
    public boolean isKilled = false;
    public boolean isSilent = false;
    public boolean SavedByDoctor = false;
    public boolean hasRoleOnNight;
    public int voteNum = 0;
    protected int hearts = 0 ;
    public Player lastVotee = null;

    public Player(String playerName , String playerRole) {
        this.playerName = playerName;
        this.playerRole = playerRole;
    }
    public Player(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(String playerRole) {
        this.playerRole = playerRole;
    }
}
