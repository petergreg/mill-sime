package fr.ippon.mill.shippingplan.infrastructure.secondary;

import fr.ippon.mill.farmer.infrastructure.secondary.FarmerEntity;
import fr.ippon.mill.shippingplan.domain.DomainCereal;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "shipping_plan")
@SequenceGenerator(name = "seq_shipping_plan", allocationSize = 1)
public class ShippingPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_shipping_plan")
    private Long id;
    @Column(unique = true, nullable = false)
    private String reference;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerEntity farmer;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DomainCereal cereal;
    @Column(nullable = false)
    private OffsetDateTime shippingDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public FarmerEntity getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerEntity farmer) {
        this.farmer = farmer;
    }

    public DomainCereal getCereal() {
        return cereal;
    }

    public void setCereal(DomainCereal cereal) {
        this.cereal = cereal;
    }

    public OffsetDateTime getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(OffsetDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingPlanEntity that = (ShippingPlanEntity) o;
        return reference.equals(that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }
}
