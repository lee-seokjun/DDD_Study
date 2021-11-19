package Circle;

import java.util.Objects;

public class CircleId {
    private String circleId;
    public CircleId(String circleId){
        this.circleId=circleId;
    }

    public String getCircleId() {
        return circleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircleId circleId1 = (CircleId) o;
        return Objects.equals(circleId, circleId1.circleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(circleId);
    }

    @Override
    public String toString() {
        return circleId ;
    }
}
