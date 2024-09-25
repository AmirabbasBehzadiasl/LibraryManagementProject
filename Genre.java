public enum Genre {
    HORROR(1),
    FANTASY(2),
    SCIENCE(3),
    HISTORY(4),
    DRAMA(5),
    POETRY(6);
    public final int number;
    Genre(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    public static Genre getGenre(String genre){
        return Genre.valueOf(genre.toUpperCase());
    }
}
