import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = "";
        String players = "";
        String role = "";
        Roles roles = new Roles();
        System.out.println("   Mafia Is Watching You   ");
        System.out.println("To Join the club Enter 0");
        System.out.println("\n 0.Create Game");
        int choice = sc.nextInt();


        while (choice != 0) {
            System.out.println("no game created");
            choice = sc.nextInt();
        }

        players = sc.nextLine();
        String[] split = players.split(" ");

        roles.setPlayers(split);    //set kardane esm ha dar araye

        System.out.println("Bravooo !!!!       Game created :D");
        System.out.println("To continue Enter 1");
        System.out.println("\n 1.Assign Roles");
        choice = sc.nextInt();
        while (choice != 1) {
            System.out.println("Try Again !");
            choice = sc.nextInt();
        }

        for (int i = 0; i < roles.players.length; i++) {
            players = sc.next();
            role = sc.next();
            if (roles.findRoles(role) && roles.findNames(players))
                roles.setRoles(players, role);
            else if (roles.findRoles(role) && !roles.findNames(players))
                System.out.println("User Not Found !");
            else if (!roles.findRoles(role) && roles.findNames(players))
                System.out.println("Role Not Found !");
           /* else if (!roles.players[i].hasRole)
                System.out.println("one or more player do not have a role");*/
        }

        System.out.println("To Start The Game Enter 2");
        System.out.println("\n 2.Start Game");
        choice = sc.nextInt();
        while (choice != 2) {
            System.out.println("Try Again !");
            choice = sc.nextInt();
        }

        for (int i = 0; i <roles.players.length ; i++) {
            roles.players[i].toString();
        }
        System.out.println("Ready? Set! Go...");

        
    }
}
