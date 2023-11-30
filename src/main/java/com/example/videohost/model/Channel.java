package com.example.videohost.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "channels")
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, exclude = "subscribers")
public class Channel extends AbstractEntity {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create")
    private LocalDateTime dateCreate;

    @Column(name = "language")
    private String language;

    @Column(name = "avatar")
    private String avatar;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @JsonBackReference
    @ManyToMany(mappedBy = "channels", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> subscribers;
}
