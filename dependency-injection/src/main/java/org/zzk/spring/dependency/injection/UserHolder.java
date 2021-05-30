package org.zzk.spring.dependency.injection;

/**
 * @ClassName UserHolder
 * @Description TODO
 * @Author zzk
 * @Date 2021/3/8 23:18
 **/
public class UserHolder {

    private User user;

    public UserHolder(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
