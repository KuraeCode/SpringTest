package spring_jdbc.jdbc_with_spring.core;

import java.io.Serializable;

/**
 * Created by artmaster on 06.06.2017.
 */
public class ContactTelDetails implements Serializable {

    private Long id;
    private Long contactId;
    private String telType;
    private String telNumber;

    @Override
    public String toString() {
        return "ContactTelDetails{" +
                "id=" + id +
                ", contactId=" + contactId +
                ", telType='" + telType + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
