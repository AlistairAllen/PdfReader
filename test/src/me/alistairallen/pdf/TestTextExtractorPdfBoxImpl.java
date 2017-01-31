package me.alistairallen.pdf;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

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
public class TestTextExtractorPdfBoxImpl
{
  private static final String MULTI_PAGE_PSR = "PSR398571201101051043.pdf";

  private static final String PSR = "PSR379692201108170848.pdf";

  private static final String NEW_METER_DETAILS =
    "ESP New Meter Details  Meter Reconnection, 7585544500, Flat 7, "
    + "Peel Street, Winson Green.30112011-1.pdf";

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
  public void exerciseWithPsr() throws IOException
  {
    TextExtractor extractor = new TextExtractorPdfBoxImpl();

    try
    {
      extractor.setFile(new File(mDirectory, PSR));
      extractor.open();

      int pageCount = extractor.getPageCount();
      assertEquals(2, pageCount);

      for (int page = 0; page < pageCount; page++)
      {
        System.out.println(extractor.getPageAsText(page));
      }
    }
    finally
    {
      extractor.close();
    }
  }

  @Test
  public void exerciseWithMultiPagePsr() throws IOException
  {
    TextExtractor extractor = new TextExtractorPdfBoxImpl();

    try
    {
      extractor.setFile(new File(mDirectory, MULTI_PAGE_PSR));
      extractor.open();

      int pageCount = extractor.getPageCount();
      assertEquals(4, pageCount);

      for (int page = 0; page < pageCount; page++)
      {
        System.out.println(extractor.getPageAsText(page));
      }
    }
    finally
    {
      extractor.close();
    }
  }


  @Test
  public void exerciseWithNewMeterDetails() throws IOException
  {
    TextExtractor extractor = new TextExtractorPdfBoxImpl();

    try
    {
      extractor.setFile(new File(mDirectory, NEW_METER_DETAILS));
      extractor.open();

      int pageCount = extractor.getPageCount();
      assertEquals(1, pageCount);

      for (int page = 0; page < pageCount; page++)
      {
        System.out.println(extractor.getPageAsText(page));
      }
    }
    finally
    {
      extractor.close();
    }
  }
}