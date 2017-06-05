package my.artwork;

import org.springframework.stereotype.Service;

/**
 * Created by artmaster on 20.04.2017.
 */
@Service("ftpartworksender")
public class FtpArtworkSender implements ArtworkSender {

    @Override
    public void sendArtwork(String artworkPath, Recipient recipient) {
        // work with ftp
    }

    @Override
    public String getFriendlyName() {
        return "FTP transfer protocol";
    }

    @Override
    public String getShortName() {
        return "ftp";
    }
}
