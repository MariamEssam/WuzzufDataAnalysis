import java.util.List;

//This class is responsible to handle the data (Manage the parsing and analysing of data)
public class DataHandler {
    DataAnalyzer analyzer;
    VacancyDAO vac_dao;
    public DataHandler(String path) {
        vac_dao=new VacancyDAO(path);
    }
    public boolean Process()
    {
        try
        {
            List<Vacancy> vacancies= vac_dao.Start();
            analyzer=new DataAnalyzer(vacancies);
        }
        catch (Exception e)
        {
           return false;
        }
        return true;
    }
}
