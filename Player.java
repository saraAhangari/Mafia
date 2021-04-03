public abstract class Player {
    public String playerName;
    public String playerRole;
    public String lastVote;
    public boolean isKilled;
    public boolean isSilent;
    public boolean SavedByDoctor;
    public boolean hasRoleOnNight;
    public boolean hasExteraHeart;
    public boolean swapped;
    public int voteNum;
    public int detectiveCount;
    public int silencerCount;
    public int votes;

    public Player(String playerName , String playerRole) {
        this.playerName = playerName;
        this.playerRole = playerRole;
        this.isKilled = false;
        this.isSilent = false;
        this.SavedByDoctor = false;
        this.voteNum=0;
        this.swapped = false;
    }

    public abstract void NightRole(Player[] players , String name);
}
