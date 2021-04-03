public class silencer extends Player{

    public silencer(String playerName, String playerRole) {
        super(playerName, playerRole);
        super.hasRoleOnNight=true;
        super.silencerCount=0;
    }

    @Override
    public void NightRole(Player[] players , String votee) {
        if (silencerCount==0){
            for (int i = 0; i < players.length ; i++) {
                if (votee.equals(players[i].playerName)){
                    players[i].isSilent = true;
                    Game.silent = players[i].playerName;
                    Night.changes=true;
                    silencerCount++;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i <players.length ; i++) {
                if (votee.equals(players[i].playerName)){
                    players[i].voteNum++;
                    Night.changes=true;
                    silencerCount++;
                    break;
                }
            }
        }
    }
}
