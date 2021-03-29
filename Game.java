import java.util.Scanner;

public class Game {
    static Player[] players;
    static String[] playerNames;
    static int members = 0;
    static int numofDay =1;
    static int numofNight=1;
    public static boolean GameCreated = false;
    public static boolean GameStarted = false;
    public static boolean foundName = false;
    public static boolean foundvoter = false;
    public static boolean NighOn = false;
    public static String[] Roles = {"Joker", "villager", "detective", "doctor", "bulletproof", "mafia", "godfather", "silencer"};

    public static String[] createGame(String[] names, int members) {
        playerNames = new String[members];
        for (int i = 0; i < members; i++) {
            playerNames[i] = names[i];
        }
        players = new Player[members];
        return playerNames;
    }

    public static void setRoles(String name, String role) {
        switch (role) {
            case "bulletproof":
                for (int i = 0; i < members; i++) {
                    if (name.equals(playerNames[i])) {
                        players[i] = new bulletproof(name, role);
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

    public static void showList() {
        for (int i = 0; i < members; i++) {
            switch (players[i].playerRole) {
                case "mafia" : System.out.println(playerNames[i] + ": mafia");break;
                case "villager" : System.out.println(playerNames[i] + ": villager");break;
                case "doctor" : System.out.println(playerNames[i] + ": doctor");break;
                case "bulletproof" : System.out.println(playerNames[i] + ": bulletproof");break;
                case "detective" : System.out.println(playerNames[i] + ": detective");break;
                case "silencer" : System.out.println(playerNames[i] + ": silencer");break;
                case "godfather" : System.out.println(playerNames[i] + ": godfather");break;
                case "joker" : System.out.println(playerNames[i] + ": joker");break;
                default : System.out.println("one or more player do not have a role");break;
            }
        }
        NighOn = false;
        GameStarted = true;
    }

    public static void vote(String voter , String votee) {
        for (int i = 0; i <members ; i++) {
            if (voter.equals(players[i].playerName)) {
                foundvoter = true;
                if (players[i].isSilent) {
                    System.out.println("voter is silenced");
                    break;
                }
            }
            for (int j = 0; j <members ; j++) {
                if (votee.equals(players[j].playerName))
                    if (players[j].isKilled)
                        System.out.println("votee already dead");
                    else
                        players[j].voteNum++;
            }
        }
        if (!foundvoter)
            System.out.println("user not found");
    }

    public static void endVote(){
        int max=0;
        int count=0;
        String qorbani="";
        for (int i = 0; i <members ; i++) {
            if (players[i].voteNum >=max)
                max = players[i].voteNum;
        }
        for (int i = 0; i <members ; i++) {
            if (players[i].voteNum == max) {
                players[i].isKilled = true;
                count++;
            }
        }
        if (count>1) {
            System.out.println("nobody died");
            for (int i = 0; i < members; i++) {
                players[i].isKilled = false;
            }
            return;
        }
        for (int i = 0; i <members ; i++) {
            if (players[i].isKilled && players[i].playerRole.equals("Joker"))
                System.out.println("Joker won!");
            else if (players[i].isKilled && !players[i].playerRole.equals("Joker")) {
                qorbani = players[i].playerName;
            }
        }
            System.out.println(qorbani + " is dead");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = "", names = "", playersRole = "" , voter="" , votee="";
        String[] role = {"Joker", "villager", "detective", "doctor", "bulletproof", "mafia", "godfather", "silencer"};
        String[] splits = null;
        System.out.println("   Mafia Is Watching You !   ");
        System.out.println("   To Join the club Enter 'create_game'      ");
        while (true) {
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
                    }else if (GameCreated) {
                        System.out.println("game already started");
                        continue;
                    }
                    break;

                case "assign_role":
                    if (!GameCreated) {
                        System.out.println("no game created");
                        continue;
                    } else {
                            names = sc.next();
                            playersRole = sc.next();
                            setRoles(names, playersRole);
                    }
                    break;
                case "start_game":
                    if (GameStarted)
                        System.out.println("game has already started");
                    if (!GameCreated) {
                        System.out.println("no game created");
                        System.out.println("Enter create_games");
                        break;
                    }else {
                        showList();
                        System.out.println("Ready? Set! Go...");
                        System.out.println();
                        System.out.println("Day : " + numofDay );
                        numofDay++;
                        System.out.println("Now you can vote");
                    }
                    break;
                case "vote":
                    voter = sc.next();
                    votee = sc.next();
                    vote(voter , votee);
                    break;
                case "end_vote":
                    endVote();
                    System.out.println();
                    System.out.println("Night : " + numofNight );
                    numofNight++;
                    break;
            }
        }
    }
}

