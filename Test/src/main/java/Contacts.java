public class Contacts {



    private Integer contact_id;
    private Integer contact_date;

    public Contacts(int listing_id, int contact_date){
        this.contact_id = listing_id;
        this.contact_date = contact_date;
    }

    public Integer getContact_id() {
        return contact_id;
    }

    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
    }

    public Integer getContact_date() {
        return contact_date;
    }

    public void setContact_date(Integer contact_date) {
        this.contact_date = contact_date;
    }
}
