package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 23.05.2017.
 */
public class HHStrategy implements Strategy
{
  //  private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    private static final String URL_FORMAT = "https://javarush.ru/testdata/big28data.html";
  //private static final String URL_FORMAT ="https://hh.ua";
    // private static final String userAgent = "Mozilla/5.0 (jsoup)";
    private static final String userAgent  = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0";
    private static final String referrer   = "https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2";
    private static final int    timeout    = 5 * 1000;

    @Override
    public List<Vacancy> getVacancies(String searchString)
        {
        List<Vacancy> vacancies = new ArrayList<> ( );
        int           pageNum   = 0;
        Document      document  = null;
    //    while (true)
            {
                document = getDocument ( searchString, pageNum );
             /*   Elements elements = document.getElementsByClass ( "vacancy-serp__vacancy" );
             /*   if (elements.size ( ) == 0)
                    break;
                for (Element element : elements)
                    {
                        if (element != null)
                            {
                                Vacancy vac = new Vacancy ( );
                                vac.setTitle ( element.getElementsByAttributeValue ( "class", "title" ).text ( ) );
                                vac.setCompanyName ( element.getElementsByAttributeValue ( "class", "company_name" ).text ( ) );
                                vac.setSiteName ( URL_FORMAT );
                                vac.setUrl ( "https://moikrug.ru" + element.select ( "a[class=job_icon]" ).attr ( "href" ) );
                                String salary = element.getElementsByAttributeValue ( "class", "salary" ).text ( );
                                String city   = element.getElementsByAttributeValue ( "class", "location" ).text ( );
                                vac.setSalary ( salary.length ( ) == 0 ? "" : salary );
                                vac.setCity ( city.length ( ) == 0 ? "" : city );
                                vacancies.add ( vac );
                            }
                    }*/
                pageNum++;
            }
      //  System.out.println("========================");
        System.out.println (vacancies);
        //System.out.println("========================");
        return vacancies;

        }

    protected  Document getDocument(String searchString, int page)
        {
        Document document = null;
        String url = String.format("%s?text=%s&page=%s",URL_FORMAT, searchString, page);
        try
            {
                document = Jsoup.connect (URL_FORMAT).userAgent ( userAgent ).timeout ( timeout ).referrer ( referrer ).get ( );
               // document.html ( );
                System.out.println (document.html ( ));
            }
        catch (IOException e)
            {
                // e.printStackTrace ( );
                System.out.println ( "no connection" );
            }
        return document;
        }
}
