import joinery.DataFrame;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import java.util.List;
//This class is responsible on all the type of analysis that should be done on the data
public class DataAnalyzer {
    List<Vacancy> vacancies;
    DataFrame<Object> df;
    static SummaryStatistics statistics;

    //This class should take the parsed data from somewhere else
    public DataAnalyzer(List<Vacancy> vacancies)
    {
        this.vacancies = vacancies;
        df=BeanToJoinery.convert(vacancies,Vacancy.class);
        df.iterrows().forEachRemaining(System.out::println);
        statistics = new SummaryStatistics();
        ShowSummary();
        XChart.HistogramSkills(vacancies);
    }
    public String ShowSummary()
    {
        statistics.clear();
        df.col(2).forEach(DataAnalyzer::AddStatistics);
        System.out.println(statistics.getSummary());
        return statistics.getSummary().toString();
    }
    static void AddStatistics(Object obj)
    {
        if(obj==null)
            return;
        statistics.addValue((int)obj);
    }

}
