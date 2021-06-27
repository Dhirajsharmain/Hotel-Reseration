package bridgelabz.model;

public class Hotel {
    private String hotelName;
    private String wDayRegularRate;
    private String wDayRewardRate;
    private String wEndRegularRate;
    private String wEndRewardRate;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {

        this.hotelName = hotelName;
    }

    public String getwDayRegularRate() {
        return wDayRegularRate;
    }

    public void setwDayRegularRate(String wDayRegularRate) {
        this.wDayRegularRate = wDayRegularRate;
    }

    public String getwDayRewardRate() {
        return wDayRewardRate;
    }

    public void setwDayRewardRate(String wDayRewardRate) {
        this.wDayRewardRate = wDayRewardRate;
    }

    public String getwEndRegularRate() {
        return wEndRegularRate;
    }

    public void setwEndRegularRate(String wEndRegularRate) {
        this.wEndRegularRate = wEndRegularRate;
    }

    public String getwEndRewardRate() {
        return wEndRewardRate;
    }

    public void setwEndRewardRate(String wEndRewardRate) {
        this.wEndRewardRate = wEndRewardRate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", wDayRegularRate='" + wDayRegularRate + '\'' +
                ", wDayRewardRate='" + wDayRewardRate + '\'' +
                ", wEndRegularRate='" + wEndRegularRate + '\'' +
                ", wEndRewardRate='" + wEndRewardRate + '\'' +
                '}';
    }
}
