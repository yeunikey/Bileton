package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

    ALL("All Genres"),
    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    FANTASY("Fantasy"),
    HORROR("Horror"),
    MYSTERY("Mystery"),
    ROMANCE("Romance"),
    SCI_FI("Science Fiction"),
    THRILLER("Thriller"),
    WESTERN("Western"),
    ANIMATION("Animation"),
    DOCUMENTARY("Documentary"),
    CRIME("Crime"),
    FAMILY("Family"),
    MUSIC("Music");

    private final String name;
}
