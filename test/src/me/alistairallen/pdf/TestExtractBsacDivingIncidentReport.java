package me.alistairallen.pdf;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import me.alistairallen.pdf.TextExtractor;
import me.alistairallen.pdf.TextExtractorPdfBoxImpl;

/**
 * @author allena
 */
public class TestExtractBsacDivingIncidentReport
{
  private String mDirectory =
    "test/src/" + getClass().getPackage().getName().replace('.', '/');

  @BeforeClass
  public static void initialise()
  {
    BasicConfigurator.resetConfiguration();
    BasicConfigurator.configure();

    Logger.getRootLogger().setLevel(Level.INFO);
  }

  @Test
  public void parseAllYears() throws IOException
  {
    for (int year = 1998; year <= 2013; year++)
    {
      TextExtractor extractor = new TextExtractorPdfBoxImpl();

      try
      {
        String pdfFilename =
          String.format("BSAC_Diving_Incident_Report_%d.pdf", year);

        String txtFilename =
          String.format("BSAC_Diving_Incident_Report_%d.txt", year);

        extractor.setFile(new File(mDirectory, pdfFilename));
        extractor.open();

        int pageCount = extractor.getPageCount();
        //assertEquals(1, pageCount);

        PrintWriter export = new PrintWriter(new File(mDirectory, txtFilename));
        for (int page = 0; page < pageCount; page++)
        {
          export.println(extractor.getPageAsText(page));
        }

        export.flush();
        export.close();
      }
      finally
      {
        extractor.close();
      }
    }
  }

  @Test
  public void exercise() throws IOException
  {
    for (int year = 1998; year <= 2013; year++)
    {
      TextExtractor extractor = new TextExtractorPdfBoxImpl();

      try
      {
        String pdfFilename =
          String.format("BSAC_Diving_Incident_Report_%d.pdf", year);

        String txtFilename =
          String.format("BSAC_Diving_Incident_Report_%d.txt", year);

        extractor.setFile(new File(mDirectory, pdfFilename));
        extractor.open();

        int pageCount = extractor.getPageCount();
        //assertEquals(1, pageCount);

        PrintWriter export = new PrintWriter(new File(mDirectory, txtFilename));
        for (int page = 0; page < pageCount; page++)
        {
          export.println(extractor.getPageAsText(page));
        }

        export.flush();
        export.close();
      }
      finally
      {
        extractor.close();
      }
    }
  }
}