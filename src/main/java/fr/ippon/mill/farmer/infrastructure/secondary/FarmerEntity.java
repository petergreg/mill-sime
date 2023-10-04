package fr.ippon.mill.farmer.infrastructure.secondary;

import fr.ippon.mill.farmer.domain.Farmer;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "farmer")
@SequenceGenerator(name = "seq_farmer", allocationSize = 1)
public class FarmerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_farmer")
    private Long id;
    @Column(unique = true, nullable = false)
    private String reference;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FarmerEntity that = (FarmerEntity) o;
        return reference.equals(that.reference) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, email);
    }

    public Farmer toDomain() {
        return new Farmer(
                UUID.fromString(this.reference),
                this.firstName,
                this.lastName,
                this.email,
                this.phoneNumber
        );
    }
}
