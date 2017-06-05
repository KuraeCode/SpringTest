package my.artwork;



/**
 * Created by artmaster on 20.04.2017.
 */
public interface ArtworkSender {

    void sendArtwork(String artworkPath, Recipient recipient);

    String getFriendlyName();

    String getShortName();

}
