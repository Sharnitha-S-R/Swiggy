package com.swiggy.swiggy.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
    public class User {
        @Id
        @Column(name="ID")
        @GeneratedValue
        private int id;

        @Column(name="USER_NAME")
        private String username;
        @Column(name="EMAIL")
        private String email;
        @Column(name="PASSWORD")
        private String password;
        @Column(name="last_logout")
        private LocalDateTime lastLogout;
        public void setLastLogout(LocalDateTime lastLogout) {
            this.lastLogout = lastLogout;
        }

    }


