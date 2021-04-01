public class bulletproof extends Player{

    public bulletproof(String playerName, String playerRole) {
        super(playerName, playerRole);
        super.hasRoleOnNight=false;
        super.hasExteraHeart = true;
    }

    @Override
    public void NightRole(Player[] players , String votee){}
}
