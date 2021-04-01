public class Joker extends Player{

    public Joker(String playerName, String playerRole) {
        super(playerName, playerRole);
        super.hasRoleOnNight=false;
    }

    @Override
    public void NightRole(Player[] players , String votee){}
}
