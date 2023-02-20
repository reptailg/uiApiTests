package test.api;

import org.testng.annotations.Test;
import pet_store_service.builder.PetStoreBuilder;
import pet_store_service.response.GetPetResponseBody;

import java.io.IOException;

public class PetStoreTest {

    @Test
    public void getPetForId() throws IOException {
        GetPetResponseBody response = new PetStoreBuilder()
                .service()
                .getPet(10)
                .execute().body();
        assert response != null:"Response is NULL";
        System.out.println(response.toString());
    }

}
