import java.util.ArrayList;
import java.util.List;

public class VacancyDAO
{
    List<Vacancy> vacancylst;
    String path;
    public VacancyDAO(String path) {
        vacancylst=new ArrayList<>();
        this.path=path;
    }
    public boolean Read()
    {
        //TODO:Parser the CSV File and fillling of the data
     return true;
    }

}
