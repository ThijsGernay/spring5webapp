package guru.springframework.spring5webapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zip;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    @ToString.Exclude
    private Set<Book> books = new HashSet<>();

    public Publisher(String name, String addressLine1, String city, String state, String zip) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
