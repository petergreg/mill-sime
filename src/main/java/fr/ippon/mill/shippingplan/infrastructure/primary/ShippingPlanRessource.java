package fr.ippon.mill.shippingplan.infrastructure.primary;

import fr.ippon.mill.shippingplan.domain.DomainCereal;
import fr.ippon.mill.shippingplan.domain.ShippingPlan;
import fr.ippon.mill.shippingplan.domain.ShippingPlanAlreadyExistsException;
import fr.ippon.mill.shippingplan.domain.ShippingPlanService;
import fr.ippon.mill.shippingplan.domain.UnknownFarmerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(ShippingPlanRessource.SHIPPING_PLAN_API_URI)
@Validated
public class ShippingPlanRessource {

    public static final String SHIPPING_PLAN_API_URI = "/api/shipping";

    private final ShippingPlanService shippingPlanService;

    public ShippingPlanRessource(ShippingPlanService shippingPlanService) {
        this.shippingPlanService = shippingPlanService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateShippingPlanRequest newShippingPlan) {
        ShippingPlan shippingPlan = ShippingPlan.create(newShippingPlan.getEmail(), DomainCereal.valueOf(newShippingPlan.getCereal().name()), newShippingPlan.getShippingDate());
        try {
            String reference = shippingPlanService.register(shippingPlan);
            String locationUri = String.format("%s/%s", SHIPPING_PLAN_API_URI, reference);
            return ResponseEntity.created(URI.create(locationUri)).build();
        } catch (UnknownFarmerException unknownFarmerException) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (ShippingPlanAlreadyExistsException shippingPlanAlreadyExistsException) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
