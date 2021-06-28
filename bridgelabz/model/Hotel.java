package bridgelabz.model;

public class Hotel {
    private String hotelName;
    private Integer rating;
    private int wDayRegularRate;
    private int wDayRewardRate;
    private int wEndRegularRate;
    private int wEndRewardRate;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {

        this.hotelName = hotelName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public int getwDayRegularRate() {
        return wDayRegularRate;
    }

    public void setwDayRegularRate(int wDayRegularRate) {
        this.wDayRegularRate = wDayRegularRate;
    }

    public int getwDayRewardRate() {
        return wDayRewardRate;
    }

    public void setwDayRewardRate(int wDayRewardRate) {
        this.wDayRewardRate = wDayRewardRate;
    }

    public int getwEndRegularRate() {
        return wEndRegularRate;
    }

    public void setwEndRegularRate(int wEndRegularRate) {
        this.wEndRegularRate = wEndRegularRate;
    }

    public int getwEndRewardRate() {
        return wEndRewardRate;
    }

    public void setwEndRewardRate(int wEndRewardRate) {
        this.wEndRewardRate = wEndRewardRate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", rating=" + rating +
                ", wDayRegularRate=" + wDayRegularRate +
                ", wDayRewardRate=" + wDayRewardRate +
                ", wEndRegularRate=" + wEndRegularRate +
                ", wEndRewardRate=" + wEndRewardRate +
                '}';
    }
}
