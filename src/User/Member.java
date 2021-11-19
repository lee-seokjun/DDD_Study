package User;

public class Member {
    private userId userId;
    private userName userName;
    private long seq;
    public Member(userName userName, userId userId, long seq)
    {
        setUserId(userId);
        setUserName(userName);
        setSeq(seq);
    }

    public userId getUserId() {
        return userId;
    }

    public userName getUserName() {
        return userName;
    }

    public void setUserId(userId userId) {
        this.userId = userId;
    }

    public void setUserName(userName userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "User.userId=" + userId +
                ", User.userName=" + userName +
                '}';
    }

    public long getSeq() {
        return seq;
    }
    public void setSeq(long seq) {
        this.seq = seq;
    }
}
