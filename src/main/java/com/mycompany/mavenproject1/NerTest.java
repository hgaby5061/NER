package com.mycompany.mavenproject1;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class NerTest {
    public static void main(String[] args) {
        String text = "key dates and impact of upcoming sap implementation over the next few weeks project apollo and beyond will conduct its final sap implementation this implementation will impact approximately new users plus all existing system users sap brings a new dynamic to enron enhancing the timely flow and sharing of specific project human resources procurement and financial information across business units and across continents this final implementation will retire multiple disparate systems and replace them with a common integrated system encompassing many processes including payroll timekeeping benefits project management and numerous financial processes employees will be empowered to update and or view their personal information via the intranet based ehronline a single front end to sap self service functionality and enrons global information system gis among other things individuals will be able to update personal information including addresses and personal banking information manage their individual time using a new time entry tool view their benefit elections and view their personal payroll information on line all enron employees paid out of corporate payroll in houston excluding azurix employees the financial communities of enron energy services enron investment partners enron north america enron renewable energy corporation gas pipeline group global finance global it enron networks and global products the project management communities of enron north america gas pipeline group global finance global it enron networks and global products the human resources communities of corporate global enron energy services enron engineering and construction company enron investment partners enron north america enron renewable energy corporation houston only the international regions gas pipeline group global finance global it enron networks and global products existing sap users currently supported by the center of expertise coe including the london people will be impacted gradually over the next few weeks june current sap users may notice and may use new features in some of the sap modules this new functionality was developed to meet requirements of business units implementing sap as part of this final implementation june  timekeeping functionality will be available for all employees paid out of corporate payroll in houston excluding azurix employees new sap coding must be used on timesheets system ids will be available for all new users june  deadline all time for the period beginning june the and ending june  th must be entered into sap by cst new sap coding must be used for all expenses and invoices july  all remaining functionality project management financials and human resources are available to new end users for more information visit us at an information booth in the enron building lobby on wednesday june  th and thursday june  that till each day visit our intranet site at http sap enron.com for job aids and other useful information contact the site manager coordinating the implementation within your business unit or global function specific site manager contact information can be found on the intranet at http sap enron com contact the center of expertise coe for sap implementation and production support questions via telephone or via email"; // Use the provided text
        String lang = LanguageDetectorJ.languageDetector(text);
        Properties props = NamedEntityRecognitionPropertiesJ.NerProperties(lang);
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        CoreDocument coreDoc = new CoreDocument(text);
        pipeline.annotate(coreDoc);
        List<String> entities = coreDoc.entityMentions().stream()
                .filter(x -> x.text().length() > 1)
                .map(x -> x.text())
                .collect(Collectors.toList());
        List<String> entityTypes = coreDoc.entityMentions().stream()
                .filter(x -> x.text().length() > 1)
                .map(x -> x.entityType())
                .collect(Collectors.toList());
        for(int i=0;i<entities.size();i++)
        System.out.println(entities.get(i)+" --> "+entityTypes.get(i));
        
    }
}
