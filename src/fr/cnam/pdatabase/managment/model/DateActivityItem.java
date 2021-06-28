package fr.cnam.pdatabase.managment.model;


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


    /**
     * @return DatePart
     */
    public DatePart getDatePart() {
        return this.datePart;
    }


    /**
     * @param datePart
     * @return void
     */
    public void setDatePart(DatePart datePart) {
        this.datePart = datePart;
    }


    /**
     * @return int
     */
    public int getDateActivityId() {
        return this.dateActivityId;
    }


    /**
     * @param dateActivityId
     * @return void
     */
    public void setDateActivityId(int dateActivityId) {
        this.dateActivityId = dateActivityId;
    }


    /**
     * @return String
     */
    public String getDateActivityDescription() {
        return this.datePartDescription;
    }


    /**
     * @param datePartDescription
     * @return void
     */
    public void setDateActivityDescription(String datePartDescription) {
        this.datePartDescription = datePartDescription;
    }

    /**
     * @return String
     */
    public String getDateActivityStatus() {
        return this.datePartStatus;
    }

    /**
     * @param datePartStatus
     * @return void
     */
    public void setDateActivityStatus(String datePartStatus) {
        this.datePartStatus = datePartStatus;
    }


    @Override
    public void displayActivity() {
        // TODO implement here
    }

}
