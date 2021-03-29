public class silencer extends Player{

    public silencer(String playerName, String playerRole) {
        super(playerName, playerRole);
    }

    public void silent(Player player){
        player.isSilent = true;
    }
}
