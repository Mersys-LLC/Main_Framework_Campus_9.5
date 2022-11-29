package _04_API_POJO.Model;

import java.util.ArrayList;
import java.util.List;

public class Fields {

    private String id;
    private String name = "JoField";
    private String code = "Jo1234";
    private String type = "STRING";
    private String schoolId = "6343bf893ed01f0dc03a509a";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public String getType() {
        return type;
    }
    public String getSchoolId() {
        return schoolId;
    }

    private List<Translate> translateName = new ArrayList<>();

    public List<Translate> getTranslateName() {
        return translateName;
    }
    public void setTranslateName(String lang,String data) {
        translateName.add(new Translate(lang,data));
    }


}
