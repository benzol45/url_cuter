package com.example.urlcuter.Repository;

import java.util.Optional;

public interface UrlRepository {
    Optional<String> getFullUrlByCutUrl(String cutUrl);
    boolean existCutUrl(String cutUrl);
    void addNewUrlPair(String fullUrl, String cutUrl);

}
