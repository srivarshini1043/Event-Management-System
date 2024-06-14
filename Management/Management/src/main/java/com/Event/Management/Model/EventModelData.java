package com.Event.Management.Model;

        import java.sql.Date;
        import java.sql.Time;

        import com.fasterxml.jackson.annotation.JsonFormat;

        import jakarta.persistence.Column;
        import jakarta.persistence.Entity;
        import jakarta.persistence.GeneratedValue;
        import jakarta.persistence.GenerationType;
        import jakarta.persistence.Id;
        import jakarta.persistence.Lob;
        import jakarta.persistence.Table;

@Entity
@Table(name = "event")
public class EventModelData {

    @Id
    @Column(name = "id", length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(name = "eventtitle", length = 100)
    public String eventtitle;

    @Column(name = "eventdescription", length = 100)
    public String eventdescription;



    @Column(name = "user", length = 100)
    public String user;

    @Column(name = "eventtype", length = 100)
    public String eventtype;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "eventdate", length = 100)
    public Date eventdate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "hh:mm")
    @Column(name = "eventtime", length = 100)
    public String eventtime;

    @Column(name = "location", length = 100)
    public String location;

    @Column(name = "attendees", length = 100)
    public String attendees;

    @Lob
    @Column(name = "brochure" ,length = 1000000000*900000800)
    public String brochure;

    public EventModelData() {

    }

    public String getBrochure() {
        return brochure;
    }

    public void setBrochure(String brochure) {
        this.brochure = brochure;
    }

    public EventModelData(String eventtitle, String eventdescription, String eventtype, Date eventdate, String eventtime,
                          String location, String attendees,String user,String brochure) {
        super();
        this.eventtitle = eventtitle;
        this.eventdescription = eventdescription;
        this.eventtype = eventtype;
        this.eventdate = eventdate;
        this.eventtime = eventtime;
        this.location = location;
        this.attendees = attendees;
        this.user=user;
        this.brochure=brochure;
    }

    public Integer getId() {
        return this.id;
    }

    public void setuser(String user) {
        this.user = user;
    }

    public String getuser() {
        return this.user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteventtitle() {
        return this.eventtitle;
    }

    public void seteventtitle(String eventtitle) {
        this.eventtitle = eventtitle;
    }

    public String geteventdescription() {
        return this.eventdescription;
    }

    public void seteventdescription(String eventdescription) {
        this.eventdescription = eventdescription;
    }

    public String geteventtype() {
        return this.eventtype;
    }

    public void seteventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public Date geteventdate() {
        return eventdate;
    }

    public void seteventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public String geteventtime() {
        return this.eventtime;
    }

    public void seteventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    public String getlocation() {
        return this.location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public String getattendees() {
        return this.attendees;
    }

    public void setattendees(String attendees) {
        this.attendees = attendees;
    }

}
