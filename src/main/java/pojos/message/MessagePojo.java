package pojos.message;

public class MessagePojo {

    String description;
    String email;
    String name;
    String phone;
    String subject;
    String messageid;

    public String getDescription() {
        return description;
    }

    public MessagePojo setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MessagePojo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public MessagePojo setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public MessagePojo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public MessagePojo setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getMessageid() {
        return messageid;
    }

    public MessagePojo setMessageid(String messageid) {
        this.messageid = messageid;
        return this;
    }
}
