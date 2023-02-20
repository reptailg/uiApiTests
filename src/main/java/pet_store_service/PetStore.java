package pet_store_service;

import pet_store_service.response.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PetStore {
    @GET("pet/{id}")
    Call<GetPetResponseBody> getPet(@Path("id")int id);

}
