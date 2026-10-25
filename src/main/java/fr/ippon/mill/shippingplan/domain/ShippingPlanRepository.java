package fr.ippon.mill.shippingplan.domain;

import java.time.OffsetDateTime;

public interface ShippingPlanRepository {
    void save(ShippingPlan shippingPlan);
    boolean exists(String farmerEmail, DomainCereal cereal, OffsetDateTime shippingDate);
}
