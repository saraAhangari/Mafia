import java.util.Scanner;

public class Game {
    public static Player[] players;
    public static Player[] allMembers;
    public static String[] playerNames;
    public static int members = 0 ;
    public static boolean GameCreated = false;
    public static boolean GameStarted = false;
    public static boolean foundName = false;
    public static boolean mafiaWon = false;
    public static boolean villagerWon = false;
    public static String triedTokill = null;
    public static String silent = null;
    public static String victim = null;
    public static Night night = new Night();
    public static Day day = new Day();

    public static String[] createGame(String[] names, int members) {
        playerNames = new String[members];
        for (int i = 0; i < members; i++) {
            playerNames[i] = names[i];
        }
        players = new Player[members];
        allMembers = new Player[members];
        return playerNames;
    }

    public static void setRoles(String name, String role) {
        switch (role) {
            case "bulletproof":
                for (int i = 0; i < members; i++) {
                    if (name.equals(playerNames[i])) {
                        players[i] = new bulletproof(name, role);
                        allMembers[i] = new bulletproof(name,role);
                        players[i].hasRoleOnNight = false;
                        foundName = true;
                        break;
                    }
                }
                if (!foundName)
                    System.out.println("user not found");
                break;
            case "detective":
                for (int i = 0; i < members; i++) {
                    if (name.equals(playerNames[i])) {
                        players[i] = new detective(name, role);
                        allMembers[i] = new detective(name , role);
                        players[i].hasRoleOnNight = true;
                        foundName = true;
                        break;
                    }
                }
                if (!foundName)
                    System.out.println("user not found");
                break;
            case "doctor":
                for (int i = 0; i < members; i++) {
                    if (name.equals(playerNames[i])) {
                        players[i] = new doctor(name, role);
                        allMembers[i] = new doctor(name , role);
                        players[i].hasRoleOnNight = true;
                        foundName = true;
                        break;
                    }
                }
                if (!foundName)
                    System.out.println("user not found");
                break;
            case "godfather":
                for (int i = 0; i < members; i++) {
                    if (name.equals(playerNames[i])) {
                        players[i] = new godfather(name, role);
                        allMembers[i] = new godfather(name , role);
                        players[i].hasRoleOnNight = false;
                        foundName = true;
                        break;
                    }
                }
                if (!foundName)
                    System.out.println("user not found");
                break;
            case "Joker":
                for (int i = 0; i < members; i++) {
                    if (name.equals(playerNames[i])) {
                        players[i] = new Joker(name, role);
                        allMembers[i] = new Joker(name , role);
                        players[i].hasRoleOnNight = false;
                        foundName = true;
                        break;
                    }
                }
                if (!foundName)
                    System.out.println("user not found");
                break;
            case "mafia":
                for (int i = 0; i < members; i++) {
                    if (name.equals(playerNames[i])) {
                        players[i] = new mafia(name, role);
                        allMembers[i] = new mafia(name , role);
                        players[i].hasRoleOnNight = true;
                        foundName = true;
                        break;
                    }
                }
                if (!foundName)
                    System.out.println("user not found");
                break;
            case "silencer":
                for (int i = 0; i < members; i++) {
                    if (name.equals(playerNames[i])) {
                        players[i] = new silencer(name, role);
                        allMembers[i] = new silencer(name , role);
                        players[i].hasRoleOnNight = false;
                        foundName = true;
                        break;
                    }
                }
                if (!foundName)
                    System.out.println("user not found");
                break;
            case "villager":
                for (int i = 0; i < members; i++) {
                    if (name.equals(playerNames[i])) {
                        players[i] = new villager(name, role);
                        allMembers[i] = new villager(name , role);
                        players[i].hasRoleOnNight = false;
                        foundName = true;
                        break;
                    }
                }
                if (!foundName)
                    System.out.println("user not found");
                break;
            default:
                System.out.println("role not found");
        }
    }

    public static boolean invalidRole(Player[] players , int members){
        for (int i = 0; i < members; i++) {
            if (players[i] == null)
                return true;
        }
        return false;
    }
    public static void endVote() {
        int max = 0;
        int count = 0;
        for (int i = 0; i < members; i++) {
            if (players[i].voteNum >= max )
                max = players[i].voteNum;
        }
        for (int i = 0; i < members; i++) {
            if (players[i].voteNum == max ) {
                players[i].isKilled = true;
                count++;
            }
        }
        if (count > 1) {
            System.out.println("nobody died");
            for (int i = 0; i < members; i++) {
                players[i].isKilled = false;
            }
            return;
        }
        for (int i = 0; i < members; i++) {
            if (players[i].isKilled && (players[i] instanceof Joker) && !players[i].SavedByDoctor) {
                System.out.println("Joker won!");
                System.exit(0);
            }
            else if (players[i].isKilled && !(players[i] instanceof Joker) && !players[i].SavedByDoctor) {
                System.out.println(players[i].playerName + " is dead");
                allMembers[i].isKilled = true;
                break;
            }
        }
    }

    public static boolean getStatus(Player[] players , boolean answer){
        int countVillager = 0 , countMafia=0;
        for (int i = 0; i < members; i++) {
            if (players[i] instanceof mafia || players[i] instanceof godfather
                    || players[i] instanceof silencer)
                countMafia++;
            else if (!(players[i] instanceof Joker) && !(players[i] instanceof mafia)
                    && !(players[i] instanceof godfather) && !(players[i] instanceof silencer))
                countVillager++;
        }
        if (answer){
            System.out.println("Mafia : " + countMafia);
            System.out.println("Villager : " + countVillager);
        }
        if (countMafia==0){
            villagerWon=true;
            return true;
        }
        else if (countVillager <= countMafia){
            mafiaWon=true;
            return true;
        }
        return false;
    }

    public static void NightReport(Player[] players) {
        int max = 0, count = 0;
        if (Night.changes) {
            for (int i = 0; i < players.length; i++) {
                if (players[i].voteNum >= max && !players[i].SavedByDoctor && !players[i].hasExteraHeart) {
                    max = players[i].voteNum;
                }
            }
            for (int i = 0; i < players.length; i++) {
                if (players[i].voteNum == max && !players[i].SavedByDoctor && !players[i].hasExteraHeart) {
                    players[i].isKilled = true;
                    playerNames[i] = null;
                    triedTokill = players[i].playerName;
                    count++;
                }
            }
            if (count > 1)
                triedTokill = null;
            else if (triedTokill != null) {
                System.out.println("mafia tried to kill " + triedTokill);
                System.out.println(triedTokill + " was killed");
            }
            for (int i = 0; i < players.length; i++) {
                if (players[i].isSilent) {
                    System.out.println("Silenced " + silent);
                }
            }
            for (int i = 0; i < players.length; i++) {
                for (int j = 0; j < players.length; j++) {
                    if (players[i].swapped && players[j].swapped) {
                        System.out.println(players[i].playerName + " swapped characters with " + players[j].playerName);
                    }
                }
            }
        }
        day.outDeadOnes(players);
    }

    public static void showList(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            switch (players[i].playerRole) {
                case "mafia":
                    System.out.println(players[i].playerName + ": mafia");
                    break;
                case "villager":
                    System.out.println(players[i].playerName + ": villager");
                    break;
                case "doctor":
                    System.out.println(players[i].playerName + ": doctor");
                    break;
                case "bulletproof":
                    System.out.println(players[i].playerName + ": bulletproof");
                    break;
                case "detective":
                    System.out.println(players[i].playerName + ": detective");
                    break;
                case "silencer":
                    System.out.println(players[i].playerName + ": silencer");
                    break;
                case "godfather":
                    System.out.println(players[i].playerName + ": godfather");
                    break;
                case "Joker":
                    System.out.println(players[i].playerName + ": Joker");
                    break;
                default:
                    System.out.println("role not found");
                    break;
            }
        }
        GameStarted = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = "", names = "", playersRole = "";
        String[] splits = null;
        System.out.println("   Mafia Is Watching You !   ");
        System.out.println("   To Join the club Enter 'create_game' and players      ");

        first : while (true) {
            order = sc.next();
            switch (order) {
                case "create_game":
                    if (!GameCreated) {
                        names = sc.nextLine().replaceFirst(" ", "");
                        splits = names.split(" ");
                        members = splits.length;
                        createGame(splits, members);
                        GameCreated = true;
                        break;
                    } else {
                        System.out.println("game already started");
                        continue;
                    }

                case "assign_role":
                    if (!GameCreated) {
                        System.out.println("no game created");
                        continue first;
                    } else {
                        names = sc.next();
                        playersRole = sc.next();
                        setRoles(names, playersRole);
                    }
                    break;

                case "get_game_state":
                    getStatus(players, true);
                    break;

                case "start_game":
                    if (GameStarted) {
                        System.out.println("game has already started");
                        continue first;
                    }
                    if (!GameCreated) {
                        System.out.println("no game created");
                        System.out.println("Enter create_game first");
                        continue first;
                    }
                    if (invalidRole(players, members)) {
                        System.out.println("one or more player do not have a role");
                        continue first;
                    }
                    showList(players);
                    System.out.println("Ready? Set! Go...");
                    System.out.println();
                    while (true) {
                        day.sunRise(players);
                        endVote();
                        day.outDeadOnes(players);
                        if (getStatus(players, false))
                            break first;
                        night.midNight(players);
                        //NightReport(players);
                        //day.outDeadOnes(players);
                        if (getStatus(players, false))
                            break first;
                    }
            }
        }
        if (villagerWon)
            System.out.println("villager Won :D ");
        else if (mafiaWon)
            System.out.println("Mafia Won :/ ");
    }
}

