package fr.ippon.mill.shippingplan.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

/**
 * CreateShippingPlanRequest
 */
public class CreateShippingPlanRequest {
  @NotNull
  @NotBlank
  @Email
  @JsonProperty("email")
  private String email;

  @NotNull
  @JsonProperty("cereal")
  private Cereal cereal;

  @NotNull
  @JsonProperty("shippingDate")
  private OffsetDateTime shippingDate;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Cereal getCereal() {
    return cereal;
  }

  public void setCereal(Cereal cereal) {
    this.cereal = cereal;
  }

  public OffsetDateTime getShippingDate() {
    return shippingDate;
  }

  public void setShippingDate(OffsetDateTime shippingDate) {
    this.shippingDate = shippingDate;
  }
}
