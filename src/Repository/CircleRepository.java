package Repository;

import Circle.CircleId;
import Circle.CircleName;
import Circle.CircleTeam;
import Interface.ICircleRepository;
import User.Member;
import User.userId;
import User.userName;
import service.CircleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircleRepository implements ICircleRepository {

    private static List<CircleTeam> list = new ArrayList<>();
    private static final CircleService circleService= new CircleService();
    static {
        CircleId circleId = new CircleId("circleId");
        CircleName circleName = null;
        userName userName=null;
        userId userId =null;
        try {
            circleName = new CircleName("testttt");
            userName= new userName("name");
            userId = new userId("testId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Member member = new Member(userName,userId,0);
        List<Member> members = new ArrayList<>();
        members.add(member);
        CircleTeam circle = new CircleTeam(circleId,circleName, member,members);
        list.add(circle);
    }
    @Override
    public void save(CircleTeam circle) {
        if(!list.contains(circle))
        {
            list.add(circle);
        }
        else{
            list.set(list.indexOf(circle),circle);
        }


    }

    @Override
    public CircleTeam Find(CircleId id) {
        Optional<CircleTeam> circleTeam=list.stream().filter(s->s.getCircleId().equals(id)).findFirst();

        return circleTeam.orElse(null);
    }

    @Override
    public CircleTeam Find(CircleName name) {
        Optional<CircleTeam> circleTeam=list.stream().filter(s->s.getCircleName().equals(name)).findFirst();
        return circleTeam.orElse(null);
    }

    @Override
    public int CircleCount() {
        return list.size();
    }

    @Override
    public List<CircleTeam> getTeams() {
        return list;
    }
}
