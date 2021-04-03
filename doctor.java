public class doctor extends Player{

    public doctor(String playerName, String playerRole) {
        super(playerName, playerRole);
        super.hasRoleOnNight=true;
    }

    @Override
    public void NightRole(Player[] players, String votee)  {
        for (int i = 0; i < players.length ; i++) {
            if (votee.equals(players[i].playerName)){
                players[i].SavedByDoctor = true;
                break;
            }
        }
    }
}
