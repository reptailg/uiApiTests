package pet_store_service.response;

import lombok.*;
import pet_store_service.model.Category;
import pet_store_service.model.Tag;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPetResponseBody {
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    @Override
    public String toString() {
        return "GetPetResponseBody{" +
                "id=" + id +
                ",\n category=" + category +
                ",\n name='" + name + '\'' +
                ",\n photoUrls=" + photoUrls +
                ",\n tags=" + tags +
                ",\n status='" + status + '\'' +
                '}';
    }
}
