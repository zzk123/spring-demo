package org.zzk.spring.dependency.lifecycle;

/**
 * @ClassName SupperUser
 * @Description TODO
 * @Author zzk
 * @Date 2021/3/8 23:12
 **/
public class SupperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
