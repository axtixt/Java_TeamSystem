public class GetSetHistory{

public int position;
public Player player;
private Team team;
private String sportType;
private String teamId;
private String teamname;
private Player deletedplayer;
private Team setcurrentteam;
private int oldposition;
private Player modifiedplayer;
private String previousName;
private String newName;

public void setplayerHistory(Player player){
        this.player = player;
    }

    public Player getplayerHistory(){
        return player;
    }

    public void setpositionHistory(int position){
        this.position = position;
    }

    public int getpositionrHistory(){
        return position;
    }

    public void setTeamHistory(Team team){
        this.team = team;
    }

    public Team getTeamHistory(){
        return team;
    }

    public void setSportTypeHistory(String sportType){
        this.sportType = sportType;
    }

    public String getSportTypeHistory(){
        return sportType; 
    }

    public void setTeamIdHistory(String teamId){
        this.teamId = teamId;
    }

    public String getTeamIdHistory(){
        return teamId;
    }

    public void setTeamnameHistory(String teamname){
        this.teamname = teamname;
    }

    public String getTeamnameHistory(){
        return teamname;
    }

    public void setDeletedPlayer(Player deletedplayer){
        this.deletedplayer = deletedplayer;
    }

    public Player getDeletedPlayer(){
        return deletedplayer;
    }

    public void setSetCurrentTeam(Team setcurrentteam){
        this.setcurrentteam = setcurrentteam;
    }

    public Team getSetCurrentTeam(){
        return setcurrentteam;
    }

    public void setoldPosition(int oldposition){
        this.oldposition = oldposition;
    }

    public int getoldPosition(){
        return oldposition;
    }

    public void setmodifiedPlayer(Player modifiedplayer){
        this.modifiedplayer = modifiedplayer;
    }

    public Player getmodifiedPlayer(){
        return modifiedplayer;
    }

    public void setpreviousName(String previousName){
        this.previousName = previousName;
    }

    public String getpreviousName(){
        return previousName;
    }

    public void setnewName(String newName){
        this.newName = newName;
    }

    public String getnewName(){
        return newName;
    }
    }