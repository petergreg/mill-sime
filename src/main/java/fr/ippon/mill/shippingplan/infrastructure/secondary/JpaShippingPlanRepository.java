package fr.ippon.mill.shippingplan.infrastructure.secondary;

import fr.ippon.mill.farmer.infrastructure.secondary.FarmerEntity;
import fr.ippon.mill.farmer.infrastructure.secondary.FarmerEntityRepository;
import fr.ippon.mill.shippingplan.domain.DomainCereal;
import fr.ippon.mill.shippingplan.domain.ShippingPlan;
import fr.ippon.mill.shippingplan.domain.ShippingPlanRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Component
public class JpaShippingPlanRepository implements ShippingPlanRepository {

    private final ShippingPlanEntityRepository shippingPlanEntityRepository;
    private final FarmerEntityRepository farmerEntityRepository;

    public JpaShippingPlanRepository(ShippingPlanEntityRepository shippingPlanEntityRepository, FarmerEntityRepository farmerEntityRepository) {
        this.shippingPlanEntityRepository = shippingPlanEntityRepository;
        this.farmerEntityRepository = farmerEntityRepository;
    }

    @Override
    @Transactional
    public void save(ShippingPlan shippingPlan) {
        FarmerEntity farmerEntity = farmerEntityRepository.findByEmail(shippingPlan.getFarmerEmail())
                .orElseThrow(() -> new IllegalStateException(String.format("Farmer with email \"%s\" not found", shippingPlan.getFarmerEmail())));

        ShippingPlanEntity shippingPlanEntity = new ShippingPlanEntity();
        shippingPlanEntity.setReference(shippingPlan.getReference().toString());
        shippingPlanEntity.setFarmer(farmerEntity);
        shippingPlanEntity.setCereal(shippingPlan.getCereal());
        shippingPlanEntity.setShippingDate(shippingPlan.getShippingDate());

        shippingPlanEntityRepository.save(shippingPlanEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(String farmerEmail, DomainCereal cereal, OffsetDateTime shippingDate) {
        return shippingPlanEntityRepository.existsByFarmerEmailAndCerealAndShippingDate(farmerEmail, cereal, shippingDate);
    }
}
