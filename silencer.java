public class silencer extends Player{

    public silencer(String playerName, String playerRole) {
        super(playerName, playerRole);
        super.hasRoleOnNight=false;
    }

    public void silent(Player player){
        player.isSilent = true;
    }
}
