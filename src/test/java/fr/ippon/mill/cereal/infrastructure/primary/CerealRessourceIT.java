package fr.ippon.mill.cereal.infrastructure.primary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class CerealRessourceIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_create_new_cereal_transaction() throws Exception {
        // Given
        mockMvc.perform(post("/api/farmers")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8)
                .content("""
                {
                "email": "jean.dupont@fermier.fr",
                "firstName": "Jean",
                "lastName": "Dupont",
                "phoneNumber": "+33 123456789"
                }
                """));

        // When
        mockMvc.perform(post("/api/shipping")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content("""
                                {
                                  "email": "jean.dupont@fermier.fr",
                                  "cereal": "BLE",
                                  "shippingDate": "2026-12-01T10:00:00Z"
                                }
                                """))
                // Then
                .andExpect(status().isCreated());

    }



    @Test
    void should_not_create_new_cereal_transaction_when_farmer_does_not_exist() throws Exception {


        // When
        mockMvc.perform(post("/api/shipping")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content("""
                                {
                                  "email": "jean.dupont3@fermier.fr",
                                  "cereal": "BLE",
                                  "shippingDate": "2026-12-01T10:00:00Z"
                                }
                                """))
                // Then
                .andExpect(status().is(403));

    }
}