import java.util.Scanner;

public class Night {
    Scanner sc = new Scanner(System.in);
    String voter = "", votee = "", first = "", second = "";
    public static int numofNight = 1;
    public static boolean changes = false;
    int swap = 0;

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


    public Player searchPlayer(Player[] players, String name) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].playerName.equals(name))
                return players[i];
        }
        return null;
    }

    public void Swap(String first, String second, Player[] players) {
        Player temp;
        for (int i = 0; i < players.length; i++) {
            if (first.equals(players[i].playerName)) {
                for (int j = 0; j < players.length; j++) {
                    if (second.equals(players[j].playerName)) {
                        temp = players[i];
                        players[i] = players[j];
                        players[j] = temp;

                        players[i].swapped = true;
                        players[j].swapped = true;
                    }
                }
            }
        }
    }

    public void midNight(Player[] players) {
        System.out.println("Night " + numofNight);
        numofNight++;
        for (int i = 0; i < players.length; i++) {
            if (players[i].hasRoleOnNight && !players[i].isKilled) {
                System.out.println(players[i].playerName + " : " + players[i].playerRole);
            }
        }
        while (true) {
            voter = sc.next();
            if (voter.equals("end_night")) {
                sc.next();
                first = sc.next();
                second = sc.next();
                if (swap > 1) {
                    System.out.println("characters already swapped");
                    break;
                }

                Player deadVoter = searchPlayer(players, first);
                Player deadVotee = searchPlayer(players, second);

                if (deadVoter.isKilled || deadVotee.isKilled) {
                    System.out.println("user is dead");
                    return;
                }
                Swap(first, second, players);
                changes=true;
                swap++;
                break;
            }
            if (voter.equals("get_game_state")) {
                System.out.println("Mafia : " + mafiaState(players));
                System.out.println("Villager : " + villagerState(players));
                continue;
            }
            if (voter.equals("start_game")) {
                System.out.println("game has already started");
                continue;
            }
            if (voter.equals("swap_character")) {
                System.out.println("can’t swap before end of the night");
                sc.nextLine();
                continue;
            }
            votee = sc.next();

            Player foundvoter = searchPlayer(players, voter);
            Player foundvotee = searchPlayer(players, votee);

            if (foundvotee == null || foundvoter == null) {
                System.out.println("user not joined");
                continue;
            }

            if (foundvotee.isKilled || foundvoter.isKilled) {
                System.out.println("user is dead");
                continue;
            }

            if (!foundvoter.hasRoleOnNight) {
                System.out.println("user can not wake up during night");
                continue;
            }
            foundvoter.NightRole(players,votee);
        }
    }
}
