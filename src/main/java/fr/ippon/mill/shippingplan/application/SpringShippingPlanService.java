package fr.ippon.mill.shippingplan.application;

import fr.ippon.mill.farmer.domain.FarmerRepository;
import fr.ippon.mill.shippingplan.domain.ShippingPlan;
import fr.ippon.mill.shippingplan.domain.ShippingPlanAlreadyExistsException;
import fr.ippon.mill.shippingplan.domain.ShippingPlanRepository;
import fr.ippon.mill.shippingplan.domain.ShippingPlanService;
import fr.ippon.mill.shippingplan.domain.UnknownFarmerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpringShippingPlanService extends ShippingPlanService {

    public SpringShippingPlanService(FarmerRepository farmerRepository, ShippingPlanRepository shippingPlanRepository) {
        super(farmerRepository, shippingPlanRepository);
    }

    @Transactional
    @Override
    public String register(ShippingPlan shippingPlan) throws UnknownFarmerException, ShippingPlanAlreadyExistsException {
        return super.register(shippingPlan);
    }
}
