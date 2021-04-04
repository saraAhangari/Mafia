import java.util.Scanner;

public class Night {
    Scanner sc = new Scanner(System.in);
    String voter = "", votee = "", first = "", second = "";
    public static int numofNight = 1;
    public static boolean changes = false;

    public int mafiaState(Player[] players) {
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (!Game.allMembers[i].isKilled) {
                if (players[i] instanceof mafia || players[i] instanceof godfather || players[i] instanceof silencer)
                    count++;
            }
        }
        return count;
    }

    public int villagerState(Player[] players) {
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (!Game.allMembers[i].isKilled) {
                if (players[i] instanceof villager || players[i] instanceof bulletproof
                        || players[i] instanceof doctor || players[i] instanceof detective)
                    count++;
            }
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
        String temp;
        outer :for (int i = 0; i < players.length; i++) {
            if (first.equals(players[i].playerName)) {
                for (int j = 0; j < players.length; j++) {
                    if (second.equals(players[j].playerName)) {
                        temp = players[i].playerName;
                        players[i].setPlayerName(players[j].playerName);
                        players[j].setPlayerName(temp);

                        players[i].swapped = true;
                        players[j].swapped = true;
                        break outer;
                    }
                }
            }
        }
    }

    public void midNight(Player[] players) {
        System.out.println("Night " + numofNight);
        numofNight++;
        for (int i = 0; i < players.length; i++) {
            if (players[i].hasRoleOnNight && !Game.allMembers[i].isKilled) {
                System.out.println(players[i].playerName + " : " + players[i].playerRole);
            }
        }
        while (true) {
            voter = sc.next();
            if (voter.equals("end_night")) {
                //swap haye ghabli remove mishe
                for (int i = 0; i < players.length ; i++) {
                    if (players[i].swapped)
                        players[i].swapped = false;
                }
                //swap anjam mishe
                sc.next();
                first = sc.next();
                second = sc.next();

                Player deadVoter = searchPlayer(players, first);
                Player deadVotee = searchPlayer(players, second);

                if (deadVoter.isKilled || deadVotee.isKilled) {
                    System.out.println("user is dead");
                    return;
                }
                Swap(first, second, players);
                //boolean changes baraye methos nightReport dar Game niaz mishe
                changes=true;
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
            //baad az daryafte votee ba tavajoh be naghshesh , methode makhsus farakhani mishe
            foundvoter.NightRole(players,votee);
        }
    }
}
