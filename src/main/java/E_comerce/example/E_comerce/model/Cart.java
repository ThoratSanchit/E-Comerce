package E_comerce.example.E_comerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cart")
public class Cart {

    @Id
    private String id;

    private String email; // Acts as a foreign key reference to User

    private List<Products> items;

    private double totalPrice;
}
