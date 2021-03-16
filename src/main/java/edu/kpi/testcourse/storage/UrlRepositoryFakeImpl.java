package edu.kpi.testcourse.storage;

import edu.kpi.testcourse.entities.UrlAlias;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * An in-memory fake implementation of {@link UrlRepository}.
 */
public class UrlRepositoryFakeImpl implements UrlRepository {
  private final HashMap<String, UrlAlias> aliases = new HashMap<>();

  @Override
  public void createUrlAlias(UrlAlias urlAlias) {
    if (aliases.containsKey(urlAlias.alias())) {
      throw new UrlRepository.AliasAlreadyExist();
    }

    aliases.put(urlAlias.alias(), urlAlias);
  }

  @Override
  public @Nullable UrlAlias findUrlAlias(String alias) {
    return aliases.get(alias);
  }

  @Override
  public void deleteUrlAlias(String alias, String email) {
    aliases.remove(alias);
  }

  @Override
  public List<UrlAlias> getAllAliasesForUser(String userEmail) {
    List returnList = new ArrayList();
    for(Map.Entry<String, UrlAlias> entry : aliases.entrySet()) {
      String key = entry.getKey();
      UrlAlias value = entry.getValue();
      System.out.println(value);
      System.out.println(key);
      if (value.email().equals(userEmail)){
        returnList.add(key);
      }
    }
    return returnList;
  }
}
