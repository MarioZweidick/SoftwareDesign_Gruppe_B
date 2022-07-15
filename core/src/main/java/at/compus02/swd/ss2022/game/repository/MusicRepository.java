package at.compus02.swd.ss2022.game.repository;

import at.compus02.swd.ss2022.game.music.Sounds;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Array;

public class MusicRepository implements Repository {
    private static final MusicRepository repository = new MusicRepository();
    private Array<Pair<Sounds, Music>> sounds = new Array<>();
    private MusicRepository(){}

    public static MusicRepository getInstance() {return repository;}

    @Override
    public void preload() {
        sounds.add(new Pair<>(Sounds.Backgroundmusic, getMusic("backgroundmusic.mp3")));
        sounds.add(new Pair<>(Sounds.Enemydefeated, getMusic("enemydefeated.mp3")));
    }
    private Music getMusic(String name){
        return Gdx.audio.newMusic(Gdx.files.internal(name));
    }

    public Music getMusic(Sounds music){
        for (Pair<Sounds, Music> sound : sounds) {
            if(sound.getFirst() == music){
                return sound.getSecond();
            }
        }
        return null;
    }

    @Override
    public void dispose() {
        sounds.forEach(n ->
        {
            //texture dispose
            n.getSecond().dispose();
            n.dispose();
        });
        sounds = null;
    }
}
