package me.alistairallen.pdf;

import java.io.File;
import java.io.IOException;

import com.asprise.util.pdf.PDFReader;

/**
 * @author allena
 */
public class TextExtractorAspireImpl implements TextExtractor
{
  private File mFile;
  private PDFReader mReader;
  private int mPageCount;

  /**
   * @param aFile the file to read
   */
  @Override
  public void setFile(File aFile)
  {
    mFile = aFile;
  }

  @Override
  public void open() throws IOException
  {
    mReader = new PDFReader(mFile);
    mReader.open();
    mPageCount = mReader.getNumberOfPages();
  }

  /**
   * @return the page count
   */
  @Override
  public int getPageCount()
  {
    return mPageCount;
  }

  @Override
  public String getPageAsText(int aPage) throws IOException
  {
    return mReader.extractTextFromPage(aPage);
  }

  @Override
  public void close() throws IOException
  {
    mReader.close();
  }
}