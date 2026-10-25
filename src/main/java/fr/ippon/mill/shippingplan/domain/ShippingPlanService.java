package fr.ippon.mill.shippingplan.domain;

import fr.ippon.mill.farmer.domain.FarmerRepository;

public abstract class ShippingPlanService {

    private final FarmerRepository farmerRepository;
    private final ShippingPlanRepository shippingPlanRepository;

    protected ShippingPlanService(FarmerRepository farmerRepository, ShippingPlanRepository shippingPlanRepository) {
        this.farmerRepository = farmerRepository;
        this.shippingPlanRepository = shippingPlanRepository;
    }

    public String register(ShippingPlan shippingPlan) throws UnknownFarmerException, ShippingPlanAlreadyExistsException {

        boolean farmerExists = farmerRepository.exists(shippingPlan.getFarmerEmail());
        if (!farmerExists) {
            throw new UnknownFarmerException(shippingPlan.getFarmerEmail());
        }
        this.shippingPlanRepository.save(shippingPlan);
        return shippingPlan.getReference().toString();
    }
}
