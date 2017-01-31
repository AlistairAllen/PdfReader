package me.alistairallen.pdf;

import java.io.File;
import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class TextExtractorITextImpl implements TextExtractor
{
  private File mFile;
  private PdfReader mReader;

  @Override
  public void setFile(File aFile)
  {
    mFile = aFile;
  }

  @Override
  public void open() throws IOException
  {
    mReader = new PdfReader(mFile.getPath());
  }

  @Override
  public int getPageCount()
  {
    return mReader.getNumberOfPages();
  }

  @Override
  public String getPageAsText(int aPage) throws IOException
  {
    return PdfTextExtractor.getTextFromPage(mReader, aPage + 1);
  }

  @Override
  public void close() throws IOException
  {
    mReader.close();
  }
}