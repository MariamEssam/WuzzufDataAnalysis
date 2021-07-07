package com.example.WuzzufDataAnalysisJavaEE;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

//This class is responsible to handle the data (Manage the parsing and analysing of data)
@Named
@RequestScoped
public class DataHandler {
    DataAnalyzer analyzer;
    VacancyDAO vac_dao;
    public DataHandler()
    {
        vac_dao=new VacancyDAO("Resources/Wuzzuf_Jobs.csv");
        Process();
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
    public String ShowSummary()
    {
        return analyzer.ShowSummary();
    }
}
