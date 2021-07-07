import java.util.*;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.*;


public class XChart {

    public static void PieChartCompany(List<Vacancy> vacancies) {
        Map<String, Long> result = vacancies.stream().collect(
                Collectors.groupingBy(Vacancy::getCompany, Collectors.counting()));
        PieChart chart = new PieChartBuilder().width(800).height(600).title(Vacancy.class.getSimpleName()).build();

        int MaxCount = 5;
        for (int i = 0; i < MaxCount; i++) {
            Long lmax = Long.MIN_VALUE;
            String lcompany = "";

            for (String key : result.keySet()) {

                if (result.get(key) > lmax) {
                    lmax = result.get(key);
                    lcompany = key;
                }

            }

            chart.addSeries(lcompany, result.get(lcompany));
            result.remove(lcompany);


        }
        new SwingWrapper(chart).displayChart();

    }
    public static void  HistogramJobTitle(List<Vacancy> vacancies)
    {
        Map<String, Long> result = vacancies.stream().collect(
                Collectors.groupingBy(Vacancy::getTitle, Collectors.counting()));
        CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Job Histogram").xAxisTitle("Job Title").yAxisTitle("Number of Vacancies").build();

        int MaxCount = 10;
        List<String> titlelst=new ArrayList<>();
        List<Long> countlst=new ArrayList<>();
        for (int i = 0; i < MaxCount; i++) {
            Long lmax = Long.MIN_VALUE;
            String lcompany = "";

            for (String key : result.keySet()) {

                if (result.get(key) > lmax) {
                    lmax = result.get(key);
                    lcompany = key;
                }

            }
           titlelst.add(lcompany);
            countlst.add(lmax);
            result.remove(lcompany);


        }

        chart.addSeries("Title Count",titlelst, countlst);
        new SwingWrapper(chart).displayChart();

    }
    public static void  HistogramJobLocation(List<Vacancy> vacancies)
    {
        Map<String, Long> result = vacancies.stream().collect(
                Collectors.groupingBy(Vacancy::getLocation, Collectors.counting()));
        CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Area Histogram").xAxisTitle("Location").yAxisTitle("Number of Vacancies").build();

        int MaxCount = 10;
        List<String> locationlst=new ArrayList<>();
        List<Long> countlst=new ArrayList<>();
        for (int i = 0; i < MaxCount; i++) {
            Long lmax = Long.MIN_VALUE;
            String lcompany = "";

            for (String key : result.keySet()) {

                if (result.get(key) > lmax) {
                    lmax = result.get(key);
                    lcompany = key;
                }

            }
            locationlst.add(lcompany);
            countlst.add(lmax);
            result.remove(lcompany);


        }

        chart.addSeries("Area Count",locationlst, countlst);
        new SwingWrapper(chart).displayChart();

    }
    public static void  HistogramSkills(List<Vacancy> vacancies)
    {
        Map<String,Long> map=new HashMap<>();
        for(int i=0;i<vacancies.size();i++)
        {
            for(int j=0;j<vacancies.get(i).getSkillsList().size();j++)
            {
                String skill=vacancies.get(i).getSkillsList().get(j);
                if(!map.containsKey(skill))
                    map.put(skill,0l);
                map.put(skill,map.get(skill)+1);
            }
        }
        PriorityQueue<Map.Entry<String, Long>> pq = new PriorityQueue<>(
                (a,b) -> b.getValue().compareTo(a.getValue()));


        for(Map.Entry<String, Long> entry: map.entrySet())
        {
            pq.offer(entry);
        }
        CategoryChart chart = new CategoryChartBuilder().width(1024).height(768).title("Skills Histogram").xAxisTitle("Skill Name").yAxisTitle("Number of Time required").build();

        int MaxCount = 7;
        List<String> skills=new ArrayList<>();
        List<Long> countlst=new ArrayList<>();
        for (int i = 0; i < MaxCount; i++) {
            var val=pq.poll();
            skills.add(val.getKey());
            countlst.add(val.getValue());
        }

        chart.addSeries("Skills Count",skills, countlst);
        new SwingWrapper(chart).displayChart();

    }
}

