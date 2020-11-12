package ghasemia.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import prog24178.assigns.models.Events;

public class Registration implements Comparable<Registration> {

    public Events event = Events.HALF;  // the event this registration is for

    // TODO: all data members must be properties
    private IntegerProperty regId = new SimpleIntegerProperty(this, "regId", 0);
    private StringProperty name = new SimpleStringProperty(this, "name");
    private BooleanProperty paid = new SimpleBooleanProperty(this, "paid", false);
    private IntegerProperty hours = new SimpleIntegerProperty(this, "hours", 0);
    private IntegerProperty minutes = new SimpleIntegerProperty(this, "minutes", 0);
    private IntegerProperty seconds = new SimpleIntegerProperty(this, "seconds", 0);
    //private int regId = 0;
    //private String name = "";
    //private boolean paid = false;
    //private int hours = 0;
    //private int minutes = 0;
    //private int seconds = 0;

    /**
     * Constructs a default registration object.
     */
    public Registration() {

    }

    /**
     * Places a valid value into the regId member.
     *
     * @param id the programmer-specified id
     */
    public void setRegId(int id) {

        // make sure ID is valid
        if (id > 0) {
            this.regId.set(id);

        } else {
            throw new IllegalArgumentException("Error: Registration ID must "
                    + "be greater than 0.");
        }
    }

    /**
     * Retrive the ID for this registration.
     *
     * @return this registration's ID
     */
    public int getRegId() {
        return regId.get();
    }

    /**
     * regIdProperty that will return the IntegerProperty, and it's value is 0
     * by default
     *
     * @return regId
     */
    public IntegerProperty regIdProperty() {
        return regId;
    }

    /**
     * Places a participant name into the name member.
     *
     * @param name the programmer-specified participant name
     */
    public void setName(String name) {

        // validation not required
        this.name.set(name);
    }

    /**
     * Retrieves the participant name for this registration.
     *
     * @return the participant name
     */
    public String getName() {
        return name.get();
    }

    /**
     * nameProperty that will return the StringProperty, and it doesn't have any
     * value by default
     *
     * @return name
     */
    public StringProperty nameProperty() {
        return name;
    }

    /**
     * Places a boolean value into the paid member.
     *
     * @param paid the programmer specified value for paid
     */
    public void setPaid(boolean paid) {

        // validation not required
        this.paid.set(paid);
    }

    /**
     * Retrieves whether or not the participant paid the fee when they
     * registered for the event.
     *
     * @return true if the participant paid, false otherwise
     */
    public boolean isPaid() {
        return paid.get();
    }

    /**
     * paidProperty that will return the BooleanProperty, and its value is false
     * by default
     *
     * @return paid
     */
    public BooleanProperty paidProperty() {
        return paid;
    }

    /**
     * Places a valid value into the hours member.
     *
     * @param hrs the programmer-specified hours
     */
    public void setHours(int hrs) {

        // make sure hours is valid
        if (hrs >= 0) {
            this.hours.set(hrs);
        } else {
            throw new IllegalArgumentException("Error: Hours must be greater"
                    + " than 0.");
        }
    }

    /**
     * Retrieves the number of hours in the participant's finish time.
     *
     * @return the number of hours in the finish time
     */
    public int getHours() {
        return hours.get();
    }

    /**
     * hoursProperty that will return the IntegerProperty, and its value is zero
     * by default
     *
     * @return hours
     */
    public IntegerProperty hoursProperty() {
        return hours;
    }

    /**
     * Places a valid value into the minutes member.
     *
     * @param mins the programmer-specified minutes
     */
    public void setMinutes(int mins) {

        // make sure minutes is valid
        if (mins >= 0) {
            this.minutes.set(mins);
        } else {
            throw new IllegalArgumentException("Error: Minutes must be "
                    + "greater than 0.");
        }
    }

    /**
     * Retrieves the number of minutes in the participant's finish time.
     *
     * @return the number of minutes in the finish time
     */
    public int getMinutes() {
        return minutes.get();
    }

    /**
     * minutesProperty that will return the IntegerProperty, and its value is
     * zero by default
     *
     * @return minutes
     */
    public IntegerProperty minutesProperty() {
        return minutes;
    }

    /**
     * Places a valid value into the seconds member.
     *
     * @param seconds the programmer-specified seconds
     */
    public void setSeconds(int seconds) {

        // make sure seconds is valid
        if (seconds >= 0) {
            this.seconds.set(seconds);
        } else {
            throw new IllegalArgumentException("Error: Seconds must be "
                    + "greater than 0.");
        }
    }

    /**
     * Retrieves the number of seconds in the participant's finish time.
     *
     * @return the number of seconds in the finish time
     */
    public int getSeconds() {
        return seconds.get();
    }

    /**
     * secondsProperty that will return the IntegerProperty, and its value is
     * zero by default
     *
     * @return seconds
     */
    public IntegerProperty secondsProperty() {
        return seconds;
    }

    /**
     * Returns a string representation of this registration, which only includes
     * the participant name.
     *
     * @return this Registration as a String
     */
    @Override
    public String toString() {
        return String.format("Date/Time: %s\nFee: $%.2f Distance: %.2f",
                this.event.getEventDateTimeString(),
                this.event.getFee(), this.event.getDistance());
    }

    /**
     * The method is comparing the id, and it returns an int
     *
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Registration o) {
        if (this.regId.get() == o.regId.get()) {
            return 0;
        } else if (this.regId.get() > o.regId.get()) {
            return 1;
        } else {
            return -1;
        }

    }

    /**
     * Returns a String that can be used to save this Registration as a record
     * in a sequential file.
     *
     * @return a delimited string containing Registration state
     */
    public String toSequentialFile() {
        // TODO: return a delimited string that can be saved to a data file
        return String.format("%d|%s|%s|%b|%d|%d|%d%n",
                regId.get(), event, name.get(),
                paid.get(), hours.get(), minutes.get(), seconds.get());
    }
}
