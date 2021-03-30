import java.util.Scanner;

public class Night {
    Scanner sc = new Scanner(System.in);
    String voter = "", votee = "";

    public void midNight(Player[] players, int members , boolean foundvotee , boolean foundvoter){
        while (true) {
            voter = sc.next();
            if (voter.equals("end_night"))
                return;
            if (voter.equals("get_game_state")) {
                //method tedad mafia va villager
                continue;
            }
            if (voter.equals("start_game")) {
                System.out.println("game has already started");
                continue;
            }
            votee = sc.next();
            for (int i = 0; i < members; i++) {
                if (voter.equals(players[i].playerName)){
                    if (players[i].playerRole.equals("mafia") || players[i].playerRole.equals("godfather")){
                        foundvoter = true;
                        if (players[i].isSilent) {
                            System.out.println("voter is silenced");
                            break;
                        }
                        if (players[i].isKilled) {
                            System.out.println("voter already dead");
                            break;
                        }
                        if (!players[i].hasRoleOnNight)
                            System.out.println("user can not wake up during night");
                    }
                }
                for (int j = 0; j < members; j++) {
                    if (votee.equals(players[j].playerName))
                        foundvotee = true;
                    if (players[j].isKilled) {
                        System.out.println("votee already dead");
                        return;
                    } else
                        players[j].voteNum++;
                }
            }
            if (!foundvoter || !foundvotee) {
                System.out.println("user not found");
                return;
            }
            return;
        }
    }
}
