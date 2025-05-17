public class NowCurrentTeam {
    Team currentTeam;

    public void setCurrentTeam(Team team) {
        this.currentTeam = team;
    }

    public void setCurrentTeamName(String teamname) {
        this.currentTeam.setName(teamname);
    }

    public Team getCurrentTeam() {
        return this.currentTeam;
    }

    @Override
    public String toString() {
        if (currentTeam != null) {
            return currentTeam.getTeamID() + currentTeam.getName();
        } else {
            return "No current team set.";
        }
    }
}