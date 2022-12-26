package com.falconow.maphome.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Generated;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "street_name")
    public String street;

    @Column(name = "number_home")
    public String home;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
            @JoinColumn(name = "home_id")
            @Fetch(FetchMode.SUBSELECT)
    List<Entrance> entrancesList;
}
