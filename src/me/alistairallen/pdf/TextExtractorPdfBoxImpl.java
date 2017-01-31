package me.alistairallen.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import me.alistairallen.pdf.util.IoHelper;

public class TextExtractorPdfBoxImpl implements TextExtractor
{
  private File mFile;
  private PDDocument mDocument;
  private IoHelper mIoHelper = new IoHelper();

  @Override
  public void setFile(File aFile)
  {
    mFile = aFile;
  }

  @Override
  public void open() throws IOException
  {
    mDocument = PDDocument.load(mFile);
  }

  @Override
  public int getPageCount()
  {
    return mDocument.getNumberOfPages();
  }

  @Override
  public String getPageAsText(int aPage) throws IOException
  {
    ByteArrayOutputStream output = null;
    PrintWriter writer = null;

    try
    {
      output = new ByteArrayOutputStream();
      writer = new PrintWriter(output);

      PDFTextStripper stripper = new PDFTextStripper();

      stripper.setStartPage(aPage + 1);
      stripper.setEndPage(aPage + 1);

      stripper.writeText(mDocument, writer);
    }
    finally
    {
      mIoHelper.closeWriter(writer);
      mIoHelper.closeOutputStream(output);
    }

    return output.toString();
  }

  @Override
  public void close() throws IOException
  {
    if (mDocument != null)
    {
      mDocument.close();
    }
  }
}