package WorkingWithAbstractionLab.hotelReservation;
enum season {
    Autumn,
    Spring,
    Winter,
    Summer
}

enum discount {
    VIP,
    SecondVisit,
    None
}
public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private discount discount;
    private season season;

    public PriceCalculator(double pricePerDay, int days,
                           WorkingWithAbstractionLab.hotelReservation.discount discount,
                           WorkingWithAbstractionLab.hotelReservation.season season) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.discount = discount;
        this.season = season;
    }

    public void calculate() {
        double price = this.pricePerDay*this.days;

        switch (season) {
            case Spring -> price *= 2;
            case Winter -> price *= 3;
            case Summer -> price *= 4;
        }

        switch (discount) {
            case VIP -> price *= 0.8;
            case SecondVisit -> price *= 0.9;
        }

        System.out.println(String.format("%.2f", price));
    }
}
