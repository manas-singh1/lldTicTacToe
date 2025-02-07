public class Player {
    private String name;
    private PlayingPiece playingpiece;
    public Player(String name, PlayingPiece playingPiece){
        this .name=name;
        this.playingpiece=playingPiece;
    }
    public String getName(){
        return name;
    }
    public PlayingPiece getPlayingPiece(){
        return playingpiece;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayingPiece(PlayingPiece playingpiece) {
        this.playingpiece = playingpiece;
    }
}
