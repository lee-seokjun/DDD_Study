package Circle;

import User.Member;
import java.util.List;
import java.util.Objects;


public class CircleTeam {
    private CircleId circleId;
    private CircleName circleName;
    private Member owner;
    private List<Member> members;

    public CircleTeam(CircleId circleId, CircleName circleName, Member owner, List<Member> members) {
        this.circleId = circleId;
        this.circleName = circleName;
        this.owner = owner;
        this.members = members;
    }
    public CircleId getCircleId() {
        return circleId;
    }
    public CircleName getCircleName() {
        return circleName;
    }

    public Member getOwner() {
        return owner;
    }
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Circle.CircleTeam{" +
                "circleId=" + circleId.getCircleId() +
                ", circleName=" + circleName.getCircleName() +
                ", owner=" + owner +
                ", members=" + members +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircleTeam that = (CircleTeam) o;
        return Objects.equals(circleId, that.circleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(circleId);
    }
}
