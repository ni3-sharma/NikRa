package Helper;

public class LinksPojo {
    String url;
    String account;
    String domain;
    String alias;
    String author;
    String longUrl;
    boolean isIntranet;
    int totalClicks;
    String created;
    String modified;
    int ttl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
