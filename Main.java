import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector<Team> teams = new Vector<Team>();
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        Command[] cmd = new Command[8];
        NowCurrentTeam currentTeam = new NowCurrentTeam();
        CommandHistory commandHistory = new CommandHistory();

        cmd[0] = new CreateTeam(teams, currentTeam);
        cmd[1] = new SetCurrentTeam(teams, currentTeam);
        cmd[2] = new AddPlayer(teams, currentTeam);
        cmd[3] = new ModifyPlayersPosition(teams, currentTeam);
        cmd[4] = new DeletePlayer(teams, currentTeam);
        cmd[5] = new ShowTeam(teams,currentTeam);
        cmd[6] = new DisplayAllTeams(teams);
        cmd[7] = new ChangeTeamsName(teams, currentTeam);

        while (true) {
            try {
                System.out.println("Sport Teams Management System (STMS)");
                System.out.println("c = create team, g = set current team, a = add player, m = modify player’s position, d = delete player, s = show team, p = display all teams, t = change team’s name, u = undo, r = redo, l = list undo/redo, x = exit system");
                if (currentTeam != null) {
                    System.out.println("The current team is " + currentTeam.toString());
                }
                System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ]: ");
                String line = br.readLine();
                if ("u".equals(line)) {
                    commandHistory.undo();
                } else if ("r".equals(line)) {
                    commandHistory.redo();
                } else if ("l".equals(line)) {
                    commandHistory.list();
                } else if ("e".equals(line)) {
                    System.out.println("-- End --");
                    System.exit(0);
                }else {
                    for (Command command : cmd) {
                        if (command.match(line)) {
                            commandHistory.executeCommand(command);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("*** " + e.getMessage());
            }
            System.out.println();
        }
    }
}