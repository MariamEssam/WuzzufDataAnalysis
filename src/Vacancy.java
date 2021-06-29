import java.util.ArrayList;
import java.util.List;

public class Vacancy {
String Title;
String Company;
String Location;
String Type;
String Level;
Integer Experience[];
String Country;
List<String> SkillsList;
    public Vacancy(String title, String company, String location,
                   String type, String level,Integer experienceLowerBound,
                   Integer experienceUpperBound
            ,String country, ArrayList<String> skillsList) {
        Title = title;
        Company = company;
        Location = location;
        Type = type;
        Level = level;
        Experience = new Integer[2];
        Experience[0]=experienceLowerBound;
        Experience[1]=experienceUpperBound;
        Country = country;
        SkillsList = skillsList;
    }


}
