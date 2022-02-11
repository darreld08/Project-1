package project1;

public class Timeslot implements Comparable<Timeslot> {
    private Date date;
    private Time time;

    public Timeslot(String date, String time) {
        this.date = new Date(date);
        this.time = new Time(time);
    }

    public Timeslot() {
        this.date = new Date();
        this.time = new Time();
    }
    
    public boolean equals(Timeslot slot) {
    	if(date == slot.date && time == slot.time) {
    		return true;
    	}
    	return false;
    }
    public Date getDate() {
    	return date;
    }
    
    public Time getTime() {
    	return time;
    }
    
    public boolean isValid() {
        return date.isValid() && time.isValid();
    }
    

    @Override
    public String toString() {
        return date.toString() + ", " + time.toString();
    }

    @Override
    public int compareTo(Timeslot slot) {
        if (this.date.compareTo(slot.date) == Constant.GREATER) return Constant.GREATER;
        else if (this.date.compareTo(slot.date) == Constant.LESS) return Constant.LESS;
        else {
            if (this.time.compareTo(slot.time) == Constant.GREATER) return Constant.GREATER;
            else if (this.time.compareTo(slot.time) == Constant.LESS) return Constant.LESS;
            else return Constant.EQUAL;
        }
    }

    public static void main(String[] args) {
        Timeslot timeslot1 = new Timeslot("1/25/2022", "14:30");
        Timeslot timeslot2 = new Timeslot("2/20/2022", "9:15");
        Timeslot timeslot3 = new Timeslot("1/25/2022", "14:30");
        Timeslot timeslot4 = new Timeslot("1/25/2022", "16:30");
        Timeslot timeslot5 = new Timeslot("1/25/2022", "6:00");
        Timeslot timeslot6 = new Timeslot("2/30/2022", "9:15");
        Timeslot timeslot7 = new Timeslot("2/20/2022", "26:15");
        Timeslot timeslot8 = new Timeslot();

        System.out.println(timeslot1.isValid()); //checks if a valid timeslot is valid
        System.out.println(timeslot6.isValid()); //checks if a timeslot with an invalid date is valid
        System.out.println(timeslot7.isValid()); //checks if a timeslot with an invalid time is valid

        System.out.println(timeslot2.toString());
        System.out.println(timeslot8.toString());

        System.out.println(timeslot1.compareTo(timeslot2)); //should be less
        System.out.println(timeslot1.compareTo(timeslot3)); //should be equal
        System.out.println(timeslot4.compareTo(timeslot1)); //should be greater
        System.out.println(timeslot1.compareTo(timeslot5)); //should be greater
    }
}
