package DaliborJankovic.StudentskiServis.entity.users.details;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @Column(name = "post_code")
    @Min(value = 1000)
    @Max(value = 99999)
    private int postCode;

    @Column(length = 200, name = "city_name")
    @NotEmpty
    private String cityName;

    @Override
    public String toString() {
        return postCode + "";
    }
}
