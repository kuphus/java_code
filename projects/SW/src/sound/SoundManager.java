package sound;

/*     mediaplayer code
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
*/
import javafx.scene.SubScene;

//import javafx.scene.Subscene;

//     audioclip code
import javafx.scene.media.AudioClip;
//

import java.io.File;
//import java.net.URI;

//import model.PLANE;

public class SoundManager{

  /*     mediaplayer code
  private MediaPlayer enginePlayer;
  private MediaPlayer crashPlayer;
  */
  
  //     audioclip code
  private AudioClip enginePlayer;
  private AudioClip crashPlayer;
 //private AudioClip fallingPlayer;
  //


  public SoundManager(){
    try{
      /*     mediaplayer code
      File engineFile = new File("sound/resources/engineSound.mp3");
      Media engine = new Media(engineFile.toURI().toString());
      enginePlayer = new MediaPlayer(engine);
      File crashFile = new File("sound/resources/crash.mp3");
      Media crash = new Media(crashFile.toURI().toString());
      crashPlayer = new MediaPlayer(crash);
      */

      /*     audioclip code
      *      Important!!! Mp3 files only seem to work when ID-tags are removed!
      */
      File engineFile = new File("src/sound/resources/engineSound.mp3");
      enginePlayer = new AudioClip(engineFile.toURI().toString());
      enginePlayer.setCycleCount(AudioClip.INDEFINITE);
      File crashFile = new File("src/sound/resources/crash.mp3");
      crashPlayer = new AudioClip(crashFile.toURI().toString());
      /*
      File fallingFile = new File("sound/resources/Falling_effect.mp3");
      fallingPlayer = new AudioClip(fallingFile.toURI().toString());
      */
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }


  public void playEngine(){
    enginePlayer.play();
  }

  public void stopEngine(){
    enginePlayer.stop();
  }


  public void playCrash(){
    crashPlayer.play();
  }
  
  /*
  public void playFalling(){
    fallingPlayer.play();
  }
  
  public void stopFalling(){
    fallingPlayer.stop();
  }
  */
}







/*
public void playSound(final String id) {
        Runnable soundPlay = new Runnable() {
            @Override
            public void run() {
                soundEffectsMap.get(id).play();
            }
        };
        soundPool.execute(soundPlay);
    }


*/

 /*
 a.setOnEndOfMedia(new Runnable() {
       public void run() {
         a.seek(Duration.ZERO);
       }
   });
  a.play();
  
  */