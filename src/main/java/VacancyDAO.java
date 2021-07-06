
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import joinery.DataFrame;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import joinery.DataFrame;
public class VacancyDAO
{
    List<Vacancy> vacancylst;
    String path;
    DataFrame<Object> df;
    public VacancyDAO(String path) {
        vacancylst=new ArrayList<>();
        this.path=path;
    }
    public void Start() throws Exception
    {
        List<String> lines = this.Read();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            if(fields.length!=Constant.TOTAL)
                continue;
            Vacancy vac=ConvertVacancy(fields);
            if(vac==null)
                continue;
            vacancylst.add(vac);
        }
        //Convert Parsed Classess to DataFrame
        df=BeanToJoinery.convert(vacancylst,Vacancy.class);
        df.iterrows().forEachRemaining(System.out::println);
    }
    Vacancy ConvertVacancy(String[] fields)
    {
        //Validate Data
        if(!Validator.Validate(fields[Constant.TITLE].trim())||
                !Validator.Validate(fields[Constant.COMPANY].trim())||
                !Validator.Validate(fields[Constant.LOCATION].trim())||
                !Validator.Validate(fields[Constant.TYPE].trim())||
                !Validator.Validate(fields[Constant.LEVEL].trim())||
                !Validator.Validate(fields[Constant.COUNTRY].trim()))
            return null;
        String[] subfields = fields[Constant.SKILLS].trim().split(",");
        List<String> skilllst=new ArrayList<>();
        for(int i=0;i<subfields.length;i++)
        {
            if(Validator.Validate(subfields[i]))
                skilllst.add(subfields[i]);
        }
       Integer arr[]= Validator.ValidateNum(fields[Constant.YEARS_OF_EXP].trim());
        return new Vacancy(fields[Constant.TITLE],fields[Constant.COMPANY],fields[Constant.LOCATION],
                fields[Constant.TYPE],fields[Constant.LEVEL],arr[0],arr[1],fields[Constant.COUNTRY],skilllst);
    }
    public List<String> Read() throws Exception {
        File vacancyFile= new File(this.path);
        List<String>lines = Files.readAllLines(vacancyFile.toPath());
        return lines;
    }

}
