package pojos.branding;

import java.util.Map;

public class BrandingPojo {

    private String name;
    private Map map;
    private String logoUrl;
    private String description;
    private ContactPojo contactPojo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ContactPojo getContactPojo() {
        return contactPojo;
    }

    public void setContactPojo(ContactPojo contactPojo) {
        this.contactPojo = contactPojo;
    }

}