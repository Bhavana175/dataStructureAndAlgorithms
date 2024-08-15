package mylearning.com.immutable;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public final class Sneh {

   private final int id;
   private final String quality;

    private final List<Address> addresses;

    public Sneh(int id, String quality, List<Address> addresses) {
        this.id = id;
        this.quality = quality;
        this.addresses =  getAddressListDeep(addresses);;
    }

    private List<Address> getAddressListDeep(List<Address> addresses) {
        List<Address> temp = new ArrayList<>();

        for(int i = 0; i< addresses.size(); i++){
            Address deepAddCopy = deepCopy(addresses.get(i));
            temp.add(deepAddCopy);
        }
        return temp;
    }

    private Address deepCopy(Address address) {
        Address add = new Address();
        add.setCity(address.getCity());
        add.setPincode(address.getPincode());
        add.setStreet(address.getStreet());

        return add;
    }

    public int getId() {
        return id;
    }

    public String getQuality() {
        return quality;
    }

    public List<Address> getAddresses() {
        return getAddressListDeep(addresses);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Address{

    int flatN;
    String street;

    int pincode;
    String city;


}
