package factory;

import Circle.CircleId;
import Circle.CircleName;
import Circle.CircleTeam;
import Interface.ICircleFactory;
import User.Member;
import service.CircleService;

import java.util.ArrayList;
import java.util.List;

public class CircleFactory implements ICircleFactory {
    private static CircleService circleService=new CircleService();

    @Override
    public CircleTeam Create(CircleName circleName,Member owner) {
        List<Member> users = new ArrayList<>();
        CircleId circleId = new CircleId("test");
        CircleTeam circle= new CircleTeam(circleId,circleName,owner,users);
        try{
        if(circleService.Exists(circle))
        {
            throw new Exception("이미 존재 합니다.");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return circle;
    }
}
