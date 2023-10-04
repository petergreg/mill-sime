package fr.ippon.mill.farmer.domain;

import java.util.Optional;
import java.util.UUID;

public interface FarmerRepository {
    Optional<Farmer> findByReference(UUID reference);
    void save(Farmer farmer);
    boolean exists(String email);
}
