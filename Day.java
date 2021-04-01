import java.util.Scanner;

public class Day {
    Scanner sc = new Scanner(System.in);
    String voter = "", votee = "";
    public int numofDay = 1;
    public static boolean GameStarted = false;
    public static Player[] victimPlayers;

    public int mafiaState(Player[] players) {
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].playerRole.equals("mafia") || players[i].playerRole.equals("godfather"))
                count++;
        }
        return count;
    }

    public int villagerState(Player[] players) {
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].playerRole.equals("villager"))
                count++;
        }
        return count;
    }

    public void outDeadOnes(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            players[i].voteNum = 0;
        }
    }

    public void sunRise(Player[] players) {
        System.out.println("Day " + numofDay);
        Game.NightReport(players);
        numofDay++;
        while (true) {
            voter = sc.next();
            if (voter.equals("end_vote"))
                break;
            if (voter.equals("get_game_state")) {
                System.out.println("Mafia : " + mafiaState(players));
                System.out.println("Villager : " + villagerState(players));
                continue;
            }
            if (voter.equals("start_game")) {
                System.out.println("the game has already began");
                continue;
            }
            votee = sc.next();
            boolean voterFound = false;
            outer :for (int i = 0; i < players.length; i++) {
                if (voter.equals(players[i].playerName) && !Game.allMembers[i].isKilled) {
                    voterFound = true;
                    if (players[i].isSilent) {
                        System.out.println("voter is silent");
                        break;
                    } else if (!players[i].isSilent) {
                        for (int j = 0; j < players.length; j++) {
                            if (votee.equals(players[j].playerName) && Game.allMembers[j].isKilled) {
                                System.out.println("votee already dead");
                                break outer;
                            } else if (votee.equals(players[j].playerName) && !Game.allMembers[j].isKilled) {
                                players[j].voteNum++;
                                break outer;
                            }
                        }
                    }
                }
            }
            if (!voterFound) {
                System.out.println("user not found");
            }
        }
    }
}
