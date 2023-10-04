package fr.ippon.mill.farmer.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface FarmerEntityRepository  extends JpaRepository<FarmerEntity, Long> {

    @Transactional(readOnly = true)
    boolean existsByEmail(String email);

    Optional<FarmerEntity> findByReference(String reference);
}
