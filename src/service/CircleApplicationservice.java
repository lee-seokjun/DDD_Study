package service;

import Circle.CircleCreateCommand;
import Circle.CircleJoinCommand;
import Circle.CircleTeam;
import Interface.ICircleFactory;
import Interface.ICircleRepository;
import Interface.IRepository;
import Repository.CircleRepository;
import Repository.CircleRepositoryUserPostgres;
import Repository.UserRepository;
import Repository.UserRepositoryUsePostgre;
import User.Member;
import factory.CircleFactory;

import java.util.List;

public class CircleApplicationservice {
    private ICircleRepository circleRepository = new CircleRepository();
    private IRepository userRepository = new UserRepository();
    private ICircleFactory circleFactory = new CircleFactory();
    private CircleService circleService = new CircleService();
    public void Create(CircleCreateCommand command) throws Exception{
        Member user  = userRepository.getUserById(command.getUserId());
        if(user==null)
        {
            throw new Exception("유저가 없음");
        }
        CircleTeam circleTeam = circleFactory.Create(command.getCircleName(),user);
        if(!circleService.Exists(circleTeam))
        {
            circleRepository.save(circleTeam);
        }
    }


    public void JoinUser(CircleJoinCommand command) throws Exception{
        CircleTeam circle = circleRepository.Find(command.getCircleName());
        Member user  = userRepository.getUserById(command.getUserid());
        if(user==null)
        {
            throw new Exception("not found this user");
        }
        if(circle==null){
            throw new Exception("not found circle");
        }
        circle.getMembers().add(user);
        circleRepository.save(circle);
    }
}
