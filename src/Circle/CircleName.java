package Circle;

import java.util.Objects;

public class CircleName {
    private String circleName;

    public CircleName(String circleName) throws Exception{
        if(circleName.length()<3 || circleName.length()>20)
        {
            throw new Exception("길이가 안맞음");
        }
        this.circleName = circleName;
    }

    public String getCircleName() {
        return circleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircleName that = (CircleName) o;
        return Objects.equals(circleName, that.circleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(circleName);
    }

    @Override
    public String toString() {
        return  circleName ;
    }
}
