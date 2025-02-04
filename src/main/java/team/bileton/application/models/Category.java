package team.bileton.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {

    ALL("Все жанры"),
    ACTION("Экшн"),
    ADVENTURE("Приключения"),
    COMEDY("Комедия"),
    DRAMA("Драма"),
    FANTASY("Фэнтези"),
    HORROR("Ужасы"),
    MYSTERY("Детектив"),
    ROMANCE("Романтика"),
    SCI_FI("Научная фантастика"),
    THRILLER("Триллер"),
    WESTERN("Вестерн"),
    ANIMATION("Анимация"),
    DOCUMENTARY("Документальный"),
    CRIME("Криминал"),
    FAMILY("Семейный"),
    MUSIC("Музыка");

    private final String name;
}
