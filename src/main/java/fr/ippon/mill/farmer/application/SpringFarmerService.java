package fr.ippon.mill.farmer.application;

import fr.ippon.mill.farmer.domain.Farmer;
import fr.ippon.mill.farmer.domain.FarmerAlreadyExistsException;
import fr.ippon.mill.farmer.domain.FarmerRepository;
import fr.ippon.mill.farmer.domain.FarmerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpringFarmerService extends FarmerService {

    public SpringFarmerService(FarmerRepository farmerRepository) {
        super(farmerRepository);
    }

    @Transactional
    @Override
    public String register(Farmer farmer) throws FarmerAlreadyExistsException {
        return super.register(farmer);
    }
}
