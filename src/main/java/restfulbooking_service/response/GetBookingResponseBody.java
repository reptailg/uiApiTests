package restfulbooking_service.response;

import lombok.*;
import restfulbooking_service.model.Bookingdates;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetBookingResponseBody {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;
}
