package _04_API_POJO.Model;

import java.util.ArrayList;
import java.util.List;

public class Nationalities {

  private String id;
  private String name;

  private List<Translate> translateName = new ArrayList<>();

  public List<Translate> getTranslateName() {
    return translateName;
  }
  public void setTranslateName(String lang,String data) {
    translateName.add(new Translate(lang,data));
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
}
