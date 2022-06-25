package at.compus02.swd.ss2022.game.repository;

public class Pair<F,S> {
    private F first;
    private S second;
    public Pair(F first, S second){
        this.first = first;
        this.second = second;
    }
    public F getFirst(){return first;};
    public S getSecond(){return second;};
    public void dispose(){
        first = null;
        second = null;
    }
}
