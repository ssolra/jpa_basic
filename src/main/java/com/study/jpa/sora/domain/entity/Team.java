package com.study.jpa.sora.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name="TEAM")
public class Team extends Common {
    @Id
    @Column(name="TEAM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="TEAM_NAME")
    private String name;

    @Column(name="TEAM_SCORE")
    private Integer score;

    @OneToMany(mappedBy = "team")
    private List<User> users = new ArrayList<User>();
}
