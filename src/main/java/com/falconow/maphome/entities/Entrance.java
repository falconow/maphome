package com.falconow.maphome.entities;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "entrance")
public class Entrance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entrance_number")
    private Integer entrance_number;

    @Column(name = "floor")
    private Integer floor;

    @ElementCollection
    @CollectionTable(name = "entrance_flats", joinColumns = @JoinColumn(name = "entrance_id"))
    @OrderColumn(name = "order_id")
    @Column(name = "flats")
    @Fetch(FetchMode.SUBSELECT)
    private List<String> flatList;
}
