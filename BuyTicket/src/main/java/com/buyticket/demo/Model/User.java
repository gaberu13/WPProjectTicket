package com.buyticket.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message ="Username should not be empty")
    @Size(min = 4,max = 20,message = "Enter minimum 4 characters")
    @Column(unique = true)
    private String username;

    @Email(message = "Email should be valid")
    @NotEmpty(message ="Email should not be empty")
    @Column(unique = true)
    private String email;

    @NotEmpty(message ="Password should not be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    private String password;

    @NotEmpty(message = "Phone should not be empty")
    @Min(value = 8,message = "Phone should be atleast 8 numbers")
    @Column
    private String phone;

    @NotEmpty(message = "Address should not be empty")
    @Column
    private String address;

    @Enumerated
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
//    , cascade = CascadeType.PERSIST
    private List<Order> orders = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
