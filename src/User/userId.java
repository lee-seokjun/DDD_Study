package User;

import java.util.Objects;

public class userId {

    private String userId;
    public userId(String userId) throws Exception {
        if(userId.length()<3)
        {
            throw new Exception("User.userId size over 3");
        }
       setUserId(userId);
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        userId userId1 = (userId) o;
        return Objects.equals(userId, userId1.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
