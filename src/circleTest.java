import Circle.CircleCreateCommand;
import Circle.CircleJoinCommand;
import Circle.CircleName;
import Circle.CircleTeam;
import Interface.ICircleRepository;
import Repository.CircleRepository;
import User.Member;
import User.userId;
import User.userName;
import service.CircleApplicationservice;

public class circleTest {
    public static void main(String[] args) throws Exception {
        userId userId = new userId("kim");
        CircleName circleName = new CircleName("footBall");
        CircleCreateCommand circleCreateCommand = new CircleCreateCommand(userId,circleName);
        CircleApplicationservice circleApplicationservice = new CircleApplicationservice();
        circleApplicationservice.Create(circleCreateCommand);
        ICircleRepository repository = new CircleRepository();
        CircleTeam circleTeam = repository.Find(circleName);
        System.out.println(circleTeam);
        CircleJoinCommand joinCommand = new CircleJoinCommand(circleName,userId);
        circleApplicationservice.JoinUser(joinCommand);
        circleApplicationservice.JoinUser(joinCommand);

        for (CircleTeam c : repository.getTeams())
        {
            System.out.println(c);
        }
    }
}
