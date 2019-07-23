
package net.middledleeast.tamm.model.validation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Validationfree {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;


    public Validationfree(String username, String phone, String email) {
        this.username = username;
        this.phone = phone;
        this.email = email;
    }

    public Validationfree() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
