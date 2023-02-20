package pet_store_service.builder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pet_store_service.PetStore;
import pet_store_service.response.*;
import properties.BaseProperties;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class PetStoreBuilder {

    public PetStore service(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseProperties.getProperty("PETSTORE_URL"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(PetStore.class);
    }

    public void getPet(int id) throws IOException {
        Response<GetPetResponseBody> response = new PetStoreBuilder().service()
                .getPet(id).execute();
        if(!(response.isSuccessful())&& Objects.nonNull(response.body())){
            throw new IllegalStateException("No booking in service");
        }
    }
}
