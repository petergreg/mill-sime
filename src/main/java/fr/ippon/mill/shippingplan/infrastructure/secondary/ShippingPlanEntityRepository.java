package fr.ippon.mill.shippingplan.infrastructure.secondary;

import fr.ippon.mill.shippingplan.domain.DomainCereal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Repository
public interface ShippingPlanEntityRepository extends JpaRepository<ShippingPlanEntity, Long> {

    @Transactional(readOnly = true)
    boolean existsByFarmerEmailAndCerealAndShippingDate(String farmerEmail, DomainCereal cereal, OffsetDateTime shippingDate);
}
