package com.example.registrationapi.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registrations")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Registration extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date expiryDate;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="book_id")
    private Integer bookId;

}
