package br.com.supercloud.surfer.boards;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "length_in_inches")
    private Float lengthInInches;
    @Column(name = "core_material")
    private CoreMaterial coreMaterial; // PU(Poly) / EPS(Epoxy)
    @Column(name = "year_released")
    private LocalDate yearReleased;
    @Column(name = "acquired_date")
    private LocalDate acquiredDate;

}
