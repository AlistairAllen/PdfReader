package me.alistairallen.pdf;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import me.alistairallen.pdf.TextExtractor;
import me.alistairallen.pdf.TextExtractorITextImpl;

/**
 * @author allena
 */
public class TestTextExtractorITextImpl
{
  private static final String PSR = "PSR379692201108170848.pdf";
  private static final String NEW_METER_DETAILS =
    "ESP New Meter Details  Meter Reconnection, 7585544500, Flat 7, "
    + "Peel Street, Winson Green.30112011-1.pdf";

  private String mDirectory =
    "test/src/" + getClass().getPackage().getName().replace('.', '/');

  @Test
  public void exerciseWithPsr() throws IOException
  {
    TextExtractor extractor = new TextExtractorITextImpl();

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
  public void exerciseWithNewMeterDetails() throws IOException
  {
    TextExtractor extractor = new TextExtractorITextImpl();

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