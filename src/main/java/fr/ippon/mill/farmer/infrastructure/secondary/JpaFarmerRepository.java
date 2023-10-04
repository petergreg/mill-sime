package fr.ippon.mill.farmer.infrastructure.secondary;

import fr.ippon.mill.farmer.domain.Farmer;
import fr.ippon.mill.farmer.domain.FarmerRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
public class JpaFarmerRepository implements FarmerRepository {

    private final FarmerEntityRepository farmerEntityRepository;

    public JpaFarmerRepository(FarmerEntityRepository farmerEntityRepository) {
        this.farmerEntityRepository = farmerEntityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Farmer> findByReference(UUID reference) {
        return farmerEntityRepository.findByReference(reference.toString()).map(FarmerEntity::toDomain);
    }

    @Override
    @Transactional
    public void save(Farmer farmer) {
        FarmerEntity farmerEntity = new FarmerEntity();
        farmerEntity.setReference(farmer.getReference().toString());
        farmerEntity.setFirstName(farmer.getFirstName());
        farmerEntity.setLastName(farmer.getLastName());
        farmerEntity.setEmail(farmer.getEmail());
        farmerEntity.setPhoneNumber(farmer.getPhoneNumber());


        farmerEntityRepository.save(farmerEntity);
    }

    @Override
    public boolean exists(String email) {
        return farmerEntityRepository.existsByEmail(email);
    }
}
