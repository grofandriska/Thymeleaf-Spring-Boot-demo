package com.example.practise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DirectMessage {

    @Id
    private Long id;
    private String message;
    private Long sender_id;
    private Long receiver_id;

}
