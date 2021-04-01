public class villager extends Player{

    public villager(String playerName, String playerRole) {
        super(playerName, playerRole);
        super.hasRoleOnNight=false;
    }

    @Override
    public void NightRole(Player[] player , String name) {}
}
