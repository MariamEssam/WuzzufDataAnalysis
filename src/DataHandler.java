//This class is responsible to handle the data (Manage the parsing and analysing of data)
public class DataHandler {
    DataAnalyzer analyzer;
    VacancyDAO vac_dao;
    public DataHandler() {
        vac_dao=new VacancyDAO("");
    }
}
