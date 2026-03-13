package com.gokul.snippetmanager.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "snippets")
@Data
public class Snippet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String language;
    private String description;

    @Column(columnDefinition = "TEXT")
    private String code;

    @ElementCollection
    @CollectionTable(name = "snippet_tags", joinColumns = @JoinColumn(name = "snippet_id"))
    @Column(name = "tag")
    private List<String> tags;

    private boolean pinned = false;

    private LocalDateTime createdAt = LocalDateTime.now();
}
