package fr.ippon.mill.shippingplan.domain;

public class UnknownFarmerException extends Exception {

    public UnknownFarmerException(String email) {
        super(String.format("Farmer with email \"%s\" is unknown", email));
    }

}
