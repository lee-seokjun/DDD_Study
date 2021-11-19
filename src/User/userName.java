package User;

import java.util.Objects;

public class userName {

    private String name;

    public userName(String name) throws Exception {

        if(name.length()<3)
        {
            throw new Exception("name size over 3");
        }
        setName(name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        userName userName = (userName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
