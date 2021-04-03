public class godfather extends Player{

    public godfather(String playerName, String playerRole) {
        super(playerName, playerRole);
        super.hasRoleOnNight=true;
        super.votes=0;
    }

    @Override
    public void NightRole(Player[] players , String votee) {
        if (votes==0){
            for (int i = 0; i < players.length ; i++) {
                if (votee.equals(players[i].playerName) && !players[i].hasExteraHeart){
                    lastVote = players[i].playerName;
                    players[i].voteNum++;
                    votes++;
                    Night.changes=true;
                    break;
                }
                if (votee.equals(players[i].playerName) && players[i].hasExteraHeart){
                    players[i].hasExteraHeart = false;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < players.length ; i++) {
                if (lastVote.equals(players[i].playerName)){
                    players[i].voteNum--;
                    break;
                }
            }
            for (int i = 0; i < players.length; i++) {
                if (votee.equals(players[i].playerName) && !players[i].hasExteraHeart){
                    lastVote = players[i].playerName;
                    players[i].voteNum++;
                    votes++;
                    Night.changes=true;
                    break;
                }
                if (votee.equals(players[i].playerName) && players[i].hasExteraHeart){
                    players[i].hasExteraHeart = false;
                    break;
                }
            }
        }
    }
}