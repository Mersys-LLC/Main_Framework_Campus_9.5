package _04_API_POJO.Model;

public class Translate {

  private String lang;
  private String data;

  public Translate(String lang, String data) {
  setLang(lang);
  setData(data);
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
