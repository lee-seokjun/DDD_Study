package service;

import Circle.CircleTeam;
import Interface.ICircleRepository;
import Repository.CircleRepository;

public class CircleService {
    ICircleRepository iCircleRepository=new CircleRepository();
    public boolean Exists(CircleTeam circle){
        CircleTeam circleTeam = iCircleRepository.Find(circle.getCircleName());
        return circleTeam!=null;
    }
}
