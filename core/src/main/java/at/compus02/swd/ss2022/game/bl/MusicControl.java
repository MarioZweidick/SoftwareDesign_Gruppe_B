package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.music.MusicPlayer;
import at.compus02.swd.ss2022.game.music.Sounds;

import java.util.ArrayList;

public class MusicControl {

    private final ArrayList<MusicPlayer> players;
    private static final MusicControl instance = new MusicControl();
    private MusicControl(){
        players = new ArrayList<>();
    }
    public static MusicControl getInstance(){return  instance;}

    public void startGame(){
        MusicPlayer player = new MusicPlayer();
        player.playMusic(Sounds.Backgroundmusic, true);
        players.add(player);
    }

    public void playSound(Sounds sound){
        MusicPlayer player = new MusicPlayer();
        players.forEach(MusicPlayer::setquiet);
        player.playMusic(sound,false);
        players.forEach(MusicPlayer::setloud);

    }
}
