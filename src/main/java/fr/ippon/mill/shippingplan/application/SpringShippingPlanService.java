package fr.ippon.mill.shippingplan.application;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.ippon.mill.shippingplan.domain.ShippingPlan;
import fr.ippon.mill.shippingplan.domain.ShippingPlanAlreadyExistsException;
import fr.ippon.mill.shippingplan.domain.ShippingPlanService;
import fr.ippon.mill.shippingplan.domain.UnknownFarmerException;

@Service
public class SpringShippingPlanService extends ShippingPlanService {

    public SpringShippingPlanService() {
    }

    @Override 
    @Transactional 
    public String register(ShippingPlan shippingPlan) throws UnknownFarmerException, ShippingPlanAlreadyExistsException{
        return super.register(shippingPlan);
    }

}
