package fr.ippon.mill.farmer.domain;

public abstract class FarmerService {

    private final FarmerRepository farmerRepository;

    protected FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public String register(Farmer farmer) throws FarmerAlreadyExistsException {

        boolean alreadyExists = farmerRepository.exists(farmer.getEmail());
        if (alreadyExists) {
            throw new FarmerAlreadyExistsException(farmer.getEmail());
        }
        this.farmerRepository.save(farmer);
        return farmer.getReference().toString();
    }
}
