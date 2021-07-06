public class Validator {
    //TODO Perform Validation on string is within the acceptable range of the ascii
static public boolean Validate(String text)
{
    for(int i=0;i<text.length();i++)
        if(text.charAt(i)<32||text.charAt(i)>127)
            return false;

    return true;
}
    //TODO Perform Validation on Year Experience is within the acceptable range of the ascii and contains number
    static public Integer[] ValidateNum(String str)
    {
        Integer start=-1;
        Integer end=-1;
        if(str.contains("null"))
            start=0;
        if(str.contains("+"))
            end= Integer.MAX_VALUE;
        boolean firstfound=false;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)<'0'||str.charAt(i)>'9')
            {
                if(start!=-1) firstfound=true;
                if (end!=-1) break;
            }
            else
            {
                if(!firstfound)
                {
                    if(start==-1) start=0;
                    start=start*10+Character.getNumericValue(str.charAt(i));
                }
                else
                {
                    if(end==-1) end=0;
                    end=end*10+Character.getNumericValue(str.charAt(i));
                }

            }
        }
        if(start==-1) start=0;
        if(end==-1) end=0;
        return new Integer[]{start,end};
    }
}
