import java.io.*;
class Dates
{
    static int yn=0,dn=0,N=0;
    static int monn[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    static String mons[] = {"Error","January","February","March","April","May","June","July","August","September","October","November","December"};
    public static void main()throws IOException
    {
        BufferedReader y = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Day Number : ");
        dn = Integer.parseInt(y.readLine());
        System.out.println("Enter Year Number : ");
        yn = Integer.parseInt(y.readLine());
        System.out.println("Enter Days After : ");
        N = Integer.parseInt(y.readLine());
        String coff ="th";
        if(dn<1 || dn>366)
        {System.out.println("Day Number Invalid");System.exit(0); }
        if(yn<1000 || yn>9999)
        {System.out.println("Year Number Invalid");System.exit(0); }
        if(N<1 && N>100)
        {System.out.println("Days After");System.exit(0); }
        if(dncalc(dn)==1)
            coff="st"; 
        if(dncalc(dn)==2)
            coff="nd";
        if(dncalc(dn)==3)
            coff="rd";
        System.out.println("Date : "+dncalc(dn)+coff+" "+mons[moncalc(dn)]+" "+yn);
        dn=dn+N;
        if(yn%4==0)
        {
            if(dn>366)
            {dn=dn-366;yn++;}
        }
        if(yn%4!=0)
        {
            if(dn>365)
            {dn=dn-365;yn++;}
        }
        if(dncalc(dn)==1)
            coff="st"; 
        if(dncalc(dn)==2)
            coff="nd";
        if(dncalc(dn)==3)
            coff="rd";
        System.out.println("Date After : "+dncalc(dn)+coff+" "+mons[moncalc(dn)]+" "+yn);
    }

    static int dncalc(int a)
    {
        int temp=0,dan=0;
        if(yn%4==0)
            monn[2] = 29;
        temp = temp+monn[1];int i;
        for(i=1;i<=12;i++)
        {
            if(a<temp)
            { 
                dan = a-(temp-monn[i]);
                break;
            }
            temp = temp+monn[i+1];
        }
        return dan;
    }

    static int moncalc(int a)
    {
        int mon=0,temp=0;
        if(yn%4==0)
            monn[2] = 29;
        temp = temp+monn[1];int i;
        for(i=1;i<=12;i++)
        {
            if(a<temp)
            {
                mon=i;
                break;
            }
            temp = temp+monn[i+1];
        }
        return mon;
    }
}