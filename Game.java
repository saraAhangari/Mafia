import java.util.Scanner;

public class Game {
    static Player[] players;
    static String[] playerNames;
    static int members = 0;
    public static boolean GameCreated = false;
    public static boolean GameStarted = false;
    public static boolean foundName = false;
    public static boolean foundRole = false;
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
                case "mafia" : System.out.println(playerNames[i] + ": mafia");
                case "villager" : System.out.println(playerNames[i] + ": villager");
                case "doctor" : System.out.println(playerNames[i] + ": doctor");
                case "bulletproof" : System.out.println(playerNames[i] + ": bulletproof");
                case "detective" : System.out.println(playerNames[i] + ": detective");
                case "silencer" : System.out.println(playerNames[i] + ": silencer");
                case "godfather" : System.out.println(playerNames[i] + ": godfather");
                case "joker" : System.out.println(playerNames[i] + ": joker");
                default : System.out.println("one or more player do not have a role");
            }
        }
        NighOn = false;
        GameStarted = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = "", names = "", playersRole = "";
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
                        order = sc.next();
                    }else {
                        showList();
                        System.out.println("Ready? Set! Go...");
                    }
                    break;
            }
        }
    }
}

