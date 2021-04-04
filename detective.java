public class detective extends Player {
    public detective(String playerName, String playerRole) {
        super(playerName, playerRole);
        super.hasRoleOnNight = true;
        super.detectiveCount = 0;
    }

    @Override
    public void NightRole(Player[] players, String votee) {
        if (detectiveCount != 0) {
            System.out.println("detective has already asked");
        } else {
            for (int i = 0; i < players.length; i++) {
                if (votee.equals(players[i].playerName)) {
                    if (Game.allMembers[i].isKilled) {
                        System.out.println("suspect is dead");
                        return;
                    }
                }
            }
            for (int i = 0; i < players.length; i++) {
                if (votee.equals(players[i].playerName)) {
                    if (players[i] instanceof mafia || players[i] instanceof silencer) {
                        System.out.println("YES");
                        detectiveCount++;
                    } else {
                        System.out.println("NO");
                        detectiveCount++;
                    }
                }
            }
        }
    }

}
