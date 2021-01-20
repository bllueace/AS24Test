import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class AverageListingPrice{

    private int avrgPrivate = 0;
    private int avrgDealer = 0;
    private int avrgOther = 0;

    public void averageListingPrice(Collection<Listing> listingList){

        Collection<Integer> totalPrivate = new ArrayList<>();
        Collection<Integer> totalDealer = new ArrayList<>();
        Collection<Integer> totalOther = new ArrayList<>();



        for(Listing lst : listingList)
        {
            switch (lst.getSeller_type()){
                case "private":
                    totalPrivate.add(lst.getPrice());
                    break;
                case "dealer":
                    totalDealer.add(lst.getPrice());
                    break;
                case "other":
                    totalOther.add(lst.getPrice());
                    break;
                default:
                    break;
            }
        }

        this.avrgPrivate = getAverageSum(totalPrivate.stream().mapToInt(a->a).sum(), totalPrivate.size());
        this.avrgDealer  = getAverageSum(totalDealer.stream().mapToInt(a->a).sum(), totalDealer.size());
        this.avrgOther   = getAverageSum(totalOther.stream().mapToInt(a->a).sum(), totalOther.size());

        String leftAlignFormat = "| %-15s | %-13s |%n";

        System.out.format("+-------------+-------------------+%n");
        System.out.format("| Seller Type | Average in Euro   |%n");
        System.out.format("+-------------+-------------------+%n");

        System.out.format(leftAlignFormat, "Private", getCurrency(avrgPrivate));
        System.out.format(leftAlignFormat, "Dealer",getCurrency(avrgDealer));
        System.out.format(leftAlignFormat, "Other",getCurrency(avrgOther));

        System.out.format("+-------------+-------------------+%n");



    }

    private int getAverageSum(int total, int lstSize){
        return total / lstSize;
    }

    private String getCurrency(int cur){
        double price = cur;
        NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.GERMANY);
        String currency = formatter.format(price);

        return currency;
    }
}
