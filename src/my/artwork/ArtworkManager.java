package my.artwork;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by artmaster on 20.04.2017.
 */
public class ArtworkManager {

    private Map<String, ArtworkSender> artworkSenderMap = new HashMap<>();

    public ArtworkManager(List<ArtworkSender> artworkSenders)
    {
        artworkSenderMap = artworkSenders.stream().collect(Collectors.toMap(ArtworkSender::getShortName, Function.identity()));
    }

    public void put(ArtworkSender artworkSender)
    {
        artworkSenderMap.put(artworkSender.getShortName(), artworkSender);
    }

    public ArtworkSender get(ArtworkSender artworkSender)
    {
        return artworkSenderMap.get(artworkSender.getShortName());
    }

    public ArtworkSender get(String name)
    {
        return artworkSenderMap.get(name);
    }

}
