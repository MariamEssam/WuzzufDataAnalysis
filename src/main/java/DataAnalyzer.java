import java.util.List;
//This class is responsible on all the type of analysis that should be done on the data
public class DataAnalyzer {
    List<Vacancy> vacancies;
    //This class should take the parsed data from somewhere else
    public DataAnalyzer(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
}
