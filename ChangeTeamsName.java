import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class ChangeTeamsName implements Command {
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Vector<Team> teams;
    NowCurrentTeam currentTeam;
    GetSetHistory history;
    String previousName;
    String newName;

    public ChangeTeamsName(Vector<Team> teams, NowCurrentTeam currentTeam) {
        this.teams = teams;
        this.currentTeam = currentTeam;
    }

    @Override
    public void execute() {
        try {
            GetSetHistory history = new GetSetHistory();
            previousName = currentTeam.getCurrentTeam().getName();
            history.setpreviousName(previousName);
            System.out.print("Please input new name of the current team:- ");
            newName = br.readLine();
            history.setnewName(newName);
            currentTeam.setCurrentTeamName(newName);

            System.out.println("Team's name is updated.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public boolean match(String input) {
        return "t".equalsIgnoreCase(input);
    }
    @Override
    public void undo() {
        history.getpreviousName();
        currentTeam.setCurrentTeamName(previousName);
    }

    @Override
    public void redo() {
        history.getnewName();
        currentTeam.setCurrentTeamName(newName);
    }
}