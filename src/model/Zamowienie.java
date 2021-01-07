package model;

import java.util.Date;

public class Zamowienie {

    int id;
    String is_done;
    Date submission_date;
    Date suspected_realization;
    int client_id;

    public Zamowienie(int id, String is_done, Date submission_date, Date suspected_realization, int client_id) {
        this.id = id;
        this.is_done = is_done;
        this.submission_date = submission_date;
        this.suspected_realization = suspected_realization;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIs_done() {
        return is_done;
    }

    public void setIs_done(String is_done) {
        this.is_done = is_done;
    }

    public Date getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(Date submission_date) {
        this.submission_date = submission_date;
    }

    public Date getSuspected_realization() {
        return suspected_realization;
    }

    public void setSuspected_realization(Date suspected_realization) {
        this.suspected_realization = suspected_realization;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
}
