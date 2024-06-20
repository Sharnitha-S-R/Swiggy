package com.swiggy.swiggy.Entity;
import com.swiggy.swiggy.Enum.Role;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private int id;

        @Column(name="USER_NAME")
        private String username;

        @Column(name="EMAIL")
        private String email;

        @Column(name="PASSWORD")
        private String password;

        @Enumerated(EnumType.STRING)
        @Column(name="ROLE")
        private Role role;

//        @Column(name="last_logout")
//        private LocalDateTime lastLogout;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Restaurant> restaurants;




}


