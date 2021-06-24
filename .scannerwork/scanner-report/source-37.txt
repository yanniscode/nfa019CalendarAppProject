package fr.cnam.pdatabase.managment.model;

import fr.cnam.pdatabase.managment.model.DatePart;

public class DateActivityItem implements DateActivityItemInterface {

    private int dateActivityId;
    private String datePartDescription;
    private String datePartStatus;
    private DatePart datePart;

    /**
     *  constructor 2
     */
    public DateActivityItem(DatePart datePart) {
        super();
        this.datePart = datePart;
    }

    /**
     * Default constructor
     */
    public DateActivityItem() {
        super();
    }

    // **********

    public DatePart getDatePart() {
        return this.datePart;
    }

    public void setDatePart(DatePart datePart) {
        System.out.println(datePart);
        this.datePart = datePart;
        return;
    }

    // ***********

    public int getDateActivityId() {
        return this.dateActivityId;
    }
    public void setDateActivityId(int dateActivityId) {
        this.dateActivityId = dateActivityId;
        return;
    }

    public String getDateActivityDescription() {
        return this.datePartDescription;
    }

    public void setDateActivityDescription(String datePartDescription) {
        this.datePartDescription = datePartDescription;
    }

    public String getDateActivityStatus() {
        return this.datePartStatus;
    }

    public void setDateActivityStatus(String datePartStatus) {
        this.datePartStatus = datePartStatus;
        return;
    }

    @Override
    public void displayActivity() {
        // à voir
    }
}
