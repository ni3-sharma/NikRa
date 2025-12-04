package Helper;
import java.util.ArrayList;

public class ResponsePojo {

    // Initialize with default capacity to improve performance
    private ArrayList<LinksPojo> links = new ArrayList<>(10);
    
    public ArrayList<LinksPojo> getLinks() {
        return links;
    }
    
    public void setLinks(ArrayList<LinksPojo> links) {
        this.links = links;
    }
}
