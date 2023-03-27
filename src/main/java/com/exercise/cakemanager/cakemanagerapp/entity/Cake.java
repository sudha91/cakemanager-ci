package com.exercise.cakemanager.cakemanagerapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "cake")
@AllArgsConstructor
@NoArgsConstructor
public class Cake
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique = true, nullable = false)
    @Setter
    private int ID;

    @Column(name="title", nullable = false, length = 300)
    private String title;
    @Column(name = "`desc`", nullable = false, length =300)
    private String desc;

    @Column(name = "image", nullable = false, length = 300)
    private String image;

}
