package lld.carrental.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    String userId;
    String name;
    String driverLicense;
}
