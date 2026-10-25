package fr.ippon.mill.shippingplan.domain;

import fr.ippon.mill.error.domain.Assert;

import java.time.OffsetDateTime;
import java.util.UUID;

public class ShippingPlan {

    private final UUID reference;
    private final String farmerEmail;
    private final DomainCereal cereal;
    private final OffsetDateTime shippingDate;

    public static ShippingPlan create(String farmerEmail, DomainCereal cereal, OffsetDateTime shippingDate) {
        return new ShippingPlan(UUID.randomUUID(), farmerEmail, cereal, shippingDate);
    }

    public ShippingPlan(UUID reference, String farmerEmail, DomainCereal cereal, OffsetDateTime shippingDate) {
        Assert.assertNotNull("reference", reference);
        Assert.assertNotBlank("farmerEmail", farmerEmail);
        Assert.assertNotNull("cereal", cereal);
        Assert.assertNotNull("shippingDate", shippingDate);
        this.reference = reference;
        this.farmerEmail = farmerEmail;
        this.cereal = cereal;
        this.shippingDate = shippingDate;
    }

    public UUID getReference() {
        return reference;
    }

    public String getFarmerEmail() {
        return farmerEmail;
    }

    public DomainCereal getCereal() {
        return cereal;
    }

    public OffsetDateTime getShippingDate() {
        return shippingDate;
    }
}
