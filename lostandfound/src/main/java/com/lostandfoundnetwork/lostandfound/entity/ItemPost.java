package com.lostandfoundnetwork.lostandfound.entity;

/*
 --> THIS CLASS REPRESENTS ITEM POST IN THE LOST AND FOUND SYSTEM.
 --> This class is mapped to the "item_posts" table in the database.
 */

import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity // specifies that this class is an entity and is mapped to a database table
@Table(name="item_posts") // Defines the name of the database table to be used for this entity
@Data // lombok annotation to automatically generate getters, setters, toString(), etc
public class ItemPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Defines a column in the table. 'nullable = false' means it must have a value
    private String title;

    @Column(length = 1000) // you can specify column properties like length.
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // LIKE "NOT NULL" in MySQL.
    private PostStatus status;

    private String location; // simple for now, can be expanded to Location entity

    private String imageUrl; // URL to the uploaded image of the item

    @CreationTimestamp // Automatically sets the value to the current timestamp when the entity is first created.
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp // Automatically updates the value to the current timestamp whenever the entity is updated.
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    // Enum to define the status of the POST
    public enum PostStatus{
        LOST,
        FOUND
    }
}
