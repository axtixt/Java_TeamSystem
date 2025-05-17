import java.util.Vector;

public class ShowTeam implements Command {
    Vector<Team> teams;
    NowCurrentTeam currentTeam;

    public ShowTeam(Vector<Team> teams, NowCurrentTeam currentTeam) {
    this.teams = teams;
	this.currentTeam = currentTeam;
}

    @Override
    public void execute() {
        Team team = currentTeam.getCurrentTeam();
        if (team != null) {
            team.displayTeam();
        } else {
            System.out.println("No current team.");
        }
    }
    @Override
    public boolean match(String input) {
        return "s".equalsIgnoreCase(input);
    }
    @Override
    public void undo() {
    }

    @Override
    public void redo() {
        this.execute();
    }
}