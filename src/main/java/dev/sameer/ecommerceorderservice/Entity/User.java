package dev.sameer.ecommerceorderservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class User {
    @Id
    private UUID userId;
    private String userName;
    private String userEmail;
}
