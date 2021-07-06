import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class Vacancy {
    String Title;
    String Company;
    String Location;
    String Type;
    String Level;
    Integer ExperienceLowerBound;
    Integer ExperienceUpperBound;
    String Country;
    List<String> SkillsList;
    public Vacancy(String title, String company, String location,
                   String type, String level,Integer experienceLowerBound,
                   Integer experienceUpperBound
            ,String country, List<String> skillsList) {
        Title = title;
        Company = company;
        Location = location;
        Type = type;
        Level = level;
        ExperienceLowerBound=experienceLowerBound;
        ExperienceUpperBound=experienceUpperBound;
        Country = country;
        SkillsList = skillsList;
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public Integer getExperienceLowerBound() {
        return ExperienceLowerBound;
    }

    public void setExperienceLowerBound(Integer experienceLowerBound) {
        ExperienceLowerBound = experienceLowerBound;
    }

    public Integer getExperienceUpperBound() {
        return ExperienceUpperBound;
    }

    public void setExperienceUpperBound(Integer experienceUpperBound) {
        ExperienceUpperBound = experienceUpperBound;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public List<String> getSkillsList() {
        return SkillsList;
    }

    public void setSkillsList(List<String> skillsList) {
        SkillsList = skillsList;
    }




}
