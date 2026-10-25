package fr.ippon.mill.shippingplan.domain;

import java.time.OffsetDateTime;

public class ShippingPlanAlreadyExistsException extends Exception {

    public ShippingPlanAlreadyExistsException(String farmerEmail, DomainCereal cereal, OffsetDateTime shippingDate) {
        super(String.format("Shipping plan for farmer \"%s\", cereal %s on %s already exists", farmerEmail, cereal, shippingDate));
    }

}
