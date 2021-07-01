import java.io.File;
import java.nio.file.Files;
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
    public void Start() throws Exception
    {
        List<String> lines = this.Read();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            if(fields.length!=Constant.TOTAL)
                continue;
            vacancylst.add(ConvertVacancy(fields));
        }
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
