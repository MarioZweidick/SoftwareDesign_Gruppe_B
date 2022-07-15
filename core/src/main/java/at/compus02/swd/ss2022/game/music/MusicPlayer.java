package at.compus02.swd.ss2022.game.music;
import at.compus02.swd.ss2022.game.bl.interfaces.Disposable;
import at.compus02.swd.ss2022.game.repository.MusicRepository;
import com.badlogic.gdx.audio.Music;

public class MusicPlayer implements Disposable {
    private Music music;
    public MusicPlayer() {
    }

    public void playMusic(Sounds sound, boolean loop){
        music = MusicRepository.getInstance().getMusic(sound);
        music.setLooping(loop);
        music.setVolume(0.1f);
        music.play();
    }

    public void setquiet(){
        music.setVolume(0.05f);
    }
    public void setloud(){
        music.setVolume(0.1f);
    }

    @Override
    public void dispose() {
        music.dispose();
    }
}
