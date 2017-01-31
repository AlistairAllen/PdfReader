package me.alistairallen.pdf;

import java.io.File;
import java.io.IOException;

public interface TextExtractor
{
  /**
   * @param aFile the file to read
   */
  void setFile(File aFile);

  /**
   * Opens the file and prepares it for reading
   * @throws IOException if there is an IO problem
   */
  public void open() throws IOException;

  /**
   * Closes the file
   * @throws IOException if there is an IO problem
   */
  public void close() throws IOException;

  /**
   * @return the page count
   */
  public int getPageCount();

  /**
   * Extracts the page
   * @param aPage the page number (0..n)
   * @return the page text
   * @throws IOException if there is an IO problem
   */
  public String getPageAsText(int aPage) throws IOException;
}