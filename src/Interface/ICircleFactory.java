package Interface;

import Circle.CircleName;
import Circle.CircleTeam;
import User.Member;

public interface ICircleFactory {
    CircleTeam Create(CircleName circleName,Member owner);
}
