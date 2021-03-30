import java.util.Scanner;

public class Day {
    Scanner sc = new Scanner(System.in);
    String voter = "", votee = "";

    public void sunRise(Player[] players, int members, boolean foundvotee , boolean foundvoter) {
        while (true) {
            voter = sc.next();
            votee = sc.next();
            for (int i = 0; i < members; i++) {
                if (voter.equals(players[i].playerName)) {
                    foundvoter = true;
                    if (players[i].isSilent) {
                        System.out.println("voter is silenced");
                        break;
                    }
                }
                for (int j = 0; j < members; j++) {
                    if (votee.equals(players[j].playerName))
                        foundvotee=true;
                        if (players[j].isKilled) {
                            System.out.println("votee already dead");
                            return;
                        }
                        else
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
